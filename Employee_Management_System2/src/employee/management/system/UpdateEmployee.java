package employee.management.system;

import javax.swing.*;
import java.awt.*;
import java.sql.*;
import java.awt.event.*;


public class UpdateEmployee extends JFrame implements ActionListener {
   
    JTextField tfhigher, tfaddress,tfmail,tfdesig,tffname,tfsal,tfphone,tfaadhaar;
    //JDateChooser dcdob;
    JLabel lblempid;
    JButton addDetails,back;
    String empid;
    
    UpdateEmployee(){
        setLayout(null);
        setSize(1170, 650);
        setVisible(true); 
        setLocationRelativeTo(null); // Center the frame on the screen
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        getContentPane().setBackground(Color.orange);
        setLayout(null);

        JLabel heading = new JLabel("EMPLOYEE MANAGEMENT SYSTEM");
        heading.setBounds(350, 30, 800, 60); // Adjust the position and width
        heading.setFont(new Font("Arial", Font.BOLD, 24)); // Set a custom font and size
        add(heading);
        JLabel heading1 = new JLabel("UPDATE EMPLOYEE");
        heading1.setBounds(450, 55, 800, 60); // Adjust the position and width
        heading1.setFont(new Font("Arial", Font.BOLD, 24)); // Set a custom font and size
        add(heading1);
        
        
        
        JLabel labelname = new JLabel("NAME");
        labelname.setBounds(150,150,150,30);
        labelname.setFont(new Font("Arial", Font.PLAIN, 16)); // Set a custom font and size
        add(labelname);
        JLabel lblname = new JLabel();
        lblname.setBounds(275,150,150,30);
        add(lblname);
        
        JLabel labeldob = new JLabel("DOB");
        labeldob.setBounds(150,200,150,30);
        labeldob.setFont(new Font("Arial", Font.PLAIN, 16)); 
        add(labeldob);
        JLabel dcdob = new JLabel();
        dcdob.setBounds(275,200,150,30);
        add(dcdob);
        
        JLabel labeladdress = new JLabel("ADDRESS");
        labeladdress.setBounds(150,250,150,30);
        labeladdress.setFont(new Font("Arial", Font.PLAIN, 16)); // Set a custom font and size
        add(labeladdress);
        tfaddress = new JTextField();
        tfaddress.setBounds(275,250,150,30);
        add(tfaddress);
        
        JLabel labelmail = new JLabel("E-Mail");
        labelmail.setBounds(150,300,150,30);
        labelmail.setFont(new Font("Arial", Font.PLAIN, 16)); // Set a custom font and size
        add(labelmail);
        tfmail = new JTextField();
        tfmail.setBounds(275,300,150,30);
        add(tfmail);
        
        JLabel labeldesig= new JLabel("DESIGNATION");
        labeldesig.setBounds(150,350,150,30);
        labeldesig.setFont(new Font("Arial", Font.PLAIN, 16)); // Set a custom font and size
        add(labeldesig);
        tfdesig= new JTextField();
        tfdesig.setBounds(275,350,150,30);
        add(tfdesig);
        
        JLabel labelempid= new JLabel("EMP ID");
        labelempid.setBounds(150,400,150,30);
        labelempid.setFont(new Font("Arial", Font.PLAIN, 16)); // Set a custom font and size
        add(labelempid);
        lblempid= new JLabel();
        lblempid.setBounds(275,400,150,30);
        lblempid.setFont(new Font("Arial", Font.PLAIN, 16)); 
        add(lblempid);
        
        JLabel labelfname = new JLabel("FATHER'S NAME");
        labelfname.setBounds(600,150,150,30);
        labelfname.setFont(new Font("Arial", Font.PLAIN, 16)); // Set a custom font and size
        add(labelfname);
        tffname = new JTextField();
        tffname.setBounds(850,150,150,30);
        add(tffname);
        
        JLabel labelsal= new JLabel("SALARY");
        labelsal.setBounds(600,200,150,30);
        labelsal.setFont(new Font("Arial", Font.PLAIN, 16)); 
        add(labelsal);
        tfsal = new JTextField();
        tfsal.setBounds(850,200,150,30);
        add(tfsal);
        
        JLabel labelphone = new JLabel("PHONE");
        labelphone.setBounds(600,250,150,30);
        labelphone.setFont(new Font("Arial", Font.PLAIN, 16)); // Set a custom font and size
        add(labelphone);
        tfphone = new JTextField();
        tfphone.setBounds(850,250,150,30);
        add(tfphone);
        
        JLabel labelhigher = new JLabel("HIGHEST QUALIFICATION");
        labelhigher.setBounds(600, 300, 350, 30);
        labelhigher.setFont(new Font("Arial", Font.PLAIN, 16));
        add(labelhigher);
        tfhigher = new JTextField();
        tfhigher.setBackground(Color.WHITE);
        tfhigher.setBounds(850, 300, 150, 30);
        add(tfhigher);
        
        
        JLabel labelaadhaar = new JLabel("AADHAAR NUMBER");
        labelaadhaar.setBounds(600,350,150,30);
        labelaadhaar.setFont(new Font("Arial", Font.PLAIN, 16)); // Set a custom font and size
        add(labelaadhaar);
        JLabel lblaadhaar = new JLabel();
        lblaadhaar.setBounds(850,350,150,30);
        add(lblaadhaar);
        
        
        
         try {
            Conn c = new Conn();
            String query = "select * from employee where empId = '"+empid+"'";
            ResultSet rs = c.s.executeQuery(query);
            while(rs.next()) {
                lblname.setText(rs.getString("name"));
                tffname.setText(rs.getString("fname"));
                labeldob.setText(rs.getString("dob"));
                tfaddress.setText(rs.getString("address"));
                tfsal.setText(rs.getString("salary"));
                tfphone.setText(rs.getString("phone"));
                tfmail.setText(rs.getString("email"));
                tfhigher.setText(rs.getString("higher"));
                lblaadhaar.setText(rs.getString("aadhaar"));
                lblempid.setText(rs.getString("empid"));
                tfdesig.setText(rs.getString("desig"));
                
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        
        addDetails= new JButton("ADD DETAILS");
        addDetails.setBounds(400,500,150,30);
        addDetails.setBackground(Color.BLACK);
        addDetails.setForeground(Color.WHITE);
        addDetails.addActionListener(this);
        add(addDetails);
        
        back= new JButton("BACK");
        back.setBounds(575,500,150,30);
        back.setBackground(Color.BLACK);
        back.setForeground(Color.WHITE);
        back.addActionListener(this);
        add(back);
        
                
    }
    @Override
    public void actionPerformed(ActionEvent e){
        if(e.getSource()==addDetails){
            //String name = lblname.getText();
            String fname = tffname.getText();
            String salary = tfsal.getText();
            String address = tfaddress.getText();
            String phone = tfphone.getText();
            String email = tfmail.getText();
            String higher = tfhigher.getText();
            String desig = tfdesig.getText();
      
            try{
                Conn conn = new Conn();
                String query = "update employee set fname = '"+fname+"', salary = '"+salary+"', address = '"+address+"', phone = '"+phone+"', email =  '"+email+"', higher = '"+higher+"', desig = '"+desig+"' where empid = '"+empid+"'";
                conn.s.executeUpdate(query);
                JOptionPane.showMessageDialog(null, "Details added Successfully");
                setVisible(false);
                new Home();
                
            }catch(Exception ae){
                ae.printStackTrace();
            }
            }
        else{
            setVisible(false);
            new Home();
        }
           
    }
    
    public static void main(String[] args) {
        new UpdateEmployee();
    }
}
