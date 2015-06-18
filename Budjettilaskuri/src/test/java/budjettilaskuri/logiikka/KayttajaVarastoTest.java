package budjettilaskuri.logiikka;

import java.io.File;
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
public class KayttajaVarastoTest {
    private static KayttajaVarasto kayttajaVarasto;
    File test = new File("testi.txt");
    
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
        kayttajaVarasto = new KayttajaVarasto(test);
        
    }
    
    @After
    public void tearDown() {
        
    }

    @Test
    public void testLisaaKayttajaKoko(){
        assertEquals(0, kayttajaVarasto.haeKayttajat().size());
    }
     @Test
    public void testLisaaKayttajaLisaysnull(){
        boolean lisays = kayttajaVarasto.LisaaKayttaja(null, test);
        assertEquals(false, lisays);
        assertEquals(0, kayttajaVarasto.haeKayttajat().size());
     }
      @Test
    public void testLisaaKayttajaTyhjanLisays(){
       boolean lisays = kayttajaVarasto.LisaaKayttaja("", test);
        assertEquals(false, lisays);
        assertEquals(0, kayttajaVarasto.haeKayttajat().size());
      }
       @Test
    public void testLisaaKayttajaUusi(){
        boolean lisays = kayttajaVarasto.LisaaKayttaja("testi", test);
        assertEquals(true, lisays);
        assertEquals(1, kayttajaVarasto.haeKayttajat().size());
        
       }
        @Test
    public void testLisaaKayttajaLisaaSama(){
       boolean lisays = kayttajaVarasto.LisaaKayttaja("testi", test);
        assertEquals(false, lisays);
        assertEquals(1, kayttajaVarasto.haeKayttajat().size());
        }
         @Test
    public void testLisaaKayttajaLisaaToinen(){
        boolean lisays = kayttajaVarasto.LisaaKayttaja("uusi", test);
        assertEquals(true, lisays);
        assertEquals(2, kayttajaVarasto.haeKayttajat().size());

    }
 }