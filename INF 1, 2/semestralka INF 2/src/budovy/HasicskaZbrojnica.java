package budovy;

import exceptions.MiestoJeObsadeneException;
import exceptions.ZlyParameterException;
import osoby.Nalozitelny;
import vozidla.HasicskeAuto;

import java.util.HashMap;

/**
 * Tieda HasicskaZbrojnica ktora nam definuje hasicsku zbrojnicu.
 *
 * @param <E> parameter, co vsetko mozeme nakladat do hasicskej zbrojnice,
 *           nalozit mozeme len objekty ktore implementuju interface Nalozitelny.
 */
public class HasicskaZbrojnica<E extends Nalozitelny> extends Budova {
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
    /**
     * Atribut, ktory nam definuje kapacitu zbrojnice.
     */
    private int kapacita;
    /**
     * Atribut, ktory nam definuje velkost garaze zbrojnice.
     */
    private int velkostGaraze;
    /**
     * Inicializácia garaze.
     */
    private Garaz garaz;
    /**
     * Inicializácia kontajnera pre hasicov a jeho nasledne vytvorenie.
     */
    private HashMap<String, E> hasici = new HashMap<>();


    /**
     * Konstruktor hasicskejZbrojnice, kontroluje zadane parametre, a ak najde chybu, vyhodi vynimku.
     *
     * @param vyskaBudovy vyska budovy.
     * @param sirkaBudovy sirka budovy.
     * @param dlzkaBudovy dlzka budovy.
     * @param kapacita kapacita budovy.
     * @param velkostGaraze velkost garaze.
     * @throws ZlyParameterException vynimka v pripade zleho parametra.
     */
    public HasicskaZbrojnica(double vyskaBudovy, double sirkaBudovy, double dlzkaBudovy, int kapacita, int velkostGaraze) throws ZlyParameterException {
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

        if (kapacita >= 0) {
            this.kapacita = kapacita;
        } else {
            throw new ZlyParameterException("Zla kapacita budovy: " + kapacita);
        }

        this.stavBudovy = StavBudovy.NEHORI;

        if (velkostGaraze > 0) {
            this.velkostGaraze = velkostGaraze;
            this.garaz = new Garaz(150, 300, 20, velkostGaraze);
        } else {
            throw new ZlyParameterException("Zla velkost garaze: " + velkostGaraze);
        }
    }

    /**
     * Metoda na pridavanie hasicskych aut do garaze, na zaklade objektu hasicskeho auta, a miesta v garazi.
     * V pripade ze je miesto obsadene, vyhodi chybu.
     *
     * @param auto auto, ktore chceme zaparkovat.
     * @param miesto miesto v garazi kam chceme auto zaparkovat.
     * @throws MiestoJeObsadeneException vynimka v pripade obsadeneho miesta.
     */
    public void pridajHasicskeAuto(HasicskeAuto auto, int miesto) throws MiestoJeObsadeneException {
        this.garaz.pridajDoGaraze(auto, miesto - 1);
    }

    /**
     * Metoda na odoberanie hasicskych aut, na zaklade SPZ aut.
     *
     * @param spz spz odoberaneho auta.
     */
    public void odoberHasicskeAuto(String spz) {
        this.garaz.odoberZGaraze(spz);
    }

    /**
     * Metoda na pridavanie hasicov do hasicskej zbrojnice, na zaklade objektu E z nalozitelny.
     * Umoznuje nalozit len objekty implementujuce interface Nalozitelny.
     *
     * @param hasic pridavany hasic.
     */
    public void pridajHasica(E hasic) {
        if (!this.hasici.containsValue(hasic)) {
            this.hasici.put(hasic.getMeno(), hasic);
        }
    }

    /**
     * Metoda na odobratie hasica z hasicskej zbrojnice, na zaklade mena hasica.
     *
     * @param menoHasica meno odoberaneho hasica.
     */
    public void odoberHasica(String menoHasica) {
        if (this.hasici.containsKey(menoHasica)) {
            this.hasici.remove(menoHasica);
        } else {
            System.out.println("Dany Hasic sa nenachadza v hasicskej zbrojnici...");
        }
    }

    /**
     * Metoda na vracanie kontajneru hasicov, vyuzitie ma v GUI.
     *
     * @return vrati kontajner hasicov.
     */
    public HashMap getHasici() {
        return hasici;
    }

    /**
     * Metoda na vracanie garaze, ma vyuzitie v GUI.
     *
     * @return vrati objekt garaz.
     */
    public Garaz getGaraz() {
        return garaz;
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
     * @return vrati retazec so vsetkymi informaciami o hasicskej zbrojnici.
     */
    @Override
    public String toString() {
        StringBuilder pom = new StringBuilder("Hasickska zbrojnica\n\tVyska: \t\t\t" + this.vyskaBudovy
                + "\n\tSirka: \t\t\t" + this.sirkaBudovy
                + "\n\tDlzka: \t\t\t" + this.dlzkaBudovy
                + "\n\tStav: \t\t\t" + this.stavBudovy
                + "\n\tKapacita: \t\t" + this.kapacita
                + "\n\tVelkost garaze: " + this.velkostGaraze
                + this.garaz.toString()
                + "\n\nHasici v hasicskej zbrojnici: ");

        for (E hasic : this.hasici.values()) {
            pom.append(hasic.toString());
        }
        return pom.toString();
    }
}
