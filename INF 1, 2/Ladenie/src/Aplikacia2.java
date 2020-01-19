
import java.util.ArrayList;
import nakladanepolozky.Krokodil;
import nakladanepolozky.Pracovnik;
import nakladanepolozky.Rura;
import java.util.HashMap;
import nakladanepolozky.StavKrokodila;

public abstract class Aplikacia2 {
    public static void main(String[] args) {
        NakladnyPriestor2 np = new NakladnyPriestor2(5,1000);
        Rura r1 = new Rura("789",5,1.5);
        Rura r2 = new Rura("135",4,1.2);        
        Krokodil k = new Krokodil("123", 30, 130, StavKrokodila.ZIVY);
        Pracovnik p = new Pracovnik("456",25,800,75);
        np.pridajRuru(r1);
        np.pridajRuru(r2);
        np.pridajKrokodila(k);
        np.pridajPracovnika(p);
        
        
        System.out.println(np.dajEvidencneCisla());
        
        System.out.println(np);
    
        np.odoberRuru("789");
        
        System.out.println(np);
        
        System.out.println("Spristupnena rura = " + np.getRura("135"));
        
        HashMap<Rura,String> popiskyRur = new HashMap<Rura,String>();
        Rura kluc1 = new Rura("159",2,1);
        String hodnota1 = "S touto tycou zbil Henrich VI svojho dlhorocneho " +
                "sluhu Matusa z rodiny miestnych kovacov";
        Rura kluc2 = new Rura("753", 2, 6);
        String hodnota2 = "Tato rura bola zabetonovana do mostu, na ktorom zomrel " +
                "kral Ferdinand III";
        
        
        popiskyRur.put(kluc1, hodnota1);
        popiskyRur.put(kluc2, hodnota2);
        
        System.out.println(popiskyRur.get(kluc2));
        
        System.out.println("******************************");
        
        ArrayList<Rura> ruryList = new ArrayList<Rura>(10000);
        long pocCasVkladList = System.currentTimeMillis();
        for(int i=0; i<20000; i++){
            ruryList.add(new Rura(String.valueOf(i),5,2));
        }
        long trvanieVkladList = System.currentTimeMillis() - pocCasVkladList;
        
        HashMap<String,Rura> ruryMapa = new HashMap<String,Rura>();
        long pocCasVkladMapa = System.currentTimeMillis();
        for(int i=0; i<20000; i++){
            String ec = String.valueOf(i);
            ruryMapa.put(ec, new Rura(ec,5,2));
        }
        long trvanieVkladMapa = System.currentTimeMillis() - pocCasVkladMapa;
        
        
        long pocCasVyberList = System.currentTimeMillis();
        for(int i=10000; i<11000; i++){
            String ec = String.valueOf(i);
            Rura vysl = null;
            for(Rura r : ruryList){
                if(r.getEvidencneCislo().equals(ec)){
                    vysl = r;
                }
            }           
            //Pouzi vysl
            vysl.getHmotnost();
        }
        long trvanieVyberList = System.currentTimeMillis() - pocCasVyberList;
        long pocCasVyberMapa = System.currentTimeMillis();
        for(int i=10000; i<11000; i++){
            String ec = String.valueOf(i);
            Rura vysl = ruryMapa.get(ec);
            //Pouzi vysl
            vysl.getHmotnost();
        }
        long trvanieVyberMapa = System.currentTimeMillis() - pocCasVyberMapa;        
        
        
        System.out.println("Trvanie vkladania pre ArrayList: " + trvanieVkladList);
        System.out.println("Trvanie vkladania pre HashMap: " + trvanieVkladMapa);
        System.out.println("Trvanie vyhladania pre ArrayList: " + trvanieVyberList);
        System.out.println("Trvanie vyhladania pre HashMap: " + trvanieVyberMapa);
    }
}
