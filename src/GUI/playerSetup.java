/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package GUI;

/**import GUI.gameBoard; 

/**
 *
 * @author Nate
 */
public class playerSetup extends javax.swing.JFrame {

    /**
     * Creates the form for the Players to set up their names and colors
     */
    public playerSetup() {
        initComponents();
    }
String playerOneName;
String playerTwoName;
String playerOneColor;
String playerTwoColor;
boolean playerOneReady = false;
boolean playerTwoReady = false;
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        jTextArea1 = new javax.swing.JTextArea();
        playerTwoInput = new javax.swing.JTextField();
        playerOneInput = new javax.swing.JTextField();
        gameStart = new javax.swing.JButton();
        playerOneDone = new javax.swing.JButton();
        playerTwoDone = new javax.swing.JButton();
        playerOneDrop = new javax.swing.JComboBox<>();
        playerTwoDrop = new javax.swing.JComboBox<>();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();

        jTextArea1.setColumns(20);
        jTextArea1.setRows(5);
        jScrollPane1.setViewportView(jTextArea1);

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setSize(new java.awt.Dimension(800, 550));

        playerTwoInput.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        playerTwoInput.setHorizontalAlignment(javax.swing.JTextField.LEFT);
        playerTwoInput.setName("playerTwoInput"); // NOI18N

        playerOneInput.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        playerOneInput.setHorizontalAlignment(javax.swing.JTextField.LEFT);
        playerOneInput.setName("playerOneInput"); // NOI18N
        playerOneInput.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                playerOneInputActionPerformed(evt);
            }
        });

        gameStart.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        gameStart.setText("Start");
        gameStart.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                gameStartActionPerformed(evt);
            }
        });

        playerOneDone.setText("Done");
        playerOneDone.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                playerOneDoneActionPerformed(evt);
            }
        });

        playerTwoDone.setText("Done");
        playerTwoDone.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                playerTwoDoneActionPerformed(evt);
            }
        });

        playerOneDrop.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        playerOneDrop.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Red", "Blue", "Black", "White" }));

        playerTwoDrop.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        playerTwoDrop.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Blue", "Red", "White", "Black" }));

        jLabel1.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Player 1");

        jLabel2.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("Player 2");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(275, 275, 275)
                .addComponent(playerOneDone, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(616, 616, 616)
                .addComponent(playerTwoDone, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(275, 275, 275))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(250, 250, 250)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(566, 566, 566)
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(250, 250, 250))
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(200, 200, 200)
                        .addComponent(playerOneInput, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(466, 466, 466)
                        .addComponent(playerTwoInput, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(583, 583, 583)
                        .addComponent(gameStart, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(200, 200, 200))
            .addGroup(layout.createSequentialGroup()
                .addGap(225, 225, 225)
                .addComponent(playerOneDrop, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(516, 516, 516)
                .addComponent(playerTwoDrop, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(225, 225, 225))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(74, 74, 74)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(64, 64, 64)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(playerOneInput, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(playerTwoInput, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(111, 111, 111)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(playerTwoDrop, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(playerOneDrop, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(89, 89, 89)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(playerOneDone, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(playerTwoDone, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(gameStart, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    /**
     * This method will check to see if both players are ready to start and 
     * create a new gameBoard object to play on moving on from the character creation
     * screen
     * @param evt An event signifying the Start Button was pressed
     */
    private void gameStartActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_gameStartActionPerformed
        if (playerOneReady && playerTwoReady)
        {
            this.setVisible(false);
            new gameBoard().setVisible(true);
        } else {
            
        }
    }//GEN-LAST:event_gameStartActionPerformed
    /**
     * This method will signify Player 1 is Done and have their username for the
     * game set along with the color of their pieces while preventing them from
     * editing their name/color further
     * @param evt An event signifying the Player 1 Done Button was pressed
     */
    private void playerOneDoneActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_playerOneDoneActionPerformed
        playerOneInput.setEditable(false);
        playerOneDrop.setEnabled(false);
        playerOneName = playerOneInput.getText();
        playerOneColor = (String)playerOneDrop.getSelectedItem();
        playerOneReady = true;
    }//GEN-LAST:event_playerOneDoneActionPerformed
    /**
     * This method will signify Player 2 is Done and has their username for the
     * game set along with the color of their pieces while preventing them from
     * editing their name/color further
     * @param evt An event signifying the Player 2 Done Button was pressed
     */
    private void playerTwoDoneActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_playerTwoDoneActionPerformed
        playerTwoInput.setEditable(false);
        playerTwoDrop.setEnabled(false);
        playerTwoName = playerTwoInput.getText();
        playerTwoColor = (String)playerTwoDrop.getSelectedItem();
        playerTwoReady = true;
    }//GEN-LAST:event_playerTwoDoneActionPerformed

    private void playerOneInputActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_playerOneInputActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_playerOneInputActionPerformed
    
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
            java.util.logging.Logger.getLogger(playerSetup.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(playerSetup.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(playerSetup.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(playerSetup.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new playerSetup().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton gameStart;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextArea jTextArea1;
    private javax.swing.JButton playerOneDone;
    private javax.swing.JComboBox<String> playerOneDrop;
    private javax.swing.JTextField playerOneInput;
    private javax.swing.JButton playerTwoDone;
    private javax.swing.JComboBox<String> playerTwoDrop;
    private javax.swing.JTextField playerTwoInput;
    // End of variables declaration//GEN-END:variables
}
