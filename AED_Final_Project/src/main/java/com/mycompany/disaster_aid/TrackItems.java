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
import javax.swing.JTextField;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JLabel;

/**
 *
 * @author rushi
 */
public class TrackItems extends JPanel implements Scenes{
             private AppWindow root;
    JTextField tfitemName ;
    JTextField tfQty ;
    String ItemName ;
    int itemQty;
    private String user_name;
    
    TrackItems(AppWindow root,AppStateManager aps)
    {
        this.root=root;       

        JTextArea jl = new JTextArea();
        user_name = aps.SessionUser_;
        jl.append("\n\n");

        for (int i = 0; i < aps.Db.getTotalHistory(user_name); i++) {
               jl.append("\t | \t");
               jl.append( aps.Db.GetDataString(0,user_name,"DonationType"));
               jl.append("\t | \t");
               jl.append( aps.Db.GetDataString(0,user_name,"Qty"));
               jl.append("\t | \n");
        }
        

        this.setBackground(Config.bgColor);
        JScrollPane jtp = addScrlPane(Color.red,500,500, jl);

        ArrayList<Component> ComponentList = new ArrayList();
        ComponentList.add(jtp);
        ComponentList.add(addButton("Go Back",300,60,new Color(0xcfa62),GoBack()));
        this.add(addjpanel(new Color(0xaaca),FlowLayout.CENTER,50,50,650,650,ComponentList));
        init(aps);

    }
      public ActionListener GoBack()
    {
        return (new ActionListener()
                {
                    public void actionPerformed(ActionEvent e)
                    {
                      
                         switchScene(Config.Home_Scene_User);
                        
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
         root.setContentPane(this);
         update(root);
    }
}
