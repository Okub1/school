import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.io.IOException;
import java.net.URISyntaxException;
import java.net.URL;

public class Application extends JFrame {
    private JPanel mainPanel;
    private JFrame parent;
    private JTextArea textArea1;
    private JButton button1;


    public Application(String title) {
        super(title);
        try {
            UIManager.setLookAndFeel("com.sun.java.swing.plaf.windows.WindowsLookAndFeel");
        } catch (Exception e) {
            e.printStackTrace();
        }

        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setContentPane(mainPanel);
        parent = this;
        setSize(600, 300);
        setLocationRelativeTo(null);

//----------------------------------------------------------------------------------------------------------------------
        // menu shit:

        JMenuBar menuBar = new JMenuBar();
        JMenu menu1 = new JMenu("Menu");
        menuBar.add(menu1);

        // Test palindrome submenu items:
        JMenu subMenu1 = new JMenu("Testovacie palindromy");
        menuBar.add(subMenu1);

        JMenuItem subMenuItem1 = new JMenuItem("Rotor");
        subMenu1.add(subMenuItem1);
        subMenuItem1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                textArea1.setText("Rotor");
            }
        });

        JMenuItem subMenuItem2 = new JMenuItem("Racecar");
        subMenu1.add(subMenuItem2);
        subMenuItem2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                textArea1.setText("Racecar");
            }
        });

        JMenuItem subMenuItem3 = new JMenuItem("Santa");
        subMenu1.add(subMenuItem3);
        subMenuItem3.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                textArea1.setText("A Santa Lived As a Devil At NASA ");
            }
        });

        JMenuItem subMenuItem4 = new JMenuItem("Panama canal");
        subMenu1.add(subMenuItem4);
        subMenuItem4.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                textArea1.setText("A Man, A Plan, A Canal-Panama!");
            }
        });

        JMenuItem subMenuItem5 = new JMenuItem("Garfield");
        subMenu1.add(subMenuItem5);
        subMenuItem5.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                textArea1.setText("Doc, Note: I Dissent. A Fast Never Prevents A Fatness. I Diet On Cod.");
            }
        });

        JMenuItem subMenuItem6 = new JMenuItem("Seno dones");
        subMenu1.add(subMenuItem6);
        subMenuItem6.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                textArea1.setText("Seno dones.");
            }
        });

        JMenuItem subMenuItem7 = new JMenuItem("Dalsie palindromy");
        subMenu1.add(subMenuItem7);
        subMenuItem7.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    Desktop.getDesktop().browse(new URL("https://www2.cs.arizona.edu/icon/oddsends/palinsen.htm").toURI());
                } catch (IOException | URISyntaxException ex) {
                    ex.printStackTrace();
                }
            }
        });


        JMenuItem menuItemWhatIsPalindrome = new JMenuItem("What is palindrome");
        menu1.add(menuItemWhatIsPalindrome);
        menuItemWhatIsPalindrome.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    JOptionPane.showMessageDialog(parent, "Let me open wikipedia for you, you lazy bastard...");
//                    Thread.sleep(1000);
                    Desktop.getDesktop().browse(new URL("https://en.wikipedia.org/wiki/Palindrome").toURI());
                } catch (IOException | URISyntaxException ex) {
                    ex.printStackTrace();
                }
            }
        });

        JMenuItem menuItemAbout = new JMenuItem("About");
        menu1.add(menuItemAbout);
        menuItemAbout.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(parent, "Naprogramoval: Jakub Senko, 2020" +
                        "\nako side-project len tak zo srandy za jeden vecer :D.");
            }
        });

        // Exit menu item:
        JMenuItem menuItemExit = new JMenuItem("Exit");
        menu1.add(menuItemExit);
        menuItemExit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                confirmExit();
            }
        });

        parent.setJMenuBar(menuBar);
        // end of menu shit
//----------------------------------------------------------------------------------------------------------------------
        // action listeners (enter pressed, escape pressed)

        // Closing window event, confirm exit window:
        addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                confirmExit();
            }
        });

        // check button listener - check
        button1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                check(textArea1.getText());
            }
        });

        // enter key listener - check
        textArea1.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                super.keyPressed(e);
                if(e.getKeyCode() == KeyEvent.VK_ENTER){
                    check(textArea1.getText());
                }
            }
        });

        // escape key listener - confirm exit
        textArea1.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                super.keyPressed(e);
                if(e.getKeyCode() == KeyEvent.VK_ESCAPE){
                    confirmExit();
                }
            }
        });
    }

    // check for palindrome method
    public void check(String palindrome) {
        if (palindrome.length() > 1) {
            if (Palindrome.check(palindrome.toLowerCase())) {
                ImageIcon icon = new ImageIcon("src/img/success_icon_check_mark.png");
                icon = resizeIcon(icon, 48, 48);
                JOptionPane.showMessageDialog(parent, "Je to palindróm!", "Success", JOptionPane.PLAIN_MESSAGE, icon);
                textArea1.setText(null);
            } else {
                ImageIcon icon = new ImageIcon("src/img/error_icon_cross.png");
                icon = resizeIcon(icon, 48, 48);
                JOptionPane.showMessageDialog(parent, "Nie je to palindróm.\n" + Palindrome.getResult(), "Failure", JOptionPane.ERROR_MESSAGE, icon);
                textArea1.setText(null);
            }
        } else {
            ImageIcon icon = new ImageIcon("src/img/info_icon_i.png");
            icon = resizeIcon(icon, 48, 48);
            JOptionPane.showMessageDialog(parent, "Zadajte palindróm, ktorý je aspoň dva znaky dlhý...", "Error", JOptionPane.INFORMATION_MESSAGE, icon);
            textArea1.setText(null);
        }
    }

    private void confirmExit() {
        ImageIcon icon = new ImageIcon("src/img/confirm_icon_question_mark.png");
        icon = resizeIcon(icon, 48, 48);
        int confirmed = JOptionPane.showConfirmDialog(parent,
                "Are you sure you want to exit?" +
                        "\n\nCreated by Jakub Senko, 2020", "Exit",
                JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, icon);

        if (confirmed == JOptionPane.YES_OPTION) {
            dispose();
        } else {
            setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);
        }
    }

    private ImageIcon resizeIcon(ImageIcon icon, int width, int height) {
        Image img = icon.getImage();
        Image newimg = img.getScaledInstance(width, height,  java.awt.Image.SCALE_SMOOTH);
        return new ImageIcon(newimg);
    }
}
