public class Peniaze{

    private double hodnota;

    public Peniaze(double hodnota){
        this.hodnota = hodnota;
    }

    public double getHodnota() {
        return hodnota;
    }

    public void setHodnota(double hodnota) {
        this.hodnota = hodnota;
    }

    public String prepocitaj() {
        int pocet500€   = 0;
        int pocet200€   = 0;
        int pocet100€   = 0;
        int pocet50€    = 0;
        int pocet20€    = 0;
        int pocet10€    = 0;
        int pocet5€     = 0;
        int pocet2€     = 0;
        int pocet1€     = 0;
        int pocet0_5€   = 0;
        int pocet0_20€  = 0;
        int pocet0_10€  = 0;
        int pocet0_05€  = 0;
        int pocet0_02€  = 0;
        int pocet0_01€  = 0;

        // 500€
        for(int i = 0; i < this.hodnota; i++) {
            if (this.hodnota / 500 >= 1) {
                pocet500€++;
                this.hodnota -= 500;
            } else {
                break;
            }
        }

        // 200€
        for(int i = 0; i < this.hodnota; i++) {
            if (this.hodnota / 200 >= 1) {
                pocet200€++;
                this.hodnota -= 200;
            } else {
                break;
            }
        }

        // 100€
        for(int i = 0; i < this.hodnota; i++) {
            if (this.hodnota / 100 >= 1) {
                pocet100€++;
                this.hodnota -= 100;
            } else {
                break;
            }
        }

        // 50€
        for(int i = 0; i < this.hodnota; i++) {
            if (this.hodnota / 50 >= 1) {
                pocet50€++;
                this.hodnota -= 50;
            } else {
                break;
            }
        }

        // 20€
        for(int i = 0; i < this.hodnota; i++) {
            if (this.hodnota / 20 >= 1) {
                pocet20€++;
                this.hodnota -= 20;
            } else {
                break;
            }
        }

        // 10€
        for(int i = 0; i < this.hodnota; i++) {
            if (this.hodnota / 10 >= 1) {
                pocet10€++;
                this.hodnota -= 10;
            } else {
                break;
            }
        }

        // 5€
        for(int i = 0; i < this.hodnota * 10; i++) {
            if (this.hodnota < 10 && this.hodnota > 0) {
                if (this.hodnota / 5 >= 1 ) {
                    pocet5€++;
                    this.hodnota -= 5;
                }
            } else {
                break;
            }
        }

        // 2€
        for(int i = 0; i < this.hodnota * 10; i++) {
            if (this.hodnota < 5 && this.hodnota > 0) {
                if (this.hodnota / 2 >= 1 ) {
                    pocet2€++;
                    this.hodnota -= 2;
                }
            } else {
                break;
            }
        }

        //1€
        for(int i = 0; i < this.hodnota * 10; i++) {
            if (this.hodnota < 2 && this.hodnota > 0) {
                if (this.hodnota / 1 >= 1 ) {
                    pocet1€++;
                    this.hodnota -= 2;
                }
            } else {
                break;
            }
        }

        // 0.50€
        for(int i = 0; i < this.hodnota * 10; i++) {
            if (this.hodnota < 1 && this.hodnota > 0) {
                if (this.hodnota / 0.5 >= 1) {
                    pocet0_5€++;
                    this.hodnota -= 0.5;
                } else {
                    break;
                }
            }
        }

        // 0.20€
        for(int i = 0; i < this.hodnota * 10; i++) {
            if (this.hodnota < 0.5 && this.hodnota > 0) {
                if (this.hodnota / 0.2 >= 1) {
                    pocet0_20€++;
                    this.hodnota -= 0.2;
                } else {
                    break;
                }
            }
        }

        // 0.10€
        for(int i = 0; i < this.hodnota * 10; i++) {
            if (this.hodnota < 0.2 && this.hodnota > 0) {
                if (this.hodnota / 0.2 >= 1) {
                    pocet0_10€++;
                    this.hodnota -= 0.2;
                } else {
                    break;
                }
            }
        }

        // 0.05€
        for(int i = 0; i < this.hodnota * 10; i++) {
            if (this.hodnota < 0.10 && this.hodnota > 0) {
                if (this.hodnota / 0.05 >= 1) {
                    pocet0_05€++;
                    this.hodnota -= 0.05;
                } else {
                    break;
                }
            }
        }

        // 0.02€
        for(int i = 0; i < this.hodnota * 10; i++) {
            if (this.hodnota < 0.05 && this.hodnota > 0) {
                if (this.hodnota / 0.02 >= 1) {
                    pocet0_02€++;
                    this.hodnota -= 0.02;
                } else {
                    break;
                }
            }
        }

        // 0.01€
        for(int i = 0; i < this.hodnota * 10; i++) {
            if (this.hodnota < 0.02 && this.hodnota > 0) {
                if (this.hodnota / 0.01 >= 1) {
                    pocet0_01€++;
                    this.hodnota -= 0.01;
                } else {
                    break;
                }
            }
        }

        System.out.println(
                "\nPocet 500€: "    + "\t"   + pocet500€ +
                "\nPocet 200€: "    + "\t"   + pocet200€ +
                "\nPocet 100€: "    + "\t"   + pocet100€ +
                "\nPocet 50€: "     + "\t\t" + pocet50€ +
                "\nPocet 20€: "     + "\t\t" + pocet20€ +
                "\nPocet 10€ "      + "\t\t" + pocet10€ +
                "\nPocet 5€: "      + "\t\t" + pocet5€ +
                "\nPocet 2€: "      + "\t\t" + pocet2€ +
                "\nPocet 1€: "      + "\t\t" + pocet1€ +
                "\nPocet 0.50€: "   + "\t"   + pocet0_5€ +
                "\nPocet 0.20: "    + "\t"   + pocet0_20€ +
                "\nPocet 0.10€: "   + "\t"   + pocet0_10€ +
                "\nPocet 0.05€: "   + "\t"   + pocet0_05€ +
                "\nPocet 0.02: "    + "\t"   + pocet0_02€ +
                "\nPocet 0.01€: "   + "\t"   + pocet0_01€);

        return pocet20€ + "\n" + pocet2€ + "\n" + pocet0_5€;
    }
}
