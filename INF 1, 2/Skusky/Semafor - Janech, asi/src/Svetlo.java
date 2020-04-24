public class Svetlo {
    private FarbaSvetla farba;
    private boolean svieti;

    public Svetlo(FarbaSvetla farba) {
        this.farba = farba;
        this.svieti = false;
    }

    public FarbaSvetla getFarba() {
        return farba;
    }

    public void prepni() {
        this.svieti = !this.svieti;
    }

    public String naformatuj() {
        // len detail, ze som to dal malymi pismenami...
        String farba = String.valueOf(this.farba).toLowerCase();

        if (this.svieti) {
            return "<" + farba + ">";
        } else {
            return farba;
        }
    }
}
