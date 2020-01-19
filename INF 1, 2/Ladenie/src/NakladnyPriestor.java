
import nakladanepolozky.Krokodil;
import nakladanepolozky.Pracovnik;
import nakladanepolozky.Rura;
import java.util.*;

public class NakladnyPriestor {
   /**
    * Nalozene rury.
    */
   private ArrayList<Rura> rury;
   /**
    * Nalozeny krokodily
    */
   private ArrayList<Krokodil> krokodily;
   /**
    * Nalozeny otroci
    */
   private ArrayList<Pracovnik> pracovnici;
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
   
    public NakladnyPriestor(int maxPocetKrokodilov,  
            double maximalnaHmotnost){
       rury = new ArrayList<Rura>();
       krokodily = new ArrayList<Krokodil>();
       pracovnici = new ArrayList<Pracovnik>();
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
        
        for (Rura r : rury) {
            if (r.getEvidencneCislo().equals(rura.getEvidencneCislo())) {
                return false;
            }
        }
        
     
        boolean vysl = rury.add(rura);
        
        if (vysl == true) {
            aktualnaHmotnost = aktualnaHmotnost + rura.getHmotnost();
        }
        
        return vysl;
    }
    
    public Rura odoberRuru(String evidencneCislo){
        if (evidencneCislo == null) {
            return null;
        }
        
        int indexOdoberanejRury = -1;
        int pocetPrvkov = rury.size();
        for (int i=0; i<pocetPrvkov; i++) {
            Rura r = rury.get(i);
            if(r.getEvidencneCislo().equals(evidencneCislo)) {
                indexOdoberanejRury = i;
            }
        }
        
        if (indexOdoberanejRury == -1) {
            return null;
        } else {
            Rura vysl = rury.remove(indexOdoberanejRury);
            aktualnaHmotnost = aktualnaHmotnost - vysl.getHmotnost();
            
            return vysl;
        }
    }
    
    public Rura getRura (String evidencneCislo){
        if (evidencneCislo == null) {
            return null;
        }
        
        int indexOdoberanejRury = -1;
        int pocetPrvkov = rury.size();
        for (int i=0; i<pocetPrvkov; i++) {
            Rura r = rury.get(i);
            if(r.getEvidencneCislo().equals(evidencneCislo)) {
                indexOdoberanejRury = i;
            }
        }
        
        if (indexOdoberanejRury == -1) {
            return null;
        } else {
            return rury.get(indexOdoberanejRury);
        }        
    }
    
    public boolean pridajKrokodila (Krokodil krokodil) {
        if(krokodil == null) {
            return false;
        }
        
        if (aktualnaHmotnost + krokodil.getHmotnost() > maximalnaHmotnost) {
            return false;
        }
        
        if (krokodily.size()+1 > maxPocetKrokodilov) {
            return false;
        }
        
        for (Krokodil k : krokodily){
            if (k.getEvidencneCislo().equals(krokodil.getEvidencneCislo())) {
                return false;
            }
        }
        
        boolean vysl = krokodily.add(krokodil);
        
        if (vysl == true) {
            aktualnaHmotnost = aktualnaHmotnost + krokodil.getHmotnost();
        }
        
        return vysl;
    }
    
    public Krokodil odoberKrokodila(String evidencneCislo){
        if (evidencneCislo == null) {
            return null;
        }
        
        int indexOdoberanehoKrokodila = -1;
        int pocetPrvkov = krokodily.size();
        for (int i=0; i<pocetPrvkov; i++) {
            Krokodil k = krokodily.get(i);
            if(k.getEvidencneCislo().equals(evidencneCislo)) {
                indexOdoberanehoKrokodila = i;
            }
        }
        
        if (indexOdoberanehoKrokodila == -1) {
            return null;
        } else {
            Krokodil vysl = krokodily.remove(indexOdoberanehoKrokodila);
            aktualnaHmotnost = aktualnaHmotnost - vysl.getHmotnost();
            
            return vysl;
        }
    }
    
    public Krokodil getKrokodil (String evidencneCislo){
        if (evidencneCislo == null) {
            return null;
        }
        
        int indexOdoberanehoKrokodila = -1;
        int pocetPrvkov = krokodily.size();
        for (int i=0; i<pocetPrvkov; i++) {
            Krokodil k = krokodily.get(i);
            if(k.getEvidencneCislo().equals(evidencneCislo)) {
                indexOdoberanehoKrokodila = i;
            }
        }
        
        if (indexOdoberanehoKrokodila == -1) {
            return null;
        } else {
            return krokodily.get(indexOdoberanehoKrokodila);
        }        
    }
    
    public boolean pridajPracovnika(Pracovnik pracovnik){
        if(pracovnik == null) {
            return false;
        }
        
        if (aktualnaHmotnost + pracovnik.getHmotnost() > maximalnaHmotnost) {
            return false;
        }
        
        for (Pracovnik o : pracovnici) {
            if (o.getEvidencneCislo().equals(pracovnik.getEvidencneCislo())) {
                return false;
            }
        }
        
        
        boolean vysl = pracovnici.add(pracovnik);
        
        if (vysl == true) {
            aktualnaHmotnost = aktualnaHmotnost + pracovnik.getHmotnost();
        }
        
        return vysl;
    }
    
    public Pracovnik odoberPracovnika(String evidencneCislo){
        if (evidencneCislo == null) {
            return null;
        }
        
        int indexOdoberanehoOtroka = -1;
        int pocetPrvkov = pracovnici.size();
        for (int i=0; i<pocetPrvkov; i++) {
            Pracovnik o = pracovnici.get(i);
            if(o.getEvidencneCislo().equals(evidencneCislo)) {
                indexOdoberanehoOtroka = i;
            }
        }
        
        if (indexOdoberanehoOtroka == -1) {
            return null;
        } else {
            Pracovnik vysl = pracovnici.remove(indexOdoberanehoOtroka);
            aktualnaHmotnost = aktualnaHmotnost - vysl.getHmotnost();
            
            return vysl;
        }
    }
    
    public Pracovnik getPracovnik (String evidencneCislo){
        if (evidencneCislo == null) {
            return null;
        }
        
        int indexOdoberanehoOtroka = -1;
        int pocetPrvkov = pracovnici.size();
        for (int i=0; i<pocetPrvkov; i++) {
            Pracovnik o = pracovnici.get(i);
            if(o.getEvidencneCislo().equals(evidencneCislo)) {
                indexOdoberanehoOtroka = i;
            }
        }
        
        if (indexOdoberanehoOtroka == -1) {
            return null;
        } else {
            return pracovnici.get(indexOdoberanehoOtroka);
        }        
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
        
        for(Rura r: rury) {
            pom = pom + "\n" + r /* .toString ()*/;
        }
        
        for(Krokodil k: krokodily) {
            pom = pom + "\n" + k /* .toString ()*/;
        }
        
        for(Pracovnik o: pracovnici) {
            pom = pom + "\n" + o /* .toString ()*/;
        }
        
        return pom;
    }    
    
    
    public double getHmotnostRur () {
        double vysl = 0;
        
        for (Rura r : rury) {
            vysl = vysl + r.getHmotnost();
        }
        
        return vysl;
    }
    
    public double getHmotnostKrokodilov () {
         double vysl = 0;
        
        for (Krokodil k : krokodily) {
            vysl = vysl + k.getHmotnost();
        }
        
        return vysl;
    }
    
    public double getHmotnostPracovnikov() {
         double vysl = 0;
        
        for (Pracovnik o : pracovnici) {
            vysl = vysl + o.getHmotnost();
        }
        
        return vysl;
    }
}
