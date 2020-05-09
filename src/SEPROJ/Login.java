package SEPROJ;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.ResultSet;
import java.sql.Statement;
/*@author Harshitha */
public class Login extends javax.swing.JFrame {
    Statement s;

    public Login() {
        initComponents();
        String [] type = new String[3];
        type[0]="Employee";
        type[1]="Manager";
        type[2]="Owner";
        cbType.setModel(new javax.swing.DefaultComboBoxModel(type));
        try {
            Class.forName("org.apache.derby.jdbc.EmbeddedDriver");
        } catch (ClassNotFoundException cnfe) {
            System.err.println("Derby driver not found.");
        }
        try {
            Connection conn = DriverManager.getConnection("jdbc:derby://localhost/test;create=true","hello","world");
            s = conn.createStatement();
        } catch(SQLException ex){
            ex.printStackTrace();
           }
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panelbox = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        cbType = new javax.swing.JComboBox<>();
        tvUser = new javax.swing.JTextField();
        brLogin = new javax.swing.JButton();
        errormsg = new javax.swing.JLabel();
        tfPass = new javax.swing.JPasswordField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setAutoRequestFocus(false);
        setBackground(new java.awt.Color(255, 255, 255));
        setResizable(false);

        panelbox.setBackground(new java.awt.Color(204, 153, 255));

        jLabel2.setText("Select Type");

        jLabel1.setText("User Name: ");

        jLabel3.setText("Password: ");

        cbType.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        brLogin.setText("Login");
        brLogin.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                brLoginActionPerformed(evt);
            }
        });

        errormsg.setText(" ");

        javax.swing.GroupLayout panelboxLayout = new javax.swing.GroupLayout(panelbox);
        panelbox.setLayout(panelboxLayout);
        panelboxLayout.setHorizontalGroup(
            panelboxLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelboxLayout.createSequentialGroup()
                .addGap(41, 41, 41)
                .addGroup(panelboxLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, 75, Short.MAX_VALUE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(panelboxLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(errormsg, javax.swing.GroupLayout.DEFAULT_SIZE, 142, Short.MAX_VALUE)
                    .addComponent(brLogin, javax.swing.GroupLayout.DEFAULT_SIZE, 142, Short.MAX_VALUE)
                    .addComponent(cbType, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(tvUser)
                    .addComponent(tfPass))
                .addContainerGap(45, Short.MAX_VALUE))
        );
        panelboxLayout.setVerticalGroup(
            panelboxLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelboxLayout.createSequentialGroup()
                .addGap(68, 68, 68)
                .addGroup(panelboxLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cbType, javax.swing.GroupLayout.DEFAULT_SIZE, 27, Short.MAX_VALUE))
                .addGap(9, 9, 9)
                .addGroup(panelboxLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(tvUser, javax.swing.GroupLayout.DEFAULT_SIZE, 23, Short.MAX_VALUE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(panelboxLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tfPass, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(brLogin)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(errormsg, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addComponent(panelbox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(25, 25, 25))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addComponent(panelbox, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(25, 25, 25))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void brLoginActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_brLoginActionPerformed
        String value1= tvUser.getText();
        String value2= tfPass.getText();
        String value3= cbType.getSelectedItem().toString();
        if(value1.equals("") || value2.equals(""))
          errormsg.setText("INVALID");
        else if(value3.equals("Owner"))
        {
            if (value1.equals("lore") && value2.equals("player") || value1.equals("ravenloss") && value2.equals("soulweaver")) {
                new OwnerPage().setVisible(true); 
                this.dispose();
            }
            else
                errormsg.setText("INVALID");
        }
        
        else if(value3.equals("Employee"))
        {
            try {
            s.execute("SELECT * FROM EMPLOYEE");
            ResultSet rs = s.getResultSet();
            int i = 0; 
           while (rs.next()) {
            String us = rs.getString("USERID"); 
            String ps = rs.getString("PASSWORD");
            if(us.equals(value1) && ps.equals(value2))
            {
                new EmpPage().setVisible(true); 
                this.dispose();            
            }
            i++;}
           errormsg.setText("INVALID");            
        } catch (SQLException ex) {
            ex.printStackTrace();
            }             
        }
        
        else if(value3.equals("Manager"))
        {
            try {
            s.execute("SELECT * FROM MANAGER");
            ResultSet rs = s.getResultSet();
            int i = 0; 
           while (rs.next()) {
            String us = rs.getString("USERNAME"); 
            String ps = rs.getString("PASSWORD");
            if(us.equals(value1) && ps.equals(value2))
            {
                new MangPage().setVisible(true); 
                this.dispose();            
            }
            i++;}
           errormsg.setText("INVALID");            
        } catch (SQLException ex) {
            ex.printStackTrace();
            }
        }
        
        else
            errormsg.setText("INVALID");    
    }//GEN-LAST:event_brLoginActionPerformed

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
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Login().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton brLogin;
    private javax.swing.JComboBox<String> cbType;
    private javax.swing.JLabel errormsg;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel panelbox;
    private javax.swing.JPasswordField tfPass;
    private javax.swing.JTextField tvUser;
    // End of variables declaration//GEN-END:variables
}