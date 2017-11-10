
import java.awt.Color;
import java.awt.Component;
import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.TableCellRenderer;

class tableRenderer implements TableCellRenderer {

  
      
  public static final DefaultTableCellRenderer DEFAULT_RENDERER = new DefaultTableCellRenderer();

  @Override
  public Component getTableCellRendererComponent(JTable table, Object value,
      boolean isSelected, boolean hasFocus, int row, int column) {
    Component renderer = DEFAULT_RENDERER.getTableCellRendererComponent(
        table, value, isSelected, hasFocus, row, column);
    ((JLabel) renderer).setOpaque(true);
    
    
    
    echipamentTableModel model = (echipamentTableModel) table.getModel();
   
    echipament e = (echipament) model.lista.get(row);
    
    renderer.setBackground(e.backColor);  
    
    if (isSelected)
        renderer.setBackground(new Color(0x7AA3CC));
   
    if (column == 0)
       ((JLabel) renderer).setHorizontalAlignment(JLabel.LEFT);
    else
        ((JLabel) renderer).setHorizontalAlignment(JLabel.CENTER);
    
    
    
   
    return renderer;
  }

 
} 