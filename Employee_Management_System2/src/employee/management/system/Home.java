package employee.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
public class Home extends JFrame implements ActionListener {
    JButton add,view,update,remove;
    
    Home(){
        setSize(1170, 650);
        setLocationRelativeTo(null); // Center the frame on the screen
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        getContentPane().setBackground(Color.orange);
        setLayout(null);

        JLabel heading = new JLabel("EMPLOYEE MANAGEMENT SYSTEM");
        heading.setBounds(350, 30, 800, 60); // Adjust the position and width
        heading.setFont(new Font("Arial", Font.BOLD, 24)); // Set a custom font and size
        add(heading);

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/admin.jpg"));
        Image i2 = i1.getImage().getScaledInstance(1000, 500, Image.SCALE_DEFAULT); // Adjust image size
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(85, 100, 1000, 500); // Adjust the position and size
        add(image);

        add = new JButton("ADD EMPLOYEE");
        add.setBounds(500,10,200,70);
        add.setBackground(Color.BLACK);
        add.setForeground(Color.WHITE);
        add.addActionListener(this);
        image.add(add);
        
        view = new JButton("VIEW EMPLOYEE");
        view.setBounds(750,10,200,70);
        view.setBackground(Color.BLACK);
        view.setForeground(Color.WHITE);
        view.addActionListener(this);
        image.add(view);
        
        update = new JButton("UPDATE EMPLOYEE");
        update.setBounds(500,140,200,70);
        update.setBackground(Color.BLACK);
        update.setForeground(Color.WHITE);
        add.addActionListener(this);
        image.add(update);
        
        remove = new JButton("REMOVE EMPLOYEE");
        remove.setBounds(750,140,200,70);
        remove.setBackground(Color.BLACK);
        remove.setForeground(Color.WHITE);
        remove.addActionListener(this);
        image.add(remove);
        
        setVisible(true); 
    }
    @Override
    public void actionPerformed(ActionEvent ae){
        if(ae.getSource()== add){
            setVisible(false);
            new AddEmployee();
             
        }
        else if(ae.getSource()==view){
            setVisible(false);
            new ViewEmployee();
            
        }
        else if(ae.getSource()==update){
            setVisible(false);
            new UpdateEmployee();
        }
        else{
            setVisible(false);
            new RemoveEmployee();
            
        }        
    }
    public static void main(String[] args) {
        new Home();
    }

    
}
