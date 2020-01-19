
import nakladanepolozky.Krokodil;
import nakladanepolozky.Pracovnik;
import nakladanepolozky.Rura;
import java.util.*;

public class NakladnyPriestor2 {
   /**
    * Nalozene rury.
    */
   private HashMap<String, Rura> rury;
   /**
    * Nalozeny krokodily
    */
   private HashMap<String, Krokodil> krokodily;
   /**
    * Nalozeny otroci
    */
   private HashMap<String, Pracovnik> pracovnici;
   /**
    * Maximalny pocet nalozenych krokodilov v kusoch.
    */
   private int maxPocetKrokodilov;
   /**
    * Maximalna hmotnost nalozenych poloziek v kg
    */
   private double maximalnaHmotnost ; 
   /**
    * Hmotnost nalozenych poloziek v kg
    */
   private double aktualnaHmotnost ;
   
    public NakladnyPriestor2(int maxPocetKrokodilov,  
            double maximalnaHmotnost){
       rury = new HashMap<String,Rura>();
       krokodily = new HashMap <String, Krokodil>();
       pracovnici = new HashMap<String, Pracovnik>();
       this.maxPocetKrokodilov = maxPocetKrokodilov;
       this.maximalnaHmotnost = maximalnaHmotnost;
       aktualnaHmotnost = 0;
     }
    
    public boolean pridajRuru(Rura rura){
        if(rura == null) {
            return false;
        }
        
        if (aktualnaHmotnost + rura.getHmotnost() > maximalnaHmotnost) {
            return false;
        }
        
        if(rury.containsKey(rura.getEvidencneCislo())){
            return false;
        }
        
        Rura vysl = rury.put(rura.getEvidencneCislo(), rura);
        
     
        if (vysl == null) {
            aktualnaHmotnost = aktualnaHmotnost + rura.getHmotnost();
        }
        
        return true;
    }
    
    public Rura odoberRuru(String evidencneCislo){
        if (evidencneCislo == null) {
            return null;
        }
        
        if(!rury.containsKey(evidencneCislo)){
            return null;
        }
        
        Rura vysl = rury.remove(evidencneCislo);
        
        if(vysl != null){
            aktualnaHmotnost = aktualnaHmotnost - vysl.getHmotnost();
        }
        
        return vysl;
    }
    
    public Rura getRura (String evidencneCislo){
        if (evidencneCislo == null) {
            return null;
        }
        
        return rury.get(evidencneCislo);
    }
    
    public boolean pridajKrokodila (Krokodil krokodil) {
        if(krokodil == null) {
            return false;
        }
        
        if (aktualnaHmotnost + krokodil.getHmotnost() > maximalnaHmotnost) {
            return false;
        }
        
        if (krokodily.size() >= maxPocetKrokodilov) {
            return false;
        }
        
        if(krokodily.containsKey(krokodil.getEvidencneCislo())){
            return false;
        }
        
        Krokodil vysl = krokodily.put(krokodil.getEvidencneCislo(), krokodil);
        
     
        if (vysl == null) {
            aktualnaHmotnost = aktualnaHmotnost + krokodil.getHmotnost();
        }
        
        return true;
    }
    
    public Krokodil odoberKrokodila(String evidencneCislo){
        if (evidencneCislo == null) {
            return null;
        }
        
        if(!krokodily.containsKey(evidencneCislo)){
            return null;
        }
        
        Krokodil vysl = krokodily.remove(evidencneCislo);
        
        if(vysl != null){
            aktualnaHmotnost = aktualnaHmotnost - vysl.getHmotnost();
        }
        
        return vysl;
        
    }
    
    public Krokodil getKrokodil (String evidencneCislo){
        if (evidencneCislo == null) {
            return null;
        }
        
        return krokodily.get(evidencneCislo);               
    }
    
    public boolean pridajPracovnika(Pracovnik pracovnik){
        if(pracovnik == null) {
            return false;
        }
        
        if (aktualnaHmotnost + pracovnik.getHmotnost() > maximalnaHmotnost) {
            return false;
        }
        
         if(pracovnici.containsKey(pracovnik.getEvidencneCislo())){
            return false;
        }
        
        Pracovnik vysl = pracovnici.put(pracovnik.getEvidencneCislo(), pracovnik);
        
     
        if (vysl == null) {
            aktualnaHmotnost = aktualnaHmotnost + pracovnik.getHmotnost();
            return true;
        }
        
        return false;
    }
    
    public Pracovnik odoberPracovnika(String evidencneCislo){
        if (evidencneCislo == null) {
            return null;
        }
        
        if(!pracovnici.containsKey(evidencneCislo)){
            return null;
        }
        
        Pracovnik vysl = pracovnici.remove(evidencneCislo);
        
        if(vysl != null){
            aktualnaHmotnost = aktualnaHmotnost - vysl.getHmotnost();
        }
        
        return vysl;
    }
    
    public Pracovnik getPracovnik (String evidencneCislo){
        if (evidencneCislo == null) {
            return null;
        }
        
        return pracovnici.get(evidencneCislo);
    }
    
    /**
     * Spristupnuje znakovu reprezentaciu nakladneho priestora
     *
     * @return The return value
     */
    public String toString () {
        String pom = "V nakladnom priestore s kapacitou " + maximalnaHmotnost + 
                " kg je nalozenych: " + aktualnaHmotnost + 
                " kg, konkretne: \n " ;
        
        for(Rura r: rury.values()) {
            pom = pom + "\n" + r /* .toString ()*/;
        }
        
        for(Krokodil k: krokodily.values()) {
            pom = pom + "\n" + k /* .toString ()*/;
        }
        
        for(Pracovnik o: pracovnici.values()) {
            pom = pom + "\n" + o /* .toString ()*/;
        }
        
        return pom;
    }    
    
    
    public double getHmotnostRur () {
        double vysl = 0;
        
        for (Rura r : rury.values()) {
            vysl = vysl + r.getHmotnost();
        }
        
        return vysl;
    }
    
    public double getHmotnostKrokodilov () {
         double vysl = 0;
        
        for (Krokodil k : krokodily.values()) {
            vysl = vysl + k.getHmotnost();
        }
        
        return vysl;
    }
    
    public double getHmotnostPracovnikov() {
         double vysl = 0;
        
        for (Pracovnik o : pracovnici.values()) {
            vysl = vysl + o.getHmotnost();
        }
        
        return vysl;
    }
    
    public String dajEvidencneCisla(){
        String vysl = "";
        
        for(String ecr : rury.keySet()){
            vysl = vysl + ecr + "\n";
        }
        
        Iterator<String> itK = krokodily.keySet().iterator();
        while(itK.hasNext()){
            String eck = itK.next();
            
            vysl = vysl + eck + "\n";
        }
        
        for(String ecp : pracovnici.keySet()){
            vysl = vysl + ecp + "\n";
        }
        
        return vysl;
    }
}

