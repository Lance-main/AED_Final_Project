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
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JOptionPane;

import java.util.Properties;
import java.util.regex.*;


/**
 *
 * @author 
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
    boolean verified=false;
    JLabel Error_Lab=addjlabel("All Fields Are Required",20,Color.WHITE);

    
    String from = "ojasvipatel113@gmail.com";
      String host = "smtp.gmail.com";
    
    Properties properties = System.getProperties();
    
    Register(AppWindow root)
    {
        
        this.root=root;
        this.setLayout(new FlowLayout(FlowLayout.CENTER,20,30));
        
        ArrayList<Component> ComponentList = new ArrayList();
        ArrayList<Component> ComponentList2 = new ArrayList();
        
        
       ArrayList<Component> left = new ArrayList();
       ArrayList<Component> mid = new ArrayList();

       ArrayList<Component> right = new ArrayList();

        
        tfName=addTxtfield(450,60);
        tfEmail=addTxtfield(450,60);
        tfPassword=addPassfield(450,60);
        tfCountry =  addTxtfield(450,60);
        tfCity=addTxtfield(450,60);
        tfPinCode=addTxtfield(450,60);
        
        left.add(tfName);
        left.add(tfPassword);
        left.add(tfEmail);
        left.add(tfCountry);
        left.add(tfCity);
        left.add(tfPinCode);

        
        right.add(addjlabel("Enter Name: ",20,Color.WHITE));
        right.add(addjlabel("Enter Password: ",20,Color.WHITE));
        right.add(addjlabel("Enter Email: ",20,Color.WHITE));
        right.add(addjlabel("Enter Country: ",20,Color.WHITE));
        right.add(addjlabel("Enter City: ",20,Color.WHITE));
        right.add(addjlabel("Enter PinCode: ",20,Color.WHITE));
        
        mid.add(addButton("Register",630,60,new Color(0x8BF0C9),RegisterUserToDb()));     
        mid.add(Error_Lab);
        
        
        ComponentList2.add(addButton("Login",300,60,new Color(0x8BB2F0),gotoLogin()));
        ComponentList2.add(addButton("Register",300,60,new Color(0xF0978B)));

        ComponentList.add(addjpanel(new Color(0x144A4B),FlowLayout.LEADING,62,150,430, 550,right));
        ComponentList.add(addjpanel(new Color(0x144A4B),FlowLayout.CENTER,30,150,430, 550,left));
        ComponentList.add(addjpanel(new Color(0x144A4B),FlowLayout.CENTER,20,150,400, 300,mid));

        this.add(addjpanel(new Color(0x144A4B),FlowLayout.CENTER,100,100,(root.width/5),root.height/2,ComponentList2));

        this.add(addjpanel(new Color(0x144A4B),FlowLayout.CENTER,30,70,((root.width)/2)+((root.width)/4),((root.height)/2) + ((root.height)/3),ComponentList));
        
        this.setBackground(Config.bgColor);
        
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
                            String pin = tfPinCode.getText();
                            
                            String regex_pass = "^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%^&+=])(?=\\S+$).{8,}$";

                            try{

                                 PinCode =(int) Integer.parseInt(pin);
                            }catch(Exception ee){
                                
                               ee.printStackTrace();
                                Error_Lab.setText("Pin Code Can Only Contain Numbers ");
                                Error_Lab.setForeground(Config.warningColor);
                                return;
                            }
                            if(UserName.equals("")  )
                            {
                                Error_Lab.setText("User Name Cant Be Blank");
                                Error_Lab.setForeground(Config.warningColor);

                                return;
                            }
                             if(Email.equals("")  )
                            {
                                Error_Lab.setText("Email Cant Be Blank");
                               Error_Lab.setForeground(Config.warningColor);

                                return;
                            }
                              if(Password.equals("")  )
                            {
                                Error_Lab.setText("Passward Cant Be Blank");
                                   Error_Lab.setForeground(Config.warningColor);
                            
                                return;
                            }
                              
                               Pattern pattern2 = Pattern.compile(regex_pass);
                                Matcher matcher2 = pattern2.matcher(Password);
                                if(matcher2.matches() == false){
                                     Error_Lab.setText("Weak Password Format");
                                     Error_Lab.setForeground(Config.warningColor);
                                     return;
                                }
                              
                               if(Country.equals("")  )
                            {
                                Error_Lab.setText("Country Cant Be Blank");
                                Error_Lab.setForeground(Config.warningColor);
                                
                                return;
                            }
                                if(City.equals("")  )
                            {
                                Error_Lab.setText("City Cant Be Blank");
                                Error_Lab.setForeground(Config.warningColor);
                                
                                return;
                            }
                                String regex = "^[\\w!#$%&'*+/=?`{|}~^-]+(?:\\.[\\w!#$%&'*+/=?`{|}~^-]+)*@(?:[a-zA-Z0-9-]+\\.)+[a-zA-Z]{2,6}";
                                Pattern pattern = Pattern.compile(regex);
                                Matcher matcher = pattern.matcher(Email);
                                if(matcher.matches() == false){
                                     Error_Lab.setText("Invalid Email Provided");
                                     Error_Lab.setForeground(Config.warningColor);
                                     return;
                                }

                                
                               root.appManager.Db.InsertUser(UserName,Password,Email,Country,City,PinCode);
                                switchScene(Config.LoginState);
                                boolean otpRecieved= false;
                                    long data =0;
                                    long pass=0;
                                    
                                    String str="Enter OTP";
                                    String st;
                                do {
                                    
                                     if(otpRecieved == false)
                                  {    
                                      pass = handleEmail(host,from,Email,properties);
                                       if(pass == -1)
                                       {
                                         JOptionPane.showMessageDialog(root,"Please Make Sure You have Active Internet Connection\n\n Please Disable AntiVirus If problem Continues","[Error]",JOptionPane.ERROR_MESSAGE);
                                         popup("Registration Failed ","Disaster Aid (Information)");
                                         break;
                                       }else{
                                            otpRecieved=true;
                                       }                        
                                  }
                                     if(otpRecieved== true)
                                     {
                                       try{
                                          st = JOptionPane.showInputDialog(root, str, "Email Verification",JOptionPane.QUESTION_MESSAGE);
                                           if( st == null)
                                          {
                                              System.out.println("Canceling Registration");
                                              popup("Registration successfuly Canceled","Disaster Aid (Information)");
                                              break;
                                          }
                                          data = Long.parseLong(st);
                                       
                                        str="Enter OTP";
                                    }catch(Exception error)
                                    {
                                        str="Enter OTP Recieved at Email\n AlphaNumeric values or Blank Fields Are Not Allowed ";   

                                    }
                                    if(pass == data)
                                  {
                                      System.out.println("data "+data);
                                      System.out.println("Pass "+pass);
                                          verified = false;
                                           popup("Registration successful","Disaster Aid (Information)");
                                           break;
                                  }
                                     }
                                  
                                  
                                 
                            } while (!verified);

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
