/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package CommunityAdmin;

import Login.Login;
import Patient.Patient;
import javax.swing.*;
import javax.swing.JOptionPane;
import javax.swing.JFrame;
import java.awt.*;
import java.util.*; 
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class CommunityAdmin extends javax.swing.JFrame {
ArrayList<Food> mylist;
String header[]= new String[]{"Doc Name", "Hospital Name", "Speciality","city","Zipcode","Community"};
DefaultTableModel dtm;
int row, col;


public CommunityAdmin() {
initComponents();
    this.setResizable(false);
    Toolkit tk = Toolkit.getDefaultToolkit();
    int xsize = (int) tk.getScreenSize().getWidth();
    int ysize = (int) tk.getScreenSize().getHeight(); 
    Insets scnMax = Toolkit.getDefaultToolkit().getScreenInsets(getGraphicsConfiguration()); 
    int taskBarSize = scnMax.bottom;
    this.setSize(xsize, ysize - taskBarSize);
mylist = new ArrayList<>();
dtm = new DefaultTableModel(header, 0);
jTable2.setModel (dtm);
this.setLocationRelativeTo(null); 
}
    /**
     * Creates new form patient
     */
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jtxtDocName = new javax.swing.JTextField();
        jtxtHospName = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jtxtCity = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jtxtZip = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        jtxtSpecial = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jtxtCommunity = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable2 = new javax.swing.JTable();
        jUpd = new javax.swing.JButton();
        jDel = new javax.swing.JButton();
        jLog = new javax.swing.JButton();
        jRes = new javax.swing.JButton();
        JExit = new javax.swing.JButton();
        JLoad = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        jLabel8 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMinimumSize(new java.awt.Dimension(1400, 800));
        setPreferredSize(new java.awt.Dimension(1400, 800));
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(51, 153, 255));
        jPanel1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 3));

        jLabel2.setBackground(new java.awt.Color(0, 0, 0));
        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 60)); // NOI18N
        jLabel2.setText("Hospital Records");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(460, Short.MAX_VALUE)
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 669, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(255, 255, 255))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jLabel2)
                .addGap(0, 11, Short.MAX_VALUE))
        );

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 1390, -1));

        jPanel2.setBackground(new java.awt.Color(102, 255, 255));
        jPanel2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 3));

        jLabel1.setBackground(new java.awt.Color(51, 255, 255));
        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 48)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(102, 0, 102));
        jLabel1.setText("Community Admin");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(489, Short.MAX_VALUE)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 669, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(226, 226, 226))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addComponent(jLabel1)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        getContentPane().add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 110, 1390, 70));

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel3.setText("Doctor Name:");
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 240, -1, -1));

        jtxtDocName.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jtxtDocName.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jtxtDocNameKeyReleased(evt);
            }
        });
        getContentPane().add(jtxtDocName, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 240, 230, -1));

        jtxtHospName.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jtxtHospName.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jtxtHospNameKeyReleased(evt);
            }
        });
        getContentPane().add(jtxtHospName, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 300, 230, -1));

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel4.setText("Hospital Name:");
        getContentPane().add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 300, -1, -1));

        jtxtCity.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jtxtCity.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jtxtCityKeyReleased(evt);
            }
        });
        getContentPane().add(jtxtCity, new org.netbeans.lib.awtextra.AbsoluteConstraints(980, 240, 230, -1));

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel5.setText("City:");
        getContentPane().add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(790, 240, -1, -1));

        jtxtZip.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jtxtZip.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jtxtZipKeyReleased(evt);
            }
        });
        getContentPane().add(jtxtZip, new org.netbeans.lib.awtextra.AbsoluteConstraints(980, 300, 230, -1));

        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel6.setText("Zip Code:");
        getContentPane().add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(790, 300, -1, -1));

        jtxtSpecial.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jtxtSpecial.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jtxtSpecialKeyReleased(evt);
            }
        });
        getContentPane().add(jtxtSpecial, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 360, 230, -1));

        jLabel7.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel7.setText("Speciality:");
        getContentPane().add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 360, -1, -1));

        jLabel9.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel9.setText("Community:");
        getContentPane().add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(790, 360, -1, -1));

        jtxtCommunity.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jtxtCommunity.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jtxtCommunityKeyReleased(evt);
            }
        });
        getContentPane().add(jtxtCommunity, new org.netbeans.lib.awtextra.AbsoluteConstraints(980, 360, 230, -1));

        jTable2.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Doc Name", "Hospital Name", "Speciality", "City", "Zip Code", "Community"
            }
        ));
        jTable2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTable2MouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jTable2);

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 530, 1270, 260));

        jUpd.setBackground(new java.awt.Color(0, 51, 153));
        jUpd.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jUpd.setForeground(new java.awt.Color(255, 255, 255));
        jUpd.setText("Add");
        jUpd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jUpdActionPerformed(evt);
            }
        });
        getContentPane().add(jUpd, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 450, 120, -1));

        jDel.setBackground(new java.awt.Color(0, 51, 153));
        jDel.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jDel.setForeground(new java.awt.Color(255, 255, 255));
        jDel.setText("Delete");
        jDel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jDelActionPerformed(evt);
            }
        });
        getContentPane().add(jDel, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 450, 113, -1));

        jLog.setBackground(new java.awt.Color(0, 51, 153));
        jLog.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLog.setForeground(new java.awt.Color(255, 255, 255));
        jLog.setText("Patient");
        jLog.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jLogActionPerformed(evt);
            }
        });
        getContentPane().add(jLog, new org.netbeans.lib.awtextra.AbsoluteConstraints(590, 450, 113, -1));

        jRes.setBackground(new java.awt.Color(0, 51, 153));
        jRes.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jRes.setForeground(new java.awt.Color(255, 255, 255));
        jRes.setText("Reset");
        jRes.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jResActionPerformed(evt);
            }
        });
        getContentPane().add(jRes, new org.netbeans.lib.awtextra.AbsoluteConstraints(760, 450, 113, -1));

        JExit.setBackground(new java.awt.Color(0, 51, 153));
        JExit.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        JExit.setForeground(new java.awt.Color(255, 255, 255));
        JExit.setText("Exit");
        JExit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JExitActionPerformed(evt);
            }
        });
        getContentPane().add(JExit, new org.netbeans.lib.awtextra.AbsoluteConstraints(930, 450, 113, -1));

        JLoad.setBackground(new java.awt.Color(0, 51, 153));
        JLoad.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        JLoad.setForeground(new java.awt.Color(255, 255, 255));
        JLoad.setText("Load");
        JLoad.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JLoadActionPerformed(evt);
            }
        });
        getContentPane().add(JLoad, new org.netbeans.lib.awtextra.AbsoluteConstraints(1090, 450, 113, -1));

        jPanel3.setBackground(new java.awt.Color(51, 153, 255));
        jPanel3.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 3));

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1384, Short.MAX_VALUE)
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 64, Short.MAX_VALUE)
        );

        getContentPane().add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 430, 1390, 70));

        jLabel8.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(255, 0, 0));
        getContentPane().add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(990, 330, 200, 20));

        jLabel10.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(255, 0, 0));
        getContentPane().add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 330, 200, 20));

        jLabel11.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(255, 0, 0));
        getContentPane().add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 390, 200, 20));

        jLabel12.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel12.setForeground(new java.awt.Color(255, 0, 0));
        getContentPane().add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(990, 390, 200, 20));

        jLabel13.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel13.setForeground(new java.awt.Color(255, 0, 0));
        getContentPane().add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 270, 200, 20));

        jLabel14.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel14.setForeground(new java.awt.Color(255, 0, 0));
        getContentPane().add(jLabel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(1000, 270, 200, 20));

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jTable2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable2MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_jTable2MouseClicked

    private void JLoadActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JLoadActionPerformed
        TableModel model1 = jTable2.getModel();
        int indexs[] = jTable2.getSelectedRows();
        Object[] row = new Object[6];
        Patient frm2 = new Patient();
        DefaultTableModel model2 = (DefaultTableModel)frm2.jTable2.getModel();

        for(int i = 0; i < indexs.length; i++)
        {
            row[0] = model1.getValueAt(indexs[i], 0);
            row[1] = model1.getValueAt(indexs[i], 1);
            row[2] = model1.getValueAt(indexs[i], 2);
            row[3] = model1.getValueAt(indexs[i], 3);
            row[4] = model1.getValueAt(indexs[i], 4);
            row[5] = model1.getValueAt(indexs[i],5);
            model2.addRow(row);
        }

        frm2.setVisible(true);
    }//GEN-LAST:event_JLoadActionPerformed

    private void JExitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JExitActionPerformed
        JFrame frame = new JFrame();
        if (JOptionPane.showConfirmDialog( frame, "Confirm if you want to exit", "HospitalManagement System",
            JOptionPane.YES_NO_OPTION)==JOptionPane.YES_NO_OPTION)
    {System.exit(0);
        }
    }//GEN-LAST:event_JExitActionPerformed

    private void jResActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jResActionPerformed
        jtxtDocName.setText("");
        jtxtHospName.setText("");
        jtxtSpecial.setText ("");
        jtxtCity.setText("");
        jtxtZip.setText("");
        jtxtCommunity.setText ("");
    }//GEN-LAST:event_jResActionPerformed

    private void jLogActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jLogActionPerformed
        this.setVisible(false);
        Patient iPatient = new Patient();
        iPatient.setVisible(true);
    }//GEN-LAST:event_jLogActionPerformed

    private void jUpdActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jUpdActionPerformed

        String dname= jtxtDocName.getText();
        String hname= jtxtHospName.getText();
        String speciality = jtxtSpecial.getText();
        String city= jtxtCity.getText();
        String zipcode= jtxtZip.getText();
        String community= jtxtCommunity.getText();

        mylist.add(new Food(dname, hname, speciality, city,zipcode,community));
        dtm.setRowCount(0);
        for(int i=0; i< mylist.size(); i++)
        {
            Object[] objs = {mylist.get(i).dname,mylist.get(i).hname,mylist.get(i).speciality,mylist.get(i).city,
                mylist.get(i).zipcode, mylist.get(i).community};
            dtm.addRow(objs);
        }

        // DefaultTableModel model = (DefaultTableModel) jTable2.getModel();
        // model.addRow (new Object[] {
            //   jtxtDocName.getText(), jtxtHospName.getText(), jtxtSpecial.getText(), jtxtCity.getText(),
            //  jtxtZip.getText(), jtxtCommunity.getText(), });
    }//GEN-LAST:event_jUpdActionPerformed

    private void jDelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jDelActionPerformed
        DefaultTableModel model = (DefaultTableModel) jTable2.getModel();
        if(jTable2.getSelectedRow() ==-1){
            if(jTable2.getRowCount() ==0) {

                JOptionPane.showMessageDialog(null, "No data to delete", "Hospital Management Systems",
                    JOptionPane.OK_OPTION );

            }else{
                JOptionPane.showMessageDialog (null, "Select a row to delete", "Hospital Management Systems",
                    JOptionPane. OK_OPTION);
            }

        }
        else
        {
            model.removeRow(jTable2.getSelectedRow());
        }
    }//GEN-LAST:event_jDelActionPerformed

    private void jtxtZipKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jtxtZipKeyReleased
        String PATTERN = "[0-9][0-9][0-9][0-9][0-9]";
        Pattern patt = Pattern.compile(PATTERN);
        Matcher match = patt.matcher(jtxtZip.getText());
        if(!match.matches()){
        jLabel8.setText("Only 5 digit Zip ");
               
        }
        else{
            jLabel8.setText("");
        }
    }//GEN-LAST:event_jtxtZipKeyReleased

    private void jtxtDocNameKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jtxtDocNameKeyReleased
        char c = evt.getKeyChar();
     if (Character.isDigit(c)){
         jtxtDocName.setEditable(false);
         
         jLabel13.setText("Invalid Doctor Name!");
     }
     else
     {
     jLabel13.setText( null);
     jtxtDocName.setEditable(true);
     }  
    }//GEN-LAST:event_jtxtDocNameKeyReleased

    private void jtxtHospNameKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jtxtHospNameKeyReleased
  char c = evt.getKeyChar();
     if (Character.isDigit(c)){
         jtxtHospName.setEditable(false);
         
         jLabel10.setText("Invalid Hospital Name!");
     }
     else
     {
     jLabel10.setText( null);
     jtxtHospName.setEditable(true);
     }        // TODO add your handling code here:
    }//GEN-LAST:event_jtxtHospNameKeyReleased

    private void jtxtSpecialKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jtxtSpecialKeyReleased
  char c = evt.getKeyChar();
     if (Character.isDigit(c)){
         jtxtSpecial.setEditable(false);
         
         jLabel11.setText("Invalid Speciality!");
     }
     else
     {
     jLabel11.setText( null);
     jtxtSpecial.setEditable(true);
     }        // TODO add your handling code here:
    }//GEN-LAST:event_jtxtSpecialKeyReleased

    private void jtxtCityKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jtxtCityKeyReleased
