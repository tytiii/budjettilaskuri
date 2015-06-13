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
public class TapahtumaTest {
    
    public TapahtumaTest() {
    }
    
    private static Tapahtuma tapahtuma;
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
       tapahtuma = new Tapahtuma();
    }
    
    @After
    public void tearDown() {
    }

    
    @Test
    public void testAsetaNimi () {
        tapahtuma.asetaNimi(null);
        assertEquals("-", tapahtuma.haeNimi());
        
        tapahtuma.asetaNimi("");
        assertEquals("-", tapahtuma.haeNimi());
        
        tapahtuma.asetaNimi("Testi");
        assertEquals("Testi", tapahtuma.haeNimi());
    }
    
    @Test
    public void testAsetaLuokittelu() {
        tapahtuma.asetaLuokittelu(null);
        assertEquals("-", tapahtuma.haeLuokittelu());
        
        tapahtuma.asetaLuokittelu("");
        assertEquals("-", tapahtuma.haeLuokittelu());
        
        tapahtuma.asetaLuokittelu("Testi");
        assertEquals("Testi", tapahtuma.haeLuokittelu());
    }
    
}