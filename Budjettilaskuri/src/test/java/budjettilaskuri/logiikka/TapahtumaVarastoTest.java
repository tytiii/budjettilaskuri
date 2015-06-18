/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package budjettilaskuri.logiikka;

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
public class TapahtumaVarastoTest {
    
   private static TapahtumaVarasto tapahtumaVarasto;
   
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp(String kayttaja) {
        tapahtumaVarasto = new TapahtumaVarasto(kayttaja);
    }
    
    @After
    public void tearDown() {
    }
   
    @Test
    public void testHaeTapahtumalista() {
    
    }
}