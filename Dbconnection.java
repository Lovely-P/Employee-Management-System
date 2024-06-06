import javax.swing.*;
import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.Statement;

public class Dbconnection {
    Connection connection;
    Statement statement;
    Dbconnection(){
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/EmployeeManagementSystem", "root","Lovely@123");
            statement=connection.createStatement();
        }catch(Exception e){

            e.printStackTrace();

        }
    }
    public static void main(String[] args) {
        new Dbconnection();
    }
}
