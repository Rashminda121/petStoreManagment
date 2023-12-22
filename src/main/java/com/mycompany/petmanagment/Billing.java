/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package com.mycompany.petmanagment;

import com.toedter.calendar.JDateChooser;
import java.awt.FlowLayout;
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
import java.time.LocalDate;
import java.sql.Date;
import java.util.Calendar;
import javax.swing.JFrame;
import javax.swing.SwingUtilities;


/**
 *
 * @author Rashminda
 */
public class Billing extends javax.swing.JFrame {

   
    public Billing() {
       initComponents();
       display();
       getCustomer();
       getUser();
       setCurrentDate();
    }
    
    
    private void initializeComponents() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setTitle("Date Setter");

        date = new JDateChooser();

        setLayout(new FlowLayout());
        add(date);

        pack();
        setLocationRelativeTo(null);
    }

    private void setCurrentDate() {
        date.setDate(new Date(Calendar.getInstance().getTimeInMillis()));
    }

    
    
    
    
    
    Connection conn=null;
    PreparedStatement ps=null;
    ResultSet rs=null;
    Statement st=null;
    
    private void display(){
        
        try {
            conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/petshopdb","root","1234");
            st=conn.createStatement();
            
            String sql="Select * from pettbl ";
            rs = st.executeQuery(sql);
            
            while(rs.next()){
                
                String pid=String.valueOf(rs.getString("pid"));
                String pname=String.valueOf(rs.getString("pname"));
                String pcat=String.valueOf(rs.getString("pcat"));
                String pqua=String.valueOf(rs.getString("pquan"));
                 String price=String.valueOf(rs.getString("price"));
               

                String tbData[]={pid,pname,pcat,pqua,price};
                DefaultTableModel tblModel=(DefaultTableModel)proTbl.getModel();
                
                tblModel.addRow(tbData);
            
            }
            conn.close();
           
            
        } catch (SQLException ex) {
            
            Logger.getLogger(Customers.class.getName()).log(Level.SEVERE, null, ex);
        }
       
    }
    
     private void SelectionClear() {
        DefaultTableModel model = (DefaultTableModel) proTbl.getModel();
        model.setRowCount(0); // Clear all rows from the table model
    }
     
     private void clearText(){
        
         product.setText("");
         price.setText("");
         //date.setDate("");
         qua.setText("");
         
     }
     private void clearText2(){
         usercb.setSelectedItem("-- select --");
         customercb.setSelectedItem("-- select --");
         date.setDate(null);
     }
     
     private void getCustomer(){
        try {
            conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/petshopdb","root","1234");
             st=conn.createStatement();
            
            String sql="Select * from customer ";
            rs = st.executeQuery(sql);
            
             while(rs.next()){
                 
                 int cusid=rs.getInt("cusid");
                 customercb.addItem(String.valueOf(cusid));
             }
            
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
           
     }
     
     private void getUser(){
        try {
            conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/petshopdb","root","1234");
             st=conn.createStatement();
            
            String sql="Select * from user";
            rs = st.executeQuery(sql);
            
             while(rs.next()){
                 
                 int cusid=rs.getInt("uid");
                 usercb.addItem(String.valueOf(cusid));
             }
            
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
           
     }

    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel5 = new javax.swing.JPanel();
        jPanel6 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel19 = new javax.swing.JLabel();
        jLabel20 = new javax.swing.JLabel();
        jLabel21 = new javax.swing.JLabel();
        product = new javax.swing.JTextField();
        qua = new javax.swing.JTextField();
        jLabel22 = new javax.swing.JLabel();
        jLabel23 = new javax.swing.JLabel();
        printbtn = new javax.swing.JButton();
        resetbtn = new javax.swing.JButton();
        delbtn = new javax.swing.JButton();
        jScrollPane3 = new javax.swing.JScrollPane();
        proTbl = new javax.swing.JTable();
        customercb = new javax.swing.JComboBox<>();
        usercb = new javax.swing.JComboBox<>();
        jLabel25 = new javax.swing.JLabel();
        date = new com.toedter.calendar.JDateChooser();
        jLabel26 = new javax.swing.JLabel();
        price = new javax.swing.JTextField();
        jScrollPane4 = new javax.swing.JScrollPane();
        billtbl = new javax.swing.JTable();
        jLabel27 = new javax.swing.JLabel();
        addbtn = new javax.swing.JButton();
        savebtn = new javax.swing.JButton();
        totlbl = new javax.swing.JLabel();
        totlbl1 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel24 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel5.setBackground(new java.awt.Color(0, 51, 102));

        jPanel6.setBackground(new java.awt.Color(255, 255, 255));

        jLabel2.setBackground(new java.awt.Color(255, 255, 255));
        jLabel2.setFont(new java.awt.Font("Century Gothic", 1, 18)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(0, 51, 102));
        jLabel2.setText("Billing");

        jLabel19.setBackground(new java.awt.Color(255, 255, 255));
        jLabel19.setFont(new java.awt.Font("Century Gothic", 1, 16)); // NOI18N
        jLabel19.setForeground(new java.awt.Color(0, 51, 102));
        jLabel19.setText("User ID");

        jLabel20.setBackground(new java.awt.Color(255, 255, 255));
        jLabel20.setFont(new java.awt.Font("Century Gothic", 1, 16)); // NOI18N
        jLabel20.setForeground(new java.awt.Color(0, 51, 102));
        jLabel20.setText("Customer");

        jLabel21.setBackground(new java.awt.Color(255, 255, 255));
        jLabel21.setFont(new java.awt.Font("Century Gothic", 1, 18)); // NOI18N
        jLabel21.setForeground(new java.awt.Color(0, 51, 102));
        jLabel21.setText("Product List");

        product.setBackground(new java.awt.Color(255, 255, 255));
        product.setFont(new java.awt.Font("Century Gothic", 1, 16)); // NOI18N
        product.setForeground(new java.awt.Color(0, 51, 102));

        qua.setBackground(new java.awt.Color(255, 255, 255));
        qua.setFont(new java.awt.Font("Century Gothic", 1, 16)); // NOI18N
        qua.setForeground(new java.awt.Color(0, 51, 102));

        jLabel22.setBackground(new java.awt.Color(255, 255, 255));
        jLabel22.setFont(new java.awt.Font("Century Gothic", 1, 16)); // NOI18N
        jLabel22.setForeground(new java.awt.Color(0, 51, 102));
        jLabel22.setText("Quantity");

        jLabel23.setBackground(new java.awt.Color(255, 255, 255));
        jLabel23.setFont(new java.awt.Font("Century Gothic", 1, 16)); // NOI18N
        jLabel23.setForeground(new java.awt.Color(0, 51, 102));
        jLabel23.setText("Product");

        printbtn.setBackground(new java.awt.Color(0, 51, 102));
        printbtn.setFont(new java.awt.Font("Century Gothic", 0, 15)); // NOI18N
        printbtn.setForeground(new java.awt.Color(255, 255, 255));
        printbtn.setText("Print");
        printbtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                printbtnActionPerformed(evt);
            }
        });

        resetbtn.setBackground(new java.awt.Color(0, 51, 102));
        resetbtn.setFont(new java.awt.Font("Century Gothic", 0, 15)); // NOI18N
        resetbtn.setForeground(new java.awt.Color(255, 255, 255));
        resetbtn.setText("Reset");
        resetbtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                resetbtnActionPerformed(evt);
            }
        });

        delbtn.setBackground(new java.awt.Color(0, 51, 102));
        delbtn.setFont(new java.awt.Font("Century Gothic", 0, 15)); // NOI18N
        delbtn.setForeground(new java.awt.Color(255, 255, 255));
        delbtn.setText("Delete");

        proTbl.setBackground(new java.awt.Color(255, 255, 255));
        proTbl.setFont(new java.awt.Font("Century Gothic", 0, 14)); // NOI18N
        proTbl.setForeground(new java.awt.Color(0, 51, 102));
        proTbl.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "Name", "Category", "Quantity", "Price"
            }
        ));
        proTbl.setRowHeight(30);
        proTbl.setRowMargin(2);
        proTbl.setSelectionBackground(new java.awt.Color(0, 51, 102));
        proTbl.setSelectionForeground(new java.awt.Color(255, 255, 255));
        proTbl.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                proTblMouseClicked(evt);
            }
        });
        jScrollPane3.setViewportView(proTbl);

        customercb.setBackground(new java.awt.Color(255, 255, 255));
        customercb.setFont(new java.awt.Font("Century Gothic", 1, 16)); // NOI18N
        customercb.setForeground(new java.awt.Color(0, 51, 102));
        customercb.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "-- select --" }));

        usercb.setBackground(new java.awt.Color(255, 255, 255));
        usercb.setFont(new java.awt.Font("Century Gothic", 1, 16)); // NOI18N
        usercb.setForeground(new java.awt.Color(0, 51, 102));
        usercb.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "-- select --" }));

        jLabel25.setBackground(new java.awt.Color(255, 255, 255));
        jLabel25.setFont(new java.awt.Font("Century Gothic", 1, 16)); // NOI18N
        jLabel25.setForeground(new java.awt.Color(0, 51, 102));
        jLabel25.setText("Date");

        date.setBackground(new java.awt.Color(255, 255, 255));
        date.setForeground(new java.awt.Color(0, 51, 102));
        date.setAlignmentX(0.7F);

        jLabel26.setBackground(new java.awt.Color(255, 255, 255));
        jLabel26.setFont(new java.awt.Font("Century Gothic", 1, 16)); // NOI18N
        jLabel26.setForeground(new java.awt.Color(0, 51, 102));
        jLabel26.setText("Price");

        price.setBackground(new java.awt.Color(255, 255, 255));
        price.setFont(new java.awt.Font("Century Gothic", 1, 16)); // NOI18N
        price.setForeground(new java.awt.Color(0, 51, 102));

        billtbl.setBackground(new java.awt.Color(255, 255, 255));
        billtbl.setFont(new java.awt.Font("Century Gothic", 0, 14)); // NOI18N
        billtbl.setForeground(new java.awt.Color(0, 51, 102));
        billtbl.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "Product", "Price", "Quantity", "Total"
            }
        ));
        billtbl.setRowHeight(30);
        billtbl.setRowMargin(2);
        billtbl.setSelectionBackground(new java.awt.Color(0, 51, 102));
        billtbl.setSelectionForeground(new java.awt.Color(255, 255, 255));
        jScrollPane4.setViewportView(billtbl);

        jLabel27.setBackground(new java.awt.Color(255, 255, 255));
        jLabel27.setFont(new java.awt.Font("Century Gothic", 1, 18)); // NOI18N
        jLabel27.setForeground(new java.awt.Color(0, 51, 102));
        jLabel27.setText("Customer Bill");

        addbtn.setBackground(new java.awt.Color(0, 51, 102));
        addbtn.setFont(new java.awt.Font("Century Gothic", 0, 15)); // NOI18N
        addbtn.setForeground(new java.awt.Color(255, 255, 255));
        addbtn.setText("Add To Bill");
        addbtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addbtnActionPerformed(evt);
            }
        });

        savebtn.setBackground(new java.awt.Color(0, 51, 102));
        savebtn.setFont(new java.awt.Font("Century Gothic", 0, 15)); // NOI18N
        savebtn.setForeground(new java.awt.Color(255, 255, 255));
        savebtn.setText("Save");
        savebtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                savebtnActionPerformed(evt);
            }
        });

        totlbl.setBackground(new java.awt.Color(255, 255, 255));
        totlbl.setFont(new java.awt.Font("Century Gothic", 1, 18)); // NOI18N
        totlbl.setForeground(new java.awt.Color(0, 51, 102));
        totlbl.setText("0.00");
        totlbl.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                totlblMouseClicked(evt);
            }
        });

        totlbl1.setBackground(new java.awt.Color(255, 255, 255));
        totlbl1.setFont(new java.awt.Font("Century Gothic", 1, 18)); // NOI18N
        totlbl1.setForeground(new java.awt.Color(0, 51, 102));
        totlbl1.setText("Total :");
        totlbl1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                totlbl1MouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addGap(84, 84, 84)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel19)
                            .addComponent(usercb, javax.swing.GroupLayout.PREFERRED_SIZE, 134, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel25)
                            .addComponent(date, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 134, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(24, 24, 24)
                        .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel20)
                            .addComponent(customercb, javax.swing.GroupLayout.PREFERRED_SIZE, 134, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(resetbtn)))
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addGap(12, 12, 12)
                        .addComponent(jLabel21, javax.swing.GroupLayout.PREFERRED_SIZE, 109, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel22)
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(product, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabel23))
                            .addComponent(qua, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(31, 31, 31)
                        .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(price, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel26)
                            .addGroup(jPanel6Layout.createSequentialGroup()
                                .addComponent(addbtn)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(delbtn))))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel6Layout.createSequentialGroup()
                        .addComponent(jLabel27, javax.swing.GroupLayout.PREFERRED_SIZE, 127, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(84, 84, 84)))
                .addContainerGap(76, Short.MAX_VALUE))
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel6Layout.createSequentialGroup()
                        .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 272, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(jPanel6Layout.createSequentialGroup()
                                .addComponent(totlbl1, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(totlbl, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(20, 20, 20)
                                .addComponent(savebtn)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(printbtn, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 332, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(48, 48, 48))))
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel2)
                .addGap(18, 18, 18)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addComponent(jLabel23)
                        .addGap(33, 33, 33))
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel19)
                            .addComponent(jLabel20)
                            .addComponent(jLabel26))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(customercb, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(usercb, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(product, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(price, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addComponent(jLabel22)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(qua, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(delbtn)
                            .addComponent(resetbtn)
                            .addComponent(addbtn)))
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addComponent(jLabel25)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(date, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(33, 33, 33)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel27)
                    .addComponent(jLabel21))
                .addGap(18, 18, 18)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 214, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 214, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(savebtn)
                            .addComponent(printbtn)
                            .addComponent(totlbl1, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(totlbl))))
                .addContainerGap(24, Short.MAX_VALUE))
        );

        jLabel3.setBackground(new java.awt.Color(0, 51, 102));
        jLabel3.setFont(new java.awt.Font("Century Gothic", 1, 18)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setIcon(new javax.swing.ImageIcon("C:\\Users\\Rashminda\\Documents\\NetBeansProjects\\petmanagment\\src\\main\\java\\com\\mycompany\\petmanagment\\cat.png")); // NOI18N
        jLabel3.setText(" Pets");

        jLabel4.setBackground(new java.awt.Color(0, 51, 102));
        jLabel4.setFont(new java.awt.Font("Century Gothic", 1, 18)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setIcon(new javax.swing.ImageIcon("C:\\Users\\Rashminda\\Documents\\NetBeansProjects\\petmanagment\\src\\main\\java\\com\\mycompany\\petmanagment\\cat.png")); // NOI18N
        jLabel4.setText(" Users");

        jLabel5.setBackground(new java.awt.Color(0, 51, 102));
        jLabel5.setFont(new java.awt.Font("Century Gothic", 1, 18)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setIcon(new javax.swing.ImageIcon("C:\\Users\\Rashminda\\Documents\\NetBeansProjects\\petmanagment\\src\\main\\java\\com\\mycompany\\petmanagment\\cat.png")); // NOI18N
        jLabel5.setText(" Logout");

        jLabel6.setBackground(new java.awt.Color(0, 51, 102));
        jLabel6.setFont(new java.awt.Font("Century Gothic", 1, 18)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setIcon(new javax.swing.ImageIcon("C:\\Users\\Rashminda\\Documents\\NetBeansProjects\\petmanagment\\src\\main\\java\\com\\mycompany\\petmanagment\\cat.png")); // NOI18N
        jLabel6.setText(" Customers");

        jLabel7.setBackground(new java.awt.Color(0, 51, 102));
        jLabel7.setFont(new java.awt.Font("Century Gothic", 1, 18)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(255, 255, 255));
        jLabel7.setIcon(new javax.swing.ImageIcon("C:\\Users\\Rashminda\\Documents\\NetBeansProjects\\petmanagment\\src\\main\\java\\com\\mycompany\\petmanagment\\cat.png")); // NOI18N
        jLabel7.setText(" Billing");

        jLabel24.setBackground(new java.awt.Color(0, 51, 102));
        jLabel24.setFont(new java.awt.Font("Century Gothic", 1, 18)); // NOI18N
        jLabel24.setForeground(new java.awt.Color(255, 255, 255));
        jLabel24.setIcon(new javax.swing.ImageIcon("C:\\Users\\Rashminda\\Documents\\NetBeansProjects\\petmanagment\\src\\main\\java\\com\\mycompany\\petmanagment\\animals.png")); // NOI18N

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addGap(72, 72, 72)
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel5)
                            .addComponent(jLabel4)
                            .addComponent(jLabel3)
                            .addComponent(jLabel7)
                            .addComponent(jLabel6)))
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addGap(27, 27, 27)
                        .addComponent(jLabel24)))
                .addGap(18, 18, 18)
                .addComponent(jPanel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(30, Short.MAX_VALUE))
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addComponent(jLabel24)
                        .addGap(47, 47, 47)
                        .addComponent(jLabel3)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel4)
                        .addGap(28, 28, 28)
                        .addComponent(jLabel6)
                        .addGap(31, 31, 31)
                        .addComponent(jLabel7)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel5)
                        .addGap(100, 100, 100))))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void resetbtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_resetbtnActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_resetbtnActionPerformed

    private void printbtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_printbtnActionPerformed
        
        try{
            
            billtbl.print();
            
        }catch(Exception e){
            e.printStackTrace();
        }
        
        
    }//GEN-LAST:event_printbtnActionPerformed

    
     int itemid;
    
    Statement st2=null;
    ResultSet rs2=null;
    
    private void countid(){
        try {
            st2=conn.createStatement();
            
            String sql="select max(bnum) from bill ";
            rs2=st2.executeQuery(sql);
            
            rs2.next();
            
            itemid=rs2.getInt(1)+1;
            
            
        } catch (Exception e) {
           e.printStackTrace();
        }
    }
    private void savebtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_savebtnActionPerformed
        if(usercb.getSelectedItem().equals("-- select --")|| customercb.getSelectedItem().equals("-- select --") ){
           
            JOptionPane.showMessageDialog(this,"Missing information.");
        }else{
            
            try {
                countid();
                conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/petshopdb","root","1234");
                
                String sql="insert into bill values(?,?,?,?,?) ";
                PreparedStatement save=conn.prepareStatement(sql);
                
                save.setInt(1, itemid);
                save.setString(2, date.getDate().toString());
                save.setInt(3, Integer.valueOf(customercb.getSelectedItem().toString()));
                save.setInt(4, Integer.valueOf(usercb.getSelectedItem().toString()));
                save.setInt(5, grandTot);
                
                int row=save.executeUpdate();
                
                JOptionPane.showMessageDialog(this, "Bill Saved Successfully.");
                
                //SelectionClear();
                //display();
                clearText2();
                setCurrentDate();
                
                conn.close();
                
            } catch (SQLException ex) {
                ex.printStackTrace();
                
                JOptionPane.showMessageDialog(this, "Something Went Wrong.");
                
            }
        } 
        
    }//GEN-LAST:event_savebtnActionPerformed

    int key=0;
    int stock=0;
    private void proTblMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_proTblMouseClicked
        
        DefaultTableModel model =(DefaultTableModel) proTbl.getModel();
        int index=proTbl.getSelectedRow();
        key=Integer.valueOf(model.getValueAt(index,  0).toString());
        product.setText(model.getValueAt(index,1).toString());
        stock =Integer.valueOf(model.getValueAt(index,3).toString());
        
        price.setText(model.getValueAt(index,4).toString());
        
        
    }//GEN-LAST:event_proTblMouseClicked
    
    int n = 1;
    int row = 0;
    
    int grandTot=0;
    private void addbtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addbtnActionPerformed
      
       if(product.getText().isEmpty()||qua.getText().isEmpty()||price.getText().isEmpty()) {
          
           JOptionPane.showMessageDialog(this,"Missing information.");
       }else{
        
            DefaultTableModel model = (DefaultTableModel) billtbl.getModel();

           // Ensure that the table has enough rows
           if (row >= model.getRowCount()) {
               model.addRow(new Object[model.getColumnCount()]);
           }
           
           int total=Integer.valueOf(price.getText()) * Integer.valueOf(qua.getText());
           billtbl.setValueAt(n, row, 0);
           billtbl.setValueAt(product.getText(), row, 1);
           billtbl.setValueAt(price.getText(), row, 2);
           billtbl.setValueAt(qua.getText(), row, 3);
           billtbl.setValueAt(total, row, 4);
           
           grandTot=grandTot+total;
           totlbl.setText(" Rs "+grandTot);

           n++;
           row++;
       }
       clearText();
    }//GEN-LAST:event_addbtnActionPerformed

    private void totlblMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_totlblMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_totlblMouseClicked

    private void totlbl1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_totlbl1MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_totlbl1MouseClicked

    
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
            java.util.logging.Logger.getLogger(Billing.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Billing.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Billing.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Billing.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Billing().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton addbtn;
    private javax.swing.JTable billtbl;
    private javax.swing.JComboBox<String> customercb;
    private com.toedter.calendar.JDateChooser date;
    private javax.swing.JButton delbtn;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel25;
    private javax.swing.JLabel jLabel26;
    private javax.swing.JLabel jLabel27;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JTextField price;
    private javax.swing.JButton printbtn;
    private javax.swing.JTable proTbl;
    private javax.swing.JTextField product;
    private javax.swing.JTextField qua;
    private javax.swing.JButton resetbtn;
    private javax.swing.JButton savebtn;
    private javax.swing.JLabel totlbl;
    private javax.swing.JLabel totlbl1;
    private javax.swing.JComboBox<String> usercb;
    // End of variables declaration//GEN-END:variables
}
