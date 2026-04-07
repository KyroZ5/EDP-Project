package edp.pos;

import java.awt.Image;
import javax.swing.ImageIcon;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;

public class UpdateAccount extends javax.swing.JFrame {
   
    public UpdateAccount() {
        initComponents();
        setLocationRelativeTo(null);
        setTitle("Account Creation");
        
        scaleImage();   
    }
    private int accountId; // store the ID for updating

    public UpdateAccount(int id, String name, String username, String password) {
        initComponents();
        setLocationRelativeTo(null);
        setTitle("Update Account");

        this.accountId = id;
        nameField.setText(name);
        userField.setText(username);
        passField.setText(password);

        scaleImage();
    }

    public void scaleImage(){
        ImageIcon icon = new ImageIcon("C:\\Users\\My PC\\OneDrive\\Documents\\NetBeansProjects\\EDP-POS\\src\\img\\logo-light-transparent.png");
        Image img = icon.getImage();
        Image imgScale = img.getScaledInstance(logo.getWidth(), logo.getHeight(), Image.SCALE_SMOOTH);
        ImageIcon scaledIcon = new ImageIcon(imgScale);
        logo.setIcon(scaledIcon);
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        logo = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        btnConfirm = new javax.swing.JButton();
        btnCancel = new javax.swing.JButton();
        nameField = new javax.swing.JTextField();
        userField = new javax.swing.JTextField();
        passField = new javax.swing.JPasswordField();
        roleBox = new javax.swing.JComboBox<>();
        jLabel6 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);

        jPanel1.setBackground(new java.awt.Color(100, 150, 135));
        jPanel1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanel1.setForeground(new java.awt.Color(100, 150, 135));
        jPanel1.setName(""); // NOI18N
        jPanel1.setNextFocusableComponent(nameField);

        logo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/logo-light-transparent.png"))); // NOI18N
        logo.setText("logo");

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel2.setText("UPDATE ACCOUNT");

        jLabel3.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel3.setText("Name:");

        jLabel4.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel4.setText("Username:");

        jLabel5.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel5.setText("Password:");

        btnConfirm.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        btnConfirm.setText("Confirm");
        btnConfirm.addActionListener(this::btnConfirmActionPerformed);

        btnCancel.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        btnCancel.setText("Cancel");
        btnCancel.addActionListener(this::btnCancelActionPerformed);

        nameField.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        nameField.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                nameFieldFocusGained(evt);
            }
        });

        userField.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N

        passField.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N

        roleBox.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        roleBox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Cashier", "Admin" }));
        roleBox.addActionListener(this::roleBoxActionPerformed);

        jLabel6.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel6.setText("Role:");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(62, 62, 62)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(logo, javax.swing.GroupLayout.PREFERRED_SIZE, 284, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel3)
                            .addComponent(jLabel4)
                            .addComponent(jLabel5)
                            .addComponent(jLabel6))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(roleBox, javax.swing.GroupLayout.PREFERRED_SIZE, 192, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(userField)
                                .addComponent(passField, javax.swing.GroupLayout.DEFAULT_SIZE, 192, Short.MAX_VALUE)
                                .addComponent(nameField))))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(btnCancel, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(70, 70, 70)
                        .addComponent(btnConfirm, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(81, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel2)
                .addGap(131, 131, 131))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addComponent(logo, javax.swing.GroupLayout.PREFERRED_SIZE, 62, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel2)
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(nameField, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(userField, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel4))
                        .addGap(21, 21, 21)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(passField, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel5)))
                    .addComponent(jLabel3))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(roleBox, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 66, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnCancel, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnConfirm, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(41, 41, 41))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnConfirmActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnConfirmActionPerformed
        String name = nameField.getText().trim();
        String username = userField.getText().trim();
        String password = new String(passField.getPassword()).trim();

        if (name.isEmpty() || username.isEmpty() || password.isEmpty()) {
            JOptionPane.showMessageDialog(this, "All fields must be filled!", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }
        String role = roleBox.getSelectedItem().toString();
        boolean success = UpdateAccountSQL.updateAccount(accountId, name, username, password, role);
        if (success) {
            JOptionPane.showMessageDialog(this, "Account Updated Successfully!", "Success", JOptionPane.INFORMATION_MESSAGE);
            this.dispose();
        } else {
            JOptionPane.showMessageDialog(this, "Failed to update account.", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_btnConfirmActionPerformed

    private void btnCancelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelActionPerformed
        int x = JOptionPane.showConfirmDialog(this, "Are you sure you want to Cancel?", "Exit Update Account", JOptionPane.YES_NO_OPTION);
        if (x == JOptionPane.YES_OPTION) {
           //System.exit(0);
            this.dispose();
        }   
    }//GEN-LAST:event_btnCancelActionPerformed

    private void nameFieldFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_nameFieldFocusGained
        // TODO add your handling code here:
    }//GEN-LAST:event_nameFieldFocusGained

    private void roleBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_roleBoxActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_roleBoxActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    javax.swing.JButton btnCancel;
    javax.swing.JButton btnConfirm;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel1;
    javax.swing.JLabel logo;
    javax.swing.JTextField nameField;
    javax.swing.JPasswordField passField;
    javax.swing.JComboBox<String> roleBox;
    javax.swing.JTextField userField;
    // End of variables declaration//GEN-END:variables
}
