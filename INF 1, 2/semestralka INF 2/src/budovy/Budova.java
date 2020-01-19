package budovy;

/**
 * Abstraktná trieda ako návrh pre budovy.
 */
public abstract class Budova implements Horlavy {
//    private double vyskaBudovy;
//    private double sirkaBudovy;
//    private double dlzkaBudovy;
//    private StavBudovy stavBudovy;


    public abstract double getVyskaBudovy();
    public abstract void setVyskaBudovy(double vyskaBudovy);
    public abstract double getSirkaBudovy();
    public abstract void setSirkaBudovy(double sirkaBudovy);
    public abstract double getDlzkaBudovy();
    public abstract void setDlzkaBudovy(double dlzkaBudovy);
    public abstract StavBudovy getStav();
    public abstract void setStav(StavBudovy stav);
    public abstract String toString();
}
