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
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

public class BatchInfo extends JFrame implements ActionListener{
    
    ImageIcon Icon;
    Container c;
    JLabel Batch, Semester, Dept, Prog;
    JTextField semester, dept, prog;
    JTextArea Info;
    JButton Add, Update, Delete,Back,Clear,ShowAll;
    JScrollPane Scroll;
    private JTable table;
    private DefaultTableModel model;
    Font f,f1;
    private String[] col={"Semester","Department","Program"};
    private String[] row=new String[3];
    BatchInfo()
    {
        Batch();
    }
    
    public void Batch()
    {
         setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
         setBounds(30,20,1000,800);
         setTitle("Batch");
         
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
         
         Batch= new JLabel("Batch");
         Batch.setBounds(160, 100, 150, 50);
         Batch.setFont(f1);
         Batch.setForeground(Color.BLUE);
         c.add(Batch);
         
         
         Semester= new JLabel("Semester :");
         Semester.setBounds(60, 200, 150, 50);
         Semester.setFont(f);
         Semester.setForeground(Color.BLUE);
         c.add(Semester);
         
         semester = new JTextField();
         semester.setBounds(185, 200, 150, 50);
         semester.setFont(f);
         semester.setForeground(Color.BLUE);
         c.add(semester);
         
         
         Dept= new JLabel("Department : ");
         Dept.setBounds(60, 260, 150, 50);
         Dept.setFont(f);
         Dept.setForeground(Color.BLUE);
         c.add(Dept);
         
         dept = new JTextField();
         dept.setBounds(185, 260, 150, 50);
         dept.setFont(f);
         dept.setForeground(Color.BLUE);
         c.add(dept);
         
         Prog= new JLabel("Program : ");
         Prog.setBounds(60, 320, 150, 50);
         Prog.setFont(f);
         Prog.setForeground(Color.BLUE);
         c.add(Prog);
         
         
         prog = new JTextField();
         prog.setBounds(185, 320, 150, 50);
         prog.setFont(f);
         prog.setForeground(Color.BLUE);
         c.add(prog);
         
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
         
         Back= new JButton("Back");
         Back.setBounds(5,5,150,50);
         Back.setFont(f);
         Back.setForeground(Color.BLUE);
         c.add(Back);
         
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
           
                semester.setText(cd);
                dept.setText(nm);
                prog.setText(cr);
                
             
             }
             
             
         });
         
         
         
         
         
         


    }
    
     @Override
    public void actionPerformed(ActionEvent e) {
       if(e.getSource()==Add){
           row[0]=semester.getText();
           row[1]=dept.getText();
           row[2]=prog.getText();
           Batch ob=new Batch();
           String s1=semester.getText().toString();
           String s2=dept.getText().toString();
           String s3=prog.getText().toString();
           int a=Integer.parseInt(s1);
           ob.setSemester(a);
           ob.setDept(s2);
           ob.setProg(s3);
           try {
               ob.saveInfo();
           } catch (SQLException ex) {
               Logger.getLogger(BatchInfo.class.getName()).log(Level.SEVERE, null, ex);
           }
           model.addRow(row);
       }
       else if(e.getSource()==Clear){
           semester.setText("");
           dept.setText("");
           prog.setText("");
       }
       else if(e.getSource()==Delete){
           int numberOfRow=table.getSelectedRow();
           int numberOfCol=table.getSelectedColumn();
           System.out.println(numberOfRow+" "+numberOfCol);
           String cd=model.getValueAt(numberOfRow, 0).toString();
           String nm=model.getValueAt(numberOfRow, 1).toString();
           String cr=model.getValueAt(numberOfRow, 2).toString();
           int cd2=Integer.parseInt(cd);
           Batch ob=new Batch();
           ob.setSemester(cd2);
           ob.setDept(nm);
           ob.setProg(cr);
           try {
               ob.deleteInfo();
           } catch (SQLException ex) {
               Logger.getLogger(BatchInfo.class.getName()).log(Level.SEVERE, null, ex);
           }
           
           if(numberOfRow>=0){
               model.removeRow(numberOfRow);
           }
           else{
               JOptionPane.showMessageDialog(null,"No Data to delete");
           }
           
       }
       
       else if(e.getSource()==ShowAll){
            Batch ob=new Batch();
            ArrayList<String>ar=new ArrayList();
            try {
                routinemanagementsystem.Batch.showAllBatch(ar);
                int cnt=0;
                for(int i=0;i<ar.size();i++){
                    String a;
                    a=ar.get(i).toString();
                    row[cnt]=a;
                    cnt++;
                    if(cnt==3){
                        cnt=0;
                        model.addRow(row);
                    }
                    
                }
            } catch (SQLException ex) {
                Logger.getLogger(TeacherInfo.class.getName()).log(Level.SEVERE, null, ex);
            }
            
        }
       
       else if(e.getSource()==Back){
            dispose(); 
            Add frame = new Add();
            frame.setVisible(true);

           
       }
       else if(e.getSource()==Update){
            int numberOfRow=table.getSelectedRow();
            String cd=semester.getText();
            String nm=dept.getText();
            String cr=prog.getText();
            int cd2=Integer.parseInt(cd);
            Batch ob=new Batch();
            ob.setSemester(cd2);
            ob.setDept(nm);
            ob.setProg(cr);
           try {
               ob.updateInfo();
           } catch (SQLException ex) {
               Logger.getLogger(BatchInfo.class.getName()).log(Level.SEVERE, null, ex);
           }
            
            
            model.setValueAt(cd,numberOfRow, 0);
            model.setValueAt(nm,numberOfRow, 1);
            model.setValueAt(cr,numberOfRow, 2);

            
        }
    }
    
    public static void main(String[] args) {

         BatchInfo frame = new BatchInfo();
         frame.setVisible(true);
    }

   
    
}
