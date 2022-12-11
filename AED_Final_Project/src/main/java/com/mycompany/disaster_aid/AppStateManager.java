/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.disaster_aid;
import java.util.ArrayList;
/**
 *
 * @author 
 */



public class AppStateManager {
    
    DbManager Db ;

    private int currentState=0;

    private ArrayList<Scenes> AppStateList;
     AppWindow appWin;
     AppStateManager(AppWindow ap)
    {
        Db = new DbManager();
          if(Db.CheckConnection()  == true)
        {
            System.out.println("Connection Succesfull");
            Db.CheckLink();
            currentState = Config.LoginState;
        }else
        {
            System.out.println("Connection Failed");
            currentState = Config.NoDbConnection;
        }
        appWin=ap;
        AppStateList = new ArrayList<Scenes>();
        AppStateList.add(new DbError(ap));
        AppStateList.add(new LoginScene(ap));
        AppStateList.add(new Register(ap));
        AppStateList.add(new HomeScene_User(ap));
        AppStateList.add(new HomeScene_Hub(ap));
        AppStateList.add(new HomeScene_DeliverAgent(ap));
        AppStateList.add(new HomeScene_EnterPrise(ap));
        AppStateList.add(new HomeScene_Organization(ap));
        AppStateList.add(new HomeScene_Logger(ap));
        AppStateList.add(new HomeScene_Admin(ap));

        SwitchState(currentState);
    }
     
     
      public void SwitchState(int state){
        currentState = state;
        System.out.println("state "+state);
        AppStateList.get(currentState).init();
        

    }
}
