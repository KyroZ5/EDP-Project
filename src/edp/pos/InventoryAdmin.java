package edp.pos;

import com.sun.jdi.connect.spi.Connection;
import java.awt.Font;
import java.awt.Image;
import java.awt.geom.RoundRectangle2D;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;

public class InventoryAdmin extends javax.swing.JFrame {
    
    String [][] row;
    String [] col = {"Barcode", "Item Name", "Stock Qty", "Price (₱)"};
    DefaultTableModel inventoryModel = new DefaultTableModel(row, col){
        @Override
        public boolean isCellEditable(int row, int col){
            return false;
        }  
    };


    public InventoryAdmin() {
      initComponents();
      setLocationRelativeTo(null);

      setShape(new RoundRectangle2D.Double(0, 0, getWidth(), getHeight(), 25, 25));

      scaleImage();

      DefaultTableModel inventoryModel = (DefaultTableModel) inventoryJModel.getModel();
      new InventoryDisplaySQL(inventoryModel);

      // Get the header of the actual table in your form
      JTableHeader header = inventoryJModel.getTableHeader();

      // Change font (bold + bigger)
      header.setFont(new Font("Segoe UI", Font.BOLD, 25));

      // Optional: center header text
      DefaultTableCellRenderer renderer = (DefaultTableCellRenderer) header.getDefaultRenderer();
      renderer.setHorizontalAlignment(SwingConstants.CENTER);
      
      // Center all rows in the table
      DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
      centerRenderer.setHorizontalAlignment(SwingConstants.CENTER);

      // Apply to each column
      for (int i = 0; i < inventoryJModel.getColumnCount(); i++) {
          inventoryJModel.getColumnModel().getColumn(i).setCellRenderer(centerRenderer);
        }
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
        txtPassword = new javax.swing.JPasswordField();
        btnExit = new javax.swing.JButton();
        txtUsername = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        btnLogin = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        inventoryJModel = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        logo = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        Back = new javax.swing.JButton();
        refreshBtn = new javax.swing.JButton();
        deleteBtn = new javax.swing.JButton();
        editBtn = new javax.swing.JButton();
        addBtn = new javax.swing.JButton();

        jPanel1.setBackground(new java.awt.Color(100, 150, 135));
        jPanel1.setForeground(new java.awt.Color(100, 150, 135));
        jPanel1.setDoubleBuffered(false);
        jPanel1.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N

        txtPassword.addActionListener(this::txtPasswordActionPerformed);

        btnExit.setText("Exit");
        btnExit.setMargin(new java.awt.Insets(10, 35, 10, 35));
        btnExit.addActionListener(this::btnExitActionPerformed);

        txtUsername.setText(" ");
        txtUsername.addActionListener(this::txtUsernameActionPerformed);

        jLabel3.setText("Password");

        jLabel2.setText("Username");

        jLabel4.setText("WELCOME");

        btnLogin.setText("Login");
        btnLogin.setMargin(new java.awt.Insets(10, 35, 10, 35));
        btnLogin.addActionListener(this::btnLoginActionPerformed);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(87, 87, 87)
                .addComponent(btnLogin)
                .addGap(71, 71, 71)
                .addComponent(btnExit)
                .addContainerGap(61, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel3, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel2, javax.swing.GroupLayout.Alignment.TRAILING))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel4)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(txtUsername, javax.swing.GroupLayout.DEFAULT_SIZE, 156, Short.MAX_VALUE)
                        .addComponent(txtPassword)))
                .addGap(69, 69, 69))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(61, 61, 61)
                .addComponent(jLabel4)
                .addGap(43, 43, 43)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(txtUsername, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(43, 43, 43)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(txtPassword, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(75, 75, 75)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnLogin)
                    .addComponent(btnExit))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBounds(new java.awt.Rectangle(0, 0, 0, 0));
        setUndecorated(true);
        setResizable(false);

        jPanel2.setBackground(new java.awt.Color(100, 150, 135));
        jPanel2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanel2.setForeground(new java.awt.Color(100, 150, 135));

        inventoryJModel.setFont(new java.awt.Font("Segoe UI", 0, 20)); // NOI18N
        inventoryJModel.setModel(inventoryModel);
        inventoryJModel.setRowHeight(50);
        jScrollPane1.setViewportView(inventoryJModel);

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Inventory");
        jLabel1.setToolTipText("");

        logo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/logo-light-transparent.png"))); // NOI18N
        logo.setText("LOGO");

        jLabel5.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel5.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel5.setText("Controls");
        jLabel5.setToolTipText("");

        jPanel3.setBackground(new java.awt.Color(100, 150, 135));
        jPanel3.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jPanel3.setForeground(new java.awt.Color(100, 150, 135));

        Back.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        Back.setText("Back");
        Back.addActionListener(this::BackActionPerformed);

        refreshBtn.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        refreshBtn.setText("Refresh List");
        refreshBtn.addActionListener(this::refreshBtnActionPerformed);

        deleteBtn.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        deleteBtn.setText("Delete Item");
        deleteBtn.addActionListener(this::deleteBtnActionPerformed);

        editBtn.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        editBtn.setText("Edit Item");
        editBtn.addActionListener(this::editBtnActionPerformed);

        addBtn.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        addBtn.setText("Add Item");
        addBtn.addActionListener(this::addBtnActionPerformed);

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(addBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(12, 12, 12)
                .addComponent(editBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(deleteBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(refreshBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(106, 106, 106)
                .addComponent(Back, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(addBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(editBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(deleteBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(refreshBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Back, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel5)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(jLabel1)
                                .addGap(58, 58, 58)
                                .addComponent(logo, javax.swing.GroupLayout.PREFERRED_SIZE, 496, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(110, 110, 110)
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(16, 16, 16)
                        .addComponent(logo, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 430, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(72, 72, 72))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, 709, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void BackActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BackActionPerformed
        SelectionAdmin sa = new SelectionAdmin();
        sa.setVisible(true);                     
        this.dispose();
    }//GEN-LAST:event_BackActionPerformed

    private void txtPasswordActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtPasswordActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtPasswordActionPerformed

    private void btnExitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnExitActionPerformed
        int x = JOptionPane.showConfirmDialog(this, "Are you sure you want to exit?", "Exit Form", JOptionPane.YES_NO_OPTION);
        if (x == JOptionPane.YES_OPTION) {
            System.exit(0);
        }
    }//GEN-LAST:event_btnExitActionPerformed

    private void txtUsernameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtUsernameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtUsernameActionPerformed

    private void btnLoginActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLoginActionPerformed
        String userL = txtUsername.getText().trim();
        String passL = new String(txtPassword.getPassword()).trim();

        if (userL.isEmpty() || passL.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Fields cannot be empty", "Error", JOptionPane.WARNING_MESSAGE);
            return;
        }

        defaultAdmin();

        Users matchedUser = null;
        for (Users acc : Users.accts) {
            if (userL.equals(acc.getUsername()) && passL.equals(acc.getPassword())) {
                matchedUser = acc;
                break;
            }
        }

        if (matchedUser != null) {
            JOptionPane.showMessageDialog(this, "Welcome, " + matchedUser.getCurrentName(), "Login Successful", JOptionPane.INFORMATION_MESSAGE);

            Users.setCurrentUser(matchedUser.getUsername(), matchedUser.getCurrentName(), matchedUser.getRole());

            if (matchedUser.getRole().equalsIgnoreCase("ADMIN")) {
                new SelectionAdmin().setVisible(true);
            } else if (matchedUser.getRole().equalsIgnoreCase("CASHIER")) {
                new Cashier(matchedUser.getRole()).setVisible(true);
            }

            this.dispose();
        } else {
            JOptionPane.showMessageDialog(this, "Invalid username or password!", "Invalid Login", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_btnLoginActionPerformed
    private void defaultAdmin() {
        boolean adminFound = false;

        for (Users acc : Users.accts) {
            if (acc.getRole().equalsIgnoreCase("ADMIN")) {
                adminFound = true;
                break;
            }
        }

        if (!adminFound) {
            Users admin = new Users("admin", "admin", "System Administrator", "ADMIN");
            Users.accts.add(admin);
        }
    }

    private void deleteBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_deleteBtnActionPerformed
        int row = inventoryJModel.getSelectedRow();
        if (row == -1) {
            JOptionPane.showMessageDialog(this, "Select an item to delete", "Warning", JOptionPane.WARNING_MESSAGE);
            return;
        }

        int barcode = Integer.parseInt(inventoryJModel.getValueAt(row, 0).toString());
        String itemName = inventoryJModel.getValueAt(row, 1).toString();

        int confirm = JOptionPane.showConfirmDialog(this,
            "Are you sure you want to delete item: " + itemName + "?",
            "Confirm Delete",
            JOptionPane.YES_NO_OPTION);

        if (confirm == JOptionPane.YES_OPTION) {
            boolean success = DeleteItemSQL.deleteItem(barcode);
            if (success) {
                JOptionPane.showMessageDialog(this, "Item deleted successfully!", "Success", JOptionPane.INFORMATION_MESSAGE);
                refreshBtnActionPerformed(null); // refresh after delete
            } else {
                JOptionPane.showMessageDialog(this, "Delete failed!", "Error", JOptionPane.ERROR_MESSAGE);
            }
        }
    }//GEN-LAST:event_deleteBtnActionPerformed

    private void refreshBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_refreshBtnActionPerformed
        DefaultTableModel inventoryModel = (DefaultTableModel) inventoryJModel.getModel();
        new InventoryDisplaySQL(inventoryModel);
    }//GEN-LAST:event_refreshBtnActionPerformed

    private void addBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addBtnActionPerformed
        this.setEnabled(false); 
        
        AddItem a = new AddItem();
        
        a.addWindowListener(new java.awt.event.WindowAdapter() {
            @Override
            public void windowClosed(java.awt.event.WindowEvent e) {
                InventoryAdmin.this.setEnabled(true);
                InventoryAdmin.this.toFront();
            }
        });

        a.setLocationRelativeTo(this);
        a.setVisible(true);
    }//GEN-LAST:event_addBtnActionPerformed

    private void editBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_editBtnActionPerformed
        int row = inventoryJModel.getSelectedRow();
        if (row == -1) {
            JOptionPane.showMessageDialog(this, "Select an item to edit", "Warning", JOptionPane.WARNING_MESSAGE);
            return;
        }

        String barcode = inventoryJModel.getValueAt(row, 0).toString();
        String itemName = inventoryJModel.getValueAt(row, 1).toString();
        int stock = Integer.parseInt(inventoryJModel.getValueAt(row, 2).toString());
        double price = Double.parseDouble(inventoryJModel.getValueAt(row, 3).toString());

        UpdateItem ui = new UpdateItem(barcode, itemName, stock, price);
        ui.addWindowListener(new java.awt.event.WindowAdapter() {
            @Override
            public void windowClosed(java.awt.event.WindowEvent e) {
                refreshBtnActionPerformed(null);
            }
        });
        ui.setLocationRelativeTo(this);
        ui.setVisible(true);
    }//GEN-LAST:event_editBtnActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton Back;
    private javax.swing.JButton addBtn;
    private javax.swing.JButton btnExit;
    private javax.swing.JButton btnLogin;
    private javax.swing.JButton deleteBtn;
    private javax.swing.JButton editBtn;
    javax.swing.JTable inventoryJModel;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    javax.swing.JLabel logo;
    private javax.swing.JButton refreshBtn;
    private javax.swing.JPasswordField txtPassword;
    private javax.swing.JTextField txtUsername;
    // End of variables declaration//GEN-END:variables

    

}