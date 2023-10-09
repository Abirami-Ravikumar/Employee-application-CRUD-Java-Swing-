package employee.management.system;
/*
5 steps in JDBC
1) Registering the Driver class
2) Creating the connection String
3) Creating statement
4) Executing mysql queries
5) Closing the connections
*/
import java.sql.*;
import java.sql.SQLException;
import java.sql.DriverManager;
public class Conn {
    
    Connection c;
    Statement s;
    
    public Conn(){
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            c = DriverManager.getConnection("jdbc:mysql://localhost:3306/employeemanagementsystem","root","glacier*99");
            s = c.createStatement();
            //System.out.println("sucess");
        }catch(Exception e){
            e.printStackTrace();
        }
            
    }
    public static void main(String[] args) {
        new Conn();
    }
}
