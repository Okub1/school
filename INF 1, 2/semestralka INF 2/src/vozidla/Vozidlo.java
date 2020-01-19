package vozidla;

import exceptions.ZlyParameterException;
import osoby.Hasic;

import java.util.HashMap;

/**
 * Trieda definujuca vozidla.
 */
public class Vozidlo implements Zaparkovatelny {
    /**
     * Atribut, ktory definuje spz vozidla.
     */
    private String spz;
    /**
     * Atribut, ktory definuje hmotnost vozidla.
     */
    private double hmotnost;
    /**
     * Atribut, ktory definuje kapacitu vozidla.
     * Kapacita vyjadruje kolko moze hasicov nastupit do daneho vozidla.
     */
    private int kapacita;
    /**
     * Inicializácia kontajneru hasicov.
     */
    private HashMap<String, Hasic> hasici;


    /**
     * Konstruktor, ktory vytvara vozidla, kontroluje ci su spravne zadane parametre,
     * v pripade zle zadaneho parametru vyhodi chybu.
     *
     * @param spz spz vozidla.
     * @param hmotnost hmotnost vozidla.
     * @param kapacita kapacita vozidla.
     * @throws ZlyParameterException vynimka v pripade zle zadaneho parametra.
     */
    public Vozidlo(String spz, double hmotnost, int kapacita) throws ZlyParameterException {
        if (spz == null) {
            throw new ZlyParameterException("Zadajte platnu spz...");
        } else {
            this.spz = spz;
        }

        if (hmotnost <= 0) {
            throw new ZlyParameterException("Zadajte platnu hmotnost (viac ako 0).");
        } else {
            this.hmotnost = hmotnost;
        }

        if (kapacita <= 0) {
            throw new ZlyParameterException("Zadajte platnu kapacita (viac ako 0).");
        } else {
            this.kapacita = kapacita;
        }
    }

    /**
     * Metoda na vracanie SPZ vozidla.
     *
     * @return vrati SPZ vozidla.
     */
    @Override
    public String getSpz() {
        return spz;
    }

    /**
     * Metoda na nastavenie SPZ vozidla.
     *
     * @param spz nova spz vozidla.
     * @throws ZlyParameterException vynimka v pripade zle zadaneho parametra.
     */
    @Override
    public void setSpz(String spz) throws ZlyParameterException {
        if (spz == null) {
            throw new ZlyParameterException("Zadajte platnu spz...");
        } else {
            this.spz = spz;
        }
    }

    /**
     * Metoda na vracanie hmotnost vozidla.
     *
     * @return vrati hmotnost vozidla.
     */
    @Override
    public double getHmotnost() {
        return this.hmotnost;
    }

    /**
     * Metoda na nastavenie hmotnost vozidla, v pripade zleho parametra vyhodi chybu.
     *
     * @param hmotnost nova hmotnost vozidla.
     * @throws ZlyParameterException vynimka v pripade zleho parametra.
     */
    @Override
    public void setHmotnost(double hmotnost) throws ZlyParameterException {
        if (hmotnost <= 0) {
            throw new ZlyParameterException("Zadajte platnu hmotnost (viac ako 0).");
        } else {
            this.hmotnost = hmotnost;
        }
    }

    /**
     * Metoda na vypisanie vsetkych informacii o vozidle v retazci.
     *
     * @return vrati informacie o mieste v retazci.
     */
    public String toString() {
        return "\nVozidlo\n\tspz: "
                + this.spz + "\n\tHmotnost: "
                + this.hmotnost;
    }
}
