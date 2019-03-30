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

public class Add extends JFrame{
    
    ImageIcon Icon;
    Container c;
    JButton Batch, Teacher, Subject, Lab, Classroom,Back;
    Font f,f1;
    
    
    Add()
    {
        add();
    }
    
    public void add()
    {
         setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
         setBounds(30,20,1000,800);
         setTitle("Manage Information");
         
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
         
        
         
         Batch= new JButton("Batch");
         Batch.setBounds(350,250,150,50);
         Batch.setFont(f);
         Batch.setForeground(Color.BLUE);
         c.add(Batch);
         
         Teacher= new JButton("Teacher");
         Teacher.setBounds(350,310,150,50);
         Teacher.setFont(f);
         Teacher.setForeground(Color.BLUE);
         c.add(Teacher);
         
         Subject= new JButton("Subject");
         Subject.setBounds(350,370,150,50);
         Subject.setFont(f);
         Subject.setForeground(Color.BLUE);
         c.add(Subject);
         
         Lab= new JButton("Lab");
         Lab.setBounds(350,430,150,50);
         Lab.setFont(f);
         Lab.setForeground(Color.BLUE);
         c.add(Lab);
         
         Classroom= new JButton("Classroom");
         Classroom.setBounds(350,490,150,50);
         Classroom.setFont(f);
         Classroom.setForeground(Color.BLUE);
         c.add(Classroom);
         
         Back= new JButton("Back");
         Back.setBounds(350,550,150,50);
         Back.setFont(f);
         Back.setForeground(Color.BLUE);
         c.add(Back);
         
         
         
         
         
         Batch.addActionListener(new ActionListener()
         {
             
             @Override
             public void actionPerformed(ActionEvent e)
             {
                 
                    dispose(); 
                    BatchInfo frame = new BatchInfo();
                    frame.setVisible(true);
             }
             
         });
         
         
         Teacher.addActionListener(new ActionListener()
         {
             
             @Override
             public void actionPerformed(ActionEvent e)
             {
                 
                    dispose(); 
                    TeacherInfo frame = new TeacherInfo();
                    frame.setVisible(true);
             }
             
         });
         
         Subject.addActionListener(new ActionListener()
         {
             
             @Override
             public void actionPerformed(ActionEvent e)
             {
                 
                    dispose(); 
                    SubjectInfo frame = new SubjectInfo();
                    frame.setVisible(true);
             }
             
         });
         
         Lab.addActionListener(new ActionListener()
         {
             
             @Override
             public void actionPerformed(ActionEvent e)
             {
                 
                    dispose(); 
                    LabInfo frame = new LabInfo();
                    frame.setVisible(true);
             }
             
         });
         
         Classroom.addActionListener(new ActionListener()
         {
             
             @Override
             public void actionPerformed(ActionEvent e)
             {
                 
                    dispose(); 
                    ClassroomInfo frame = new ClassroomInfo();
                    frame.setVisible(true);
             }
             
         });
         
         Back.addActionListener(new ActionListener()
         {
             
             @Override
             public void actionPerformed(ActionEvent e)
             {
                 
                    dispose(); 
                    AddInfo frame = new AddInfo();
                    frame.setVisible(true);
             }
             
         });
         


    }
    

    public static void main(String[] args) {

         Add frame = new Add();
         frame.setVisible(true);
    }
    
}
