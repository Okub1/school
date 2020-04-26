import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Window extends JFrame{
    private JButton button1;
    private JPanel mainPanel;
    private JTextArea textArea1;
    private JSpinner spinner1;

    public Window(String title) throws HeadlessException {
        super(title);
        try {
            UIManager.setLookAndFeel("com.sun.java.swing.plaf.windows.WindowsLookAndFeel");
        } catch (Exception e) {
            e.printStackTrace();
        }

        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setContentPane(mainPanel);

        setSize(500, 300);
        setLocationRelativeTo(null);
        setVisible(true);

        JFrame parent = this;


        button1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int input = JOptionPane.showConfirmDialog(parent, "Are you sure?", "Confirm",
                        JOptionPane.OK_CANCEL_OPTION, JOptionPane.INFORMATION_MESSAGE);
                // 0 = yes 2 = cancel

                if (input == 0) {
                    int value = (Integer) spinner1.getValue();
                    textArea1.setText(PascalTriangle.notUsingFactorial(value));
                }
            }
        });

    }
}
