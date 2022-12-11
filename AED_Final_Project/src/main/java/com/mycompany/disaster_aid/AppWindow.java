/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.disaster_aid;
import javax.swing.JFrame;
import java.awt.Dimension;
import java.awt.Toolkit;
/**
 *
 * @author 
 */
public class AppWindow extends JFrame{
    public AppStateManager appManager;
    int width;
    int height;
    AppWindow(String appName)
    {
        super(appName);
         Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();

         width = (int)screenSize.getWidth();
         height = (int)screenSize.getHeight();
        
        System.out.println("App Started");
        appManager = new AppStateManager(this);
         this.pack();

        
         this.setDefaultCloseOperation(EXIT_ON_CLOSE);
         this.setExtendedState(MAXIMIZED_BOTH);
         this.setVisible(true);
         this.setResizable(false);

    }
  
}
