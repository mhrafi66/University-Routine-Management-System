
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
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

public class MakeScheduleTwo extends JFrame implements ActionListener{
    String departments,semesters;
    
    ImageIcon Icon;
    Container c;
    JLabel Teacher, Code, Name, Designation,Dept,Semester;
    JButton Add, Update, Delete,Back,Clear,ShowAll;
    JTextField code, name, designation;
    JTextArea Info;
    JComboBox department,semester;
    String dept,sem;
    int sems;
    JScrollPane Scroll;
    private JTable table;
    private DefaultTableModel model;
    
    
    Font f,f1;
    private String[] dayhere={"Mon","Tues","Wed","Thurs","Fri"};
    private String[] col={"Day","1(8.00-8.50)","2(8.50-9.40)","3(9.40-10.30)","4(10.30-11.20)","5(11.20-12.10)","6(12.10-1.00)","7(2.30-3.20)","8(3.20-4.10)","9(4.10-5.00)"};
    private String[] row=new String[9];
    private String[] slotHere={"Slot-1(8.00-8.50)","Slot-2(8.50-9.40)","Slot-3(9.40-10.30)","Slot-4(10.30-11.20)","Slot-5(11.20-12.10)","Slot-6(12.10-1.00)","Slot-7(2.30-3.20)","Slot-8(3.20-4.10)","Slot-9(4.10-5.00)"};
    
    
    MakeScheduleTwo()
    {
        
        doSchedule();
    }
    
    public void doSchedule()
    {
         setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
         setBounds(30,20,1000,800);
         setTitle("Show Schedule");
         
         //Setting Up Icon
         Icon= new ImageIcon(getClass().getResource("index.png"));
         this.setIconImage(Icon.getImage());  
         
         //Backgroung Color
         c = this.getContentPane();
         c.setLayout(null);
         c.setBackground(Color.cyan);
         
         //font
         f = new Font("Cambria",Font.BOLD,20);
         f1 = new Font("Cambria",Font.BOLD,10);
         
         Teacher= new JLabel("Show Schedule");
         Teacher.setBounds(160, 100, 150, 50);
         Teacher.setFont(f);
         Teacher.setForeground(Color.BLUE);
         c.add(Teacher);
         
         
         Dept= new JLabel("Department :");
         Dept.setBounds(60, 200, 150, 50);
         Dept.setFont(f);
         Dept.setForeground(Color.BLUE);
         c.add(Dept);
         
         department = new JComboBox();
         department.setBounds(185, 200, 150, 50);
         department.setFont(f);
         department.setForeground(Color.BLUE);
         c.add(department);
         
         
         Semester= new JLabel("Semester : ");
         Semester.setBounds(60, 260, 150, 50);
         Semester.setFont(f);
         Semester.setForeground(Color.BLUE);
         c.add(Semester);
         
         semester = new JComboBox();
         semester.setBounds(185, 260, 150, 50);
         semester.setFont(f);
         semester.setForeground(Color.BLUE);
         c.add(semester);
         
         
         
         Back= new JButton("Back");
         Back.setBounds(5,5,150,50);
         Back.setFont(f);
         Back.setForeground(Color.BLUE);
         c.add(Back);
         
          Add= new JButton("Show");
         Add.setBounds(350,200,150,50);
         Add.setFont(f);
         Add.setForeground(Color.BLUE);
         c.add(Add);
         
         
         
         
         table=new JTable();
         model=new DefaultTableModel();
         model.setColumnIdentifiers(col);
         
         table.setModel(model);
         table.setFont(f1);
         table.setSelectionBackground(Color.BLUE);
         table.setRowHeight(70);
 
         Scroll = new JScrollPane(table);
         Scroll.setBounds(60,315,900,400);
         c.add(Scroll);
         
         String ini=null;
         for(int i=0;i<5;i++){
             row[0]=dayhere[i];
             for(int j=1;j<9;j++){
                 row[j]=ini;
             }
             model.addRow(row);
         }
         
         
         
         
         Add.addActionListener(this);
         department.addActionListener(this);
        
         Back.addActionListener(this);
         findDepartment();
         
         
         
         
         
         
         


    }
    
    
  
    

 
    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==Add){
           String s;
            s=department.getSelectedItem().toString();
            dept=s;
            s=semester.getSelectedItem().toString();
            sem=s;
            int smst=Integer.parseInt(sem);
            setTable(dept,smst);
       }
        
        else if(e.getSource()==department){
            String s=department.getSelectedItem().toString();
            dept=s;
            semester.removeAllItems();
            findSemester();
        }
      
        else if(e.getSource()==Back){
            dispose(); 
            AddInfo frame = new AddInfo();
            frame.setVisible(true);
        }
       
        
        
    }
    
        private void setTable(String _dept,int _sem){
        for(int i=0;i<5;i++){
            for(int j=0;j<9;j++){
                String course_id="";
                String teacher_id="";
                String room_id="";
                String lab_id="";
                String type="";
                String s="";
                ArrayList<String>ar=new ArrayList();
                try {
                    Routine.findTableInfo(_dept, _sem,dayhere[i], slotHere[j], ar);
                } catch (SQLException ex) {
                    Logger.getLogger(MakeScheduleOne.class.getName()).log(Level.SEVERE, null, ex);
                }
                
                 if(!ar.isEmpty()){
                    String z;
                    z=ar.get(0).toString();
                    course_id=z;
                    z=ar.get(1).toString();
                    teacher_id=z;
                    z=ar.get(2).toString();
                    room_id=z;
                    z=ar.get(3).toString();
                    lab_id=z;
                     
                 }
                 s=s+course_id+" ";
                 s=s+teacher_id+" ";
                 if("0".equals(room_id)){
                     s=s+lab_id;
                 }
                 else{
                     s=s+room_id;
                 }
                model.setValueAt(s, i, j+1);
            }
        }
    }
    
    private void findSemester() {
        Batch ob=new Batch();
        ArrayList<String>ar=new ArrayList();
        System.out.println("here");
        try {
            Batch.findSem(ar, dept);
            String a;
            for(int i=0;i<ar.size();i++){
                a=ar.get(i).toString();
                semester.addItem(a);
                
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(MakeScheduleOne.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    
    private void findDepartment() {
        Batch ob=new Batch();
        ArrayList<String>ar=new ArrayList();
        //System.out.println("here");
        try {
            Batch.findDept(ar);
            String a;
            for(int i=0;i<ar.size();i++){
                a=ar.get(i).toString();
                department.addItem(a);
                
            }
            
            
        } catch (SQLException ex) {
            Logger.getLogger(MakeScheduleOne.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
        

    public static void main(String[] args) {

         MakeScheduleTwo frame = new MakeScheduleTwo();
         frame.setVisible(true);
         
    }


}

