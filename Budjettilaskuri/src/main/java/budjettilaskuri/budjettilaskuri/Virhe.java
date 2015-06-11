/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package budjettilaskuri.budjettilaskuri;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 *Virheilmoitus
 * Graafinen osa
 * @author mylly
 */
public class Virhe extends JFrame implements ActionListener  {
    
    /**
     * Kostruktori
     * @param teksti Virheilmoituksen esittama teksti
     */
    
    public Virhe(String teksti) {
        this.setTitle("Virhe!");
        this.setSize(300,120);
        this.setResizable(false);
        this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        JPanel paneeli = new JPanel();
        paneeli.setSize(300,120);
        paneeli.setLayout(null);
        this.add(paneeli);
        JLabel label = new JLabel(teksti);
        label.setAlignmentX(TOP_ALIGNMENT);
        label.setAlignmentY(LEFT_ALIGNMENT);
        label.setLocation(10,10);
        label.setSize(240,50);
        JButton ok = new JButton("OK");
        ok.setLocation(70,70);
        ok.setSize(80,20);
        ok.addActionListener(this);
        paneeli.add(label);
        paneeli.add(ok);
        this.setVisible(true);
    }
    public void actionPerformed(ActionEvent e) {
        this.dispose();
    }
}
