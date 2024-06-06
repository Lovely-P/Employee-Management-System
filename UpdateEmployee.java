import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.sql.*;

public class UpdateEmployee extends JFrame implements ActionListener{

    JTextField tfeducation, tffname, tfaddress, tfphone, tfaadhar, tfemail, tfsalary, tfdesignation;
    JLabel lblempId;
    JButton add, back;
    String empId;

    UpdateEmployee(String empId) {
        this.empId = empId;
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);

        JLabel heading = new JLabel("Update Employee Detail");
        heading.setBounds(370,20,400,40);
        heading.setFont(new Font("Raleway",Font.BOLD,26));
        add(heading);

        JLabel labelname = new JLabel("Name");
        labelname.setBounds(140,150,150,30);
        labelname.setFont(new Font("serif",Font.PLAIN,20));
        add(labelname);

        JLabel lblname = new JLabel();
        lblname.setBounds(280,150,150,30);
        add(lblname);

        JLabel labelfname = new JLabel("Father's Name");
        labelfname.setBounds(500,150,150,30);
        labelfname.setFont(new Font("serif", Font.PLAIN, 20));
        add(labelfname);

        tffname = new JTextField();
        tffname.setBounds(680,150,150,30);
        add(tffname);

        JLabel labeldob = new JLabel("DOB");
        labeldob.setBounds(140,200,150,30);
        labeldob.setFont(new Font("serif", Font.PLAIN, 20));
        add(labeldob);

        JLabel lbldob = new JLabel();
        lbldob.setBounds(280,200,150,30);
        add(lbldob);

        JLabel labelsalary = new JLabel("Salary");
        labelsalary.setBounds(500,200,150,30);
        labelsalary.setFont(new Font("serif", Font.PLAIN, 20));
        add(labelsalary);

        tfsalary = new JTextField();
        tfsalary.setBounds(680,200,150,30);
        add(tfsalary);

        JLabel labeladdress = new JLabel("Address");
        labeladdress.setBounds(140,250,150,30);
        labeladdress.setFont(new Font("serif", Font.PLAIN, 20));
        add(labeladdress);

        tfaddress = new JTextField();
        tfaddress.setBounds(280,250,150,30);
        add(tfaddress);

        JLabel labelphone = new JLabel("Phone");
        labelphone.setBounds(500,250,150,30);
        labelphone.setFont(new Font("serif", Font.PLAIN, 20));
        add(labelphone);

        tfphone = new JTextField();
        tfphone.setBounds(680,250,150,30);
        add(tfphone);

        JLabel labelemail = new JLabel("Email");
        labelemail.setBounds(140,300,150,30);
        labelemail.setFont(new Font("serif", Font.PLAIN, 20));
        add(labelemail);

        tfemail = new JTextField();
        tfemail.setBounds(280,300,150,30);
        add(tfemail);

        JLabel labeleducation = new JLabel("Higest Education");
        labeleducation.setBounds(500,300,150,30);
        labeleducation.setFont(new Font("serif", Font.PLAIN, 20));
        add(labeleducation);

        tfeducation = new JTextField();
        tfeducation.setBounds(680,300,150,30);
        add(tfeducation);

        JLabel labeldesignation = new JLabel("Designation");
        labeldesignation.setBounds(140,350,150,30);
        labeldesignation.setFont(new Font("serif", Font.PLAIN, 20));
        add(labeldesignation);

        tfdesignation = new JTextField();
        tfdesignation.setBounds(280,350,150,30);
        add(tfdesignation);

        JLabel labelaadhar = new JLabel("Aadhar Number");
        labelaadhar.setBounds(500,350,150,30);
        labelaadhar.setFont(new Font("serif", Font.PLAIN, 20));
        add(labelaadhar);

        JLabel lblaadhar = new JLabel();
        lblaadhar.setBounds(680,350,150,30);
        add(lblaadhar);

        JLabel labelempId = new JLabel("Employee id");
        labelempId.setBounds(140,400,150,30);
        labelempId.setFont(new Font("serif", Font.PLAIN, 20));
        add(labelempId);

        lblempId = new JLabel();
        lblempId.setBounds(280,400,150,30);
        lblempId.setFont(new Font("serif", Font.PLAIN, 20));
        add(lblempId);

        try {
            Dbconnection conn = new Dbconnection();
            String query = "select * from Employee where empid = '"+empId+"'";
            ResultSet rs = conn.statement.executeQuery(query);
            while(rs.next()) {
                lblname.setText(rs.getString("name"));
                tffname.setText(rs.getString("fname"));
                lbldob.setText(rs.getString("dob"));
                tfaddress.setText(rs.getString("address"));
                tfsalary.setText(rs.getString("salary"));
                tfphone.setText(rs.getString("phone"));
                tfemail.setText(rs.getString("email"));
                tfeducation.setText(rs.getString("hedu"));
                lblaadhar.setText(rs.getString("aadhar"));
                lblempId.setText(rs.getString("empid"));
                tfdesignation.setText(rs.getString("designaton"));

            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        add = new JButton("Update Details");
        add.setFont(new Font("Raleway",Font.BOLD,13));
        add.setBounds(300,450,150,50);
        add.addActionListener(this);
        add.setBackground(Color.BLACK);
        add.setForeground(Color.WHITE);
        add(add);

        back = new JButton("Back");
        back.setFont(new Font("Raleway",Font.BOLD,13));
        back.setBounds(550,450,150,50);
        back.addActionListener(this);
        back.setBackground(Color.BLACK);
        back.setForeground(Color.WHITE);
        add(back);

        setSize(1120,630);
        setLocation(250,120);
        setVisible(true);
    }

    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == add) {
            String fname = tffname.getText();
            String salary = tfsalary.getText();
            String address = tfaddress.getText();
            String phone = tfphone.getText();
            String email = tfemail.getText();
            String education = tfeducation.getText();
            String designation = tfdesignation.getText();

            try {
                Dbconnection conn = new Dbconnection();
                String query = "update Employee set fname = '"+fname+"', salary = '"+salary+"', address = '"+address+"', phone = '"+phone+"', email =  '"+email+"', hedu = '"+education+"', designaton = '"+designation+"' where empid = '"+empId+"'";
                conn.statement.executeUpdate(query);
                JOptionPane.showMessageDialog(null, "Details updated successfully");
                setVisible(false);
                new Home();
            } catch (Exception e) {
                e.printStackTrace();
            }
        } else {
            setVisible(false);
            new Home();
        }
    }

    public static void main(String[] args) {
        new UpdateEmployee("");
    }
}