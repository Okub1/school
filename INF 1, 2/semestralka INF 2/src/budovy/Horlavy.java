package budovy;

/**
 * Interface ktory implementuju vsetky budovy, ktore mozu zhoriet.
 */
public interface Horlavy {

    double getVyskaBudovy();
    void setVyskaBudovy(double vyskaBudovy);
    double getSirkaBudovy();
    void setSirkaBudovy(double sirkaBudovy);
    double getDlzkaBudovy();
    void setDlzkaBudovy(double dlzkaBudovy);
    StavBudovy getStav();
    void setStav(StavBudovy stav);
    String toString();
}
