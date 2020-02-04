public enum Farba {
    CIERNA,
    HNEDA,
    CERVENA,
    ORANZOVA,
    ZLTA,
    ZELENA,
    MODRA,
    FIALOVA,
    SEDA,
    BIELA,
    ZLATA,
    STRIEBORNA,
    ZIADNA;

    public int getHodnota() {
        int temp = -3;

        switch (this) {
            case CIERNA:
                temp = 0;
                break;
            case HNEDA:
                temp = 1;
                break;
            case CERVENA:
                temp = 2;
                break;
            case ORANZOVA:
                temp = 3;
                break;
            case ZLTA:
                temp = 4;
                break;
            case ZELENA:
                temp = 5;
                break;
            case MODRA:
                temp = 6;
                break;
            case FIALOVA:
                temp = 7;
                break;
            case SEDA:
                temp = 8;
                break;
            case BIELA:
                temp = 9;
                break;
            case ZLATA:
                temp = -1;
                break;
            case STRIEBORNA:
                temp = -2;
                break;
        }
        return temp; // JEDEN RETURN ABY SA JULO NEPOSRAL :D
    }

    public double getPresnost() {
        double temp = 0.0;

        switch (this) {
            case HNEDA:
                temp = 0.01; // 1%
                break;
            case CERVENA:
                temp = 0.02; // 2%
                break;
            case ZELENA:
                temp = 0.005; // 0,5%
                break;
            case MODRA:
                temp = 0.0025; // 0,25%
                break;
            case FIALOVA:
                temp = 0.001; // 0,1%
                break;
            case SEDA:
                temp = 0.0005; // 0,05%
                break;
            case ZLATA:
                temp = 0.05; // 5%
                break;
            case STRIEBORNA:
                temp = 0.1; // 10%
                break;
            default: temp = 0.2; // 20%

        }
        return temp;
    }
}
