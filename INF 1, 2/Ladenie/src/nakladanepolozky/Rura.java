package nakladanepolozky;

import java.io.Serializable;

public class Rura implements Nalozitelny, Serializable {
        
    private double dlzka;
    private double hmotnost;
    private String evidencneCislo;
    
    public Rura (String evidencneCislo, double hmotnost,  double dlzka){
    
        if (evidencneCislo == null) {
            evidencneCislo = "";
        }
        
        if (hmotnost == 0) {
            hmotnost = 0.01;
        }
        
        if (dlzka <= 0) {
            dlzka = 0.01;
        }
        
        this.evidencneCislo = evidencneCislo;
        this.hmotnost = hmotnost;
        this.dlzka = dlzka;
        
    }
    
     public String getEvidencneCislo (){
         return evidencneCislo;
    }
    
      public double getHmotnost (){
          return hmotnost;
    }
    
    public double getDlzka (){
        return dlzka;
    }
    
    public String toString () {
        return "[ Rura : evidencneCislo = " + evidencneCislo + ", hmotnost = " + 
                hmotnost + " kg , dlzka = " + dlzka + " m ]";
    }
    
    public boolean equals(Object o){
        if(o == null) {
            return false;
        }
        
        if(!(o instanceof Rura)) {
            return false;
        }

        Rura param = (Rura) o;
        
        if(!(Math.abs(dlzka - param.dlzka)<0.005)){
            return false;
        }
        
        if(!(Math.abs(hmotnost - param.hmotnost)<0.005)){
            return false;
        }        
        
        if(!evidencneCislo.equals(param.evidencneCislo)){
            return false;
        }
        
        return true;
    }    
    
    public int hashCode(){
        return (int)dlzka * 
                (int)hmotnost *
                evidencneCislo.hashCode();
    }
}