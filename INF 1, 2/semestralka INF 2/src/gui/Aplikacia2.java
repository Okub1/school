package gui;

import vozidla.HasicskeAuto;
import budovy.HasicskaZbrojnica;
import exceptions.MiestoJeObsadeneException;
import exceptions.ZlyParameterException;
import osoby.Hasic;
import osoby.Pohlavie;

import javax.swing.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.HashMap;

public class Aplikacia2 {


    private JPanel panel1;
    private JButton vytvoritHasicskuZbrojnicuButton;
    private JButton vytvoritHasicaButton;
    private JButton pridajHasicaDoZbrojniceButton;
    private JButton vypisHasicskuZbrojnicuButton;
    private JButton exitButton;
    private JButton pridajHasicskeAutoButton;
    private JButton vytvorHasicskeAutoButton;
    private JButton pridajHasicadoHasicskehoAutaButton;
    private JButton vypisHasicskeAutoButton;
    private JButton zburatHasicskuZbrojnicuButton;
    private JButton zabitHasicaButton;
    private JButton znicitHasicskeAutoButton;
    private JButton odobratHasicaZoZbrojniceButton;
    private JButton odobratHasicskeAutoButton;
    private JButton odobratHasicazHasicskehoAutaButton;
    private HasicskaZbrojnica<Hasic> hasicskaZbrojnica;
    private HashMap<String, Hasic> hasici = new HashMap<>();
    private HashMap<String, HasicskeAuto> hasicskeAuta = new HashMap<>();

    public static void main(String[] args) {
        JFrame frame = new JFrame("Aplikacia2");
        frame.setContentPane(new Aplikacia2().panel1);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }

    public Aplikacia2() {
        vytvoritHasicskuZbrojnicuButton.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);

                Double vyska = Double.parseDouble(JOptionPane.showInputDialog(panel1, "Zadajte vysku zbrojnice: ", 150));
                Double sirka = Double.parseDouble(JOptionPane.showInputDialog(panel1, "Zadajte sirku zbrojnice: ", 150));
                Double dlzka = Double.parseDouble(JOptionPane.showInputDialog(panel1, "Zadajte dlzku zbrojnice: ", 150));
                int kapacita = Integer.parseInt(JOptionPane.showInputDialog(panel1, "Zadajte kapacitu zbrojnice: ", 5));
                int velkostGaraze = Integer.parseInt(JOptionPane.showInputDialog(panel1, "Zadajte velkost garaze zbrojnice: ", 2));


