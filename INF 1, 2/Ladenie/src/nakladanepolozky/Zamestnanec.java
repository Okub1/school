
package nakladanepolozky;

public class Zamestnanec extends Pracovnik{
    private String nazovFirmy;
    private boolean clenOdborov;
    private int nevycerpaneDniDovolenky;
    
    public Zamestnanec(String evidencneCislo, int vek, double vyskaMzdy,
            double hmotnost, String nazovFirmy) {
        super(evidencneCislo, vek, vyskaMzdy, hmotnost);
        
        if (nazovFirmy == null) {
            nazovFirmy = "";
        }
        
        this.nazovFirmy = nazovFirmy;
        this.clenOdborov = false;
        
        if (getVek() < 33) {
            this.nevycerpaneDniDovolenky = 20;
        } else {
            this.nevycerpaneDniDovolenky = 25;
        }
      
    }
    
    public String getNazovFirmy() {
        return this.nazovFirmy;
    }
    
    public boolean getClenOdborov() {
        return this.clenOdborov;
    }
    
    public void setClenOdborov(boolean clen) {
        this.clenOdborov = clen;
    }
    
    public boolean zoberDovolenku(int pocetDni) {
        
        if (pocetDni < 1 || pocetDni > this.nevycerpaneDniDovolenky) {
            return false;
        }
        
        this.nevycerpaneDniDovolenky -= pocetDni;
        return true;
    }
    
    public int getNevycerpaneDniDovolenky() {
        return this.nevycerpaneDniDovolenky;
    }
    
    @Override
    public String toString () {
        return "[ Zamestnanec : evidencneCislo = " + getEvidencneCislo()
                + ", hmotnost = " + getHmotnost() + " kg, vek = " + getVek() 
                + " rokov, vyska mzdy = " + getVyskaMzdy() + " €"
                + ", nazov firmy = " + this.nazovFirmy
                + ", nevycerpane dni dovolenky = " + this.nevycerpaneDniDovolenky
                + ", clen odborov = " + (this.clenOdborov?"áno":"nie") + "]";
    }
    
    @Override
    public int hashCode(){
        return super.hashCode()
                * this.nazovFirmy.hashCode()
                * (int)this.nevycerpaneDniDovolenky
                * (this.clenOdborov?1:2);
    }
    
    @Override
    public boolean equals(Object o){
        if(o == null) {
            return false;
        }
        
        if(!(o instanceof Zamestnanec)){
            return false;
        }
        
        Zamestnanec param = (Zamestnanec)o;
        
        if (!super.equals(param)) {
            return false;
        }
        
        if (!this.nazovFirmy.equals(param.nazovFirmy)) {
            return false;
        }
        
        if (this.clenOdborov != param.clenOdborov) {
            return false;
        }
        
        if (this.nevycerpaneDniDovolenky != param.nevycerpaneDniDovolenky) {
            return false;
        }
        
        return true;
    }
}
