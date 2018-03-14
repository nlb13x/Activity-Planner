
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projectevent;

import java.awt.Component;
import javax.swing.JButton;
import javax.swing.JTable;
import javax.swing.table.TableCellRenderer;

/**
 *
 * @author sonu
 */
public class ButtonRendererEvent extends JButton implements  TableCellRenderer {
    
  //CONSTRUCTOR
  public ButtonRendererEvent() {
    //SET BUTTON PROPERTIES
    setOpaque(true);
  }
  @Override
  public Component getTableCellRendererComponent(JTable table, Object obj,
      boolean selected, boolean focused, int row, int col) {
    
    //SET PASSED OBJECT AS BUTTON TEXT
      setText((obj==null) ? "":obj.toString());
        
    return this;
  }
}
