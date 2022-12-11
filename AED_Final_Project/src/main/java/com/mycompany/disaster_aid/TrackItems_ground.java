/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.disaster_aid;

import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Vector;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author 
 */

public class TrackItems_ground extends JPanel implements Scenes{
             private AppWindow root;
    JTextField tfitemName ;
    JTextField tfQty ;
    String ItemName ;
    int itemQty;
    private String user_name;
    AppStateManager aps;
    DefaultTableModel model ;

    
    String[] columnNames = new String[]{ "User Name","Item Name","Item Quantity","Category","Destination","Organization","Logistics"};
    
   Object[][] TableData = new Object[][]{};

    
    TrackItems_ground(AppWindow root,AppStateManager aps,String db)
    {
        this.root=root;       
        this.aps=aps;
        JTextArea jl = new JTextArea();
        user_name = aps.SessionUser_;
        
      
        model = new DefaultTableModel(TableData,columnNames);
        
        System.out.println("Getting data from "+db);
        for (int i = 0; i < aps.Db.getTotalUser(db); i++) 
        {
                    Vector<Object> tt = new Vector<Object>();

                System.out.println("i "+i);
                tt.add(aps.Db.GetAllwithDb(i,user_name,"UserName",db));
                tt.add(aps.Db.GetAllwithDb(i,user_name,"DonationType",db));
                tt.add(aps.Db.GetAllwithDb(i,user_name,"Qty",db));
                tt.add(aps.Db.GetAllwithDb(i,user_name,"Category",db));
                tt.add(aps.Db.GetAllwithDb(i,user_name,"Destination",db));
                tt.add(aps.Db.GetAllwithDb(i,user_name,"Organization",db));
                tt.add(aps.Db.GetAllwithDb(i,user_name,"PlaceHolder",db));
                model.insertRow(i,tt);

        }
       
        JTable jt = new JTable();
        jt.setModel(model);
       

        DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
        centerRenderer.setHorizontalAlignment(JLabel.CENTER);

        for(int j=0;j<jt.getColumnCount();j++)
        {
            jt.getColumnModel().getColumn(j).setCellRenderer(centerRenderer);
        }
        jt.getColumnModel().getColumn(0).setCellEditor(new DisableEditor());  //Set Table column Non editable
        jt.getColumnModel().getColumn(1).setCellEditor(new DisableEditor());  //Set Table column Non editable
        jt.getColumnModel().getColumn(2).setCellEditor(new DisableEditor());  //Set Table column Non editable
        jt.getColumnModel().getColumn(3).setCellEditor(new DisableEditor());  //Set Table column Non editable
        jt.getColumnModel().getColumn(4).setCellEditor(new DisableEditor());  //Set Table column Non editable
        jt.getColumnModel().getColumn(5).setCellEditor(new DisableEditor());  //Set Table column Non editable
        jt.getColumnModel().getColumn(6).setCellEditor(new DisableEditor());  //Set Table column Non editable
        
        ArrayList<Component> ComponentList2 = new ArrayList();
        jt.getTableHeader().setReorderingAllowed(false);
        jt.setRowHeight(80);
        jt.getTableHeader().setResizingAllowed(false);
        
      
        this.setLayout(new FlowLayout(FlowLayout.LEADING,20,70));
        ComponentList2.add(addButton("Home",300,60,new Color(0xcfa62),GoBack()));
        ComponentList2.add(addButton("Send Donation",300,60,new Color(0xcfa62),SendData()));
        ComponentList2.add(addButton("Track Order",300,60,Config.selectColor));
        ComponentList2.add(addButton("Log Out",300,60,new Color(0xcfa62),logout(aps)));
        
        
        

        this.setBackground(Config.bgColor);
        ArrayList<Component> ComponentList = new ArrayList();
        
        
        JScrollPane jc = new JScrollPane(jt);
        jc.setPreferredSize(new Dimension(1350, 750));
        ComponentList.add(jc);

        
        
        this.add(addjpanel(new Color(0xaaca),FlowLayout.CENTER,100,50,350,900,ComponentList2));

        this.add(addjpanel(new Color(0xaaca),FlowLayout.CENTER,50,50,1500,900,ComponentList));
        init(aps);

    }
      public ActionListener SendData()
    {
        return (new ActionListener()
                {
                    public void actionPerformed(ActionEvent e)
                    {
                        root.setContentPane(   new SendItems(root,aps));
                    }
                }
            );
    }
   public ActionListener TrackOrder(String db)
    {
      return (new ActionListener()
                {
                    public void actionPerformed(ActionEvent e)
                    {
                    
                        root.setContentPane(   new TrackItems(root,aps,db));
                        
                    }
                }
            );
            
    }
      public ActionListener GoBack()
    {
        return (new ActionListener()
                {
                    public void actionPerformed(ActionEvent e)
                    {
                      
                         switchScene(Config.Home_Scene_User);
                        
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


