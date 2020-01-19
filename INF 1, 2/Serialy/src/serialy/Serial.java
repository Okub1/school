package serialy;

public class Serial {
    private String nazov;
    private String tvorca;
    private int pocetEpizod;
    private int hodnotenie;

    public Serial(String nazov, String tvorca, int pocetEpizod, int hodnotenie) {
        this.nazov = nazov;
        this.tvorca = tvorca;
        this.pocetEpizod = pocetEpizod;
        this.hodnotenie = hodnotenie;
    }

    public String getNazov() {
        return this.nazov;
    }

    public void setNazov(String nazov) {
        this.nazov = nazov;
    }

    public String getTvorca() {
        return this.tvorca;
    }

    public void setTvorca(String tvorca) {
        this.tvorca = tvorca;
    }

    public int getPocetEpizod() {
        return this.pocetEpizod;
    }

    public void setPocetEpizod(int pocetEpizod) {
        this.pocetEpizod = pocetEpizod;
    }

    public int getHodnotenie() {
        return hodnotenie;
    }

    public void setHodnotenie(int hodnotenie) {
        this.hodnotenie = hodnotenie;
    }
}