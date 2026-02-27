package edp.pos;

import javax.swing.*;
import java.util.*;

public class Login extends javax.swing.JFrame {
    
    private static final java.util.logging.Logger logger = java.util.logging.Logger.getLogger(Login.class.getName());

    public Login() {
        initComponents();
        setLocationRelativeTo(null);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        btnLogin = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        txtUsername = new javax.swing.JTextField();
        btnExit = new javax.swing.JButton();
        txtPassword = new javax.swing.JPasswordField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(0, 102, 102));
        setLocationByPlatform(true);

        btnLogin.setText("Login");
        btnLogin.addActionListener(this::btnLoginActionPerformed);

        jLabel1.setText("WELCOME");

        jLabel2.setText("User");

        jLabel3.setText("Pass");

        txtUsername.setText(" ");
        txtUsername.addActionListener(this::txtUsernameActionPerformed);

        btnExit.setText("Exit");
        btnExit.addActionListener(this::btnExitActionPerformed);

        txtPassword.addActionListener(this::txtPasswordActionPerformed);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(157, 157, 157)
                        .addComponent(jLabel1))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(102, 102, 102)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(btnLogin)
                                .addGap(52, 52, 52)
                                .addComponent(btnExit))
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                    .addComponent(jLabel3)
                                    .addGap(18, 18, 18)
                                    .addComponent(txtPassword))
                                .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                    .addComponent(jLabel2)
                                    .addGap(18, 18, 18)
                                    .addComponent(txtUsername, javax.swing.GroupLayout.PREFERRED_SIZE, 118, javax.swing.GroupLayout.PREFERRED_SIZE))))))
                .addContainerGap(109, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(68, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addGap(24, 24, 24)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(txtUsername, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(txtPassword, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(34, 34, 34)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnLogin)
                    .addComponent(btnExit))
                .addGap(79, 79, 79))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents
    private void defaultAdminExists() {
        for (Users acc : Users.accts) {
            if (acc.getUsername().equals("admin")) {
                return;
            }
        }
        Users.accts.add(new Users("admin", "admin", "Administrator"));
    }

    private void btnLoginActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLoginActionPerformed
    String userL = txtUsername.getText().trim();
    String passL = new String(txtPassword.getPassword()).trim();

    if (userL.isEmpty() || passL.isEmpty()) {
        JOptionPane.showMessageDialog(this, "Fields cannot be empty", "Error", JOptionPane.WARNING_MESSAGE);
        return;
    }

    defaultAdminExists();
    Users matchedUser = null;
    for (Users acc : Users.accts) {
        if (userL.equals(acc.getUsername()) && passL.equals(acc.getPassword())) {
            matchedUser = acc;
            break;
        }
    }

    if (matchedUser != null) {
        JOptionPane.showMessageDialog(this, "Welcome, " + matchedUser.getEmployeeName(), "Login Successful", JOptionPane.INFORMATION_MESSAGE);

        if (matchedUser.getUsername().equalsIgnoreCase("admin")) {
            Users.setAdmin(true);
            Users.setStaff("Administrator");
            new SelectionAdmin().setVisible(true);
        } else {
            Users.setAdmin(false);
            Users.setStaff(matchedUser.getEmployeeName());
            new SelectionCashier().setVisible(true);
        }
        this.dispose();
    } else {
        JOptionPane.showMessageDialog(this, "Invalid username or password!", "Invalid Login", JOptionPane.ERROR_MESSAGE);
    }
    }//GEN-LAST:event_btnLoginActionPerformed
     
    private void txtUsernameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtUsernameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtUsernameActionPerformed

    private void btnExitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnExitActionPerformed
            int x = JOptionPane.showConfirmDialog(this, "Are you sure you want to exit?", "Exit Form", JOptionPane.YES_NO_OPTION);
    if (x == JOptionPane.YES_OPTION) {
        System.exit(0);
    }

    }//GEN-LAST:event_btnExitActionPerformed

    private void txtPasswordActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtPasswordActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtPasswordActionPerformed

    
    public static void main(String args[]) {
 
        java.awt.EventQueue.invokeLater(() -> new Login().setVisible(true));
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnExit;
    private javax.swing.JButton btnLogin;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPasswordField txtPassword;
    private javax.swing.JTextField txtUsername;
    // End of variables declaration//GEN-END:variables
}
