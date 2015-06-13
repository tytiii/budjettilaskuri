    /*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package budjettilaskuri.logiikka;

import java.text.DecimalFormat;
import org.joda.time.DateTime;

/**
 * Luokka Budjettilaskurin tapahtumille
 *
 * @author mylly
 */
public class Tapahtuma {

    private double arvo;
    private DateTime paivamaara;
    private String nimi;
    private String luokittelu;

    public Tapahtuma() {
        this.arvo = 0.0;
        this.paivamaara = new DateTime();
        this.nimi = "-";
        this.luokittelu = "-";
    }
    
    /**
     * Konstruktori
     *
     */
    public Tapahtuma(double arvo, DateTime paivamaara, String nimi, String luokittelu) {
        this.arvo = arvo;
        this.paivamaara = paivamaara;
        this.nimi = nimi;
        this.luokittelu = luokittelu;
    }

    /**
     * Asettaa tapahtuman arvon
     *
     * @param arvo Asetettava arvo
     */
    public void asetaArvo(double arvo) {
        this.arvo = arvo;
    }

    /**
     * Asettaa tapahtumalle paivamaaran
     *
     * @param paivamaara Paivamaara asetetaan muodossa "pp.kk.vvvv"
     */
    public void asetaPaivamaara(int vuosi, int kuukausi, int paiva) {
        this.paivamaara = new DateTime(vuosi, kuukausi+1, paiva, 0, 0);
    }

    /**
     * Asettaa nimen tapahtumalle
     *
     * @param nimi Tapahtuman nimi
     */
    /**
     * Asettaa luokituksen
     *
     * @param luokittelu Tapahtuman luokitus
     */
    public void asetaLuokittelu(String luokittelu) {
        this.luokittelu = luokittelu;
        if (luokittelu == null || luokittelu.length() == 0) {
            this.luokittelu = "-";
        }

    }

    public void asetaNimi(String nimi) {
        this.nimi = nimi;
        if (nimi == null || nimi.length() == 0) {
            this.nimi = "-";
        }
    }

    /**
     * Hakee tapahtuman arvon
     *
     * @return Tapahtuman arvo
     */
    public double haeArvo() {
        return this.arvo;
    }

    /**
     * Hakee tapahtuman paivamaaran
     *
     * @return Tapahtuman paivamaara
     */
    public DateTime haePaivamaara() {
        return this.paivamaara;
    }

    /**
     * Hakee luokittelun
     *
     * @return Tapahtuman luokittelu
     */
    public String haeLuokittelu() {
        return this.luokittelu;
    }

    /**
     * Hakee tapahtuman nimen
     *
     * @return Tapahtuman nimi
     */
    public String haeNimi() {
        return this.nimi;
    }

    @Override
    public String toString() {
        DecimalFormat tulostus = new DecimalFormat("####.##");

        return (this.nimi + " " + tulostus.format(this.arvo) + "euroa ");
    }
}
