/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package budjettilaskuri.budjettilaskuri;

import java.util.ArrayList;
import junit.framework.TestCase;

/**
 *
 * @author mylly
 */
public class KayttajaTest extends TestCase {
    
    public KayttajaTest(String testName) {
        super(testName);
    }
    
    @Override
    protected void setUp() throws Exception {
        super.setUp();
    }
    
    @Override
    protected void tearDown() throws Exception {
        super.tearDown();
    }

    /**
     * Test of haeKayttajat method, of class Kayttaja.
     */
    public void testHaeKayttajat() {
        System.out.println("haeKayttajat");
        Kayttaja instance = new Kayttaja();
        ArrayList expResult = null;
        ArrayList result = instance.haeKayttajat();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of lisaaKayttaja method, of class Kayttaja.
     */
    public void testLisaaKayttaja() {
        System.out.println("lisaaKayttaja");
        String s = "";
        Kayttaja instance = new Kayttaja();
        boolean expResult = false;
        boolean result = instance.lisaaKayttaja(s);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
}
