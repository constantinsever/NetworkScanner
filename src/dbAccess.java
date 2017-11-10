import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;


public class dbAccess {
    boolean connected;
    boolean enabled;
    
    Statement statement=null;
    Connection connection=null;
    ResultSet resultset = null;

    
    public boolean isConnected() {
        return connected;
    }

    
   
    
 public void connect(){
       
       try {
         Class.forName("com.mysql.jdbc.Driver").newInstance();
         connection = DriverManager.getConnection("jdbc:mysql://188.226.191.28:3306/hermes", "hermes","hermes");
         
         statement = connection.createStatement();
        }
        catch (Exception e){
            System.out.println(e);
            JOptionPane.showConfirmDialog(null,"Eroare conectare  : " + e);
            return;
        } 
       connected = true;
  } 
    
 public void disconnect(){
     
        try {
            if (connection != null)
                connection.close();
            if (statement != null)
                statement.close();
            if (resultset != null)
                resultset.close();
            connected = false;
        } catch (SQLException ex) {
            Logger.getLogger(dbAccess.class.getName()).log(Level.SEVERE, null, ex);
        }
  } 
    
    
 public ResultSet getRecords(String query){
     if (! connected)
         return null;
     ResultSet rs;
    
    try {
         Statement st = connection.createStatement();
         rs = st.executeQuery(query);
    
    
         } catch (SQLException ex) {
            Logger.getLogger(dbAccess.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("Eroare getRecords : " + ex);
            return null;
        }
    
    return rs;
    
 };
    
   
 public void runUpdate(String s){
     
     if (! connected)
         return ;
    try {
         Statement st = connection.createStatement();
         st.executeUpdate(s);

        } catch (SQLException ex) {
            Logger.getLogger(dbAccess.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("Eroare runQuery: " + ex);
            
        }
 }
    
}

