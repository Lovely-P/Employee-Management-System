
import com.mysql.cj.jdbc.ha.RandomBalanceStrategy;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;


public class AddEmployee extends JFrame implements ActionListener {
    Random random=new Random();
    int num=random.nextInt(999999);

    JTextField tname,tfname,taddr,tdesi,tphone,tdob,temail,tsalary,taddhar;
    JComboBox tedu;
    JButton add,back;
    JLabel tempid;
    AddEmployee(){
        getContentPane().setBackground(Color.white);
        setLayout(null);

        JLabel heading=new JLabel("Add Employee Details");
        heading.setBounds(370,20,400,40);
        heading.setFont(new Font("Raleway",Font.BOLD,26));
        add(heading);

        JLabel labelname=new JLabel("Name");
        labelname.setBounds(140,150,150,30);
        labelname.setFont(new Font("serif",Font.PLAIN,20));
        add(labelname);

        tname=new JTextField();
        tname.setBounds(280,150,150,30);
        add(tname);

        JLabel fname=new JLabel("Father's Name");
        fname.setBounds(500,150,150,30);
        fname.setFont(new Font("serif",Font.PLAIN,20));
        add(fname);

        tfname=new JTextField();
        tfname.setBounds(680,150,150,30);
        add(tfname);

        JLabel dob=new JLabel("DOB");
        dob.setBounds(140,200,150,30);
        dob.setFont(new Font("serif",Font.PLAIN,20));
        add(dob);

        tdob=new JTextField();
        tdob.setBounds(280,200,150,30);
        add(tdob);

        JLabel salary=new JLabel("Salary");
        salary.setBounds(500,200,150,30);
        salary.setFont(new Font("serif",Font.PLAIN,20));
        add(salary);

        tsalary=new JTextField();
        tsalary.setBounds(680,200,150,30);
        add(tsalary);

        JLabel address=new JLabel("Address");
        address.setBounds(140,250,150,30);
        address.setFont(new Font("serif",Font.PLAIN,20));
        add(address);

        taddr=new JTextField();
        taddr.setBounds(280,250,150,30);
        add(taddr);

        JLabel phone=new JLabel("Phone");
        phone.setBounds(500,250,150,30);
        phone.setFont(new Font("serif",Font.PLAIN,20));
        add(phone);

        tphone=new JTextField();
        tphone.setBounds(680,250,150,30);
        add(tphone);

        JLabel email=new JLabel("Email");
        email.setBounds(140,300,150,30);
        email.setFont(new Font("serif",Font.PLAIN,20));
        add(email);

        temail=new JTextField();
        temail.setBounds(280,300,150,30);
        add(temail);

        JLabel edu=new JLabel("Highest Education");
        edu.setBounds(500,300,150,30);
        edu.setFont(new Font("serif",Font.PLAIN,20));
        add(edu);

        String courses[]={"--Select--","BE","ME","BTech","BA","MA","Mtech","MBA","BSc","Phd","BBA","BArch","Msc"};
        tedu=new JComboBox(courses);
        tedu.setBackground(Color.white);
        tedu.setBounds(680,300,150,30);
        add(tedu);

        JLabel designation=new JLabel("Designation");
        designation.setBounds(140,350,150,30);
        designation.setFont(new Font("serif",Font.PLAIN,20));
        add(designation);

        tdesi=new JTextField();
        tdesi.setBounds(280,350,150,30);
        add(tdesi);

        JLabel aadhar=new JLabel("Aadhar Number");
        aadhar.setBounds(500,350,150,30);
        aadhar.setFont(new Font("serif",Font.PLAIN,20));
        add(aadhar);

        taddhar=new JTextField();
        taddhar.setBounds(680,350,150,30);
        add(taddhar);

        JLabel empid=new JLabel("Employee Id");
        empid.setBounds(140,400,150,30);
        empid.setFont(new Font("serif",Font.PLAIN,20));
        add(empid);

        tempid=new JLabel(""+num);
        tempid.setBounds(280,400,150,30);
        tempid.setFont(new Font("serif",Font.PLAIN,20));
        add(tempid);

        add=new JButton("Add Details");
        add.setBackground(Color.black);
        add.setForeground(Color.white);
        add.setFont(new Font("Raleway",Font.BOLD,13));
        add.setBounds(300,450,150,50);
        add.addActionListener(this);
        add(add);

        back=new JButton("Back");
        back.setBackground(Color.black);
        back.setForeground(Color.white);
        back.setFont(new Font("Raleway",Font.BOLD,13));
        back.setBounds(550,450,150,50);
        back.addActionListener(this);
        add(back);

        setSize(1120,630);
       setLocation(250,120);
       setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==add){
            String name=tname.getText();
            String fname=tfname.getText();
            String dob=tdob.getText();
            String salary=tsalary.getText();
            String address=taddr.getText();
            String phone=tphone.getText();
            String email=temail.getText();
            String hedu=(String)tedu.getSelectedItem();
            String designation=tdesi.getText();
            String aadhar= taddhar.getText();
            String empid=tempid.getText();

            try{
                Dbconnection conn=new Dbconnection();
                String query="insert into Employee values('"+name+"','"+fname+"','"+dob+"','"+salary+"','"+address+"','"+phone+"','"+email+"','"+hedu+"','"+designation+"','"+aadhar+"','"+empid+"')";
                conn.statement.executeUpdate(query);
                JOptionPane.showMessageDialog(null,"Details added Successfully");
                setVisible(false);
                new Home();
            }catch(Exception ae){
                JOptionPane.showMessageDialog(null,"Invalid Details");
                  ae.printStackTrace();
            }

        }else{
            setVisible(false);
            new Home();
        }

    }

    public static void main(String[] args) {
        new AddEmployee();
    }
}
