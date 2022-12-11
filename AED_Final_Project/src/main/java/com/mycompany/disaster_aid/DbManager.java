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
    private String userData="UserData";
  
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
            if(ExecuteUpdate("CREATE TABLE "+UserInfo+"(" + "Sno INT UNIQUE AUTO_INCREMENT," +
                    "UserName VARCHAR(20) NOT NULL  PRIMARY KEY," +
                    "Password VARCHAR(20) NOT NULL, "+
                     "Email VARCHAR(80) NOT NULL, "+
                     "Country VARCHAR(20) NOT NULL, "+
                     "City VARCHAR(20) NOT NULL, "+
                     "PinCode VARCHAR(20) NOT NULL) ")==true)
            {
                System.out.println("Created the table "+UserInfo);

            }
            
             if(ExecuteUpdate("CREATE TABLE "+userData+"(" + "Sno INT UNIQUE AUTO_INCREMENT," +
                    "UserName VARCHAR(20) NOT NULL ," +
                    "DonationType VARCHAR(20) NOT NULL, "+
                    "Qty INT NOT NULL)")==true)
            {
                System.out.println("Created the table "+userData);

            }
         
        }
    }
      public int getTotalHistory(String user_name)
    {
        int rows=0;
        String SQL="select COUNT(*) from "+ userData + " WHERE UserName = '"+user_name+"'";
        try{
            PrepStatment = connection.prepareStatement(SQL);
            ResSet = PrepStatment.executeQuery();
            if(ResSet.next())
            {
                rows=ResSet.getInt(1);
            }else
            {
                System.out.println("Error Getting Column Number ");
            }
        }catch(Exception e)
        {
            System.out.println("Error At Exectuing Querry"+e);
        }
        return rows;
    }
      public String GetDataString(int i,String UserName,String ColName)
    {
        String RData="";
        String SQL="select * from "+ userData +" WHERE UserName='"+UserName+"' LIMIT "+(i)+",1";
        try{
            PrepStatment = connection.prepareStatement(SQL);
            ResSet = PrepStatment.executeQuery();
            if(ResSet.next())
            {
                RData=ResSet.getString(ColName);
            }else
            {
                System.out.println("No Data Found ");
            }
        }catch(Exception e)
        {
            System.out.println("Error At Exectuing Querry"+e);
            RData="No Connection";
        }
        return RData;
    }
    public void InsertUser(String UserName,String Password,String Email,String Country,String city,int pinCode)
    {
        try{
            String Sql = "INSERT INTO "+UserInfo+"(UserName,Password,Email,Country,City,PinCode) VALUES(?,?,?,?,?,?)";
            PrepStatment = connection.prepareStatement(Sql);
            PrepStatment.setString(1,UserName);
            PrepStatment.setString(2,Password);
            PrepStatment.setString(3,Email);
            PrepStatment.setString(4,Country);
            PrepStatment.setString(5,city);
            PrepStatment.setInt(6,pinCode);


            PrepStatment.execute();
        }catch (Exception e)
        {
            System.out.println("Inserting Data into Database Failed\n\n\t--"+e);
        }
    }
     public void InsertData(String UserName,String DonationType,int QTY)
    {
        try{
            String Sql = "INSERT INTO "+userData+"(UserName,DonationType,Qty) VALUES(?,?,?)";
            PrepStatment = connection.prepareStatement(Sql);
            PrepStatment.setString(1,UserName);
            PrepStatment.setString(2,DonationType);
            PrepStatment.setInt(3,QTY);
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
