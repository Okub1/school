package nakladanepolozky;

import java.io.DataOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.Serializable;

public class Krokodil implements Nalozitelny, Zjeditelny, Serializable {
    private int pocetZubov;
    private double hmotnost;
    private String evidencneCislo;
    private StavKrokodila stavKrokodila;
    
    private static final int ENERGIA_NA_JEDNOTKU = 6149;
    
    public Krokodil (String evidencneCislo, int pocetZubov, double hmotnost, StavKrokodila stavKrokodila) {
        if (evidencneCislo == null) {
            evidencneCislo = "";
        }
        
        if (hmotnost == 0) {
            hmotnost = 0.01;
        }
        
        if (pocetZubov < 0 ) {
            pocetZubov = 0;
        }
        else if (pocetZubov > 50) {
            pocetZubov = 50;
        }
        
        this.evidencneCislo = evidencneCislo;
        this.hmotnost = hmotnost;
        this.pocetZubov = pocetZubov;
        this.stavKrokodila = stavKrokodila;
    }
    
    public boolean ulozDoSuboru(String nazovSuboru) {
        boolean vysl = false;
        
        try {
            File subor = new File(nazovSuboru);
            FileOutputStream prud = new FileOutputStream(subor);
            DataOutputStream zapisovac = new DataOutputStream(prud);
            
            zapisovac.writeUTF("Krokodil");
            zapisovac.writeUTF("0.0.1");
            zapisovac.writeUTF(evidencneCislo);
            zapisovac.writeDouble(hmotnost);
            zapisovac.writeInt(pocetZubov);
            zapisovac.writeUTF(stavKrokodila.toString());
            
            zapisovac.close();
            
            vysl = true;
            
        } catch (IOException suborE) {
            
            
            
        }
        
        return vysl;
        
    }
    
     public String getEvidencneCislo () {
         return evidencneCislo;
    }
    
     public double getHmotnost () {
          return hmotnost;
    }
    
    public double getPocetZubov () {
          return pocetZubov; 
    }
    
    public void setPocetZubov (int novyPocet) {
          this.pocetZubov = novyPocet;
          
          if (pocetZubov < 0 ) {
            pocetZubov = 0;
        }
        else if (pocetZubov > 50) {
            pocetZubov = 50;
        }
    }
    
    public Chut getChut() {      
        return Chut.KURACORYBIA;       
    }
    
    public boolean jeToCerstve() {
        if(stavKrokodila.equals(StavKrokodila.ZIVY) || stavKrokodila.equals(StavKrokodila.ZMRAZENY)) {
            return true;
        } 
        return false;
    }
    
    public double getVyziva() {
        return this.hmotnost * ENERGIA_NA_JEDNOTKU;
    }

    public String toString () {
        String cerstvost = "";
        if (jeToCerstve()) {
            cerstvost = "cerstve";
        } else {
            cerstvost = "necerstve";
        }
        return "[ Krokodil : evidencneCislo = " + evidencneCislo + ", hmotnost = " 
                + hmotnost + " kg , pocet zubov = " + pocetZubov + ", chut = " + getChut() + ", vyziva = " + getVyziva() + ", cerstvost = " + cerstvost + " ] ";
    }  
    
    public boolean equals(Object o){
        if(o == null) {
            return false;
        }
        
        if(!(o instanceof Krokodil)){
            return false;
        }
        
        Krokodil param = (Krokodil)o;
        
        if(!(pocetZubov == param.pocetZubov)){
            return false;
        }
        
        if(!(Math.abs(hmotnost - param.hmotnost)<0.005)){
            return false;
       
        }   
        
        if(!this.stavKrokodila.equals(param.stavKrokodila)) {
            return false;
        }
        
        if (this.ENERGIA_NA_JEDNOTKU != param.ENERGIA_NA_JEDNOTKU) {
            return false;
        }
        
        if(!evidencneCislo.equals(param.evidencneCislo)){
            return false;
        }
        
        return true;
    }
    
    public int hashCode(){
        return (int)pocetZubov *
                (int)hmotnost *
                evidencneCislo.hashCode() *
                stavKrokodila.hashCode() *
                (int)this.ENERGIA_NA_JEDNOTKU;
    }
}