                try {
                    hasicskaZbrojnica = new HasicskaZbrojnica<Hasic>(vyska, sirka, dlzka, kapacita, velkostGaraze);
                } catch (ZlyParameterException e1) {
                    e1.printStackTrace();
                }


            }
        });
        vytvoritHasicaButton.addMouseListener(new MouseAdapter() { ;
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);


                int vek = Integer.parseInt(JOptionPane.showInputDialog(panel1, "Zadajte vek hasica:", 18));
                Object[] pohlavia = {Pohlavie.MUZ, Pohlavie.ZENA};
                int pohlavie = JOptionPane.showOptionDialog(panel1, "Vyberte pohlavie hasica: ", "Pohlavie", JOptionPane.DEFAULT_OPTION, JOptionPane.QUESTION_MESSAGE, null, pohlavia, pohlavia);
                double hmotnost = Double.parseDouble(JOptionPane.showInputDialog(panel1, "Zadajte hmotnost hasica: ", 100));
                String meno = JOptionPane.showInputDialog(panel1, "Zadajte meno hasica: ", "Jano");
                int mzda = Integer.parseInt(JOptionPane.showInputDialog(panel1, "Zadajte mzdu hasica: ", 450));

                try {
                    Pohlavie pohlavie1;
                    if (pohlavie == 0) {
                        pohlavie1 = Pohlavie.MUZ;
                    } else {
                        pohlavie1 = Pohlavie.ZENA;
                    }
                    Hasic hasic = new Hasic(vek, pohlavie1, hmotnost, meno, mzda);
                    hasici.put(meno, hasic);
                } catch (ZlyParameterException e1) {
                    e1.printStackTrace();
                }
            }
        });
        pridajHasicaDoZbrojniceButton.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);

                String meno = JOptionPane.showInputDialog(panel1, "Zadajte meno hasica: ", "Jano");

                if (hasici.containsKey(meno)) {
                    if (hasicskaZbrojnica != null) {
                        hasicskaZbrojnica.pridajHasica(hasici.get(meno));
                    } else {
                        JOptionPane.showMessageDialog(panel1, "Najprv musíte vytvoriť hasičskú zbrojnicu...");
                    }
                } else {

                    String pom = "Dostupní hasiči: ";

                    JOptionPane.showMessageDialog(panel1, "Hasic s danym menom neexistuje...\n" + pom + hasici.keySet());
                }
            }
        });
        vypisHasicskuZbrojnicuButton.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);

                if (hasicskaZbrojnica != null) {
                    JOptionPane.showMessageDialog(panel1, hasicskaZbrojnica.toString());
                } else {
                    JOptionPane.showMessageDialog(panel1, "Najprv musíte vytvoriť hasičskú zbrojnicu...");
                }
            }
        });
        exitButton.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
                System.exit(0);
            }
        });
        vytvorHasicskeAutoButton.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);

                String spz = JOptionPane.showInputDialog(panel1, "Zadajte SPZ hasicskeho auta: ", "AA123BB");
                double hmotnost = Double.parseDouble(JOptionPane.showInputDialog(panel1, "Zadajte hmotnost hasicskeho auta: ", 250));
                int kapacita = Integer.parseInt(JOptionPane.showInputDialog(panel1, "Zadajte kapacitu hasicskeho auta: ", 5));

                try {
                    HasicskeAuto hasicskeAuto = new HasicskeAuto(spz, hmotnost, kapacita);
                    hasicskeAuta.put(spz, hasicskeAuto);
                } catch (ZlyParameterException e1) {
                    e1.printStackTrace();
                }
            }
        });
        pridajHasicskeAutoButton.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);

                String spz = JOptionPane.showInputDialog(panel1, "Zadajte SPZ vozidla: ", "AA123BB");
                int miesto = Integer.parseInt(JOptionPane.showInputDialog(panel1, "Vyberte miesto v garazi: ", 1));

                if (hasicskeAuta.containsKey(spz)) {
                    if (hasicskaZbrojnica != null) {
                        try {
                            hasicskaZbrojnica.pridajHasicskeAuto(hasicskeAuta.get(spz), miesto);
                        } catch (MiestoJeObsadeneException e1) {
                            e1.printStackTrace();
                        }
                    } else {
                        JOptionPane.showMessageDialog(panel1, "Najprv musíte vytvoriť hasičskú zbrojnicu...");
                    }
                } else {

                    String pom = "Dostupné hasičské autá: ";

                    JOptionPane.showMessageDialog(panel1, "Hasičské auto s danou ŠPZ neexistuje...\n" + pom + hasicskeAuta.keySet());
                }
            }
        });
        pridajHasicadoHasicskehoAutaButton.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);

                String spz = JOptionPane.showInputDialog(panel1, "Zadajte SPZ vozidla: ", "AA123BB");
                String meno = JOptionPane.showInputDialog(panel1, "Zadajte meno hasica, ktoreho chcete pridat do vozidla " + spz + ": ", "Jano");

                if (hasicskeAuta.containsKey(spz)) {
                    if (hasici.containsKey(meno)) {
                        try {
                            hasicskeAuta.get(spz).pridajHasica(hasici.get(meno));
                        } catch (ZlyParameterException e1) {
                            e1.printStackTrace();
                        }
                    } else {

                        String pom = "Dostupné hasičské autá: ";

                        JOptionPane.showMessageDialog(panel1, "Hasičské auto s danou ŠPZ neexistuje...\n" + pom + hasicskeAuta.keySet());
                    }
                } else {

                    String pom = "Dostupní hasiči: ";

                    JOptionPane.showMessageDialog(panel1, "Hasic s danym menom neexistuje...\n" + pom + hasici.keySet());
                }
            }
        });
        vypisHasicskeAutoButton.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);

                String spz = JOptionPane.showInputDialog(panel1, "Zadajte SPZ vozidla: ", "AA123BB");

                if (hasicskeAuta.containsKey(spz)) {
                    JOptionPane.showMessageDialog(panel1, "Hasičské auto " + spz + ": " + hasicskeAuta.get(spz).toString());
                } else {

                    String pom = "Dostupné hasičské autá: ";

                    JOptionPane.showMessageDialog(panel1, "Hasičské auto s danou ŠPZ neexistuje...\n" + pom + hasicskeAuta.keySet());
                }
            }
        });
        zburatHasicskuZbrojnicuButton.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);

                JOptionPane.showMessageDialog(panel1, "Hasičská zbrojnica bola zbúraná...");
                hasicskaZbrojnica = null;
            }
        });
        zabitHasicaButton.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);

                String meno = JOptionPane.showInputDialog(panel1, "Zadajte meno hasica: ", "Jano");

                if (hasici.containsKey(meno)) {
                    hasici.remove(meno);
                    JOptionPane.showMessageDialog(panel1, "Úspešne ste zabili hasiča: " + meno);
                } else {

                    String pom = "Dostupní hasiči: ";

                    JOptionPane.showMessageDialog(panel1, "Hasic s danym menom neexistuje...\n" + pom + hasici.keySet());
                }
            }
        });
        znicitHasicskeAutoButton.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);

                String spz = JOptionPane.showInputDialog(panel1, "Zadajte SPZ vozidla: ", "AA123BB");

                if (hasicskeAuta.containsKey(spz)) {
                    hasicskeAuta.remove(spz);
                    JOptionPane.showMessageDialog(panel1, "Úspešne ste zničili hasičské auto: " + spz);
                } else {

                    String pom = "Dostupné hasičské autá: ";

                    JOptionPane.showMessageDialog(panel1, "Hasičské auto s danou ŠPZ neexistuje...\n" + pom + hasicskeAuta.keySet());
                }
            }
        });
        odobratHasicaZoZbrojniceButton.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);

                if (hasicskaZbrojnica != null) {
                    String meno = JOptionPane.showInputDialog(panel1, "Zadajte meno hasica: ", "Jano");
                    Boolean has = hasicskaZbrojnica.getHasici().containsKey(meno);
                    if (has) {
                        hasicskaZbrojnica.odoberHasica(meno);
                        JOptionPane.showMessageDialog(panel1, "Úspešne ste vyhodili hasiča: " + meno + " z hasičskej zbrojnice...");
                    } else {
                        String pom = "Dostupní hasiči: ";

                        JOptionPane.showMessageDialog(panel1, "Hasic s danym menom sa nenachadza v zbrojnici...\n" + pom + hasicskaZbrojnica.getHasici().keySet());
                    }
                } else {
                    JOptionPane.showMessageDialog(panel1, "Najprv musíte vytvoriť hasičskú zbrojnicu...");
                }
            }
        });
        odobratHasicskeAutoButton.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);

                if (hasicskaZbrojnica != null) {
                    String spz = JOptionPane.showInputDialog(panel1, "Zadajte ŠPZ hasičského auta: ", "AA123BB");
                    hasicskaZbrojnica.getGaraz().odoberZGaraze(spz);
                    JOptionPane.showMessageDialog(panel1, "Úspešne ste odobrali " + spz + " z hasičskej zbrojnice...");
                } else {
                    JOptionPane.showMessageDialog(panel1, "Najprv musíte vytvoriť hasičskú zbrojnicu...");
                }
            }
        });
        odobratHasicazHasicskehoAutaButton.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);

                String spz = JOptionPane.showInputDialog(panel1, "Zadajte ŠPZ vozidla: ", "AA123BB");

                if (hasicskeAuta.containsKey(spz)) {
                    String meno = JOptionPane.showInputDialog(panel1, "Zadajte meno odoberaného hasiča: ", "Jano");

                    if (hasicskeAuta.get(spz).getHasici().containsKey(meno)) {

                        hasicskeAuta.get(spz).odoberHasica(meno);
                        JOptionPane.showMessageDialog(panel1, "Úspešne ste vyhodili hasiča " + meno + " z hasičského auta " + spz + ".");
                    } else {

                        String pom = "Dostupní hasiči: ";

                        JOptionPane.showMessageDialog(panel1, "Hasic s danym menom sa nenachádza v hasičskom aute...\n" + pom + hasicskeAuta.get(spz).getHasici().keySet());
                    }
                } else {

                    String pom = "Dostupné hasičské autá: ";

                    JOptionPane.showMessageDialog(panel1, "Hasičské auto s danou ŠPZ neexistuje...\n" + pom + hasicskeAuta.keySet());
                }
            }
        });
    }
}
