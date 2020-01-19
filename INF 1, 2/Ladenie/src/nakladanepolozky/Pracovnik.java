package nakladanepolozky;

import java.io.Serializable;


public class Pracovnik implements Nalozitelny, Serializable {
   public static final double MINIMALNA_HMOTNOST = 40;
   public static final int VEK_DOSPELOSTI = 18;
   public static final double MINIMALNA_MZDA = 480;
   private int vek;
   private double vyskaMzdy;
   private double hmotnost;
   private String evidencneCislo;
   
    public Pracovnik (String evidencneCislo, int vek, double vyskaMzdy, double hmotnost) {
        if (evidencneCislo == null) {
            throw new IllegalArgumentException("V konštruktore ste zadali nespravne evidencne cislo pracovnika");
        }
        
        if (vek <= VEK_DOSPELOSTI) {
            throw new IllegalArgumentException("V konštruktore musi byt vek väcsci aspon ako vek dospelosti");
        }

        if (vyskaMzdy < MINIMALNA_MZDA) {
            throw new IllegalArgumentException("Zadali ste vysku mzdy krora je nizsia ako vyska minimalnej mzdy");
        }
        
        if (hmotnost < MINIMALNA_HMOTNOST) {
            throw new IllegalArgumentException("Zadali ste hmotnost ktora je mensia ako minimalna hmotnost");
        }
      
        this.evidencneCislo = evidencneCislo;
        this.vek = vek;
        this.vyskaMzdy = vyskaMzdy;
        this.hmotnost = hmotnost;
    }
    
    public String getEvidencneCislo (){
         return evidencneCislo;
    }
    
    public int getVek() {
        return vek;
    }
    
    public double getVyskaMzdy() {
        return vyskaMzdy;
    }
    
    public void setVyskaMzdy (double novaVyskaMzdy){
        if (novaVyskaMzdy < MINIMALNA_MZDA) {
            throw new IllegalArgumentException("Zadali ste vysku mzdy krora je nizsia ako vyska minimalnej mzdy");
        }
        
        this.vyskaMzdy = novaVyskaMzdy;
    }
    
    public double getHmotnost(){
        return hmotnost;
    }

    @Override
    public String toString () {
        return "[ Pracovnik : evidencneCislo = " + evidencneCislo + ", hmotnost = " 
                + hmotnost + " kg, vek = " + vek + " rokov, vyska mzdy = " + 
                vyskaMzdy + " €]";
    }
    
    @Override
    public boolean equals(Object o){
        if(o == null) {
            return false;
        }
        
        if(!(o instanceof Pracovnik)){
            return false;
        }
        
        Pracovnik param = (Pracovnik)o;
        
        if(!(vek == param.vek)){
            return false;
        }
        
        if(!(VEK_DOSPELOSTI == param.VEK_DOSPELOSTI)) {
            return false;
        }
        
        if(!(Math.abs(vyskaMzdy - param.vyskaMzdy) < 0.005)){
            return false;
        }
        
        if(!(Math.abs(hmotnost - param.hmotnost)<0.005)){
            return false;
        }  
        
        if(!(Math.abs(MINIMALNA_HMOTNOST - param.MINIMALNA_HMOTNOST) < 0.005)) {
            return false;
        }
        
        if(!(Math.abs(MINIMALNA_MZDA - param.MINIMALNA_MZDA) < 0.005)) {
            return false;
        }
        
        if(!evidencneCislo.equals(param.evidencneCislo)){
            return false;
        }
        
        return true;
    }
    
    @Override
    public int hashCode(){
        return (int)vek *
                (int) VEK_DOSPELOSTI *
                (int) MINIMALNA_HMOTNOST *
                (int) MINIMALNA_MZDA *
                (int) vyskaMzdy *
                (int)hmotnost *
                evidencneCislo.hashCode();
    }
}
