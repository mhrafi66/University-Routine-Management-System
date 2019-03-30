package routinemanagementsystem;

import java.awt.Color;
import java.awt.Container;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

public class ScheduleMaker extends JFrame{
    
    ImageIcon Icon;
    Container c;
    JLabel Schedule, User, Pass;
    JTextField UserName;
    JPasswordField Password;
    JButton Login;
    Font f,f1;
    
    
    ScheduleMaker()
    {
        SetupFrame();
    }
    
    public void SetupFrame()
    {
         setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
         setBounds(30,20,1000,800);
         setTitle("Classroom Management System");
         
         //Setting Up Icon
         Icon= new ImageIcon(getClass().getResource("index.png"));
         this.setIconImage(Icon.getImage());  
         
         //Backgroung Color
         c = this.getContentPane();
         c.setLayout(null);
         c.setBackground(Color.cyan);
         
         //font
         f = new Font("Cambria",Font.BOLD,20);
         f1 = new Font("Cambria",Font.BOLD,25);
         
         //teacher
         Schedule = new JLabel("Schedule Maker");
         Schedule.setBounds(430,60,200,50);
         Schedule.setFont(f1);
         Schedule.setForeground(Color.BLUE);
         c.add(Schedule);
         

         User= new JLabel("Username: ");
         User.setBounds(300, 200, 150, 50);
         User.setFont(f);
         User.setForeground(Color.BLUE);
         c.add(User);
         
         UserName = new JTextField();
         UserName.setBounds(420, 200, 150, 50);
         UserName.setFont(f);
         UserName.setForeground(Color.BLUE);
         c.add(UserName);
         
         
         Pass= new JLabel("Password : ");
         Pass.setBounds(300, 260, 150, 50);
         Pass.setFont(f);
         Pass.setForeground(Color.BLUE);
         c.add(Pass);
         
         Password = new JPasswordField();
         Password.setBounds(420, 260, 150, 50);
         Password.setFont(f);
         Password.setForeground(Color.BLUE);
         c.add(Password);
         
         Login= new JButton("Login");
         Login.setBounds(420,340,150,50);
         Login.setFont(f);
         Login.setForeground(Color.BLUE);
         c.add(Login);
         
         
         
         
         Login.addActionListener(new ActionListener()
         {
             
             @Override
             public void actionPerformed(ActionEvent e)
             {
                 String a,b;
                 a=UserName.getText();
                 b=Password.getText();
                 if(b.equals(Admin.getPassword()) && a.equals(Admin.getUSN())){
                    dispose(); 
                    AddInfo frame = new AddInfo();
                    frame.setVisible(true);
                 }
                 else {
                     JOptionPane.showMessageDialog(null,"UserName or Password is incorrect");
                 }
             }
             
         });
         
         


    }
    

    public static void main(String[] args) {

         ScheduleMaker frame = new ScheduleMaker();
         frame.setVisible(true);
    }
    
}
