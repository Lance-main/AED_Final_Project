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
import javax.swing.JButton;
/**
 *
 * @author 
 */
public class SendItems extends JPanel implements Scenes
{
    private AppWindow root;
    JTextField tfitemName ;
    JTextField tfQty ;
    String ItemName ;
    int itemQty;
    private String user_name;
    String CountrySelected;
    JButton btn1,btn2,btn3,btn4;
    AppStateManager aps;
    SendItems(AppWindow root,AppStateManager aps)
    {
        this.root=root;     
        this.aps=aps;
        this.setBackground(Config.bgColor);
        user_name = aps.SessionUser_;
        
        tfitemName=addTxtfield(450,60);
        tfQty=addTxtfield(450,60);
        ArrayList<Component> ComponentList = new ArrayList();
        btn1= addButton("Ukrain",400,60,new Color(0xcfa62),getCountry());
        btn2= addButton("Yemen",400,60,new Color(0xcfa62),getCountry());
        btn3= addButton("Syria",400,60,new Color(0xcfa62),getCountry());
        btn4= addButton("Ethiopia",400,60,new Color(0xcfa62),getCountry());

        
        ComponentList.add(addjlabel("Select Country",25,Color.white));
        ComponentList.add(btn1);
        ComponentList.add(btn2);
        ComponentList.add(btn3);
        ComponentList.add(btn4);
        ComponentList.add(addButton("Next",450,60,new Color(0xcfa62),gotoNext()));
        ComponentList.add(addButton("Go Back",450,60,new Color(0xcfa62),GoBack()));

        this.add(addjpanel(new Color(0xaaca),FlowLayout.CENTER,50,50,650,650,ComponentList));
        init(aps);
    }
    public ActionListener gotoNext()
    {
     return (new ActionListener()
                {
                    public void actionPerformed(ActionEvent e)
                    {
                        if(CountrySelected == null)
                        {
                            return;
                        }
                        root.setContentPane(   new SendItems2(root,aps,CountrySelected));

                    }
                }
            );
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
    public ActionListener getCountry()
    {
        return (new ActionListener()
                {
                    public void actionPerformed(ActionEvent e)
                    {
                        btn1.setBackground(new Color(0xcfa62));
                        btn2.setBackground(new Color(0xcfa62));
                        btn3.setBackground(new Color(0xcfa62));
                        btn4.setBackground(new Color(0xcfa62));

                        JButton jb = (JButton)e.getSource();
                        jb.setBackground(new Color(0xEA7364));
                        
                        CountrySelected = jb.getText();
                        System.out.println("Selected "+CountrySelected);
                        
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

 class SendItems2 extends JPanel implements Scenes
{
    private AppWindow root;
    JButton org1 ;
    JButton org2 ;
    String ItemName ;
    int itemQty;
    private String user_name;
    String Organization;
    String Country;

    AppStateManager aps;
    SendItems2(AppWindow root,AppStateManager aps,String countrySelected)
    {
        this.aps=aps;
        Country=countrySelected;
        this.root=root;       
        this.setBackground(Config.bgColor);
        user_name = aps.SessionUser_;
        
        org1=addButton("Organization 1",450,60,new Color(0xcfa62),getOrgaization());
        org2=addButton("Organization 2",450,60,new Color(0xcfa62),getOrgaization());
        ArrayList<Component> ComponentList = new ArrayList();
    
        
        ComponentList.add(addjlabel("Select Organization",25,Color.white));
   
        ComponentList.add(org1);
        ComponentList.add(org2);

        ComponentList.add(addButton("Next",450,60,new Color(0xcfa62),gotoNext()));
        ComponentList.add(addButton("Go Back",450,60,new Color(0xcfa62),GoBack()));

        this.add(addjpanel(new Color(0xaaca),FlowLayout.CENTER,50,50,650,650,ComponentList));
        init(aps);
    }
    public ActionListener getOrgaization()
    {
        return (new ActionListener()
                {
                    public void actionPerformed(ActionEvent e)
                    {
                        org1.setBackground(new Color(0xcfa62));
                        org2.setBackground(new Color(0xcfa62));
               

                        JButton jb = (JButton)e.getSource();
                        jb.setBackground(new Color(0xEA7364));
                        
                        Organization = jb.getText();
                        System.out.println("Selected "+Organization);
                        
                    }
                }
            );
    }  
    public ActionListener gotoNext()
    {
     return (new ActionListener()
                {
                    public void actionPerformed(ActionEvent e)
                    {
                        if(Organization==null )
                        {
                            return;
                        }
                        root.setContentPane(   new SendItems3(root,aps,Country,Organization));

                    }
                }
            );
    }  
    public ActionListener GoBack()
    {
        return (new ActionListener()
                {
                    public void actionPerformed(ActionEvent e)
                    {
                      
                         root.setContentPane(new SendItems(root,aps));
                        
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


class SendItems3 extends JPanel implements Scenes
{
    private AppWindow root;
    JButton donate ;
    
    String ItemName ,itemCat;
    int itemQty;
    private String user_name;
    String CountrySelected;
    String Organization;

    JTextField tf1,tf2,tf3;
    AppStateManager aps;
    SendItems3(AppWindow root,AppStateManager aps,String country,String org)
    {
        this.aps=aps;
        CountrySelected = country;
        Organization =org;
        this.root=root;       
        this.setBackground(Config.bgColor);
        
        user_name = aps.SessionUser_;
        
        tf1=addTxtfield(400,60);
        tf2=addTxtfield(400,60);
        tf3=addTxtfield(400,60);

        ArrayList<Component> ComponentList = new ArrayList();
    
        
        ComponentList.add(addjlabel("Enter Item Name",24,Color.WHITE));
        ComponentList.add(tf1);
        ComponentList.add(addjlabel("Enter Item Quantity",24,Color.WHITE));
        ComponentList.add(tf2);
        ComponentList.add(addjlabel("Enter Item Category",24,Color.WHITE));
        ComponentList.add(tf3);

        
        ComponentList.add(addButton("Donate Items",450,60,new Color(0xcfa62),SendData()));
        ComponentList.add(addButton("Go Back",450,60,new Color(0xcfa62),GoBack()));

        this.add(addjpanel(new Color(0xaaca),FlowLayout.CENTER,30,50,650,650,ComponentList));
        init(aps);
    }
      public ActionListener SendData()
    {
        return (new ActionListener()
                {
                    public void actionPerformed(ActionEvent e)
                    {
                          ItemName = tf1.getText();
                          itemCat = tf3.getText();

                            try{
                                 itemQty = Integer.parseInt(tf2.getText());
                            }catch(Exception ee){
                                System.out.println("[Error:] Must Only Contain Numbers");
                                return;
                            }
                            
                             if(ItemName.equals("")  )
                            {
                                System.out.println("Item Name Cant Be Empty");
                                return;
                            }
                               if(itemCat.equals("")  )
                            {
                                System.out.println("Item category Cant Be Empty");
                                return;
                            }
                             if(itemQty <=0 )
                            {
                              System.out.println("Item Quantity Cant Be smalelr then 1");
                                return;
                            }
                         root.appManager.Db.InsertData(user_name,ItemName,itemCat,CountrySelected,Organization,"At HUB",itemQty);

                         switchScene(Config.Home_Scene_User);
                        
                    }
                }
            );
    }
    public ActionListener GoBack()
    {
        return (new ActionListener()
                {
                    public void actionPerformed(ActionEvent e)
                    {
                      
                         root.setContentPane(new SendItems2(root,aps,CountrySelected));
                        
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