/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package OfficerModule.Attendece;

// import necessary packages

import OfficerModule.Attendece.UpdateAttendence;
import OfficerModule.JTableToPDF;
import OfficerModule.Officer;
import OfficerModule.TableManagement;
import com.toedter.calendar.JDateChooser;
import common.code.MyDbConnector;
import java.awt.Image;
import java.io.FileOutputStream;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.Timer;
import javax.swing.table.DefaultTableModel;
import javax.swing.text.Document;

/**
 *
 * @author user
 */
public class ViewAttendence extends javax.swing.JFrame implements TableManagement{
    
    PreparedStatement pst1 = null;
    public ResultSet rs;
    
    private MyDbConnector dbConnector; 
    Connection connection = null;
    private Officer officerAcc;
 
    public ViewAttendence(Officer officerAcc) {
        initComponents();
        this.officerAcc = officerAcc;
        dbConnector = new MyDbConnector();
        connection = dbConnector.getMyConnection();
    }

    private ViewAttendence() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        txt_copy2 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        jPanel4 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        AttendViewTable = new javax.swing.JTable();
        jPanel3 = new javax.swing.JPanel();
        FileName = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jButton3 = new javax.swing.JButton();
        jPanel6 = new javax.swing.JPanel();
        jLabel13 = new javax.swing.JLabel();
        S_id = new javax.swing.JTextField();
        jLabel14 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        jButton5 = new javax.swing.JButton();
        jButton7 = new javax.swing.JButton();
        Course_Id1 = new javax.swing.JComboBox<>();
        jPanel7 = new javax.swing.JPanel();
        jLabel8 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        dept = new javax.swing.JComboBox<>();
        Jdate = new com.toedter.calendar.JDateChooser();
        jLabel12 = new javax.swing.JLabel();
        Course_Id = new javax.swing.JComboBox<>();
        jLabel9 = new javax.swing.JLabel();
        Status = new javax.swing.JComboBox<>();
        jButton2 = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMinimumSize(new java.awt.Dimension(1260, 820));
        setResizable(false);
        setType(java.awt.Window.Type.POPUP);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(104, 164, 236));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        txt_copy2.setBackground(new java.awt.Color(255, 255, 255));
        txt_copy2.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        txt_copy2.setForeground(new java.awt.Color(255, 255, 255));
        txt_copy2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        txt_copy2.setText("© Faculty of Technology,University of Ruhuna.");
        jPanel1.add(txt_copy2, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 100, -1, -1));

        jLabel10.setFont(new java.awt.Font("MS UI Gothic", 1, 24)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(255, 255, 255));
        jLabel10.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel10.setText(" ATTENDENCE VIEW PORTAL");
        jLabel10.setFocusable(false);
        jLabel10.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
        jLabel10.setInheritsPopupMenu(false);
        jLabel10.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jPanel1.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(490, 60, 330, 30));

        jLabel16.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/backbtn.png"))); // NOI18N
        jLabel16.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel16MouseClicked(evt);
            }
        });
        jPanel1.add(jLabel16, new org.netbeans.lib.awtextra.AbsoluteConstraints(1190, 20, 50, 40));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1250, 150));

        jPanel4.setForeground(new java.awt.Color(204, 204, 204));
        jPanel4.setMinimumSize(new java.awt.Dimension(1070, 420));
        jPanel4.setPreferredSize(new java.awt.Dimension(1070, 420));
        jPanel4.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        AttendViewTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "Student_Id", "Department", "course ID", "Date", "Student count with percentage"
            }
        ));
        jScrollPane1.setViewportView(AttendViewTable);
        if (AttendViewTable.getColumnModel().getColumnCount() > 0) {
            AttendViewTable.getColumnModel().getColumn(1).setPreferredWidth(30);
            AttendViewTable.getColumnModel().getColumn(2).setPreferredWidth(100);
            AttendViewTable.getColumnModel().getColumn(3).setPreferredWidth(40);
            AttendViewTable.getColumnModel().getColumn(4).setPreferredWidth(50);
        }

        jPanel4.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 290, 860, 120));

        jPanel3.setBackground(new java.awt.Color(204, 204, 204));
        jPanel3.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        jPanel3.add(FileName, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 10, 260, -1));

        jLabel1.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel1.setText("File Name");
        jPanel3.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 10, -1, -1));

        jButton3.setBackground(new java.awt.Color(255, 102, 0));
        jButton3.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jButton3.setForeground(new java.awt.Color(255, 255, 255));
        jButton3.setText("Generate PDF");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });
        jPanel3.add(jButton3, new org.netbeans.lib.awtextra.AbsoluteConstraints(650, 0, 210, 50));

        jPanel4.add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 430, 860, 50));

        jPanel6.setBorder(javax.swing.BorderFactory.createTitledBorder("Individual "));
        jPanel6.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel13.setFont(new java.awt.Font("Arial Black", 3, 14)); // NOI18N
        jPanel6.add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 60, 130, -1));

        S_id.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                S_idActionPerformed(evt);
            }
        });
        jPanel6.add(S_id, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 30, 150, -1));

        jLabel14.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel14.setText("Student_Id");
        jPanel6.add(jLabel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 30, 100, -1));

        jLabel15.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel15.setText("Course _ ID");
        jPanel6.add(jLabel15, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 70, 100, -1));

        jButton5.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jButton5.setText("View");
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });
        jPanel6.add(jButton5, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 200, 150, -1));

        jButton7.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jButton7.setText("Reset");
        jButton7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton7ActionPerformed(evt);
            }
        });
        jPanel6.add(jButton7, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 200, 150, -1));

        Course_Id1.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        Course_Id1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Select", "ICT01", "ICT02", "ICT03", "ICT04", "ICT05", "TMS01", " " }));
        Course_Id1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Course_Id1ActionPerformed(evt);
            }
        });
        jPanel6.add(Course_Id1, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 70, 150, 20));

        jPanel4.add(jPanel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 30, 370, 240));

        jPanel7.setBorder(javax.swing.BorderFactory.createTitledBorder("Department wise"));
        jPanel7.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel8.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel8.setText("Department");
        jPanel7.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 30, 100, -1));

        jLabel11.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel11.setText("Date");
        jPanel7.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 70, 50, -1));

        dept.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        dept.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Select", "ict", "bst", "et", "All" }));
        jPanel7.add(dept, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 30, 150, 20));
        jPanel7.add(Jdate, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 70, 150, -1));

        jLabel12.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel12.setText("Course _ ID");
        jPanel7.add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 110, 100, -1));

        Course_Id.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        Course_Id.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Select", "ICT01", "ICT02", "ICT03", "ICT04", "ICT05", "TMS01", " " }));
        jPanel7.add(Course_Id, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 110, 150, 20));

        jLabel9.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel9.setText("Status");
        jPanel7.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 150, 100, -1));

        Status.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        Status.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Select", "Absent", "Present" }));
        jPanel7.add(Status, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 150, 150, -1));

        jButton2.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jButton2.setText("Reset");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        jPanel7.add(jButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 200, 150, -1));

        jButton1.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jButton1.setText("View");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        jPanel7.add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 200, 150, -1));

        jPanel4.add(jPanel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(660, 30, 410, 240));

        getContentPane().add(jPanel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 150, 1250, 530));

        setSize(new java.awt.Dimension(1266, 689));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jLabel16MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel16MouseClicked
        officerAcc.back(officerAcc);
        this.dispose();
    }//GEN-LAST:event_jLabel16MouseClicked
