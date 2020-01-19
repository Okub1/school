
package nakladanepolozky;

public class Maslo extends ZjeditelnaPolozka {
    private static final int ENERGIA_NA_KILOGRAM = 31000; //kJ
    private long datumVyroby;

    public Maslo(double hmotnost, long datumVyroby) {
        super(hmotnost);
        this.datumVyroby = datumVyroby;
    }
    
    public Chut getChut(){
       return Chut.SLANA;
   }
   
   @Override
   public boolean jeToCerstve() {
       return ((System.currentTimeMillis() - this.datumVyroby) <= (long)1000*60*60*24*31);
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
       
       if(!(o instanceof Maslo)) {
           return false;
       }

       Maslo param = (Maslo) o;
        
       if(!super.equals(param)){
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
                (int)ENERGIA_NA_KILOGRAM*
                (int)datumVyroby;
    }  
    
    @Override
    public String toString(){
        return "[ Maslo : hmotnost = " + getHmotnost() +
                ", cerstvost = " + (jeToCerstve()?"ano":"nie") +
                ", chut = " + getChut() + 
                ", vyziva = " + getVyziva() + " kJ" +
                " ]";
    }
}
