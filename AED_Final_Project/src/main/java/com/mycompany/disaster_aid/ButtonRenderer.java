/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.disaster_aid;
import javax.swing.JButton;
import javax.swing.table.*;
import javax.swing.*;
import java.awt.*;
/**
 *
 * @lance
 */
public class ButtonRenderer extends JButton implements  TableCellRenderer{
     //CONSTRUCTOR
    public ButtonRenderer() {
        //SET BUTTON PROPERTIES
        setOpaque(true);
        setBorderPainted(true);
        setFont(new Font("Arial", Font.PLAIN, 25));

        setBackground(Color.decode("#BDE0FE"));
    }
    @Override
    public Component getTableCellRendererComponent(JTable table, Object obj,
                                                   boolean selected, boolean focused, int row, int col) {

        //SET PASSED OBJECT AS BUTTON TEXT
        setText((obj==null) ? "":obj.toString());

        return this;
    }

}
