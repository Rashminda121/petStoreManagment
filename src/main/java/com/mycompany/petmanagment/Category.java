/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package com.mycompany.petmanagment;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Rashminda
 */
public class Category extends javax.swing.JFrame {

    /**
     * Creates new form Category
     */
    public Category() {
        initComponents();
         displayCus();
    }

   
    Connection conn=null;
    PreparedStatement ps=null;
    ResultSet rs=null;
    Statement st=null;
    
    private void displayCus(){
        
        try {
            conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/petshopdb","root","1234");
            st=conn.createStatement();
            
            String sql="Select * from category ";
            rs = st.executeQuery(sql);
            
            while(rs.next()){
                
                String catid=String.valueOf(rs.getString("catid"));
                String catname=String.valueOf(rs.getString("catdes"));
                String catcode=String.valueOf(rs.getString("catcode"));
                
                String tbData[]={catid,catname,catcode};
                DefaultTableModel tblModel=(DefaultTableModel)catTable.getModel();
                
                tblModel.addRow(tbData);
            
            }
            conn.close();
           
            
        } catch (SQLException ex) {
            
            Logger.getLogger(Customers.class.getName()).log(Level.SEVERE, null, ex);
        }
       
    }
    private void SelectionClear() {
        DefaultTableModel model = (DefaultTableModel) catTable.getModel();
        model.setRowCount(0); // Clear all rows from the table model
    }
    private void clearText(){
         catname.setText("");
         catcode.setText("");
     }
    
    int itemid;
    
    Statement st2=null;
    ResultSet rs2=null;
    
