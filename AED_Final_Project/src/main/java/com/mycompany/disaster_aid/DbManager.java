/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.disaster_aid;
import java.sql.*;

/**
 *
 * @author 
 */
public class DbManager {
    private Connection connection;
    private PreparedStatement PrepStatment;
    private Statement Stat;
    private ResultSet ResSet;
    private String UName;
    private String UPass;
    private String db = "";
    private String DatabaseName="appdb";
    private String UserInfo="UserInfo";
  
    DbManager()
    {
        UName = "root";
        UPass="toor";

    }
    boolean CheckConnection()
    {
        try
        {
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306",UName,UPass);
            return true;
        }catch (Exception e)
        {
            System.out.println("Error Establishing Connection"+e);
            return false;
        }

    }

    public void CheckLink()
    {
        try
        {
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/"+DatabaseName,UName,UPass);
            System.out.println("Database Found");
        }catch (Exception e)
        {
            //sets up Db at first start
            System.out.println("Database "+DatabaseName+" Not Found \n"+e);
            if(ExecuteUpdate("Create Database "+DatabaseName)==true)
            {
                System.out.println("--New Database Created Executed");
            }
            if(ExecuteUpdate("USE "+DatabaseName)==true)
            {
                System.out.println("Using Database "+DatabaseName);
            }
            if(ExecuteUpdate("CREATE TABLE "+UserInfo+"(" + "Sno INT PRIMARY KEY AUTO_INCREMENT," +
                    "UserName VARCHAR(20) NOT NULL UNIQUE," +
                    "Password VARCHAR(20) NOT NULL) ")==true)
            {
                System.out.println("Created the table "+UserInfo);
                InsertUser("User1","pass1");
                InsertUser("User2","pass2");
            }
         
        }
    }
    public void InsertUser(String UserName,String Password)
    {
        try{
            String Sql = "INSERT INTO "+UserInfo+"(UserName,Password) VALUES(?,?)";
            PrepStatment = connection.prepareStatement(Sql);
            PrepStatment.setString(1,UserName);
            PrepStatment.setString(2,Password);
            PrepStatment.execute();
        }catch (Exception e)
        {
            System.out.println("Inserting Data into Database Failed\n\n\t--"+e);
        }
    }
    
    public int Authenticate(String UserName,String Password)
    {
        try{

            if(CheckData("UserName",UserName,UserInfo)==true)
            {
                System.out.println("UserNamE Found");
            }else{
                System.out.println("UserName Not Found");
                return 1;
            }
            String Sql2 = "SELECT * FROM "+UserInfo+" WHERE UserName=? AND Password=?";
            PrepStatment = connection.prepareStatement(Sql2);
            PrepStatment.setString(1,UserName);
            PrepStatment.setString(2,Password);
            ResSet = PrepStatment.executeQuery();
            if(ResSet.next())
            {
                System.out.println("User Authenticated");
                return 0;
            }else
            {
                System.out.println("Password Does not Match");
                return 2;
            }
        }catch (Exception e){
            System.out.println("Unable To Execute The Equerry\n\n\t"+e);
            return -1;
        }
    }
    public boolean CheckData(String Col,String Data,String TableName)
    {

        String Sql = "SELECT * FROM "+TableName+" WHERE "+Col+" = ?";
        try
        {
            PrepStatment = connection.prepareStatement(Sql);
            //    PrepStatment.setString(1,Col);
            PrepStatment.setString(1,Data);
            ResSet=PrepStatment.executeQuery();
            System.out.println();
            if(ResSet.next())
            {
                System.out.println("Data Found");
                return true;
            }else
            {
                System.out.println("Data Not Found for Col "+Col+" "+Data);
                return false;
            }
        }catch (Exception e)
        {
            System.out.println("Error Executing Querry");
            return false;
        }
    }

    public void RemoveFromDocumentTable(String ColName ,String Info,String CName)
    {
        Info = Info.replaceAll("[\\\\]", "\\\\\\\\\\\\\\\\"); //removes File Extension
        System.out.println("Info IS "+Info);
        if(ExecuteUpdate("DELETE from metacompanyinfo where "+ColName+" LIKE '%"+Info+"%' AND CompanyName='"+CName+"'")==true)
        {
            System.out.println("Sucesfully Removed "+Info+" at "+ColName+" From MetaCompanyinfo");

        }else
        {
            System.out.println("Failed To Delete Data");
        }
    }
    public void RemoveFromTable(String ColName ,String Info,String TableName)
    {
        System.out.println(Info);
        if(ExecuteUpdate("DELETE from "+TableName+" where "+ColName+"='"+Info+"'")==true)
        {
            System.out.println("Sucesfully Removed "+Info+" at "+ColName+" From "+TableName);

        }else
        {
            System.out.println("Failed To Delete Data");
        }
    }
    public boolean ExecuteUpdate(String sqlStmnt)
    {
        try
        {
            Stat = connection.createStatement();
            Stat.executeUpdate(sqlStmnt);
            return true;
        }catch (Exception e)
        {
            System.out.println("Failed to Execute Statement"+e);
            return false;
        }
    }
}
