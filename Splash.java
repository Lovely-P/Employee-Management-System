import javax.swing.*;
import java.awt.*;

public class Splash extends JFrame {
    Splash(){
        ImageIcon i1=new ImageIcon(ClassLoader.getSystemResource("emphome.jpeg"));
        Image i2= i1.getImage().getScaledInstance(980, 580, Image.SCALE_DEFAULT);
        ImageIcon i3=new ImageIcon(i2);
        JLabel image=new JLabel(i3);
        image.setBounds(0,0,980,580);
        add(image);
        setSize(1000,600);
        setLayout(null);
        setLocation(250,120);
        setVisible(true);
        try{
            Thread.sleep(3000);
            setVisible(false);
            new Login();
        }catch (Exception e){
            e.printStackTrace();
        }
    }
    public static void main(String[] args) {
        new Splash();
    }
}
