import java.awt.Color;
import java.util.ArrayList;
import javax.swing.table.AbstractTableModel;

public class echipamentTableModel extends AbstractTableModel {
    public ArrayList lista = new ArrayList(); //diamond operator
   
    Color backStyle;
     
    @Override
    public int getRowCount() {
            return lista.size();
           }
    @Override
    public int getColumnCount() {
        return 12; // nr de coloane
    }

     public Object getElementAt(int pos) {
        return lista.get(pos);
    }
    
    
    @Override
    public String getColumnName(int col) {
          switch(col){
              case 0 : return "Device name";
              case 1 : return "County";
              case 2 : return "Tip";    
              case 3 : return "IP address";    
              case 4 : return "Status";    
              case 5 : return "LastChange";        
              case 6 : return "LastCheck";     
              case 7 : return "Parent";    
              case 8 : return "Clients";     
              case 9 : return "VIP clients";  
              case 10 : return "Monitor";  
              case 11 : return "Details";  
                  
          };
        return null;  
    }
     
    @Override
    public Object getValueAt(int row, int col) { // celulele din matrice, de fapt.
       echipament e = (echipament)lista.get(row);

        switch(col){
            case 0: return e.getName(); // 
            case 1: return e.getJudet(); // 
            case 2: return e.getType();
            case 3: return e.getIpAddress();
            case 4: return e.getStatus();
            case 5: return e.getLastChange();
            case 6: return e.getLastCheck();
            case 7: return e.getParinte();
            case 8: return e.getAbonati();
            case 9: return e.getClienti();
            case 10: return e.getMonitor();
            case 11: return e.getDetails();
            
        }
        return null;

    }
    
    
    
}
