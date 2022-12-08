package app;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;

public class FrameWindow extends JFrame implements Runnable{
    public static JTextArea messageArea;
    public static final String databaseUrl = "jdbc:mysql://localhost:3306/appdb";
    public FrameWindow(String title) throws HeadlessException {
        super(title);
        
        String username = "root";
        String password = "toor";
        
        try{
            Connection connection = DriverManager.getConnection(databaseUrl,username,password);
            String sql = "SELECT * FROM ENTERPRISE";
            Statement statement = connection.createStatement();
            ResultSet result = statement.executeQuery(sql);
            while(result.next()){
                System.out.println(result.getString(1));
                System.out.println(result.getString(2));
            }
            
        }catch(SQLException e){
            System.out.println("Error");
            e.printStackTrace();
        }
        
    
        setBounds(300, 200, 800, 600);
        Container controlHost = getContentPane();
        controlHost.setLayout(null);
        

        //Message Area
        messageArea = new JTextArea();
        messageArea.setBounds(0, 200, 800, 400);
        messageArea.setEditable(false);
        messageArea.setBackground(Color.LIGHT_GRAY);
        messageArea.setLineWrap(true);
        Font font = new Font("Arial", Font.BOLD, 30);
        messageArea.setFont(font);
        controlHost.add(messageArea);


        //Menus
        JMenuBar menuBar = new JMenuBar();
        setJMenuBar(menuBar);
        JMenu management = new JMenu("Login");
        menuBar.add(management);


        //Management Menu
        JMenuItem start = new JMenuItem("Login");
        JMenuItem stop = new JMenuItem("Logout");
        management.add(start);
        start.setAccelerator(KeyStroke.getKeyStroke('N', Toolkit.getDefaultToolkit().getMenuShortcutKeyMaskEx()));
        stop.setAccelerator(KeyStroke.getKeyStroke('T', Toolkit.getDefaultToolkit().getMenuShortcutKeyMaskEx()));
        management.add(stop);
        start.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                LoginDialog login = new LoginDialog(FrameWindow.this);
                login.setBounds(400, 300, 400, 200);
                login.setVisible(true);
            }
        });
    }
        @Override
    public void run() {
        this.setVisible(true);
    }

    public static void setText(String message){
        messageArea.setText(message);
    }
    public static boolean authenticate(String username, String password){
        //will be comparing to database entries
        if(username.equals("") && password.equals("")){
            return true;
        }
        return false;
    }
}
