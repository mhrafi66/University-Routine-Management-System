package routinemanagementsystem;

import java.awt.Color;
import java.awt.Container;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Array;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

public class TeacherInfo extends JFrame implements ActionListener{
    
    ImageIcon Icon;
    Container c;
    JLabel Teacher, Code, Name, Dept, Designation;
    JButton Add, Update, Delete,Back,Clear,ShowAll;
    JTextField code, name, dept, designation;
    JTextArea Info;
    JScrollPane Scroll;
    private JTable table;
    private DefaultTableModel model;
    private String[] col={"Code","Name","Department","Designation"};
    private String[] row=new String[4];
    
    Font f,f1;
    
    
    TeacherInfo()
    {
        Teacher();
    }
    
    public void Teacher()
    {
         setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
         setBounds(30,20,1000,800);
         setTitle("Teacher");
         
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
         
         Teacher= new JLabel("Teacher");
         Teacher.setBounds(160, 100, 150, 50);
         Teacher.setFont(f1);
         Teacher.setForeground(Color.BLUE);
         c.add(Teacher);
         
         
         Code= new JLabel("Code :");
         Code.setBounds(60, 200, 150, 50);
         Code.setFont(f);
         Code.setForeground(Color.BLUE);
         c.add(Code);
         
         code = new JTextField();
         code.setBounds(185, 200, 150, 50);
         code.setFont(f);
         code.setForeground(Color.BLUE);
         c.add(code);
         
         
         Name= new JLabel("Name : ");
         Name.setBounds(60, 260, 150, 50);
         Name.setFont(f);
         Name.setForeground(Color.BLUE);
         c.add(Name);
         
         name = new JTextField();
         name.setBounds(185, 260, 150, 50);
         name.setFont(f);
         name.setForeground(Color.BLUE);
         c.add(name);
         
         Dept= new JLabel("Department : ");
         Dept.setBounds(60, 320, 150, 50);
         Dept.setFont(f);
         Dept.setForeground(Color.BLUE);
         c.add(Dept);
         
         dept = new JTextField();
         dept.setBounds(185, 320, 150, 50);
         dept.setFont(f);
         dept.setForeground(Color.BLUE);
         c.add(dept);
         
         Designation= new JLabel("Designation : ");
         Designation.setBounds(60, 380, 150, 50);
         Designation.setFont(f);
         Designation.setForeground(Color.BLUE);
         c.add(Designation);
         
         designation = new JTextField();
         designation.setBounds(185, 380, 150, 50);
         designation.setFont(f);
         designation.setForeground(Color.BLUE);
         c.add(designation);
         
         Back= new JButton("Back");
         Back.setBounds(5,5,150,50);
         Back.setFont(f);
         Back.setForeground(Color.BLUE);
         c.add(Back);
         
          Add= new JButton("Add");
         Add.setBounds(350,200,150,50);
         Add.setFont(f);
         Add.setForeground(Color.BLUE);
         c.add(Add);
         
         Update= new JButton("Update");
         Update.setBounds(350,260,150,50);
         Update.setFont(f);
         Update.setForeground(Color.BLUE);
         c.add(Update);
         
         Delete= new JButton("Delete");
         Delete.setBounds(350,320,150,50);
         Delete.setFont(f);
         Delete.setForeground(Color.BLUE);
         c.add(Delete);
         
         Clear= new JButton("Clear");
         Clear.setBounds(350,380,150,50);
         Clear.setFont(f);
         Clear.setForeground(Color.BLUE);
         c.add(Clear);
         
         ShowAll= new JButton("ShowAll");
         ShowAll.setBounds(350,440,150,50);
         ShowAll.setFont(f);
         ShowAll.setForeground(Color.BLUE);
         c.add(ShowAll);
         
         table=new JTable();
         model=new DefaultTableModel();
         model.setColumnIdentifiers(col);
         table.setModel(model);
         table.setFont(f);
         table.setSelectionBackground(Color.BLUE);
         table.setRowHeight(30);
 
         Scroll = new JScrollPane(table);
         Scroll.setBounds(60,500,880,140);
         c.add(Scroll);
         
         
         
         Add.addActionListener(this);
         Clear.addActionListener(this);
         Back.addActionListener(this);
         Delete.addActionListener(this);
         Update.addActionListener(this);
         ShowAll.addActionListener(this);
         table.addMouseListener(new MouseAdapter(){
             @Override
             public void mouseClicked(MouseEvent me){
                int numberOfRow=table.getSelectedRow();
              
                String cd=model.getValueAt(numberOfRow, 0).toString();
                String nm=model.getValueAt(numberOfRow, 1).toString();
                String cr=model.getValueAt(numberOfRow, 2).toString();
                String dpt=model.getValueAt(numberOfRow, 3).toString();
                code.setText(cd);
                name.setText(nm);
                dept.setText(cr);
                designation.setText(dpt);

             }
             
             
         });
         
         
         
         
         
         


    }
    
    
  
    

 
    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==Add){
           row[0]=code.getText();
           row[1]=name.getText();
           row[2]=dept.getText();
           row[3]=designation.getText();
           
           String s1=code.getText().toString();
           String s2=name.getText().toString();
           String s3=dept.getText().toString();
           String s4=designation.getText().toString();
           
           Teacher ob=new Teacher(s1,s2,s4,s3);
            try {
                ob.saveInfo();
            } catch (SQLException ex) {
                Logger.getLogger(TeacherInfo.class.getName()).log(Level.SEVERE, null, ex);
            }
           
           model.addRow(row);
       }
       else if(e.getSource()==Clear){
           code.setText("");
           name.setText("");
           dept.setText("");
           designation.setText("");
       }
       else if(e.getSource()==Delete){
           int numberOfRow=table.getSelectedRow();
           
           String cd=model.getValueAt(numberOfRow, 0).toString();
           String nm=model.getValueAt(numberOfRow, 1).toString();
           String cr=model.getValueAt(numberOfRow, 2).toString();
           String dpt=model.getValueAt(numberOfRow, 3).toString();
           
           if(numberOfRow>=0){
               model.removeRow(numberOfRow);
           }
           else{
               JOptionPane.showMessageDialog(null,"No Data to delete");
               return;
           }
           
           Teacher ob=new Teacher(cd,nm,dpt,cr);
            try {
                ob.deleteInfo();
            } catch (SQLException ex) {
                Logger.getLogger(TeacherInfo.class.getName()).log(Level.SEVERE, null, ex);
            }
           
           
           
       }
        else if(e.getSource()==Back){
            dispose(); 
            Add frame = new Add();
            frame.setVisible(true);

           
       }
        else if(e.getSource()==ShowAll){
            Teacher ob=new Teacher();
            ArrayList<String>ar=new ArrayList();
            try {
                routinemanagementsystem.Teacher.showAllTeacher(ar);
                int cnt=0;
                for(int i=0;i<ar.size();i++){
                    String a;
                    a=ar.get(i).toString();
                    row[cnt]=a;
                    cnt++;
                    if(cnt==4){
                        cnt=0;
                        model.addRow(row);
                    }
                    
                }
            } catch (SQLException ex) {
                Logger.getLogger(TeacherInfo.class.getName()).log(Level.SEVERE, null, ex);
            }
            
        }
        else if(e.getSource()== Update){
             int numberOfRow=table.getSelectedRow();
            String cd=code.getText();
            String nm=name.getText();
            String cr=dept.getText();
            String dpt=designation.getText();
            
            
           String s1=code.getText().toString();
           String s2=name.getText().toString();
           String s3=dept.getText().toString();
           String s4=designation.getText().toString();
           
           Teacher ob=new Teacher(s1,s2,s4,s3);
            try {
                ob.updateInfo();
            } catch (SQLException ex) {
                Logger.getLogger(TeacherInfo.class.getName()).log(Level.SEVERE, null, ex);
            }
            
            
            model.setValueAt(cd,numberOfRow, 0);
            model.setValueAt(nm,numberOfRow, 1);
            model.setValueAt(cr,numberOfRow, 2);
            model.setValueAt(dpt,numberOfRow, 3);

            
         }
        
    }
        

    public static void main(String[] args) {

         TeacherInfo frame = new TeacherInfo();
         frame.setVisible(true);
    }


}
