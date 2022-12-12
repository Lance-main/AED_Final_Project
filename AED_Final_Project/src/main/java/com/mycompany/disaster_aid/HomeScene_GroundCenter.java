/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.disaster_aid;

import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Vector;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.JTextField;


import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @rushi
 */
public class HomeScene_GroundCenter extends JPanel implements Scenes{
     static AppStateManager AppState_M;

    private AppWindow root;
    private String user_name;
    AppStateManager aps;
    HomeScene_GroundCenter(AppWindow root,AppStateManager aps)
    {
          this.root=root;
          this.aps=aps;

            user_name = aps.SessionUser_;
          this.setLayout(new FlowLayout(FlowLayout.LEADING,50,50));

          ArrayList<Component> ComponentList = new ArrayList();
          ArrayList<Component> Content = new ArrayList();

          ArrayList<Component> ComponentList2 = new ArrayList();
          Content.add(addjlabel("Name: "+user_name,35,Color.WHITE));
          Content.add(addjlabel("Logistics Size : "+aps.Db.getTotalUser(aps.Db.GroundCenter),35,Color.WHITE));
         

          ComponentList2.add(addjlabel("Welcome to Donation Aid "+user_name,50,new Color(0xdfa12)));
          ComponentList2.add(addjpanel(new Color(0xaaca),FlowLayout.LEFT,50,50,450,500,Content));

          
          
          ComponentList.add(addButton("Home",300,60,Config.selectColor));
          ComponentList.add(addButton("Logistics",300,60,new Color(0xcfa62),TrackOrder(aps.Db.GroundCenter)));
          ComponentList.add(addButton("Log Out",300,60,new Color(0xcfa62),logout(aps)));
          
          this.setBackground(Config.bgColor);
          this.add(addjpanel(new Color(0xaaca),FlowLayout.CENTER,100,50,350,900,ComponentList));

          this.add(addjpanel(Config.bgColor,FlowLayout.CENTER,50,150,1500,900,ComponentList2));

    }

    @Override
    public void switchScene(int a)
    {
         root.appManager.SwitchState(a);
    }
    
    @Override
    public void init(AppStateManager aps)
    {
         root.setContentPane(new HomeScene_GroundCenter(root,aps));
         update(root);
    }
    
      public ActionListener TrackOrder(String db)
    {
      return (new ActionListener()
                {
                    public void actionPerformed(ActionEvent e)
                    {
                    
                        root.setContentPane(   new TrackItems_ground(root,aps,aps.Db.GroundCenter));
                        
                    }
                }
            );
            
    }
      public ActionListener SendData()
    {
        return (new ActionListener()
                {
                    public void actionPerformed(ActionEvent e)
                    {
                    
                        root.setContentPane(   new SendItems(root,aps));
                        
                    }
                }
            );
    }
}




