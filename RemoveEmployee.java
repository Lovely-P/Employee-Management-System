import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.sql.ResultSet;

public class RemoveEmployee extends JFrame implements ActionListener {
    Choice empdrop;
    JButton delete,back;
    RemoveEmployee(){
        getContentPane().setBackground(Color.white);
        setLayout(null);

        JLabel heading=new JLabel("Remove Employee Details");
        heading.setBounds(300,30,400,40);
        heading.setFont(new Font("Raleway",Font.BOLD,26));
        add(heading);

        JLabel empid=new JLabel("Employee ID");
        empid.setFont(new Font("serif",Font.BOLD,20));
        empid.setBounds(300,140,150,30);
        add(empid);

        empdrop=new Choice();
        empdrop.setBounds(480,150,150,30);
        add(empdrop);

        try{
            Dbconnection conn=new Dbconnection();
            String query="select * from Employee";
            ResultSet resultSet=conn.statement.executeQuery(query);

            while(resultSet.next()){
                empdrop.add(resultSet.getString("empid"));
            }

        }catch(Exception e){
            e.printStackTrace();
        }


        JLabel labelname=new JLabel("Name");
        labelname.setBounds(340,200,150,30);
        labelname.setFont(new Font("serif",Font.PLAIN,20));
        add(labelname);

        JLabel lblname=new JLabel();
        lblname.setBounds(480,200,150,30);
        lblname.setFont(new Font("serif",Font.PLAIN,20));
        add(lblname);

        JLabel labelphone=new JLabel("Phone");
        labelphone.setBounds(340,250,150,30);
        labelphone.setFont(new Font("serif",Font.PLAIN,20));
        add(labelphone);

        JLabel lblphone=new JLabel();
        lblphone.setBounds(480,250,150,30);
        lblphone.setFont(new Font("serif",Font.PLAIN,20));
        add(lblphone);

        JLabel labelemail=new JLabel("Email");
        labelemail.setBounds(340,300,150,30);
        labelemail.setFont(new Font("serif",Font.PLAIN,20));
        add(labelemail);

        JLabel lblemail=new JLabel();
        lblemail.setBounds(480,300,200,30);
        lblemail.setFont(new Font("serif",Font.PLAIN,20));
        add(lblemail);

        try{
            Dbconnection conn=new Dbconnection();
            String query="select * from Employee where empid='"+empdrop.getSelectedItem()+"'";
            ResultSet resultSet=conn.statement.executeQuery(query);

            while(resultSet.next()){
                lblname.setText(resultSet.getString("name"));
                lblphone.setText(resultSet.getString("phone"));
                lblemail.setText(resultSet.getString("email"));

            }

        }catch(Exception e){
            e.printStackTrace();
        }
        empdrop.addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent e) {
                try{
                    Dbconnection conn=new Dbconnection();
                    String query="select * from Employee where empid='"+empdrop.getSelectedItem()+"'";
                    ResultSet resultSet=conn.statement.executeQuery(query);

                    while(resultSet.next()){
                        lblname.setText(resultSet.getString("name"));
                        lblphone.setText(resultSet.getString("phone"));
                        lblemail.setText(resultSet.getString("email"));

                    }
                }catch(Exception ae){
                    ae.printStackTrace();
                }

            }
        });

        delete=new JButton("Delete Details");
        delete.setBounds(300,450,150,50);
        delete.setFont(new Font("Raleway",Font.BOLD,13));
        delete.setBackground(Color.black);
        delete.setForeground(Color.white);
        delete.addActionListener(this);
        add(delete);

        back=new JButton("Back");
        back.setBounds(550,450,150,50);
        back.setFont(new Font("Raleway",Font.BOLD,13));
        back.setBackground(Color.black);
        back.setForeground(Color.white);
        back.addActionListener(this);
        add(back);


        setSize(1120,630);
        setLocation(250,120);
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==delete){
            try{
                Dbconnection conn=new Dbconnection();
                String query="delete from Employee where empid='"+empdrop.getSelectedItem()+"'";
                conn.statement.executeUpdate(query);
                JOptionPane.showMessageDialog(null,"Employee Details Deleted Successfully");
                setVisible(false);
                new Home();
            }catch (Exception e2){
                e2.printStackTrace();

            }

        }else {
            setVisible(false);
            new Home();
        }

    }

    public static void main(String[] args) {
        new RemoveEmployee();
    }
}
