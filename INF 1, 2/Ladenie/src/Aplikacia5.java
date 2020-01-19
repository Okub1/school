
import nakladanepolozky.Chut;
import nakladanepolozky.Krokodil;
import nakladanepolozky.Rura;
import nakladanepolozky.StavKrokodila;
import nakladanepolozky.Zjeditelny;


public abstract class Aplikacia5 {
    public static void main(String[] args) {
        NakladnyPriestor5 np = new NakladnyPriestor5(2, 3, 1000);
        
        System.out.println(np.pridajPolozku(new Krokodil("123",50,120, StavKrokodila.ZIVY)));
        System.out.println(np.pridajPolozku(new Krokodil("456",40,100, StavKrokodila.ZIVY)));
        System.out.println(np.pridajPolozku(new Krokodil("789",45,130, StavKrokodila.ZIVY)));
        System.out.println(np.pridajPolozku(new Rura("753",3,1.5)));
    
        System.out.println(np);
        
        if(np.getPolozka("456") instanceof Zjeditelny){
            Zjeditelny jedlo = (Zjeditelny)np.getPolozka("456");
            if(jedlo.getChut().equals(Chut.KURACORYBIA)){
                System.out.println("Idem do toho");
            }
        }
    }    
}
