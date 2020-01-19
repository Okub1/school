package nakladanepolozky;

import java.io.Serializable;

public abstract class ZjeditelnaPolozka implements Serializable {
   private double hmotnost;
   
   public ZjeditelnaPolozka(double hmotnost){
       this.hmotnost = hmotnost;
   }
   
   public double getHmotnost() {
       return hmotnost;
   }
   
   public abstract Chut getChut();
   
   public abstract boolean jeToCerstve();
   
   public abstract double getVyziva();
   
   @Override
   public boolean equals(Object o){
       if(o == null) {
           return false;
       }
       
       if(!(o instanceof ZjeditelnaPolozka)) {
           return false;
       }

       ZjeditelnaPolozka param = (ZjeditelnaPolozka) o;
        
       if(Math.abs(hmotnost - param.hmotnost)>0.005){
           return false;
       }
        
       return true;                            
    }   
   
    @Override
    public int hashCode(){
        return (int)hmotnost;
    }
    
    @Override
    public String toString() {
        return "[ Zjeditelna polozka : hmotnost = " + hmotnost + "]";
    }
}
