package budovy;

import exceptions.MiestoJeObsadeneException;
import exceptions.ZlyParameterException;
import vozidla.HasicskeAuto;
import vozidla.Vozidlo;

/**
 * Trieda garaz.
 */
public class Garaz extends Budova {
    /**
     * Atribut, ktory nam definuje vysku budovy.
     */
    private double vyskaBudovy;
    /**
     * Atribut, ktory nam definuje sirku budovy.
     */
    private double sirkaBudovy;
    /**
     * Atribut, ktory nam definuje dlzku budovy.
     */
    private double dlzkaBudovy;
    /**
     * Atribut, ktory nam definuje stav budovy.
     */
    private StavBudovy stavBudovy;
    /*
      Atribut, ktory nam definuje velkost garaze.
     */
//    private int velkostGaraze;
    /**
     * Inicializácia poľa miest v garáži.
     */
    private Miesto[] garaz;

    /**
     * Konstuktor garaze, skontroluje vsetky zadane paremetre, a v pripade chybneho parametra, vyhodi chybu.
     * Vytvori pole miest v garazi, do ktorych sa moze parkovat.
     *
     * @param vyskaBudovy vyska budovy
     * @param sirkaBudovy sirka budovy
     * @param dlzkaBudovy dlzka budovy
     * @param velkostGaraze velkost garaze
     * @throws ZlyParameterException vynimka v pripade zleho parametra.
     */
    public Garaz(
            final double vyskaBudovy,
            final double sirkaBudovy,
            final double dlzkaBudovy,
            final int velkostGaraze) throws ZlyParameterException {
        if (vyskaBudovy >= 0) {
            this.vyskaBudovy = vyskaBudovy;
        } else {
            throw new ZlyParameterException("Zla vyska budovy: " + vyskaBudovy);
        }

        if (sirkaBudovy >= 0) {
            this.sirkaBudovy = sirkaBudovy;
        } else {
            throw new ZlyParameterException("Zla sirka budovy: " + sirkaBudovy);
        }

        if (dlzkaBudovy >= 0) {
            this.dlzkaBudovy = dlzkaBudovy;
        } else {
            throw new ZlyParameterException("Zla dlzka budovy: " + dlzkaBudovy);
        }

//        if (velkostGaraze > 0) {
//            this.velkostGaraze = velkostGaraze;
//        } else {
//            throw new ZlyParameterException(
//                    "Zla velkost garaze: " + velkostGaraze);
//        }

        this.stavBudovy = StavBudovy.NEHORI;

        this.garaz = new Miesto[velkostGaraze];
        for (int i = 0; i < this.garaz.length; i++) {
            this.garaz[i] = new Miesto();
        }
    }

    /**
     * Metoda na pridavanie aut do garaze podla objektu a miesta v garazi.
     *
     * @param auto pridavane auto
     * @param miesto miesto v garazi
     * @throws MiestoJeObsadeneException vynimka v pripade obsadeneho miesta.
     */
    public void pridajDoGaraze(HasicskeAuto auto, int miesto)
            throws MiestoJeObsadeneException {
        if (this.garaz[miesto].isMiestoVolne()) {
            this.garaz[miesto].pridajVozidlo(auto);
        } else {
            throw new MiestoJeObsadeneException(
                    "V garazi uz sa dane auto nachadza alebo uz nie je miesto v garazi...");
        }
    }

    /**
     * Metoda na odoberanie vozidiel z garaze, odobera vozidla na zaklade SPZ.
     *
     * @param spz spz vozidla
     */
    public void odoberZGaraze(String spz) {
        for (Miesto aGaraz : this.garaz) {
            if (aGaraz.getSPZVozidla().equals(spz)) {
                aGaraz.odoberAuto();
            }
        }
    }

    /**
     * Metoda na ziskanie vysky budovy.
     *
     * @return vrati vysku budovy.
     */
    @Override
    public double getVyskaBudovy() {
        return this.vyskaBudovy;
    }

    /**
     * Metoda na nastevnie vysky budovy.
     *
     * @param vyskaBudovy vyska budovy
     */
    @Override
    public void setVyskaBudovy(double vyskaBudovy) {
        if (vyskaBudovy >= 0) {
            this.vyskaBudovy = vyskaBudovy;
        } else {
            this.vyskaBudovy = 0.01;
        }
    }

