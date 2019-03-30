package routinemanagementsystem;

import java.awt.Color;
import java.awt.Container;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
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

public class MakeScheduleOne extends JFrame implements ActionListener{
    
    ImageIcon Icon;
    Container c;
    JLabel Schedule, Department, Semester,Course,Teacher,label,Day,Slot,Room;
    JComboBox department,semester,course,teacher,day,slot,room,Label;
    JButton Ok,Back,OK,Add,Delete;
    String dept,sem,course2,teacher2,stype,day2,slot2,room2,forclass,lab2;
    String type="Core";
    float cr;
    JScrollPane Scroll;
    private JTable table;
    private DefaultTableModel model;
    Font f,f1;
    private String[] dayhere={"Mon","Tues","Wed","Thurs","Fri"};
    private String[] col={"Day","1(8.00-8.50)","2(8.50-9.40)","3(9.40-10.30)","4(10.30-11.20)","5(11.20-12.10)","6(12.10-1.00)","7(2.30-3.20)","8(3.20-4.10)","9(4.10-5.00)"};
    private String[] row=new String[9];
    private String[] slotHere={"Slot-1(8.00-8.50)","Slot-2(8.50-9.40)","Slot-3(9.40-10.30)","Slot-4(10.30-11.20)","Slot-5(11.20-12.10)","Slot-6(12.10-1.00)","Slot-7(2.30-3.20)","Slot-8(3.20-4.10)","Slot-9(4.10-5.00)"};
    
    MakeScheduleOne()
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
         f1 = new Font("Cambria",Font.BOLD,10);
         
         //teacher
         Schedule = new JLabel("Make Schedule");
         Schedule.setBounds(430,2,200,50);
         Schedule.setFont(f);
         Schedule.setForeground(Color.BLUE);
         c.add(Schedule);
         

         Department= new JLabel("Department: ");
         Department.setBounds(5, 65, 150, 50);
         Department.setFont(f);
         Department.setForeground(Color.BLUE);
         c.add(Department);
         
         department = new JComboBox();
         department.setBounds(130, 65, 120, 50);
         department.setFont(f);
         department.setForeground(Color.BLUE);
         c.add(department);
         
         
         Semester= new JLabel("Semester : ");
         Semester.setBounds(5, 125, 150, 50);
         Semester.setFont(f);
         Semester.setForeground(Color.BLUE);
         c.add(Semester);
         
         semester = new JComboBox();
         semester.setBounds(130, 125, 120, 50);
         semester.setFont(f);
         semester.setForeground(Color.BLUE);
         c.add(semester);
         
         Course= new JLabel("Course: ");
         Course.setBounds(280, 65, 150, 50);
         Course.setFont(f);
         Course.setForeground(Color.BLUE);
         c.add(Course);
         
         course = new JComboBox();
         course.setBounds(360, 65, 200, 50);
         course.setFont(f);
         course.setForeground(Color.BLUE);
         c.add(course);
         
         Teacher= new JLabel("Teacher: ");
         Teacher.setBounds(280, 125, 150, 50);
         Teacher.setFont(f);
         Teacher.setForeground(Color.BLUE);
         c.add(Teacher);
         
         teacher = new JComboBox();
         teacher.setBounds(360, 125, 200, 50);
         teacher.setFont(f);
         teacher.setForeground(Color.BLUE);
         c.add(teacher);
         
         label= new JLabel("Class: ");
         label.setBounds(580, 25, 150, 50);
         label.setFont(f);
         label.setForeground(Color.BLUE);
         c.add(label);
         
         Label = new JComboBox();
         Label.setBounds(650, 25, 200, 40);
         Label.setFont(f);
         Label.setForeground(Color.BLUE);
         c.add(Label);
         
         Day= new JLabel("Day: ");
         Day.setBounds(580, 65, 150, 50);
         Day.setFont(f);
         Day.setForeground(Color.BLUE);
         c.add(Day);
         
         day = new JComboBox(dayhere);
         day.setBounds(650, 65, 200, 50);
         day.setFont(f);
         day.setForeground(Color.BLUE);
         c.add(day);
         
         Slot= new JLabel("Slot: ");
         Slot.setBounds(580, 125, 150, 50);
         Slot.setFont(f);
         Slot.setForeground(Color.BLUE);
         c.add(Slot);
         
         slot = new JComboBox();
         slot.setBounds(650, 125, 200, 50);
         slot.setFont(f);
         slot.setForeground(Color.BLUE);
         c.add(slot);
         
         Room= new JLabel("Room: ");
         Room.setBounds(580, 185, 150, 50);
         Room.setFont(f);
         Room.setForeground(Color.BLUE);
         c.add(Room);
         
