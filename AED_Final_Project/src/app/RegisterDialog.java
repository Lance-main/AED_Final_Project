/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package app;

/**
 *
 * @author Rushi
 */
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import java.awt.BorderLayout;
import java.awt.Frame;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

public class RegisterDialog extends JDialog {

    private JTextField username;
    private JPasswordField password;
    private JLabel labelUser;
    private JLabel labelPass;
    private JButton login;
    private JButton cancel;

    public RegisterDialog(Frame parent){
        super(parent,"Register",true);

        JPanel panel = new JPanel(new GridBagLayout());
        GridBagConstraints cs = new GridBagConstraints();
        cs.fill = GridBagConstraints.HORIZONTAL;

        labelUser = new JLabel("Username");
        cs.gridx = 0;
        cs.gridy = 0;
        cs.gridwidth = 1;
        panel.add(labelUser,cs);

        username = new JTextField(20);
        cs.gridx = 1;
        cs.gridy = 0;
        cs.gridwidth = 2;
        panel.add(username,cs);

        labelPass = new JLabel("Password");
        cs.gridx = 0;
        cs.gridy = 1;
        cs.gridwidth = 1;
        panel.add(labelPass,cs);

        password = new JPasswordField(20);
        cs.gridx = 1;
        cs.gridy = 1;
        cs.gridwidth = 2;
        panel.add(password,cs);

        login = new JButton("Login");

        login.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(FrameWindow.authenticate(getUsername(),getPassword())){
                    JOptionPane.showMessageDialog(RegisterDialog.this,"Welcome "+ getUsername(),"Register",JOptionPane.INFORMATION_MESSAGE);
                    LogManager.setMessage("Welcome "+ getUsername());
                    LogManager.displayMessage();
                    dispose();
                }
                else{
                    JOptionPane.showMessageDialog(RegisterDialog.this, "Unsuccesful registration","Register",JOptionPane.ERROR_MESSAGE);
                    LogManager.setMessage("Unsuccesful registration");
                    LogManager.displayMessage();
                    dispose();
                }
            }
        });

        cancel = new JButton("Cancel");
        cancel.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
            }
        });

        JPanel buttons = new JPanel();
        buttons.add(login);
        buttons.add(cancel);

        getContentPane().add(panel,BorderLayout.CENTER);
        getContentPane().add(buttons,BorderLayout.PAGE_END);

        pack();
        setResizable(false);
        setLocationRelativeTo(parent);
    }

    private String getUsername(){
        return username.getText();
    }
    private String getPassword(){
        String pass ="";
        for(char c: password.getPassword()){
            pass+=c;
        }
        return pass;
    }

}

