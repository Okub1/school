
import java.util.Iterator;
import nakladanepolozky.Cukrik;
import nakladanepolozky.PrichutCukrika;


public class Aplikacia10 {
    
    public static void main(String[] args) {
        NakladnyPriestor8<Cukrik> np = new NakladnyPriestor8(10);
       // NakladnyPriestor8<Cukrik> np2 = new NakladnyPriestor8(10); // dalsi sposob vytvorenia
       // NakladnyPriestor8<Cukrik> np2 = new NakladnyPriestor8(); // dalsi sposob vytvorenia
     
        
        Cukrik c = new Cukrik("123", 0.03, PrichutCukrika.JAHODOVA, System.currentTimeMillis());
        Cukrik c2 = new Cukrik("456", 0.02, PrichutCukrika.MENTOLOVA, System.currentTimeMillis());
        
        np.naloz(c);
        np.naloz(c2);
        
        
        System.out.println(np);
        
        System.out.println("**********");
        
        System.out.println(np.<Cukrik>dajNaklad(0));
        
        System.out.println(np.dajNaklad(0)); //dalsi spôsob
        
        System.out.println("**********");
        
        Iterator<Cukrik> it = np.iterator();
        
        while(it.hasNext()) {
            Cukrik x = it.next();
            System.out.println(x);
        }
        
         System.out.println("**********");
         
         for (Cukrik x : np) {
             System.out.println(x);
         }
       
         //NakladnyPriestor8<String> slova = new NakladnyPriestor8<String>(10); // dalsi spôsob
         
            NakladnyPriestor8<String> slova = new NakladnyPriestor8(10);
            
            slova.naloz("Huraaaaa....");
            slova.naloz("hahaha");
            slova.naloz("Mozno");
            
            for (String s : slova) {
                System.out.println(s);
            }
            
            NakladnyPriestor9<Cukrik> cukriky = new NakladnyPriestor9(10);
    
    cukriky.naloz(c);
    cukriky.naloz(c2);
    System.out.println(cukriky);
    
    //NakladnyPriestor9<String> slova2 = new NakladnyPriestor9(); // nefunguje
    }

}
