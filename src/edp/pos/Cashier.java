/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package edp.pos;


import com.sun.jdi.connect.spi.Connection;
import java.awt.*;
import java.awt.geom.RoundRectangle2D;
import java.text.SimpleDateFormat;
import java.util.*;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.util.Date;
import javax.swing.Timer;

public class Cashier extends javax.swing.JFrame {
    
    private static final java.util.logging.Logger logger = java.util.logging.Logger.getLogger(Cashier.class.getName());

    String [][] row;
    String [] col = {"Barcode", "Item Name", "Quantity", "Price (₱)", "Subtotal (₱)"};
    DefaultTableModel cashierTable = new DefaultTableModel(row, col){
        @Override
        public boolean isCellEditable(int row, int col){
            return false;
        }  
    };
    
    private double calculateTotal() {
        double total = 0;
        for (int i = 0; i < cashierTable.getRowCount(); i++) {
            total += Double.parseDouble(cashierTable.getValueAt(i, 4).toString()); // column 4 = Subtotal
        }
        return total;
    }
    public Cashier() {
        initComponents();
        setLocationRelativeTo(null);
        
        transactionPanel.setBorder(BorderFactory.createTitledBorder("Transaction"));
        receiptPanel.setBorder(BorderFactory.createTitledBorder("Receipt"));
        paymentPanel.setBorder(BorderFactory.createTitledBorder("Payment"));
        
        quantityField.setText("1"); 
        quantityField.requestFocusInWindow();
        
        setShape(new RoundRectangle2D.Double(0, 0, getWidth(), getHeight(), 25, 25));
        
        scaleImage();
        
        lblUser.setText("Logged in as: "+Users.getStaff());
        
        Timer timer = new Timer(1000, e -> {
             String date = new SimpleDateFormat("yyyy-MM-dd").format(new Date());
             String time = new SimpleDateFormat("hh:mm a").format(new Date());
             lblDateTime.setText("<html><div style='text-align: right;'>" + date + "<br>" + time + "</div></html>");
        });
        timer.start();    
        
        // 👉 Setup numpad here
        numpadPanel.setLayout(new GridLayout(4, 3, 5, 5));

        // Buttons 1–9
        for (int i = 1; i <= 9; i++) {
            JButton btn = new JButton(String.valueOf(i));
            btn.setFont(new Font("Segoe UI", Font.BOLD, 70));
            btn.addActionListener(e -> {
                String current = quantityField.getText();
                quantityField.setText(current.equals("0") ? btn.getText() : current + btn.getText());
            });
            numpadPanel.add(btn);
        }

        // Zero button
        JButton zero = new JButton("0");
        zero.setFont(new Font("Segoe UI", Font.BOLD, 70));
        zero.addActionListener(e -> quantityField.setText(quantityField.getText() + "0"));
        numpadPanel.add(zero);

        // Clear button
        JButton clear = new JButton("Clear");
        clear.setFont(new Font("Segoe UI", Font.BOLD, 30));
        clear.addActionListener(e -> quantityField.setText("")); // reset
        numpadPanel.add(clear);

        // Enter button
        JButton enter = new JButton("Enter");
        enter.setFont(new Font("Segoe UI", Font.BOLD, 30));
        enter.addActionListener(e -> addItemBarcode.doClick()); // simulate pressing Add Item
        numpadPanel.add(enter);
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

        jButton7 = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        receiptPanel = new javax.swing.JPanel();
        jButton1 = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTextPane1 = new javax.swing.JTextPane();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        paymentPanel = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        barcodeField = new javax.swing.JTextField();
        addItemBarcode = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        quantityField = new javax.swing.JTextField();
        btnPayment = new javax.swing.JButton();
        btnDelete = new javax.swing.JButton();
        numpadPanel = new javax.swing.JPanel();
        transactionPanel = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        cashierJTable = new javax.swing.JTable();
        logo = new javax.swing.JLabel();
        lblDateTime = new javax.swing.JLabel();
        lblUser = new javax.swing.JLabel();

        jButton7.setText("jButton7");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);

        jPanel1.setBackground(new java.awt.Color(100, 150, 135));
        jPanel1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanel1.setForeground(new java.awt.Color(100, 150, 135));

