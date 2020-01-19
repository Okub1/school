
import dialogy.NovyNakladnyPriestor;
import dialogy.PridajRuru;
import java.util.HashMap;
import javax.swing.JFrame;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;
import nakladanepolozky.Rura;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author bohacikj
 */
public class    AplikaciaNakladnyPriestorGUI extends javax.swing.JFrame {
    private NakladnyPriestor5 nakladnyPriestor;
    /**
     * Creates new form AplikaciaNakladnyPriestorGUI
     */
    public AplikaciaNakladnyPriestorGUI() {
        initComponents();
        //nastavenie aby vyzerala aplikacia ako win app
        try {
            //UIManager.setLookAndFeel(UIManager.getCrossPlatformLookAndFeelClassName());
            UIManager.setLookAndFeel("com.sun.java.swing.plaf.windows.WindowsLookAndFeel");
            //UIManager.setLookAndFeel("com.sun.java.swing.plaf.motif.MotifLookAndFeel");
            
            SwingUtilities.updateComponentTreeUI(this);
            this.pack();
        }catch(Exception e){
            System.out.println("Nepodporovany look and feel.");
        }
        
        nakladnyPriestor = null;
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        txpVypisy = new javax.swing.JTextPane();
        jMenuBar1 = new javax.swing.JMenuBar();
        mnuProgram = new javax.swing.JMenu();
        mniNovy = new javax.swing.JMenuItem();
        mniKoniec = new javax.swing.JMenuItem();
        mnuMoznosti = new javax.swing.JMenu();
        mniVypisNakladnyPriestor = new javax.swing.JMenuItem();
        mniPridajRuru = new javax.swing.JMenuItem();
        mniPridajKrokodila = new javax.swing.JMenuItem();
        mniPridajZamestnanca = new javax.swing.JMenuItem();
        mniPridajAgenturnehoPracovnika = new javax.swing.JMenuItem();
        mniPridajTehlu = new javax.swing.JMenuItem();
        mniPridajPomaranc = new javax.swing.JMenuItem();
        mniPridajCukrik = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Nakladny priestor");

        jScrollPane1.setViewportView(txpVypisy);

        mnuProgram.setText("Program");

        mniNovy.setText("Novy");
        mniNovy.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mniNovyActionPerformed(evt);
            }
        });
        mnuProgram.add(mniNovy);

        mniKoniec.setText("Koniec");
        mniKoniec.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mniKoniecActionPerformed(evt);
            }
        });
        mnuProgram.add(mniKoniec);

        jMenuBar1.add(mnuProgram);

        mnuMoznosti.setText("Moznosti");
        mnuMoznosti.setEnabled(false);

        mniVypisNakladnyPriestor.setText("Vypis Nakladny priestor");
        mniVypisNakladnyPriestor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mniVypisNakladnyPriestorActionPerformed(evt);
            }
        });
        mnuMoznosti.add(mniVypisNakladnyPriestor);

        mniPridajRuru.setText("Pridaj Ruru");
        mniPridajRuru.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mniPridajRuruActionPerformed(evt);
            }
        });
        mnuMoznosti.add(mniPridajRuru);

        mniPridajKrokodila.setText("Pridaj Krokodila");
        mnuMoznosti.add(mniPridajKrokodila);

        mniPridajZamestnanca.setText("Pridaj Zamestnanca");
        mnuMoznosti.add(mniPridajZamestnanca);

        mniPridajAgenturnehoPracovnika.setText("Pridaj Agenturneho pracovnika");
        mnuMoznosti.add(mniPridajAgenturnehoPracovnika);

        mniPridajTehlu.setText("Pridaj Tehlu");
        mnuMoznosti.add(mniPridajTehlu);

        mniPridajPomaranc.setText("Pridaj Pomaranc");
        mnuMoznosti.add(mniPridajPomaranc);

        mniPridajCukrik.setText("Pridaj Cukrik");
        mnuMoznosti.add(mniPridajCukrik);

        jMenuBar1.add(mnuMoznosti);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 380, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 257, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void mniKoniecActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mniKoniecActionPerformed
        // TODO add your handling code here:
        System.exit(0);
    }//GEN-LAST:event_mniKoniecActionPerformed

    private void mniNovyActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mniNovyActionPerformed
        // TODO add your handling code here:
        
        HashMap<String,Object> preberaneUdaje = new HashMap<String,Object>();
        
        JFrame hlavnaAplikacia = this;
        
                
        NovyNakladnyPriestor dialog = new NovyNakladnyPriestor(
                        hlavnaAplikacia, true, preberaneUdaje); 
        dialog.setVisible(true);
        
        if(preberaneUdaje.get("chyba").equals("true")) {
            //nakladny priesot sa neda vytvorit z danych udajov
        } else {
        
       nakladnyPriestor = new NakladnyPriestor5(
                ((Integer)preberaneUdaje.get("maxPocetKrokodilov")).intValue(),
                ((Integer)preberaneUdaje.get("maxPocetPracovnikov")).intValue(),
                ((Double)preberaneUdaje.get("maxHmotnost")).doubleValue()
            );
       
        mnuMoznosti.setEnabled(true);
        }
    }//GEN-LAST:event_mniNovyActionPerformed

    private void mniVypisNakladnyPriestorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mniVypisNakladnyPriestorActionPerformed
        // TODO add your handling code here:
        
        String vysl = nakladnyPriestor.toString();
        
        if(txpVypisy.getText().equals("")){
            txpVypisy.setText(vysl);
        }else{
            txpVypisy.setText(txpVypisy.getText() + "\n\n" + vysl);
        }
    }//GEN-LAST:event_mniVypisNakladnyPriestorActionPerformed

    private void mniPridajRuruActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mniPridajRuruActionPerformed
        // TODO add your handling code here:
        
        HashMap<String,Object> preberaneUdaje = new HashMap<String,Object>();
        
        JFrame hlavnaAplikacia = this;
        
                
        PridajRuru dialog = new PridajRuru(
                        hlavnaAplikacia, true, preberaneUdaje); 
        dialog.setVisible(true);
        
        if(preberaneUdaje.get("chyba").equals("true")) {
            System.out.println("nic sa neprebera");
        } else {
            Rura r = new Rura ((String)preberaneUdaje.get("evidencneCislo"),
                    (Double) preberaneUdaje.get("hmotnost"),
                    (Double) preberaneUdaje.get("dlzka")
            );
            
            boolean vysl = nakladnyPriestor.pridajPolozku(r);
            if (!vysl) {
                String text = "CHYBA: RURU SA NEPODARILO PRIDAT.\n";
                if(txpVypisy.getText().equals("")) {
                    txpVypisy.setText(text);
                } else {
                    txpVypisy.setText(txpVypisy.getText() + "\n\n" + text);
                }
            }
            
        }
        
    }//GEN-LAST:event_mniPridajRuruActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(AplikaciaNakladnyPriestorGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(AplikaciaNakladnyPriestorGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(AplikaciaNakladnyPriestorGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(AplikaciaNakladnyPriestorGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new AplikaciaNakladnyPriestorGUI().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JMenuItem mniKoniec;
    private javax.swing.JMenuItem mniNovy;
    private javax.swing.JMenuItem mniPridajAgenturnehoPracovnika;
    private javax.swing.JMenuItem mniPridajCukrik;
    private javax.swing.JMenuItem mniPridajKrokodila;
    private javax.swing.JMenuItem mniPridajPomaranc;
    private javax.swing.JMenuItem mniPridajRuru;
    private javax.swing.JMenuItem mniPridajTehlu;
    private javax.swing.JMenuItem mniPridajZamestnanca;
    private javax.swing.JMenuItem mniVypisNakladnyPriestor;
    private javax.swing.JMenu mnuMoznosti;
    private javax.swing.JMenu mnuProgram;
    private javax.swing.JTextPane txpVypisy;
    // End of variables declaration//GEN-END:variables
}