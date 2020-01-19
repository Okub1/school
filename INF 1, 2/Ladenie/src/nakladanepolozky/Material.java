
package nakladanepolozky;

import java.io.Serializable;

public enum Material implements Serializable {
    PALENA("palena"),
    HLINENA("hlinena"),
    BETONOVA("betonova");
    private String material;
    
    Material(String material){
        this.material = material;
    
    }
    
    public String toString() {
        return this.material;  
    }
    //hashCode() sa neda vytvorit a ani ho nemusime tvorit
    //ale pouzivame ho
}
