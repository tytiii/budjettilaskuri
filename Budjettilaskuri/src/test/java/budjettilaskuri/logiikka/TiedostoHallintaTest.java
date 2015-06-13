package budjettilaskuri.logiikka;

import java.util.ArrayList;
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
public class TiedostoHallintaTest {
    private String tiedostoNimi = "testi.txt";
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
        // TODO: poista testitiedosto
    }

     @Test
     public void testTiedostonKirjoitusJaLuku() {
         ArrayList<String> testidata = new ArrayList<>();
         testidata.add("2");
         testidata.add("34634");
         testidata.add("sgsg");
         
         boolean tulos = TiedostoHallinta.kirjoitaRivit(tiedostoNimi, testidata);
         
         assertEquals(true, tulos);
         ArrayList<String> rivit = TiedostoHallinta.lueRivit(tiedostoNimi);
         
         assertArrayEquals(testidata.toArray(), rivit.toArray());
     }
}