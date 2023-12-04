import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import refaktorointi.Pelaaja;

public class PelaajaTest {

    private static Pelaaja testiPelaaja = new Pelaaja();

    @BeforeAll
    static void alusta() {
        testiPelaaja.valitseAsento();
        testiPelaaja.lisaaKierrosvoitto();
    }
    
    @Test
    void asennonTarkistus() {
        String asento = testiPelaaja.getAsentovalinta();
        assertTrue(asento.equals("sakset") || asento.equals("kivi") || asento.equals("paperi"), "Asennonvalinnassa ongelma, pitäisi olla kivi, sakset tai paperi");
    }

    @Test
    void voitonTarkistus() {
        assertEquals(1, testiPelaaja.getKierrosvoitot());
    }

}
