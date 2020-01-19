
package nakladanepolozky;

import java.io.Serializable;

public enum Chut implements Serializable{
    SLADKA("sladka"),
    SLANA("slana"),
    HORKA("horka"),
    KYSLA("kysla"),
    KURACORYBIA("kuracorybia");
    private String chut;
    
    Chut(String chut){
        this.chut = chut;
    
    }
    
    public String toString() {
        return this.chut;  
    }
    //hashCode() sa neda vytvorit a ani ho nemusime tvorit
    //ale pouzivame ho
}
