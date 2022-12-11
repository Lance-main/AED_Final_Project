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
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.JTabbedPane;
import java.awt.*;
import java.util.Vector;
import javax.swing.JPasswordField;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.JScrollPane;
import javax.swing.JCheckBox;
/**
 *
 * @author 
 */
public class HomeScene_Admin extends JPanel implements Scenes
{
      private AppWindow root;
      AppStateManager aps;
    HomeScene_Admin(AppWindow root,AppStateManager aps)
    {
          this.root=root;
          this.aps=aps;
         this.setLayout(new FlowLayout(FlowLayout.LEADING,20,40));
          ArrayList<Component> ComponentList2 = new ArrayList();

          ArrayList<Component> ComponentList = new ArrayList();
          ArrayList<Component> Content = new ArrayList();

          
          
          ComponentList2.add(addjlabel("Welcome to Donation Aid Admin Page",50,new Color(0xdfa12)));
          ComponentList2.add(addjpanel(new Color(0xaaca),FlowLayout.LEFT,50,50,450,500,Content));
          
                      
          ComponentList.add(addButton("Home",300,50,Config.selectColor,GoBack()));
          ComponentList.add(addButton("Manage User Data",300,50,new Color(0xcfa62),this.Manage_User_Data()));
          ComponentList.add(addButton("Manage Users",300,50,new Color(0xcfa62),this.Manage_User_Info()));
          ComponentList.add(addButton("Manage Hubs",300,50,new Color(0xcfa62),this.Manage_Hub()));
          ComponentList.add(addButton("Manage Enterprises",300,50,new Color(0xcfa62),this.Manage_Enterprise()));
          ComponentList.add(addButton("Manage Organizations",300,50,new Color(0xcfa62),this.Manage_Organization()));
          ComponentList.add(addButton("Manage Delivery Agent",300,50,new Color(0xcfa62),this.Manage_Logger()));
          ComponentList.add(addButton("Manage Loggers",300,50,new Color(0xcfa62),this.Manage_DeliveryAgent()));
          ComponentList.add(addButton("Manage Ground Center",300,50,new Color(0xcfa62),this.Manage_GroundCenter()));
          ComponentList.add(addButton("Log Out",300,50,new Color(0xcfa62),this.logout(aps)));

          this.setBackground(Config.bgColor);
          this.add(addjpanel(new Color(0xaaca),FlowLayout.CENTER,35,20,400,920,ComponentList));
          this.add(addjpanel(new Color(0xaaca),FlowLayout.CENTER,50,300,1400,900,ComponentList2));

    }
    public ActionListener Manage_User_Data()
      {
          return (new ActionListener()
                  {
                      public void actionPerformed(ActionEvent e)
                      {

                          root.setContentPane(   new admin_ManageUsers(root,aps));

                      }
                  }
              );
      }
    
        public ActionListener Manage_User_Info()
      {
          return (new ActionListener()
                  {
                      public void actionPerformed(ActionEvent e)
                      {

                          root.setContentPane(   new admin_ManageUserAccounts(root,aps));

                      }
                  }
              );
      }
     public ActionListener Manage_Hub()
      {
          return (new ActionListener()
                  {
                      public void actionPerformed(ActionEvent e)
                      {

                          root.setContentPane(   new admin_ManageHubAccounts(root,aps));

                      }
                  }
              );
      }
      public ActionListener Manage_Enterprise()
      {
          return (new ActionListener()
                  {
                      public void actionPerformed(ActionEvent e)
                      {

                          root.setContentPane(   new admin_ManageEnterprise(root,aps));

                      }
                  }
              );
      }
       public ActionListener Manage_Organization()
      {
          return (new ActionListener()
                  {
                      public void actionPerformed(ActionEvent e)
                      {

                          root.setContentPane(   new admin_ManageOrganization(root,aps));

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
                      
                         switchScene(Config.Home_Scene_Admin);
                        
                    }
                }
            );
    }  
        public ActionListener Manage_Logger()
      {
          return (new ActionListener()
                  {
                      public void actionPerformed(ActionEvent e)
                      {

                          root.setContentPane(   new admin_Manage_Logger(root,aps));

                      }
                  }
              );
      }
         public ActionListener Manage_DeliveryAgent()
      {
          return (new ActionListener()
                  {
                      public void actionPerformed(ActionEvent e)
                      {

                          root.setContentPane(   new admin_Manage_DeliveryAgent(root,aps));

                      }
                  }
              );
      }
         