        receiptPanel.setBackground(new java.awt.Color(100, 150, 135));
        receiptPanel.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        receiptPanel.setForeground(new java.awt.Color(100, 150, 135));
        receiptPanel.setToolTipText("");
        receiptPanel.setName(""); // NOI18N

        jButton1.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jButton1.setText("Menu");
        jButton1.addActionListener(this::jButton1ActionPerformed);

        jScrollPane1.setViewportView(jTextPane1);

        jButton2.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jButton2.setText("Print Receipt");

        jButton3.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jButton3.setText("Reset All");

        javax.swing.GroupLayout receiptPanelLayout = new javax.swing.GroupLayout(receiptPanel);
        receiptPanel.setLayout(receiptPanelLayout);
        receiptPanelLayout.setHorizontalGroup(
            receiptPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, receiptPanelLayout.createSequentialGroup()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 692, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(receiptPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(receiptPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jButton1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jButton3, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );
        receiptPanelLayout.setVerticalGroup(
            receiptPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(receiptPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(38, 38, 38)
                .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(41, 41, 41)
                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(receiptPanelLayout.createSequentialGroup()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 241, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        paymentPanel.setBackground(new java.awt.Color(100, 150, 135));
        paymentPanel.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        paymentPanel.setForeground(new java.awt.Color(100, 150, 135));

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel2.setText("BARCODE:");

        barcodeField.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        barcodeField.addActionListener(this::barcodeFieldActionPerformed);

        addItemBarcode.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        addItemBarcode.setText("Add Item");
        addItemBarcode.addActionListener(this::addItemBarcodeActionPerformed);

        jLabel3.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel3.setText("QUANTITY:");

        quantityField.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N

        btnPayment.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        btnPayment.setText("Process Payment");
        btnPayment.addActionListener(this::btnPaymentActionPerformed);

        btnDelete.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        btnDelete.setText("Void Item");
        btnDelete.addActionListener(this::btnDeleteActionPerformed);

        numpadPanel.setBackground(new java.awt.Color(100, 150, 135));
        numpadPanel.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        numpadPanel.setForeground(new java.awt.Color(100, 150, 135));

        javax.swing.GroupLayout numpadPanelLayout = new javax.swing.GroupLayout(numpadPanel);
        numpadPanel.setLayout(numpadPanelLayout);
        numpadPanelLayout.setHorizontalGroup(
            numpadPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        numpadPanelLayout.setVerticalGroup(
            numpadPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 452, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout paymentPanelLayout = new javax.swing.GroupLayout(paymentPanel);
        paymentPanel.setLayout(paymentPanelLayout);
        paymentPanelLayout.setHorizontalGroup(
            paymentPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(paymentPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(paymentPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(numpadPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(paymentPanelLayout.createSequentialGroup()
                        .addGroup(paymentPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2)
                            .addComponent(jLabel3))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(paymentPanelLayout.createSequentialGroup()
                        .addComponent(barcodeField, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(addItemBarcode, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(paymentPanelLayout.createSequentialGroup()
                        .addGroup(paymentPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(quantityField)
                            .addComponent(btnDelete, javax.swing.GroupLayout.DEFAULT_SIZE, 180, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnPayment, javax.swing.GroupLayout.PREFERRED_SIZE, 237, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        paymentPanelLayout.setVerticalGroup(
            paymentPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(paymentPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(paymentPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(addItemBarcode, javax.swing.GroupLayout.DEFAULT_SIZE, 50, Short.MAX_VALUE)
                    .addComponent(barcodeField, javax.swing.GroupLayout.DEFAULT_SIZE, 50, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(quantityField, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(paymentPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnDelete, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnPayment, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(numpadPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        transactionPanel.setBackground(new java.awt.Color(100, 150, 135));
        transactionPanel.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        transactionPanel.setForeground(new java.awt.Color(100, 150, 135));

        cashierJTable.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        cashierJTable.setModel(cashierTable);
        jScrollPane2.setViewportView(cashierJTable);

        javax.swing.GroupLayout transactionPanelLayout = new javax.swing.GroupLayout(transactionPanel);
        transactionPanel.setLayout(transactionPanelLayout);
        transactionPanelLayout.setHorizontalGroup(
            transactionPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 860, Short.MAX_VALUE)
        );
        transactionPanelLayout.setVerticalGroup(
            transactionPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(transactionPanelLayout.createSequentialGroup()
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 448, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        logo.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        logo.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        logo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/logo-light-transparent.png"))); // NOI18N
        logo.setPreferredSize(new java.awt.Dimension(300, 200));
        logo.addComponentListener(new java.awt.event.ComponentAdapter() {
            public void componentResized(java.awt.event.ComponentEvent evt) {
                logoComponentResized(evt);
            }
        });

        lblDateTime.setFont(new java.awt.Font("Arial", 1, 24)); // NOI18N
        lblDateTime.setForeground(new java.awt.Color(255, 255, 255));
        lblDateTime.setText(" ");

        lblUser.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        lblUser.setForeground(new java.awt.Color(255, 255, 255));

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(receiptPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(transactionPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(paymentPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(165, 165, 165)
                        .addComponent(logo, javax.swing.GroupLayout.PREFERRED_SIZE, 557, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblUser, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 262, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblDateTime, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 144, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(logo, javax.swing.GroupLayout.PREFERRED_SIZE, 97, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(lblDateTime)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lblUser, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(transactionPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(5, 5, 5)
                        .addComponent(receiptPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(paymentPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(40, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        SelectionAdmin sa = new SelectionAdmin();
        sa.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_jButton1ActionPerformed

    private void logoComponentResized(java.awt.event.ComponentEvent evt) {//GEN-FIRST:event_logoComponentResized

    }//GEN-LAST:event_logoComponentResized

    private void btnPaymentActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPaymentActionPerformed
//      double totalAmount = calculateTotal();
//
//      Payment payment = new Payment(totalAmount);
//      payment.setLocationRelativeTo(this);
//      payment.setVisible(true);

// Disable Cashier while Payment is open
    this.setEnabled(false);

    double totalAmount = calculateTotal();
    Payment p = new Payment(totalAmount);

    // Add a listener so when Payment closes, Cashier re‑enables
    p.addWindowListener(new java.awt.event.WindowAdapter() {
        @Override
        public void windowClosed(java.awt.event.WindowEvent e) {
            Cashier.this.setEnabled(true);
            Cashier.this.toFront(); // bring back focus
        }
    });

    p.setLocationRelativeTo(this);
    p.setVisible(true);

    }//GEN-LAST:event_btnPaymentActionPerformed

    private void addItemBarcodeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addItemBarcodeActionPerformed
       AddItemFromBarcode helper = new AddItemFromBarcode(cashierTable);
       helper.addItem(barcodeField.getText(), Integer.parseInt(quantityField.getText()));

       quantityField.setText("1");
       barcodeField.setText("");
       barcodeField.requestFocusInWindow();
    }//GEN-LAST:event_addItemBarcodeActionPerformed

    private void btnDeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDeleteActionPerformed
        int selectedRow = cashierJTable.getSelectedRow(); // get selected row index

        if (selectedRow != -1) { // -1 means no row selected
            DefaultTableModel model = (DefaultTableModel) cashierJTable.getModel();
            model.removeRow(selectedRow);
        } else {
            JOptionPane.showMessageDialog(this, "Please select an item to void.", "No Selection", JOptionPane.WARNING_MESSAGE);
        }
    }//GEN-LAST:event_btnDeleteActionPerformed

    private void barcodeFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_barcodeFieldActionPerformed
       AddItemFromBarcode helper = new AddItemFromBarcode(cashierTable);
       helper.addItem(barcodeField.getText(), Integer.parseInt(quantityField.getText()));

      
       quantityField.setText("1");
       barcodeField.setText("");
       barcodeField.requestFocusInWindow();
    }//GEN-LAST:event_barcodeFieldActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    javax.swing.JButton addItemBarcode;
    javax.swing.JTextField barcodeField;
    javax.swing.JButton btnDelete;
    javax.swing.JButton btnPayment;
    javax.swing.JTable cashierJTable;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton7;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTextPane jTextPane1;
    javax.swing.JLabel lblDateTime;
    javax.swing.JLabel lblUser;
    javax.swing.JLabel logo;
    javax.swing.JPanel numpadPanel;
    javax.swing.JPanel paymentPanel;
    javax.swing.JTextField quantityField;
    javax.swing.JPanel receiptPanel;
    javax.swing.JPanel transactionPanel;
    // End of variables declaration//GEN-END:variables
}
