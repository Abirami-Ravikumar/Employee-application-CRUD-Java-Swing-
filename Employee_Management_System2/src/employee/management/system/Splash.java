package employee.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
public class Splash extends JFrame implements ActionListener {

    Splash() {
        setSize(1170, 650);
        setLocationRelativeTo(null); // Center the frame on the screen
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        getContentPane().setBackground(Color.orange);
        setLayout(null);

        JLabel heading = new JLabel("EMPLOYEE MANAGEMENT SYSTEM");
        heading.setBounds(350, 30, 800, 60); // Adjust the position and width
        heading.setFont(new Font("Arial", Font.BOLD, 24)); // Set a custom font and size
        add(heading);

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/home.jpg"));
        Image i2 = i1.getImage().getScaledInstance(1000, 500, Image.SCALE_DEFAULT); // Adjust image size
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(85, 100, 1000, 500); // Adjust the position and size
        add(image);

        JButton clickhere = new JButton("CLICK HERE TO CONTINUE");
        clickhere.setBounds(400,400,300,70);
        clickhere.setBackground(Color.BLACK);
        clickhere.setForeground(Color.WHITE);
        clickhere.addActionListener(this);
        image.add(clickhere);
        
        setVisible(true);
    }
    
    @Override
    public void actionPerformed(ActionEvent e){
        setVisible(false);
        new Login();
    }

    public static void main(String[] args) {
            new Splash();

    }
}
