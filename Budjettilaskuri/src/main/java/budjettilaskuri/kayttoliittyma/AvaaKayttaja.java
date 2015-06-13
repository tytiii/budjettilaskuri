/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package budjettilaskuri.kayttoliittyma;
import java.util.ArrayList;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 *Kayttajan vaihdon graafinen osa
 * @author mylly
 */
public class AvaaKayttaja extends JFrame {
        private JComboBox nimet;
        private String[] nimilista;
        
        /**
         * Konstruktori
         * @param o  Viite listeneriin
         * @param nimilista  KÃ¤yttÃ¤jÃ¤lista
         */
        
    public AvaaKayttaja(Logiikka o, ArrayList<String> nimilista) {

        this.nimilista = new String[nimilista.size()];
        for(int i=0;i<nimilista.size();i++) {
            this.nimilista[i] = nimilista.get(i);
        }
        this.setTitle("Vaihda käyttäjää");
        this.setSize(100,120);
        this.setResizable(false);
        this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        JPanel paneeli = new JPanel();
        paneeli.setSize(100,120);
        paneeli.setLayout(null);
        this.add(paneeli);
        JLabel label = new JLabel("Vaihda käyttäjää:");
        label.setLocation(10,10);
        label.setSize(80,20);
        this.nimet = new JComboBox(this.nimilista);
        this.nimet.setLocation(10,30);
        this.nimet.setSize(80,20);
        JButton ok = new JButton("OK");
        ok.setLocation(10,60);
        ok.setSize(80,20);
        ok.setActionCommand("VAIHDAOK");
        ok.addActionListener(o);
        paneeli.add(label);
        paneeli.add(nimet);
        paneeli.add(ok);
        this.setVisible(true);
    }
    
    /**Palauttaa valitun nimen
     * 
     * @return Valittu nimi
     */
    
    public String haenimi() {
        int indeksi = this.nimet.getSelectedIndex();
        if(indeksi<0) return null;
        return this.nimilista[indeksi];
    }

}
