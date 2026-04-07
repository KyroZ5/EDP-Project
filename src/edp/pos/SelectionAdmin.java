package edp.pos;

import java.awt.Image;
import java.awt.geom.RoundRectangle2D;
import javax.swing.ImageIcon;

public class SelectionAdmin extends javax.swing.JFrame {
    
    private static final java.util.logging.Logger logger = java.util.logging.Logger.getLogger(SelectionAdmin.class.getName());

    public SelectionAdmin() {
        initComponents();
        setLocationRelativeTo(null);
        
        setShape(new RoundRectangle2D.Double(0, 0, getWidth(), getHeight(), 25, 25));
        
        btnInventory();
        btnCashier();
        btnAccounts();
        btnTransactions();
        scaleImage();
    }
    
    public void scaleImage(){
        ImageIcon icon = new ImageIcon("C:\\Users\\My PC\\OneDrive\\Documents\\NetBeansProjects\\EDP-POS\\src\\img\\logo-light-transparent.png");
        Image img = icon.getImage();
        Image imgScale = img.getScaledInstance(logo.getWidth(), logo.getHeight(), Image.SCALE_SMOOTH);
        ImageIcon scaledIcon = new ImageIcon(imgScale);
        logo.setIcon(scaledIcon);
    }
    
    public void btnInventory(){
        ImageIcon icon = new ImageIcon("C:\\Users\\My PC\\OneDrive\\Documents\\NetBeansProjects\\EDP-POS\\src\\img\\7.png");
        Image img = icon.getImage();
        Image imgScale = img.getScaledInstance(btnInventory.getWidth(), btnInventory.getHeight(), Image.SCALE_SMOOTH);
        ImageIcon scaledIcon = new ImageIcon(imgScale);
        btnInventory.setIcon(scaledIcon);
    }
    
    public void btnCashier(){
        ImageIcon icon = new ImageIcon("C:\\Users\\My PC\\OneDrive\\Documents\\NetBeansProjects\\EDP-POS\\src\\img\\8.png");
        Image img = icon.getImage();
        Image imgScale = img.getScaledInstance(btnCashier.getWidth(), btnCashier.getHeight(), Image.SCALE_SMOOTH);
        ImageIcon scaledIcon = new ImageIcon(imgScale);
        btnCashier.setIcon(scaledIcon);
    }
    
    public void btnAccounts(){
        ImageIcon icon = new ImageIcon("C:\\Users\\My PC\\OneDrive\\Documents\\NetBeansProjects\\EDP-POS\\src\\img\\9.png");
        Image img = icon.getImage();
        Image imgScale = img.getScaledInstance(btnAccounts.getWidth(), btnAccounts.getHeight(), Image.SCALE_SMOOTH);
        ImageIcon scaledIcon = new ImageIcon(imgScale);
        btnAccounts.setIcon(scaledIcon);
    }
    
    public void btnTransactions(){
        ImageIcon icon = new ImageIcon("C:\\Users\\My PC\\OneDrive\\Documents\\NetBeansProjects\\EDP-POS\\src\\img\\10.png");
        Image img = icon.getImage();
        Image imgScale = img.getScaledInstance(btnTransactions.getWidth(), btnTransactions.getHeight(), Image.SCALE_SMOOTH);
        ImageIcon scaledIcon = new ImageIcon(imgScale);
        btnTransactions.setIcon(scaledIcon);
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        btnTransactions = new javax.swing.JButton();
        btnInventory = new javax.swing.JButton();
        btnAccounts = new javax.swing.JButton();
        btnCashier = new javax.swing.JButton();
        btnLogout = new javax.swing.JButton();
        logo = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);
        setSize(new java.awt.Dimension(150, 150));

        jPanel1.setBackground(new java.awt.Color(100, 150, 135));
        jPanel1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanel1.setForeground(new java.awt.Color(100, 150, 135));

        btnTransactions.addActionListener(this::btnTransactionsActionPerformed);

        btnInventory.addActionListener(this::btnInventoryActionPerformed);

        btnAccounts.addActionListener(this::btnAccountsActionPerformed);

        btnCashier.addActionListener(this::btnCashierActionPerformed);

        btnLogout.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnLogout.setText("Logout");
        btnLogout.addActionListener(this::btnLogoutActionPerformed);

        logo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/logo-light-transparent.png"))); // NOI18N
        logo.setText(" ");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnInventory, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(31, 31, 31)
                .addComponent(btnCashier, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(28, 28, 28)
                .addComponent(btnAccounts, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(30, 30, 30)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnLogout, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnTransactions, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(26, 26, 26))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(323, 323, 323)
                .addComponent(logo, javax.swing.GroupLayout.PREFERRED_SIZE, 213, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(12, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(logo, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnAccounts, javax.swing.GroupLayout.PREFERRED_SIZE, 97, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnTransactions, javax.swing.GroupLayout.PREFERRED_SIZE, 97, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(btnCashier, javax.swing.GroupLayout.PREFERRED_SIZE, 97, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(btnInventory, javax.swing.GroupLayout.PREFERRED_SIZE, 97, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(27, 27, 27)
                .addComponent(btnLogout)
                .addGap(30, 30, 30))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 240, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnInventoryActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnInventoryActionPerformed
        InventoryAdmin i = new InventoryAdmin();
        i.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_btnInventoryActionPerformed

    private void btnLogoutActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLogoutActionPerformed
       Login l = new Login();
       l.setVisible(true);
       this.dispose();
    }//GEN-LAST:event_btnLogoutActionPerformed

    private void btnAccountsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAccountsActionPerformed
       Accounts a = new Accounts();
       a.setVisible(true);
       this.setVisible(false);
    }//GEN-LAST:event_btnAccountsActionPerformed

    private void btnCashierActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCashierActionPerformed
        Cashier ca = new Cashier("ADMIN");
        ca.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_btnCashierActionPerformed

    private void btnTransactionsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTransactionsActionPerformed
        Transactions tr = new Transactions();
        tr.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_btnTransactionsActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    javax.swing.JButton btnAccounts;
    javax.swing.JButton btnCashier;
    javax.swing.JButton btnInventory;
    private javax.swing.JButton btnLogout;
    javax.swing.JButton btnTransactions;
    private javax.swing.JPanel jPanel1;
    javax.swing.JLabel logo;
    // End of variables declaration//GEN-END:variables
}
