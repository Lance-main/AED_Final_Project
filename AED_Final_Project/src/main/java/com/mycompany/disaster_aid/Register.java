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
import javax.swing.JPasswordField;


/**
 *
 * @Ojasvi
 */
public class Register extends JPanel implements Scenes{
    private AppWindow root;
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
    JTextField tfPinCode ;
    

    Register(AppWindow root)
    {
        
        this.root=root;
        this.setLayout(new FlowLayout(FlowLayout.CENTER,20,40));
        
        ArrayList<Component> ComponentList = new ArrayList();
        ArrayList<Component> ComponentList2 = new ArrayList();
        
        tfName=addTxtfield(450,60);
        tfEmail=addTxtfield(450,60);
        tfPassword=addPassfield(450,60);
        tfCountry =  addTxtfield(450,60);
        tfCity=addTxtfield(450,60);
        tfPinCode=addTxtfield(450,60);
        //for registration
        ComponentList.add(addjlabel("Enter Name: ",20,Color.WHITE));
        ComponentList.add(tfName);
        
        ComponentList.add(addjlabel("Enter Password: ",20,Color.WHITE));
        ComponentList.add(tfPassword);
        
        ComponentList.add(addjlabel("Enter Email: ",20,Color.WHITE));
        ComponentList.add(tfEmail);
        
        ComponentList.add(addjlabel("Enter Country: ",20,Color.WHITE));
        ComponentList.add(tfCountry);
        
        ComponentList.add(addjlabel("Enter City: ",20,Color.WHITE));

        ComponentList.add(tfCity);
        ComponentList.add(addjlabel("Enter PinCode: ",20,Color.WHITE));

        ComponentList.add(tfPinCode);
        ComponentList.add(addButton("Register",630,60,new Color(0x8BF0C9),RegisterUserToDb()));
        
        
        
        
        ComponentList2.add(addButton("Login",300,60,new Color(0x8BB2F0),gotoLogin()));
        ComponentList2.add(addButton("Register",300,60,new Color(0xF0978B)));

        this.add(addjpanel(new Color(0x13818F),FlowLayout.CENTER,100,20,350,600,ComponentList2));

        this.add(addjpanel(new Color(0x0B4850),FlowLayout.RIGHT,20,20,675,600,ComponentList));

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
       public ActionListener RegisterUserToDb()
    {
        return (new ActionListener()
                {
                    public void actionPerformed(ActionEvent e)
                        {
                            UserName = tfName.getText();
                            Email = tfEmail.getText();
                            Password = String.valueOf(tfPassword.getPassword());
                            Country = tfCountry.getText();
                            City = tfCity.getText();
                            try{
                                 PinCode = Integer.parseInt(tfPinCode.getText());
                            }catch(Exception ee){
                                System.out.println("[Error:] Must Only Contain Numbers");
                                return;
                            }
                            if(UserName.equals("")  )
                            {
                                System.out.println("UserName Cant Be Empty");
                                return;
                            }
                             if(Email.equals("")  )
                            {
                              System.out.println("Email Cant Be Empty");
                                return;
                            }
                              if(Password.equals("")  )
                            {
                              System.out.println("Password Cant Be Empty");
                                return;
                            }
                               if(Country.equals("")  )
                            {
                              System.out.println("Country Cant Be Empty");
                                return;
                            }
                                if(City.equals("")  )
                            {
                              System.out.println("City Cant Be Empty");
                                return;
                            }
                               root.appManager.Db.InsertUser(UserName,Password,Email,Country,City,PinCode);
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
    public void init(AppStateManager aps)
    {
         root.setContentPane(this);
         update(root);

    }
}
