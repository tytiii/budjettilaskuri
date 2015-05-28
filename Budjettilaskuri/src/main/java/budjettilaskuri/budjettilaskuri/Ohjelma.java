/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package budjettilaskuri.budjettilaskuri;
import java.awt.Menu;
import java.awt.MenuBar;
import java.awt.MenuItem;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;

/**
 *
 * @author mylly
 */
public class Ohjelma {

    private String[] kategoria;
    private JComboBox uusitapahtuma_kategoria;
    
    public Ohjelma() {
        this.kategoria = new String[] 
            {"Ruoka", "Palkka", "Huvi", "Hyöty"};
        JPanel pohja = new JPanel();
        
        
    }
}
