import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

import refaktorointi.Pelaaja;
import refaktorointi.Peli;

public class PeliTest {

    Peli testiPeli = new Peli();
    Pelaaja testiPelaaja1 = new Pelaaja();
    Pelaaja testiPelaaja2 = new Pelaaja();
    int pelikierros = 3;
    int tasapelit = 2;
    
    @Test
    void pelikierrostesti() {
        Peli.pelaaKierros(testiPelaaja1, testiPelaaja2);
        assertTrue(testiPelaaja1.getKierrosvoitot() == 1 || testiPelaaja2.getKierrosvoitot() == 1);
    }

    @Test
    void tasapeliTest() {
        while (testiPelaaja1.getAsentovalinta() != "sakset") {
            testiPelaaja1.valitseAsento();
        }
        while (testiPelaaja2.getAsentovalinta() != "sakset") {
            testiPelaaja2.valitseAsento();
        }
        assertEquals(testiPelaaja2.getAsentovalinta(), testiPelaaja1.getAsentovalinta());
    }
}
