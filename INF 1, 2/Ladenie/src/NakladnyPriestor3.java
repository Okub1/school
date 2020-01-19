
import java.util.ArrayList;
import nakladanepolozky.Nalozitelny;


public class NakladnyPriestor3 {
    private ArrayList<Nalozitelny> nalozenePolozky;
    /**
     * Maximalna hmotnost nalozenych poloziek v kg
     */
    private double maximalnaHmotnost ; 
    /**
     * Hmotnost nalozenych poloziek v kg
     */
    private double aktualnaHmotnost ;
    
    public NakladnyPriestor3(double maximalnaHmotnost){
       nalozenePolozky = new ArrayList<Nalozitelny>();
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
        
        for (Nalozitelny r : nalozenePolozky) {
            if (r.getEvidencneCislo().equals(polozka.getEvidencneCislo())) {
                return false;
            }
        }
        
     
        boolean vysl = nalozenePolozky.add(polozka);
        
        if (vysl == true) {
            aktualnaHmotnost = aktualnaHmotnost + polozka.getHmotnost();
        }
        
        return vysl;
    }    
    
    
    public Nalozitelny odoberPolozku(String evidencneCislo){
        if (evidencneCislo == null) {
            return null;
        }
        
        int indexOdoberanejPolozky = -1;
        int pocetPrvkov = nalozenePolozky.size();
        for (int i=0; i<pocetPrvkov; i++) {
            Nalozitelny p = nalozenePolozky.get(i);
            if(p.getEvidencneCislo().equals(evidencneCislo)) {
                indexOdoberanejPolozky = i;
            }
        }
        
        if (indexOdoberanejPolozky == -1) {
            return null;
        } else {
            Nalozitelny vysl = nalozenePolozky.remove(indexOdoberanejPolozky);
            aktualnaHmotnost = aktualnaHmotnost - vysl.getHmotnost();
            
            return vysl;
        }
    
    }
     
    public Nalozitelny getPolozka (String evidencneCislo){
        if (evidencneCislo == null) {
            return null;
        }
        
        int indexOdoberanejPolozky = -1;
        int pocetPrvkov = nalozenePolozky.size();
        for (int i=0; i<pocetPrvkov; i++) {
            Nalozitelny p = nalozenePolozky.get(i);
            if(p.getEvidencneCislo().equals(evidencneCislo)) {
                indexOdoberanejPolozky = i;
            }
        }
        
        if (indexOdoberanejPolozky == -1) {
            return null;
        } else {
            return nalozenePolozky.get(indexOdoberanejPolozky);
        }        
    }
    
    public String toString () {
        String pom = "V nakladnom priestore s kapacitou " + maximalnaHmotnost + 
                " kg je nalozenych: " + aktualnaHmotnost + 
                " kg, konkretne: \n " ;
        
        for(Nalozitelny p: nalozenePolozky) {
            pom = pom + "\n" + p/*.toString ()*/;
        }
        
        return pom;
    }     
    
    public double getHmotnostPoloziek () {
        /*
        double vysl = 0;
        
        for (PolozkaNakladu p : nalozenePolozky) {
            vysl = vysl + p.getHmotnost();
        }
        
        return vysl;
        */
        
        return aktualnaHmotnost;
    }    
    
}
