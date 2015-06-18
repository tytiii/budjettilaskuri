/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package budjettilaskuri.kayttoliittyma;

import budjettilaskuri.kayttoliittyma.Logiikka;
import budjettilaskuri.logiikka.Tapahtuma;
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
 * Ohjelman graafinen esitys
 *
 * @author mylly
 */
public class Ohjelma extends JFrame {

    private String[] kategoria;
    private JComboBox uusitapahtuma_kategoria;
    private Logiikka logiikka;
    private JScrollPane tapahtumat;
    private DefaultListModel tapahtumadata;
    private JList tdata;
    private JComboBox kuukaudet, paivat;
    private String[] kk, pv;
    private JTextField uusitapahtuma_nimi, uusitapahtuma_summa, uusitapahtuma_pvm, tuloraja;
    private JButton uusitapahtuma, poistatapahtuma, muokkaa;

    /**
     * Kostruktori
     *
     */
    public Ohjelma() {
        this.kategoria = new String[]{"Ruoka", "Palkka", "Huvi", "Hyöty"};
        this.kk = new String[]{"Tammikuu", "Helmikuu", "Maaliskuu", "Huhtikuu", "Toukokuu", "Kesäkuu", "Heinäkuu", "Elokuu", "Syyskuu", "Lokakuu", "Marraskuu", "Joulukuu"};
        this.pv = new String[]{"1","2","3","4","5","6","7","8","9","10","11","12","13","14","15","16","17","18","19","20","21","22","23","24","25","26","27","28","29","30","31",};
        this.logiikka = new Logiikka(this) {
        };
        this.setTitle("Budjettilaskuri");
        this.setSize(480, 640);
        this.setResizable(true);
        this.setVisible(true);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setLayout(null);
        JPanel pohja = new JPanel();
        pohja.setSize(480, 640);
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

        this.tuloraja = new JTextField();
        this.tuloraja.setSize(100, 30);
        this.tuloraja.setLocation(10, 70);
        pohja.add(this.tuloraja);

        JLabel tulorajateksti = new JLabel("Menoraja");
        tulorajateksti.setLocation(10, 45);
        tulorajateksti.setSize(60, 30);
        pohja.add(tulorajateksti);

        this.kuukaudet = new JComboBox(this.kk);
        this.kuukaudet.setActionCommand("KUUKAUSI");
        this.kuukaudet.addActionListener(logiikka);
        this.kuukaudet.setSize(400, 30);
        this.kuukaudet.setLocation(10, 10);
        pohja.add(this.kuukaudet);

        this.paivat = new JComboBox(this.pv);
        this.paivat.setActionCommand("PAIVA");
        this.paivat.addActionListener(logiikka);
        this.paivat.setSize(400, 30);
        this.paivat.setLocation(10, 110);
        pohja.add(this.paivat);

        this.tapahtumadata = new DefaultListModel();
        tdata = new JList(this.tapahtumadata);
        tapahtumat = new JScrollPane(tdata);

        tapahtumat.setSize(400, 150);
        tapahtumat.setLocation(10, 150);
        pohja.add(tapahtumat);


        this.poistatapahtuma = new JButton("Poista");
        this.poistatapahtuma.setSize(130, 30);
        this.poistatapahtuma.setLocation(160, 320);
        this.poistatapahtuma.setActionCommand("POISTA");
        this.poistatapahtuma.addActionListener(this.logiikka);
        pohja.add(this.poistatapahtuma);

        this.muokkaa = new JButton("Muokkaa");
        this.muokkaa.setSize(130, 30);
        this.muokkaa.setLocation(10, 320);
        this.muokkaa.setActionCommand("MUOKKAA");
        this.muokkaa.addActionListener(this.logiikka);
        pohja.add(this.muokkaa);

        this.uusitapahtuma_nimi = new JTextField();
        JLabel uusit_nimi = new JLabel("Nimi");
        this.uusitapahtuma_nimi.setSize(300, 30);
        this.uusitapahtuma_nimi.setLocation(100, 370);
        pohja.add(this.uusitapahtuma_nimi);

        this.uusitapahtuma_pvm = new JTextField();
        JLabel uusit_paiva = new JLabel("Päivä");
        this.uusitapahtuma_pvm.setSize(80, 30);
        this.uusitapahtuma_pvm.setLocation(10, 370);
        pohja.add(this.uusitapahtuma_pvm);

        this.uusitapahtuma_summa = new JTextField();
        JLabel uusit_summa = new JLabel("Summa");
        this.uusitapahtuma_summa.setSize(80, 30);
        this.uusitapahtuma_summa.setLocation(10, 430);
        pohja.add(this.uusitapahtuma_summa);

        this.uusitapahtuma_kategoria = new JComboBox(this.kategoria);
        this.uusitapahtuma_kategoria.setSize(80, 30);
        this.uusitapahtuma_kategoria.setLocation(110, 430);
        pohja.add(this.uusitapahtuma_kategoria);

        this.uusitapahtuma = new JButton("Lisää uusi");
        this.uusitapahtuma.setActionCommand("LISAA");
        this.uusitapahtuma.addActionListener(logiikka);
        this.uusitapahtuma.setSize(130, 30);
        this.uusitapahtuma.setLocation(310, 430);
        pohja.add(this.uusitapahtuma);

        this.add(pohja);
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                maalaa();
            }
        });
        this.kentatAktivoitu(true);
    }

    /**
     * Muokkaa tietokenttien toimivuutta
     *
     * @param b Haluttu toimivuus
     */
    public void kentatAktivoitu(boolean b) {
        this.uusitapahtuma_kategoria.setEnabled(b);
        this.uusitapahtuma_nimi.setEnabled(b);
        this.uusitapahtuma_pvm.setEnabled(b);
        this.uusitapahtuma_summa.setEnabled(b);
        this.kuukaudet.setEnabled(b);
        this.paivat.setEnabled(b);
        this.tuloraja.setEnabled(b);
        this.uusitapahtuma.setEnabled(b);
        this.poistatapahtuma.setEnabled(b);
        this.muokkaa.setEnabled(b);
    }

    /**
     * Uudelleenpiirtaa nakyman
     */
    private void maalaa() {
        this.repaint();
    }

    /**
     * Muokkaa tietokentista uuden tapahtuman
     *
     * @return Uusi tietokentista keratty tapahtuma
     */
    public Tapahtuma haeUusiTapahtuma() {
        Tapahtuma t = new Tapahtuma();
        try {
            String[] temp = this.uusitapahtuma_pvm.getText().split("[.]");
            if (temp.length != 3) {
                return null;
            }
            int pv = Integer.parseInt(temp[0]);
            int kk = Integer.parseInt(temp[1]);
            int v = Integer.parseInt(temp[2]);
            if (pv < 1 || pv > 31) {
                return null;
            }
            if (kk < 1 || kk > 12) {
                return null;
            }
            if (v < 2000) {
                v = v + 2000;
            }
            String pvm = "" + pv + "." + kk + "." + v;
            double summa = Double.parseDouble(this.uusitapahtuma_summa.getText());
            t.asetaArvo(summa);
            t.asetaLuokittelu(this.kategoria[this.uusitapahtuma_kategoria.getSelectedIndex()]);
            t.asetaPaivamaara(v, kk, pv);
            t.asetaNimi(this.uusitapahtuma_nimi.getText());
        } catch (NumberFormatException nfe) {
            return null;
        }
        return t;
    }

    /**
     * Tayttaa tietokentat annetun tapahtuman tiedoilla
     *
     * @param t Tietokenttiin lisattava tapahtuma
     */
    public void taytaKentat(Tapahtuma t) {
        int indeksi = -1;
        for (int i = 0; i < this.kategoria.length; i++) {
            if (this.kategoria[i].equals(t.haeLuokittelu())) {
                indeksi = i;
            }
        }
        this.uusitapahtuma_kategoria.setSelectedIndex(indeksi);
        this.uusitapahtuma_nimi.setText(t.haeNimi());
        this.uusitapahtuma_pvm.setText(t.haePaivamaara().toString("dd.MM.yyyy"));
        this.uusitapahtuma_summa.setText("" + t.haeArvo());
    }

    /**
     * Tayttaa kuukausilistauksen
     *
     * @param kk Kuukausilistaus
     */
    public void LisaaKuukaudet(String[] kk) {
        this.kuukaudet.removeAllItems();
        this.paivat.removeAllItems();
        this.tapahtumadata.clear();
        for (String k : kk) {
            this.kuukaudet.addItem(k);
        }
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                maalaa();
            }
        });
    }

    /**
     * Tayttaa paivalistauksen
     *
     * @param pv Paivalistaus
     */
    public void LisaaPaivat(String[] pv) {
        this.paivat.removeAllItems();
        this.tapahtumadata.clear();
        for (String p : pv) {
            this.paivat.addItem(p);
        }
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                maalaa();
            }
        });
    }

    /**
     * Tayttaa paivanakyman datan
     *
     * @param data paivan tapahtumat
     */
    public void LisaaData(String[] data) {
        this.tapahtumadata.clear();
        for (String d : data) {
            this.tapahtumadata.addElement(d);

        }
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                maalaa();
            }
        });
    }

    /**
     * Hakee tamanhetkisen kuukauden
     *
     * @return Tamanhetkinen kuukausi
     */
    public String haeKK() {
        return (String) this.kuukaudet.getSelectedItem();
    }

    /**
     * Hakee tamanhetkisen paivan
     *
     * @return Tamanhetkinen paiva
     */
    public String HaePV() {
        return (String) this.paivat.getSelectedItem();
    }

    /**
     * Hakee valitun tapahtuman
     *
     * @return Valitun tapahtuman indeksi
     */
    public int haeValittu() {
        return this.tdata.getSelectedIndex();
    }
}