char c = evt.getKeyChar();
     if (Character.isDigit(c)){
         jtxtCity.setEditable(false);
         
         jLabel14.setText("Invalid City!");
     }
     else
     {
     jLabel14.setText( null);
     jtxtCity.setEditable(true);
     }         // TODO add your handling code here:
    }//GEN-LAST:event_jtxtCityKeyReleased

    private void jtxtCommunityKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jtxtCommunityKeyReleased
char c = evt.getKeyChar();
     if (Character.isDigit(c)){
         jtxtCommunity.setEditable(false);
         
         jLabel12.setText("Invalid Community!");
     }
     else
     {
     jLabel12.setText( null);
     jtxtCommunity.setEditable(true);
     }         // TODO add your handling code here:
    }//GEN-LAST:event_jtxtCommunityKeyReleased

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
            java.util.logging.Logger.getLogger(CommunityAdmin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(CommunityAdmin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(CommunityAdmin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(CommunityAdmin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new CommunityAdmin().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton JExit;
    private javax.swing.JButton JLoad;
    private javax.swing.JButton jDel;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JButton jLog;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JButton jRes;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable2;
    private javax.swing.JButton jUpd;
    private javax.swing.JTextField jtxtCity;
    private javax.swing.JTextField jtxtCommunity;
    private javax.swing.JTextField jtxtDocName;
    private javax.swing.JTextField jtxtHospName;
    private javax.swing.JTextField jtxtSpecial;
    private javax.swing.JTextField jtxtZip;
    // End of variables declaration//GEN-END:variables

    private void clearField() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    
}
