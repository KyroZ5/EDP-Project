package edp.pos;


import com.sun.jdi.connect.spi.Connection;
import java.awt.*;
import java.awt.geom.RoundRectangle2D;
import java.text.SimpleDateFormat;
import static java.time.Instant.now;
import java.util.*;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.util.Date;
import javax.print.Doc;
import javax.print.DocFlavor;
import javax.print.DocPrintJob;
import javax.print.PrintService;
import javax.print.PrintServiceLookup;
import javax.print.SimpleDoc;
import javax.print.attribute.HashPrintRequestAttributeSet;
import javax.print.attribute.PrintRequestAttributeSet;
import javax.print.attribute.standard.Copies;
import javax.print.attribute.standard.JobName;
import javax.swing.Timer;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.JTableHeader;

public class Cashier extends javax.swing.JFrame {

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
    
    private String currentRole;
    
    public Cashier(String role) {
        initComponents();
        this.currentRole = role;
        setLocationRelativeTo(null);
        btnPrint.setEnabled(false);
        btnVoid.setEnabled(false);

        transactionPanel.setBorder(BorderFactory.createTitledBorder("Transaction"));
        receiptPanel.setBorder(BorderFactory.createTitledBorder("Receipt"));
        paymentPanel.setBorder(BorderFactory.createTitledBorder("Payment"));
        
        quantityField.setText("1"); 
        quantityField.requestFocusInWindow();
        
        setShape(new RoundRectangle2D.Double(0, 0, getWidth(), getHeight(), 25, 25));
        
        scaleImage();
        lblUser.setText("Logged in as: "+ Users.getCurrentName() + " (" + Users.getCurrentRole() + ")");

            // Get the header of the actual table in your form
          JTableHeader header = cashierJTable.getTableHeader();

          // Change font (bold + bigger)
          header.setFont(new Font("Segoe UI", Font.BOLD, 25));

          // Optional: center header text
          DefaultTableCellRenderer renderer = (DefaultTableCellRenderer) header.getDefaultRenderer();
          renderer.setHorizontalAlignment(SwingConstants.CENTER);

          // Center all rows in the table
          DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
          centerRenderer.setHorizontalAlignment(SwingConstants.CENTER);

          // Apply to each column
          for (int i = 0; i < cashierJTable.getColumnCount(); i++) {
              cashierJTable.getColumnModel().getColumn(i).setCellRenderer(centerRenderer);
            }
      
        Timer timer = new Timer(1000, e -> {
             String date = new SimpleDateFormat("yyyy-MM-dd").format(new Date());
             String time = new SimpleDateFormat("hh:mm a").format(new Date());
             lblDateTime.setText("<html><div style='text-align: right;'>" + date + "<br>" + time + "</div></html>");
        });
        timer.start();    
        
        numpadPanel.setLayout(new GridLayout(4, 3, 5, 5));

        for (int i = 1; i <= 9; i++) {
        JButton btn = new JButton(String.valueOf(i));
        btn.setFont(new Font("Segoe UI", Font.BOLD, 70));
        btn.addActionListener(e -> {
            quantityField.setText(quantityField.getText() + btn.getText());
            });
            numpadPanel.add(btn);
        }

        JButton zero = new JButton("0");
        zero.setFont(new Font("Segoe UI", Font.BOLD, 70));
        zero.addActionListener(e -> {
            // Always append zero
            quantityField.setText(quantityField.getText() + "0");
        });
        numpadPanel.add(zero);

        JButton clear = new JButton("Clear");
        clear.setFont(new Font("Segoe UI", Font.BOLD, 30));
        clear.addActionListener(e -> quantityField.setText("")); // reset
        numpadPanel.add(clear);

        JButton enter = new JButton("Enter");
        enter.setFont(new Font("Segoe UI", Font.BOLD, 30));
        enter.addActionListener(e -> addItemBarcode.doClick()); // simulate pressing Add Item
        numpadPanel.add(enter);
        
        cashierJTable.getSelectionModel().addListSelectionListener(event -> {
            if (!event.getValueIsAdjusting()) {
                boolean rowSelected = cashierJTable.getSelectedRow() != -1;
                btnVoid.setEnabled(rowSelected);
            }
        });
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
        receiptPanel = new javax.swing.JPanel();
        btnMenu = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTextArea = new javax.swing.JTextPane();
        btnPrint = new javax.swing.JButton();
        btnReset = new javax.swing.JButton();
        paymentPanel = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        barcodeField = new javax.swing.JTextField();
        addItemBarcode = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        quantityField = new javax.swing.JTextField();
        btnPayment = new javax.swing.JButton();
        btnVoid = new javax.swing.JButton();
        numpadPanel = new javax.swing.JPanel();
        transactionPanel = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        cashierJTable = new javax.swing.JTable();
        logo = new javax.swing.JLabel();
        lblDateTime = new javax.swing.JLabel();
        lblUser = new javax.swing.JLabel();

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

        btnMenu.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        btnMenu.setText("Menu");
        btnMenu.addActionListener(this::btnMenuActionPerformed);

        jScrollPane1.setViewportView(jTextArea);

        btnPrint.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        btnPrint.setText("Print Receipt");

        btnReset.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        btnReset.setText("Reset All");
        btnReset.addActionListener(this::btnResetActionPerformed);

        javax.swing.GroupLayout receiptPanelLayout = new javax.swing.GroupLayout(receiptPanel);
        receiptPanel.setLayout(receiptPanelLayout);
        receiptPanelLayout.setHorizontalGroup(
            receiptPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, receiptPanelLayout.createSequentialGroup()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 692, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(receiptPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(receiptPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(btnPrint, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(btnMenu, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(btnReset, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );
        receiptPanelLayout.setVerticalGroup(
            receiptPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(receiptPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btnPrint, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(38, 38, 38)
                .addComponent(btnReset, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(41, 41, 41)
                .addComponent(btnMenu, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
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
        quantityField.addActionListener(this::quantityFieldActionPerformed);

        btnPayment.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        btnPayment.setText("Process Payment");
        btnPayment.addActionListener(this::btnPaymentActionPerformed);

        btnVoid.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        btnVoid.setText("Void Item");
        btnVoid.addActionListener(this::btnVoidActionPerformed);

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
                            .addComponent(btnVoid, javax.swing.GroupLayout.DEFAULT_SIZE, 180, Short.MAX_VALUE))
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
                    .addComponent(btnVoid, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnPayment, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(numpadPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        transactionPanel.setBackground(new java.awt.Color(100, 150, 135));
        transactionPanel.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        transactionPanel.setForeground(new java.awt.Color(100, 150, 135));

        cashierJTable.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        cashierJTable.setFont(new java.awt.Font("Segoe UI", 0, 30)); // NOI18N
        cashierJTable.setModel(cashierTable);
        cashierJTable.setRowHeight(50);
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
        lblUser.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lblUser.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);

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
                            .addComponent(lblDateTime, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 144, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblUser, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 387, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(logo, javax.swing.GroupLayout.PREFERRED_SIZE, 97, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(lblDateTime)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lblUser, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)))
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

    private void btnMenuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnMenuActionPerformed
        if (cashierTable.getRowCount() > 0) {
        int confirm = JOptionPane.showConfirmDialog(this,
            "You have items in the transaction. Are you sure you want to go back to Menu?",
            "Confirm Menu",
            JOptionPane.YES_NO_OPTION);

            if (confirm != JOptionPane.YES_OPTION) {
                return; // cancel going back
            }
        }

        if ("ADMIN".equalsIgnoreCase(currentRole)) {
            SelectionAdmin sa = new SelectionAdmin();
            sa.setVisible(true);
            this.dispose();
        } else {
            int confirm = JOptionPane.showConfirmDialog(this,
                "Are you sure you want to log out?",
                "Logout",
                JOptionPane.YES_NO_OPTION);

            if (confirm == JOptionPane.YES_OPTION) {
                new Login().setVisible(true);
                this.dispose();
            }
        }
    }//GEN-LAST:event_btnMenuActionPerformed

    private void logoComponentResized(java.awt.event.ComponentEvent evt) {//GEN-FIRST:event_logoComponentResized

    }//GEN-LAST:event_logoComponentResized

    private void btnPaymentActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPaymentActionPerformed
        if (cashierTable.getRowCount() == 0) {
            JOptionPane.showMessageDialog(this, "No items in transaction!", "Error", JOptionPane.WARNING_MESSAGE);
            return;
        }
        
        this.setEnabled(false);

        double totalAmount = calculateTotal();
        Payment p = new Payment(totalAmount);

        p.addWindowListener(new java.awt.event.WindowAdapter() {
        @Override
        public void windowClosed(java.awt.event.WindowEvent e) {
            Cashier.this.setEnabled(true);
            Cashier.this.toFront();

            if (p.isConfirmed()) {  
                double cash = p.getCashReceived();
                double balance = cash - totalAmount;
                if (cash >= totalAmount) {
                    java.util.Date now = new java.util.Date();
                    String staff = Users.getCurrentName();
                    boolean success = TransactionSQL.addTransaction(now, totalAmount, balance, staff);

                    if (success) {
                        TransacData.transData.add(new TransacData(TransacData.transData.size() + 1, totalAmount, balance));

                        generateReceipt(totalAmount, cash, balance);
                        printReceiptDirect();
                        btnPrint.setEnabled(true);
                    }
                }
            }
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

    private void generateReceipt(double total, double cash, double balance) {
        jTextArea.setText(""); // clear

        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd hh:mm a");
        jTextArea.setText(
            "PENTAGRAM RECEIPT\n" +
            "---------------------------------------------\n" +
            "Date: " + dateFormat.format(new Date()) + "\n" +
            "Transaction # " + TransacData.transData.size() + "\n" +
            "Staff: " + Users.getCurrentName() + "\n\n"
        );

        for (int i = 0; i < cashierTable.getRowCount(); i++) {
            String itemName = cashierTable.getValueAt(i, 1).toString();
            String qty = cashierTable.getValueAt(i, 2).toString();
            String price = cashierTable.getValueAt(i, 3).toString();
            String subtotal = cashierTable.getValueAt(i, 4).toString();
            jTextArea.setText(jTextArea.getText() +
                qty + "x " + itemName + " ₱" + price + " = " + subtotal + "\n");
        }

        jTextArea.setText(jTextArea.getText() +
            "---------------------------------------------\n" +
            "Total: ₱" + String.format("%.2f", total) + "\n" +
            "Cash: ₱" + String.format("%.2f", cash) + "\n" +
            "Change: ₱" + String.format("%.2f", balance) + "\n\n" +
            "THANK YOU FOR SHOPPING!\n"
        );
    }

    private void printReceiptDirect() {
        try {
            String receiptText = jTextArea.getText();
            byte[] receiptBytes = receiptText.getBytes("UTF-8");
            DocFlavor flavor = DocFlavor.BYTE_ARRAY.AUTOSENSE;
            PrintService[] printServices = PrintServiceLookup.lookupPrintServices(flavor, null);

            if (printServices.length > 0) {
                PrintService selectedService = printServices[0];
                for (PrintService service : printServices) {
                    if (service.getName().toLowerCase().contains("xprinter-58")) {
                        selectedService = service;
                        break;
                    }
                }
                DocPrintJob printJob = selectedService.createPrintJob();
                Doc doc = new SimpleDoc(receiptBytes, flavor, null);
                PrintRequestAttributeSet attributes = new HashPrintRequestAttributeSet();
                attributes.add(new Copies(1));
                attributes.add(new JobName("Pentagram POS Receipt", null));
                printJob.print(doc, attributes);
            } else {
                JOptionPane.showMessageDialog(this, "No printer found! Please check your USB printer connection.", "Error", JOptionPane.ERROR_MESSAGE);
            }
        } catch(Exception ex) {
            ex.printStackTrace();
            JOptionPane.showMessageDialog(this, "Printing error: " + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void btnVoidActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnVoidActionPerformed
       int selectedRow = cashierJTable.getSelectedRow();
        if (selectedRow != -1) {
            DefaultTableModel model = (DefaultTableModel) cashierJTable.getModel();
            model.removeRow(selectedRow);

            double newTotal = calculateTotal();
            System.out.println("New total: " + newTotal);
        }
    }//GEN-LAST:event_btnVoidActionPerformed

    private void barcodeFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_barcodeFieldActionPerformed
       AddItemFromBarcode helper = new AddItemFromBarcode(cashierTable);
       helper.addItem(barcodeField.getText(), Integer.parseInt(quantityField.getText()));

      
       quantityField.setText("1");
       barcodeField.setText("");
       barcodeField.requestFocusInWindow();
    }//GEN-LAST:event_barcodeFieldActionPerformed

    private void btnResetActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnResetActionPerformed
        cashierTable.setRowCount(0);

        jTextArea.setText("");

        barcodeField.setText("");
        quantityField.setText("1");

        btnPrint.setEnabled(false);   
        btnMenu.setEnabled(true);  

        JOptionPane.showMessageDialog(this, "Transaction has been reset.", "Reset Complete", JOptionPane.INFORMATION_MESSAGE);
    }//GEN-LAST:event_btnResetActionPerformed

    private void quantityFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_quantityFieldActionPerformed
      
    }//GEN-LAST:event_quantityFieldActionPerformed
   
    // Variables declaration - do not modify//GEN-BEGIN:variables
    javax.swing.JButton addItemBarcode;
    javax.swing.JTextField barcodeField;
    javax.swing.JButton btnMenu;
    javax.swing.JButton btnPayment;
    javax.swing.JButton btnPrint;
    javax.swing.JButton btnReset;
    javax.swing.JButton btnVoid;
    javax.swing.JTable cashierJTable;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    javax.swing.JTextPane jTextArea;
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
