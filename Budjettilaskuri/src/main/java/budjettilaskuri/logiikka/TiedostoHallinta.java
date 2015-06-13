/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package budjettilaskuri.logiikka;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * Luokka, joka osaa lukea ja kirjottaa tiedostoja
 * @author mylly
 */
public class TiedostoHallinta {
    
    /**
     * Lukee tiedoston rivit ja palauttaa ne listana
     * @param tiedostoNimi Tiedoston nimi
     * @return Tiedoston rivit listana
     */
    public static ArrayList<String> lueRivit(String tiedostoNimi) {
        ArrayList<String> tulos = new ArrayList<>();
        if (tiedostoNimi == null || tiedostoNimi.length() == 0) {
            return tulos;
        }
        
        File f = new File(tiedostoNimi);
        if (f.exists()) {
            try {
                Scanner s = new Scanner(f);
                while(s.hasNextLine()) {
                    String rivi = s.nextLine();
                    if(rivi.length() > 0) {
                        tulos.add(rivi);
                    }
                }
            } catch (FileNotFoundException ex){
                System.out.println("Virhe tiedoston lukemisessa");
                return tulos;
            }
        }

        return tulos;
    }

    public static boolean kirjoitaRivit(String tiedostoNimi, ArrayList<String> rivit) {
        File f = new File(tiedostoNimi);
        PrintWriter pr = null;
        try {
            pr = new PrintWriter(f);
            for (String rivi : rivit) {
                pr.println(rivi);
            }
        } catch (FileNotFoundException ex) {
            if (pr != null) {
                pr.close();
                pr = null;
            }
            return false;
        } finally {
            if (pr != null) {
                pr.close();
            }
        }
        return true;
    }
}
