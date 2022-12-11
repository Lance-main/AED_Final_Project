/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.disaster_aid;

import java.awt.Color;
import java.awt.Component;
import java.awt.FlowLayout;
import java.util.ArrayList;
import javax.swing.JPanel;

/**
 *
 * @Ojasvi
 */
public class HomeScene_Organization extends JPanel implements Scenes{
         private AppWindow root;
    HomeScene_Organization(AppWindow root)
    {
          this.root=root;
          ArrayList<Component> ComponentList = new ArrayList();
          ComponentList.add(addButton("Send Order",300,60,new Color(0xcfa12)));
          ComponentList.add(addButton("Track Order",300,60,new Color(0xcfa12)));
          ComponentList.add(addButton("Log Out",300,60,new Color(0xcfa12)));

          this.setBackground(Config.bgColor);
          this.add(addjpanel(new Color(0xaaca),FlowLayout.CENTER,50,50,650,650,ComponentList));
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
