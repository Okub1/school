public class Prikaz {
    private int casSpustenia = -1;
    private Svetlo svetlo;

    public Prikaz(FarbaSvetla farbaNaPrepnutie) {
        this.svetlo = new Svetlo(farbaNaPrepnutie);
        this.svetlo.prepni();
    }

    public Prikaz(int casSpustenia, FarbaSvetla farbaNaPrepnutie) {
        this.casSpustenia = casSpustenia;
        this.svetlo = new Svetlo(farbaNaPrepnutie);
        //TODO vytvori prikaz, ktory ma prepnut svetlo so zadanou farbou v zadanom kroku cyklu
        // this.svetlo.prepni();
    }

    public boolean maSaVykonat(int aktualnyKrok) {
        return this.casSpustenia == aktualnyKrok;
    }

    public boolean jeInicializovany() {
        return this.casSpustenia >= 0; // TODO not sure ci to ma takto byt
    }

    public boolean platiPre(FarbaSvetla farba) {
        return this.svetlo.getFarba() == farba;
    }
}
