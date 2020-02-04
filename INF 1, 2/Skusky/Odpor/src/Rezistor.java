public class Rezistor {
    private Farba prvy, druhy, nasobic, presnost; // pruzky - farebny kod rezistora

    public Rezistor(Farba prvy, Farba druhy, Farba nasobic, Farba presnost) {
        this.prvy = prvy;
        this.druhy = druhy;
        this.nasobic = nasobic;
        this.presnost = presnost;
    }

    public double getOdpor() {
        return (this.prvy.getHodnota() * 10 + this.druhy.getHodnota()) * (Math.pow(10, this.nasobic.getHodnota()));
    }

    public double getMinimalnyOdpor() {
        return getOdpor() - getOdpor() * this.presnost.getPresnost();
    }

    public double getMaximalnyOdpor() {
        return getOdpor() + getOdpor() * this.presnost.getPresnost();
    }

    public String naformatuj() {
        return this.prvy.getHodnota() + "" + this.druhy.getHodnota() + "x10^" + this.nasobic.getHodnota() + " +/- " + this.presnost.getPresnost() * 100 + "%";
    }
}
