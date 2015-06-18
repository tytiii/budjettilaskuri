/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package budjettilaskuri.logiikka;

import budjettilaskuri.kayttoliittyma.Virhe;
import java.util.ArrayList;
import java.io.File;
import java.io.FileInputStream;
import java.util.Scanner;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
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
    public void lisaaTapahtuma(Tapahtuma uusitapahtuma) {
        // TODO: tarkista että ei null ja ei samoja ja testit
        if (uusitapahtuma == null) {
        }
        else {
        this.tapahtumat.add(uusitapahtuma);
        this.tallennaTapahtumat();
        }
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
     * Lataa tapahtumat tiedostosta
     */
    public void lataaTapahtumat() {
        this.tapahtumat.clear();
        Scanner s = null;
        File f = new File(this.nimi + ".txt");
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
            new Virhe("Tiedostoa " + this.nimi + ".txt ei löydy!");
        }
        s.close();
    }

    /**
     * Tallentaa tapahtumat tiedostoon
     */
    public void tallennaTapahtumat()  {
        FileOutputStream fos = null;
        try {
            fos = new FileOutputStream(this.nimi + ".dat");
            
            PrintWriter pw = new PrintWriter(fos);
            for (Tapahtuma t : tapahtumat) {
                pw.println(t.haeArvo() + "|" + t.haePaivamaara().toString() + "|" + t.haeLuokittelu() + "|" + t.haeNimi());
            }
            pw.close();
       } catch (FileNotFoundException ex) {
            new Virhe("Tiedostoa " + this.nimi + ".dat ei löydy!");

        }
    }
      /**
     * Hakee tietyn paivan kaikki tapahtumat
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
    
    
}