         room = new JComboBox();
         room.setBounds(650, 185, 200, 50);
         room.setFont(f);
         room.setForeground(Color.BLUE);
         c.add(room);
         
         Add= new JButton("Add");
         Add.setBounds(650,245,100,50);
         Add.setFont(f);
         Add.setForeground(Color.BLUE);
         c.add(Add);
         
         Delete= new JButton("Delete");
         Delete.setBounds(760,245,100,50);
         Delete.setFont(f);
         Delete.setForeground(Color.BLUE);
         c.add(Delete);
         
         Ok= new JButton("Done");
         Ok.setBounds(130,185,100,50);
         Ok.setFont(f);
         Ok.setForeground(Color.BLUE);
         c.add(Ok);
         
         OK= new JButton("Done");
         OK.setBounds(360,185,100,50);
         OK.setFont(f);
         OK.setForeground(Color.BLUE);
         c.add(OK);
         
         Back= new JButton("Back");
         Back.setBounds(5,5,150,50);
         Back.setFont(f);
         Back.setForeground(Color.BLUE);
         c.add(Back);
         
         table=new JTable();
         model=new DefaultTableModel();
         model.setColumnIdentifiers(col);
         
         table.setModel(model);
         table.setFont(f1);
         table.setSelectionBackground(Color.BLUE);
         table.setRowHeight(70);
 
         Scroll = new JScrollPane(table);
         Scroll.setBounds(60,300,900,400);
         c.add(Scroll);
         
         String ini=null;
         for(int i=0;i<5;i++){
             row[0]=dayhere[i];
             for(int j=1;j<9;j++){
                 row[j]=ini;
             }
             model.addRow(row);
         }
         
         department.addActionListener(this);
         semester.addActionListener(this);
         Ok.addActionListener(this);
         OK.addActionListener(this);
         Back.addActionListener(this);
         day.addActionListener(this);
         slot.addActionListener(this);
         Add.addActionListener(this);
         Delete.addActionListener(this);
         