             public ActionListener Manage_GroundCenter()
      {
          return (new ActionListener()
                  {
                      public void actionPerformed(ActionEvent e)
                      {

                          root.setContentPane(   new admin_Manage_Ground_Center(root,aps));

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
         root.setContentPane(new HomeScene_Admin(root,aps));
         update(root);
    }
}
//ManageUsers
class admin_ManageUsers extends JPanel implements Scenes
{
    private AppWindow root;
    JButton donate ;
    
    String ItemName ,itemCat,PlaceHolder;
    int itemQty;
    private String user_name;
    String CountrySelected;
    String Organization;
    DefaultTableModel model ;

    JTextField tf1,tf2,tf3,tf4,tf5,tf6,tf7;
    AppStateManager aps;
        String[] columnNames = new String[]{ "User Name","Item Name","Item Quantity","Category","Destination","Organization","Logistics"};
   Object[][] TableData = new Object[][]{};

    JLabel Error_Lab=addjlabel("Please Fill Details to Donate",20,Color.WHITE);
    JTabbedPane data ;
    admin_ManageUsers(AppWindow root,AppStateManager aps)
    {
        
        this.aps=aps;
        data = new JTabbedPane();
        this.root=root;       
        this.setBackground(Config.bgColor);
        ArrayList<Component> ComponentList2 = new ArrayList();
          ArrayList<Component> ComponentList = new ArrayList();
                  ArrayList<Component> ComponentList3 = new ArrayList();

        model = new DefaultTableModel(TableData,columnNames);

        
              for (int i = 0; i < aps.Db.getTotalHistory(); i++) 
        {
                    Vector<Object> tt = new Vector<Object>();

                System.out.println("i "+i);
                tt.add(aps.Db.GetAllwithDb(i,"UserName",aps.Db.userData));
                tt.add(aps.Db.GetAllwithDb(i,"DonationType",aps.Db.userData));
                tt.add(aps.Db.GetAllwithDb(i,"Category",aps.Db.userData));
                tt.add(aps.Db.GetAllwithDb(i,"Destination",aps.Db.userData));
                tt.add(aps.Db.GetAllwithDb(i,"Organization",aps.Db.userData));
                tt.add(aps.Db.GetAllwithDb(i,"PlaceHolder",aps.Db.userData));
                tt.add(aps.Db.GetAllwithDb(i,"Qty",aps.Db.userData));

                model.insertRow(0,tt);

        }
        
        
        
        
        JTable jt = new JTable();
        jt.setModel(model);
        DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
        centerRenderer.setHorizontalAlignment(JLabel.CENTER);
         
         
         
        this.setLayout(new FlowLayout(FlowLayout.LEADING,20,40));
         for(int j=0;j<jt.getColumnCount();j++)
        {
            jt.getColumnModel().getColumn(j).setCellRenderer(centerRenderer);
        }
     
          ComponentList.add(addButton("Home",300,50,new Color(0xcfa62),GoBack()));
          ComponentList.add(addButton("Manage User Data",300,50,Config.selectColor,Manage_User_Data()));
          ComponentList.add(addButton("Manage Users",300,50,new Color(0xcfa62),Manage_User_Info()));
          ComponentList.add(addButton("Manage Hubs",300,50,new Color(0xcfa62),Manage_Hub()));
          ComponentList.add(addButton("Manage Enterprises",300,50,new Color(0xcfa62),Manage_Enterprise()));
          ComponentList.add(addButton("Manage Organizations",300,50,new Color(0xcfa62),Manage_Organization()));
          ComponentList.add(addButton("Manage Delivery Agent",300,50,new Color(0xcfa62),Manage_DeliveryAgent()));
          ComponentList.add(addButton("Manage Loggers",300,50,new Color(0xcfa62),Manage_Logger()));
          ComponentList.add(addButton("Manage Ground Center",300,50,new Color(0xcfa62),Manage_GroundCenter()));
          ComponentList.add(addButton("Log Out",300,50,new Color(0xcfa62),logout(aps)));
        
        
        
        jt.getTableHeader().setReorderingAllowed(false);
        jt.setRowHeight(80);
        jt.getTableHeader().setResizingAllowed(false);

        
        
        
        
        JScrollPane jc = new JScrollPane(jt);
        jc.setPreferredSize(new Dimension(1350, 750));
        ComponentList3.add(jc);

        
        
       ArrayList<Component> addTransaction_User = new ArrayList();
          
        ArrayList<Component> subListRight = new ArrayList();
        ArrayList<Component> subListMid = new ArrayList();
        ArrayList<Component> subListLeft = new ArrayList();
        
        subListLeft.add(addjlabel("Enter User Name",24,Color.WHITE));
        subListLeft.add(addjlabel("Enter Item Name",24,Color.WHITE));
        subListLeft.add(addjlabel("Enter Category",24,Color.WHITE));
        subListLeft.add(addjlabel("Enter Destination",24,Color.WHITE));
        subListLeft.add(addjlabel("Enter Organization",24,Color.WHITE));
        subListLeft.add(addjlabel("Enter PlaceHolder",24,Color.WHITE));
        subListLeft.add(addjlabel("Enter Qty",24,Color.WHITE));
    
       
        tf1=addTxtfield(400,60);
        tf2=addTxtfield(400,60);
        tf3=addTxtfield(400,60); 
        tf4=addTxtfield(400,60);
        tf5=addTxtfield(400,60);
        tf6=addTxtfield(400,60);
        tf7=addTxtfield(400,60);

        subListRight.add(tf1);
        subListRight.add(tf2);
        subListRight.add(tf3);
        subListRight.add(tf4);
        subListRight.add(tf5);
        subListRight.add(tf6);
        subListRight.add(tf7);
        subListMid.add(addButton("Add Record",450,60,new Color(0xcfa62),SendData()));
        subListMid.add(Error_Lab);

        addTransaction_User.add(addjpanel(new Color(0xaaca),FlowLayout.CENTER,50,50,350,600,subListLeft));
        addTransaction_User.add(addjpanel(new Color(0xaaca),FlowLayout.CENTER,20,50,650,600,subListRight));
        addTransaction_User.add(addjpanel(new Color(0xaaca),FlowLayout.CENTER,20,50,500,200,subListMid));

        data.setPreferredSize(new Dimension(1400,900));
        data.add("<html> <h1 style='padding:10px;'> Add Transaction </h1> </html>",addjpanel(new Color(0xaaca),FlowLayout.CENTER,20,150,500,900,addTransaction_User));
        data.add("<html> <h1 style='padding:10px;'> Manage Transaction </h1> </html>",addjpanel(new Color(0xaaca),FlowLayout.CENTER,40,50,350,900,ComponentList3));
        ComponentList2.add(data);
        this.add(addjpanel(new Color(0xaaca),FlowLayout.CENTER,35,20,400,920,ComponentList));
        this.add(addjpanel(Config.bgColor,FlowLayout.CENTER,10,300,1400,900,ComponentList2));
        
        
        
        init(aps);
    }
    public ActionListener Manage_User_Data()
      {
          return (new ActionListener()
                  {
                      public void actionPerformed(ActionEvent e)
                      {

                          root.setContentPane(   new admin_ManageUsers(root,aps));

                      }
                  }
              );
      }
    
        public ActionListener Manage_User_Info()
      {
          return (new ActionListener()
                  {
                      public void actionPerformed(ActionEvent e)
                      {

                          root.setContentPane(   new admin_ManageUserAccounts(root,aps));

                      }
                  }
              );
      }
     public ActionListener Manage_Hub()
      {
          return (new ActionListener()
                  {
                      public void actionPerformed(ActionEvent e)
                      {

                          root.setContentPane(   new admin_ManageHubAccounts(root,aps));

                      }
                  }
              );
      }
      public ActionListener Manage_Enterprise()
      {
          return (new ActionListener()
                  {
                      public void actionPerformed(ActionEvent e)
                      {

                          root.setContentPane(   new admin_ManageEnterprise(root,aps));

                      }
                  }
              );
      }
       public ActionListener Manage_Organization()
      {
          return (new ActionListener()
                  {
                      public void actionPerformed(ActionEvent e)
                      {

                          root.setContentPane(   new admin_ManageOrganization(root,aps));

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
                      
                         switchScene(Config.Home_Scene_Admin);
                        
                    }
                }
            );
    }  
        public ActionListener Manage_Logger()
      {
          return (new ActionListener()
                  {
                      public void actionPerformed(ActionEvent e)
                      {

                          root.setContentPane(   new admin_Manage_Logger(root,aps));

                      }
                  }
              );
      }
         public ActionListener Manage_DeliveryAgent()
      {
          return (new ActionListener()
                  {
                      public void actionPerformed(ActionEvent e)
                      {

                          root.setContentPane(   new admin_Manage_DeliveryAgent(root,aps));

                      }
                  }
              );
      }
         
             public ActionListener Manage_GroundCenter()
      {
          return (new ActionListener()
                  {
                      public void actionPerformed(ActionEvent e)
                      {

                          root.setContentPane(   new admin_Manage_Ground_Center(root,aps));

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
                          user_name = tf1.getText();
                          ItemName = tf2.getText();
                          itemCat = tf3.getText();
                          CountrySelected = tf4.getText();
                          Organization = tf5.getText();
                          PlaceHolder = tf6.getText();
                      
                          
                            try{
                                 itemQty = Integer.parseInt(tf7.getText());
                            }catch(Exception ee){
                                   Error_Lab.setText("Quantity Can Only be In Numbers");
                                   Error_Lab.setForeground(Config.warningColor);
                                return;
                            }
                            
                             if(ItemName.equals("")  )
                            {
                                  Error_Lab.setText("Item Name Cant Be Empty");
                                   Error_Lab.setForeground(Config.warningColor);
                                return;
                            }
                               if(itemCat.equals("")  )
                            {
                                  Error_Lab.setText("Item Must Belong to a category");
                                   Error_Lab.setForeground(Config.warningColor);
                                return;
                            }
                                   if(user_name.equals("")  )
                            {
                                  Error_Lab.setText("User Name  cant be Empty");
                                   Error_Lab.setForeground(Config.warningColor);
                                return;
                            }
                                if(CountrySelected.equals("")  )
                            {
                                  Error_Lab.setText("Destination  cant be Empty");
                                   Error_Lab.setForeground(Config.warningColor);
                                return;
                            }
                                if(Organization.equals("")  )
                            {
                                  Error_Lab.setText("Organization  cant be Empty");
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
                             
                                    if(PlaceHolder.equals("")  )
                            {
                                  Error_Lab.setText("PlaceHolder  cant be Empty");
                                   Error_Lab.setForeground(Config.warningColor);
                                   return;
                            }
                         root.appManager.Db.InsertData(user_name,ItemName,itemCat,CountrySelected,Organization,PlaceHolder,itemQty);
                         root.appManager.Db.Inserthub(user_name,ItemName,CountrySelected,Organization,PlaceHolder,aps.Db.Hub);

                         switchScene(Config.Home_Scene_Admin);
                        
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



class admin_ManageUserAccounts extends JPanel implements Scenes
{
    private AppWindow root;
    JButton donate ;
   
    DefaultTableModel model ;

     String UserName ;
    String Email;
    String Password;
    String Country;
    String City;
    int PinCode;
    
    JTextField tfName ;
    JTextField tfEmail ;
    JPasswordField tfPassword ;
    JTextField tfCountry ;
    JTextField tfCity ;
    JTextField tfPlaceHolder ;

    JTextField tfPinCode ;
    
    
    AppStateManager aps;
        String[] columnNames = new String[]{ "User Name","User Password","Email","Country","City","Pin Code"};
   Object[][] TableData = new Object[][]{};

    JLabel Error_Lab=addjlabel("Please Fill Details to Donate",20,Color.WHITE);
    JTabbedPane data ;
    admin_ManageUserAccounts(AppWindow root,AppStateManager aps)
    {
        
        this.aps=aps;
        data = new JTabbedPane();
        this.root=root;       
        this.setBackground(Config.bgColor);
        ArrayList<Component> ComponentList2 = new ArrayList();
          ArrayList<Component> ComponentList = new ArrayList();
                  ArrayList<Component> ComponentList3 = new ArrayList();

        model = new DefaultTableModel(TableData,columnNames);

        
              for (int i = 0; i < aps.Db.getTotalUser(aps.Db.UserInfo); i++) 
        {
                    Vector<Object> tt = new Vector<Object>();

                System.out.println("i "+i);
                tt.add(aps.Db.GetAllUser(i,"UserName"));
                tt.add(aps.Db.GetAllUser(i,"Password"));
                tt.add(aps.Db.GetAllUser(i,"Email"));
                tt.add(aps.Db.GetAllUser(i,"Country"));
                tt.add(aps.Db.GetAllUser(i,"City"));
                tt.add(aps.Db.GetAllUser(i,"PinCode"));
                model.insertRow(0,tt);

        }
        
        
        
        
         JTable jt = new JTable();
         jt.setModel(model);
         
        DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
        centerRenderer.setHorizontalAlignment(JLabel.CENTER);

         
        this.setLayout(new FlowLayout(FlowLayout.LEADING,20,40));
         for(int j=0;j<jt.getColumnCount();j++)
        {
            jt.getColumnModel().getColumn(j).setCellRenderer(centerRenderer);
        }
         
         
         
//        ComponentList2.add(addButton("Home",300,60,new Color(0xcfa62),GoBack()));
//        ComponentList2.add(addButton("Manage User Data",300,60,new Color(0xcfa62),SendtoData()));
//        ComponentList2.add(addButton("Manage Users",300,60,Config.selectColor));
//        ComponentList2.add(addButton("Manage Hubs",300,60,new Color(0xcfa62), hub()));
//        ComponentList2.add(addButton("Manage Enterprises",300,60,new Color(0xcfa62)));
//        ComponentList2.add(addButton("Manage Organizations",300,60,new Color(0xcfa62)));
//        ComponentList2.add(addButton("Manage Loggers",300,60,new Color(0xcfa62)));
//        ComponentList2.add(addButton("Log Out",300,60,new Color(0xcfa62),logout(aps)));
        
          
             
                    
          ComponentList.add(addButton("Home",300,50,new Color(0xcfa62),GoBack()));
          ComponentList.add(addButton("Manage User Data",300,50,new Color(0xcfa62),this.Manage_User_Data()));
          ComponentList.add(addButton("Manage Users",300,50,Config.selectColor,this.Manage_User_Info()));
          ComponentList.add(addButton("Manage Hubs",300,50,new Color(0xcfa62),this.Manage_Hub()));
          ComponentList.add(addButton("Manage Enterprises",300,50,new Color(0xcfa62),this.Manage_Enterprise()));
          ComponentList.add(addButton("Manage Organizations",300,50,new Color(0xcfa62),this.Manage_Organization()));
             ComponentList.add(addButton("Manage Delivery Agent",300,50,new Color(0xcfa62),this.Manage_DeliveryAgent()));
          ComponentList.add(addButton("Manage Loggers",300,50,new Color(0xcfa62),Manage_Logger()));
          ComponentList.add(addButton("Manage Ground Center",300,50,new Color(0xcfa62),this.Manage_GroundCenter()));
          ComponentList.add(addButton("Log Out",300,50,new Color(0xcfa62),this.logout(aps)));
        
          jt.getTableHeader().setReorderingAllowed(false);
        jt.setRowHeight(50);
        jt.getTableHeader().setResizingAllowed(false);
        
        
        ComponentList.add(data);
        
        
        
        JScrollPane jc = new JScrollPane(jt);
        jc.setPreferredSize(new Dimension(1350, 750));
        ComponentList3.add(jc);

        
        
       ArrayList<Component> addTransaction_User = new ArrayList();
          
        ArrayList<Component> subListRight = new ArrayList();
        ArrayList<Component> subListMid = new ArrayList();
        ArrayList<Component> subListLeft = new ArrayList();
        
        subListLeft.add(addjlabel("Enter User Name",24,Color.WHITE));
        subListLeft.add(addjlabel("Enter Email",24,Color.WHITE));
        subListLeft.add(addjlabel("Enter Password",24,Color.WHITE));
        subListLeft.add(addjlabel("Enter Country",24,Color.WHITE));
        subListLeft.add(addjlabel("Enter City",24,Color.WHITE));
        subListLeft.add(addjlabel("Enter PlaceHolder",24,Color.WHITE));
        subListLeft.add(addjlabel("Enter Pin Code",24,Color.WHITE));
    
       
       ArrayList<Component> left = new ArrayList();
       ArrayList<Component> mid = new ArrayList();

       ArrayList<Component> right = new ArrayList();

        
        tfName=addTxtfield(450,60);
        tfEmail=addTxtfield(450,60);
        tfPassword=addPassfield(450,60);
        tfCountry =  addTxtfield(450,60);
        tfCity=addTxtfield(450,60);
        tfPlaceHolder=addTxtfield(450,60);
        tfPinCode=addTxtfield(450,60);
        
        subListRight.add(tfName);
        subListRight.add(tfEmail);
        subListRight.add(tfPassword);
        subListRight.add(tfCountry);
        subListRight.add(tfCity);
        subListRight.add(tfPlaceHolder);

        subListRight.add(tfPinCode);
        
        
        subListMid.add(addButton("Add Record",450,60,new Color(0xcfa62),SendData()));
        subListMid.add(Error_Lab);

        addTransaction_User.add(addjpanel(new Color(0xaaca),FlowLayout.CENTER,50,50,350,600,subListLeft));
        addTransaction_User.add(addjpanel(new Color(0xaaca),FlowLayout.CENTER,20,50,650,600,subListRight));
        addTransaction_User.add(addjpanel(new Color(0xaaca),FlowLayout.CENTER,20,50,500,200,subListMid));
        
        
        
        data.setPreferredSize(new Dimension(1400,900));
        data.add("<html> <h1 style='padding:10px;'> Add Transaction </h1> </html>",addjpanel(new Color(0xaaca),FlowLayout.CENTER,20,150,500,900,addTransaction_User));
        data.add("<html> <h1 style='padding:10px;'> Manage Transaction </h1> </html>",addjpanel(new Color(0xaaca),FlowLayout.CENTER,40,50,350,900,ComponentList3));
        ComponentList2.add(data);
        this.add(addjpanel(new Color(0xaaca),FlowLayout.CENTER,35,20,400,920,ComponentList));
        this.add(addjpanel(Config.bgColor,FlowLayout.CENTER,10,300,1400,900,ComponentList2));
        
        init(aps);
    }
    
    public ActionListener Manage_User_Data()
      {
          return (new ActionListener()
                  {
                      public void actionPerformed(ActionEvent e)
                      {

                          root.setContentPane(   new admin_ManageUsers(root,aps));

                      }
                  }
              );
      }
    
        public ActionListener Manage_User_Info()
      {
          return (new ActionListener()
                  {
                      public void actionPerformed(ActionEvent e)
                      {

                          root.setContentPane(   new admin_ManageUserAccounts(root,aps));

                      }
                  }
              );
      }
     public ActionListener Manage_Hub()
      {
          return (new ActionListener()
                  {
                      public void actionPerformed(ActionEvent e)
                      {

                          root.setContentPane(   new admin_ManageHubAccounts(root,aps));

                      }
                  }
              );
      }
      public ActionListener Manage_Enterprise()
      {
          return (new ActionListener()
                  {
                      public void actionPerformed(ActionEvent e)
                      {

                          root.setContentPane(   new admin_ManageEnterprise(root,aps));

                      }
                  }
              );
      }
       public ActionListener Manage_Organization()
      {
          return (new ActionListener()
                  {
                      public void actionPerformed(ActionEvent e)
                      {

                          root.setContentPane(   new admin_ManageOrganization(root,aps));

                      }
                  }
              );
      }
        public ActionListener Manage_Logger()
      {
          return (new ActionListener()
                  {
                      public void actionPerformed(ActionEvent e)
                      {

                          root.setContentPane(   new admin_Manage_Logger(root,aps));

                      }
                  }
              );
      }
         public ActionListener Manage_DeliveryAgent()
      {
          return (new ActionListener()
                  {
                      public void actionPerformed(ActionEvent e)
                      {

                          root.setContentPane(   new admin_Manage_DeliveryAgent(root,aps));

                      }
                  }
              );
      }
         
             public ActionListener Manage_GroundCenter()
      {
          return (new ActionListener()
                  {
                      public void actionPerformed(ActionEvent e)
                      {

                          root.setContentPane(   new admin_Manage_Ground_Center(root,aps));

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
                           
                          UserName = tfName.getText();

                          Email = tfEmail.getText();
                          Password = tfPassword.getText();
                          Country = tfCountry.getText();
                          City = tfCity.getText();
                          
           
                          
                            try{
                                 PinCode = Integer.parseInt(tfPinCode.getText());
                            }catch(Exception ee){
                                   Error_Lab.setText("Pin Code Can Only be In Numbers");
                                   Error_Lab.setForeground(Config.warningColor);
                                return;
                            }
                            if(Email.equals("")  )
                            {
                                  Error_Lab.setText("Item Name Cant Be Empty");
                                   Error_Lab.setForeground(Config.warningColor);
                                return;
                            }
                            if(UserName.equals("")  )
                            {
                                  Error_Lab.setText("Item Name Cant Be Empty");
                                   Error_Lab.setForeground(Config.warningColor);
                                return;
                            }
                             if(Country.equals("")  )
                            {
                                  Error_Lab.setText("Item Name Cant Be Empty");
                                   Error_Lab.setForeground(Config.warningColor);
                                return;
                            }
                             if(Password.equals("")  )
                            {
                                  Error_Lab.setText("Item Name Cant Be Empty");
                                   Error_Lab.setForeground(Config.warningColor);
                                return;
                            }
                               if(City.equals("")  )
                            {
                                  Error_Lab.setText("Item Must Belong to a category");
                                   Error_Lab.setForeground(Config.warningColor);
                                return;
                            }
                         
                             
                             
                               root.appManager.Db.InsertUser(UserName,Password,Email,Country,City,PinCode);

                         switchScene(Config.Home_Scene_Admin);
                        
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
                      
                         switchScene(Config.Home_Scene_Admin);
                        
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





class admin_ManageHubAccounts extends JPanel implements Scenes
{
    private AppWindow root;
    JButton donate ;
   
    DefaultTableModel model ;

     String UserName ;
    String Shipment;
    String Destomatopm;
    String Organization;
    String Status;

    JTextField tfName ;
    JTextField tfShipMent ;
    JTextField tfCountry ;
    JTextField tfOrganize ;
    JTextField tfStatus ;

    
    AppStateManager aps;
        String[] columnNames = new String[]{ "User Name","Shipments","Destination","Organization","Status"};
   Object[][] TableData = new Object[][]{};

    JLabel Error_Lab=addjlabel("Please Fill Details to Donate",20,Color.WHITE);
    JTabbedPane data ;
    admin_ManageHubAccounts(AppWindow root,AppStateManager aps)
    {
        
        this.aps=aps;
        data = new JTabbedPane();
        this.root=root;       
        this.setBackground(Config.bgColor);
        ArrayList<Component> ComponentList2 = new ArrayList();
          ArrayList<Component> ComponentList = new ArrayList();
                  ArrayList<Component> ComponentList3 = new ArrayList();

        model = new DefaultTableModel(TableData,columnNames);

        
              for (int i = 0; i < aps.Db.getTotalUser(aps.Db.Hub); i++) 
        {
                    Vector<Object> tt = new Vector<Object>();

                System.out.println("i "+i);
                tt.add(aps.Db.GetAllwithDb(i,"UserName",aps.Db.Hub));
                tt.add(aps.Db.GetAllwithDb(i,"Shipment",aps.Db.Hub));
                tt.add(aps.Db.GetAllwithDb(i,"Destination",aps.Db.Hub));
                tt.add(aps.Db.GetAllwithDb(i,"Organization",aps.Db.Hub));
                tt.add(aps.Db.GetAllwithDb(i,"Status",aps.Db.Hub));
                
                model.insertRow(0,tt);

        }
        
        
        
        
         JTable jt = new JTable();
         jt.setModel(model);
         
        DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
        centerRenderer.setHorizontalAlignment(JLabel.CENTER);

         
        this.setLayout(new FlowLayout(FlowLayout.LEADING,20,40));
         for(int j=0;j<jt.getColumnCount();j++)
        {
            jt.getColumnModel().getColumn(j).setCellRenderer(centerRenderer);
        }
         
         
         
//        ComponentList2.add(addButton("Home",300,60,new Color(0xcfa62),GoBack()));
//        ComponentList2.add(addButton("Manage User Data",300,60,new Color(0xcfa62),ManageUsers()));
//        ComponentList2.add(addButton("Manage Users",300,60,new Color(0xcfa62),SendtoData()));
//        ComponentList2.add(addButton("Manage Hubs",300,60,Config.selectColor));
//        ComponentList2.add(addButton("Manage Enterprises",300,60,new Color(0xcfa62)));
//        ComponentList2.add(addButton("Manage Organizations",300,60,new Color(0xcfa62)));
//        ComponentList2.add(addButton("Manage Loggers",300,60,new Color(0xcfa62)));
//        ComponentList2.add(addButton("Log Out",300,60,new Color(0xcfa62),logout(aps)));
        
   
               
                
          ComponentList.add(addButton("Home",300,50,new Color(0xcfa62),GoBack()));
          ComponentList.add(addButton("Manage User Data",300,50,new Color(0xcfa62),this.Manage_User_Data()));
          ComponentList.add(addButton("Manage Users",300,50,new Color(0xcfa62),this.Manage_User_Info()));
          ComponentList.add(addButton("Manage Hubs",300,50,Config.selectColor,this.Manage_Hub()));
          ComponentList.add(addButton("Manage Enterprises",300,50,new Color(0xcfa62),this.Manage_Enterprise()));
          ComponentList.add(addButton("Manage Organizations",300,50,new Color(0xcfa62),this.Manage_Organization()));
          ComponentList.add(addButton("Manage Delivery Agent",300,50,new Color(0xcfa62),this.Manage_DeliveryAgent()));
          ComponentList.add(addButton("Manage Loggers",300,50,new Color(0xcfa62),Manage_Logger()));
          ComponentList.add(addButton("Manage Ground Center",300,50,new Color(0xcfa62),this.Manage_GroundCenter()));
          ComponentList.add(addButton("Log Out",300,50,new Color(0xcfa62),this.logout(aps)));
        
          jt.getTableHeader().setReorderingAllowed(false);
        jt.setRowHeight(50);
        jt.getTableHeader().setResizingAllowed(false);
     
        
        
         
        JScrollPane jc = new JScrollPane(jt);
        jc.setPreferredSize(new Dimension(1350, 750));
        ComponentList3.add(jc);

        
        
       ArrayList<Component> addTransaction_User = new ArrayList();
          
        ArrayList<Component> subListRight = new ArrayList();
        ArrayList<Component> subListMid = new ArrayList();
        ArrayList<Component> subListLeft = new ArrayList();
        
        subListLeft.add(addjlabel("Enter User Name",24,Color.WHITE));
        subListLeft.add(addjlabel("Enter Shipment",24,Color.WHITE));
        subListLeft.add(addjlabel("Enter Destination",24,Color.WHITE));
        subListLeft.add(addjlabel("Enter Organization",24,Color.WHITE));
         subListLeft.add(addjlabel("Enter Status",24,Color.WHITE));

       
       ArrayList<Component> left = new ArrayList();
       ArrayList<Component> mid = new ArrayList();

       ArrayList<Component> right = new ArrayList();

        
        tfName=addTxtfield(450,60);
        tfShipMent=addTxtfield(450,60);
        tfCountry =  addTxtfield(450,60);
        tfOrganize=addTxtfield(450,60);
        tfStatus=addTxtfield(450,60);

        subListRight.add(tfName);
        subListRight.add(tfShipMent);
        subListRight.add(tfCountry);
        subListRight.add(tfOrganize);
        subListRight.add(tfStatus);

        
        subListMid.add(addButton("Add Record",450,60,new Color(0xcfa62),SendData()));
        subListMid.add(Error_Lab);

        addTransaction_User.add(addjpanel(new Color(0xaaca),FlowLayout.CENTER,50,50,350,600,subListLeft));
        addTransaction_User.add(addjpanel(new Color(0xaaca),FlowLayout.CENTER,20,50,650,600,subListRight));
        addTransaction_User.add(addjpanel(new Color(0xaaca),FlowLayout.CENTER,20,50,500,200,subListMid));

        data.setPreferredSize(new Dimension(1400,900));
        data.add("<html> <h1 style='padding:10px;'> Add Transaction </h1> </html>",addjpanel(new Color(0xaaca),FlowLayout.CENTER,20,150,500,900,addTransaction_User));
        data.add("<html> <h1 style='padding:10px;'> Manage Transaction </h1> </html>",addjpanel(new Color(0xaaca),FlowLayout.CENTER,40,50,350,900,ComponentList3));
        ComponentList2.add(data);
        this.add(addjpanel(new Color(0xaaca),FlowLayout.CENTER,35,20,400,920,ComponentList));
        this.add(addjpanel(Config.bgColor,FlowLayout.CENTER,10,300,1400,900,ComponentList2));
        
        init(aps);
    }
   public ActionListener Manage_User_Data()
      {
          return (new ActionListener()
                  {
                      public void actionPerformed(ActionEvent e)
                      {

                          root.setContentPane(   new admin_ManageUsers(root,aps));

                      }
                  }
              );
      }
    
        public ActionListener Manage_User_Info()
      {
          return (new ActionListener()
                  {
                      public void actionPerformed(ActionEvent e)
                      {

                          root.setContentPane(   new admin_ManageUserAccounts(root,aps));

                      }
                  }
              );
      }
     public ActionListener Manage_Hub()
      {
          return (new ActionListener()
                  {
                      public void actionPerformed(ActionEvent e)
                      {

                          root.setContentPane(   new admin_ManageHubAccounts(root,aps));

                      }
                  }
              );
      }
      public ActionListener Manage_Enterprise()
      {
          return (new ActionListener()
                  {
                      public void actionPerformed(ActionEvent e)
                      {

                          root.setContentPane(   new admin_ManageEnterprise(root,aps));

                      }
                  }
              );
      }
       public ActionListener Manage_Organization()
      {
          return (new ActionListener()
                  {
                      public void actionPerformed(ActionEvent e)
                      {

                          root.setContentPane(   new admin_ManageOrganization(root,aps));

                      }
                  }
              );
      }
        public ActionListener Manage_Logger()
      {
          return (new ActionListener()
                  {
                      public void actionPerformed(ActionEvent e)
                      {

                          root.setContentPane(   new admin_Manage_Logger(root,aps));

                      }
                  }
              );
      }
         public ActionListener Manage_DeliveryAgent()
      {
          return (new ActionListener()
                  {
                      public void actionPerformed(ActionEvent e)
                      {

                          root.setContentPane(   new admin_Manage_DeliveryAgent(root,aps));

                      }
                  }
              );
      }
         
             public ActionListener Manage_GroundCenter()
      {
          return (new ActionListener()
                  {
                      public void actionPerformed(ActionEvent e)
                      {

                          root.setContentPane(   new admin_Manage_Ground_Center(root,aps));

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
                           
                          UserName = tfName.getText();
                          Shipment = tfShipMent.getText();
                          Destomatopm = tfCountry.getText();
                          Organization = tfOrganize.getText();
                          Status = tfShipMent.getText();

     
                          
                         
                          
                            if(UserName.equals("")  )
                            {
                                  Error_Lab.setText("Item Name Cant Be Empty");
                                   Error_Lab.setForeground(Config.warningColor);
                                return;
                            }
                             if(Destomatopm.equals("")  )
                            {
                                  Error_Lab.setText("Item Name Cant Be Empty");
                                   Error_Lab.setForeground(Config.warningColor);
                                return;
                            }
                             if(Shipment.equals("")  )
                            {
                                  Error_Lab.setText("Item Name Cant Be Empty");
                                   Error_Lab.setForeground(Config.warningColor);
                                return;
                            }
                               if(Organization.equals("")  )
                            {
                                  Error_Lab.setText("Item Must Belong to a category");
                                   Error_Lab.setForeground(Config.warningColor);
                                return;
                            }
                              if(Status.equals("")  )
                            {
                                  Error_Lab.setText("Item Must Belong to a category");
                                   Error_Lab.setForeground(Config.warningColor);
                                return;
                            }
                             
                             
                               root.appManager.Db.Inserthub(UserName,Shipment,Destomatopm,Organization,Status,aps.Db.Hub);

                         switchScene(Config.Home_Scene_Admin);
                        
                    }
                }
            );
       
    }
    public ActionListener ManageUsers()
      {
          return (new ActionListener()
                  {
                      public void actionPerformed(ActionEvent e)
                      {

                          root.setContentPane(   new admin_ManageUsers(root,aps));

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
                      
                         switchScene(Config.Home_Scene_Admin);
                        
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


//enterprise


class admin_ManageEnterprise extends JPanel implements Scenes
{
    private AppWindow root;
    JButton donate ;
   
    DefaultTableModel model ;

     String UserName ;
    String Password;
    String Country;
    String City;
    int PinCode;
    String ShipMent;

    JTextField tfName ;
    JPasswordField tfPassword ;
    JTextField tfCountry ;
    JTextField tfCity ;
    JTextField tfPinCode ;
        JTextField tfShipMent ;

    
    AppStateManager aps;
        String[] columnNames = new String[]{ "User Name","User Password","Country","City","PinCode","ShipMent"};
   Object[][] TableData = new Object[][]{};

    JLabel Error_Lab=addjlabel("Please Fill Details to Donate",20,Color.WHITE);
    JTabbedPane data ;
    admin_ManageEnterprise(AppWindow root,AppStateManager aps)
    {
        
        this.aps=aps;
        data = new JTabbedPane();
        this.root=root;       
        this.setBackground(Config.bgColor);
        ArrayList<Component> ComponentList2 = new ArrayList();
          ArrayList<Component> ComponentList = new ArrayList();
                  ArrayList<Component> ComponentList3 = new ArrayList();

        model = new DefaultTableModel(TableData,columnNames);    
              for (int i = 0; i < aps.Db.getTotalUser(aps.Db.Enterprise); i++) 
        {
                    Vector<Object> tt = new Vector<Object>();

                System.out.println("i "+i);
               tt.add(aps.Db.GetAllwithDb(i,"UserName",aps.Db.Enterprise));
                tt.add(aps.Db.GetAllwithDb(i,"Password",aps.Db.Enterprise));
                tt.add(aps.Db.GetAllwithDb(i,"Country",aps.Db.Enterprise));
                tt.add(aps.Db.GetAllwithDb(i,"City",aps.Db.Enterprise));
                tt.add(aps.Db.GetAllwithDb(i,"PinCode",aps.Db.Enterprise));
                tt.add(aps.Db.GetAllwithDb(i,"Shipment",aps.Db.Enterprise));
                System.out.println("inside tt we got : "+tt);
                model.insertRow(0,tt);

        }
        
        
        
        
         JTable jt = new JTable();
         jt.setModel(model);
         
        DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
        centerRenderer.setHorizontalAlignment(JLabel.CENTER);

         
        this.setLayout(new FlowLayout(FlowLayout.LEADING,20,40));
         for(int j=0;j<jt.getColumnCount();j++)
        {
            jt.getColumnModel().getColumn(j).setCellRenderer(centerRenderer);
        }
         
         
//         
//        ComponentList2.add(addButton("Home",300,60,new Color(0xcfa62),GoBack()));
//        ComponentList2.add(addButton("Manage User Data",300,60,new Color(0xcfa62),ManageUsers()));
//        ComponentList2.add(addButton("Manage Users",300,60,new Color(0xcfa62),SendtoData()));
//        ComponentList2.add(addButton("Manage Hubs",300,60,Config.selectColor));
//        ComponentList2.add(addButton("Manage Enterprises",300,60,new Color(0xcfa62)));
//        ComponentList2.add(addButton("Manage Organizations",300,60,new Color(0xcfa62)));
//        ComponentList2.add(addButton("Manage Loggers",300,60,new Color(0xcfa62)));
//        ComponentList2.add(addButton("Log Out",300,60,new Color(0xcfa62),logout(aps)));
//        
          
                  
          ComponentList.add(addButton("Home",300,50,new Color(0xcfa62),GoBack()));
          ComponentList.add(addButton("Manage User Data",300,50,new Color(0xcfa62),this.Manage_User_Data()));
          ComponentList.add(addButton("Manage Users",300,50,new Color(0xcfa62),this.Manage_User_Info()));
          ComponentList.add(addButton("Manage Hubs",300,50,new Color(0xcfa62),this.Manage_Hub()));
          ComponentList.add(addButton("Manage Enterprises",300,50,Config.selectColor,this.Manage_Enterprise()));
          ComponentList.add(addButton("Manage Organizations",300,50,new Color(0xcfa62),this.Manage_Organization()));
           ComponentList.add(addButton("Manage Delivery Agent",300,50,new Color(0xcfa62),this.Manage_DeliveryAgent()));
          ComponentList.add(addButton("Manage Loggers",300,50,new Color(0xcfa62),Manage_Logger()));
          ComponentList.add(addButton("Manage Ground Center",300,50,new Color(0xcfa62),this.Manage_GroundCenter()));
          ComponentList.add(addButton("Log Out",300,50,new Color(0xcfa62),this.logout(aps)));
        
          jt.getTableHeader().setReorderingAllowed(false);
        jt.setRowHeight(50);
        jt.getTableHeader().setResizingAllowed(false);
        
        
         
        JScrollPane jc = new JScrollPane(jt);
        jc.setPreferredSize(new Dimension(1350, 750));
        ComponentList3.add(jc);

        
        
       ArrayList<Component> addTransaction_User = new ArrayList();
          
        ArrayList<Component> subListRight = new ArrayList();
        ArrayList<Component> subListMid = new ArrayList();
        ArrayList<Component> subListLeft = new ArrayList();
        
        subListLeft.add(addjlabel("Enter User Name",24,Color.WHITE));
        subListLeft.add(addjlabel("Enter Password",24,Color.WHITE));
        subListLeft.add(addjlabel("Enter Country",24,Color.WHITE));
        subListLeft.add(addjlabel("Enter City",24,Color.WHITE));
        subListLeft.add(addjlabel("Enter Pin Code",24,Color.WHITE));
        subListLeft.add(addjlabel("Enter Shipment",24,Color.WHITE));

       
       ArrayList<Component> left = new ArrayList();
       ArrayList<Component> mid = new ArrayList();

       ArrayList<Component> right = new ArrayList();

        
        tfName=addTxtfield(450,60);
        tfPassword=addPassfield(450,60);
        tfCountry =  addTxtfield(450,60);
        tfCity=addTxtfield(450,60);
        tfPinCode=addTxtfield(450,60);
        tfShipMent=addTxtfield(450,60);

        subListRight.add(tfName);
        subListRight.add(tfPassword);
        subListRight.add(tfCountry);
        subListRight.add(tfCity);
        subListRight.add(tfPinCode);
        subListRight.add(tfShipMent);

        
        subListMid.add(addButton("Add Record",450,60,new Color(0xcfa62),SendData()));
        subListMid.add(Error_Lab);

        addTransaction_User.add(addjpanel(new Color(0xaaca),FlowLayout.CENTER,50,50,350,600,subListLeft));
        addTransaction_User.add(addjpanel(new Color(0xaaca),FlowLayout.CENTER,20,50,650,600,subListRight));
        addTransaction_User.add(addjpanel(new Color(0xaaca),FlowLayout.CENTER,20,50,500,200,subListMid));

       data.setPreferredSize(new Dimension(1400,900));
        data.add("<html> <h1 style='padding:10px;'> Add Transaction </h1> </html>",addjpanel(new Color(0xaaca),FlowLayout.CENTER,20,150,500,900,addTransaction_User));
        data.add("<html> <h1 style='padding:10px;'> Manage Transaction </h1> </html>",addjpanel(new Color(0xaaca),FlowLayout.CENTER,40,50,350,900,ComponentList3));
        ComponentList2.add(data);
        this.add(addjpanel(new Color(0xaaca),FlowLayout.CENTER,35,20,400,920,ComponentList));
        this.add(addjpanel(Config.bgColor,FlowLayout.CENTER,10,300,1400,900,ComponentList2));
        
        init(aps);
    }
     public ActionListener Manage_User_Data()
      {
          return (new ActionListener()
                  {
                      public void actionPerformed(ActionEvent e)
                      {

                          root.setContentPane(   new admin_ManageUsers(root,aps));

                      }
                  }
              );
      }
    
        public ActionListener Manage_User_Info()
      {
          return (new ActionListener()
                  {
                      public void actionPerformed(ActionEvent e)
                      {

                          root.setContentPane(   new admin_ManageUserAccounts(root,aps));

                      }
                  }
              );
      }
     public ActionListener Manage_Hub()
      {
          return (new ActionListener()
                  {
                      public void actionPerformed(ActionEvent e)
                      {

                          root.setContentPane(   new admin_ManageHubAccounts(root,aps));

                      }
                  }
              );
      }
      public ActionListener Manage_Enterprise()
      {
          return (new ActionListener()
                  {
                      public void actionPerformed(ActionEvent e)
                      {

                          root.setContentPane(   new admin_ManageEnterprise(root,aps));

                      }
                  }
              );
      }
       public ActionListener Manage_Organization()
      {
          return (new ActionListener()
                  {
                      public void actionPerformed(ActionEvent e)
                      {

                          root.setContentPane(   new admin_ManageOrganization(root,aps));

                      }
                  }
              );
      }
        public ActionListener Manage_Logger()
      {
          return (new ActionListener()
                  {
                      public void actionPerformed(ActionEvent e)
                      {

                          root.setContentPane(   new admin_Manage_Logger(root,aps));

                      }
                  }
              );
      }
         public ActionListener Manage_DeliveryAgent()
      {
          return (new ActionListener()
                  {
                      public void actionPerformed(ActionEvent e)
                      {

                          root.setContentPane(   new admin_Manage_DeliveryAgent(root,aps));

                      }
                  }
              );
      }
         
             public ActionListener Manage_GroundCenter()
      {
          return (new ActionListener()
                  {
                      public void actionPerformed(ActionEvent e)
                      {

                          root.setContentPane(   new admin_Manage_Ground_Center(root,aps));

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
                           
                          UserName = tfName.getText();
                          Password = tfPassword.getText();
                          Country = tfCountry.getText();
                          City = tfCity.getText();
                          ShipMent = tfShipMent.getText();
           
                          
                            try{
                                 PinCode = Integer.parseInt(tfPinCode.getText());
                            }catch(Exception ee){
                                   Error_Lab.setText("Quantity Can Only be In Numbers");
                                   Error_Lab.setForeground(Config.warningColor);
                                return;
                            }
                          
                            if(UserName.equals("")  )
                            {
                                  Error_Lab.setText("Item Name Cant Be Empty");
                                   Error_Lab.setForeground(Config.warningColor);
                                return;
                            }
                             if(Country.equals("")  )
                            {
                                  Error_Lab.setText("Item Name Cant Be Empty");
                                   Error_Lab.setForeground(Config.warningColor);
                                return;
                            }
                             if(Password.equals("")  )
                            {
                                  Error_Lab.setText("Item Name Cant Be Empty");
                                   Error_Lab.setForeground(Config.warningColor);
                                return;
                            }
                               if(City.equals("")  )
                            {
                                  Error_Lab.setText("Item Must Belong to a category");
                                   Error_Lab.setForeground(Config.warningColor);
                                return;
                            }
                              if(City.equals("")  )
                            {
                                  Error_Lab.setText("Item Must Belong to a category");
                                   Error_Lab.setForeground(Config.warningColor);
                                return;
                            }
                             
                             
                            root.appManager.Db.InsertUserspecficEnterPrise(UserName,Password,Country,City,PinCode,ShipMent,aps.Db.Enterprise);

                         switchScene(Config.Home_Scene_Admin);
                        
                    }
                }
            );
       
    }
    public ActionListener ManageUsers()
      {
          return (new ActionListener()
                  {
                      public void actionPerformed(ActionEvent e)
                      {

                          root.setContentPane(   new admin_ManageUsers(root,aps));

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
                      
                         switchScene(Config.Home_Scene_Admin);
                        
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


//organization


class admin_ManageOrganization extends JPanel implements Scenes
{
    private AppWindow root;
    JButton donate ;
   
    DefaultTableModel model ;

     String UserName ;
    String Password;
    String Country;
    String City;
    int PinCode;
    String ShipMent;

    JTextField tfName ;
    JPasswordField tfPassword ;
    JTextField tfCountry ;
    JTextField tfCity ;
    JTextField tfPinCode ;
        JTextField tfShipMent ;

    
    AppStateManager aps;
        String[] columnNames = new String[]{ "User Name","User Password","Country","City","PinCode","ShipMent"};
   Object[][] TableData = new Object[][]{};

    JLabel Error_Lab=addjlabel("Please Fill Details to Donate",20,Color.WHITE);
    JTabbedPane data ;
    admin_ManageOrganization(AppWindow root,AppStateManager aps)
    {
        
        this.aps=aps;
        data = new JTabbedPane();
        this.root=root;       
        this.setBackground(Config.bgColor);
        ArrayList<Component> ComponentList2 = new ArrayList();
          ArrayList<Component> ComponentList = new ArrayList();
                  ArrayList<Component> ComponentList3 = new ArrayList();

        model = new DefaultTableModel(TableData,columnNames);

        
              for (int i = 0; i < aps.Db.getTotalUser(aps.Db.Organization); i++) 
        {
                    Vector<Object> tt = new Vector<Object>();

                System.out.println("i "+i);
                 tt.add(aps.Db.GetAllwithDb(i,"UserName",aps.Db.Organization));
                tt.add(aps.Db.GetAllwithDb(i,"Password",aps.Db.Organization));
                tt.add(aps.Db.GetAllwithDb(i,"Country",aps.Db.Organization));
                tt.add(aps.Db.GetAllwithDb(i,"City",aps.Db.Organization));
                tt.add(aps.Db.GetAllwithDb(i,"PinCode",aps.Db.Organization));
                tt.add(aps.Db.GetAllwithDb(i,"Shipment",aps.Db.Organization));
                
                model.insertRow(0,tt);

        }
        
        
        
        
         JTable jt = new JTable();
         jt.setModel(model);
         
        DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
        centerRenderer.setHorizontalAlignment(JLabel.CENTER);

         
        this.setLayout(new FlowLayout(FlowLayout.LEADING,20,40));
         for(int j=0;j<jt.getColumnCount();j++)
        {
            jt.getColumnModel().getColumn(j).setCellRenderer(centerRenderer);
        }
         
         
//         
//        ComponentList2.add(addButton("Home",300,60,new Color(0xcfa62),GoBack()));
//        ComponentList2.add(addButton("Manage User Data",300,60,new Color(0xcfa62),ManageUsers()));
//        ComponentList2.add(addButton("Manage Users",300,60,new Color(0xcfa62),SendtoData()));
//        ComponentList2.add(addButton("Manage Hubs",300,60,Config.selectColor));
//        ComponentList2.add(addButton("Manage Enterprises",300,60,new Color(0xcfa62)));
//        ComponentList2.add(addButton("Manage Organizations",300,60,new Color(0xcfa62)));
//        ComponentList2.add(addButton("Manage Loggers",300,60,new Color(0xcfa62)));
//        ComponentList2.add(addButton("Log Out",300,60,new Color(0xcfa62),logout(aps)));
//        
          
           
                 
          ComponentList.add(addButton("Home",300,50,new Color(0xcfa62),GoBack()));
          ComponentList.add(addButton("Manage User Data",300,50,new Color(0xcfa62),this.Manage_User_Data()));
          ComponentList.add(addButton("Manage Users",300,50,new Color(0xcfa62),this.Manage_User_Info()));
          ComponentList.add(addButton("Manage Hubs",300,50,new Color(0xcfa62),this.Manage_Hub()));
          ComponentList.add(addButton("Manage Enterprises",300,50,new Color(0xcfa62),this.Manage_Enterprise()));
          ComponentList.add(addButton("Manage Organizations",300,50,Config.selectColor,this.Manage_Organization()));
            ComponentList.add(addButton("Manage Delivery Agent",300,50,new Color(0xcfa62),this.Manage_DeliveryAgent()));
          ComponentList.add(addButton("Manage Loggers",300,50,new Color(0xcfa62),Manage_Logger()));
          ComponentList.add(addButton("Manage Ground Center",300,50,new Color(0xcfa62),this.Manage_GroundCenter()));
          ComponentList.add(addButton("Log Out",300,50,new Color(0xcfa62),this.logout(aps)));
        
        
        jt.getTableHeader().setReorderingAllowed(false);
        jt.setRowHeight(50);
        jt.getTableHeader().setResizingAllowed(false);
  
        
        
         
        JScrollPane jc = new JScrollPane(jt);
        jc.setPreferredSize(new Dimension(1350, 750));
        ComponentList3.add(jc);

        
        
       ArrayList<Component> addTransaction_User = new ArrayList();
          
        ArrayList<Component> subListRight = new ArrayList();
        ArrayList<Component> subListMid = new ArrayList();
        ArrayList<Component> subListLeft = new ArrayList();
        
        subListLeft.add(addjlabel("Enter User Name",24,Color.WHITE));
        subListLeft.add(addjlabel("Enter Password",24,Color.WHITE));
        subListLeft.add(addjlabel("Enter Country",24,Color.WHITE));
        subListLeft.add(addjlabel("Enter City",24,Color.WHITE));
        subListLeft.add(addjlabel("Enter Pin Code",24,Color.WHITE));
            subListLeft.add(addjlabel("Enter Shipment",24,Color.WHITE));

       
       ArrayList<Component> left = new ArrayList();
       ArrayList<Component> mid = new ArrayList();

       ArrayList<Component> right = new ArrayList();

        
        tfName=addTxtfield(450,60);
        tfPassword=addPassfield(450,60);
        tfCountry =  addTxtfield(450,60);
        tfCity=addTxtfield(450,60);
        tfPinCode=addTxtfield(450,60);
        tfShipMent=addTxtfield(450,60);

        subListRight.add(tfName);
        subListRight.add(tfPassword);
        subListRight.add(tfCountry);
        subListRight.add(tfCity);
        subListRight.add(tfPinCode);
        subListRight.add(tfShipMent);

        
        subListMid.add(addButton("Add Record",450,60,new Color(0xcfa62),SendData()));
        subListMid.add(Error_Lab);

        addTransaction_User.add(addjpanel(new Color(0xaaca),FlowLayout.CENTER,50,50,350,600,subListLeft));
        addTransaction_User.add(addjpanel(new Color(0xaaca),FlowLayout.CENTER,20,50,650,600,subListRight));
        addTransaction_User.add(addjpanel(new Color(0xaaca),FlowLayout.CENTER,20,50,500,200,subListMid));

       data.setPreferredSize(new Dimension(1400,900));
        data.add("<html> <h1 style='padding:10px;'> Add Transaction </h1> </html>",addjpanel(new Color(0xaaca),FlowLayout.CENTER,20,150,500,900,addTransaction_User));
        data.add("<html> <h1 style='padding:10px;'> Manage Transaction </h1> </html>",addjpanel(new Color(0xaaca),FlowLayout.CENTER,40,50,350,900,ComponentList3));
        ComponentList2.add(data);
        this.add(addjpanel(new Color(0xaaca),FlowLayout.CENTER,35,20,400,920,ComponentList));
        this.add(addjpanel(Config.bgColor,FlowLayout.CENTER,10,300,1400,900,ComponentList2));
        
        init(aps);
    }
    public ActionListener Manage_User_Data()
      {
          return (new ActionListener()
                  {
                      public void actionPerformed(ActionEvent e)
                      {

                          root.setContentPane(   new admin_ManageUsers(root,aps));

                      }
                  }
              );
      }
    
        public ActionListener Manage_User_Info()
      {
          return (new ActionListener()
                  {
                      public void actionPerformed(ActionEvent e)
                      {

                          root.setContentPane(   new admin_ManageUserAccounts(root,aps));

                      }
                  }
              );
      }
     public ActionListener Manage_Hub()
      {
          return (new ActionListener()
                  {
                      public void actionPerformed(ActionEvent e)
                      {

                          root.setContentPane(   new admin_ManageHubAccounts(root,aps));

                      }
                  }
              );
      }
      public ActionListener Manage_Enterprise()
      {
          return (new ActionListener()
                  {
                      public void actionPerformed(ActionEvent e)
                      {

                          root.setContentPane(   new admin_ManageEnterprise(root,aps));

                      }
                  }
              );
      }
       public ActionListener Manage_Organization()
      {
          return (new ActionListener()
                  {
                      public void actionPerformed(ActionEvent e)
                      {

                          root.setContentPane(   new admin_ManageOrganization(root,aps));

                      }
                  }
              );
      }
        public ActionListener Manage_Logger()
      {
          return (new ActionListener()
                  {
                      public void actionPerformed(ActionEvent e)
                      {

                          root.setContentPane(   new admin_Manage_Logger(root,aps));

                      }
                  }
              );
      }
         public ActionListener Manage_DeliveryAgent()
      {
          return (new ActionListener()
                  {
                      public void actionPerformed(ActionEvent e)
                      {

                          root.setContentPane(   new admin_Manage_DeliveryAgent(root,aps));

                      }
                  }
              );
      }
         
             public ActionListener Manage_GroundCenter()
      {
          return (new ActionListener()
                  {
                      public void actionPerformed(ActionEvent e)
                      {

                          root.setContentPane(   new admin_Manage_Ground_Center(root,aps));

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
                           
                          UserName = tfName.getText();
                          Password = tfPassword.getPassword().toString();
                          Country = tfCountry.getText();
                          City = tfCity.getText();
                          ShipMent = tfShipMent.getText();
           
                          
                            try{
                                 PinCode = Integer.parseInt(tfPinCode.getText());
                            }catch(Exception ee){
                                   Error_Lab.setText("Quantity Can Only be In Numbers");
                                   Error_Lab.setForeground(Config.warningColor);
                                return;
                            }
                          
                            if(UserName.equals("")  )
                            {
                                  Error_Lab.setText("Item Name Cant Be Empty");
                                   Error_Lab.setForeground(Config.warningColor);
                                return;
                            }
                             if(Country.equals("")  )
                            {
                                  Error_Lab.setText("Item Name Cant Be Empty");
                                   Error_Lab.setForeground(Config.warningColor);
                                return;
                            }
                             if(Password.equals("")  )
                            {
                                  Error_Lab.setText("Item Name Cant Be Empty");
                                   Error_Lab.setForeground(Config.warningColor);
                                return;
                            }
                               if(City.equals("")  )
                            {
                                  Error_Lab.setText("Item Must Belong to a category");
                                   Error_Lab.setForeground(Config.warningColor);
                                return;
                            }
                              if(City.equals("")  )
                            {
                                  Error_Lab.setText("Item Must Belong to a category");
                                   Error_Lab.setForeground(Config.warningColor);
                                return;
                            }
                             
                             
                               root.appManager.Db.InsertUserspecficOrganize(UserName,Password,Country,City,PinCode,ShipMent,aps.Db.Organization);

                         switchScene(Config.Home_Scene_Admin);
                        
                    }
                }
            );
       
    }
    public ActionListener ManageUsers()
      {
          return (new ActionListener()
                  {
                      public void actionPerformed(ActionEvent e)
                      {

                          root.setContentPane(   new admin_ManageUsers(root,aps));

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
                      
                         switchScene(Config.Home_Scene_Admin);
                        
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
//logger


class admin_Manage_Logger extends JPanel implements Scenes
{
    private AppWindow root;
    JButton donate ;
   
    DefaultTableModel model ;

     String UserName ;
    String Password;
    String Country;
    String City;
    int PinCode;
    String ShipMent;

    JTextField tfName ;
    JPasswordField tfPassword ;
    JTextField tfCountry ;
    JTextField tfCity ;
    JTextField tfPinCode ;
        JTextField tfShipMent ;

    
    AppStateManager aps;
        String[] columnNames = new String[]{ "User Name","User Password","Country","City","PinCode","ShipMent"};
   Object[][] TableData = new Object[][]{};

    JLabel Error_Lab=addjlabel("Please Fill Details to Donate",20,Color.WHITE);
    JTabbedPane data ;
    admin_Manage_Logger(AppWindow root,AppStateManager aps)
    {
        
        this.aps=aps;
        data = new JTabbedPane();
        this.root=root;       
        this.setBackground(Config.bgColor);
        ArrayList<Component> ComponentList2 = new ArrayList();
          ArrayList<Component> ComponentList = new ArrayList();
                  ArrayList<Component> ComponentList3 = new ArrayList();

        model = new DefaultTableModel(TableData,columnNames);

        
              for (int i = 0; i < aps.Db.getTotalUser(aps.Db.Logger); i++) 
        {
                    Vector<Object> tt = new Vector<Object>();

                System.out.println("i "+i);
                  tt.add(aps.Db.GetAllwithDb(i,"UserName",aps.Db.Logger));
                tt.add(aps.Db.GetAllwithDb(i,"Password",aps.Db.Logger));
                tt.add(aps.Db.GetAllwithDb(i,"Country",aps.Db.Logger));
                tt.add(aps.Db.GetAllwithDb(i,"City",aps.Db.Logger));
                tt.add(aps.Db.GetAllwithDb(i,"PinCode",aps.Db.Logger));
                tt.add(aps.Db.GetAllwithDb(i,"Shipment",aps.Db.Logger));
                
                model.insertRow(0,tt);

        }
        
        
        
        
         JTable jt = new JTable();
         jt.setModel(model);
         
        DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
        centerRenderer.setHorizontalAlignment(JLabel.CENTER);

         
        this.setLayout(new FlowLayout(FlowLayout.LEADING,20,40));
         for(int j=0;j<jt.getColumnCount();j++)
        {
            jt.getColumnModel().getColumn(j).setCellRenderer(centerRenderer);
        }
         
         
//         
//        ComponentList2.add(addButton("Home",300,60,new Color(0xcfa62),GoBack()));
//        ComponentList2.add(addButton("Manage User Data",300,60,new Color(0xcfa62),ManageUsers()));
//        ComponentList2.add(addButton("Manage Users",300,60,new Color(0xcfa62),SendtoData()));
//        ComponentList2.add(addButton("Manage Hubs",300,60,Config.selectColor));
//        ComponentList2.add(addButton("Manage Enterprises",300,60,new Color(0xcfa62)));
//        ComponentList2.add(addButton("Manage Organizations",300,60,new Color(0xcfa62)));
//        ComponentList2.add(addButton("Manage Loggers",300,60,new Color(0xcfa62)));
//        ComponentList2.add(addButton("Log Out",300,60,new Color(0xcfa62),logout(aps)));
//        
//   
               
           
                   
          ComponentList.add(addButton("Home",300,50,new Color(0xcfa62),GoBack()));
          ComponentList.add(addButton("Manage User Data",300,50,new Color(0xcfa62),this.Manage_User_Data()));
          ComponentList.add(addButton("Manage Users",300,50,new Color(0xcfa62),this.Manage_User_Info()));
          ComponentList.add(addButton("Manage Hubs",300,50,new Color(0xcfa62),this.Manage_Hub()));
          ComponentList.add(addButton("Manage Enterprises",300,50,new Color(0xcfa62),this.Manage_Enterprise()));
          ComponentList.add(addButton("Manage Organizations",300,50,new Color(0xcfa62),this.Manage_Organization()));
          ComponentList.add(addButton("Manage Delivery Agent",300,50,new Color(0xcfa62),this.Manage_DeliveryAgent()));
          ComponentList.add(addButton("Manage Loggers",300,50,Config.selectColor,this.Manage_Logger()));
          ComponentList.add(addButton("Manage Ground Center",300,50,new Color(0xcfa62),this.Manage_GroundCenter()));
          ComponentList.add(addButton("Log Out",300,50,new Color(0xcfa62),this.logout(aps)));
          
        jt.getTableHeader().setReorderingAllowed(false);
        jt.setRowHeight(50);
        jt.getTableHeader().setResizingAllowed(false);      
        
         
        JScrollPane jc = new JScrollPane(jt);
        jc.setPreferredSize(new Dimension(1350, 750));
        ComponentList3.add(jc);

        
        
       ArrayList<Component> addTransaction_User = new ArrayList();
          
        ArrayList<Component> subListRight = new ArrayList();
        ArrayList<Component> subListMid = new ArrayList();
        ArrayList<Component> subListLeft = new ArrayList();
        
        subListLeft.add(addjlabel("Enter User Name",24,Color.WHITE));
        subListLeft.add(addjlabel("Enter Password",24,Color.WHITE));
        subListLeft.add(addjlabel("Enter Country",24,Color.WHITE));
        subListLeft.add(addjlabel("Enter City",24,Color.WHITE));
        subListLeft.add(addjlabel("Enter Pin Code",24,Color.WHITE));
            subListLeft.add(addjlabel("Enter Shipment",24,Color.WHITE));

       
       ArrayList<Component> left = new ArrayList();
       ArrayList<Component> mid = new ArrayList();

       ArrayList<Component> right = new ArrayList();

        
        tfName=addTxtfield(450,60);
        tfPassword=addPassfield(450,60);
        tfCountry =  addTxtfield(450,60);
        tfCity=addTxtfield(450,60);
        tfPinCode=addTxtfield(450,60);
        tfShipMent=addTxtfield(450,60);

        subListRight.add(tfName);
        subListRight.add(tfPassword);
        subListRight.add(tfCountry);
        subListRight.add(tfCity);
        subListRight.add(tfPinCode);
        subListRight.add(tfShipMent);

        
        subListMid.add(addButton("Add Record",450,60,new Color(0xcfa62),SendData()));
        subListMid.add(Error_Lab);

        addTransaction_User.add(addjpanel(new Color(0xaaca),FlowLayout.CENTER,50,50,350,600,subListLeft));
        addTransaction_User.add(addjpanel(new Color(0xaaca),FlowLayout.CENTER,20,50,650,600,subListRight));
        addTransaction_User.add(addjpanel(new Color(0xaaca),FlowLayout.CENTER,20,50,500,200,subListMid));

       data.setPreferredSize(new Dimension(1400,900));
        data.add("<html> <h1 style='padding:10px;'> Add Transaction </h1> </html>",addjpanel(new Color(0xaaca),FlowLayout.CENTER,20,150,500,900,addTransaction_User));
        data.add("<html> <h1 style='padding:10px;'> Manage Transaction </h1> </html>",addjpanel(new Color(0xaaca),FlowLayout.CENTER,40,50,350,900,ComponentList3));
        ComponentList2.add(data);
        this.add(addjpanel(new Color(0xaaca),FlowLayout.CENTER,35,20,400,920,ComponentList));
        this.add(addjpanel(Config.bgColor,FlowLayout.CENTER,10,300,1400,900,ComponentList2));
        
        init(aps);
    }
   public ActionListener Manage_User_Data()
      {
          return (new ActionListener()
                  {
                      public void actionPerformed(ActionEvent e)
                      {

                          root.setContentPane(   new admin_ManageUsers(root,aps));

                      }
                  }
              );
      }
    
        public ActionListener Manage_User_Info()
      {
          return (new ActionListener()
                  {
                      public void actionPerformed(ActionEvent e)
                      {

                          root.setContentPane(   new admin_ManageUserAccounts(root,aps));

                      }
                  }
              );
      }
     public ActionListener Manage_Hub()
      {
          return (new ActionListener()
                  {
                      public void actionPerformed(ActionEvent e)
                      {

                          root.setContentPane(   new admin_ManageHubAccounts(root,aps));

                      }
                  }
              );
      }
      public ActionListener Manage_Enterprise()
      {
          return (new ActionListener()
                  {
                      public void actionPerformed(ActionEvent e)
                      {

                          root.setContentPane(   new admin_ManageEnterprise(root,aps));

                      }
                  }
              );
      }
       public ActionListener Manage_Organization()
      {
          return (new ActionListener()
                  {
                      public void actionPerformed(ActionEvent e)
                      {

                          root.setContentPane(   new admin_ManageOrganization(root,aps));

                      }
                  }
              );
      }
        public ActionListener Manage_Logger()
      {
          return (new ActionListener()
                  {
                      public void actionPerformed(ActionEvent e)
                      {

                          root.setContentPane(   new admin_Manage_Logger(root,aps));

                      }
                  }
              );
      }
         public ActionListener Manage_DeliveryAgent()
      {
          return (new ActionListener()
                  {
                      public void actionPerformed(ActionEvent e)
                      {

                          root.setContentPane(   new admin_Manage_DeliveryAgent(root,aps));

                      }
                  }
              );
      }
         
             public ActionListener Manage_GroundCenter()
      {
          return (new ActionListener()
                  {
                      public void actionPerformed(ActionEvent e)
                      {

                          root.setContentPane(   new admin_Manage_Ground_Center(root,aps));

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
                           
                          UserName = tfName.getText();
                          Password = tfPassword.getText();
                          Country = tfCountry.getText();
                          City = tfCity.getText();
                          ShipMent = tfShipMent.getText();
           
                          
                            try{
                                 PinCode = Integer.parseInt(tfPinCode.getText());
                            }catch(Exception ee){
                                   Error_Lab.setText("Quantity Can Only be In Numbers");
                                   Error_Lab.setForeground(Config.warningColor);
                                return;
                            }
                          
                            if(UserName.equals("")  )
                            {
                                  Error_Lab.setText("Item Name Cant Be Empty");
                                   Error_Lab.setForeground(Config.warningColor);
                                return;
                            }
                             if(Country.equals("")  )
                            {
                                  Error_Lab.setText("Item Name Cant Be Empty");
                                   Error_Lab.setForeground(Config.warningColor);
                                return;
                            }
                             if(Password.equals("")  )
                            {
                                  Error_Lab.setText("Item Name Cant Be Empty");
                                   Error_Lab.setForeground(Config.warningColor);
                                return;
                            }
                               if(City.equals("")  )
                            {
                                  Error_Lab.setText("Item Must Belong to a category");
                                   Error_Lab.setForeground(Config.warningColor);
                                return;
                            }
                              if(City.equals("")  )
                            {
                                  Error_Lab.setText("Item Must Belong to a category");
                                   Error_Lab.setForeground(Config.warningColor);
                                return;
                            }
                             
                             
                               root.appManager.Db.InsertUserspecfic(UserName,Password,Country,City,PinCode,ShipMent,aps.Db.Logger);

                         switchScene(Config.Home_Scene_Admin);
                        
                    }
                }
            );
       
    }
    public ActionListener ManageUsers()
      {
          return (new ActionListener()
                  {
                      public void actionPerformed(ActionEvent e)
                      {

                          root.setContentPane(   new admin_ManageUsers(root,aps));

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
                      
                         switchScene(Config.Home_Scene_Admin);
                        
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
//delivery agent 


class admin_Manage_DeliveryAgent extends JPanel implements Scenes
{
    private AppWindow root;
    JButton donate ;
   
    DefaultTableModel model ;

     String UserName ;
    String Password;
    String Country;
    String City;
    int PinCode;
    String ShipMent;

    JTextField tfName ;
    JPasswordField tfPassword ;
    JTextField tfCountry ;
    JTextField tfCity ;
    JTextField tfPinCode ;
        JTextField tfShipMent ;

    
    AppStateManager aps;
        String[] columnNames = new String[]{ "User Name","User Password","Country","City","PinCode","ShipMent"};
   Object[][] TableData = new Object[][]{};

    JLabel Error_Lab=addjlabel("Please Fill Details to Donate",20,Color.WHITE);
    JTabbedPane data ;
    admin_Manage_DeliveryAgent(AppWindow root,AppStateManager aps)
    {
        
        this.aps=aps;
        data = new JTabbedPane();
        this.root=root;       
        this.setBackground(Config.bgColor);
        ArrayList<Component> ComponentList2 = new ArrayList();
          ArrayList<Component> ComponentList = new ArrayList();
                  ArrayList<Component> ComponentList3 = new ArrayList();

        model = new DefaultTableModel(TableData,columnNames);

        
              for (int i = 0; i < aps.Db.getTotalUser(aps.Db.DeliverAgent); i++) 
        {
                    Vector<Object> tt = new Vector<Object>();

                System.out.println("i "+i);
                  tt.add(aps.Db.GetAllwithDb(i,"UserName",aps.Db.DeliverAgent));
                tt.add(aps.Db.GetAllwithDb(i,"Password",aps.Db.DeliverAgent));
                tt.add(aps.Db.GetAllwithDb(i,"Country",aps.Db.DeliverAgent));
                tt.add(aps.Db.GetAllwithDb(i,"City",aps.Db.DeliverAgent));
                tt.add(aps.Db.GetAllwithDb(i,"PinCode",aps.Db.DeliverAgent));
                tt.add(aps.Db.GetAllwithDb(i,"Shipment",aps.Db.DeliverAgent));
                
                model.insertRow(0,tt);

        }
        
        
        
        
         JTable jt = new JTable();
         jt.setModel(model);
         
        DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
        centerRenderer.setHorizontalAlignment(JLabel.CENTER);

         
        this.setLayout(new FlowLayout(FlowLayout.LEADING,20,40));
         for(int j=0;j<jt.getColumnCount();j++)
        {
            jt.getColumnModel().getColumn(j).setCellRenderer(centerRenderer);
        }
         
         
//         
//        ComponentList2.add(addButton("Home",300,60,new Color(0xcfa62),GoBack()));
//        ComponentList2.add(addButton("Manage User Data",300,60,new Color(0xcfa62),ManageUsers()));
//        ComponentList2.add(addButton("Manage Users",300,60,new Color(0xcfa62),SendtoData()));
//        ComponentList2.add(addButton("Manage Hubs",300,60,Config.selectColor));
//        ComponentList2.add(addButton("Manage Enterprises",300,60,new Color(0xcfa62)));
//        ComponentList2.add(addButton("Manage Organizations",300,60,new Color(0xcfa62)));
//        ComponentList2.add(addButton("Manage Loggers",300,60,new Color(0xcfa62)));
//        ComponentList2.add(addButton("Log Out",300,60,new Color(0xcfa62),logout(aps)));
//        
//   
               
           
            
          ComponentList.add(addButton("Home",300,50,new Color(0xcfa62),GoBack()));
          ComponentList.add(addButton("Manage User Data",300,50,new Color(0xcfa62),this.Manage_User_Data()));
          ComponentList.add(addButton("Manage Users",300,50,new Color(0xcfa62),this.Manage_User_Info()));
          ComponentList.add(addButton("Manage Hubs",300,50,new Color(0xcfa62),this.Manage_Hub()));
          ComponentList.add(addButton("Manage Enterprises",300,50,new Color(0xcfa62),this.Manage_Enterprise()));
          ComponentList.add(addButton("Manage Organizations",300,50,new Color(0xcfa62),this.Manage_Organization()));
            ComponentList.add(addButton("Manage Delivery Agent",300,50,Config.selectColor,this.Manage_DeliveryAgent()));
          ComponentList.add(addButton("Manage Loggers",300,50,new Color(0xcfa62),Manage_Logger()));
          ComponentList.add(addButton("Manage Ground Center",300,50,new Color(0xcfa62),this.Manage_GroundCenter()));
          ComponentList.add(addButton("Log Out",300,50,new Color(0xcfa62),this.logout(aps)));
        
          jt.getTableHeader().setReorderingAllowed(false);
        jt.setRowHeight(50);
        jt.getTableHeader().setResizingAllowed(false);
     
        
        
         
        JScrollPane jc = new JScrollPane(jt);
        jc.setPreferredSize(new Dimension(1350, 750));
        ComponentList3.add(jc);

        
        
       ArrayList<Component> addTransaction_User = new ArrayList();
          
        ArrayList<Component> subListRight = new ArrayList();
        ArrayList<Component> subListMid = new ArrayList();
        ArrayList<Component> subListLeft = new ArrayList();
        
        subListLeft.add(addjlabel("Enter User Name",24,Color.WHITE));
        subListLeft.add(addjlabel("Enter Password",24,Color.WHITE));
        subListLeft.add(addjlabel("Enter Country",24,Color.WHITE));
        subListLeft.add(addjlabel("Enter City",24,Color.WHITE));
        subListLeft.add(addjlabel("Enter Pin Code",24,Color.WHITE));
            subListLeft.add(addjlabel("Enter Shipment",24,Color.WHITE));

       
       ArrayList<Component> left = new ArrayList();
       ArrayList<Component> mid = new ArrayList();

       ArrayList<Component> right = new ArrayList();

        
        tfName=addTxtfield(450,60);
        tfPassword=addPassfield(450,60);
        tfCountry =  addTxtfield(450,60);
        tfCity=addTxtfield(450,60);
        tfPinCode=addTxtfield(450,60);
        tfShipMent=addTxtfield(450,60);

        subListRight.add(tfName);
        subListRight.add(tfPassword);
        subListRight.add(tfCountry);
        subListRight.add(tfCity);
        subListRight.add(tfPinCode);
        subListRight.add(tfShipMent);

        
        subListMid.add(addButton("Add Record",450,60,new Color(0xcfa62),SendData()));
        subListMid.add(Error_Lab);

        addTransaction_User.add(addjpanel(new Color(0xaaca),FlowLayout.CENTER,50,50,350,600,subListLeft));
        addTransaction_User.add(addjpanel(new Color(0xaaca),FlowLayout.CENTER,20,50,650,600,subListRight));
        addTransaction_User.add(addjpanel(new Color(0xaaca),FlowLayout.CENTER,20,50,500,200,subListMid));
        data.setPreferredSize(new Dimension(1400,900));
        data.add("<html> <h1 style='padding:10px;'> Add Transaction </h1> </html>",addjpanel(new Color(0xaaca),FlowLayout.CENTER,20,150,500,900,addTransaction_User));
        data.add("<html> <h1 style='padding:10px;'> Manage Transaction </h1> </html>",addjpanel(new Color(0xaaca),FlowLayout.CENTER,40,50,350,900,ComponentList3));
        ComponentList2.add(data);
        this.add(addjpanel(new Color(0xaaca),FlowLayout.CENTER,35,20,400,920,ComponentList));
        this.add(addjpanel(Config.bgColor,FlowLayout.CENTER,10,300,1400,900,ComponentList2));
        
        init(aps);
    }
     public ActionListener SendtoData()
      {
          return (new ActionListener()
                  {
                      public void actionPerformed(ActionEvent e)
                      {

                          root.setContentPane(   new admin_ManageUserAccounts(root,aps));

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
                           
                          UserName = tfName.getText();
                          Password = tfPassword.getText();
                          Country = tfCountry.getText();
                          City = tfCity.getText();
                          ShipMent = tfShipMent.getText();
           
                          
                            try{
                                 PinCode = Integer.parseInt(tfPinCode.getText());
                            }catch(Exception ee){
                                   Error_Lab.setText("Quantity Can Only be In Numbers");
                                   Error_Lab.setForeground(Config.warningColor);
                                return;
                            }
                          
                            if(UserName.equals("")  )
                            {
                                  Error_Lab.setText("Item Name Cant Be Empty");
                                   Error_Lab.setForeground(Config.warningColor);
                                return;
                            }
                             if(Country.equals("")  )
                            {
                                  Error_Lab.setText("Item Name Cant Be Empty");
                                   Error_Lab.setForeground(Config.warningColor);
                                return;
                            }
                             if(Password.equals("")  )
                            {
                                  Error_Lab.setText("Item Name Cant Be Empty");
                                   Error_Lab.setForeground(Config.warningColor);
                                return;
                            }
                               if(City.equals("")  )
                            {
                                  Error_Lab.setText("Item Must Belong to a category");
                                   Error_Lab.setForeground(Config.warningColor);
                                return;
                            }
                              if(City.equals("")  )
                            {
                                  Error_Lab.setText("Item Must Belong to a category");
                                   Error_Lab.setForeground(Config.warningColor);
                                return;
                            }
                             
                             
                               root.appManager.Db.InsertUserspecfic(UserName,Password,Country,City,PinCode,ShipMent,aps.Db.DeliverAgent);

                         switchScene(Config.Home_Scene_Admin);
                        
                    }
                }
            );
       
    }
  public ActionListener Manage_User_Data()
      {
          return (new ActionListener()
                  {
                      public void actionPerformed(ActionEvent e)
                      {

                          root.setContentPane(   new admin_ManageUsers(root,aps));

                      }
                  }
              );
      }
    
        public ActionListener Manage_User_Info()
      {
          return (new ActionListener()
                  {
                      public void actionPerformed(ActionEvent e)
                      {

                          root.setContentPane(   new admin_ManageUserAccounts(root,aps));

                      }
                  }
              );
      }
     public ActionListener Manage_Hub()
      {
          return (new ActionListener()
                  {
                      public void actionPerformed(ActionEvent e)
                      {

                          root.setContentPane(   new admin_ManageHubAccounts(root,aps));

                      }
                  }
              );
      }
      public ActionListener Manage_Enterprise()
      {
          return (new ActionListener()
                  {
                      public void actionPerformed(ActionEvent e)
                      {

                          root.setContentPane(   new admin_ManageEnterprise(root,aps));

                      }
                  }
              );
      }
       public ActionListener Manage_Organization()
      {
          return (new ActionListener()
                  {
                      public void actionPerformed(ActionEvent e)
                      {

                          root.setContentPane(   new admin_ManageOrganization(root,aps));

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
                      
                         switchScene(Config.Home_Scene_Admin);
                        
                    }
                }
            );
    }  
        public ActionListener Manage_Logger()
      {
          return (new ActionListener()
                  {
                      public void actionPerformed(ActionEvent e)
                      {

                          root.setContentPane(   new admin_Manage_Logger(root,aps));

                      }
                  }
              );
      }
         public ActionListener Manage_DeliveryAgent()
      {
          return (new ActionListener()
                  {
                      public void actionPerformed(ActionEvent e)
                      {

                          root.setContentPane(   new admin_Manage_DeliveryAgent(root,aps));

                      }
                  }
              );
      }
         
             public ActionListener Manage_GroundCenter()
      {
          return (new ActionListener()
                  {
                      public void actionPerformed(ActionEvent e)
                      {

                          root.setContentPane(   new admin_Manage_Ground_Center(root,aps));

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
//ground center


class admin_Manage_Ground_Center extends JPanel implements Scenes
{
    private AppWindow root;
    JButton donate ;
   
    DefaultTableModel model ;

     String UserName ;
    String Password;
    String Country;
    String City;
    int PinCode;
    String ShipMent;

    JTextField tfName ;
    JPasswordField tfPassword ;
    JTextField tfCountry ;
    JTextField tfCity ;
    JTextField tfPinCode ;
        JTextField tfShipMent ;

    
    AppStateManager aps;
        String[] columnNames = new String[]{ "User Name","User Password","Country","City","PinCode","ShipMent"};
   Object[][] TableData = new Object[][]{};

    JLabel Error_Lab=addjlabel("Please Fill Details to Donate",20,Color.WHITE);
    JTabbedPane data ;
    admin_Manage_Ground_Center(AppWindow root,AppStateManager aps)
    {
        
        this.aps=aps;
        data = new JTabbedPane();
        this.root=root;       
        this.setBackground(Config.bgColor);
        ArrayList<Component> ComponentList2 = new ArrayList();
          ArrayList<Component> ComponentList = new ArrayList();
                  ArrayList<Component> ComponentList3 = new ArrayList();

        model = new DefaultTableModel(TableData,columnNames);

        
              for (int i = 0; i < aps.Db.getTotalUser(aps.Db.GroundCenter); i++) 
        {
                    Vector<Object> tt = new Vector<Object>();

                System.out.println("i "+i);
                tt.add(aps.Db.GetAllwithDb(i,"UserName",aps.Db.GroundCenter));
                tt.add(aps.Db.GetAllwithDb(i,"Password",aps.Db.GroundCenter));
                tt.add(aps.Db.GetAllwithDb(i,"Country",aps.Db.GroundCenter));
                tt.add(aps.Db.GetAllwithDb(i,"City",aps.Db.GroundCenter));
                tt.add(aps.Db.GetAllwithDb(i,"PinCode",aps.Db.GroundCenter));
                tt.add(aps.Db.GetAllwithDb(i,"Shipment",aps.Db.GroundCenter));
                
                model.insertRow(0,tt);

        }
        
        
        
        
         JTable jt = new JTable();
         jt.setModel(model);
         
        DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
        centerRenderer.setHorizontalAlignment(JLabel.CENTER);

         
        this.setLayout(new FlowLayout(FlowLayout.LEADING,20,40));
         for(int j=0;j<jt.getColumnCount();j++)
        {
            jt.getColumnModel().getColumn(j).setCellRenderer(centerRenderer);
        }
         
         
         
//        ComponentList2.add(addButton("Home",300,60,new Color(0xcfa62),GoBack()));
//        ComponentList2.add(addButton("Manage User Data",300,60,new Color(0xcfa62),ManageUsers()));
//        ComponentList2.add(addButton("Manage Users",300,60,new Color(0xcfa62),SendtoData()));
//        ComponentList2.add(addButton("Manage Hubs",300,60,Config.selectColor));
//        ComponentList2.add(addButton("Manage Enterprises",300,60,new Color(0xcfa62)));
//        ComponentList2.add(addButton("Manage Organizations",300,60,new Color(0xcfa62)));
//        ComponentList2.add(addButton("Manage Loggers",300,60,new Color(0xcfa62)));
//        ComponentList2.add(addButton("Log Out",300,60,new Color(0xcfa62),logout(aps)));
//        
//   
               
            
          ComponentList.add(addButton("Home",300,50,new Color(0xcfa62),GoBack()));
          ComponentList.add(addButton("Manage User Data",300,50,new Color(0xcfa62),Manage_User_Data()));
          ComponentList.add(addButton("Manage Users",300,50,new Color(0xcfa62),Manage_User_Info()));
          ComponentList.add(addButton("Manage Hubs",300,50,new Color(0xcfa62),Manage_Hub()));
          ComponentList.add(addButton("Manage Enterprises",300,50,new Color(0xcfa62),Manage_Enterprise()));
          ComponentList.add(addButton("Manage Organizations",300,50,new Color(0xcfa62),Manage_Organization()));
           ComponentList.add(addButton("Manage Delivery Agent",300,50,new Color(0xcfa62),this.Manage_DeliveryAgent()));
          ComponentList.add(addButton("Manage Loggers",300,50,new Color(0xcfa62),Manage_Logger()));
          ComponentList.add(addButton("Manage Ground Center",300,50,Config.selectColor,Manage_GroundCenter()));
          ComponentList.add(addButton("Log Out",300,50,new Color(0xcfa62),logout(aps)));

          jt.getTableHeader().setReorderingAllowed(false);
        jt.setRowHeight(50);
        jt.getTableHeader().setResizingAllowed(false);
       
        
        
         
        JScrollPane jc = new JScrollPane(jt);
        jc.setPreferredSize(new Dimension(1350, 750));
        ComponentList3.add(jc);

        
        
       ArrayList<Component> addTransaction_User = new ArrayList();
          
        ArrayList<Component> subListRight = new ArrayList();
        ArrayList<Component> subListMid = new ArrayList();
        ArrayList<Component> subListLeft = new ArrayList();
        
        subListLeft.add(addjlabel("Enter User Name",24,Color.WHITE));
        subListLeft.add(addjlabel("Enter Password",24,Color.WHITE));
        subListLeft.add(addjlabel("Enter Country",24,Color.WHITE));
        subListLeft.add(addjlabel("Enter City",24,Color.WHITE));
        subListLeft.add(addjlabel("Enter Pin Code",24,Color.WHITE));
            subListLeft.add(addjlabel("Enter Shipment",24,Color.WHITE));

       
       ArrayList<Component> left = new ArrayList();
       ArrayList<Component> mid = new ArrayList();

       ArrayList<Component> right = new ArrayList();

        
        tfName=addTxtfield(450,60);
        tfPassword=addPassfield(450,60);
        tfCountry =  addTxtfield(450,60);
        tfCity=addTxtfield(450,60);
        tfPinCode=addTxtfield(450,60);
        tfShipMent=addTxtfield(450,60);

        subListRight.add(tfName);
        subListRight.add(tfPassword);
        subListRight.add(tfCountry);
        subListRight.add(tfCity);
        subListRight.add(tfPinCode);
        subListRight.add(tfShipMent);

        
        subListMid.add(addButton("Add Record",450,60,new Color(0xcfa62),SendData()));
        subListMid.add(Error_Lab);

        addTransaction_User.add(addjpanel(new Color(0xaaca),FlowLayout.CENTER,50,50,350,600,subListLeft));
        addTransaction_User.add(addjpanel(new Color(0xaaca),FlowLayout.CENTER,20,50,650,600,subListRight));
        addTransaction_User.add(addjpanel(new Color(0xaaca),FlowLayout.CENTER,20,50,500,200,subListMid));

   data.setPreferredSize(new Dimension(1400,900));
        data.add("<html> <h1 style='padding:10px;'> Add Transaction </h1> </html>",addjpanel(new Color(0xaaca),FlowLayout.CENTER,20,150,500,900,addTransaction_User));
        data.add("<html> <h1 style='padding:10px;'> Manage Transaction </h1> </html>",addjpanel(new Color(0xaaca),FlowLayout.CENTER,40,50,350,900,ComponentList3));
        ComponentList2.add(data);
        this.add(addjpanel(new Color(0xaaca),FlowLayout.CENTER,35,20,400,920,ComponentList));
        this.add(addjpanel(Config.bgColor,FlowLayout.CENTER,10,300,1400,900,ComponentList2));
        
        init(aps);
    }
     public ActionListener SendtoData()
      {
          return (new ActionListener()
                  {
                      public void actionPerformed(ActionEvent e)
                      {

                          root.setContentPane(   new admin_ManageUserAccounts(root,aps));

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
                           
                          UserName = tfName.getText();
                          Password = tfPassword.getText();
                          Country = tfCountry.getText();
                          City = tfCity.getText();
                          ShipMent = tfShipMent.getText();
           
                          
                            try{
                                 PinCode = Integer.parseInt(tfPinCode.getText());
                            }catch(Exception ee){
                                   Error_Lab.setText("Quantity Can Only be In Numbers");
                                   Error_Lab.setForeground(Config.warningColor);
                                return;
                            }
                          
                            if(UserName.equals("")  )
                            {
                                  Error_Lab.setText("Item Name Cant Be Empty");
                                   Error_Lab.setForeground(Config.warningColor);
                                return;
                            }
                             if(Country.equals("")  )
                            {
                                  Error_Lab.setText("Item Name Cant Be Empty");
                                   Error_Lab.setForeground(Config.warningColor);
                                return;
                            }
                             if(Password.equals("")  )
                            {
                                  Error_Lab.setText("Item Name Cant Be Empty");
                                   Error_Lab.setForeground(Config.warningColor);
                                return;
                            }
                               if(City.equals("")  )
                            {
                                  Error_Lab.setText("Item Must Belong to a category");
                                   Error_Lab.setForeground(Config.warningColor);
                                return;
                            }
                              if(City.equals("")  )
                            {
                                  Error_Lab.setText("Item Must Belong to a category");
                                   Error_Lab.setForeground(Config.warningColor);
                                return;
                            }
                             
                             
                               root.appManager.Db.InsertUserspecfic(UserName,Password,Country,City,PinCode,ShipMent,"groundcenter");

                         switchScene(Config.Home_Scene_Admin);
                    }
                }
            );
    }
    public ActionListener Manage_User_Data()
      {
          return (new ActionListener()
                  {
                      public void actionPerformed(ActionEvent e)
                      {

                          root.setContentPane(   new admin_ManageUsers(root,aps));

                      }
                  }
              );
      }
    
        public ActionListener Manage_User_Info()
      {
          return (new ActionListener()
                  {
                      public void actionPerformed(ActionEvent e)
                      {

                          root.setContentPane(   new admin_ManageUserAccounts(root,aps));

                      }
                  }
              );
      }
     public ActionListener Manage_Hub()
      {
          return (new ActionListener()
                  {
                      public void actionPerformed(ActionEvent e)
                      {

                          root.setContentPane(   new admin_ManageHubAccounts(root,aps));

                      }
                  }
              );
      }
      public ActionListener Manage_Enterprise()
      {
          return (new ActionListener()
                  {
                      public void actionPerformed(ActionEvent e)
                      {

                          root.setContentPane(   new admin_ManageEnterprise(root,aps));

                      }
                  }
              );
      }
       public ActionListener Manage_Organization()
      {
          return (new ActionListener()
                  {
                      public void actionPerformed(ActionEvent e)
                      {

                          root.setContentPane(   new admin_ManageOrganization(root,aps));

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
                      
                         switchScene(Config.Home_Scene_Admin);
                        
                    }
                }
            );
    }  
        public ActionListener Manage_Logger()
      {
          return (new ActionListener()
                  {
                      public void actionPerformed(ActionEvent e)
                      {

                          root.setContentPane(   new admin_Manage_Logger(root,aps));

                      }
                  }
              );
      }
         public ActionListener Manage_DeliveryAgent()
      {
          return (new ActionListener()
                  {
                      public void actionPerformed(ActionEvent e)
                      {

                          root.setContentPane(   new admin_Manage_DeliveryAgent(root,aps));

                      }
                  }
              );
      }
         
             public ActionListener Manage_GroundCenter()
      {
          return (new ActionListener()
                  {
                      public void actionPerformed(ActionEvent e)
                      {

                          root.setContentPane(   new admin_Manage_Ground_Center(root,aps));

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

