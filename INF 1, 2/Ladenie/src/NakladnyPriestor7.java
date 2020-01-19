

import Vynimky.OdobratiePolozkyException;
import Vynimky.PridaniePolozkyException;
import java.io.Serializable;
import java.util.HashMap;
import nakladanepolozky.Krokodil;
import nakladanepolozky.Nalozitelny;
import nakladanepolozky.Pracovnik;

public class NakladnyPriestor7 implements Serializable{
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
 
    public NakladnyPriestor7 (int maxPocetKrokodilov, int maxPocetPracovnikov,
            double maximalnaHmotnost){
       if(maxPocetKrokodilov<0){
           //maxPocetKrokodilov = 0;
           throw new IllegalArgumentException("Maximalny pocet krokodilov zadany v konstruktore nemoze byt nmensi ako 0");
       }
       if(maximalnaHmotnost<0.1){
           //maximalnaHmotnost=0.1;
           throw new IllegalArgumentException("Maximalny hmotnost nakladneho priestoru zadana v konstruktore nemoze byt nmensi ako 0");      
       }
       if (maxPocetPracovnikov < 0) {
           //maxPocetPracovnikov = 0;
           throw new IllegalArgumentException("Maximalny pocet pracovnikov  zadany v konstruktore nemoze byt nmensi ako 0");
       }
        
       nalozenePolozky = new HashMap <String, Nalozitelny>();
       this.maxPocetKrokodilov = maxPocetKrokodilov;
       this.aktualnyPocetKrokodilov = 0;
       this.maximalnaHmotnost = maximalnaHmotnost;
       aktualnaHmotnost = 0;
       this.maxPocetPracovnikov = maxPocetPracovnikov;
       this.aktualnyPocetPracovnikov = 0;
     } 
    
    public void pridajPolozku(Nalozitelny polozka) throws PridaniePolozkyException{
        if(polozka == null) {
            throw new PridaniePolozkyException("Pridavana polozka nemoze byt null");
        }
        
        if (aktualnaHmotnost + polozka.getHmotnost() > maximalnaHmotnost) {
            throw new PridaniePolozkyException("Pridanie polozky by spôsobilo prekrocenie maximalnej hmotnosti");
        }
        
        if(nalozenePolozky.containsKey(polozka.getEvidencneCislo())){
            throw new PridaniePolozkyException("Pridavana polozka sa neda vlozit do nakladneho priestotu pretoze polozka s takym"
                    + "rovnakym evidencnym cislom sa tam uz nachádza");
        }
        
        if(polozka instanceof Krokodil){
            if(aktualnyPocetKrokodilov>=maxPocetKrokodilov){
                throw new PridaniePolozkyException("Pridavany krokodil sa enda vlozit do NP pretoze uz obsahuje stanoveny maximalny pocet krokodilov");
            }
        }
        
        if (polozka instanceof Pracovnik) {
            if (aktualnyPocetPracovnikov >= maxPocetPracovnikov) {
                throw new PridaniePolozkyException("Pridavany pracovnik sa enda vlozit do NP pretoze ten uz obsahuje stanoveny max pocet pracovnikov");
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
        
        
       
    }
    
    public Nalozitelny odoberPolozku(String evidencneCislo) throws OdobratiePolozkyException {
        if (evidencneCislo == null) {
            //return null;
            throw new OdobratiePolozkyException("Evidencne cislo pri odoberani polozky nemoze byt null");
        }
        
        if (!nalozenePolozky.containsKey(evidencneCislo)) {
            //return null;
            throw new OdobratiePolozkyException("V nakladnom priestore sa nenachadza polozka s danym evidencnym cislom na odobratie");
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

