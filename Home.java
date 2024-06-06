import javax.swing.*;
import javax.swing.text.View;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Home extends JFrame implements ActionListener {
    JButton view,update,remove,add;
    Home(){
        setLayout(null);
        ImageIcon i1=new ImageIcon(ClassLoader.getSystemResource("home.jpg"));
        Image i2= i1.getImage().getScaledInstance(1120, 630, Image.SCALE_DEFAULT);
        ImageIcon i3=new ImageIcon(i2);
        JLabel image=new JLabel(i3);
        image.setBounds(0,0,1120,630);
        add(image);

        JLabel heading=new JLabel("Employee Management System");
        heading.setBounds(370,20,400,40);
        heading.setFont(new Font("Raleway",Font.BOLD,26));
        image.add(heading);

        add=new JButton("Add Employee Details");
        add.setFont(new Font("Raleway",Font.BOLD,13));
        add.setBounds(260,230,200,65);
        add.addActionListener(this);
        image.add(add);

        view=new JButton("View Employee Details");
        view.setFont(new Font("Raleway",Font.BOLD,13));
        view.setBounds(590,230,200,65);
        view.addActionListener(this);
        image.add(view);

        update=new JButton("Update Employee Details");
        update.setFont(new Font("Raleway",Font.BOLD,13));
        update.setBounds(260,400,200,65);
        update.addActionListener(this);
        image.add(update);

        remove=new JButton("Remove Employee Details");
        remove.setFont(new Font("Raleway",Font.BOLD,13));
        remove.setBounds(590,400,200,65);
        remove.addActionListener(this);
        image.add(remove);

        setSize(1120,630);
        setLocation(250,120);
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
            if(e.getSource()==add){
                setVisible(false);
                new AddEmployee();
            }else if(e.getSource()==view){
                setVisible(false);
                new ViewEmployee();

            }else if(e.getSource()==update){
                setVisible(false);
                new ViewEmployee();
            }else if(e.getSource()==remove){
                setVisible(false);
                new RemoveEmployee();
            }
    }

    public static void main(String[] args) {
           new Home();
    }
}