    private void countid(){
        try {
            st2=conn.createStatement();
            
            String sql="select max(catid) from category ";
            rs2=st2.executeQuery(sql);
            
            rs2.next();
            
            itemid=rs2.getInt(1)+1;
            
            
        } catch (Exception e) {
           e.printStackTrace();
        }
    }
    
    
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        catname = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        catcode = new javax.swing.JTextField();
        jLabel12 = new javax.swing.JLabel();
        savebtn = new javax.swing.JButton();
        editbtn = new javax.swing.JButton();
        delbtn = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        catTable = new javax.swing.JTable();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(0, 51, 102));

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));

        jLabel1.setBackground(new java.awt.Color(255, 255, 255));
        jLabel1.setFont(new java.awt.Font("Century Gothic", 1, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(0, 51, 102));
        jLabel1.setText("Manage Categories");

        jLabel8.setBackground(new java.awt.Color(255, 255, 255));
        jLabel8.setFont(new java.awt.Font("Century Gothic", 1, 16)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(0, 51, 102));
        jLabel8.setText("Name");

        catname.setBackground(new java.awt.Color(255, 255, 255));
        catname.setFont(new java.awt.Font("Century Gothic", 1, 16)); // NOI18N
        catname.setForeground(new java.awt.Color(0, 51, 102));

        jLabel10.setBackground(new java.awt.Color(255, 255, 255));
        jLabel10.setFont(new java.awt.Font("Century Gothic", 1, 18)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(0, 51, 102));
        jLabel10.setText(" Categories List");

        catcode.setBackground(new java.awt.Color(255, 255, 255));
        catcode.setFont(new java.awt.Font("Century Gothic", 1, 16)); // NOI18N
        catcode.setForeground(new java.awt.Color(0, 51, 102));

        jLabel12.setBackground(new java.awt.Color(255, 255, 255));
        jLabel12.setFont(new java.awt.Font("Century Gothic", 1, 16)); // NOI18N
        jLabel12.setForeground(new java.awt.Color(0, 51, 102));
        jLabel12.setText("Code");

        savebtn.setBackground(new java.awt.Color(0, 51, 102));
        savebtn.setFont(new java.awt.Font("Century Gothic", 0, 15)); // NOI18N
        savebtn.setForeground(new java.awt.Color(255, 255, 255));
        savebtn.setText("Save");
        savebtn.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                savebtnMouseClicked(evt);
            }
        });

        editbtn.setBackground(new java.awt.Color(0, 51, 102));
        editbtn.setFont(new java.awt.Font("Century Gothic", 0, 15)); // NOI18N
        editbtn.setForeground(new java.awt.Color(255, 255, 255));
        editbtn.setText("Edit");
        editbtn.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                editbtnMouseClicked(evt);
            }
        });

        delbtn.setBackground(new java.awt.Color(0, 51, 102));
        delbtn.setFont(new java.awt.Font("Century Gothic", 0, 15)); // NOI18N
        delbtn.setForeground(new java.awt.Color(255, 255, 255));
        delbtn.setText("Delete");
        delbtn.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                delbtnMouseClicked(evt);
            }
        });
        delbtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                delbtnActionPerformed(evt);
            }
        });

        catTable.setBackground(new java.awt.Color(255, 255, 255));
        catTable.setFont(new java.awt.Font("Century Gothic", 0, 14)); // NOI18N
        catTable.setForeground(new java.awt.Color(0, 51, 102));
        catTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "Name", "Code"
            }
        ));
        catTable.setRowHeight(30);
        catTable.setRowMargin(2);
        catTable.setSelectionBackground(new java.awt.Color(0, 51, 102));
        catTable.setSelectionForeground(new java.awt.Color(255, 255, 255));
        catTable.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                catTableMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(catTable);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(savebtn)
                        .addGap(18, 18, 18)
                        .addComponent(editbtn)
                        .addGap(18, 18, 18)
                        .addComponent(delbtn)
                        .addGap(143, 143, 143))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel2Layout.createSequentialGroup()
                                        .addComponent(jLabel1)
                                        .addGap(90, 90, 90))
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabel8)
                                            .addComponent(catname, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGap(43, 43, 43)))
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(catcode, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel12)))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGap(174, 174, 174)
                                .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 168, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 498, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addContainerGap(18, Short.MAX_VALUE))))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8)
                    .addComponent(jLabel12))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(catname, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(catcode, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(savebtn)
                    .addComponent(editbtn)
                    .addComponent(delbtn))
                .addGap(18, 18, 18)
                .addComponent(jLabel10)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 214, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(26, Short.MAX_VALUE))
        );

        jLabel2.setBackground(new java.awt.Color(0, 51, 102));
        jLabel2.setFont(new java.awt.Font("Century Gothic", 1, 18)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setIcon(new javax.swing.ImageIcon("C:\\Users\\Rashminda\\Documents\\NetBeansProjects\\petmanagment\\src\\main\\java\\com\\mycompany\\petmanagment\\cat.png")); // NOI18N
        jLabel2.setText(" Pets");

        jLabel3.setBackground(new java.awt.Color(0, 51, 102));
        jLabel3.setFont(new java.awt.Font("Century Gothic", 1, 18)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setIcon(new javax.swing.ImageIcon("C:\\Users\\Rashminda\\Documents\\NetBeansProjects\\petmanagment\\src\\main\\java\\com\\mycompany\\petmanagment\\cat.png")); // NOI18N
        jLabel3.setText(" Users");

        jLabel4.setBackground(new java.awt.Color(0, 51, 102));
        jLabel4.setFont(new java.awt.Font("Century Gothic", 1, 18)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setIcon(new javax.swing.ImageIcon("C:\\Users\\Rashminda\\Documents\\NetBeansProjects\\petmanagment\\src\\main\\java\\com\\mycompany\\petmanagment\\cat.png")); // NOI18N
        jLabel4.setText(" Logout");

        jLabel5.setBackground(new java.awt.Color(0, 51, 102));
        jLabel5.setFont(new java.awt.Font("Century Gothic", 1, 18)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setIcon(new javax.swing.ImageIcon("C:\\Users\\Rashminda\\Documents\\NetBeansProjects\\petmanagment\\src\\main\\java\\com\\mycompany\\petmanagment\\cat.png")); // NOI18N
        jLabel5.setText(" Customers");

        jLabel6.setBackground(new java.awt.Color(0, 51, 102));
        jLabel6.setFont(new java.awt.Font("Century Gothic", 1, 18)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setIcon(new javax.swing.ImageIcon("C:\\Users\\Rashminda\\Documents\\NetBeansProjects\\petmanagment\\src\\main\\java\\com\\mycompany\\petmanagment\\cat.png")); // NOI18N
        jLabel6.setText(" Billing");

        jLabel7.setBackground(new java.awt.Color(0, 51, 102));
        jLabel7.setFont(new java.awt.Font("Century Gothic", 1, 18)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(255, 255, 255));
        jLabel7.setIcon(new javax.swing.ImageIcon("C:\\Users\\Rashminda\\Documents\\NetBeansProjects\\petmanagment\\src\\main\\java\\com\\mycompany\\petmanagment\\animals.png")); // NOI18N

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(72, 72, 72)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel4)
                            .addComponent(jLabel3)
                            .addComponent(jLabel2)
                            .addComponent(jLabel6)
                            .addComponent(jLabel5)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(27, 27, 27)
                        .addComponent(jLabel7)))
                .addGap(18, 18, 18)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(18, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel7)
                        .addGap(47, 47, 47)
                        .addComponent(jLabel2)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel3)
                        .addGap(28, 28, 28)
                        .addComponent(jLabel5)
                        .addGap(31, 31, 31)
                        .addComponent(jLabel6)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel4)
                        .addGap(64, 64, 64))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void delbtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_delbtnActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_delbtnActionPerformed
    
    int key=0;
    private void catTableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_catTableMouseClicked
        
         DefaultTableModel model =(DefaultTableModel) catTable.getModel();
        int index=catTable.getSelectedRow();
        key=Integer.valueOf(model.getValueAt(index,  0).toString());
        catname.setText(model.getValueAt(index,1).toString());
        catcode.setText(model.getValueAt(index,2).toString());
        
    }//GEN-LAST:event_catTableMouseClicked

    private void savebtnMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_savebtnMouseClicked
          if(catname.getText().isEmpty()|| catcode.getText().isEmpty()){
            JOptionPane.showMessageDialog(this,"Missing information.");
        }else{
            
            try {
                countid();
                conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/petshopdb","root","1234");
                
                String sql="insert into category values(?,?,?) ";
                PreparedStatement save=conn.prepareStatement(sql);
                
                save.setInt(1, itemid);
                save.setString(2, catname.getText());
                save.setString(3, catcode.getText());
                
                
                int row=save.executeUpdate();
                
                JOptionPane.showMessageDialog(this, "Category Added Successfully.");
                
                SelectionClear();
                displayCus();
                clearText();
                
                conn.close();
                
            } catch (SQLException ex) {
                ex.printStackTrace();
                
                JOptionPane.showMessageDialog(this, "Something Went Wrong.");
                
            }
        }
    }//GEN-LAST:event_savebtnMouseClicked

    private void editbtnMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_editbtnMouseClicked
        
        
         if(catname.getText().isEmpty()|| catcode.getText().isEmpty()){
            
            JOptionPane.showMessageDialog(this,"Missing information.");
            
        }else{
            
            try {
                
                conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/petshopdb","root","1234");
                
                String sql="update category set catdes=?,catcode=?  where catid=?";
                PreparedStatement update=conn.prepareStatement(sql);
                
                update.setInt(3, key);
                update.setString(1, catname.getText());
                update.setString(2, catcode.getText());
               
                
                int row=update.executeUpdate();
                
                JOptionPane.showMessageDialog(this, "Category Updated Successfully.");
                
                SelectionClear();
                displayCus();
                clearText();
                
                conn.close();
                
            } catch (SQLException ex) {
                ex.printStackTrace();
                
                JOptionPane.showMessageDialog(this, "Something Went Wrong.");
                
            }
        }
    }//GEN-LAST:event_editbtnMouseClicked

    private void delbtnMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_delbtnMouseClicked
           
        
        if(catname.getText().isEmpty()|| catcode.getText().isEmpty()){
            
            JOptionPane.showMessageDialog(this,"Missing information.");
            
        }else{
            
            try {
                
                conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/petshopdb","root","1234");
                
                String sql="delete from category where catid=?";
                PreparedStatement update=conn.prepareStatement(sql);
                
                update.setInt(1, key);
                
                
                int row=update.executeUpdate();
                
                JOptionPane.showMessageDialog(this, "Category Removed Successfully.");
                
                SelectionClear();
                displayCus();
                clearText();
                
                conn.close();
                
            } catch (SQLException ex) {
                ex.printStackTrace();
                
                JOptionPane.showMessageDialog(this, "Something Went Wrong.");
                
            }
        }
    }//GEN-LAST:event_delbtnMouseClicked

    
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
            java.util.logging.Logger.getLogger(Category.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Category.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Category.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Category.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Category().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTable catTable;
    private javax.swing.JTextField catcode;
    private javax.swing.JTextField catname;
    private javax.swing.JButton delbtn;
    private javax.swing.JButton editbtn;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JButton savebtn;
    // End of variables declaration//GEN-END:variables
}
