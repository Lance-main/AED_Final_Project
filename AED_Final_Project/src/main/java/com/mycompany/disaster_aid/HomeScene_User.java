/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.disaster_aid;

import java.awt.Color;
import java.awt.Component;
import java.util.ArrayList;
import javax.swing.JPanel;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 *
 * @author 
 */
public class HomeScene_User extends JPanel implements Scenes{
    
    static AppStateManager AppState_M;

    private AppWindow root;
    private String user_name;
    AppStateManager aps;
    HomeScene_User(AppWindow root,AppStateManager aps)
    {
         this.setLayout(new FlowLayout(FlowLayout.LEADING,20,70));
        ArrayList<Component> Content = new ArrayList();

          this.root=root;
         user_name = aps.SessionUser_;
         this.aps=aps;
          ArrayList<Component> ComponentList = new ArrayList();
          ArrayList<Component> ComponentList2 = new ArrayList();
          Content.add(addjlabel("Name: "+user_name,35,Color.WHITE));
          Content.add(addjlabel("Total Donation: "+aps.Db.getTotalHistory(user_name),35,Color.WHITE));
         

          ComponentList2.add(addjlabel("Welcome to Donation Aid "+user_name,50,new Color(0xdfa12)));
          ComponentList2.add(addjpanel(new Color(0xaaca),FlowLayout.LEFT,50,50,450,500,Content));

          
          
          this.setLayout(new FlowLayout(FlowLayout.LEADING,20,70));
          ComponentList.add(addButton("Home",300,60,Config.selectColor));
          ComponentList.add(addButton("Send Donation",300,60,new Color(0xcfa62),SendData()));
          ComponentList.add(addButton("Track Order",300,60,new Color(0xcfa62),TrackOrder(aps.Db.userData)));
          ComponentList.add(addButton("Log Out",300,60,new Color(0xcfa62),logout(aps)));
          
          this.setBackground(Config.bgColor);
          this.add(addjpanel(new Color(0xaaca),FlowLayout.CENTER,100,50,350,900,ComponentList));

          this.add(addjpanel(new Color(0xaaca),FlowLayout.CENTER,50,150,1500,900,ComponentList2));

    }
   
     public ActionListener TrackOrder(String db)
    {
      return (new ActionListener()
                {
                    public void actionPerformed(ActionEvent e)
                    {
                    
                        root.setContentPane(   new TrackItems(root,aps,db));
                        
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
    @Override
    public void switchScene(int a)
    {
         root.appManager.SwitchState(a);
    }
    
    @Override
    public void init(AppStateManager aps)
    {
         root.setContentPane(new HomeScene_User(root,aps));
         update(root);
      
    }
}


