package edp.pos;

import java.awt.Font;
import java.awt.GridLayout;
import java.awt.geom.RoundRectangle2D;
import javax.swing.JButton;
import javax.swing.JOptionPane;

public class Payment extends javax.swing.JFrame {

    private static final java.util.logging.Logger logger = java.util.logging.Logger.getLogger(Payment.class.getName());
    private double totalAmount;
    private double cashReceived;

    private boolean confirmed = false;

    public boolean isConfirmed() {
        return confirmed;
    }

    public Payment(double totalAmount) {
        initComponents();
        setLocationRelativeTo(null);
        this.totalAmount = totalAmount;
        lblTotal.setText("Total: ₱" + totalAmount);
        setupNumpad(); // always build numpad
    }

    public Payment() {
        initComponents();
        setLocationRelativeTo(null);
        setupNumpad(); 
    }

    private void setupNumpad() {
        numpadPanel.removeAll();
        numpadPanel.setLayout(new GridLayout(4, 3, 5, 5));

        for (int i = 1; i <= 9; i++) {
            JButton btn = new JButton(String.valueOf(i));
            btn.setFont(new Font("Segoe UI", Font.BOLD, 60));
            btn.addActionListener(e -> {
                String current = cashField.getText();
                cashField.setText(current.equals("0") ? btn.getText() : current + btn.getText());
            });
            numpadPanel.add(btn);
        }

        JButton zero = new JButton("0");
        zero.setFont(new Font("Segoe UI", Font.BOLD, 60));
        zero.addActionListener(e -> cashField.setText(cashField.getText() + "0"));
        numpadPanel.add(zero);

        JButton clear = new JButton("Clear");
        clear.setFont(new Font("Segoe UI", Font.BOLD, 30));
        clear.addActionListener(e -> cashField.setText(""));
        numpadPanel.add(clear);

        JButton enter = new JButton("Enter");
        enter.setFont(new Font("Segoe UI", Font.BOLD, 30));
        enter.addActionListener(e -> btnConfirm.doClick()); // simulate Confirm
        numpadPanel.add(enter);

        numpadPanel.revalidate();
        numpadPanel.repaint();
    }

    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        btnCancel = new javax.swing.JButton();
        btnConfirm = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        lblTotal = new javax.swing.JLabel();
        lblChange = new javax.swing.JLabel();
        cashField = new javax.swing.JTextField();
        numpadPanel = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setAlwaysOnTop(true);
        setUndecorated(true);
        setResizable(false);

        jPanel1.setBackground(new java.awt.Color(100, 150, 135));
        jPanel1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanel1.setForeground(new java.awt.Color(100, 150, 135));

        btnCancel.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        btnCancel.setText("Cancel");
        btnCancel.addActionListener(this::btnCancelActionPerformed);

        btnConfirm.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        btnConfirm.setText("Confirm");
        btnConfirm.addActionListener(this::btnConfirmActionPerformed);

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 36)); // NOI18N
        jLabel1.setText("Cash Received:");

        lblTotal.setFont(new java.awt.Font("Segoe UI", 1, 36)); // NOI18N
        lblTotal.setText("Total:");

        lblChange.setFont(new java.awt.Font("Segoe UI", 1, 36)); // NOI18N
        lblChange.setText("Change: ₱0.0");

        cashField.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N

        numpadPanel.setBackground(new java.awt.Color(100, 150, 135));
        numpadPanel.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        numpadPanel.setForeground(new java.awt.Color(100, 150, 135));
        numpadPanel.setFocusCycleRoot(true);

        javax.swing.GroupLayout numpadPanelLayout = new javax.swing.GroupLayout(numpadPanel);
        numpadPanel.setLayout(numpadPanelLayout);
        numpadPanelLayout.setHorizontalGroup(
            numpadPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 365, Short.MAX_VALUE)
        );
        numpadPanelLayout.setVerticalGroup(
            numpadPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 386, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addComponent(btnCancel, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnConfirm, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(22, 22, 22))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(86, 86, 86)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblTotal)
                    .addComponent(lblChange)
                    .addComponent(jLabel1)
                    .addComponent(cashField, javax.swing.GroupLayout.PREFERRED_SIZE, 337, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(147, 147, 147)
                .addComponent(numpadPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(cashField, javax.swing.GroupLayout.PREFERRED_SIZE, 56, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(71, 71, 71)
                        .addComponent(lblTotal)
                        .addGap(82, 82, 82)
                        .addComponent(lblChange))
                    .addComponent(numpadPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 85, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnConfirm, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnCancel, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(20, 20, 20))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnCancelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelActionPerformed
        int x = JOptionPane.showConfirmDialog(this, "Are you sure you want to Cancel?", "Exit Payment", JOptionPane.YES_NO_OPTION);
        if (x == JOptionPane.YES_OPTION) {
            confirmed = false;
            this.dispose();
        }
    }//GEN-LAST:event_btnCancelActionPerformed

    private void btnConfirmActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnConfirmActionPerformed
        try {
        cashReceived = Double.parseDouble(cashField.getText());
        double change = cashReceived - totalAmount;

        if (change < 0) {
            JOptionPane.showMessageDialog(this, "Insufficient cash!", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        lblChange.setText("Change: ₱" + change);
        JOptionPane.showMessageDialog(this, "Change to give: ₱" + change, "Payment Successful", JOptionPane.INFORMATION_MESSAGE);

        confirmed = true;   // ✅ mark as confirmed
        this.dispose();
    } catch (NumberFormatException e) {
        JOptionPane.showMessageDialog(this, "Invalid cash input!", "Error", JOptionPane.ERROR_MESSAGE);
    }                                         
    }//GEN-LAST:event_btnConfirmActionPerformed
    
    public double getCashReceived() {
    return cashReceived;
    }


    // Variables declaration - do not modify//GEN-BEGIN:variables
    javax.swing.JButton btnCancel;
    javax.swing.JButton btnConfirm;
    javax.swing.JTextField cashField;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    javax.swing.JLabel lblChange;
    private javax.swing.JLabel lblTotal;
    javax.swing.JPanel numpadPanel;
    // End of variables declaration//GEN-END:variables
}
