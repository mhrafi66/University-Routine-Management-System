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
import javax.swing.JPasswordField;
import javax.swing.JTextField;

public class AddInfo extends JFrame{
    
    ImageIcon Icon;
    Container c;
    JButton Add, Update, Make,Back,Show;
    Font f,f1;
    
    
    AddInfo()
    {
        Add();
    }
    
    public void Add()
    {
         setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
         setBounds(30,20,1000,800);
         setTitle("Add info");
         
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
         
        
         
         Add= new JButton("Manage Info");
         Add.setBounds(140,300,220,110);
         Add.setFont(f);
         Add.setForeground(Color.BLUE);
         c.add(Add);
         
         Make= new JButton("Make Schedule");
         Make.setBounds(380,300,200,110);
         Make.setFont(f);
         Make.setForeground(Color.BLUE);
         c.add(Make);
         
         Show= new JButton("Show Schedule");
         Show.setBounds(620,300,200,110);
         Show.setFont(f);
         Show.setForeground(Color.BLUE);
         c.add(Show);
         
         Back= new JButton("Log Out");
         Back.setBounds(400,450,150,55);
         Back.setFont(f);
         Back.setForeground(Color.BLUE);
         c.add(Back);
         
         
         
         
         
         Add.addActionListener(new ActionListener()
         {
             
             @Override
             public void actionPerformed(ActionEvent e)
             {
                 
                    dispose(); 
                    Add frame = new Add();
                    frame.setVisible(true);
             }
             
         });
         
         Show.addActionListener(new ActionListener()
         {
             
             @Override
             public void actionPerformed(ActionEvent e)
             {
                 
                    dispose(); 
                    MakeScheduleTwo frame = new MakeScheduleTwo();
                    frame.setVisible(true);
             }
             
         });
         
         
         Make.addActionListener(new ActionListener()
         {
             
             @Override
             public void actionPerformed(ActionEvent e)
             {
                 
                   dispose(); 
                    MakeScheduleOne frame = new MakeScheduleOne();
                    frame.setVisible(true);
             }
             
         });
         
         Back.addActionListener(new ActionListener()
         {
             
             @Override
             public void actionPerformed(ActionEvent e)
             {
                 
                   dispose(); 
                    ScheduleMaker frame = new ScheduleMaker();
                    frame.setVisible(true);
             }
             
         });
         
         


    }
    

    public static void main(String[] args) {

         AddInfo frame = new AddInfo();
         frame.setVisible(true);
    }
    
}
