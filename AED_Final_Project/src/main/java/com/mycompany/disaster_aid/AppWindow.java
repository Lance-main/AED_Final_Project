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
    public AppStateManager appManager;
    AppWindow(String appName,int width,int height)
    {
        super(appName);
        System.out.println("App Started");
        appManager = new AppStateManager(this);
        
        this.setSize(width,height);
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setResizable(false);
      
        this.setVisible(true);
        
        
    }
  
}
