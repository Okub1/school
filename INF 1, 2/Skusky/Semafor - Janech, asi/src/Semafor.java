import java.util.ArrayList;

public class Semafor {
    private Svetlo[] svetla;
    private int dlzkaCyklu;
    private int krok;
    private boolean zapnuty;
    private ArrayList<Prikaz> prikazy;

    public Semafor(FarbaSvetla[] farby, int dlzkaCyklu) {
        this.svetla = new Svetlo[farby.length];

        for (int i = 0; i < this.svetla.length; i++) {
            this.svetla[i] = new Svetlo(farby[i]);
        }

        this.dlzkaCyklu = dlzkaCyklu;
        this.zapnuty = false;
        this.prikazy = new ArrayList<>(dlzkaCyklu);
    }

    public void pridajPrikaz(Prikaz prikaz) {
        if (!this.zapnuty) {
            this.prikazy.add(prikaz);
        }
    }

    public void spusti() {
        if (!this.zapnuty) {
            this.zapnuty = true;
            this.krok = 0;
            this.prikazy.get(this.krok).maSaVykonat(this.krok);
        }
    }

    public void krok() {

    }

    public String naformatuj() {
        String string = "[ ";
        for (int i = 0; i < this.svetla.length; i++) {

        }
    }
}
