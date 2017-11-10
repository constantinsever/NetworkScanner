import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.InputStream;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.Timer;
import javax.swing.table.JTableHeader;
import sun.audio.AudioPlayer;
import sun.audio.AudioStream;

public class mainWindow extends javax.swing.JFrame {
    private static String theLabel;
    
    
    List listaEchipamente = new ArrayList();
    public static echipamentTableModel model = new echipamentTableModel();
    tableRenderer tr = new tableRenderer();
       
    String Criteria="";
    
    static boolean soundEnabled = false;
    static boolean scanEnabled = false;
    static boolean threadsStarted = false;
    
    int index;
       
    public static dbAccess database = new dbAccess();
    
    scanner[] romania = new scanner[4];
       
         
    Timer timer = new Timer(5000, new  ActionListener() { //timer 5 secunde
       @Override
        public void actionPerformed(ActionEvent e) {
             readTable();
        };        
      });
      
  
    public mainWindow() {
        
        initComponents();
        setBounds(200, 200, 1100, 520);
        
        Toolkit toolkit = Toolkit.getDefaultToolkit();
        Dimension screenSize = toolkit.getScreenSize();
        int iWidth = (screenSize.width - this.getWidth()) / 2;
        int iHeight = (screenSize.height - this.getHeight()) / 2;
        setLocation(iWidth, iHeight);
    
        timer.start();
        
                
       romania[0] = new scanner("CT");
       romania[1] = new scanner("TM");
       romania[2] = new scanner("BR");
       romania[3] = new scanner("HD");
       
       JTableHeader header = jTable1.getTableHeader();
       header.setFont( new Font( "Arial" , Font.BOLD, 12 ) );
       
       mnuDetails.addActionListener(new ActionListener() {
          public void actionPerformed(ActionEvent e) {
                showDetails();
            }
       });
       
       mnuAckAlarm.addActionListener(new ActionListener() {
          public void actionPerformed(ActionEvent e) {
                ackAlarm(true);
            }
       });
       
       mnuDeackAlarm.addActionListener(new ActionListener() {
          public void actionPerformed(ActionEvent e) {
                ackAlarm(false);
            }
       });
       
       
      
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel5 = new javax.swing.JLabel();
        jButton2 = new javax.swing.JButton();
        jToggleButton2 = new javax.swing.JToggleButton();
        jButton3 = new javax.swing.JButton();
        jPopupMenu1 = new javax.swing.JPopupMenu();
        mnuDetails = new javax.swing.JMenuItem();
        jSeparator1 = new javax.swing.JPopupMenu.Separator();
        mnuAckAlarm = new javax.swing.JMenuItem();
        mnuDeackAlarm = new javax.swing.JMenuItem();
        mnuTakeOwnership = new javax.swing.JMenuItem();
        jSeparator2 = new javax.swing.JPopupMenu.Separator();
        jMenuItem1 = new javax.swing.JMenuItem();
        jMenuItem2 = new javax.swing.JMenuItem();
        jMenuItem4 = new javax.swing.JMenuItem();
        jMenuItem5 = new javax.swing.JMenuItem();
        jMenuItem6 = new javax.swing.JMenuItem();
        jMenuItem7 = new javax.swing.JMenuItem();
        jMenuItem8 = new javax.swing.JMenuItem();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jLabel2 = new javax.swing.JLabel();
        btnAll = new javax.swing.JButton();
        btnUP = new javax.swing.JButton();
        btnRecovering = new javax.swing.JButton();
        btnDown = new javax.swing.JButton();
        jToolBar1 = new javax.swing.JToolBar();
        btnConnect = new javax.swing.JButton();
        btnEnableScan = new javax.swing.JButton();
        btnRefresh = new javax.swing.JButton();
        btnEnableSound = new javax.swing.JButton();

        jLabel5.setText("jLabel5");

        jButton2.setText("jButton2");

        jToggleButton2.setText("jToggleButton2");

        jButton3.setText("jButton3");

        jPopupMenu1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jPopupMenu1MouseClicked(evt);
            }
        });

        mnuDetails.setText("Details");
        jPopupMenu1.add(mnuDetails);
        jPopupMenu1.add(jSeparator1);

        mnuAckAlarm.setText("Acknowledge");
        jPopupMenu1.add(mnuAckAlarm);

        mnuDeackAlarm.setText("Deacknowledge");
        jPopupMenu1.add(mnuDeackAlarm);

        mnuTakeOwnership.setText("Take ownership");
        jPopupMenu1.add(mnuTakeOwnership);
        jPopupMenu1.add(jSeparator2);

        jMenuItem1.setText("Check NOW");
        jPopupMenu1.add(jMenuItem1);

        jMenuItem2.setText("Connect to Hermes unit");
        jPopupMenu1.add(jMenuItem2);

        jMenuItem4.setText("Group assign");
        jPopupMenu1.add(jMenuItem4);

        jMenuItem5.setText("User assign");
        jPopupMenu1.add(jMenuItem5);

        jMenuItem6.setText("Prioritize");
        jPopupMenu1.add(jMenuItem6);

        jMenuItem7.setText("Show parent");
        jPopupMenu1.add(jMenuItem7);

        jMenuItem8.setText("Show children");
        jPopupMenu1.add(jMenuItem8);

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Ericsson Network Scanner");

        jTable1.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Device name", "County", "IP address", "Status", "Last change", "Last check", "Parent", "Clients", "VIP clients", "Monitor", "Details"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.Integer.class, java.lang.Integer.class, java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false, false, false, true
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jTable1.setRowHeight(22);
        jTable1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTable1MouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jTable1);

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/eLogo.png"))); // NOI18N
        jLabel2.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jLabel2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel2MouseClicked(evt);
            }
        });

        btnAll.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        btnAll.setText("All");
        btnAll.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAllActionPerformed(evt);
            }
        });

        btnUP.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        btnUP.setForeground(new java.awt.Color(0, 102, 0));
        btnUP.setText("UP");
        btnUP.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnUPActionPerformed(evt);
            }
        });

        btnRecovering.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        btnRecovering.setForeground(new java.awt.Color(153, 153, 0));
        btnRecovering.setText("Recovering");
        btnRecovering.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRecoveringActionPerformed(evt);
            }
        });

        btnDown.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        btnDown.setForeground(new java.awt.Color(204, 0, 0));
        btnDown.setText("Down");
        btnDown.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDownActionPerformed(evt);
            }
        });

        jToolBar1.setBorder(null);
        jToolBar1.setFloatable(false);
        jToolBar1.setRollover(true);
        jToolBar1.setMaximumSize(new java.awt.Dimension(360, 35));
        jToolBar1.setMinimumSize(new java.awt.Dimension(360, 35));
        jToolBar1.setPreferredSize(new java.awt.Dimension(100, 35));

        btnConnect.setText("Connect");
        btnConnect.setFocusable(false);
        btnConnect.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnConnect.setMaximumSize(new java.awt.Dimension(100, 25));
        btnConnect.setMinimumSize(new java.awt.Dimension(100, 25));
        btnConnect.setPreferredSize(new java.awt.Dimension(100, 25));
        btnConnect.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnConnect.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnConnectMouseClicked(evt);
            }
        });
        btnConnect.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnConnectActionPerformed(evt);
            }
        });
        jToolBar1.add(btnConnect);

        btnEnableScan.setText("Enable Scan");
        btnEnableScan.setToolTipText("Start scanning");
        btnEnableScan.setEnabled(false);
        btnEnableScan.setMaximumSize(new java.awt.Dimension(100, 25));
        btnEnableScan.setMinimumSize(new java.awt.Dimension(100, 25));
        btnEnableScan.setPreferredSize(new java.awt.Dimension(100, 25));
        btnEnableScan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEnableScanActionPerformed(evt);
            }
        });
        jToolBar1.add(btnEnableScan);

        btnRefresh.setText("Refresh now");
        btnRefresh.setToolTipText("Refresh now");
        btnRefresh.setEnabled(false);
        btnRefresh.setMaximumSize(new java.awt.Dimension(100, 25));
        btnRefresh.setMinimumSize(new java.awt.Dimension(100, 25));
        btnRefresh.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRefreshActionPerformed(evt);
            }
        });
        jToolBar1.add(btnRefresh);

        btnEnableSound.setText("Enable sound");
        btnEnableSound.setToolTipText("Enable sound alert");
        btnEnableSound.setMaximumSize(new java.awt.Dimension(100, 25));
        btnEnableSound.setMinimumSize(new java.awt.Dimension(100, 25));
        btnEnableSound.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEnableSoundActionPerformed(evt);
            }
        });
        jToolBar1.add(btnEnableSound);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jToolBar1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(btnUP, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(18, 18, 18)
                        .addComponent(btnRecovering, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnDown, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(10, 10, 10)
                        .addComponent(btnAll, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel2))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 1189, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jToolBar1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 439, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btnUP)
                            .addComponent(btnRecovering)
                            .addComponent(btnDown)
                            .addComponent(btnAll))
                        .addGap(6, 6, 6))))
        );

        layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {btnAll, btnDown, btnRecovering, btnUP});

        pack();
    }// </editor-fold>//GEN-END:initComponents

    
   
    
    private void readTable(){
      
       if (!database.connected){
           return;
         }
        
        
        String query = "select * from netscan";
        
        if (Criteria.equals("")){
          query = query + " order by judet;"; 
         }
        else{
         query = query + " where " + Criteria +" order by judet;";
         }
        
           
        jTable1.setDefaultRenderer(Object.class, tr); 
        model.lista.clear(); 
        model.fireTableDataChanged();
        

        ResultSet rs = database.getRecords(query);
        
        try {
                while (rs.next()){
                  String nume = rs.getString("deviceName");
                   echipament e = new echipament(nume);
                  String judet = rs.getString("judet");
                   e.setJudet(judet);
                   
                  String tip = rs.getString("tip");
                   e.setType(tip);
                  String ipAddress = rs.getString("ipAddress");
                   e.setIpAddress(ipAddress);
                  String status = rs.getString("status");
                   e.setStatus(status);
                  String parinte = rs.getString("parinte");
                   e.setParinte(parinte);
                  String lastChange = rs.getString("lastChange");
                   e.setLastChange(lastChange);
                  String lastCheck = rs.getString("lastCheck");
                   e.setLastCheck(lastCheck);
                  String abonati = rs.getString("abonati");
                   e.setAbonati(abonati);
                  String clienti = rs.getString("clienti");
                   e.setClienti(clienti);
                  String monitor = rs.getString("monitor");
                   e.setMonitor(monitor);
                  String details = rs.getString("details");
                   e.setDetails(details);
                   
                  if (status.equals("DOWN")) 
                   if (monitor.isEmpty()) // nu s-a ack't
                      playSound();
                   
                  
                  if (status.equals("DOWN"))
                   e.setBackColor(Color.RED);
                  if (status.equals("RECOVERING"))
                   e.setBackColor(Color.YELLOW);
                  if (status.equals("UP"))
                   e.setBackColor(new Color (0x01DF3A));
                                    
                  model.lista.add(e);
                  model.fireTableDataChanged();
                  jTable1.setModel(model); 
                 
                }
                
            } //try
           catch (Exception e){
             System.out.println(e);
             JOptionPane.showConfirmDialog(null,"Eroare citire inregistrari : " + e);
           }      
             
    }
    
    
    private void jLabel2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel2MouseClicked
        JOptionPane.showMessageDialog(this,"NetScan 2014.\nConstantin Sever for Ericsson.",
                "About", JOptionPane.INFORMATION_MESSAGE);
        
    }//GEN-LAST:event_jLabel2MouseClicked

    private void btnUPActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUPActionPerformed
        playSound();
        Criteria = "status='UP'";
        readTable();
    }//GEN-LAST:event_btnUPActionPerformed

    private void btnRecoveringActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRecoveringActionPerformed
        Criteria = "status='RECOVERING'";
        readTable();
    }//GEN-LAST:event_btnRecoveringActionPerformed

    private void btnDownActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDownActionPerformed
        Criteria = "status='DOWN'";
        readTable();
    }//GEN-LAST:event_btnDownActionPerformed

    private void btnAllActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAllActionPerformed
        Criteria ="";
        readTable();

    }//GEN-LAST:event_btnAllActionPerformed

    
    private void showDetails(){
        String s, severity="MINOR";
        
        int i = jTable1.getSelectedRow();
        if (i < 0)
            return;
            
                    echipament e = (echipament) model.lista.get(i);
                    if (e.getDetails() == null){
                       s = e.getName() + " is " + e.getStatus() +" \n";
                       s = s + "IP address : " + e.getIpAddress()+" \n";
                       s = s + "Parent : " + e.getParinte() + " \n";
                       s = s + "Clients : " + e.getAbonati() + " \n";
                       s = s + "VIP clients : " + e.getClienti() + " \n";
                       s = s + "Last change : " + e.getLastChange()+ " \n";
                       if (e.getStatus().equals("DOWN"))
                       {
                        if (Integer.parseInt(e.getClienti()) < 1000) 
                           severity = "MINOR";
                        if ( (Integer.parseInt(e.getClienti()) > 1000) && (Integer.parseInt(e.getClienti()) < 3000))
                             severity = "MEDIU";
                        if (Integer.parseInt(e.getClienti()) > 3000)
                           severity = "MAJOR";
                         s = s + "Recommended severity : " + severity+ " \n";
                       };
                       
                     }
                    else
                        s = e.getDetails();
                    
                    detailsDialog dg = new detailsDialog(this, true,i);
                    dg.setTxtDetails(s);
                    dg.setVisible(true);
                    
    }
    
    private void ackAlarm(boolean status){
        
        
        int i = jTable1.getSelectedRow();
        
        if (i < 0)
            return;
        
        String monitor;
        
        echipament e = (echipament) model.lista.get(i);
        if (status)
             monitor="sever.constantin";
        else
            monitor="";
        e.setMonitor(monitor);
        database.runUpdate("update netscan set monitor='"+e.getMonitor()+"' where deviceName='"+e.getName()+"';");
        model.fireTableDataChanged();
        
    }
    
    
    private void btnEnableScanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEnableScanActionPerformed
        
        
        if (!database.connected)
        {
            JOptionPane.showMessageDialog(this,"Not connected to topology server. Please connect first. ");
            return;
        }
        scanEnabled = !scanEnabled;
        if(scanEnabled)
           {
            if (threadsStarted) // daca au fost deja pornite, dar sunt disabled
             {  
              for (index = 0; index < romania.length; index ++)
                   romania[index].enable(true);
              btnEnableScan.setText("Disable scan");
              }
            else // sunt nepornite, s-a apasat enable prima data
            {
                for (index = 0; index < romania.length; index ++)
               {
                 romania[index].start();
                 romania[index].enable(true);
               } 
             btnEnableScan.setText("Disable scan");
             threadsStarted = true;
             }
          }
       
        else
          {
           for (index = 0; index < romania.length; index ++)
              romania[index].enable(false);
           btnEnableScan.setText("Enable scan");
          };   
    }//GEN-LAST:event_btnEnableScanActionPerformed

    private void btnEnableSoundActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEnableSoundActionPerformed
        soundEnabled = !soundEnabled;
        
        if (soundEnabled)
            btnEnableSound.setText("Disable sound");
        else
            btnEnableSound.setText("Enable sound");
        
    }//GEN-LAST:event_btnEnableSoundActionPerformed

    private void btnRefreshActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRefreshActionPerformed
          readTable();
    }//GEN-LAST:event_btnRefreshActionPerformed

    private void jTable1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable1MouseClicked
        
        
        
          if (evt.getClickCount() == 2)
                {
                 showDetails();
                    
                }
        
        if (evt.getButton() == java.awt.event.MouseEvent.BUTTON3) {
          
        int r = jTable1.rowAtPoint(evt.getPoint());
         if (r >= 0 && r < jTable1.getRowCount()) {
            jTable1.setRowSelectionInterval(r, r);
        } else {
            jTable1.clearSelection();
        }

         
        int rowindex = jTable1.getSelectedRow();
        
        if (rowindex < 0)
            return;
            jPopupMenu1.show(evt.getComponent(), evt.getX(), evt.getY());
        }
            
    }//GEN-LAST:event_jTable1MouseClicked

    private void btnConnectMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnConnectMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_btnConnectMouseClicked

    private void btnConnectActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnConnectActionPerformed
        if (!database.connected){
            database.connect();
            if (!database.connected)
            JOptionPane.showMessageDialog(this,"Could not connect to topology server. ");
            btnConnect.setText("Disconnect");
            btnEnableScan.setEnabled(true);
            btnRefresh.setEnabled(true);
         }
        else
         {
            database.disconnect();
            btnConnect.setText("Connect");
            btnEnableScan.setEnabled(false);
            btnRefresh.setEnabled(false);
         }           // TODO add your handling code
    }//GEN-LAST:event_btnConnectActionPerformed

    private void jPopupMenu1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPopupMenu1MouseClicked
       
        
    }//GEN-LAST:event_jPopupMenu1MouseClicked

    
    
    
    public void playSound(){
    
    if (!soundEnabled)
        return;         
    try
     {
        InputStream inputStream = getClass().getResourceAsStream("alarm.au");
        AudioStream audioStream = new AudioStream(inputStream);     
        
        AudioPlayer.player.start(audioStream);
      }
      catch (Exception e)
      {
       JOptionPane.showMessageDialog(this,"Nu se poate reda audio !");
      } 
    }    
    
    
    public static void main(String args[]) {
              
       mainWindow mw = new mainWindow();
       mw.setVisible(true);
       
   }

 
    
    





    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAll;
    private javax.swing.JButton btnConnect;
    private javax.swing.JButton btnDown;
    private javax.swing.JButton btnEnableScan;
    private javax.swing.JButton btnEnableSound;
    private javax.swing.JButton btnRecovering;
    private javax.swing.JButton btnRefresh;
    private javax.swing.JButton btnUP;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JMenuItem jMenuItem2;
    private javax.swing.JMenuItem jMenuItem4;
    private javax.swing.JMenuItem jMenuItem5;
    private javax.swing.JMenuItem jMenuItem6;
    private javax.swing.JMenuItem jMenuItem7;
    private javax.swing.JMenuItem jMenuItem8;
    private javax.swing.JPopupMenu jPopupMenu1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JPopupMenu.Separator jSeparator1;
    private javax.swing.JPopupMenu.Separator jSeparator2;
    private javax.swing.JTable jTable1;
    private javax.swing.JToggleButton jToggleButton2;
    private javax.swing.JToolBar jToolBar1;
    private javax.swing.JMenuItem mnuAckAlarm;
    private javax.swing.JMenuItem mnuDeackAlarm;
    private javax.swing.JMenuItem mnuDetails;
    private javax.swing.JMenuItem mnuTakeOwnership;
    // End of variables declaration//GEN-END:variables
}