public void ViewData(){
    String dep = (String) dept.getSelectedItem();
    String C_id = (String) Course_Id.getSelectedItem();
    String stetus = (String) Status.getSelectedItem();
    java.util.Date selectedDate = Jdate.getDate();
    SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
    String dateString = dateFormat.format(selectedDate);
  
    String sql = "SELECT userID, Department, CourseID, Date, Status " +
             "FROM attendance " +
             "WHERE Department = ? AND CourseID = ? AND Date = ? AND Status = ?";

    try (PreparedStatement pst = connection.prepareStatement(sql)) {
         pst.setString(1, dep);
         pst.setString(2, C_id);
         pst.setString(3, dateString);
         pst.setString(4, stetus);

         ResultSet rs = pst.executeQuery();

        DefaultTableModel model = (DefaultTableModel) AttendViewTable.getModel();
        model.setColumnIdentifiers(new String[]{"StudentID", "Department", "CourseID", "Date", "Status"});
        model.setRowCount(0);

        if (!rs.isBeforeFirst()) {
    // No attendance data found for the given conditions
            JOptionPane.showMessageDialog(null, "No attendance data found for the specified conditions.");
    } else {
        while (rs.next()) {
        String studentID = rs.getString("userID");
        String department = rs.getString("Department");
        String courseID = rs.getString("CourseID");
        String date = rs.getString("Date");
        String status = rs.getString("Status");

        String[] rowData = {studentID, department, courseID, date, status};
        model.addRow(rowData);
    }
} 
}catch (SQLException ex) {
    ex.printStackTrace();
}

}

 @Override
    public void Reset(){
        S_id.setText("");
        Course_Id1.setSelectedItem("Select");       
        dept.setSelectedItem("Select");
        Status.setSelectedItem("Select");
        Course_Id.setSelectedItem("Select");
        Jdate.setDate(null);
        DefaultTableModel model1  = (DefaultTableModel) AttendViewTable.getModel();
        model1.setRowCount(0);
}
    
    @Override
    public void ShowTable() {
      String studentID = S_id.getText(); 
      String courseID = (String) Course_Id1.getSelectedItem(); 

      String sql = "SELECT userID, CourseID, Department, COUNT(Status) AS AttendCount, " +
             "SUM(CASE WHEN Status = 'Absent' THEN 1 ELSE 0 END) AS AbsentCount " +
             "FROM attendance " +
             "WHERE userID = ? AND CourseID = ? " +
             "GROUP BY userID, CourseID, Department";

      try (PreparedStatement pst = connection.prepareStatement(sql)) {
             pst.setString(1, studentID);
             pst.setString(2, courseID);

             ResultSet rs = pst.executeQuery();

            DefaultTableModel model = (DefaultTableModel) AttendViewTable.getModel();
            model.setRowCount(0);

            if (!rs.isBeforeFirst()) {
        // No attendance data found for the given student and course
                  JOptionPane.showMessageDialog(null, "No attendance data found for the student and course.");
            } else {
                while (rs.next()) {
                      String userID = rs.getString("userID");
                      String department = rs.getString("Department");
                      String courseIDs = rs.getString("CourseID");
                      int attendCount = rs.getInt("AttendCount");
                      int absentCount = rs.getInt("AbsentCount");
                      double attendancePercentage = ((attendCount - absentCount) * 100.0) / attendCount;

                     String tbData[] = {userID, courseIDs, department, String.valueOf(attendCount), String.format("%.2f", attendancePercentage)};
       
                     model.setColumnIdentifiers(new String[]{"StudentId","CourseId", "Department",  "AttendCount", "AttendancePercentage"});
                     model.setRowCount(0);
                     model.addRow(tbData);
                }
            }
        } catch (SQLException ex) {
             ex.printStackTrace();
     }
}
    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        ViewData();
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        Reset();        
    }//GEN-LAST:event_jButton2ActionPerformed

    private void Course_Id1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Course_Id1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_Course_Id1ActionPerformed

    private void jButton7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton7ActionPerformed
        Reset();
    }//GEN-LAST:event_jButton7ActionPerformed
    
    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
      ShowTable();

    }//GEN-LAST:event_jButton5ActionPerformed

    private void S_idActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_S_idActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_S_idActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed

        JTable table = AttendViewTable;
        String filename = FileName.getText();
        String filenameWithExtension = filename + ".pdf";
        JTableToPDF.convert(table, filenameWithExtension);
    }//GEN-LAST:event_jButton3ActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        
        
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ViewAttendence().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTable AttendViewTable;
    private javax.swing.JComboBox<String> Course_Id;
    private javax.swing.JComboBox<String> Course_Id1;
    private javax.swing.JTextField FileName;
    private com.toedter.calendar.JDateChooser Jdate;
    private javax.swing.JTextField S_id;
    private javax.swing.JComboBox<String> Status;
    private javax.swing.JComboBox<String> dept;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton5;
    private javax.swing.JButton jButton7;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel txt_copy2;
    // End of variables declaration//GEN-END:variables

    private void date(java.util.Date date) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void Insert() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void SetValue() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void Referance() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

   

    @Override
    public void Update() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
}
