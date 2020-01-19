package nakladanepolozky;

public class Pomaranc extends ZjeditelnaPolozka implements Nalozitelny {
    private String evidencneCislo;
    private static final int ENERGIA_NA_KILOGRAM = 2080; //kJ
    private long datumVyroby;        
    
    public Pomaranc(String evidencnceCislo, double hmotnost, long datumVyroby) {
        super(hmotnost);
        this.evidencneCislo = evidencnceCislo;
        this.datumVyroby = datumVyroby;
    }
    
    @Override
    public String getEvidencneCislo(){
        return evidencneCislo;
    }
   
   @Override 
   public Chut getChut(){
       return Chut.KYSLA;
   }
   
   @Override
   public boolean jeToCerstve() {
       return ((System.currentTimeMillis() - this.datumVyroby) <= (long)183 * 24 * 3600 * 1000);
   }
   
   @Override
   public double getVyziva(){
       return ENERGIA_NA_KILOGRAM*getHmotnost();
   }   
   
   @Override
   public boolean equals(Object o){
       if(o == null) {
           return false;
       }
       
       if(!(o instanceof Pomaranc)) {
           return false;
       }

       Pomaranc param = (Pomaranc) o;
        
       if(!super.equals(param)){
           return false;
       }
       
       if(!evidencneCislo.equals(param.evidencneCislo)){
           return false;
       }
       
       if(ENERGIA_NA_KILOGRAM != param.ENERGIA_NA_KILOGRAM){
           return false;
       }
       
       if(datumVyroby != param.datumVyroby){
           return false;
       }
        
       return true;                            
    } 
   
    @Override
    public int hashCode(){
        return super.hashCode()*
                evidencneCislo.hashCode()*
                (int)ENERGIA_NA_KILOGRAM*
                (int)datumVyroby;
    }   
   
    @Override
    public String toString(){
        return "[ Pomaranc : " + "evidencne cislo = " + evidencneCislo +
                ", hmotnost = " + getHmotnost() +
                ", cerstvost = " + (jeToCerstve()?"ano":"nie") +
                ", chut = " + getChut() + 
                ", vyziva = " + getVyziva() + " kJ" +
                " ]";
    }
}
