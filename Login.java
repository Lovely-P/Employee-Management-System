import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

public class Login extends JFrame implements ActionListener {
    JButton login,back;
    JTextField tusername;
    JPasswordField tpassword;
    Login() {

        JLabel username = new JLabel("UserName:");
        username.setBounds(40, 20, 100, 30);
        add(username);
        JLabel password = new JLabel("Password:");
        password.setBounds(40, 70, 100, 30);
        add(password);
        tusername = new JTextField();
        tusername.setBounds(150, 20, 150, 30);
        add(tusername);
        tpassword = new JPasswordField();
        tpassword.setBounds(150, 70, 150, 30);
        add(tpassword);

        login = new JButton("LOGIN");
        login.setBounds(60, 140, 110, 30);
        login.setBackground(Color.black);
        login.setForeground(Color.white);
        login.addActionListener(this);
        add(login);
         back = new JButton("BACK");
        back.setBounds(180, 140, 110, 30);
        back.setBackground(Color.black);
        back.setForeground(Color.white);
        back.addActionListener(this);
        add(back);


        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("emmpid.jpg"));
        Image i2 = i1.getImage().getScaledInstance(200, 180, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(350, 20, 200, 200);
        add(image);


        setSize(600, 300);
        setLocation(450, 200);
        setLayout(null);
        setVisible(true);

    }
        @Override
        public void actionPerformed(ActionEvent e){
            if (e.getSource() == login) {
                try{
                    String username=tusername.getText();
                    String password=tpassword.getText();

                    Dbconnection dbconnection=new Dbconnection();
                    String query="select * from Login where username= '"+username+"'and password= '"+password+"'";
                    ResultSet resultSet=dbconnection.statement.executeQuery(query);
                   if(resultSet.next()){
                       setVisible(false);
                        new Home();
                   }else{
                       JOptionPane.showMessageDialog(null,"Invalid username or password");


                   }
                }catch (Exception e1){
                    e1.printStackTrace();

                }

            } else if (e.getSource() == back) {
                System.exit(0);
            }
        }

    public static void main(String[] args) {
        new Login();
    }
}
