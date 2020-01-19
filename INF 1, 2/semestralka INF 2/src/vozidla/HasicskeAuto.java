package vozidla;

import exceptions.ZlyParameterException;
import osoby.Hasic;

import java.util.HashMap;

/**
 * Trieda, ktora nam definuje hasicske auto, co moze hasicske auto vykonat.
 */
public class HasicskeAuto extends Vozidlo implements Zaparkovatelny {
    /**
     * Atribut, ktory definje typ auta.
     */
    private TypVozidla typVozidla;
    /**
     * Inicializacia kontajneru hasicov v hasicskom aute.
     */
    private HashMap<String, Hasic> hasici;

    /**
     * Kontruktor hasicskeho auta, ktory kontroluje zadane parametre, v pripade zle zadaneho parametru vyhodi chybu.
     *
     * @param spz spz vozidla.
     * @param hmotnost hmotnost vozidla.
     * @param kapacita kapacita vozidla.
     * @throws ZlyParameterException vynimka v pripade ze bol zle zadany parameter.
     */
    public HasicskeAuto(String spz, double hmotnost, int kapacita) throws ZlyParameterException {
        super(spz, hmotnost, kapacita);
        this.typVozidla = TypVozidla.HASICSKEAUTO;
        this.hasici = new HashMap<>(kapacita);
    }

    /**
     * Metoda na pridavanie hasicov do hasicskeho auta, nazaklade objektu hasic,
     * v pripade zleho parametru vyhodi chybu.
     *
     * @param hasic pridavany hasic.
     * @throws ZlyParameterException vynimka v pripade zleho parametru.
     */
    public void pridajHasica(Hasic hasic) throws ZlyParameterException {
        if (hasic == null) {
            throw new ZlyParameterException("Zly Hasic.");
        } else {
            if (!this.hasici.containsValue(hasic)) {
                this.hasici.put(hasic.getMeno(), hasic);
            } else {
                throw new ZlyParameterException("Zly Hasic.");
            }
        }
    }

    /**
     * Metoda na odoberanie hasica z hasicskeho auta, na zaklade mena hasica.
     *
     * @param menoHasica meno odoberaneho hasica.
     */
    public void odoberHasica(String menoHasica) {
        if (this.hasici.containsKey(menoHasica)) {
            this.hasici.remove(menoHasica);
        } else {
            System.out.println("Dany Hasic sa nenachadza v hasicskom aute...");
        }
    }

    /**
     * Metoda vracanie kontajneru hasicov, ma vyuzitie v GUI.
     *
     * @return vrati kontajner hasicov.
     */
    public HashMap getHasici() {
        return hasici;
    }

    /**
     * Metoda na vracanie SPZ vozidla.
     *
     * @return vrati SPZ vozidla.
     */
    @Override
    public String getSpz() {
        return super.getSpz();
    }

    /**
     * Metoda na nastavenie SPZ vozidla, v pripade zleho paramtera vyhodi chybu.
     *
     * @param spz nova SPZ.
     * @throws ZlyParameterException vynimka v pripade zleho parametra.
     */
    @Override
    public void setSpz(String spz) throws ZlyParameterException {
        try {
            super.setSpz(spz);
        } catch (ZlyParameterException e) {
            e.printStackTrace();
        }
    }

    /**
     * Metoda na vracanie hmotnosti vozidla.
     *
     * @return vrati hmotnost vozidla.
     */
    @Override
    public double getHmotnost() {
        return super.getHmotnost();
    }

    /**
     * Metoda na nastavenie hmotnost vozidla, v pripade zleho parametru vyhodi chybu.
     *
     * @param hmotnost nova hmotnost vozidla.
     * @throws ZlyParameterException vynimka v pripdae zleho parametra.
     */
    @Override
    public void setHmotnost(double hmotnost) throws ZlyParameterException {
        try {
            super.setHmotnost(hmotnost);
        } catch (ZlyParameterException e) {
            e.printStackTrace();
        }
    }

    /**
     * Metoda na vypisanie vsetkych informacii o vozidle v retazci.
     *
     * @return vrati informacie o mieste v retazci.
     */
    @Override
    public String toString() {
        StringBuilder pom = new StringBuilder(super.toString()
                + "\n\tTyp vozidla: " + typVozidla.toString()
                + "\nV hasicskom aute sa nachadza: ");

        for (Hasic hasic : this.hasici.values()) {
            pom.append(hasic.toString());
        }

        return pom.toString();
    }
}
