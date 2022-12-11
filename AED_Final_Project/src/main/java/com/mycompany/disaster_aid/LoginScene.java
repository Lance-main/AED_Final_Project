/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.disaster_aid;
import java.awt.Color;
import javax.swing.JPanel;
import java.awt.FlowLayout;
import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JLabel;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.*;
import java.awt.Graphics;
/**
 *
 * @author 
 */


public class LoginScene extends JPanel implements Scenes{
    
    private AppWindow root;
    private JTextField uname ;
    private JPasswordField upass ;
   
    
    JLabel Error_Lab=addjlabel("Please Login To Continue",20,Color.WHITE);
    
    
  
    
    LoginScene(AppWindow root)
    {
     
  
          
        this.root=root;

        this.setLayout(new FlowLayout(FlowLayout.LEADING,20,70));
        ArrayList<Component> ComponentList = new ArrayList();
        ArrayList<Component> ComponentList2 = new ArrayList();
        
        ArrayList<Component> subListRight = new ArrayList();
        ArrayList<Component> subListMid = new ArrayList();

        ArrayList<Component> subListLeft = new ArrayList();

         uname = addTxtfield(450,60);
         upass = addPassfield(450,60);

          Image background = Toolkit.getDefaultToolkit().createImage("ng.png");
     
        ComponentList2.add( addButton("Login",300,60,new Color(0xF0978B)));
          
        ComponentList2.add(addButton("Register",300,60,new Color(0x8BB2F0),gotoRegister()));
        //ComponentList2.add(addjlabel("Disaster",35,Color.white));


        subListLeft.add(addjlabel("Enter User Name:",35,Color.white));
        subListLeft.add(addjlabel("Enter Password:",35,Color.white));
        subListRight.add(uname);
        subListRight.add(upass);
        subListMid.add(addButton("Login",300,60,new Color(0x8BF0C9),uLogin()));
        subListMid.add(Error_Lab);
        
        ComponentList.add(addjpanel(new Color(0x0B4850),FlowLayout.CENTER,100,60,450,450,subListLeft));
        ComponentList.add(addjpanel(new Color(0x0B4850),FlowLayout.CENTER,90,60,450,450,subListRight));
        ComponentList.add(addjpanel(new Color(0x0B4850),FlowLayout.CENTER,20,60,500,450,subListMid));

      

        JPanel p = addjpanel(new Color(0x144A4B),FlowLayout.CENTER,100,100,(root.width/5),root.height/2,ComponentList2);
        
        this.add(p);
      // this.drawImage(background, 0, 0, null);
        this.add(addjpanel(new Color(0x0B4850),FlowLayout.CENTER,70,60,(root.width/2)+(root.width/4),(root.height/2 + (root.height/3)),ComponentList));
        
        this.setBackground(Config.bgColor);
        
        
        
    }
    public ActionListener uLogin()
    {
        
        return (new ActionListener()
                {
                    public void actionPerformed(ActionEvent e)
                        {
                            
                          String user_n = uname.getText();
                          String Uuser_p = String.valueOf(upass.getPassword());
                          
                          int rs1= root.appManager.Db.Authenticate_db(user_n,Uuser_p,root.appManager.Db.Entity);
                          int rs2= root.appManager.Db.Authenticate_db(user_n,Uuser_p,root.appManager.Db.UserInfo);
                     
                          

                        if(rs1 == 1 || rs2 == 1)
                        {
                            Error_Lab.setText("Invalid User Name");
                            Error_Lab.setForeground(Config.warningColor);

                        }
                        if(rs1 == 2 || rs2 == 2)
                        {
                            Error_Lab.setText("Password does not match with User Name");
                            Error_Lab.setForeground(Config.warningColor);

                        }
                        if(rs1 == 0)
                        {
                            uname.setText("");
                            upass.setText("");
                            root.appManager.SessionUser_ =user_n;
                            switch(user_n)
                            {
                                case "admin":
                                {
                                    switchScene(Config.Home_Scene_Admin);
                                    break;
                                }
                                case "hub":
                                {
                                    switchScene(Config.Home_Scene_Hub);
                                    break;
                                }
                                case "enter":
                                {
                                    switchScene(Config.Home_Scene_EnterPrise);
                                    break;
                                }
                                case "delivery":
                                {
                                    switchScene(Config.Home_Scene_DeliverAgent);
                                    break;
                                }
                                case "ground":
                                {
                                    switchScene(Config.Home_Scene_GroundCentral);
                                    break;
                                }
                                case "organization":
                                {
                                    switchScene(Config.Home_Scene_Organization);
                                    break;
                                }
                                   case "Logger":
                                {
                                    switchScene(Config.Home_Scene_Logger);
                                    break;
                                }
                                   default:{
                                    switchScene(Config.RegisterState);
                                }
                            }
                            popup("logged in successfully","Disaster Aid (Information)");

                        }else if(rs2  == 0)
                        {
                            uname.setText("");
                            upass.setText("");
                            root.appManager.SessionUser_ =user_n;
                            switchScene(Config.Home_Scene_User);
                            popup("logged in successfully","Disaster Aid (Information)");

                        }
                        
                 }
                }
            );
    }
    public ActionListener gotoRegister()
    {
        return (new ActionListener()
                {
                    public void actionPerformed(ActionEvent e)
                        {
                            switchScene(Config.RegisterState);
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
