/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package budjettilaskuri.logiikka;

import budjettilaskuri.kayttoliittyma.Virhe;
import java.util.ArrayList;
import java.io.File;
import java.util.Scanner;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.FileOutputStream;
import java.io.PrintWriter;
import java.util.HashMap;
import org.joda.time.DateTime;

/**
 * Luokka tapahtumien käsittelylle
 *
 * @author mylly
 */
public class TapahtumaVarasto {

    private String nimi;
    private ArrayList<Tapahtuma> tapahtumat;

    /**
     * Kostruktori
     *
     * @param kayttaja Käyttäjän nimi
     */
    public TapahtumaVarasto(String kayttaja) {
        this.nimi = kayttaja.toLowerCase();
        this.tapahtumat = new ArrayList<>();
        this.lataaTapahtumat();
    }

    /**
     * Hakee tietyn kuukauden kaikki tapahtumat
     *
     * @param kk Haluttu kuukausi muodossa Kuukausi vvvv
     * @return Pyydetyn kuukauden tapahtumat
     */
    public ArrayList<Tapahtuma> haeTapahtumaLista(int kk, int vuosi) {
        // TODO: test
        ArrayList<Tapahtuma> paivat = new ArrayList<Tapahtuma>();
        for (Tapahtuma t : this.tapahtumat) {
            DateTime paiva = t.haePaivamaara();
            if (paiva.getYear() == vuosi && paiva.getMonthOfYear() == kk + 1) {
                paivat.add(t);
            }
        }
        return paivat;
    }

    /**
     * Palauttaa kayttajan nimen
     *
     * @return Kayttajan nimi
     */
    public String haeNimi() {
        return this.nimi;
    }

    /**
     * Lisaa uuden tapahtuman
     *
     * @param t Uusi tapahtuma
     */
    public void lisaaTapahtuma(Tapahtuma t) {
        // TODO: tarkista että ei null ja ei samoja ja testit
        this.tapahtumat.add(t);
        this.tallennaTapahtumat();
    }

    /**
     * Poistaa tapahtuman
     *
     * @param t Poistettava tapahtuma
     */
    public void poistaTapahtuma(Tapahtuma t) {
        this.tapahtumat.remove(t);
        this.tallennaTapahtumat();
    }

    /**
     * Hakee kaikki kuukaudet, jolloin on ollut tapahtumia
     *
     * @return Kuukaudet ja niiden saldo, kuukausi muodossa Kuukausi VVVV
     */
    public HashMap<String, Double> haeKuukaudet() {
        // TODO: test
        HashMap<String, Double> kk = new HashMap<>();
        for (Tapahtuma t : this.tapahtumat) {
            String pvm = t.haePaivamaara().toString("MM.yyyy");
            if (!kk.containsKey(pvm)) {
                kk.put(pvm, 0.0);
            }
            kk.put(pvm, kk.get(pvm) + t.haeArvo());
        }
        return kk;
    }

    /**
     * Hakee kaikki tietyn kuukauden paivat
     *
     * @param kk Haluttu kuukausi, muodossa Kuukausi VVVV
     * @return Halutun kuukauden kaikki paivat ja niiden saldot
     */
    public HashMap<String, Double> HaePaivat(int kk, int vuosi) {
        // TODO: test
        HashMap<String, Double> paivat = new HashMap<>();
        for (Tapahtuma t : this.tapahtumat) {
            DateTime paivamaara = t.haePaivamaara();
            if (kk != paivamaara.getMonthOfYear() + 1 || vuosi != paivamaara.getYear()) {
                continue;
            }
            String paiva = paivamaara.toString("dd.MM.yyyy");
            if (!paivat.containsKey(paiva)) {
                paivat.put(paiva, 0.0);
            }
            paivat.put(paiva, paivat.get(paiva) + t.haeArvo());
        }
        return paivat;

    }

    /**
     * Hakee tietyn paivan kaikki tapahtumat
     *
     * @param pvm Haluttu paivamaara muodossa PV. Kuukausita VVVV
     * @return Halutun paivan tapahtumat
     */
    public ArrayList<Tapahtuma> haePaiva(int paiva, int kk, int vuosi) {
        // TODO: test
        ArrayList<Tapahtuma> paivat = new ArrayList<>();
        for (Tapahtuma t : this.tapahtumat) {
            DateTime paivamaara = t.haePaivamaara();
            if (vuosi == paivamaara.getYear() && kk == paivamaara.getMonthOfYear() + 1 && paiva == paivamaara.getDayOfMonth()) {
                paivat.add(t);   
            }
        }
        return paivat;

    }

    /**
     * Lataa tapahtumat tiedostosta
     */
    public void lataaTapahtumat() {
        // TODO: käytä TiedostonHallintaa rivien lukemiseen
        this.tapahtumat.clear();
        Scanner s = null;
        File f = new File(this.nimi + ".dat");
        if (!f.exists()) {
            return;
        }
        try {
            s = new Scanner(f);
            while (s.hasNextLine()) {
                String rivi = s.nextLine();
                String[] data = rivi.split("[|]");
                Tapahtuma t = new Tapahtuma(Double.parseDouble(data[0]), new DateTime(data[1]), data[2], data[3]);
                this.tapahtumat.add(t);

            }
        } catch (FileNotFoundException ex) {
            new Virhe("Tiedostoa " + this.nimi + ".dat ei lÃ¶ydy!");
        } catch (IOException e) {
            new Virhe("Tiedosto " + this.nimi + " on kirjoitussuojattu!");
        }
        s.close();
    }

    /**
     * Tallentaa tapahtumat tiedostoon
     */
    public void tallennaTapahtumat() {
        // TODO: käytä TiedostonHallintaa kirjoittamiseen
        FileOutputStream fos = null;
        try {
            fos = new FileOutputStream(this.nimi + ".dat");
            PrintWriter pw = new PrintWriter(fos);
            for (Tapahtuma t : tapahtumat) {
                // Tallenna nämä listaan, ja anna TiedostonHallinnalle
                pw.println(t.haeArvo() + "|" + t.haePaivamaara().toString() + "|" + t.haeLuokittelu() + "|" + t.haeNimi());
            }
            pw.close();
        } catch (FileNotFoundException ex) {
            new Virhe("Tiedostoa " + this.nimi + ".dat ei lÃ¶ydy!");

        } catch (IOException ex) {
            new Virhe("Tiedosto " + this.nimi + " on kirjoitussuojattu!");
        } finally {
            try {
                fos.close();
            } catch (IOException ex) {
                new Virhe("Tiedosto " + this.nimi + " on kirjoitussuojattu!");

            }
        }

    }
}