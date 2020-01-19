public class Hrac {

    private String nick;
    private int skore = 0;
    private  int pocetZivotov = 15;

    public Hrac(String nick) {
        this.nick = nick;
    }

    public String getNick() {
        return nick;
    }

    public void setNick(String nick) {
        if (nick != null) {
            this.nick = nick;
        }
    }

    public int getSkore() {
        return skore;
    }

    public void setSkore(int skore) {
        this.skore = skore;
    }

    public int getPocetZivotov() {
        return pocetZivotov;
    }

    public void setPocetZivotov(int pocetZivotov) {
        this.pocetZivotov = pocetZivotov;
    }
}
