package view;

import javax.swing.JFrame;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class transaction extends javax.swing.JFrame {
    
    public Statement st;
    public ResultSet rs;
    public DefaultTableModel tabModel;
    Connection cn = koneksi.Koneksi.Koneksi();
    
    // Customers table
    
    public void judulCustomers() {
        
        Object[] judul = {
            "Name", "Phone", "Address"
        };
        tabModel = new DefaultTableModel(null, judul);
        tableCustomers.setModel(tabModel);
    }
    
    public void tampilDataCustomers(String where) {
        
        try {
            st = cn.createStatement();
            tabModel.getDataVector().removeAllElements();
            tabModel.fireTableDataChanged();
            rs = st.executeQuery("SELECT * FROM customers " + where);

            while (rs.next()) {
                Object[] data = {
                    rs.getString("Name"),
                    rs.getString("Phone"),
                    rs.getString("Address"),
                };

                tabModel.addRow(data);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    //Vespa table
    
    public void judulVespa() {
        
        Object[] judul = {
            "Type", "Color", "Price"
        };
        tabModel = new DefaultTableModel(null, judul);
        tableVespa.setModel(tabModel);
    }

    public void tampilDataVespa(String where) {
        
        try {
            st = cn.createStatement();
            tabModel.getDataVector().removeAllElements();
            tabModel.fireTableDataChanged();
            rs = st.executeQuery("SELECT * FROM vespa " + where);

            while (rs.next()) {
                Object[] data = {
                    rs.getString("Type"),
                    rs.getString("Color"),
                    rs.getString("Price"),
                };

                tabModel.addRow(data);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    // Cart table
    
    public void judulCart() {
        
        Object[] judul = {
            "Name", "Phone", "Address", "Type", "Color", "Price", "Quantity", "Subtotal", "Total", "Pay", "Outcome", "Date"
        };
        tabModel = new DefaultTableModel(null, judul);
        tableCart.setModel(tabModel);
    }
    
    public void tampilDataCart(String where) {
        
        try {
            st = cn.createStatement();
            tabModel.getDataVector().removeAllElements();
            tabModel.fireTableDataChanged();
            rs = st.executeQuery("SELECT * FROM cart " + where);

            while (rs.next()) {
                Object[] data = {
                    rs.getString("Name"),
                    rs.getString("Phone"),
                    rs.getString("Address"),
                    rs.getString("Type"),
                    rs.getString("Color"),
                    rs.getString("Price"),
                    rs.getString("Quantity"),
                    rs.getString("Subtotal"),
                    rs.getString("Total"),
                    rs.getString("Pay"),
                    rs.getString("Outcome"),
                    rs.getString("Date"),
                    
                };

                tabModel.addRow(data);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    private void subtotal() {
        
        String harga = txtPrice.getText();
        String jumlah = txtQuantity.getText();

        int hargaa = Integer.parseInt(harga);
        try {
            if (jumlah.matches("\\d+")) {
                int jumlahh = Integer.parseInt(jumlah);
                if (jumlahh < 1) {
                    JOptionPane.showMessageDialog(null, "Quantity must be greater than or equal to 1!");
                    txtQuantity.setText("1");
                    jumlahh = 1;
                }
                int total = hargaa * jumlahh;
                String total_harga = Integer.toString(total);
                txtSubtotal.setText(total_harga);
            } else {
                JOptionPane.showMessageDialog(null, "Enter only numbers without symbols!");
                txtQuantity.setText(null);
            }
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(null, "Only numbers!");
            txtQuantity.setText(null);
        }
    }
    
    public void reset() {
        
        txtName.setText("");
        txtPhone.setText("");
        txtAddress.setText("");
        txtType.setText("");
        txtColor.setText("");
        txtPrice.setText("");
        txtQuantity.setText("");
        txtSubtotal.setText("");
        tableCustomers.setEnabled(true);
        tableVespa.setEnabled(true);
        tableCart.setEnabled(true);
        btnUpdate.setEnabled(true);
        btnDelete.setEnabled(true);
    }
    
    public void restart() {
        
        txtType.setText("");
        txtColor.setText("");
        txtPrice.setText("");
        txtQuantity.setText("");
        txtSubtotal.setText("");
        btnDelete.setEnabled(true);
    }
    
    public void date(){
        
        Date currentDate = new Date();
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
        txtDate.setText(dateFormat.format(currentDate));
    }
    
    public transaction() {
        
        initComponents();
        judulCustomers();
        tampilDataCustomers("");
        judulVespa();
        tampilDataVespa("");
        judulCart();
        tampilDataCart("");
        date();
        setLocationRelativeTo(this); 
        btnUpdate.setEnabled(false);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel11 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        txtName = new javax.swing.JTextField();
        txtPhone = new javax.swing.JTextField();
        jScrollPane3 = new javax.swing.JScrollPane();
        tableCart = new javax.swing.JTable();
        jScrollPane4 = new javax.swing.JScrollPane();
        tableCustomers = new javax.swing.JTable();
        txtType = new javax.swing.JTextField();
        txtColor = new javax.swing.JTextField();
        txtPrice = new javax.swing.JTextField();
        btnAddCart = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        txtAddress = new javax.swing.JTextArea();
        btnUpdate = new javax.swing.JButton();
        btnDelete = new javax.swing.JButton();
        btnReset = new javax.swing.JButton();
        jScrollPane5 = new javax.swing.JScrollPane();
        tableVespa = new javax.swing.JTable();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        txtSubtotal = new javax.swing.JTextField();
        txtQuantity = new javax.swing.JTextField();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        filler1 = new javax.swing.Box.Filler(new java.awt.Dimension(0, 60), new java.awt.Dimension(0, 60), new java.awt.Dimension(32767, 60));
        btnUpdate1 = new javax.swing.JButton();
        txtPay = new javax.swing.JTextField();
        txtOutcome = new javax.swing.JTextField();
        txtTotal = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        txtDate = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Transaction");
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(255, 153, 0));
        jPanel1.setForeground(new java.awt.Color(255, 153, 0));

        jLabel11.setFont(new java.awt.Font("Bodoni MT", 1, 36)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(255, 255, 255));
        jLabel11.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/income.png"))); // NOI18N
        jLabel11.setText(" Transaction");

        jButton1.setBackground(new java.awt.Color(255, 153, 0));
        jButton1.setFont(new java.awt.Font("Bodoni MT", 0, 12)); // NOI18N
        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/back.png"))); // NOI18N
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addComponent(jLabel11)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 727, Short.MAX_VALUE)
                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jButton1)
                    .addComponent(jLabel11))
                .addGap(0, 13, Short.MAX_VALUE))
        );

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1060, -1));

        jLabel2.setFont(new java.awt.Font("Bodoni MT", 0, 12)); // NOI18N
        jLabel2.setText("Phone :");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(18, 114, -1, -1));

        jLabel3.setFont(new java.awt.Font("Bodoni MT", 0, 12)); // NOI18N
        jLabel3.setText("Name :");
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(21, 153, -1, -1));

        jLabel4.setFont(new java.awt.Font("Bodoni MT", 0, 12)); // NOI18N
        jLabel4.setText("Address :");
        getContentPane().add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 197, -1, -1));

        jLabel5.setFont(new java.awt.Font("Bodoni MT", 0, 12)); // NOI18N
        jLabel5.setText("Type :");
        getContentPane().add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(23, 315, -1, -1));

        jLabel6.setFont(new java.awt.Font("Bodoni MT", 0, 12)); // NOI18N
        jLabel6.setText("Color :");
        getContentPane().add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(23, 353, -1, -1));

        jLabel7.setFont(new java.awt.Font("Bodoni MT", 0, 12)); // NOI18N
        jLabel7.setText("Price :");
        getContentPane().add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(24, 390, -1, -1));

        jLabel8.setFont(new java.awt.Font("Bodoni MT", 0, 12)); // NOI18N
        jLabel8.setText("Quantity :");
        getContentPane().add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(246, 317, -1, -1));

        txtName.setFont(new java.awt.Font("Bodoni MT", 0, 12)); // NOI18N
        getContentPane().add(txtName, new org.netbeans.lib.awtextra.AbsoluteConstraints(75, 150, 154, -1));

        txtPhone.setFont(new java.awt.Font("Bodoni MT", 0, 12)); // NOI18N
        getContentPane().add(txtPhone, new org.netbeans.lib.awtextra.AbsoluteConstraints(75, 111, 154, -1));

        tableCart.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        tableCart.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tableCartMouseClicked(evt);
            }
        });
        jScrollPane3.setViewportView(tableCart);

        getContentPane().add(jScrollPane3, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 340, 572, 153));

        tableCustomers.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        tableCustomers.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tableCustomersMouseClicked(evt);
            }
        });
        jScrollPane4.setViewportView(tableCustomers);

        getContentPane().add(jScrollPane4, new org.netbeans.lib.awtextra.AbsoluteConstraints(762, 139, 277, 168));
        getContentPane().add(txtType, new org.netbeans.lib.awtextra.AbsoluteConstraints(74, 314, 154, -1));
        getContentPane().add(txtColor, new org.netbeans.lib.awtextra.AbsoluteConstraints(74, 350, 154, -1));
        getContentPane().add(txtPrice, new org.netbeans.lib.awtextra.AbsoluteConstraints(74, 387, 154, -1));

        btnAddCart.setBackground(new java.awt.Color(255, 153, 0));
        btnAddCart.setFont(new java.awt.Font("Bodoni MT", 0, 12)); // NOI18N
        btnAddCart.setForeground(new java.awt.Color(255, 255, 255));
        btnAddCart.setText("Add to cart");
        btnAddCart.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddCartActionPerformed(evt);
            }
        });
        getContentPane().add(btnAddCart, new org.netbeans.lib.awtextra.AbsoluteConstraints(247, 386, 162, -1));

        txtAddress.setColumns(20);
        txtAddress.setFont(new java.awt.Font("Bodoni MT", 0, 12)); // NOI18N
        txtAddress.setRows(5);
        jScrollPane2.setViewportView(txtAddress);

        getContentPane().add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(75, 189, -1, -1));

        btnUpdate.setFont(new java.awt.Font("Bodoni MT", 0, 12)); // NOI18N
        btnUpdate.setText("Update");
        btnUpdate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnUpdateActionPerformed(evt);
            }
        });
        getContentPane().add(btnUpdate, new org.netbeans.lib.awtextra.AbsoluteConstraints(247, 415, 162, -1));

        btnDelete.setBackground(new java.awt.Color(255, 0, 0));
        btnDelete.setFont(new java.awt.Font("Bodoni MT", 0, 12)); // NOI18N
        btnDelete.setForeground(new java.awt.Color(255, 255, 255));
        btnDelete.setText("Delete");
        btnDelete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDeleteActionPerformed(evt);
            }
        });
        getContentPane().add(btnDelete, new org.netbeans.lib.awtextra.AbsoluteConstraints(164, 429, -1, -1));

        btnReset.setFont(new java.awt.Font("Bodoni MT", 0, 12)); // NOI18N
        btnReset.setText("Reset");
        btnReset.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnResetActionPerformed(evt);
            }
        });
        getContentPane().add(btnReset, new org.netbeans.lib.awtextra.AbsoluteConstraints(74, 429, 72, -1));

        tableVespa.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        tableVespa.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tableVespaMouseClicked(evt);
            }
        });
        jScrollPane5.setViewportView(tableVespa);

        getContentPane().add(jScrollPane5, new org.netbeans.lib.awtextra.AbsoluteConstraints(467, 139, 277, 168));

        jLabel9.setFont(new java.awt.Font("Bodoni MT", 0, 14)); // NOI18N
        jLabel9.setText("Cart");
        getContentPane().add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(739, 318, -1, -1));

        jLabel10.setFont(new java.awt.Font("Bodoni MT", 0, 12)); // NOI18N
        jLabel10.setText("Subtotal :");
        getContentPane().add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(249, 353, -1, -1));
        getContentPane().add(txtSubtotal, new org.netbeans.lib.awtextra.AbsoluteConstraints(319, 350, 88, -1));

        txtQuantity.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtQuantityKeyReleased(evt);
            }
        });
        getContentPane().add(txtQuantity, new org.netbeans.lib.awtextra.AbsoluteConstraints(319, 314, 88, -1));

        jLabel12.setFont(new java.awt.Font("Bodoni MT", 0, 14)); // NOI18N
        jLabel12.setText("Vespa");
        getContentPane().add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(586, 111, -1, -1));

        jLabel13.setFont(new java.awt.Font("Bodoni MT", 0, 14)); // NOI18N
        jLabel13.setText("Customers");
        getContentPane().add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(867, 111, -1, -1));
        getContentPane().add(filler1, new org.netbeans.lib.awtextra.AbsoluteConstraints(429, 189, -1, -1));

        btnUpdate1.setBackground(new java.awt.Color(0, 0, 255));
        btnUpdate1.setFont(new java.awt.Font("Bodoni MT", 0, 12)); // NOI18N
        btnUpdate1.setForeground(new java.awt.Color(255, 255, 255));
        btnUpdate1.setText("Done");
        btnUpdate1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnUpdate1ActionPerformed(evt);
            }
        });
        getContentPane().add(btnUpdate1, new org.netbeans.lib.awtextra.AbsoluteConstraints(247, 449, 162, -1));

        txtPay.setText("1");
        getContentPane().add(txtPay, new org.netbeans.lib.awtextra.AbsoluteConstraints(550, 460, 10, -1));

        txtOutcome.setText("1");
        getContentPane().add(txtOutcome, new org.netbeans.lib.awtextra.AbsoluteConstraints(630, 460, 10, -1));

        txtTotal.setText("1");
        getContentPane().add(txtTotal, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 460, 10, -1));

        jLabel1.setText("            ");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 520, 1010, -1));

        txtDate.setEditable(false);
        txtDate.setFont(new java.awt.Font("Bodoni MT", 0, 12)); // NOI18N
        getContentPane().add(txtDate, new org.netbeans.lib.awtextra.AbsoluteConstraints(940, 500, 100, 20));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnUpdateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUpdateActionPerformed
        
        try {
            st = cn.createStatement();
            String name = txtName.getText(); 
            String phone = txtPhone.getText(); 
            String address = txtAddress.getText();
            String type = txtType.getText(); 
            String color = txtColor.getText(); 
            String price = txtPrice.getText(); 
            String quantity = txtQuantity.getText();
            String subtotal = txtSubtotal.getText(); 

            String updateQuery = "UPDATE cart SET "
                + "quantity='" + quantity + "', "
                + "subtotal='" + subtotal + "'WHERE color='" + color + "'";

            st.executeUpdate(updateQuery);
            btnAddCart.setEnabled(true);
            btnUpdate.setEnabled(false);
            tampilDataCart(""); 
            JOptionPane.showMessageDialog(null, "Updated succesfully");
            restart();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }//GEN-LAST:event_btnUpdateActionPerformed

    private void btnDeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDeleteActionPerformed

        try {
            int jawab;
            if ((jawab = JOptionPane.showConfirmDialog(null, "Are you sure want to delete?", "Information", JOptionPane.YES_NO_OPTION)) == 0) {
                st = cn.createStatement();
                st.executeUpdate("DELETE FROM cart WHERE color='" + tabModel.getValueAt(tableCart.getSelectedRow(), 4) + "'");
                tampilDataCart("");
                restart();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        btnAddCart.setEnabled(true);
    }//GEN-LAST:event_btnDeleteActionPerformed

    private void btnResetActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnResetActionPerformed
        
        try {
            int jawab;
            if ((jawab = JOptionPane.showConfirmDialog(null, "Are you sure want to delete all data?", "Information", JOptionPane.YES_NO_OPTION)) == 0) {
                st = cn.createStatement();
                st.executeUpdate("DELETE FROM cart"); 
                tampilDataCart(""); 
                reset(); 
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }//GEN-LAST:event_btnResetActionPerformed

    private void tableCustomersMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tableCustomersMouseClicked
        
        txtName.setText(tableCustomers.getValueAt(tableCustomers.getSelectedRow(), 0).toString());
        txtPhone.setText(tableCustomers.getValueAt(tableCustomers.getSelectedRow(), 1).toString());
        txtAddress.setText(tableCustomers.getValueAt(tableCustomers.getSelectedRow(), 2).toString());
        
    }//GEN-LAST:event_tableCustomersMouseClicked

    private void tableVespaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tableVespaMouseClicked
        
        txtType.setText(tableVespa.getValueAt(tableVespa.getSelectedRow(), 0).toString());
        txtColor.setText(tableVespa.getValueAt(tableVespa.getSelectedRow(), 1).toString());
        txtPrice.setText(tableVespa.getValueAt(tableVespa.getSelectedRow(), 2).toString());
    }//GEN-LAST:event_tableVespaMouseClicked

    private void btnAddCartActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddCartActionPerformed
        
        try {
            st = cn.createStatement();
            st.executeUpdate("INSERT INTO cart (name, phone, address, type, color, price, quantity, subtotal, total, pay, outcome, date) VALUES('" + txtName.getText() + "','" + txtPhone.getText() + "','" + txtAddress.getText() + "','" + txtType.getText() + "','" + txtColor.getText() + "','" + txtPrice.getText() + "','" + txtQuantity.getText() + "','" + txtSubtotal.getText() + "','" + txtTotal.getText() + "','" + txtPay.getText() + "','" + txtOutcome.getText() + "','" + txtDate.getText() + "')");
            tampilDataCart("");
            JOptionPane.showMessageDialog(null, "Saved successfully");
            restart();
        } catch (Exception e) {
            e.printStackTrace();
        }      
        tableCustomers.setEnabled(false);
    }//GEN-LAST:event_btnAddCartActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        
        try {
            int jawab;
            {
                st = cn.createStatement();
                st.executeUpdate("DELETE FROM cart"); 
                tampilDataCart(""); 
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        JFrame dashboard = new dashboard();
        this.setVisible(false);
        dashboard.setVisible(true);
    }//GEN-LAST:event_jButton1ActionPerformed

    private void btnUpdate1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUpdate1ActionPerformed
        JFrame carts = new carts();
        this.setVisible(false);
        carts.setVisible(true);
    }//GEN-LAST:event_btnUpdate1ActionPerformed

    private void tableCartMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tableCartMouseClicked
        
        txtName.setText(tableCart.getValueAt(tableCart.getSelectedRow(), 0).toString());
        txtPhone.setText(tableCart.getValueAt(tableCart.getSelectedRow(), 1).toString());
        txtAddress.setText(tableCart.getValueAt(tableCart.getSelectedRow(), 2).toString());
        txtType.setText(tableCart.getValueAt(tableCart.getSelectedRow(), 3).toString());
        txtColor.setText(tableCart.getValueAt(tableCart.getSelectedRow(), 4).toString());
        txtPrice.setText(tableCart.getValueAt(tableCart.getSelectedRow(), 5).toString());
        txtQuantity.setText(tableCart.getValueAt(tableCart.getSelectedRow(), 6).toString());
        txtSubtotal.setText(tableCart.getValueAt(tableCart.getSelectedRow(), 7).toString());
        btnAddCart.setEnabled(false);
        btnUpdate.setEnabled(true);

    }//GEN-LAST:event_tableCartMouseClicked

    private void txtQuantityKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtQuantityKeyReleased
        
        subtotal();
    }//GEN-LAST:event_txtQuantityKeyReleased

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
            java.util.logging.Logger.getLogger(transaction.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(transaction.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(transaction.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(transaction.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new transaction().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAddCart;
    private javax.swing.JButton btnDelete;
    private javax.swing.JButton btnReset;
    private javax.swing.JButton btnUpdate;
    private javax.swing.JButton btnUpdate1;
    private javax.swing.Box.Filler filler1;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JTable tableCart;
    private javax.swing.JTable tableCustomers;
    private javax.swing.JTable tableVespa;
    private javax.swing.JTextArea txtAddress;
    private javax.swing.JTextField txtColor;
    private javax.swing.JTextField txtDate;
    private javax.swing.JTextField txtName;
    private javax.swing.JTextField txtOutcome;
    private javax.swing.JTextField txtPay;
    private javax.swing.JTextField txtPhone;
    private javax.swing.JTextField txtPrice;
    private javax.swing.JTextField txtQuantity;
    private javax.swing.JTextField txtSubtotal;
    private javax.swing.JTextField txtTotal;
    private javax.swing.JTextField txtType;
    // End of variables declaration//GEN-END:variables
}