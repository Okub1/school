public class Clanok {

    private String autor;
    private String nazov;

    public Clanok(String autor, String nazov) {
        this.autor = autor;
        this.nazov = nazov;
    }

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public String getNazov() {
        return nazov;
    }

    public void setNazov(String nazov) {
        this.nazov = nazov;
    }

    public String toString() {
        return "Clanok\n\tAutor: " + this.autor + "\n\tNazov: " + this.nazov;
    }
}
