package budjettilaskuri.budjettilaskuri;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.HashMap;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 * @author mylly
 */
public abstract class Logiikka implements ActionListener {

    private Ohjelma ohjelma;
    private UusiKayttaja uusikayttaja;
    private Kayttaja kayttajat;
    private DecimalFormat muoto;
    private TapahtumaVarasto tapahtumat;
    private AvaaKayttaja ak;

    /**
     * Kostruktori
     *
     * @param o Viite Ohjelmaan
     */
    public Logiikka(Ohjelma o) {
        this.ohjelma = o;
        this.kayttajat = new Kayttaja();
        this.muoto = new DecimalFormat("####.##");
    }
}
