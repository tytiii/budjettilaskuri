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
public class KayttajaVarastoTest {
    private static KayttajaVarasto kayttajaVarasto;
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
        kayttajaVarasto = new KayttajaVarasto();
    }
    
    @After
    public void tearDown() {
    }

    @Test
    public void testLisaaKayttaja(){
        assertEquals(0, kayttajaVarasto.haeKayttajat().size());

        boolean lisays = kayttajaVarasto.lisaaKayttaja(null);
        assertEquals(false, lisays);
        assertEquals(0, kayttajaVarasto.haeKayttajat().size());

        lisays = kayttajaVarasto.lisaaKayttaja("");
        assertEquals(false, lisays);
        assertEquals(0, kayttajaVarasto.haeKayttajat().size());

        lisays = kayttajaVarasto.lisaaKayttaja("testi");
        assertEquals(true, lisays);
        assertEquals(1, kayttajaVarasto.haeKayttajat().size());
        
        lisays = kayttajaVarasto.lisaaKayttaja("testi");
        assertEquals(false, lisays);
        assertEquals(1, kayttajaVarasto.haeKayttajat().size());

        lisays = kayttajaVarasto.lisaaKayttaja("uusi");
        assertEquals(true, lisays);
        assertEquals(2, kayttajaVarasto.haeKayttajat().size());

    }
 }