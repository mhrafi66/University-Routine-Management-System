package routinemanagementsystem;

import java.awt.Color;
import java.awt.Container;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

public class SubjectInfo extends JFrame implements ActionListener{
    
    ImageIcon Icon;
    Container c;
    JLabel Subject, Code, Name, Credit, Dept, Semester,Type,SType;
    JTextField subject, code, name, credit, dept, semester;
    JComboBox type,stype;
    JButton Add, Update, Delete,Back,Clear,ShowAll;
    Font f,f1;
    JScrollPane Scroll;
    private JTable table;
    private DefaultTableModel model;
    private String[] col={"Code","Name","Credit","Department","Semester","Type","Theory/Lab"};
    private String[] row=new String[7];
    private String[] t={"Core","Optional"};
    private String[] st={"Theory","Lab"};
    int thisRow;
    
    
    SubjectInfo()
    {
        Subject();
    }
    
    public void Subject()
    {
         setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
         setBounds(30,20,1000,800);
         setTitle("Course");
         
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
         
         Subject= new JLabel("Course");
         Subject.setBounds(160, 40, 150, 50);
         Subject.setFont(f1);
         Subject.setForeground(Color.BLUE);
         c.add(Subject);
         
         
         Code= new JLabel("Code :");
         Code.setBounds(60, 135, 150, 50);
         Code.setFont(f);
         Code.setForeground(Color.BLUE);
         c.add(Code);
         
         code = new JTextField();
         code.setBounds(185, 135, 150, 50);
         code.setFont(f);
         code.setForeground(Color.BLUE);
         c.add(code);
         
         
         Name= new JLabel("Name : ");
         Name.setBounds(60, 200, 150, 50);
         Name.setFont(f);
         Name.setForeground(Color.BLUE);
         c.add(Name);
         
         name = new JTextField();
         name.setBounds(185, 200, 150, 50);
         name.setFont(f);
         name.setForeground(Color.BLUE);
         c.add(name);
         
         Credit= new JLabel("Credit : ");
         Credit.setBounds(60, 260, 150, 50);
         Credit.setFont(f);
         Credit.setForeground(Color.BLUE);
         c.add(Credit);
         
         credit = new JTextField();
         credit.setBounds(185, 260, 150, 50);
         credit.setFont(f);
         credit.setForeground(Color.BLUE);
         c.add(credit);
         
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
         
         Semester= new JLabel("Semester : ");
         Semester.setBounds(60, 380, 150, 50);
         Semester.setFont(f);
         Semester.setForeground(Color.BLUE);
         c.add(Semester);
         
         semester = new JTextField();
         semester.setBounds(185, 380, 150, 50);
         semester.setFont(f);
         semester.setForeground(Color.BLUE);
         c.add(semester);
         
         Type= new JLabel("Type : ");
         Type.setBounds(60, 440, 150, 50);
         Type.setFont(f);
         Type.setForeground(Color.BLUE);
         c.add(Type);
         
         type=new JComboBox(t);
         type.setBounds(185, 440, 150, 50);
         type.setFont(f);
         type.setForeground(Color.BLUE);
         c.add(type);
         
         SType= new JLabel("Theory/Lab: ");
         SType.setBounds(60, 500, 150, 50);
         SType.setFont(f);
         SType.setForeground(Color.BLUE);
         c.add(SType);
         
         stype=new JComboBox(st);
         stype.setBounds(185, 500, 150, 50);
         stype.setFont(f);
         stype.setForeground(Color.BLUE);
         c.add(stype);
         
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
         
         Back= new JButton("Back");
         Back.setBounds(5,5,150,50);
         Back.setFont(f);
         Back.setForeground(Color.BLUE);
         c.add(Back);
         
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
         Scroll.setBounds(60,570,880,100);
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
                String sem=model.getValueAt(numberOfRow, 4).toString();
                code.setText(cd);
                name.setText(nm);
                credit.setText(cr);
                dept.setText(dpt);
                semester.setText(sem);
             
             }
             
             
         });
         
         
         
         
         
         


    }
    @Override
    public void actionPerformed(ActionEvent e) {
         if(e.getSource()==Add){
           row[0]=code.getText();
           row[1]=name.getText();
           row[2]=credit.getText();
           row[3]=dept.getText();
           row[4]=semester.getText();
           row[5]=type.getSelectedItem().toString();
           row[6]=stype.getSelectedItem().toString();
           String s1=code.getText().toString();
           String s2=name.getText().toString();
           String s3=credit.getText().toString();
           String s4=dept.getText().toString();
           String s5=semester.getText().toString();
           String s6=type.getSelectedItem().toString();
           String s7=stype.getSelectedItem().toString();
           float s3f=Float.parseFloat(s3);
           int s5i=Integer.parseInt(s5);
           Subject ob=new Subject(s1,s2,s3f,s4,s5i,s6,s7);
             try {
                 ob.saveInfo();
             } catch (SQLException ex) {
                 Logger.getLogger(SubjectInfo.class.getName()).log(Level.SEVERE, null, ex);
             }
           
           model.addRow(row);
       }
         else if(e.getSource()== Update){
             int numberOfRow=table.getSelectedRow();
            String cd=code.getText();
            String nm=name.getText();
            String cr=credit.getText();
            String dpt=dept.getText();
            String sem=semester.getText();
            String typ=type.getSelectedItem().toString();
            String styp=stype.getSelectedItem().toString();
            
           String s1=code.getText().toString();
           String s2=name.getText().toString();
           String s3=credit.getText().toString();
           String s4=dept.getText().toString();
           String s5=semester.getText().toString();
           String s6=type.getSelectedItem().toString();
           String s7=stype.getSelectedItem().toString();
           float s3f=Float.parseFloat(s3);
           int s5i=Integer.parseInt(s5);
           Subject ob=new Subject(s1,s2,s3f,s4,s5i,s6,s7);
             try {
                 ob.updateInfo();
             } catch (SQLException ex) {
                 Logger.getLogger(SubjectInfo.class.getName()).log(Level.SEVERE, null, ex);
             }
            
            model.setValueAt(cd,numberOfRow, 0);
            model.setValueAt(nm,numberOfRow, 1);
            model.setValueAt(cr,numberOfRow, 2);
            model.setValueAt(dpt,numberOfRow, 3);
            model.setValueAt(sem,numberOfRow, 4);
            model.setValueAt(typ,numberOfRow, 5);
            model.setValueAt(styp,numberOfRow, 6);
            
         }
       else if(e.getSource()==Clear){
           code.setText("");
           name.setText("");
           credit.setText("");
           dept.setText("");
           semester.setText("");
           

       }
       else if(e.getSource()==ShowAll){
            Batch ob=new Batch();
            ArrayList<String>ar=new ArrayList();
            try {
                routinemanagementsystem.Subject.showAllCourse(ar);
                int cnt=0;
                for(int i=0;i<ar.size();i++){
                    String a;
                    a=ar.get(i).toString();
                    System.out.println(a);
                    row[cnt]=a;
                    cnt++;
                    if(cnt==7){
                        cnt=0;
                        model.addRow(row);
                    }
                    
                }
            } catch (SQLException ex) {
                Logger.getLogger(TeacherInfo.class.getName()).log(Level.SEVERE, null, ex);
            }
            
        }
       else if(e.getSource()==Delete){
           int numberOfRow=table.getSelectedRow();
           String cd=model.getValueAt(numberOfRow, 0).toString();
           String nm=model.getValueAt(numberOfRow, 1).toString();
           String cr=model.getValueAt(numberOfRow, 2).toString();
           String dpt=model.getValueAt(numberOfRow, 3).toString();
           String sem=model.getValueAt(numberOfRow, 4).toString();
           String typ=model.getValueAt(numberOfRow, 5).toString();
           String styp=model.getValueAt(numberOfRow,6).toString();
           float cr2=Float.parseFloat(cr);
           int sem2=Integer.parseInt(sem);
           
           
           
           Subject ob=new Subject(cd,nm,cr2,dpt,sem2,typ,styp);
             try {
                 ob.deleteInfo();
             } catch (SQLException ex) {
                 Logger.getLogger(SubjectInfo.class.getName()).log(Level.SEVERE, null, ex);
             }
           if(numberOfRow>=0){
               model.removeRow(numberOfRow);
           }
           else{
               JOptionPane.showMessageDialog(null,"No Data to delete");
           }
           
       }
        else if(e.getSource()==Back){
            dispose(); 
            Add frame = new Add();
            frame.setVisible(true);

           
       }
        
    }

    public static void main(String[] args) {

         SubjectInfo frame = new SubjectInfo();
         frame.setVisible(true);
    }

    
    
}
