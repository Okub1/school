import com.sun.org.apache.xpath.internal.SourceTree;

import java.util.ArrayList;
import java.util.Arrays;

import static java.util.Arrays.*;

public class Kniznica {

    private Publikacia[] publikacie;

    public Kniznica(int velkost) {
        if (velkost <= 0) {
            this.publikacie = new Publikacia[1];
        }
        this.publikacie = new Publikacia[velkost];
    }

    public void pridaj(Publikacia publikacia) {
        for (int i = 0; i < this.publikacie.length; i++) {
            if (this.publikacie[i] == null) {
                this.publikacie[i] = publikacia;
                break;
            }
        }
    }

    public Publikacia[] najdi(String nazov) {
        Publikacia[] najdenePublikacie;


        //------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
        //ja sa ospravedlnujem, ale nevedel som ako spravit binary search, pretoze neviem co to je... :(((
        //tak som to spravil po svojom...

//        int index = binarySearch(this.publikacie, nazov);
//        Publikacia pom;
//        pom = this.publikacie[index];
//        najdenePublikacie.add(pom);


        System.out.println("\nNajdena publikacia: " + nazov);
        najdenePublikacie = new Publikacia[this.publikacie.length];

        for (int i = 0; i < this.publikacie.length; i++) {
            if (this.publikacie[i] == null) {
                continue;
            }

            if (this.publikacie[i].getNazov().equals(nazov) && najdenePublikacie[i] == null) {
                najdenePublikacie[i] = this.publikacie[i];
            }
        }

        for (Publikacia aNajdenePublikacie : najdenePublikacie) {
            if (aNajdenePublikacie == null) {
                continue;
            } else {
                System.out.println(aNajdenePublikacie.toString());
            }
        }

        return najdenePublikacie;
    }

    private void usporiadaj() {
        sort(this.publikacie);
    }

    public String toString() {
        int pom1 = 0;
        StringBuilder pom = null;

        for (int i = 0; i < this.publikacie.length; i++) {
            if (this.publikacie[i] == null) {
                pom1 += 1;
            }
        }


        System.out.println("\n-------------------------");
        System.out.println("Kniznica: ");
        if (pom1 == this.publikacie.length) {
            pom = new StringBuilder("\nV kniznici sa nic nenachadza...\n");
        } else {
            pom = new StringBuilder("\nV kniznici sa nachadza: \n");

            for (Publikacia aPublikacie : this.publikacie) {
                if (aPublikacie == null) {
                    continue;
                }
                pom.append(aPublikacie);
            }
        }
        pom.append("\n-------------------------");
        return pom.toString();
    }
}
