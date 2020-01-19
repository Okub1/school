public class Kniha extends Publikacia{
    private String autor;
    private String zaner;


    public Kniha(String nazov, int rok) {
        super(nazov, rok);
    }

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public String getZaner() {
        return zaner;
    }

    public void setZaner(String zaner) {
        this.zaner = zaner;
    }

    public String toString() {
        return "Kniha\n\tAutor: " + this.autor + "\n\tZaner: " + this.zaner;
    }
}
