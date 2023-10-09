package employee.management.system;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
import java.sql.*;
import net.proteanit.sql.DbUtils;

public class ViewEmployee extends JFrame implements ActionListener{
    
    Choice employeeid;
            
    JTable table;
    
    JButton searchb, print, update, back;
    
    ViewEmployee(){
        
        setSize(1170, 650);
        setVisible(true); 
        setLocationRelativeTo(null); // Center the frame on the screen
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        getContentPane().setBackground(Color.orange);
        setLayout(null);

        JLabel heading = new JLabel("EMPLOYEE MANAGEMENT SYSTEM");
        heading.setBounds(350, 15, 800, 60); // Adjust the position and width
        heading.setFont(new Font("Arial", Font.BOLD, 24)); // Set a custom font and size
        add(heading);
        JLabel heading1 = new JLabel("UPDATE EMPLOYEE");
        heading1.setBounds(450, 35, 800, 60); // Adjust the position and width
        heading1.setFont(new Font("Arial", Font.BOLD, 24)); // Set a custom font and size
        add(heading1);
        
        
        
        JLabel search = new JLabel("Search by ID");
        search.setBounds(150,100,150,25);
        search.setFont(new Font("Arial", Font.PLAIN, 16)); // Set a custom font and size
        add(search);
        
         searchb = new JButton("Search");
        searchb.setBounds(105,140,75,30);
        searchb.setBackground(Color.BLACK);
        searchb.setForeground(Color.WHITE);
        searchb.addActionListener(this);
        add(searchb);
        
        print = new JButton("Print");
        print.setBounds(205,140,75,30);
        print.setBackground(Color.BLACK);
        print.setForeground(Color.WHITE);
        print.addActionListener(this);
        add(print);
        
        update = new JButton("Update");
        update.setBounds(305,140,75,30);
        update.setBackground(Color.BLACK);
        update.setForeground(Color.WHITE);
        update.addActionListener(this);
        add(update);
        
        back= new JButton("BACK");
        back.setBounds(405,140,75,30);
        back.setBackground(Color.BLACK);
        back.setForeground(Color.WHITE);
        back.addActionListener(this);
        add(back);
        
        
        
        employeeid = new Choice();
        employeeid.setBounds(375,100,150,30);
        add(employeeid);
        try{
            Conn c = new Conn();
            ResultSet rs = c.s.executeQuery("select * from employee");
            while(rs.next()){
                employeeid.add(rs.getString("empid"));
            }
        }catch(Exception e){
            e.printStackTrace();
        }
        
       
        table = new JTable();
        
        try{
            Conn c = new Conn();
            ResultSet rs = c.s.executeQuery("select * from employee");
            table.setModel(DbUtils.resultSetToTableModel(rs));
            while(rs.next()){
                employeeid.add(rs.getString("empid"));
            }
        }catch(Exception e){
            e.printStackTrace();
        }
        JScrollPane jsp = new JScrollPane(table);
        jsp.setBounds(100,175,900,450);
        add(jsp);
        
    }
    @Override
    public void actionPerformed(ActionEvent e){
        if(e.getSource()==searchb){
            String query1 = "select * from employee where empid= '"+employeeid.getSelectedItem()+"'";
            try{
            Conn c = new Conn();
            ResultSet rs = c.s.executeQuery(query1);
            table.setModel(DbUtils.resultSetToTableModel(rs));
            }catch(Exception ae){
                ae.printStackTrace();
            }
        }
        
        else if(e.getSource()==update){
            
        }
        else if(e.getSource()==print){
            try{
                table.print();
            }catch(Exception ee){
                ee.printStackTrace();
            }
        }
        else{
            new Home();
        }
    }
    public static void main(String[] args) {
        new ViewEmployee();
    }
}