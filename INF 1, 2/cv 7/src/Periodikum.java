import java.util.ArrayList;

public class Periodikum extends Publikacia{
    private String vydavatel;
    private Clanok [] clanky;

    public Periodikum(String nazov, int rok, int velkost) {
        super(nazov, rok);
        this.clanky = new Clanok[velkost];
    }

    public String getVydavatel() {
        return vydavatel;
    }

    public void setVydavatel(String vydavatel) {
        this.vydavatel = vydavatel;
    }

    public Clanok[] getClanky() {
        return clanky;
    }

    public void setClanky(Clanok[] clanky) {
        this.clanky = clanky;
    }

    public Clanok[] najdi(String paAutor) {
        ArrayList<Clanok> clankyAutora = new ArrayList<>();
        for (Clanok aClanky : this.clanky) {
            if (aClanky.getAutor().equals(paAutor)) {
                clankyAutora.add(aClanky);
            }
        }
        return (Clanok[]) clankyAutora.toArray();
    }

    public String toString() {
        StringBuilder pom = new StringBuilder("Periodikum\n\tVydavatel: " + this.vydavatel);

        for (Clanok aClanky : this.clanky) {
            pom.append(aClanky.toString());
        }

        return pom.toString();
    }
}
