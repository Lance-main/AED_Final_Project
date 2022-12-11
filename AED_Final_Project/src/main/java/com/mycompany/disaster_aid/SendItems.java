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
import javax.swing.JList;
import java.awt.Dimension;
import java.awt.event.*;
import java.awt.Font;
import javax.swing.JLabel;
import javax.swing.AbstractListModel;
import javax.swing.DefaultListModel;
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
    String CountrySelected="None Selected",OrganizationSelected="None Selected";
    JButton country_Btn,organization_btn,Next;
    AppStateManager aps;
    String[] CountryList_S = {"Ukraine", "Yemen", "Ethiopia","Syria"};
    
    String[] country0_S = {"Empty"};

    String[] country1_S = {"Kherson", "Kyiv"};
    String[] country2_S = {"Sanaa", "Aden"};
    String[] country3_s = {"Addis Ababa", "Harar"};
    String[] country4_s = {"Damascus", "Aleppo"};
    DefaultListModel model = new DefaultListModel();
    
    private JList CountryListDP;
    private JList OrganizationDP;

    JPanel DropDown;
    JPanel DropDown2;
    JPanel containDrop;
    
     JLabel Error_Lab=addjlabel("Please Fill Details to Continue",20,Color.WHITE);


    SendItems(AppWindow root,AppStateManager aps)
    {
        model.add(0,"Empty ");
        this.root=root;     
        this.aps=aps;
        user_name = aps.SessionUser_;
        ArrayList<Component> ComponentList2 = new ArrayList();
        this.setLayout(new FlowLayout(FlowLayout.LEADING,20,70));

        this.setBackground(Config.bgColor);
        ComponentList2.add(addButton("Home",300,60,new Color(0xcfa62),GoBack()));
        ComponentList2.add(addButton("Send Donation",300,60,Config.selectColor));
        ComponentList2.add(addButton("Track Order",300,60,new Color(0xcfa62),TrackOrder("userinfo")));
        ComponentList2.add(addButton("Log Out",300,60,new Color(0xcfa62),logout(aps)));        
        
        
        ArrayList<Component> ComponentList = new ArrayList();
        

        
       CountryListDP=new JList(CountryList_S);
       CountryListDP.setFont(new Font("Arial",Font.PLAIN,25));
       CountryListDP.setPreferredSize(new Dimension(300,150));
       CountryListDP.setForeground(Color.BLACK);
       
       country_Btn = addButton("None Selected",300,60,new Color(0xcfa62));
       DropDown = addjpanel(new Color(0xaaca),FlowLayout.CENTER,0,50,400,200,ComponentList);
       DropDown.add(country_Btn);
       DropDown.add(CountryListDP);
       
       OrganizationDP=new JList(model );
       OrganizationDP.setFont(new Font("Arial",Font.PLAIN,25));
       OrganizationDP.setPreferredSize(new Dimension(300,350));
       OrganizationDP.setForeground(Color.BLACK);
       
       organization_btn = addButton("None Selected",300,60,new Color(0xcfa62));
       DropDown2 = addjpanel(new Color(0xaaca),FlowLayout.CENTER,0,50,400,200,ComponentList);
       DropDown2.add(organization_btn);
       DropDown2.add(OrganizationDP);
       
        Next =addButton("Next",300,60,new Color(0xcfa62),gotoNext());

       
       containDrop = addjpanel(new Color(0xaaca),FlowLayout.CENTER,20,50,500,1200,ComponentList);
       containDrop.add(addjlabel("Select Country",35,Color.white));
       containDrop.add(DropDown);
       containDrop.add(addjlabel("Select Organization",35,Color.white));
       containDrop.add(DropDown2);
       containDrop.add(Next);
       containDrop.add(Error_Lab);

       
       HandleExpandedOptions(country_Btn,CountryListDP,CountryList_S);
       HandleExpandedOptions2(organization_btn,OrganizationDP,country1_S);

       ComponentList.add(containDrop);

        this.add(addjpanel(new Color(0xaaca),FlowLayout.CENTER,100,50,350,900,ComponentList2));

        this.add(addjpanel(new Color(0xaaca),FlowLayout.CENTER,20,50,1500,900,ComponentList));
        init(aps);
        
    }
     public void HandleExpandedOptions2(JButton Btn,JList List,String[] data)
    {
        List.setVisible(false);
        Btn.addActionListener(
                new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        if(List.isVisible() == false) {
                          
                            List.setVisible(true);
                            //List.setListData(data);
                            
                            return;
                        }else{
                            List.setVisible(false);
                        }
                    }
                }
        );
        List.addMouseListener(
                new MouseAdapter() {
                    @Override
                    public void mouseClicked(MouseEvent e) {
                        if(e.getClickCount() ==1)
                        {
                            List.setVisible(false);
                            
                            OrganizationSelected = ""+List.getSelectedValue();
                            
                            Btn.setText(OrganizationSelected);
                        }
                    }
                }
        );
    }
    public void HandleExpandedOptions(JButton Btn,JList List,String[] data)
    {
        List.setVisible(false);
        Btn.addActionListener(
                new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        if(List.isVisible() == false) {
                          
                            List.setVisible(true);
                            List.setListData(data);

                            return;
                        }else{
                            List.setVisible(false);
                        }
                    }
                }
        );
        List.addMouseListener(
                new MouseAdapter() {
                    @Override
                    public void mouseClicked(MouseEvent e) {
                        if(e.getClickCount() ==1)
                        {
                            List.setVisible(false);
                            CountrySelected = ""+List.getSelectedValue();
                            
                            for (int i = 0; i < CountryList_S.length; i++) {
                                if (CountryList_S[i].equals(CountrySelected ) ){
                                    if(i==0)
                                    {
                                        System.out.println("first");
                                        OrganizationDP.setListData(country1_S);
                                    
                                        //DropDown2.getComponents()[1]=new JList(country1_S);
                                    }else if(i==1)
                                    {
                                        System.out.println("second");
                                        OrganizationDP.setListData(country2_S);

                                    }else if(i==2)
                                    {   System.out.println("third");
                                        OrganizationDP.setListData(country3_s);

                                    }else if(i==3)
                                    {
                                        System.out.println("fourth");
                                        OrganizationDP.setListData(country4_s);

                                    }
                                    OrganizationDP.requestFocus();

                                    OrganizationDP.ensureIndexIsVisible(OrganizationDP.getModel().getSize());
                                    break;
                                }
                            }
                            Btn.setText(CountrySelected);
                        }
                    }
                }
        );
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
    public ActionListener gotoNext()
    {
     return (new ActionListener()
                {
                    public void actionPerformed(ActionEvent e)
                    {
                        if(CountrySelected.equals("None Selected") )
                        {
                            Error_Lab.setText("Country Selection is Required");
                            Error_Lab.setForeground(Config.warningColor);
                            return;
                        }
                         if(OrganizationSelected.equals("None Selected") )
                        {
                            Error_Lab.setText("Organization Selection is Required");
                            Error_Lab.setForeground(Config.warningColor);
                            return;
                        }
                        root.setContentPane(   new SendItems3(root,aps,CountrySelected,OrganizationSelected));

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
    JLabel Error_Lab=addjlabel("Please Fill Details to Donate",20,Color.WHITE);

    SendItems3(AppWindow root,AppStateManager aps,String country,String org)
    {
        
        this.aps=aps;
        CountrySelected = country;
        Organization =org;
        this.root=root;       
        this.setBackground(Config.bgColor);
        ArrayList<Component> ComponentList2 = new ArrayList();

        user_name = aps.SessionUser_;
        
        this.setLayout(new FlowLayout(FlowLayout.LEADING,20,70));
        ComponentList2.add(addButton("Home",300,60,new Color(0xcfa62),GoBack()));
        ComponentList2.add(addButton("Send Donation",300,60,Config.selectColor));
        ComponentList2.add(addButton("Track Order",300,60,new Color(0xcfa62),TrackOrder("userinfo")));
        ComponentList2.add(addButton("Log Out",300,60,new Color(0xcfa62),logout(aps)));
        
           
        ArrayList<Component> subListRight = new ArrayList();
        ArrayList<Component> subListMid = new ArrayList();
        ArrayList<Component> subListLeft = new ArrayList();
        
        tf1=addTxtfield(400,60);
        tf2=addTxtfield(400,60);
        tf3=addTxtfield(400,60);
        
        subListRight.add(tf1);
        subListRight.add(tf2);
        subListRight.add(tf3);
        
        subListLeft.add(addjlabel("Enter Item Name",24,Color.WHITE));
        subListLeft.add(addjlabel("Enter Item Quantity",24,Color.WHITE));
        subListLeft.add(addjlabel("Enter Item Category",24,Color.WHITE));
     
        
        subListMid.add(addButton("Donate Items",450,60,new Color(0xcfa62),SendData()));
        subListMid.add(addButton("Go Back",450,60,new Color(0xcfa62),GoBack()));
        subListMid.add(Error_Lab);

        ArrayList<Component> ComponentList = new ArrayList();
        
         
        ComponentList.add(addjpanel(new Color(0xaaca),FlowLayout.CENTER,110,60,500,500,subListLeft));
        ComponentList.add(addjpanel(new Color(0xaaca),FlowLayout.CENTER,90,60,500,500,subListRight));
        ComponentList.add(addjpanel(new Color(0xaaca),FlowLayout.CENTER,20,60,500,500,subListMid));
    

        this.add(addjpanel(new Color(0xaaca),FlowLayout.CENTER,100,50,350,900,ComponentList2));

        this.add(addjpanel(new Color(0xaaca),FlowLayout.CENTER,50,50,1500,900,ComponentList));
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
                                   Error_Lab.setText("Quantity Can Only be In Numbers");
                                   Error_Lab.setForeground(Config.warningColor);
                                return;
                            }
                            
                             if(ItemName.equals("")  )
                            {
                                System.out.println("Item Name Cant Be Empty");
                                  Error_Lab.setText("Item Name Cant Be Empty");
                                   Error_Lab.setForeground(Config.warningColor);
                                return;
                            }
                               if(itemCat.equals("")  )
                            {
                                System.out.println("Item category Cant Be Empty");
                                  Error_Lab.setText("Item Must Belong to a category");
                                   Error_Lab.setForeground(Config.warningColor);
                                return;
                            }
                             if(itemQty <=0 )
                            {
                              System.out.println("Item Quantity Cant Be smalelr then 1");
                              Error_Lab.setText("Item Quantity Cant Be 0");
                                   Error_Lab.setForeground(Config.warningColor);
                                return;
                            }
                             System.out.println("Sending items============");
                         root.appManager.Db.InsertData(user_name,ItemName,itemCat,CountrySelected,Organization,"Awaiting Delivery",itemQty);
                         root.appManager.Db.Inserthub(user_name,ItemName,CountrySelected,Organization,"Awaiting Delivery",aps.Db.Hub);

                         switchScene(Config.Home_Scene_User);
                        
                    }
                }
            );
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