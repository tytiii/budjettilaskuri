/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package budjettilaskuri.budjettilaskuri;
import java.text.DecimalFormat;

/**
 *  Luokka Budjettilaskurin tapahtumille
 * @author mylly
 */
public class Tapahtuma {
    
    private double arvo;
    private String paivamaara;
    private String nimi;
    
    /**Konstruktori
     * 
     */      
    public Tapahtuma(){
        this.arvo = 0;
        this.paivamaara = "-";
        this.nimi = "-";
    }
    
    /** Asettaa tapahtuman arvon
     * 
     * @param arvo Asetettava arvo
     */
    
    public void asetaArvo(double arvo) {
        this.arvo = arvo;
    }
    
    /** Asettaa tapahtumalle paivamaaran
     *
     * @param paivamaara  Paivamaara asetetaan muodossa "dd.mm.yyyy"
     */
    
    public void asetaPaivamaara (String paivamaara) {
        this.paivamaara = paivamaara;
    }
    
    /** Asettaa nimen tapahtumalle
     * 
     * @param nimi Tapahtuman nimi
     */
    
    public void asetaNimi(String nimi) {
        this.nimi = nimi;
        if(nimi.length() == 0) this.nimi = "-";
    }
    
    /** Hakee tapahtuman arvon
     * 
     * @return Tapahtuman arvo
     */
    
    public double haeArvo() {
        return this.arvo;
    }
    
    /** Hakee tapahtuman paivamaaran
     * 
     * @return Tapahtuman paivamaara
     */
    
    public String haePaivamaara() {
        return this.paivamaara;
    }
    
    /** Hakee tapahtuman nimen
     * 
     * @return Tapahtuman nimi
     */
    
    public String haeNimi() {
        return this.nimi;
    }
    
    public String toString() {
        DecimalFormat tulostus = new DecimalFormat("####.##");
        
        return (this.nimi + " " + tulostus.format(this.arvo) + "euroa ");
    }
}
