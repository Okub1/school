
import nakladanepolozky.Krokodil;
import nakladanepolozky.Pracovnik;
import nakladanepolozky.StavKrokodila;


public abstract class Aplikacia {
    public static void main(String[] args) {
        NakladnyPriestor np = new NakladnyPriestor(5,1000);
        Krokodil k = new Krokodil("123", 30, 130, StavKrokodila.ZIVY);
        Pracovnik p = new Pracovnik("456",25,800,75);
        np.pridajKrokodila(k);
        np.pridajPracovnika(p);
        System.out.println(np);
    
    }
}
