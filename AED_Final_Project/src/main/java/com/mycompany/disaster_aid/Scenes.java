/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.mycompany.disaster_aid;

import javax.swing.JButton;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Color;
import java.awt.Component;
import java.util.ArrayList;
import java.awt.Font;
import java.awt.event.ActionListener;
import javax.swing.JLabel;
import javax.swing.JPasswordField;
/**
 *
 * @author 
 */
public interface Scenes {
    
      default void update(JFrame f)
    {
        f.revalidate();
        f.repaint();
            
    }
    default JButton addButton(String txt,int width,int height,Color color)
    {
        
        JButton jb = new JButton();
       

        jb.setFont(new Font("Arial",Font.PLAIN,25));
        jb.setText(txt);
        jb.setPreferredSize(new Dimension(width,height));
        jb.setFocusable(false);
        jb.setOpaque(true);
        jb.setBackground(color);

        return jb;
    }
    default JButton addButton(String txt,int width,int height,Color color,ActionListener Listener)
    {
        
        JButton jb = new JButton();
       
        jb.addActionListener(Listener);
        jb.setFont(new Font("Arial",Font.PLAIN,25));
        jb.setText(txt);
        jb.setPreferredSize(new Dimension(width,height));
        jb.setFocusable(false);
        jb.setOpaque(true);
        jb.setBackground(color);

        return jb;
    }
    default JTextField addTxtfield(int width,int height)
    {
        JTextField tf = new JTextField();
        tf.setPreferredSize(new Dimension(width,height));
        tf.setFont(new Font("Arial",Font.PLAIN,25));

        tf.setHorizontalAlignment(JTextField.CENTER);
        return tf;
    }
     default JPasswordField addPassfield(int width,int height)
    {
        JPasswordField pf = new JPasswordField();
        pf.setPreferredSize(new Dimension(width,height));
        pf.setFont(new Font("Arial",Font.PLAIN,25));

        pf.setHorizontalAlignment(JTextField.CENTER);
        return pf;
    }
    default JPanel addjpanel(Color color,int align,int vgap,int hgap,int width,int height,ArrayList<Component> componentList)
    {
        JPanel jp = new JPanel(new FlowLayout(align,hgap,vgap));
        jp.setBackground(color);
        
        for(Component c : componentList)
        {
                jp.add(c);

        }
        jp.setPreferredSize(new Dimension(width,height));
        return jp;
    }
    default JLabel addjlabel(String txt,int fontSize,Color fgColor)
    {
        JLabel lb = new JLabel();
        lb.setText(txt);
        lb.setFont(new Font("Arial",Font.BOLD,fontSize));
        lb.setForeground(fgColor);
          lb.setOpaque(true);
        
        return lb;
    }
    void switchScene(int a);
    void init();
}
