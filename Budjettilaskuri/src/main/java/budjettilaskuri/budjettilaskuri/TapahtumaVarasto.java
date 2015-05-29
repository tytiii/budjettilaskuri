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

/**Luokka tapahtumien käsittelylle
 *
 * @author mylly
 */
public class TapahtumaVarasto {
    private String nimi;
    private ArrayList<Tapahtuma> tapahtumat;
    
    /**Kostruktori
     * 
     * @param nimi Käyttäjän nimi
     */
    
//    public TapahtumaVarasto(String nimi){
//        this.nimi = nimi.toLowerCase();
//        this.tapahtumat = new ArrayList<Tapahtuma>();
//        this.lataaTapahtumat();
//    }
    
    /** Hakee tietyn kuukauden kaikki tapahtumat
     * 
     * @param kk Haluttu kuukausi muodossa Kuukausi vvvv
     * @return Pyydetyn kuukauden tapahtumat
     */
    
    public ArrayList<Tapahtuma> haeTapahtumaLista(String kk) {
        String[] kuukaudet = new String[]{"Null", "Tammikuu", "Helmikuu", "Maaliskuu", "Huhtikuu", "Toukokuu", "KesÃ¤kuu", "HeinÃ¤kuu", "Elokuu", "Syyskuu", "Lokakuu", "Marraskuu", "Joulukuu"};
        ArrayList<Tapahtuma> paivat = new ArrayList<Tapahtuma>();
        for(Tapahtuma t : this.tapahtumat) {
            String[] splitattupaiva = t.haePaivamaara().split("[.]");
            if(splitattupaiva.length==3) {
                String kuukausi = kuukaudet[Integer.parseInt(splitattupaiva[1])] + splitattupaiva[2];
                if(kuukausi.equals(kk)) {
                    paivat.add(t);
                }
            }
        }
        return paivat;
    }

    /** Palauttaa kayttajan nimen
     * 
     * @return Kayttajan nimi
     */
    
    public String haeNimi() {
        return this.nimi;
    }

    /** Lisaa uuden tapahtuman
     * 
     * @param t Uusi tapahtuma
     */
    
//    public void lisaaTapahtuma(Tapahtuma t){
//        this.tapahtumat.add(t);
//        this.tallennaTapahtumat();
//    }
    
    /** Poistaa tapahtuman
     * 
     * @param t Poistettava tapahtuma
     */
    
//    public void poistaTapahtuma(Tapahtuma t){
//        this.tapahtumat.remove(t);
//        this.tallennaTapahtumat();
//    }
}