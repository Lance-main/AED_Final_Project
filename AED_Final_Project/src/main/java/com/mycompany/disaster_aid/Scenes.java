/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.mycompany.disaster_aid;

import javax.swing.JButton;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Color;
import java.awt.Component;
import java.util.ArrayList;
import java.awt.Font;
import java.awt.event.ActionListener;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JPasswordField;
import java.awt.event.ActionEvent;
import javax.swing.JList;
import javax.swing.JOptionPane;
import java.util.Properties;
import java.util.Random;

import javax.swing.JTextArea;


import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
/**
 *
 * @author 
 */
public interface Scenes {
    
      default void update(JFrame f)
    {
        f.revalidate();
        f.repaint();
            
    }
    default JButton addButton(String txt,int width,int height,Color color)
    {
        
        JButton jb = new JButton();
       

        jb.setFont(new Font("Arial",Font.PLAIN,25));
        jb.setText(txt);
        jb.setPreferredSize(new Dimension(width,height));
        jb.setFocusable(false);
        jb.setOpaque(true);
        jb.setBackground(color);

        return jb;
    }
    default JButton addButton(String txt,int width,int height,Color color,ActionListener Listener)
    {
        
        JButton jb = new JButton();
       
        jb.addActionListener(Listener);
        jb.setFont(new Font("Arial",Font.PLAIN,25));
        jb.setText(txt);
        jb.setPreferredSize(new Dimension(width,height));
        jb.setFocusable(false);
        jb.setOpaque(true);
        jb.setBackground(color);

        return jb;
    }
    default JTextField addTxtfield(int width,int height)
    {
        JTextField tf = new JTextField();
        tf.setPreferredSize(new Dimension(width,height));
        tf.setFont(new Font("Arial",Font.PLAIN,25));

        tf.setHorizontalAlignment(JTextField.CENTER);
        return tf;
    }
     default JPasswordField addPassfield(int width,int height)
    {
        JPasswordField pf = new JPasswordField();
        pf.setPreferredSize(new Dimension(width,height));
        pf.setFont(new Font("Arial",Font.PLAIN,25));
        pf.setHorizontalAlignment(JTextField.CENTER);
        return pf;
    }
    default JPanel addjpanel(Color color,int align,int vgap,int hgap,int width,int height,ArrayList<Component> componentList)
    {
        JPanel jp = new JPanel(new FlowLayout(align,hgap,vgap));
        jp.setBackground(color);
        
        for(Component c : componentList)
        {
                jp.add(c);
        }
        jp.setPreferredSize(new Dimension(width,height));
        return jp;
    }
    default JLabel addjlabel(String txt,int fontSize,Color fgColor)
    {
        JLabel lb = new JLabel();
        lb.setText(txt);
        lb.setFont(new Font("Arial",Font.BOLD,fontSize));
        lb.setForeground(fgColor);
          lb.setOpaque(false);
        
        return lb;
    }
    default JScrollPane addScrlPane(Color col,int height,int width,JTextArea a)
    {
        a.setEditable(false);
        JScrollPane jp = new JScrollPane(a);
       
        jp.setPreferredSize(new Dimension(width,height));
          jp.setOpaque(false);
        
        return jp;
    }
    default public ActionListener logout(AppStateManager aps)
    {
     return (new ActionListener()
                {
                    public void actionPerformed(ActionEvent e)
                    {
                        System.out.println("LogOut");
                        aps.SessionUser_=null;    
                        switchScene(Config.LoginState);
                    }
                }
            );
    }
    default public void popup(String str,String title)
    {
        JOptionPane.showMessageDialog(null, str, title, JOptionPane.INFORMATION_MESSAGE);

    }
    default JPanel addDropDown(Color color,int align,int hgap,int width,int height,String[] list_s,JButton btn)
    {
         JList list=new JList(list_s);

        JPanel jp = new JPanel(new FlowLayout(align,hgap,0));
               list.setPreferredSize(new Dimension(width,height));
       list.setForeground(Color.BLACK);

       list.setFont(new Font("Arial",Font.PLAIN,25));

        jp.setBackground(color);
         
       
        jp.setPreferredSize(new Dimension(width,height));
         list.add(btn);
       list.add(list);
        return jp;
    }
   default long handleEmail(String host,String from,String to,Properties properties)
    {

    Random rc = new Random();
    long otp=-1;
     properties.put("mail.smtp.host", host);
     properties.put("mail.smtp.port", "465");
     properties.put("mail.smtp.ssl.enable", "true");
     properties.put("mail.smtp.auth", "true");
     properties.put("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");
      Session session = Session.getInstance(properties, new javax.mail.Authenticator() {

         protected PasswordAuthentication getPasswordAuthentication() {

             return new PasswordAuthentication(from, "ikpi nugl ozmh llrk");

         }

     });

     // Used to debug SMTP issues
     session.setDebug(true);

       try {
         // Create a default MimeMessage object.
         MimeMessage message = new MimeMessage(session);

         // Set From: header field of the header.
         message.setFrom(new InternetAddress(from));

         // Set To: header field of the header.
         message.addRecipient(Message.RecipientType.TO, new InternetAddress(to));

         // Set Subject: header field
         message.setSubject("Email Verification");
            otp=rc.nextInt(1000,9999);
         // Now set the actual message
         message.setText("Your Registration OTP is: "+otp);

         System.out.println("sending...");
         // Send message
         Transport.send(message);
         System.out.println("Sent message successfully....");
     } catch (MessagingException mex) {
         mex.printStackTrace();
         otp=-1;
     }
       return otp;
    }
    void switchScene(int a);
    void init(AppStateManager aps);
    
}
