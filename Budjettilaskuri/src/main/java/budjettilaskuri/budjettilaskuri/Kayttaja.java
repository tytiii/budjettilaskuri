/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package budjettilaskuri.budjettilaskuri;
import java.util.ArrayList;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.io.PrintWriter;
/**
 *Kasittelee kayttaja data
 * @author mylly
 */
public class Kayttaja {
    
    private ArrayList<String> kayttajat;
    
    /**Konstruktori 
     * 
     */
    
    public Kayttaja() {
        this.kayttajat = new ArrayList<String>();
        File f = new File("kayttajat.txt");
        if (f.exists()) {
            try {
                Scanner s = new Scanner(f);
                while(s.hasNextLine()) {
                    String kayttaja = s.nextLine();
                    if(kayttaja.length()>1) {
                        this.kayttajat.add(kayttaja);
                    }
                }
            } catch (FileNotFoundException ex){
                
            }
            
        }
    }
    
    /** 
     * Hakee kaikki kayttajat
     * @return Kaikki kayttajat
     */
    
    public ArrayList<String> haeKayttajat() {
        return this.kayttajat;
    }
    
    /** Lisaa kayttajan
     * 
     * @param s Lisattava kayttajanimi
     * @return Kertoo, onnistuiko lisäys
     */
    
    public boolean lisaaKayttaja (String s) {
        if (this.kayttajat.contains(s)) 
            return false;
        else this.kayttajat.add(s);
        File f = new File("kayttajat.txt");
        PrintWriter pr;
        try {
            pr = new PrintWriter(f);
            for (String kayttaja : this.kayttajat) {
                pr.println(kayttaja);
            }
        } catch (FileNotFoundException ex) {
            return false;
        }
        pr.close();
        return true;
    }
}
