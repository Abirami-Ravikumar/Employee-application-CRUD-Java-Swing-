package employee.management.system;
import javax.swing.*;
import java.awt.*;
import java.sql.*;
import java.awt.event.*;
public class Login extends JFrame implements ActionListener {
    JTextField tfusername ;
    JPasswordField tfpassword ;
    
    Login(){
        
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);
        
        JLabel lblusername = new JLabel("Username");
        lblusername.setBounds(40,20,100,30);
        add(lblusername);
        tfusername = new JTextField();
        tfusername.setBounds(150,20,150,30);
        add(tfusername);
        
        
        JLabel lblpassword = new JLabel("Password");
        lblpassword.setBounds(40,70,100,30);
        add(lblpassword);
        tfpassword = new JPasswordField();
        tfpassword.setBounds(150,70,150,30);
        add(tfpassword);
        
        JButton login= new JButton("LOGIN");
        login.setBounds(150,140,150,30);
        login.setBackground(Color.BLACK);
        login.setForeground(Color.WHITE);
        login.addActionListener(this);
        add(login);
        
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/login.jpg"));
        Image i2 = i1.getImage().getScaledInstance(200, 200, Image.SCALE_DEFAULT); // Adjust image size
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(350, 0, 200, 200); // Adjust the position and size
        add(image);

        
        setSize(600,300);
        setLocation(450,200);
        setVisible(true);
    }
    @Override
    public void actionPerformed(ActionEvent ae){
        try{
            String username = tfusername.getText();
            char[] passwordChars = tfpassword.getPassword();
            String password = new String(passwordChars);
            Conn c = new Conn();
            String query = "select * from login where username = '"+username+"' and password = '"+password+"'";
            ResultSet rs =  c.s.executeQuery(query);
            if(rs.next())
            {
                setVisible(false);
                // next class
                new Home();
            }
            else{
                JOptionPane.showMessageDialog(null, "Invalid username or password");
            }
        }catch(Exception e){
            e.printStackTrace();
        }
    }
    public static void main(String[] args) {
        new Login();        
    }
}
