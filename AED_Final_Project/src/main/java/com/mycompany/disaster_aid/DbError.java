/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.disaster_aid;

import java.awt.Color;
import java.awt.FlowLayout;
import javax.swing.JPanel;

/**
 *
 * @author EpiCon
 */
public class DbError extends JPanel implements Scenes {
    AppWindow root;

    DbError(AppWindow root)
    {
         this.root=root;
         this.setLayout(new FlowLayout(FlowLayout.CENTER,50,300));
         
         this.add(addjlabel("Connection With Database Failed",50,new Color(0xBA2B19)));
         this.setBackground(new Color(0x8BE4F0));

    }
    
    @Override
    public void switchScene(int a)
    {
        root.appManager.SwitchState(a);
        
    }
    
    @Override
    public void init()
    {
         root.setContentPane(this);
         update(root);

    }
}


