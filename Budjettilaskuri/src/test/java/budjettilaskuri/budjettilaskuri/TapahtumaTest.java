/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package budjettilaskuri.budjettilaskuri;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author mylly
 */
public class TapahtumaTest {
    
    public TapahtumaTest() {
    }
    
    Tapahtuma tapahtuma;
    
    @BeforeClass
    public static void setUpClass() {
       
    }
    
    @Test
    public void asetaArvoasettaaArvonOikein() {
        tapahtuma.asetaArvo(10);
        assertEquals("Tapahtuman arvo on 10 euroa", tapahtuma.toString());
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of asetaArvo method, of class Tapahtuma.
     */
    /**
    @Test
    public void testAsetaArvo() {
        System.out.println("asetaArvo");
        double arvo = 0.0;
        Tapahtuma instance = new Tapahtuma();
        instance.asetaArvo(arvo);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of asetaPaivamaara method, of class Tapahtuma.
     */
    /**
    @Test
    public void testAsetaPaivamaara() {
        System.out.println("asetaPaivamaara");
        String paivamaara = "";
        Tapahtuma instance = new Tapahtuma();
        instance.asetaPaivamaara(paivamaara);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of asetaNimi method, of class Tapahtuma.
     */
    /**
    @Test
    public void testAsetaNimi() {
        System.out.println("asetaNimi");
        String nimi = "";
        Tapahtuma instance = new Tapahtuma();
        instance.asetaNimi(nimi);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of haeArvo method, of class Tapahtuma.
     */
    /**
    @Test
    public void testHaeArvo() {
        System.out.println("haeArvo");
        Tapahtuma instance = new Tapahtuma();
        double expResult = 0.0;
        double result = instance.haeArvo();
        assertEquals(expResult, result, 0.0);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of haePaivamaara method, of class Tapahtuma.
     */
    /**
    @Test
    public void testHaePaivamaara() {
        System.out.println("haePaivamaara");
        Tapahtuma instance = new Tapahtuma();
        String expResult = "";
        String result = instance.haePaivamaara();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of haeNimi method, of class Tapahtuma.
     */
    /**
    @Test
    public void testHaeNimi() {
        System.out.println("haeNimi");
        Tapahtuma instance = new Tapahtuma();
        String expResult = "";
        String result = instance.haeNimi();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of toString method, of class Tapahtuma.
     */
    /**
    @Test
    public void testToString() {
        System.out.println("toString");
        Tapahtuma instance = new Tapahtuma();
        String expResult = "";
        String result = instance.toString();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    */
}