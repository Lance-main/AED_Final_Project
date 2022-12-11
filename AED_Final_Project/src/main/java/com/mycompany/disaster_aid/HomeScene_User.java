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
 * @Ojasvi
 */
public class HomeScene_User extends JPanel implements Scenes{
    
    static AppStateManager AppState_M;

    private AppWindow root;
    private String user_name;
    AppStateManager aps;
    HomeScene_User(AppWindow root,AppStateManager aps)
    {
          this.root=root;
         user_name = aps.SessionUser_;
         this.aps=aps;
          ArrayList<Component> ComponentList = new ArrayList();
          ComponentList.add(addjlabel("Welcome User "+user_name,40,new Color(0xdfa12)));
          ComponentList.add(addButton("Send Order",300,60,new Color(0xcfa62),SendData()));
          ComponentList.add(addButton("Track Order",300,60,new Color(0xcfa62),TrackOrder()));
          ComponentList.add(addButton("Log Out",300,60,new Color(0xcfa62),logout()));

          this.setBackground(Config.bgColor);
          this.add(addjpanel(new Color(0xaaca),FlowLayout.CENTER,50,50,650,650,ComponentList));
    }
    public ActionListener logout()
    {
     return (new ActionListener()
                {
                    public void actionPerformed(ActionEvent e)
                    {
                            System.out.println("LogOut");
                            aps.SessionUser_=null;    
                            switchScene(Config.LoginState);
                    }
                }
            );
    }
    public ActionListener TrackOrder()
    {
      return (new ActionListener()
                {
                    public void actionPerformed(ActionEvent e)
                    {
                    
                        root.setContentPane(   new TrackItems(root,aps));
                        
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
