/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package procesossjf;

import java.awt.Color;
import java.awt.Component;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;

/**
 *
 * @author jgale
 */
public class TableRender extends DefaultTableCellRenderer {

    @Override
    public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
        super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);
        if (value == "p") {
            this.setOpaque(true);
            this.setBackground(Color.blue);
            this.setForeground(Color.white);
        } else if (value == "e") {
            this.setOpaque(true);
            this.setBackground(Color.orange);
            this.setForeground(Color.black);
        } else if (value == "b") {
            this.setOpaque(true);
            this.setBackground(Color.red);
            this.setForeground(Color.white);
        } else {
            this.setOpaque(false);
            this.setBackground(Color.white);
            this.setForeground(Color.black);
        }

        return this;
    }
}
