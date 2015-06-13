package budjettilaskuri.logiikka;
import java.util.ArrayList;

/**
 *Kasittelee kayttaja data
 * @author mylly
 */
public class KayttajaVarasto {
    
    private ArrayList<String> kayttajat;
    private String tiedostoNimi = "kayttajat.txt";
    
    /**Konstruktori 
     * 
     */
    
    public KayttajaVarasto() {
        this.kayttajat = TiedostoHallinta.lueRivit(tiedostoNimi);
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
     * @param uusiKayttaja Lisattava kayttajanimi
     * @return Kertoo, onnistuiko lisäys
     */
    
    public boolean lisaaKayttaja (String uusiKayttaja) {
        if (uusiKayttaja == null || uusiKayttaja.length() == 0 || this.kayttajat.contains(uusiKayttaja)) 
            return false;
        else this.kayttajat.add(uusiKayttaja);
        
        return true;
    }
    
    /**
     * Tallentaa käyttäjät tiedostoon
     * @return True, jos tiedoston tallennus onnistui
     */
    public boolean tallennaKayttajat() {
        return TiedostoHallinta.kirjoitaRivit(this.tiedostoNimi, this.kayttajat);
    }
}
