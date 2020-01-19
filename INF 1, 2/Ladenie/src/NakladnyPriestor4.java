

import java.util.HashMap;
import nakladanepolozky.Nalozitelny;

public class NakladnyPriestor4 {
    private HashMap<String,Nalozitelny> nalozenePolozky;
    /**
     * Maximalna hmotnost nalozenych poloziek v kg
     */
    private double maximalnaHmotnost ; 
    /**
     * Hmotnost nalozenych poloziek v kg
     */
    private double aktualnaHmotnost ;
 
    public NakladnyPriestor4 (double maximalnaHmotnost){
       nalozenePolozky = new HashMap <String, Nalozitelny>();
       this.maximalnaHmotnost = maximalnaHmotnost;
       aktualnaHmotnost = 0;
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
        
        Nalozitelny vysl = nalozenePolozky.put(polozka.getEvidencneCislo(), polozka);
        
     
        if (vysl == null) {
            aktualnaHmotnost = aktualnaHmotnost + polozka.getHmotnost();
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
