package budjettilaskuri.kayttoliittyma;

import budjettilaskuri.kayttoliittyma.Virhe;
import budjettilaskuri.kayttoliittyma.AvaaKayttaja;
import budjettilaskuri.kayttoliittyma.UusiKayttaja;
import budjettilaskuri.logiikka.KayttajaVarasto;
import budjettilaskuri.logiikka.Tapahtuma;
import budjettilaskuri.logiikka.TapahtumaVarasto;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.HashMap;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 * @author mylly
 */
public abstract class Logiikka implements ActionListener {

    private Ohjelma ohjelma;
    private UusiKayttaja uusikayttaja;
    private KayttajaVarasto kayttajat;
    private DecimalFormat muoto;
    private TapahtumaVarasto tapahtumat;
    private AvaaKayttaja ak;

    /**
     * Kostruktori
     *
     * @param o Viite Ohjelmaan
     */
    public Logiikka(Ohjelma o) {
        this.ohjelma = o;
        this.kayttajat = new KayttajaVarasto();
        this.muoto = new DecimalFormat("####.##");
    }
    
    public void actionPerformed(ActionEvent e) {
        String komento = e.getActionCommand();
        if(komento.equals("UUSI")) {
            this.uusikayttaja = new UusiKayttaja(this);
        }
        else if(komento.equals("UUSIOK")) {
            String uusikayttaja = this.uusikayttaja.haenimi();
            if(uusikayttaja.length() < 2) {
                Virhe v = new Virhe("Liian lyhyt kÃ¤yttÃ¤jÃ¤tunnus!");
            }
            else if(this.kayttajat.lisaaKayttaja(uusikayttaja)) {
                this.taytaKuukaudet(uusikayttaja);
            }
            else {
                Virhe v = new Virhe("Käyttäjänimi on jo käytössä!");
            }
            this.uusikayttaja.dispose();

        }
        else if(komento.equals("VAIHDA")) {
            this.ak = new AvaaKayttaja(this, this.kayttajat.haeKayttajat());
        }
        else if(komento.equals("VAIHDAOK")) {
            String nimi = this.ak.haenimi();
            if(nimi!=null) {
                this.taytaKuukaudet(nimi);
                this.ohjelma.kentatAktivoitu(true);
            }
            this.ak.dispose();
        }
        else if(komento.equals("KUUKAUSI")) {
           String kk = this.ohjelma.haeKK();
           if(kk!= null) {
            String[] splitattu = kk.split(" ");
            this.taytaPaivat(Integer.parseInt(splitattu[0]), Integer.parseInt(splitattu[1]));
            }
        }
        else if(komento.equals("PAIVA")) {
          String pv = this.ohjelma.HaePV();
          if(pv!=null) {
           String[] splitattu = pv.split(" ");
           this.taytaPaiva(Integer.parseInt(splitattu[0]), Integer.parseInt(splitattu[1]), Integer.parseInt(splitattu[2]));
          }
        }
        else if(komento.equals("LISAA")) {
            Tapahtuma uusitapahtuma = this.ohjelma.haeUusiTapahtuma();
            if(uusitapahtuma != null) {
                this.tapahtumat.lisaaTapahtuma(uusitapahtuma);
                this.ohjelma.pyyhikentat();
                this.paivita();
            }
        }
        else if(komento.equals("POISTA")) {
            this.poistaTapahtuma();
        }
        else if(komento.equals("MUOKKAA")) {
            this.muokkaa();
        }
    }
    /**
     * Paivittaa tietokentat
     */
    public void paivita() {
        String pv = this.ohjelma.HaePV();
        String kk = this.ohjelma.haeKK();
        this.taytaKuukaudet(this.tapahtumat.haeNimi());
        if(kk!= null) {
            String[] splitattu = kk.split(" ");
            this.taytaPaivat(Integer.parseInt(splitattu[0]), Integer.parseInt(splitattu[1]));
        }
        if(pv!=null) {
            String[] splitattu = pv.split(" ");
            this.taytaPaiva(Integer.parseInt(splitattu[0]), Integer.parseInt(splitattu[1]), Integer.parseInt(splitattu[2]));
        }
    }
    /**
     * Tayttaa kuukausilistan
     * @param kayttaja  Haluttu kayttaja¤
     */
    public void taytaKuukaudet(String kayttaja) {
        this.tapahtumat = new TapahtumaVarasto(kayttaja);
        HashMap<String, Double> kuukaudet = this.tapahtumat.haeKuukaudet();
        String[] kk_data = new String[kuukaudet.size()];
        int i = 0;
        for(String key : kuukaudet.keySet()) {
            kk_data[i] = key + " " + this.muoto.format(kuukaudet.get(key)) + " EUR";
            i++;
        }
        this.ohjelma.LisaaKuukaudet(kk_data);

    }
    /**
     * Tayttaa paivalistauksen
     * @param kk  Haluttu kuukausi
     */
    public void taytaPaivat(int kk, int vuosi) {
        HashMap<String, Double> paivat = this.tapahtumat.HaePaivat(kk, vuosi);
        String[] pv_data = new String[paivat.size()];
        int i = 0;
        for(String key : paivat.keySet()) {
            pv_data[i] = key + " " + this.muoto.format(paivat.get(key)) + " EUR";
            i++;
        }
        this.ohjelma.LisaaPaivat(pv_data);

    }
    /**
     * Asettaa valitun tapahtuman muokkaukseen
     */
    public void muokkaa() {
        String pv = this.ohjelma.HaePV();
        int indeksi = this.ohjelma.haeValittu();
        if(pv != null && indeksi>=0) {
            String[] splitattu = pv.split(" ");
            ArrayList<Tapahtuma> paivat = this.tapahtumat.haePaiva(Integer.parseInt(splitattu[0]), Integer.parseInt(splitattu[1]), Integer.parseInt(splitattu[2]));
            this.ohjelma.taytaKentat(paivat.get(indeksi));
            this.tapahtumat.poistaTapahtuma(paivat.get(indeksi));
            this.paivita();
        } else {
            new Virhe("Päivämäärä väärässä muodossa");
            return;
            
        }
    }
    /**
     * Poistaa valitun tapahtuman
     */
    public void poistaTapahtuma() {
        String pv = this.ohjelma.HaePV();
        int indeksi = this.ohjelma.haeValittu();
        if(pv != null && indeksi>=0) {
            String[] splitattu = pv.split(" ");
            ArrayList<Tapahtuma> paivat = this.tapahtumat.haePaiva(Integer.parseInt(splitattu[0]), Integer.parseInt(splitattu[1]), Integer.parseInt(splitattu[2]));
            this.tapahtumat.poistaTapahtuma(paivat.get(indeksi));
            this.paivita();
        }
    }
    /**
     * Taytta paivan tapahtumat listaukseen
     * @param pv  Valittu paiva
     */
    public void taytaPaiva(int pv, int kk, int vuosi) {
        ArrayList<Tapahtuma> paivat = this.tapahtumat.haePaiva(pv, kk, vuosi);
        String[] pv_data = new String[paivat.size()];
        int i = 0;
        for(Tapahtuma t : paivat) {
            pv_data[i] = t.toString();
            i++;
        }
        this.ohjelma.LisaaData(pv_data);

    }
}
