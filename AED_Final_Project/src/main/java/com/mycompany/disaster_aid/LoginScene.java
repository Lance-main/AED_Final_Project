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
/**
 *
 * @Ojasvi
 */
public class LoginScene extends JPanel implements Scenes{
    
    private AppWindow root;
    private JTextField uname ;
    private JPasswordField upass ;
    JLabel Error_Lab=addjlabel("         ",20,Color.RED);
    LoginScene(AppWindow root)
    {
        this.root=root;

        this.setLayout(new FlowLayout(FlowLayout.CENTER,20,40));
        ArrayList<Component> ComponentList = new ArrayList();
        ArrayList<Component> ComponentList2 = new ArrayList();

         uname = addTxtfield(450,60);
         upass = addPassfield(450,60);

        ComponentList.add(uname);
        ComponentList.add(upass);

        ComponentList.add(addButton("Login",300,60,new Color(0x8BF0C9),uLogin()));
        
        ComponentList2.add( addButton("Login",300,60,new Color(0xF0978B)));
          
        ComponentList2.add(addButton("Register",300,60,new Color(0x8BB2F0),gotoRegister()));
        ComponentList.add(Error_Lab);

        this.add(addjpanel(new Color(0x144A4B),FlowLayout.CENTER,100,100,350,600,ComponentList2));

        this.add(addjpanel(new Color(0x0B4850),FlowLayout.CENTER,75,150,650,600,ComponentList));

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
                            
                          int rs= root.appManager.Db.Authenticate(user_n,Uuser_p);
                          
                        if(rs == 1)
                        {
                            Error_Lab.setText("Invalid User Name");
                            return;
                        }
                        if(rs == 2)
                        {
                            Error_Lab.setText("Password Does Not Match UserName");
                            return;
                        }
                        if(rs == 0)
                        {
                            uname.setText("");
                            upass.setText("");
                            root.appManager.SessionUser_ =user_n;
                            switchScene(Config.Home_Scene_User);

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
