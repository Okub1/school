package nakladanepolozky;

public class AgenturnyPracovnik extends Pracovnik {
    private static int STAND_POCET_HODIN_ZA_MESIAC = 210;
    private static int MAX_POCET_NADCASOV_ZA_MESIAC = 7;
    private String nazovAgentury;
    private int minPocetHodinZaMesiac;
    private int maxPocetHodinZaMesiac;
    private int pocetDoterazOdpracovanychHodinZaMesiac;
    
    public AgenturnyPracovnik(String evidencneCislo, int vek, 
              double vyskaMzdy, double hmotnost, String nazovAgentury,
              int minPocetHodinZaMesiac, int maxPocetHodinZaMesiac) {
        super(evidencneCislo, vek, vyskaMzdy, hmotnost);
        
        if (nazovAgentury == null) {
            
            // natovAgentury = "";
           throw new IllegalArgumentException("V konštruktore ste zadali nespravny nazov " + "agentury pre vytvataneho pracovnika");
       }
        this.nazovAgentury = nazovAgentury;
        
        if (minPocetHodinZaMesiac < 0) {
           
           throw new IllegalArgumentException("V konštruktore ste zadali minimalny pocet hodin za mesiac mensi ako 0.");
          
       }
        
        if(minPocetHodinZaMesiac>STAND_POCET_HODIN_ZA_MESIAC+
                    MAX_POCET_NADCASOV_ZA_MESIAC){
           // minPocetHodinZaMesiac = STAND_POCET_HODIN_ZA_MESIAC + 
                 //   MAX_POCET_NADCASOV_ZA_MESIAC;
                 
                 throw new IllegalArgumentException("V konstruktore ste zadali prilis velky minimalny pocet hodin za mesiac");
        }        
        this.minPocetHodinZaMesiac = minPocetHodinZaMesiac;
        
        if(maxPocetHodinZaMesiac<minPocetHodinZaMesiac){
            //maxPocetHodinZaMesiac=minPocetHodinZaMesiac;
            
            throw new IllegalArgumentException("V konstruktore nemoze byt zadany maximalny pocet hodin väcsic ako minimalny pocet hodin");
            
        }
        if(maxPocetHodinZaMesiac>STAND_POCET_HODIN_ZA_MESIAC+
                    MAX_POCET_NADCASOV_ZA_MESIAC){
            //maxPocetHodinZaMesiac = STAND_POCET_HODIN_ZA_MESIAC + 
              //      MAX_POCET_NADCASOV_ZA_MESIAC;
              throw new IllegalArgumentException("V konstruktore ste zadali prilis velky maximalny pocet hodin za mesiac.");
              
        }
        this.maxPocetHodinZaMesiac = maxPocetHodinZaMesiac;
        pocetDoterazOdpracovanychHodinZaMesiac = 0;  
    }
    
    public int getMaxPocetHodinZaMesiac(){
        return maxPocetHodinZaMesiac;
    }
    
    public int getMinPocetHodinZaMesiac(){
        return minPocetHodinZaMesiac;
    }
    
    public boolean pridajOdpracovaneHodiny(int hodiny){
        if(hodiny<=0){
            return false;
        }
        
        if(pocetDoterazOdpracovanychHodinZaMesiac + hodiny > 
                maxPocetHodinZaMesiac){
            return false;
        }
        
        pocetDoterazOdpracovanychHodinZaMesiac += hodiny;
        return true;
    }
    
    public int getPocetDoterazOdpracovanychHodinZaMesiac(){
        return pocetDoterazOdpracovanychHodinZaMesiac;
    }
    
    @Override
    public double getVyskaMzdy() {
        double mzdaZaHodinu = super.getVyskaMzdy()/(double)STAND_POCET_HODIN_ZA_MESIAC;
        return mzdaZaHodinu*pocetDoterazOdpracovanychHodinZaMesiac;
    }
    
    @Override
    public String toString()
    {
        /*
        return super.toString() + "[ nazov agentury = " + nazovAgentury +
                ", min. pocet hod/mesiac = " + minPocetHodinZaMesiac +
                ", max. pocet hod/mesiac = " + maxPocetHodinZaMesiac +
                ", pocet doteraz odpracovanych hodin/mesiac = " +
                pocetDoterazOdpracovanychHodinZaMesiac + "]";
        */
        
        return "[ Agenturny pracovnik : evidencneCislo = " + getEvidencneCislo() + ", hmotnost = " 
                + getHmotnost() + " kg, vek = " + getVek() + " rokov, vyska mzdy = " + 
                getVyskaMzdy() + " €" + ", nazov agentury = " + nazovAgentury +
                ", min. pocet hod/mesiac = " + minPocetHodinZaMesiac +
                ", max. pocet hod/mesiac = " + maxPocetHodinZaMesiac +
                ", pocet doteraz odpracovanych hodin/mesiac = " +
                pocetDoterazOdpracovanychHodinZaMesiac + "]";
    }
    
    
    @Override
    public int hashCode(){
        return super.hashCode()*
                (int)STAND_POCET_HODIN_ZA_MESIAC*
                (int)MAX_POCET_NADCASOV_ZA_MESIAC*
                nazovAgentury.hashCode()*
                (int)maxPocetHodinZaMesiac*
                (int)minPocetHodinZaMesiac*
                (int)pocetDoterazOdpracovanychHodinZaMesiac;
        
    }  
    
    @Override
    public boolean equals(Object o){
        if(o == null) {
            return false;
        }
        
        if(!(o instanceof AgenturnyPracovnik)){
            return false;
        }
        
        AgenturnyPracovnik param = (AgenturnyPracovnik)o;
        
        if(!super.equals(param)){
            return false;
        }
        
        if(STAND_POCET_HODIN_ZA_MESIAC != param.STAND_POCET_HODIN_ZA_MESIAC){
            return false;
        }
        
        if(MAX_POCET_NADCASOV_ZA_MESIAC != param.MAX_POCET_NADCASOV_ZA_MESIAC){
            return false;
        }
    
        if(!nazovAgentury.equals(param.nazovAgentury)){
            return false;
        }
        
        if(maxPocetHodinZaMesiac != param.maxPocetHodinZaMesiac){
            return false;
        }
        
        if(minPocetHodinZaMesiac != param.minPocetHodinZaMesiac){
            return false;
        }
        
        if(pocetDoterazOdpracovanychHodinZaMesiac != param.pocetDoterazOdpracovanychHodinZaMesiac){
            return false;
        }
        
        return true;
    }
    
    
}
