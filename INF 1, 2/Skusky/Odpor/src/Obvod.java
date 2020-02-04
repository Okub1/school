import java.util.ArrayList;

public class Obvod {
    private TypObvodu typObvodu;
    private ArrayList<Rezistor> suciastky;

    public Obvod(TypObvodu typObvodu) {
        this.typObvodu = typObvodu;
        this.suciastky = new ArrayList<>();
    }

    public void pridajSuciastku(Rezistor suciastka) {
        this.suciastky.add(suciastka);
    }

    public void vypisObvod() {
        String pom = "";
        if (this.typObvodu == TypObvodu.SERIOVY) {
            pom = "Seriove zapojenie\n";
        } else {
            pom = "Paralelne zapojenie\n";
        }

        for (Rezistor rezistor : this.suciastky) {
            pom += rezistor.naformatuj() + "\n";
        }

        pom += "Celkovy odpor: " + getCelkovyOdpor();

        System.out.println(pom + "\n");
    }

    public double getCelkovyOdpor() {
        double pom = 0.0;
        if (this.typObvodu == TypObvodu.SERIOVY) {
            for (Rezistor rezistor : this.suciastky) {
                pom += rezistor.getOdpor();
            }
        } else {
            for (Rezistor rezistor : this.suciastky) {
                pom += 1 / rezistor.getOdpor();
            }

            pom = 1 / pom;
        }

        return pom;
    }
}
