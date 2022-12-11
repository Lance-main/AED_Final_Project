/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.disaster_aid;
import javax.swing.JFrame;
/**
 *
 * @author 
 */
public class AppWindow extends JFrame{
    
    AppWindow(String appName,int width,int height)
    {
        super(appName);
        System.out.println("App Started");
        this.setSize(width,height);
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setResizable(false);
        this.setContentPane(new LoginScene(this));
        this.setVisible(true);


    }
  
}
