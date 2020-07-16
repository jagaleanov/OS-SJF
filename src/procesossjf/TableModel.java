/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package procesossjf;

import java.util.Vector;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author jgale
 */
public class TableModel extends DefaultTableModel {

    private String[] columnNames = {};

    public TableModel(String[] columnNames) {
        super(columnNames, 0);
        this.columnNames = columnNames;
    }

    @Override
    public Class<?> getColumnClass(int columnIndex) {
        if (getRowCount() > 0 && getValueAt(0, columnIndex) != null) {
            return getValueAt(0, columnIndex).getClass();
        }
        return super.getColumnClass(columnIndex);
    }

    public void setRowsQueue(Node head) {

        if (getRowCount() > 0) {
            for (int i = getRowCount() - 1; i > -1; i--) {
                removeRow(i);
            }
        }
        Node temp = head;

        while (temp != null) {

            Vector<Object> rowVector = new Vector<>();
            rowVector.add(temp.getId());
            rowVector.add(temp.getTimeIn());
            rowVector.add(temp.getRaf());

            super.addRow(rowVector);
            temp = temp.getNext();
        }
    }

    public void setRowsHistory(Node head) {

        if (getRowCount() > 0) {
            for (int i = getRowCount() - 1; i > -1; i--) {
                removeRow(i);
            }
        }
        Node temp = head;

        while (temp != null) {

            Vector<Object> rowVector = new Vector<>();
            rowVector.add(temp.getId());
            rowVector.add(temp.getTimeIn());
            rowVector.add(temp.getRafExecuted());
            rowVector.add(temp.getTimeStart());
            rowVector.add(temp.getTimeEnd());
            rowVector.add(temp.getTimeReturn());
            rowVector.add(temp.getTimeWait());

            super.addRow(rowVector);
            temp = temp.getNext();
        }

    }

    public void setRowsBlock(Node head) {

        if (getRowCount() > 0) {
            for (int i = getRowCount() - 1; i > -1; i--) {
                removeRow(i);
            }
        }
        Node temp = head;

        while (temp != null) {

            Vector<Object> rowVector = new Vector<>();
            rowVector.add(temp.getId());
            rowVector.add(temp.getTimeIn());
            rowVector.add(temp.getRaf());
            rowVector.add(temp.getRafExecuted());

            super.addRow(rowVector);
            temp = temp.getNext();
        }

    }

    public void addRowGantt(Node newNode, int time) {

        Vector<Object> rowVector = new Vector<>();

        rowVector.add(newNode.getId());

        for (int i = 0; i < time; i++) {

            rowVector.add("");
        }
        rowVector.add("e");
        super.addRow(rowVector);
    }

    public void addColumnGantt(Node headQueue, Node headBlock, Node onProcess, int time) {

        Vector<Object> columnVector = new Vector<>();

        for (int i = 0; i < getRowCount(); i++) {

            Node tempQueue = headQueue;
            Node tempBlock = headBlock;
            boolean found = false;

            if (onProcess != null && onProcess.getId() == (int) getValueAt​(i, 0)) {
                columnVector.add("p");
                found = true;
            } else {
                while (tempQueue != null) {
                    if (tempQueue.getId() == (int) getValueAt​(i, 0)) {
                        columnVector.add("e");
                        found = true;
                    }

                    tempQueue = tempQueue.getNext();
                }
                
                while (tempBlock != null) {
                    if (tempBlock.getId() == (int) getValueAt​(i, 0)) {
                        columnVector.add("b");
                        found = true;
                    }

                    tempBlock = tempBlock.getNext();
                }
            }

            if (!found) {
                columnVector.add("");
            }
        }
        super.addColumn(time, columnVector);
    }
}
