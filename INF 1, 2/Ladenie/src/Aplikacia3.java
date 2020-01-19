
import nakladanepolozky.*;


public abstract class Aplikacia3 {
    public static void main(String[] args) {
        Nalozitelny[] pn = new Nalozitelny[2];
        
        pn[0] = new Krokodil("123",30,120, StavKrokodila.ZIVY);
        pn[1] = new Pracovnik("456",20,800,80);
        
        
        for(int i=0; i<pn.length; i++){
            System.out.println(pn[i].getEvidencneCislo());
            System.out.println(pn[i].toString());
        }
        
        System.out.println(((Krokodil)pn[0]).getPocetZubov());
        //System.out.println(((Rura)pn[0]).getDlzka()); // Za behu nastane chyba
        
        System.out.println("*********************************************");
        
        NakladnyPriestor3 np3 = new NakladnyPriestor3(1000);
        np3.pridajPolozku(pn[0]);
        np3.pridajPolozku(pn[1]);
        np3.pridajPolozku(new Tehla("489", 2.3, Material.PALENA));
        np3.pridajPolozku(new Rura("789", 3, 1.2));
        System.out.println(np3);
        System.out.println("*");
        Nalozitelny odobranaPolozka = np3.odoberPolozku("123");
        System.out.println(np3);
        System.out.println(((Krokodil)odobranaPolozka).getPocetZubov());
        System.out.println(odobranaPolozka.getHmotnost());
        
        
    }
}
