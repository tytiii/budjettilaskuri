/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package budjettilaskuri.budjettilaskuri;

import java.util.ArrayList;
import java.io.File;
import java.util.Scanner;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.FileOutputStream;
import java.io.PrintWriter;
import java.util.HashMap;

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
     * @param nimi Käyttäjän nimi
     */
    public TapahtumaVarasto(String nimi) {
        this.nimi = nimi.toLowerCase();
        this.tapahtumat = new ArrayList<Tapahtuma>();
        this.lataaTapahtumat();
    }

    /**
     * Hakee tietyn kuukauden kaikki tapahtumat
     *
     * @param kk Haluttu kuukausi muodossa Kuukausi vvvv
     * @return Pyydetyn kuukauden tapahtumat
     */
    public ArrayList<Tapahtuma> haeTapahtumaLista(String kk) {
        String[] kuukaudet = new String[]{"Null", "Tammikuu", "Helmikuu", "Maaliskuu", "Huhtikuu", "Toukokuu", "Kesäkuu", "Heinäkuu", "Elokuu", "Syyskuu", "Lokakuu", "Marraskuu", "Joulukuu"};
        ArrayList<Tapahtuma> paivat = new ArrayList<Tapahtuma>();
        for (Tapahtuma t : this.tapahtumat) {
            String[] splitattupaiva = t.haePaivamaara().split("[.]");
            if (splitattupaiva.length == 3) {
                String kuukausi = kuukaudet[Integer.parseInt(splitattupaiva[1])] + splitattupaiva[2];
                if (kuukausi.equals(kk)) {
                    paivat.add(t);
                }
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
        String[] kuukaudet = new String[]{"Null", "Tammikuu", "Helmikuu", "Maaliskuu", "Huhtikuu", "Toukokuu", "Kesäkuu", "Heinäkuu", "Elokuu", "Syyskuu", "Lokakuu", "Marraskuu", "Joulukuu"};
        HashMap<String, Double> kk = new HashMap<String, Double>();
        for (Tapahtuma t : this.tapahtumat) {
            String[] splitattu = t.haePaivamaara().split("[.]");
            if (splitattu.length == 3) {
                String pvm = kuukaudet[Integer.parseInt(splitattu[1])] + " " + splitattu[2];
                if (!kk.containsKey(pvm)) {
                    kk.put(pvm, 0.0);
                }
                kk.put(pvm, kk.get(pvm) + t.haeArvo());
            }
        }
        return kk;
    }

    /**
     * Hakee kaikki tietyn kuukauden paivat
     *
     * @param kk Haluttu kuukausi, muodossa Kuukausi VVVV
     * @return Halutun kuukauden kaikki paivat ja niiden saldot
     */
    public HashMap<String, Double> HaePaivat(String kk) {
        String[] kuukaudet = new String[]{"Null", "Tammikuu", "Helmikuu", "Maaliskuu", "Huhtikuu", "Toukokuu", "Kesäkuu", "Heinäkuu", "Elokuu", "Syyskuu", "Lokakuu", "Marraskuu", "Joulukuu"};
        HashMap<String, Double> paivat = new HashMap<String, Double>();
        for (Tapahtuma t : this.tapahtumat) {
            String[] splitattupaiva = t.haePaivamaara().split("[.]");
            if (splitattupaiva.length == 3) {
                String kuukausi = kuukaudet[Integer.parseInt(splitattupaiva[1])] + " " + splitattupaiva[2];
                if (kuukausi.equals(kk)) {
                    String paiva = splitattupaiva[0] + ". " + kuukaudet[Integer.parseInt(splitattupaiva[1])] + "ta " + splitattupaiva[2];
                    if (!paivat.containsKey(paiva)) {
                        paivat.put(paiva, 0.0);
                    }
                    paivat.put(paiva, paivat.get(paiva) + t.haeArvo());
                }
            }
        }
        return paivat;

    }

    /**
     * Hakee tietyn paivan kaikki tapahtumat
     *
     * @param pvm Haluttu paivamaara muodossa PV. Kuukausita VVVV
     * @return Halutun paivan tapahtumat
     */
    public ArrayList<Tapahtuma> haePaiva(String pvm) {
        String[] kuukaudet = new String[]{"Null", "Tammikuu", "Helmikuu", "Maaliskuu", "Huhtikuu", "Toukokuu", "Kesäkuu", "Heinäkuu", "Elokuu", "Syyskuu", "Lokakuu", "Marraskuu", "Joulukuu"};
        ArrayList<Tapahtuma> paivat = new ArrayList<Tapahtuma>();
        for (Tapahtuma t : this.tapahtumat) {
            String[] splitattupaiva = t.haePaivamaara().split("[.]");
            if (splitattupaiva.length == 3) {
                String paiva = splitattupaiva[0] + ". " + kuukaudet[Integer.parseInt(splitattupaiva[1])] + "ta " + splitattupaiva[2];
                if (pvm.equals(paiva)) {
                    paivat.add(t);
                }
            }
        }
        return paivat;

    }

    /**
     * Lataa tapahtumat tiedostosta
     */
    public void lataaTapahtumat() {
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
                Tapahtuma t = new Tapahtuma();
                t.asetaArvo(Double.parseDouble(data[0]));
                t.asetaPaivamaara(data[1]);
                t.asetaLuokittelu(data[2]);
                t.asetaNimi(data[3]);
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
        FileOutputStream fos = null;
        try {
            fos = new FileOutputStream(this.nimi + ".dat");
            PrintWriter pw = new PrintWriter(fos);
            for (Tapahtuma t : tapahtumat) {
                pw.println(t.haeArvo() + "|" + t.haePaivamaara() + "|" + t.haeLuokittelu() + "|" + t.haeNimi());
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