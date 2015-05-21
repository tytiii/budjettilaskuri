/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package budjettilaskuri.budjettilaskuri;

/**
 *  
 * @author mylly
 */
public class Tapahtuma {
    
    private double arvo;
    private String paivamaara;
    private String nimi;
    
          
    public Tapahtuma(){
        this.arvo = 0;
        this.paivamaara = "-";
        this.nimi = "-";
    }
    
    /** Asettaa tapahtuman arvo
     * 
     * @param arvo 
     */
    
    public void asetaArvo(double arvo) {
        this.arvo = arvo;
    }
    
    /** Asettaa tapahtumalle paivamaaran
     * Paivamaara asetetaan muodossa "dd.mm.yyyy"
     * @param paivamaara 
     */
    
    public void asetaPaivamaara (String paivamaara) {
        this.paivamaara = paivamaara;
    }
    
    /** Asettaa nimen tapahtumalle
     * 
     * @param nimi 
     */
    
    public void asetaNimi(String nimi) {
        this.nimi = nimi;
        if(nimi.length() == 0) this.nimi = "-";
    }
    
    public double ()
}
