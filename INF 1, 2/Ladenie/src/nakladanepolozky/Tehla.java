package nakladanepolozky;

import java.io.Serializable;

public class Tehla implements Nalozitelny, Serializable {
        
    private Material material;
    private double hmotnost;
    private String evidencneCislo;
    
    public Tehla (String evidencneCislo, double hmotnost,  Material material){
    
        if (evidencneCislo == null) {
            evidencneCislo = "";
        }
        
        if (hmotnost == 0) {
            hmotnost = 0.01;
        }
        
       
        
        this.evidencneCislo = evidencneCislo;
        this.hmotnost = hmotnost;
        this.material = material;
        
    }
    
     public String getEvidencneCislo (){
         return evidencneCislo;
    }
    
      public double getHmotnost (){
          return hmotnost;
    }
    
    public Material getMaterial (){
        return this.material;
    }
    
    public String toString () {
        return "[ Tehla : evidencneCislo = " + evidencneCislo + ", hmotnost = " + 
                hmotnost + " kg , material = " + this.material + " ]";
    }
    
    public boolean equals(Object o){
        if(o == null) {
            return false;
        }
        
        if(!(o instanceof Tehla)) {
            return false;
        }

        Tehla param = (Tehla)o;
        
        if(!this.material.equals(param.material)) {
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
        return this.material.hashCode() * 
                (int)hmotnost *
                evidencneCislo.hashCode();
    }
}