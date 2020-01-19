import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

public class HraciePole {

    private Karta karty[];
    private Karta[] kartas;
    private int pocetRiadkov;
    private int pocetStlpcov;


    public HraciePole(int pocetRiadkov, int pocetStlpcov) {
        this.pocetRiadkov = pocetRiadkov;
        this.pocetStlpcov = pocetStlpcov;
        this.kartas = new Karta[pocetRiadkov*pocetStlpcov];

        int a = 0;
        for (int i = 0; i < this.kartas.length; i+=2 ) {
            kartas[i] = new Karta((char) ('A' + a));
            kartas[i+1] = new Karta((char) ('A' + a));
            a++;
        }
        shuffleArray(kartas);
    }

    public void vypisPole() {
        System.out.println();
        for (int i = 0; i < this.kartas.length; i++) {
            if (i % this.pocetStlpcov == 0) {
                System.out.println();
            }

            System.out.print(this.kartas[i].getZnak() + " ");
        }
    }

    public void otocVsetkyKarty() {
        for (int i = 0; i < this.kartas.length; i++) {
            this.kartas[i].otocKartu();
        }
    }

    static void shuffleArray(Karta[] ar)
    {
        // If running on Java 6 or older, use `new Random()` on RHS here
        Random rnd = ThreadLocalRandom.current();
        for (int i = ar.length - 1; i > 0; i--)
        {
            int index = rnd.nextInt(i + 1);
            // Simple swap
            Karta a = ar[index];
            ar[index] = ar[i];
            ar[i] = a;
        }
    }

    public Karta getKarta(int riadok, int stlpec) {
        return this.kartas[this.pocetStlpcov*riadok+stlpec]; // jednoducha matika na "prerobenie" 1d pola na 2d :)
    }

    public boolean jeHraciePolePrazdne() {
        for (int i = 0; i < this.kartas.length; i++) {
            if (this.kartas[i].getZnak() != ' ') {
                return false;
            }
        }

        return true;
    }
}
