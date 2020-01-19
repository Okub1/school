/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 *
 * @author ACER NB
 */
public class DijkstrovAlg {

    public static void main(String[] args) throws FileNotFoundException {
        File vstup = new File("Input files/vstupSHodnotami.txt");
        Scanner scanner = new Scanner(vstup); //Nastavenie vrcholov, hran a cien hran
        Graf graf = new Graf();
        int pocetVrcholov;
        pocetVrcholov = scanner.nextInt();
        graf.vytvorPolePreVrcholy(pocetVrcholov);
        for (int pocitadlo = 0; pocitadlo < pocetVrcholov; pocitadlo++) {
            graf.zadajVrcholy();
        }
        System.out.print("Vsetky zadane vrcholy teda su: ");
        for (int pocitadlo = 0; pocitadlo < pocetVrcholov; pocitadlo++) {
            System.out.print(graf.getVrcholy());
        }
        System.out.println();
        int pocetHran;
        pocetHran = scanner.nextInt();
        graf.vytvorPolePreHrany(pocetHran);
        for (int pocitadlo = 0; pocitadlo < pocetHran; pocitadlo++) {
            graf.zadajHrany();
        }
        System.out.print("Vsetky zadane hrany aj s cenami teda su: ");
        for (int pocitadlo = 0; pocitadlo < pocetHran; pocitadlo++) {
            System.out.print(graf.getHrany());
        }
        System.out.println();
        
        graf.rataj();          //Zaciatok samotneho programu
    }
}
