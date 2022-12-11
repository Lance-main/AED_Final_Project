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
import javax.swing.JFrame;
import javax.swing.JPanel;

/**
 *
 * @author 
 */
public class Register extends JPanel implements Scenes{
    private AppWindow root;
    Register(AppWindow root)
    {
        this.root=root;
        this.setLayout(new FlowLayout(FlowLayout.LEADING,20,80));
        
        ArrayList<Component> ComponentList = new ArrayList();
        ArrayList<Component> ComponentList2 = new ArrayList();
       
        ComponentList.add(addTxtfield(450,60));
        ComponentList.add(addTxtfield(450,60));
        ComponentList.add(addTxtfield(450,60));
        ComponentList.add(addTxtfield(450,60));
        ComponentList.add(addTxtfield(450,60));
        

        ComponentList.add(addButton("Register",300,60,new Color(0x8BF0C9)));
        
        ComponentList2.add(addButton("Login",300,60,new Color(0x8BB2F0),gotoLogin()));
        ComponentList2.add(addButton("Register",300,60,new Color(0xF0978B)));

        this.add(addjpanel(new Color(0x13818F),FlowLayout.CENTER,100,20,350,500,ComponentList2));

        this.add(addjpanel(new Color(0x0B4850),FlowLayout.CENTER,20,20,650,500,ComponentList));

        this.setBackground(new Color(0x179FB0));
        
    }
     public ActionListener gotoLogin()
    {
        return (new ActionListener()
                {
                    public void actionPerformed(ActionEvent e)
                        {
                            switchScene(Config.LoginState);
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
    public void init()
    {
         root.setContentPane(this);
         update(root);

    }
}
