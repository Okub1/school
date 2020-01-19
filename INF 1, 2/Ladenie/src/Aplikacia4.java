
import nakladanepolozky.*;


public abstract class Aplikacia4 {
    public static void main(String[] args) {
        Nalozitelny[] pn = new Nalozitelny[2];
        
        pn[0] = new Krokodil("123",30,120, StavKrokodila.ZIVY);
        pn[1] = new Pracovnik("456",20,800,80);
        
        
        NakladnyPriestor4 np4 = new NakladnyPriestor4(1000);
        np4.pridajPolozku(pn[0]);
        np4.pridajPolozku(pn[1]);
        np4.pridajPolozku(new Tehla("489", 2.3, Material.PALENA));
        np4.pridajPolozku(new Rura("789", 3, 1.2));
        System.out.println(np4);
        System.out.println("*");
        Nalozitelny odobranaPolozka = np4.odoberPolozku("123");
        System.out.println(np4);
        System.out.println(((Krokodil)odobranaPolozka).getPocetZubov());
        System.out.println(odobranaPolozka.getHmotnost());
        
        
    }    
}
