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
public class Customers extends javax.swing.JFrame {

    /**
     * Creates new form Customers
     */
    public Customers() {
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
            
            String sql="Select * from customer ";
            rs = st.executeQuery(sql);
            
            while(rs.next()){
                
                String cusid=String.valueOf(rs.getString("cusid"));
                String cusname=String.valueOf(rs.getString("cusname"));
                String cusadd=String.valueOf(rs.getString("cusadd"));
                String cusphone=String.valueOf(rs.getString("cusphone"));
               

                String tbData[]={cusid,cusname,cusadd,cusphone};
                DefaultTableModel tblModel=(DefaultTableModel)customertbl.getModel();
                
                tblModel.addRow(tbData);
            
            }
            conn.close();
           
            
        } catch (SQLException ex) {
            
            Logger.getLogger(Customers.class.getName()).log(Level.SEVERE, null, ex);
        }
       
    }
     private void SelectionClear() {
        DefaultTableModel model = (DefaultTableModel) customertbl.getModel();
        model.setRowCount(0); // Clear all rows from the table model
    }
     
     private void clearText(){
         cusname.setText("");
         cusadd.setText("");
         cusphone.setText("");
     }
    
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        cusname = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        cusadd = new javax.swing.JTextField();
        cusphone = new javax.swing.JTextField();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        savebtn = new javax.swing.JButton();
        editbtn = new javax.swing.JButton();
        delbtn = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        customertbl = new javax.swing.JTable();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        Category = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(0, 51, 102));

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));

        jLabel1.setBackground(new java.awt.Color(255, 255, 255));
        jLabel1.setFont(new java.awt.Font("Century Gothic", 1, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(0, 51, 102));
        jLabel1.setText("Manage Customers");

        jLabel8.setBackground(new java.awt.Color(255, 255, 255));
        jLabel8.setFont(new java.awt.Font("Century Gothic", 1, 16)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(0, 51, 102));
        jLabel8.setText("Name");

        cusname.setBackground(new java.awt.Color(255, 255, 255));
        cusname.setFont(new java.awt.Font("Century Gothic", 1, 16)); // NOI18N
        cusname.setForeground(new java.awt.Color(0, 51, 102));

        jLabel10.setBackground(new java.awt.Color(255, 255, 255));
        jLabel10.setFont(new java.awt.Font("Century Gothic", 1, 18)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(0, 51, 102));
        jLabel10.setText("Customers");

        cusadd.setBackground(new java.awt.Color(255, 255, 255));
        cusadd.setFont(new java.awt.Font("Century Gothic", 1, 16)); // NOI18N
        cusadd.setForeground(new java.awt.Color(0, 51, 102));

        cusphone.setBackground(new java.awt.Color(255, 255, 255));
        cusphone.setFont(new java.awt.Font("Century Gothic", 1, 16)); // NOI18N
        cusphone.setForeground(new java.awt.Color(0, 51, 102));

        jLabel11.setBackground(new java.awt.Color(255, 255, 255));
        jLabel11.setFont(new java.awt.Font("Century Gothic", 1, 16)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(0, 51, 102));
        jLabel11.setText("Phone");

        jLabel12.setBackground(new java.awt.Color(255, 255, 255));
        jLabel12.setFont(new java.awt.Font("Century Gothic", 1, 16)); // NOI18N
        jLabel12.setForeground(new java.awt.Color(0, 51, 102));
        jLabel12.setText("Address");

        savebtn.setBackground(new java.awt.Color(0, 51, 102));
        savebtn.setFont(new java.awt.Font("Century Gothic", 0, 15)); // NOI18N
        savebtn.setForeground(new java.awt.Color(255, 255, 255));
        savebtn.setText("Save");
        savebtn.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                savebtnMouseClicked(evt);
            }
        });
        savebtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                savebtnActionPerformed(evt);
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
        editbtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                editbtnActionPerformed(evt);
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

        customertbl.setBackground(new java.awt.Color(255, 255, 255));
        customertbl.setFont(new java.awt.Font("Century Gothic", 0, 14)); // NOI18N
        customertbl.setForeground(new java.awt.Color(0, 51, 102));
        customertbl.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Customer ID", "Name", "Address", "Phone"
            }
        ));
        customertbl.setRowHeight(30);
        customertbl.setSelectionBackground(new java.awt.Color(0, 51, 102));
        customertbl.setSelectionForeground(new java.awt.Color(255, 255, 255));
        customertbl.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                customertblMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(customertbl);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 711, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 23, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(savebtn)
                        .addGap(18, 18, 18)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 109, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(editbtn)
                                .addGap(18, 18, 18)
                                .addComponent(delbtn)))
                        .addGap(258, 258, 258))))
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(138, 138, 138)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel8)
                    .addComponent(cusname, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(cusadd, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(cusphone, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel12)
                        .addGap(105, 105, 105)
                        .addComponent(jLabel11)))
                .addGap(0, 0, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel11, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel8))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(cusname, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel12)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(cusadd, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(cusphone, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
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
        jLabel2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel2MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jLabel2MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jLabel2MouseExited(evt);
            }
        });

        jLabel3.setBackground(new java.awt.Color(0, 51, 102));
        jLabel3.setFont(new java.awt.Font("Century Gothic", 1, 18)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setIcon(new javax.swing.ImageIcon("C:\\Users\\Rashminda\\Documents\\NetBeansProjects\\petmanagment\\src\\main\\java\\com\\mycompany\\petmanagment\\user.png")); // NOI18N
        jLabel3.setText(" Users");
        jLabel3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jLabel3MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jLabel3MouseExited(evt);
            }
        });

        jLabel4.setBackground(new java.awt.Color(0, 51, 102));
        jLabel4.setFont(new java.awt.Font("Century Gothic", 1, 18)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setIcon(new javax.swing.ImageIcon("C:\\Users\\Rashminda\\Documents\\NetBeansProjects\\petmanagment\\src\\main\\java\\com\\mycompany\\petmanagment\\logout .png")); // NOI18N
        jLabel4.setText(" Logout");
        jLabel4.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel4MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jLabel4MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jLabel4MouseExited(evt);
            }
        });

        jLabel5.setBackground(new java.awt.Color(0, 51, 102));
        jLabel5.setFont(new java.awt.Font("Century Gothic", 1, 18)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setIcon(new javax.swing.ImageIcon("C:\\Users\\Rashminda\\Documents\\NetBeansProjects\\petmanagment\\src\\main\\java\\com\\mycompany\\petmanagment\\customer.png")); // NOI18N
        jLabel5.setText(" Customers");
        jLabel5.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel5MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jLabel5MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jLabel5MouseExited(evt);
            }
        });

        jLabel6.setBackground(new java.awt.Color(0, 51, 102));
        jLabel6.setFont(new java.awt.Font("Century Gothic", 1, 18)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setIcon(new javax.swing.ImageIcon("C:\\Users\\Rashminda\\Documents\\NetBeansProjects\\petmanagment\\src\\main\\java\\com\\mycompany\\petmanagment\\invoice.png")); // NOI18N
        jLabel6.setText(" Billing");
        jLabel6.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel6MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jLabel6MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jLabel6MouseExited(evt);
            }
        });

        jLabel7.setBackground(new java.awt.Color(0, 51, 102));
        jLabel7.setFont(new java.awt.Font("Century Gothic", 1, 18)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(255, 255, 255));
        jLabel7.setIcon(new javax.swing.ImageIcon("C:\\Users\\Rashminda\\Documents\\NetBeansProjects\\petmanagment\\src\\main\\java\\com\\mycompany\\petmanagment\\animals.png")); // NOI18N

        Category.setBackground(new java.awt.Color(0, 51, 102));
        Category.setFont(new java.awt.Font("Century Gothic", 1, 18)); // NOI18N
        Category.setForeground(new java.awt.Color(255, 255, 255));
        Category.setIcon(new javax.swing.ImageIcon("C:\\Users\\Rashminda\\Documents\\NetBeansProjects\\petmanagment\\src\\main\\java\\com\\mycompany\\petmanagment\\category.png")); // NOI18N
        Category.setText(" Category");
        Category.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                CategoryMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                CategoryMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                CategoryMouseExited(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(27, 27, 27)
                        .addComponent(jLabel7)
                        .addGap(158, 158, 158))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel5, javax.swing.GroupLayout.DEFAULT_SIZE, 141, Short.MAX_VALUE)
                            .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(Category, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(18, 18, 18)))
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(18, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel7)
                        .addGap(39, 39, 39)
                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(19, 19, 19)
                        .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(Category, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(38, 38, 38)
                        .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
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

    int itemid;
    
    Statement st2=null;
    ResultSet rs2=null;
    
    private void countid(){
        try {
            st2=conn.createStatement();
            
            String sql="select max(cusid) from customers ";
            rs2=st2.executeQuery(sql);
            
            rs2.next();
            
            itemid=rs2.getInt(1)+1;
            
            
        } catch (Exception e) {
           e.printStackTrace();
        }
    }
    
        
    private void savebtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_savebtnActionPerformed
        
        if(cusname.getText().isEmpty()|| cusadd.getText().isEmpty()||cusphone.getText().isEmpty()){
            JOptionPane.showMessageDialog(this,"Missing information.");
        }else{
            
            try {
                countid();
                conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/petshopdb","root","1234");
                
                String sql="insert into customer values(?,?,?,?) ";
                PreparedStatement save=conn.prepareStatement(sql);
                
                save.setInt(1, itemid);
                save.setString(2, cusname.getText());
                save.setString(3, cusadd.getText());
                save.setString(4, cusphone.getText());
                
                int row=save.executeUpdate();
                
                JOptionPane.showMessageDialog(this, "Customer Added Successfully.");
                
                SelectionClear();
                displayCus();
                clearText();
                
                conn.close();
                
            } catch (SQLException ex) {
                ex.printStackTrace();
                
                JOptionPane.showMessageDialog(this, "Something Went Wrong.");
                
            }
        }
        
    }//GEN-LAST:event_savebtnActionPerformed
    
    int key=0;
    private void customertblMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_customertblMouseClicked
       
        DefaultTableModel model =(DefaultTableModel) customertbl.getModel();
        int index=customertbl.getSelectedRow();
        key=Integer.valueOf(model.getValueAt(index,  0).toString());
        cusname.setText(model.getValueAt(index,1).toString());
        cusadd.setText(model.getValueAt(index,2).toString());
        cusphone.setText(model.getValueAt(index,3).toString());
        
    }//GEN-LAST:event_customertblMouseClicked

    private void editbtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_editbtnActionPerformed
        if(cusname.getText().isEmpty()|| cusadd.getText().isEmpty()||cusphone.getText().isEmpty()){
            
            JOptionPane.showMessageDialog(this,"Missing information.");
            
        }else{
            
            try {
                
                conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/petshopdb","root","1234");
                
                String sql="update customer set cusname=?,cusadd=?,cusphone=?  where cusid=?";
                PreparedStatement update=conn.prepareStatement(sql);
                
                update.setInt(4, key);
                update.setString(1, cusname.getText());
                update.setString(2, cusadd.getText());
                update.setString(3, cusphone.getText());
                
                int row=update.executeUpdate();
                
                JOptionPane.showMessageDialog(this, "Customer Updated Successfully.");
                
                SelectionClear();
                displayCus();
                clearText();
                
                conn.close();
                
            } catch (SQLException ex) {
                ex.printStackTrace();
                
                JOptionPane.showMessageDialog(this, "Something Went Wrong.");
                
            }
        }
    }//GEN-LAST:event_editbtnActionPerformed

    private void delbtnMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_delbtnMouseClicked
       
        if(cusname.getText().isEmpty()|| cusadd.getText().isEmpty()||cusphone.getText().isEmpty()){
            
            JOptionPane.showMessageDialog(this,"Missing information.");
            
        }else{
            
            try {
                
                conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/petshopdb","root","1234");
                
                String sql="delete from customer where cusid=?";
                PreparedStatement update=conn.prepareStatement(sql);
                
                update.setInt(1, key);
                
                
                int row=update.executeUpdate();
                
                JOptionPane.showMessageDialog(this, "Customer Removed Successfully.");
                
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

    private void editbtnMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_editbtnMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_editbtnMouseClicked

    private void savebtnMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_savebtnMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_savebtnMouseClicked

    private void jLabel2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel2MouseClicked
        new pets().setVisible(true);
           this.dispose();
    }//GEN-LAST:event_jLabel2MouseClicked

    private void jLabel5MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel5MouseClicked
       new Customers().setVisible(true);
           this.dispose();
    }//GEN-LAST:event_jLabel5MouseClicked

    private void jLabel6MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel6MouseClicked
       new Billing().setVisible(true);
           this.dispose();
    }//GEN-LAST:event_jLabel6MouseClicked

    private void jLabel4MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel4MouseClicked
        new Login().setVisible(true);
           this.dispose();
    }//GEN-LAST:event_jLabel4MouseClicked

    private void jLabel2MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel2MouseEntered
        jLabel2.setBackground(new java.awt.Color(102, 0, 51));
        jLabel2.setOpaque(true);
        jLabel2.repaint();
    }//GEN-LAST:event_jLabel2MouseEntered

    private void jLabel2MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel2MouseExited
        jLabel2.setBackground(new java.awt.Color(0, 51, 102));
        jLabel2.setOpaque(true);
        jLabel2.repaint();
    }//GEN-LAST:event_jLabel2MouseExited

    private void jLabel5MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel5MouseEntered
        jLabel5.setBackground(new java.awt.Color(102, 0, 51));
        jLabel5.setOpaque(true);
        jLabel5.repaint();
    }//GEN-LAST:event_jLabel5MouseEntered

    private void jLabel5MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel5MouseExited
        jLabel5.setBackground(new java.awt.Color(0, 51, 102));
        jLabel5.setOpaque(true);
        jLabel5.repaint();
    }//GEN-LAST:event_jLabel5MouseExited

    private void jLabel6MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel6MouseEntered
        jLabel6.setBackground(new java.awt.Color(102, 0, 51));
        jLabel6.setOpaque(true);
        jLabel6.repaint();
    }//GEN-LAST:event_jLabel6MouseEntered

    private void jLabel6MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel6MouseExited
        jLabel6.setBackground(new java.awt.Color(0, 51, 102));
        jLabel6.setOpaque(true);
        jLabel6.repaint();
    }//GEN-LAST:event_jLabel6MouseExited

    private void jLabel4MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel4MouseEntered
        jLabel4.setBackground(new java.awt.Color(102, 0, 51));
        jLabel4.setOpaque(true);
        jLabel4.repaint();
    }//GEN-LAST:event_jLabel4MouseEntered

    private void jLabel4MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel4MouseExited
        jLabel4.setBackground(new java.awt.Color(0, 51, 102));
        jLabel4.setOpaque(true);
        jLabel4.repaint();
    }//GEN-LAST:event_jLabel4MouseExited

    private void jLabel3MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel3MouseEntered
        jLabel3.setBackground(new java.awt.Color(102, 0, 51));
        jLabel3.setOpaque(true);
        jLabel3.repaint();
    }//GEN-LAST:event_jLabel3MouseEntered

    private void jLabel3MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel3MouseExited
        jLabel3.setBackground(new java.awt.Color(0, 51, 102));
        jLabel3.setOpaque(true);
        jLabel3.repaint();
    }//GEN-LAST:event_jLabel3MouseExited

    private void CategoryMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_CategoryMouseClicked
        new Category().setVisible(true);
           this.dispose();
    }//GEN-LAST:event_CategoryMouseClicked

    private void CategoryMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_CategoryMouseEntered
        Category.setBackground(new java.awt.Color(102, 0, 51));
        Category.setOpaque(true);
        Category.repaint();
    }//GEN-LAST:event_CategoryMouseEntered

    private void CategoryMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_CategoryMouseExited
        Category.setBackground(new java.awt.Color(0, 51, 102));
        Category.setOpaque(true);
        Category.repaint();
    }//GEN-LAST:event_CategoryMouseExited

    
    
   
    
    
    
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
            java.util.logging.Logger.getLogger(Customers.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Customers.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Customers.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Customers.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Customers().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel Category;
    private javax.swing.JTextField cusadd;
    private javax.swing.JTextField cusname;
    private javax.swing.JTextField cusphone;
    private javax.swing.JTable customertbl;
    private javax.swing.JButton delbtn;
    private javax.swing.JButton editbtn;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
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
