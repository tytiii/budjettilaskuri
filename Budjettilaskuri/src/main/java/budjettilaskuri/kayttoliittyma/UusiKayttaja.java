/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package budjettilaskuri.kayttoliittyma;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

/**
 *Kayttajan lisäyksen graafinen osa
 * @author mylly
 */
public class UusiKayttaja extends JFrame{
    private JTextField nimi;
    
    /**Kostruktori
     * @param logiikka Viite Logiikkaan
     */
    
    public UusiKayttaja(Logiikka logiikka) {
        this.setTitle("Luo uusi käyttäjä");
        this.setSize(100,120);
        this.setResizable(false);
        this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        JPanel paneeli = new JPanel();
        paneeli.setSize(100,120);
        paneeli.setLayout(null);
        this.add(paneeli);
        JLabel label = new JLabel("Uusi nimi:");
        label.setLocation(10,10);
        label.setSize(80,20);
        this.nimi = new JTextField();
        this.nimi.setLocation(10,30);
        this.nimi.setSize(80,20);
        JButton ok = new JButton("OK");
        ok.setLocation(10,60);
        ok.setSize(80,20);
        ok.setActionCommand("UUSI OK");
        ok.addActionListener(logiikka);
        paneeli.add(label);
        paneeli.add(nimi);
        paneeli.add(ok);
        this.setVisible(true);
    }
    
    /**Palauttaa uuden nimen
     * @return uusi kayttajatunnus
     */
    public String haenimi() {
        return this.nimi.getText();
    }


}
