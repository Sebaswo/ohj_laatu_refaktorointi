package refaktorointi;

/**
 *
 * @author Ira Dook
 */
public class Peli {

    public static void main(String args[]) {

        Pelaaja pelaaja1 = new Pelaaja();
        Pelaaja pelaaja2 = new Pelaaja();

        boolean peliLoppui = false;     // Peli loppuu, kun arvo on true

        int halututKierrokset = 3;      // Montako kierrosta pelataan
        int pelatutPelit = 0;           // Pelattujen pelien lkm
        int tasapelit = 0;              // Tasapelien lkm
       
        do {

            tulostaPelitilanne(pelaaja1, pelaaja2, pelatutPelit, tasapelit);

            pelaaja1.valitseAsento();
            pelaaja2.valitseAsento();

            if (tarkistaTasapeli(pelaaja1, pelaaja2)) {
                tasapelit++;
                System.out.println("TASAPELI!\n\n");
            } else {
                pelaaKierros(pelaaja1, pelaaja2);
            }

            pelatutPelit++;

            peliLoppui = (pelaaja1.getKierrosvoitot() >= halututKierrokset || pelaaja2.getKierrosvoitot() >= halututKierrokset) ? true : false;

        } while (peliLoppui != true);

        System.out.println("KOLME VOITTOA - PELI PÄÄTTYY");
    }

    /**
     * Tulostaa konsoliin pelin tilannetietoja: kierrosnumeron, tasapeli maaran ja kummankin pelaajan pistesaldot.
     * 
     * @param pelaaja1 ensimmainen peliin osallistuva Pelaaja-luokan ilmentyma.
     * 
     * @param pelaaja2 toinen peliin osallistuva Pelaaja-luokan ilmentyma.
     * 
     * @param kierrosnumero kokonaisluku, joka kertoo milla pelikierroksella mennaan. Pelikierros on yhden jaljessa
     *                      joten siihen lisataan yksi ennen tulostamista.
     * 
     * @param tasapelit kokonaisluku, joka kertoo montako tasapelia pelaajat ovat pelanneet.
     * 
     */
    public static void tulostaPelitilanne(Pelaaja pelaaja1, Pelaaja pelaaja2, int kierrosnumero, int tasapelit) {
        System.out.println("Erä: " + ++kierrosnumero + " =====================\n");
        System.out.println("Tasapelien lukumäärä: "+ tasapelit + "\n");
        System.out.println("Pelaajalla 1 koossa " + pelaaja1.getKierrosvoitot() + " voittoa.");
        System.out.println("Pelaajalla 2 koossa " + pelaaja2.getKierrosvoitot() + " voittoa.\n");
    }

    /**
     * Pelataan yksi kierros kivi-paperi-sakset-pelia. Verrataan pelaajien arpomia asentoja (kivi, paperi, sakset) ja niiden  mukaan
     * paatetaan, kumpi voitti. Voittajan kierrosvoitot-instanssimuuttujaan lisataan yksi ja molempien pelaajien arpomat asennot tulostetaan konsoliin.
     * 
     * @param pelaaja1 ensimmainen peliin osallistuva Pelaaja-luokan ilmentyma.
     * 
     * @param pelaaja2 toinen peliin osallistuva Pelaaja-luokan ilmentyma.
     * 
     */
    public static void pelaaKierros(Pelaaja pelaaja1, Pelaaja pelaaja2) {

        final boolean pelaaja1Voitti = pelaaja1.getAsentovalinta().equals("kivi") && pelaaja2.getAsentovalinta().equals("sakset")
                                    || pelaaja1.getAsentovalinta().equals("sakset") && pelaaja2.getAsentovalinta().equals("paperi")
                                    || pelaaja1.getAsentovalinta().equals("paperi") && pelaaja2.getAsentovalinta().equals("kivi");

        if (pelaaja1Voitti) {
            pelaaja1.lisaaKierrosvoitto();
            System.out.println("Pelaaja 1: " + pelaaja1.getAsentovalinta() + "\nPelaaja 2: " + pelaaja2.getAsentovalinta() +
            "\nPelaaja 1 voitti kierroksen!\n\n");
        }

        if (!pelaaja1Voitti) {
            pelaaja2.lisaaKierrosvoitto();
            System.out.println("Pelaaja 1: " + pelaaja1.getAsentovalinta() + "\nPelaaja 2: " + pelaaja2.getAsentovalinta() +
            "\nPelaaja 2 voitti kierroksen!\n\n");            
        }
    }

    /**
     * Tarkistetaan, tuliko pelaajien pelaamista asennoista tasapeli, eli ovatko heidan arpomansa tulokset samat.
     * 
     * @param pelaaja1 ensimmainen peliin osallistuva Pelaaja-luokan ilmentyma.
     * 
     * @param pelaaja2 toinen peliin osallistuva Pelaaja-luokan ilmentyma.
     * 
     * @return booleanin, joka on true jos kyseessa on tasapeli ja false jos ei ole tasapeli.
     */
    public static boolean tarkistaTasapeli (Pelaaja pelaaja1, Pelaaja pelaaja2) {
        return pelaaja1.getAsentovalinta().equals(pelaaja2.getAsentovalinta());
    }

}
