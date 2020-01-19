
import nakladanepolozky.*;


public abstract class Aplikacia6 {
    public static void main(String[] args) {
        Pracovnik[] pracovnici = new Pracovnik[3];
        
        pracovnici[0] = new AgenturnyPracovnik("123", 30, 500, 80, 
                "Ofajc s.r.o.", 0, 200);
        pracovnici[1] = new Zamestnanec("456",27,1200,77,"Microsoft Slovakia");
        pracovnici[2] = new AgenturnyPracovnik("789", 55, 520, 100, 
                "Ofajc s.r.o.", 0, 100);
        
        for(Pracovnik p : pracovnici){
            System.out.println(p.toString());
        }
        
        for(Pracovnik p : pracovnici){
            System.out.println(p.getVyskaMzdy());
        }
        
        System.out.println(((Zamestnanec)pracovnici[1]).getNevycerpaneDniDovolenky());
        
        NakladnyPriestor5 np = new NakladnyPriestor5(10, 10, 1000);
        np.pridajPolozku(pracovnici[1]);
        System.out.println(np);
    }    
}
