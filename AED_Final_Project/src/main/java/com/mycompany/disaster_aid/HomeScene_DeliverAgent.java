/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.disaster_aid;

import java.awt.Color;
import java.awt.Component;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.JPanel;

/**
 *
 * @author EpiCon
 */
public class HomeScene_DeliverAgent extends JPanel implements Scenes{
     private AppWindow root;
    private String user_name;
    AppStateManager aps;
    HomeScene_DeliverAgent(AppWindow root,AppStateManager aps)
    {
         this.root=root;
          this.aps=aps;

            user_name = aps.SessionUser_;
          this.setLayout(new FlowLayout(FlowLayout.LEADING,100,100));

          ArrayList<Component> ComponentList = new ArrayList();
          ArrayList<Component> Content = new ArrayList();

          ArrayList<Component> ComponentList2 = new ArrayList();
          Content.add(addjlabel("Name: "+user_name,35,Color.WHITE));
          Content.add(addjlabel("Logistics Size : "+aps.Db.getTotalUser(aps.Db.Hub),35,Color.WHITE));
         

          ComponentList2.add(addjlabel("Welcome to Donation Aid "+user_name,50,new Color(0xdfa12)));
          ComponentList2.add(addjpanel(new Color(0xaaca),FlowLayout.LEFT,50,50,450,500,Content));

          
          
          ComponentList.add(addButton("Home",300,60,Config.selectColor));
          ComponentList.add(addButton("Logistics",300,60,new Color(0xcfa62),TrackOrder(aps.Db.Hub)));
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
         root.setContentPane(new HomeScene_DeliverAgent(root,aps));
         update(root);
    }
       public ActionListener TrackOrder(String db)
    {
      return (new ActionListener()
                {
                    public void actionPerformed(ActionEvent e)
                    {
                    
                        root.setContentPane(   new TrackItemsHub(root,aps));
                        
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
