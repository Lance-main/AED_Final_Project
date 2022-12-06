package app;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class LoginDialog extends JDialog {

    private JTextField username;
    private JPasswordField password;
    private JLabel labelUser;
    private JLabel labelPass;
    private JButton login;
    private JButton cancel;

    public LoginDialog(Frame parent){
        super(parent,"Login",true);

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
                    JOptionPane.showMessageDialog(LoginDialog.this,"Welcome "+ getUsername(),"Login",JOptionPane.INFORMATION_MESSAGE);
                    LogManager.setMessage("Welcome "+ getUsername());
                    LogManager.displayMessage();
                    dispose();
                }
                else{
                    JOptionPane.showMessageDialog(LoginDialog.this, "Invalid username or password","Login",JOptionPane.ERROR_MESSAGE);
                    LogManager.setMessage("Invalid username or password");
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
