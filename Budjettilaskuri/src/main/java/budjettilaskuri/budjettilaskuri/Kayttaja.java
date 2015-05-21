/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package budjettilaskuri.budjettilaskuri;
import java.util.ArrayList;
/**
 *Kayttaja data
 * @author mylly
 */
public class Kayttaja {
    
    private ArrayList<String> kayttajat;
    
    public kayttajat() {
        this.kayttajat = new ArrayList<String>();
        
    }
    
    /** Hakee kaikki kayttajat
     * 
     * @return 
     */
    
    public ArrayList<String> haeKayttajat() {
        return this.kayttajat;
    }
    
    public boolean lisaaKayttaja (String kayttaja) {
        if (this.kayttajat.contains(kayttaja)) 
            return false;
        else this.kayttajat.add(kayttaja);
        
    }
}
