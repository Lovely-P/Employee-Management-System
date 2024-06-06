import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import net.proteanit.sql.DbUtils;

public class ViewEmployee extends JFrame implements ActionListener {
    JTable table;
    Choice chempid;

    JButton search,print,update,back;
    ViewEmployee(){

        getContentPane().setBackground(Color.white);
        setLayout(null);

        JLabel searchid=new JLabel("Search by Employee ID");
        searchid.setFont(new Font("Raleway",Font.BOLD,15));
        searchid.setBounds(10,30,180,40);
        add(searchid);

        chempid=new Choice();
        chempid.setBounds(200,40,200,40);
        add(chempid);


        search=new JButton("search");
        search.setFont(new Font("Raleway",Font.BOLD,13));
        search.setBounds(10,80,100,25);
        search.addActionListener(this);
        add(search);

        print=new JButton("Print");
        print.setFont(new Font("Raleway",Font.BOLD,13));
        print.setBounds(130,80,100,25);
        print.addActionListener(this);
        add(print);

        update=new JButton("Update");
        update.setFont(new Font("Raleway",Font.BOLD,13));
        update.setBounds(250,80,100,25);
        update.addActionListener(this);
        add(update);

        back=new JButton("Back");
        back.setFont(new Font("Raleway",Font.BOLD,13));
        back.setBounds(370,80,100,25);
        back.addActionListener(this);
        add(back);


        try{
            Dbconnection conn=new Dbconnection();
            ResultSet resultSet=conn.statement.executeQuery("select * from Employee");
            while(resultSet.next()){
                chempid.add(resultSet.getString("empid"));
            }
        }catch(Exception e){
            e.printStackTrace();

        }

        table=new JTable();

        try{
            Dbconnection conn=new Dbconnection();
            ResultSet resultSet=conn.statement.executeQuery("select * from Employee");
            table.setModel(DbUtils.resultSetToTableModel(resultSet));
        }catch(Exception e){
            e.printStackTrace();

        }
        JScrollPane jScrollPane=new JScrollPane(table);
        jScrollPane.setBounds(0,130,1120,630);
        add(jScrollPane);

        setSize(1120,630);
        setLocation(250,120);
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==search){
            String query="select * from Employee where empid='"+chempid.getSelectedItem()+"'";
            try{
                Dbconnection conn=new Dbconnection();
                ResultSet resultSet=conn.statement.executeQuery(query);
                table.setModel(DbUtils.resultSetToTableModel(resultSet));
            }catch(Exception e1){
                e1.printStackTrace();
            }

        }else if(e.getSource()==print){
            try{
                table.print();
            }catch(Exception e2){
                e2.printStackTrace();
            }

        }else if(e.getSource()==update){
            setVisible(false);
            new UpdateEmployee(chempid.getSelectedItem());

        }else if(e.getSource()==back){
            setVisible(false);
            new Home();
        }

    }

    public static void main(String[] args) {
        new ViewEmployee();

    }
}
