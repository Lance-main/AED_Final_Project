/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.disaster_aid;

import java.awt.Component;
import java.util.ArrayList;
import javax.swing.JPanel;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JTextField;
/**
 *
 * @author 
 */
public class SendItems extends JPanel implements Scenes{
    
          private AppWindow root;
    JTextField tfitemName ;
    JTextField tfQty ;
    String ItemName ;
    int itemQty;
    private String user_name;
    SendItems(AppWindow root,AppStateManager aps)
    {
        this.root=root;       
        this.setBackground(Config.bgColor);
        user_name = aps.SessionUser_;
        
        tfitemName=addTxtfield(450,60);
        tfQty=addTxtfield(450,60);
        ArrayList<Component> ComponentList = new ArrayList();
        
        ComponentList.add(addjlabel("Input Item Type",25,Color.white));
        ComponentList.add(tfitemName);
        ComponentList.add(addjlabel("Input Item Quantity",25,Color.white));
        ComponentList.add(tfQty);

        ComponentList.add(addButton("Donate Items",450,60,new Color(0xcfa62),SendData()));
        ComponentList.add(addButton("Go Back",450,60,new Color(0xcfa62),GoBack()));

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
    
    public ActionListener SendData()
    {
        return (new ActionListener()
                {
                    public void actionPerformed(ActionEvent e)
                    {
                          ItemName = tfitemName.getText();
                            
                            try{
                                 itemQty = Integer.parseInt(tfQty.getText());
                            }catch(Exception ee){
                                System.out.println("[Error:] Must Only Contain Numbers");
                                return;
                            }
                            
                             if(ItemName.equals("")  )
                            {
                                System.out.println("Item Name Cant Be Empty");
                                return;
                            }
                             if(itemQty <=0 )
                            {
                              System.out.println("Item Quantity Cant Be smalelr then 1");
                                return;
                            }
                         root.appManager.Db.InsertData(user_name,ItemName,itemQty);

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