         findDepartment();
         
         
         


    }
    
    
    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==Ok){
            course.removeAllItems();
            teacher.removeAllItems();
            Label.removeAllItems();
            slot.removeAllItems();
            room.removeAllItems();
            String s;
            s=department.getSelectedItem().toString();
            dept=s;
            s=semester.getSelectedItem().toString();
            sem=s;
            int smst=Integer.parseInt(sem);
            setTable(dept,smst);
            ArrayList<String>ar=new ArrayList();
            ArrayList<String>ar2=new ArrayList();
            ArrayList<String>ar3=new ArrayList();
            try {
                Routine.findAvailableCourse(dept, sem, ar);
            } catch (SQLException ex) {
                Logger.getLogger(MakeScheduleOne.class.getName()).log(Level.SEVERE, null, ex);
            }
            try {
                Routine.findAvailableCourse2(dept, sem, ar2);
            } catch (SQLException ex) {
                Logger.getLogger(MakeScheduleOne.class.getName()).log(Level.SEVERE, null, ex);
            }
            for(int i=0;i<ar.size();i++){
                int flag=0;
                for(int j=0;j<ar2.size();j++){
                   if(ar.get(i).equals(ar2.get(j))){
                       flag=1;
                        break;
                   } 
                }
                if(flag==0){
                    String a;
                    a=ar.get(i).toString();
                    course.addItem(a);
                    
                }
            }
            ArrayList<String>ar4=new ArrayList();
            try {
                routinemanagementsystem.Teacher.showAllTeacher(ar4, dept);
            } catch (SQLException ex) {
                Logger.getLogger(MakeScheduleOne.class.getName()).log(Level.SEVERE, null, ex);
            }
            for(int i=0;i<ar4.size();i++){
                String a;
                a=ar4.get(i).toString();
                teacher.addItem(a);
            }
            
        }
        else if(e.getSource()==Add){
            dept=department.getSelectedItem().toString();
            sem=semester.getSelectedItem().toString();
            int semst=Integer.parseInt(sem);
            course2=course.getSelectedItem().toString();
            teacher2=teacher.getSelectedItem().toString();
            day2=day.getSelectedItem().toString();
            slot2=slot.getSelectedItem().toString();
            if("Theory".equals(stype)){
                room2=room.getSelectedItem().toString();
                lab2="0";
            }
            else if("Lab".equals(stype)){
               lab2=room.getSelectedItem().toString();
               room2="0";
            }
            Routine ob=new Routine(dept,semst,course2,teacher2,cr,day2,slot2,type,stype,room2,lab2);
            try {
                ob.saveInfo();
            } catch (SQLException ex) {
                Logger.getLogger(MakeScheduleOne.class.getName()).log(Level.SEVERE, null, ex);
            }
           
           setTable(dept,semst); 
        }
        
        else if(e.getSource()==slot){
            //room.removeAllItems();
            String s=slot.getSelectedItem().toString();
            slot2=s;
            
            if("Theory".equals(stype)){
                //System.out.println(stype);
                ArrayList<String>ar=new ArrayList();
                ArrayList<String>ar2=new ArrayList();
                try {
                    Routine.findAllRoom(ar);
                } catch (SQLException ex) {
                    Logger.getLogger(MakeScheduleOne.class.getName()).log(Level.SEVERE, null, ex);
                }
                try {
                    Routine.findAvailableRoom(stype, day2, slot2, ar2);
                } catch (SQLException ex) {
                    Logger.getLogger(MakeScheduleOne.class.getName()).log(Level.SEVERE, null, ex);
                }
                
                for(int i=0;i<ar.size();i++){
                    String l=ar.get(i).toString();
                    int flag=0;
                    
                    for(int j=0;j<ar2.size();j++){
                        String m=ar2.get(j).toString();
                        if(l.equals(m)){
                            flag=1;
                            break;
                        }
                        
                    }
                    if(flag==0){
                            room.addItem(l);
                        }
                    
                }
                
            }
            else if("Lab".equals(stype)){
                //System.out.println(stype);
                ArrayList<String>ar=new ArrayList();
                ArrayList<String>ar2=new ArrayList();
                try {
                    Routine.findAllLab(ar);
                } catch (SQLException ex) {
                    Logger.getLogger(MakeScheduleOne.class.getName()).log(Level.SEVERE, null, ex);
                }
                try {
                    Routine.findAvailableLab(stype, day2, slot2, ar2);
                } catch (SQLException ex) {
                    Logger.getLogger(MakeScheduleOne.class.getName()).log(Level.SEVERE, null, ex);
                }
                
                for(int i=0;i<ar.size();i++){
                    String l=ar.get(i).toString();
                    int flag=0;
                    
                    for(int j=0;j<ar2.size();j++){
                        String m=ar2.get(j).toString();
                        if(l.equals(m)){
                            flag=1;
                            break;
                        }
                        
                    }
                    if(flag==0){
                            room.addItem(l);
                        }
                    
                }
                
            }
            
        }
        else if(e.getSource()==day){
            /*slot.removeAllItems();
            room.removeAllItems();*/
            day2=day.getSelectedItem().toString();
            ArrayList<String>ar=new ArrayList();
            try {
                Routine.findTeacherSlot(teacher2,day2,ar);
            } catch (SQLException ex) {
                Logger.getLogger(MakeScheduleOne.class.getName()).log(Level.SEVERE, null, ex);
            }
            int semt=Integer.parseInt(sem);
            try {
                Routine.findStudentSlot(dept, semt, day2, ar);
            } catch (SQLException ex) {
                Logger.getLogger(MakeScheduleOne.class.getName()).log(Level.SEVERE, null, ex);
            }
            for(int i=0;i<slotHere.length;i++){
                String s=slotHere[i];
                int flag=0;
                for(int j=0;j<ar.size();j++){
                    String a;
                    a=ar.get(j).toString();
                    if(s.equals(a)){
                        flag=1;
                        break;
                    }
                }
                if(flag==0){
                    slot.addItem(s);
                }
            }
            
        }
        
        else if(e.getSource()==OK){
            Label.removeAllItems();
            slot.removeAllItems();
            room.removeAllItems();
            String s;
            s=course.getSelectedItem().toString();
            course2=s;
            s=teacher.getSelectedItem().toString();
            teacher2=s;
            ArrayList<String>ar=new ArrayList();
            try {
                Routine.showAllCourse(course2, ar);
            } catch (SQLException ex) {
                Logger.getLogger(MakeScheduleOne.class.getName()).log(Level.SEVERE, null, ex);
            }
            String flo;
            flo=ar.get(0).toString();
            cr=Float.parseFloat(flo);
            stype=ar.get(1).toString();
            //System.out.println(stype);
            if(stype.equals("Lab")){
                cr=cr*2;
            }
            int loop;
            loop=(int)Math.ceil(cr);
            String shh="Class: ";
            for(int i=1;i<=loop;i++){
                String ad=Integer.toString(i);
                Label.addItem(ad);
                
            }
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
        else if(e.getSource()==Delete){
            dispose(); 
            MakeScheduleThree frame = new MakeScheduleThree();
            frame.setVisible(true);
        }
    }
    
    private void findSemester() {
        Batch ob=new Batch();
        ArrayList<String>ar=new ArrayList();
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
    
    private void findDepartment() {
        Batch ob=new Batch();
        ArrayList<String>ar=new ArrayList();
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

         MakeScheduleOne frame = new MakeScheduleOne();
         frame.setVisible(true);
    }

    

    

    

    
    
}

