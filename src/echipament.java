
import java.awt.Color;



public class echipament {
     String name, judet, type, ipAddress, status, lastChange, lastCheck, parinte, abonati, clienti, monitor, details;
     Color backColor;
  
    public String getDetails() {
        return details;
    }
  
      
     public echipament(String aName){
         name = aName;
     }
     
     public String getName(){
        return name;    
    }

    public String getJudet() {
        return judet;
    }

    public String getType() {
        return type;
    }

    public String getIpAddress() {
        return ipAddress;
    }
    
    public void setName(String s){
        name = s;
    }

    public void setDetails(String details) {
        this.details = details;
    }

    public void setJudet(String judet) {
        this.judet = judet;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getLastChange() {
        return lastChange;
    }

    public void setLastChange(String lastChange) {
        this.lastChange = lastChange;
    }

    public String getLastCheck() {
        return lastCheck;
    }

    public void setLastCheck(String lastCheck) {
        this.lastCheck = lastCheck;
    }

    public String getParinte() {
        return parinte;
    }

    public void setParinte(String parinte) {
        this.parinte = parinte;
    }

    public String getAbonati() {
        return abonati;
    }

    public void setAbonati(String abonati) {
        this.abonati = abonati;
    }

    public String getClienti() {
        return clienti;
    }

    public void setClienti(String clienti) {
        this.clienti = clienti;
    }

    public String getMonitor() {
        return monitor;
    }

    public void setMonitor(String monitor) {
        this.monitor = monitor;
    }

    public void setIpAddress(String ipAddress) {
        this.ipAddress = ipAddress;
    }
    
    public void setStatus(String s){
        status = s;
    }

  
     
     public String getStatus(){
        return status;    
    }
  
     
    public Color getBackColor(int row) {
        return backColor;
    }

    public void setBackColor(Color  backStyle) {
        this.backColor = backStyle;
        
    }

     
    
    
}

