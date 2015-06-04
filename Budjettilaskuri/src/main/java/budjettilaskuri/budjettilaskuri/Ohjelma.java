/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package budjettilaskuri.budjettilaskuri;
import java.awt.Menu;
import java.awt.MenuBar;
import java.awt.MenuItem;
import java.awt.event.ActionEvent;
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
 *Ohjelman graafinen esitys
 * @author mylly
 */
public class Ohjelma extends JFrame {

    private String[] kategoria;
    private JComboBox uusitapahtuma_kategoria;
    private Logiikka logiikka;
    private JScrollPane tapahtumat;
    private JComboBox kuukaudet, paivat;
    private JTextField uusitapahtuma_nimi, uusitapahtuma_summa, uusitapahtuma_pvm, tuloraja;
    private JButton uusitapahtuma, poistatapahtuma, muokkaa;
    
    /**Kostruktori
     * 
     */
    
    public Ohjelma() {
        this.kategoria = new String[] 
            {"Ruoka", "Palkka", "Huvi", "Hyöty"};
        this.logiikka = new Logiikka(this) {

            @Override
            public void actionPerformed(ActionEvent e) {
                throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
            }
        };
        this.setTitle("Budjettilaskuri");
        this.setSize(480,640);
        this.setResizable(false);
        this.setVisible(true);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setLayout(null);
        JPanel pohja = new JPanel();
        pohja.setSize(480,640);
        pohja.setLayout(null);
        
        MenuBar valikko = new MenuBar();
        Menu menu = new Menu("Menu");
        MenuItem uusi = new MenuItem("Uusi käyttäjä");
        uusi.setActionCommand("UUSI");
        uusi.addActionListener(logiikka);
        MenuItem vaihda = new MenuItem("Vaihda käyttäjää");
        
        vaihda.setActionCommand("VAIHDA");
        vaihda.addActionListener(logiikka);
        menu.add(uusi);
        menu.add(vaihda);
        valikko.add(menu);
        this.setMenuBar(valikko);

        this.kuukaudet = new JComboBox();
        this.kuukaudet.setActionCommand("KUUKAUSI");
        this.kuukaudet.addActionListener(this.logiikka);
        this.kuukaudet.setSize(400, 30);
        this.kuukaudet.setLocation(10,10);
        pohja.add(this.kuukaudet);

        this.tuloraja = new JTextField();
        this.tuloraja.setSize(100,30);
        this.tuloraja.setLocation(10,70);
        
        this.paivat = new JComboBox();
        this.paivat.setActionCommand("PAIVA");
        this.paivat.addActionListener(this.logiikka);
        this.paivat.setSize(400, 30);
        this.paivat.setLocation(10,110);
        pohja.add(this.paivat);

        this.poistatapahtuma = new JButton("Poista");
        this.poistatapahtuma.setSize(130,30);
        this.poistatapahtuma.setLocation(160,320);
        this.poistatapahtuma.setActionCommand("POISTA");
        this.poistatapahtuma.addActionListener(this.logiikka);
        pohja.add(this.poistatapahtuma);

        this.muokkaa = new JButton("Muokkaa");
        this.muokkaa.setSize(130,30);
        this.muokkaa.setLocation(10,320);
        this.muokkaa.setActionCommand("MUOKKAA");
        this.muokkaa.addActionListener(this.logiikka);
        pohja.add(this.muokkaa);

    }
}
