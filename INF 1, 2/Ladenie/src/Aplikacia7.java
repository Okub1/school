
import nakladanepolozky.Chut;
import nakladanepolozky.Maslo;
import nakladanepolozky.Pomaranc;
import nakladanepolozky.Rura;
import nakladanepolozky.ZjeditelnaPolozka;


public abstract class Aplikacia7 {
    public static void main(String[] args) {
        NakladnyPriestor5 np = new NakladnyPriestor5(2, 3, 1000);
        
        System.out.println(np.pridajPolozku(new Pomaranc("123",0.2,System.currentTimeMillis())));
        System.out.println(np.pridajPolozku(new Pomaranc("456",0.15,System.currentTimeMillis())));
        System.out.println(np.pridajPolozku(new Pomaranc("789",0.25,System.currentTimeMillis())));
        System.out.println(np.pridajPolozku(new Rura("753",3,1.5)));
    
        System.out.println(np);
        
        if(np.getPolozka("456") instanceof ZjeditelnaPolozka){
            ZjeditelnaPolozka jedlo = (ZjeditelnaPolozka)np.getPolozka("456");
            if(jedlo.getChut().equals(Chut.KYSLA)){
                System.out.println("Idem do toho");
            }
        }
        
        ZjeditelnaPolozka[] polozky = new ZjeditelnaPolozka[2];
        polozky[0] = new Pomaranc("123",0.2,System.currentTimeMillis());
        polozky[1] = new Maslo(0.1,System.currentTimeMillis());
        for(int i=0; i<polozky.length; i++){
            System.out.println(polozky[i].getVyziva());
            System.out.println(polozky[i].jeToCerstve());
        }
    }     
}