    /**
     * Metoda na ziskanie sirky budovy.
     *
     * @return vrati sirku budovy.
     */
    @Override
    public double getSirkaBudovy() {
        return this.sirkaBudovy;
    }

    /**
     * Metoda na nastavenie sirky budovy.
     *
     * @param sirkaBudovy sirka budovy.
     */
    @Override
    public void setSirkaBudovy(double sirkaBudovy) {
        if (sirkaBudovy >= 0) {
            this.sirkaBudovy = sirkaBudovy;
        } else {
            this.sirkaBudovy = 0.01;
        }
    }

    /**
     * Metoda na ziskanie dlzky budovy.
     *
     * @return vrati dlzku budovy.
     */
    @Override
    public double getDlzkaBudovy() {
        return this.dlzkaBudovy;
    }

    /**
     * Metoda na nastavenie dlzky budovy.
     *
     * @param dlzkaBudovy dlzka budovy.
     */
    @Override
    public void setDlzkaBudovy(double dlzkaBudovy) {
        if (dlzkaBudovy >= 0) {
            this.dlzkaBudovy = dlzkaBudovy;
        } else {
            this.dlzkaBudovy = 0.01;
        }
    }

    /**
     * Metoda na ziskanie stav budovy.
     *
     * @return vrati stav budovy.
     */
    @Override
    public StavBudovy getStav() {
        return this.stavBudovy;
    }


    /**
     * Metoda na nastavenie stavu budovy, ci hori, alebo nehori alebo je zhorena.
     *
     * @param stav stav budovy.
     */
    @Override
    public void setStav(StavBudovy stav) {
        this.stavBudovy = stav;
    }

    /**
     * Metoda na vypisanie vsetkych udajov do textoveho retazca.
     *
     * @return vrati retazec so vsetkymi informaciami o budove
     */
    @Override
    public String toString() {
        StringBuilder pom = new StringBuilder("\n\nGaraz\n\tVyska: \t\t\t" + this.vyskaBudovy
                + "\n\tSirka: \t\t\t" + this.sirkaBudovy
                + "\n\tDlzka: \t\t\t" + this.dlzkaBudovy
                + "\n\tStav: \t\t\t" + this.stavBudovy);

        pom.append("\n\nMiesta v garazi: ");

        for (int i = 0; i < this.garaz.length; i++) {
            pom.append("\nMiesto ").append(i + 1).append(":");
            pom.append(this.garaz[i].toString());
            pom.append("\n-------------------------------");
        }

//        for (Miesto aGaraz : this.garaz) {
//            pom.append(aGaraz.toString());
//        }
        return pom.toString();
    }
}

/**
 * Trieda miesto v garazi.
 */
class Miesto {
    /**
     * Atribut, ktory nam urcuje ci je miesto volne alebo nie.
     */
    private boolean volne = true;
    /**
     * Atribut, ktory nam urcuje, ake vozidlo je na danom mieste.
     */
    private Vozidlo voz;

    /**
     * Metoda na pridavanie vozidiel na dane miesto.
     * Vozidla sa pridavaju na zaklade objektov HasicskeAuto.
     *
     * @param auto auto ktore chceme pridat.
     */
    public void pridajVozidlo(HasicskeAuto auto) {
        if (this.volne) {
            this.voz = auto;
            this.volne = false;
        }
    }

    /**
     * Metoda na odoberanie aut z daneho miesta.
     */
    public void odoberAuto() {
        this.volne = true;
        this.voz = null;
    }

    /**
     * Metoda na vracanie SPZ vozidla z daneho miesta.
     *
     * @return vrati SPZ vozidla na danom mieste.
     */
    public String getSPZVozidla() {
        return this.voz.getSpz();
    }

    /**
     * Metoda na vracanie stavu miesta, ci je obsadene alebo nie.
     *
     * @return stav miesta.
     */
    public boolean isMiestoVolne() {
        return this.volne;
    }

    /**
     * Metoda na vypisanie vsetkych informacii o mieste v retazci.
     *
     * @return vrati informacie o mieste v retazci.
     */
    public String toString() {
        String volneString;

        if (this.volne) {
            volneString = "ano";
        } else {
            volneString = "nie";
        }

        String pom = "\n-------------------------------";
        if (this.voz == null) {
            pom += "\n\t   Miesto je prazdne\n-------------------------------";
            return pom ;
        } else {
            return "\n-------------------------------\t" + "\n\tVolne? : " + volneString + this.voz.toString();
        }
    }
}
