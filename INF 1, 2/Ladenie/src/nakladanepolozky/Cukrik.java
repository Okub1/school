package nakladanepolozky;

import java.io.*;
import java.util.Scanner;

public class Cukrik implements Nalozitelny, Zjeditelny, Serializable {
    private String evidencneCislo;
    private double hmotnost;
    private PrichutCukrika prichut;
    private static final int ENERGIA_NA_JEDNOTKU = 23005; //v kJ
    private long casVyroby;
    
    public Cukrik (String evidencneCislo, double hmotnost, PrichutCukrika prichut, 
                long casVyroby){
    
        if (evidencneCislo == null) {
            evidencneCislo = "";
        }
        
        if (prichut == null) {
            prichut = PrichutCukrika.JAHODOVA;
        }
        
        if (hmotnost == 0) {
            hmotnost = 0.01;
        }
        
       
        
        this.evidencneCislo = evidencneCislo;
        this.hmotnost = hmotnost;
        this.prichut = prichut;
        this.casVyroby = casVyroby;
        
    }
    
    public Cukrik (String nazovSuboru) throws IOException {
        File prud = new File(nazovSuboru);
        Scanner subor = new Scanner(prud);
        
        String typSuboru = subor.nextLine().trim();
        if (typSuboru.equals("Cukrik")) {
            String verziaSuboru = subor.nextLine().trim();
            if(verziaSuboru.equals("0.0.1")) {
                evidencneCislo = subor.nextLine().trim();
                hmotnost = Double.parseDouble(subor.nextLine().trim());
                String prichutPom = subor.nextLine().trim();
                /*switch (prichutPom) {
                
                  case "jahodova":{
                      prichut = PrichutCukrika.JAHODOVA;
                      break;
                    }
                  
                  case "mentolova": {
                      prichut = PrichutCukrika.MENTOLOVA;
                              break;
                  }
                  
                  default: {
                      throw new IOException("Subor s cukrikom nepodporuje prichut cukrika");
                      
                  }
                    
                 }   
                */
                PrichutCukrika[] prichute = PrichutCukrika.values();
                boolean prichutExistuje = false;
                for (PrichutCukrika p : prichute) {
                    if(p.toString().equals(prichutPom)) {
                        prichutExistuje = true;
                        this.prichut = p;
                    }
                }
                
                if(!prichutExistuje) {
                    throw new IOException("Subor s cukrikom nepodporuje prichut cukrika");
                }
                
               casVyroby = subor.nextLong();
            
        } else {
            throw new IOException("V danem subore nie je nacitany Cukrik");
        }
            subor.close();
    }
    }
    
    public String getEvidencneCislo() {
        return this.evidencneCislo;
    }
    
    public double getHmotnost() {
        return this.hmotnost;
    }
    
    public double getVyziva() {
        return (this.hmotnost * ENERGIA_NA_JEDNOTKU);
    }
    
    public Chut getChut() {
        return Chut.SLADKA;
    }
    
    public boolean jeToCerstve() {
        return ((System.currentTimeMillis() - this.casVyroby) <= (long)365 * 24 * 3600 * 1000);
    }
    
    public String toString() {
        String cerstvost = "";
        if (jeToCerstve()) {
            cerstvost = "cerstve";
        } else {
            cerstvost = "necerstve";
        }
        String vypis = "[ Cukrik : evidencne cislo = " + this.evidencneCislo + ", hmotnost = " + 
                this.hmotnost + " kg, prichut = " + 
                getChut() + ", podchut = " + this.prichut + 
                ", cerstvost = " + cerstvost + ", vyziva = " + getVyziva() + " ]";
        
        return vypis;
    }
    
    public boolean equals(Object o){
        if(o == null) {
            return false;
        }
        
        if(!(o instanceof Cukrik)) {
            return false;
        }

        Cukrik param = (Cukrik) o;
        
        if(!this.prichut.equals(param.prichut)) {
            return false;
        }
        
        if (this.ENERGIA_NA_JEDNOTKU != param.ENERGIA_NA_JEDNOTKU) {
            return false;
        }
        
        if (this.casVyroby != param.casVyroby) {
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
        return this.prichut.hashCode() * 
                (int)this.hmotnost *
                     this.evidencneCislo.hashCode() *
                (int)this.ENERGIA_NA_JEDNOTKU *
                (int)this.casVyroby;
    }      
    
    public boolean ulozDoSuboru(String nazovSuboru) {
        boolean vysl = false;
        
        try {
        File prud = new File(nazovSuboru);
        PrintWriter subor = new PrintWriter(prud);
        subor.println("Cukrik");
        subor.println("0.0.1");
        subor.println(evidencneCislo);
        subor.println(hmotnost);
        subor.println(prichut.toString());
        subor.println(casVyroby);
        subor.close();
        vysl = true;
        } catch (IOException suborE) {
            suborE.printStackTrace();
        }
        return vysl;
    }
    
 
}
