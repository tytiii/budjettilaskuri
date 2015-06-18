package budjettilaskuri.logiikka;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;

/**
 *Kasittelee kayttaja data
 * @author mylly
 */
public class KayttajaVarasto {
    
    private ArrayList<String> kayttajat;
    
    
       public KayttajaVarasto(File f) {
        this.kayttajat = new ArrayList<String>();
        f = new File("kayttajat.txt");
        if (f == null || f.length() == 0){
            return;
        }
            
        if(f.exists()) {
            try {
                Scanner s = new Scanner(f);
                while(s.hasNextLine()) {
                    String kayttaja = s.nextLine();
                    if(kayttaja.length()>0) {
                        this.kayttajat.add(kayttaja);
                    }
                }

            } catch (FileNotFoundException ex) {
            }
        }
    }
    /**
     * Hakee kaikki käyttäjät
     * @return  Kaikki käyttäjät
     */
    public ArrayList<String> haeKayttajat() {
        return this.kayttajat;
    }
    /**
     * Lisää käyttäjän
     * @param s  Lisättävä käyttäjänimi
     * @return  Kertoo, onnistuiko lisäys
     */
    
    public boolean LisaaKayttaja(String s, File f) {
        f = new File("kayttajat.txt");
        if(s == null || s.length() == 0 || this.kayttajat.contains(s)) return false;
        else this.kayttajat.add(s);
        PrintWriter pr;
        try {
            pr = new PrintWriter(f);
            for(String kayttaja : this.kayttajat) {
                pr.println(kayttaja);
            }
        } catch (FileNotFoundException ex) {
            return false;
        }
    pr.close();
    return true;
    }

}
