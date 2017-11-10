
import java.io.IOException;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.sql.ResultSet;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.TimeZone;

public class scanner extends Thread {
private String judet, query;
private boolean  enabled;
ResultSet resultSet = null;
Statement st = null;

 public boolean isEnabled() {
        return enabled;
    }
 public void enable(boolean stopNow) {
    this.enabled = stopNow;
     if (!enabled)
         System.out.println("Thread "+judet+" stopped !");
     else
         System.out.println("Thread "+judet+" enabled !");
    }
 public ResultSet getResultSet() {
        return resultSet;
    }
 
 
 public void setResultSet(ResultSet recordSet) {
        this.resultSet = recordSet;
    }

scanner(String s){
    judet = s;
    enabled = false;
    System.out.println("Thread " + judet + " initiated");
}


@Override
public void run() {
  
     while (true) // se va testa si in bucla, pentru oprire imediata.
         scan();
   }
    

static boolean isOnline(String hostName){
  try {
       InetAddress address = InetAddress.getByName(hostName);
        return address.isReachable(2000);
     }
     catch (UnknownHostException e) {
        System.err.println("Unable to lookup <"+hostName+"> .");
     }
     catch (IOException e) {
        System.err.println("Unable to reach  <"+hostName+"> .");
     }
   return false;
};  
   


public void scan(){
     String q;
       
     if (!enabled) // oprire inainte de bucla
       return;
                   
          
     ResultSet resultSet = mainWindow.database.getRecords("select deviceName, ipAddress, status from netscan where judet='" + judet + "';");
     
     
     
      try {
                while (resultSet.next()){
                    
                   if (!enabled) // oprire imediata , daca deja este in bucla
                       return;
                   String deviceName = resultSet.getString("deviceName");
                   String ipAddress = resultSet.getString("ipAddress");
                   String oldStatus = resultSet.getString("status");
                   
                    System.out.println("-Scanning host " + deviceName);
                    
                       SimpleDateFormat sdfDate = new SimpleDateFormat("HH:mm:ss dd/MM/yyyy");//dd/MM/yyyy
                       sdfDate.setTimeZone(TimeZone.getTimeZone("GMT+2"));
                       java.util.Date now = new java.util.Date();
                       String strDate = sdfDate.format(now);
                        
                       if (!isOnline(ipAddress))
                         {
                          if (oldStatus.equals("UP"))
                           {
                              q = "update netscan set status='DOWN', lastCheck='"+strDate+"', lastChange='"+strDate+"' where deviceName='"+deviceName+"';";
                              st = mainWindow.database.connection.createStatement();
                              st.executeUpdate(q);
                              
                            }
                          else // era deja down
                           {
                            q = "update netscan set status='DOWN', lastCheck='"+strDate+"' where ipAddress='"+ipAddress+"';";
                             st = mainWindow.database.connection.createStatement();
                             st.executeUpdate(q);
                           
                           }
                          
                         }
                       else  // raspunde la ping
                         {
                          if (oldStatus.equals("DOWN")) // erau down si s-au ridicat
                           {    
                            q = "update netscan set status='RECOVERING', lastCheck='"+strDate+"', lastChange='"+strDate+"' where deviceName='"+deviceName+"'; ";
                            st = mainWindow.database.connection.createStatement();
                            st.executeUpdate(q);
                          } 
                          else // era deja UP sau RECOVERING
                          {
                           q = "update netscan set status='UP', lastCheck='"+strDate+"' where deviceName='"+deviceName+"'; ";
                           st = mainWindow.database.connection.createStatement();
                           st.executeUpdate(q);
                           }
                         }
                } //while
              } //try
           catch (Exception e){
             System.out.println(e);
           }
                  
         
    }

}
