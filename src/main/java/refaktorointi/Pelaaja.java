package refaktorointi;

/**
 *
 * @author Sebastian Wolf
 */
public class Pelaaja {

    private int kierrosvoitot = 0;      // Eravoittojen lukumaara
    private String asentoValinta = "";  // Arvottu kasien asento: kivi, paperi tai sakset

    /**
     * Arpoo satunnaisesti yhden kolmesta arvosta ("kivi", "paperi", "sakset")
     * ja asettaa sen instanssimuuttujan asentoValinta arvoksi
     */
    public void valitseAsento() {
        int arvottuAsento = (int) (Math.random() * 3);
        switch (arvottuAsento) {
            case 0:
                asentoValinta = ("kivi");
                break;
            case 1:
                asentoValinta = ("paperi");
                break;
            case 2:
                asentoValinta = ("sakset");
                break;
        }
    }

    /**
     * Lisaa kutsuttaessa instanssimuuttujan 'kierrosvoitot' arvoon luvun 1
     */
    public void lisaaKierrosvoitto() {
        kierrosvoitot += 1;
    }

    /**
     * Palauttaa kierrosvoitot-muuttujan kokonaislukuna
     * 
     * @return kokonaisluku, joka kertoo voittojen kokonaismaaran
     * 
     */
    public int getKierrosvoitot() {
        return kierrosvoitot;
    }

    /**
     * Palauttaa asentoValinta-muuttujan Stringina
     * 
     * @return String, joka kertoo arvotun ksp-asennon.
     * 
     */
    public String getAsentovalinta() {
        return asentoValinta;
    }
}
