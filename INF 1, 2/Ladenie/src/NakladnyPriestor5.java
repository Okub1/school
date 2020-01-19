

import java.util.HashMap;
import nakladanepolozky.Krokodil;
import nakladanepolozky.Nalozitelny;
import nakladanepolozky.Pracovnik;

public class NakladnyPriestor5 {
    private HashMap<String,Nalozitelny> nalozenePolozky;
    /**
     * Maximalna hmotnost nalozenych poloziek v kg
     */
    private double maximalnaHmotnost ; 
    /**
     * Hmotnost nalozenych poloziek v kg
     */
    private double aktualnaHmotnost ;
    
    private int maxPocetKrokodilov;
    
    private int aktualnyPocetKrokodilov;
    
    private int maxPocetPracovnikov;
    
    private int aktualnyPocetPracovnikov;
 
    public NakladnyPriestor5 (int maxPocetKrokodilov, int maxPocetPracovnikov,
            double maximalnaHmotnost){
       if(maxPocetKrokodilov<0){
           maxPocetKrokodilov = 0;
       }
       if(maximalnaHmotnost<0.1){
           maximalnaHmotnost=0.1;
       }
       if (maxPocetPracovnikov < 0) {
           maxPocetPracovnikov = 0;
       }
        
       nalozenePolozky = new HashMap <String, Nalozitelny>();
       this.maxPocetKrokodilov = maxPocetKrokodilov;
       this.aktualnyPocetKrokodilov = 0;
       this.maximalnaHmotnost = maximalnaHmotnost;
       aktualnaHmotnost = 0;
       this.maxPocetPracovnikov = maxPocetPracovnikov;
       this.aktualnyPocetPracovnikov = 0;
     } 
    
    public boolean pridajPolozku(Nalozitelny polozka){
        if(polozka == null) {
            return false;
        }
        
        if (aktualnaHmotnost + polozka.getHmotnost() > maximalnaHmotnost) {
            return false;
        }
        
        if(nalozenePolozky.containsKey(polozka.getEvidencneCislo())){
            return false;
        }
        
        if(polozka instanceof Krokodil){
            if(aktualnyPocetKrokodilov>=maxPocetKrokodilov){
                return false;
            }
        }
        
        if (polozka instanceof Pracovnik) {
            if (aktualnyPocetPracovnikov >= maxPocetPracovnikov) {
                return false;
            }
        }
        
        Nalozitelny vysl = nalozenePolozky.put(polozka.getEvidencneCislo(), polozka);
        
     
        if (vysl == null) {
            aktualnaHmotnost = aktualnaHmotnost + polozka.getHmotnost();
            if(polozka instanceof Krokodil){
                aktualnyPocetKrokodilov++;
            }
            if (polozka instanceof Pracovnik) {
                this.aktualnyPocetPracovnikov++;
            }
        }
        
        
        return true;
    }
    
    public Nalozitelny odoberPolozku(String evidencneCislo) {
        if (evidencneCislo == null) {
            return null;
        }
        
        if (!nalozenePolozky.containsKey(evidencneCislo)) {
            return null;
        }
        
        Nalozitelny vysl = nalozenePolozky.remove(evidencneCislo);
        if (vysl != null) {
            aktualnaHmotnost -= vysl.getHmotnost();
        }
        
        return vysl;
    }
    
    public Nalozitelny getPolozka (String evidencneCislo){
        if (evidencneCislo == null) {
            return null;
        }
        
        return nalozenePolozky.get(evidencneCislo);
    }

    
    public String toString() {
        String pom = "V nakladnom priestore s kapacitou " + maximalnaHmotnost + 
                " kg je nalozenych: " + aktualnaHmotnost + 
                " kg, konkretne: \n ";
        for (Nalozitelny n : nalozenePolozky.values()) {
            pom += n + "\n";
        }
        
        return pom;
    }
    
    public double getHmotnostPoloziek() {
        return this.aktualnaHmotnost;
    }
}

