
package nakladanepolozky;

import java.io.Serializable;

public enum StavKrokodila implements Serializable{
    ZIVY("zivy"),
    ZMRAZENY("zmrazeny"),
    ZDOCHNUTY("zdochnuty");
    
    private String stav;
    
    StavKrokodila(String stav){
        this.stav = stav;
    
    }
    
    public String toString() {
        return this.stav;  
    }
            
}
