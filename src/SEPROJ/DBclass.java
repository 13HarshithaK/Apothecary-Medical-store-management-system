package SEPROJ;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.table.DefaultTableModel;
/* @author Harshitha */
public class DBclass {
    Statement s;
    public DBclass()
    {
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
    
    public void DispInv(DefaultTableModel model, javax.swing.JTable jTable1)
    {             
            model.setRowCount(0);
            try {
            jTable1.getColumnModel().getColumn(0).setHeaderValue("Sr. No.");
            jTable1.getColumnModel().getColumn(1).setHeaderValue("Item name");
            jTable1.getColumnModel().getColumn(2).setHeaderValue("Quantity");
            jTable1.getColumnModel().getColumn(3).setHeaderValue("Price");
               
            s.execute("SELECT * FROM INVENTORY");
            ResultSet rs = s.getResultSet();
            int i = 0; 
           while (rs.next()) {
              int a=i+1;
            String srno= Integer.toString(a);
            String name = rs.getString("ITEM"); 
            String quant = rs.getString("QUANTITY");
            String price = rs.getString("PRICE");
            Object[] row = { srno , name, quant, price,};
            model.addRow(row);
            i++;}
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    public void delInv(String namedel)
    {
        String namedel2=namedel.toLowerCase();
        try {
            s.execute("DELETE FROM INVENTORY WHERE ITEM = '"+namedel2+"'");
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }
    
    public void addInv(String name, String quant, String price, javax.swing.JLabel errordisp)
    {

        String name2=name.toLowerCase();
        try {
            s.execute("INSERT INTO INVENTORY VALUES ('"+ name2+ "'," + quant+ ","+price+")");
        } catch (SQLException ex) {
            ex.printStackTrace();
            errordisp.setText("INVALID INPUT HINT: Enter numbers for QUANTITY and PRICE field");
            
        }
    }

    public void updateInv(String[] ItemName, int[] ItemAmt)
    {
        int n=ItemName.length;
        for(int i=0;i<n;i++)
        {
            int cnt=ItemAmt[i];
            String ck=ItemName[i].toLowerCase();
            try {
                s.execute("UPDATE INVENTORY SET QUANTITY = QUANTITY-" +cnt + " WHERE ITEM = '"+ck+"'");
            }
             catch(SQLException ex) {
                ex.printStackTrace();
        }
        }
   
    }

    public void DispLog(DefaultTableModel model, javax.swing.JTable jTable1)
    {             
            model.setRowCount(0);
            try {
            jTable1.getColumnModel().getColumn(0).setHeaderValue("Sr. No.");
            jTable1.getColumnModel().getColumn(1).setHeaderValue("Item name");
            jTable1.getColumnModel().getColumn(2).setHeaderValue("Quantity");
            jTable1.getColumnModel().getColumn(3).setHeaderValue("Price");
               
            s.execute("SELECT * FROM PURCHASELOG");
            ResultSet rs = s.getResultSet();
            int i = 0; 
           while (rs.next()) {
              int a=i+1;
            String srno= Integer.toString(a);
            String name = rs.getString("ITEM"); 
            String quant = rs.getString("QUANTITY");
            String price = rs.getString("PRICE");
            Object[] row = { srno , name, quant, price,};
            model.addRow(row);
            i++;}
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    public void delLog(String namedel)
    {
        String namedel2=namedel.toLowerCase();
        try {
            s.execute("DELETE FROM PURCHASELOG WHERE ITEM = '"+namedel2+"'");
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    public void addLog(String name, String quant, String price, javax.swing.JLabel errordisp)
    {

        String name2=name.toLowerCase();
        try {
            s.execute("INSERT INTO PURCHASELOG VALUES ('"+ name2+ "'," + quant+ ","+price+")");
        } catch (SQLException ex) {
            ex.printStackTrace();
            errordisp.setText("INVALID INPUT HINT: Enter numbers for QUANTITY and PRICE field");
            
        }
    }
    
    public void updateLog(String[] ItemName, int[] ItemAmt, int[] ItemTp)
    {
        int n=ItemName.length;
        for(int i=0;i<n;i++)
        {
            int cnt=ItemAmt[i];
            int tp=ItemTp[i];
            String ck=ItemName[i].toLowerCase();
            try {
                s.execute("INSERT INTO PURCHASELOG VALUES ('" +ck + "', " +cnt+ ", "+tp+")");
            }
             catch(SQLException ex) {
                ex.printStackTrace();
        }
        }
   
    }    
    
    public void DispCust(DefaultTableModel model, javax.swing.JTable jTable1)
    {
        model.setRowCount(0);
     try {
            jTable1.getColumnModel().getColumn(0).setHeaderValue("Sr. No.");
            jTable1.getColumnModel().getColumn(1).setHeaderValue("Name");
            jTable1.getColumnModel().getColumn(2).setHeaderValue("Points");
            jTable1.getColumnModel().getColumn(3).setHeaderValue("Contact");
               
            s.execute("SELECT * FROM CUSTOMER");
            ResultSet rs = s.getResultSet();
            int i = 0; 
           while (rs.next()) {
              int a=i+1;
            String srno= Integer.toString(a);
            String name = rs.getString("NAME"); 
            String quant = rs.getString("POINTS"); 
            String id = rs.getString("CONTACT");
            Object[] row = { srno , name, quant, id};
            model.addRow(row);
            i++;}
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }
    
    public void delCust(String namedel, javax.swing.JLabel errordisp)
    {
        try {
            s.execute("DELETE FROM CUSTOMER WHERE NAME = '"+namedel+"'");
        } catch (SQLException ex) {
            ex.printStackTrace();
            errordisp.setText("Doesnt Exist");
        }
    }
    
    public void addCust(String name, String cont, javax.swing.JLabel errordisp)
    {
        int a=0;
        String points=Integer.toString(a);
        try {
            s.execute("INSERT INTO CUSTOMER VALUES ('"+ name+ "'," + points+ ","+cont+")");
        } catch (SQLException ex) {
            ex.printStackTrace();
            errordisp.setText("INVALID INPUT HINT: Enter numbers for CONTACT field");
        }
    }
    
    public void DispEmp(DefaultTableModel model, javax.swing.JTable jTable1)
    {
       model.setRowCount(0);
        try {
            jTable1.getColumnModel().getColumn(0).setHeaderValue("Sr. No.");
            jTable1.getColumnModel().getColumn(1).setHeaderValue("Name");
            jTable1.getColumnModel().getColumn(2).setHeaderValue("User ID");
            jTable1.getColumnModel().getColumn(3).setHeaderValue("Password");

            s.execute("SELECT * FROM EMPLOYEE");
            ResultSet rs = s.getResultSet();
            int i = 0;
            while (rs.next()) {
                int a=i+1;
                String srno= Integer.toString(a);
                String name = rs.getString("NAME");
                String quant = rs.getString("USERID");
                String price = rs.getString("PASSWORD");
                Object[] row = { srno , name, quant, price,};
                model.addRow(row);
                i++;}
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }
    
    public void delEmp(String namedel)
    {
        try {
            s.execute("DELETE FROM EMPLOYEE WHERE NAME = '"+namedel+"'");
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }
    
    public void addEmp(String name, String user, String pass)
    {
        try {
            s.execute("INSERT INTO EMPLOYEE VALUES ('"+ name+ "', '" + user+ "' , '"+pass+"')");
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }
    
    public void DispMang(DefaultTableModel model, javax.swing.JTable jTable1)
    {
        model.setRowCount(0);
        try {
            jTable1.getColumnModel().getColumn(0).setHeaderValue("Sr. No.");
            jTable1.getColumnModel().getColumn(1).setHeaderValue("Name");
            jTable1.getColumnModel().getColumn(2).setHeaderValue("User ID");
            jTable1.getColumnModel().getColumn(3).setHeaderValue("Password");
               
            s.execute("SELECT * FROM MANAGER");
            ResultSet rs = s.getResultSet();
            int i = 0; 
           while (rs.next()) {
              int a=i+1;
            String srno= Integer.toString(a);
            String name = rs.getString("NAME"); 
            String quant = rs.getString("USERNAME");
            String price = rs.getString("PASSWORD");
            Object[] row = { srno , name, quant, price,};
            model.addRow(row);
            i++;}
        } catch (SQLException ex) {
            ex.printStackTrace();
        }    
    }
    
    public void delMang(String namedel)
    {
        try {
            s.execute("DELETE FROM MANAGER WHERE NAME = '"+namedel+"'");
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }
    
    public void addMang(String name, String user, String pass)
    {
        try {
            s.execute("INSERT INTO MANAGER VALUES ('"+ name+ "', '" + user+ "', '"+pass+"')");
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }
    
    public void DispSup(DefaultTableModel model, javax.swing.JTable jTable1)
    {
        model.setRowCount(0);
        try {
            jTable1.getColumnModel().getColumn(0).setHeaderValue("Sr. No.");
            jTable1.getColumnModel().getColumn(1).setHeaderValue("Name");
            jTable1.getColumnModel().getColumn(2).setHeaderValue("Wares");
            jTable1.getColumnModel().getColumn(3).setHeaderValue("COntact");
               
            s.execute("SELECT * FROM SUPPLIER");
            ResultSet rs = s.getResultSet();
            int i = 0; 
           while (rs.next()) {
              int a=i+1;
            String srno= Integer.toString(a);
            String name = rs.getString("NAME"); 
            String quant = rs.getString("WARES");
            String price = rs.getString("CONTACT");
            Object[] row = { srno , name, quant, price,};
            model.addRow(row);
            i++;}
        } catch (SQLException ex) {
            ex.printStackTrace();
        }        
    }
    
    public void delSup(String namedel)
    {
        try {
            s.execute("DELETE FROM SUPPLIER WHERE NAME = '"+namedel+"'");
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }
    
    public void addSup(String name, String wares, String cont, javax.swing.JLabel errordisp)
    {
        try {
            s.execute("INSERT INTO SUPPLIER VALUES ('"+ name+ "', '" + wares+ "' ,"+cont+")");
        } catch (SQLException ex) {
            ex.printStackTrace();
            errordisp.setText("INVALID INPUT HINT: Enter numbers for CONTACT fields");

        }
    }

    public String[] srchItem(String nameitem,javax.swing.JLabel stat)
    {
        String nameitem2=nameitem.toLowerCase();
        String b= new String();
        String[] row=new String[3];
        try{
            s.execute("SELECT * FROM INVENTORY WHERE ITEM = '"+nameitem2+"'");
            ResultSet rs = s.getResultSet();
            if(rs.next())
            {
                String name = rs.getString("ITEM"); 
                String quant = rs.getString("QUANTITY");
                String price = rs.getString("PRICE");
                row[0] =name;
                row[1] =quant;
                row[2] =price;
                stat.setText("Available");
            }
            else
            {
                b="Not Found";
                row[0] =b;
                row[1] =b;
                row[2] =b;
                stat.setText("Unavailable");
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
            stat.setText("Something went wrong, check input");
        }
        return row;
    }
    

}