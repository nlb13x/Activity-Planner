/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projectevent;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author sonu
 */
public class Volunteer extends javax.swing.JFrame {
   
    /**
     * Creates new form Volunteer
     */
    public Volunteer() {
        initComponents();  
        addRow();
        addRow1();
    }
  
  
   
    public void genCode(String user, String pass){
        
      
            jLabel1.setText(user);
            initComponents();
            addRow();
            addRow1();
        
    }

    private String getUser() {
        try {
            String u = null;
            Connection con=DatabaseConnection.getConn();
            Statement st=con.createStatement();
            ResultSet rs=st.executeQuery("SELECT * FROM eventmanagement.temp;");
            if(rs.next()){
                u=rs.getString(1);
            }
            return u;
        } catch (Exception ex) {
            Logger.getLogger(Volunteer.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }
    
        public class Events  implements java.io.Serializable {


     public int idevents;
     public String eventname;
     public String eventcreatedon;
     public String lastdateofregistraion;
     public String eventwillbeon;
     public String eventdescription;
     public String eventvenue;

    public Events() {
    }

    public Events(int idevents, String eventname, String eventcreatedon, String lastdateofregistraion, String eventwillbeon, String eventdescription, String eventvenue) {
       this.idevents = idevents;
       this.eventname = eventname;
       this.eventcreatedon = eventcreatedon;
       this.lastdateofregistraion = lastdateofregistraion;
       this.eventwillbeon = eventwillbeon;
       this.eventdescription = eventdescription;
       this.eventvenue = eventvenue;
    }
    
}
    
    public  ArrayList<Events> getAll(){
         ArrayList<Events> events=new ArrayList<>();
        try {
            Connection con=DatabaseConnection.getConn();
            Statement st=con.createStatement();
            ResultSet rs=st.executeQuery("SELECT * FROM eventmanagement.events;");
           Events eve;
            while (rs.next()) {                
                eve=new Events(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getString(6), rs.getString(7));
                events.add(eve);
            }
        
        } catch (SQLException ex) {
            
        }
        return events;
    } 
    public void addRow() {
        DefaultTableModel model=(DefaultTableModel) jTable1.getModel();
        
       List<Events> events=getAll();
        Object rowdata[] =new Object[7];
        for (int i = 0; i < events.size(); i++) {
            rowdata[0]=getAll().get(i).idevents;
            rowdata[1]=getAll().get(i).eventname;
            rowdata[2]=getAll().get(i).eventcreatedon;
            rowdata[3]=getAll().get(i).lastdateofregistraion;
            rowdata[4]=getAll().get(i).eventwillbeon;
            rowdata[5]=getAll().get(i).eventdescription;
            rowdata[6]=getAll().get(i).eventvenue;
            model.addRow(rowdata);
        }   
    }
    
       public class Eventregistration  implements java.io.Serializable {


     public int eventid;
     public int userid;
     public String usermail;


    public Eventregistration(int eventid, int userid, String usermail) {
       this.eventid = eventid;
       this.userid = userid;
       this.usermail = usermail;
    }
 }
 
    public  ArrayList<Eventregistration> getAll1(){
         ArrayList<Eventregistration> eventrt=new ArrayList<>();
        try {
            Connection con=DatabaseConnection.getConn();
            String query="select * from eventmanagement.eventregistration where userid=?;";
            PreparedStatement ps=con.prepareStatement(query);
             String u=getUser();
            ps.setString(1, u);
            ResultSet rs=ps.executeQuery(); 
           Eventregistration ert;
            while (rs.next()) {    
               ert=new Eventregistration(rs.getInt(1), rs.getInt(2), rs.getString(3));
                eventrt.add(ert);
                }
            }        
         catch (SQLException ex) {
            
        }
        return eventrt;
    } 
    
     public void addRow1() {
        DefaultTableModel model=(DefaultTableModel) jTable2.getModel();
        
       List<Eventregistration> eventrt=getAll1();
        Object rowdata[] =new Object[3];
        for (int i = 0; i < eventrt.size(); i++) {
           rowdata[0]=getAll1().get(i).eventid;
           rowdata[1]=getAll1().get(i).userid;
           rowdata[2]=getAll1().get(i).usermail;
            model.addRow(rowdata);
        }   
       
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
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jLabel4 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTable2 = new javax.swing.JTable();
        jLabel5 = new javax.swing.JLabel();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Ubuntu", 0, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(235, 20, 20));
        jLabel1.setText("jlab");

        jLabel2.setFont(new java.awt.Font("Ubuntu", 1, 18)); // NOI18N
        jLabel2.setText("Welcome Volunteer :-");

        jButton1.setFont(new java.awt.Font("Ubuntu", 0, 18)); // NOI18N
        jButton1.setText("Logout");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jLabel3.setFont(new java.awt.Font("Ubuntu", 1, 24)); // NOI18N
        jLabel3.setText("Volunteer Pannel");

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null}
            },
            new String [] {
                "Event Id", "Event Name", "Event Created On", "Last Date of Reg", "Event Date", "Description", "Venue"
            }
        ));
        jScrollPane1.setViewportView(jTable1);

        jLabel4.setFont(new java.awt.Font("Ubuntu", 1, 18)); // NOI18N
        jLabel4.setText("Event Table");

        jTable2.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null}
            },
            new String [] {
                "Event Id", "User Id", "Email"
            }
        ));
        jScrollPane2.setViewportView(jTable2);
        if (jTable2.getColumnModel().getColumnCount() > 0) {
            jTable2.getColumnModel().getColumn(1).setResizable(false);
        }

        jLabel5.setFont(new java.awt.Font("Ubuntu", 1, 18)); // NOI18N
        jLabel5.setText("Events Participated/Participating");

        jButton2.setFont(new java.awt.Font("Ubuntu", 1, 18)); // NOI18N
        jButton2.setText("Register For A Event");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jButton3.setFont(new java.awt.Font("Ubuntu", 2, 18)); // NOI18N
        jButton3.setText("Messages");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(467, 467, 467)
                .addComponent(jLabel3)
                .addContainerGap(425, Short.MAX_VALUE))
            .addComponent(jScrollPane1)
            .addComponent(jScrollPane2)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jLabel5)
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 308, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(183, 183, 183))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jButton3))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel2)
                        .addGap(28, 28, 28)
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 81, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jButton1)))
                .addGap(24, 24, 24))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(jLabel1)
                    .addComponent(jButton1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(jButton3))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 128, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 16, Short.MAX_VALUE)
                .addComponent(jLabel5)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(49, 49, 49))
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

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        try {
            // TODO add your handling code here:
            Connection con=DatabaseConnection.getConn();
            con.prepareStatement("TRUNCATE `eventmanagement`.`temp`;").execute();
            dispose();
            LoginForm form=new LoginForm();
            form.setVisible(true);
        } catch (SQLException ex) {
            Logger.getLogger(Volunteer.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
                String userid = null, pass = null,email=null;
                String eventid=null;
                int eventidint, useridint;
        try {
            // TODO add your handling code here:
            Connection con=DatabaseConnection.getConn();
            Statement st=con.createStatement();
            ResultSet rs=st.executeQuery("SELECT * FROM eventmanagement.temp;");
            if(rs.next()){
                userid=rs.getString(1);
                pass=rs.getString(2);
            }
             String query1="select * from login where id_login=? and password=?";
            PreparedStatement statement1=con.prepareStatement(query1);
            statement1.setString(1, userid);
            statement1.setString(2, pass);
            ResultSet rs1=statement1.executeQuery();
            if(rs1.next()){
                email=rs1.getString(6);
            }
            eventid = JOptionPane.showInputDialog("Input Event Id to register for that event");
            String query2="SELECT * FROM eventmanagement.events where idevents=?;";
            PreparedStatement statement2=con.prepareStatement(query2);
            statement2.setString(1, eventid);
            ResultSet rs2=statement2.executeQuery();
            if(rs2.next()){
                
                 eventidint=Integer.parseInt(eventid);
            useridint=Integer.parseInt(userid);
            String query="INSERT INTO `eventmanagement`.`eventregistration` (`eventid`, `userid`, `usermail`) VALUES ('"+eventidint+"', '"+useridint+"', '"+email+"');";
            Connection conn=DatabaseConnection.getConn();
            Statement stmt=conn.createStatement();
            stmt.executeUpdate(query);
            JOptionPane.showMessageDialog(null, "Registration Successful");
                
            }else{
                 JOptionPane.showMessageDialog(null, "Event Not Exist");
            }
            
        } catch (Exception ex) {
            Logger.getLogger(Volunteer.class.getName()).log(Level.SEVERE, null, ex);
             JOptionPane.showMessageDialog(null, "Try After Some Time");
        }
        
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        // TODO add your handling code here:
        SendMessage msg=new SendMessage();
       msg.setVisible(true);
    }//GEN-LAST:event_jButton3ActionPerformed

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
            java.util.logging.Logger.getLogger(Volunteer.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Volunteer.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Volunteer.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Volunteer.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Volunteer().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable jTable1;
    private javax.swing.JTable jTable2;
    // End of variables declaration//GEN-END:variables
}
