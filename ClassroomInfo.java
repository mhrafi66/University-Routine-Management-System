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
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

public class ClassroomInfo extends JFrame implements ActionListener{
    
    ImageIcon Icon;
    Container c;
    JLabel ROOM,Room, Location;
    JTextField room, location;
    JButton Add, Update, Delete,Back,Clear,ShowAll;
    Font f,f1;
    JScrollPane Scroll;
    private JTable table;
    private DefaultTableModel model;
    private String[] col={"Classroom","Location"};
    private String[] row=new String[2];
    
    
    ClassroomInfo()
    {
        ROOM();
    }
    
    public void ROOM()
    {
         setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
         setBounds(30,20,1000,800);
         setTitle("Classroom");
         
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
         
         ROOM= new JLabel("ROOM");
         ROOM.setBounds(160, 100, 150, 50);
         ROOM.setFont(f1);
         ROOM.setForeground(Color.BLUE);
         c.add(ROOM);
         
         
         Room= new JLabel("Room No: ");
         Room.setBounds(60, 200, 150, 50);
         Room.setFont(f);
         Room.setForeground(Color.BLUE);
         c.add(Room);
         
         room = new JTextField();
         room.setBounds(185, 200, 150, 50);
         room.setFont(f);
         room.setForeground(Color.BLUE);
         c.add(room);
         
         
         Location= new JLabel("Location : ");
         Location.setBounds(60, 260, 150, 50);
         Location.setFont(f);
         Location.setForeground(Color.BLUE);
         c.add(Location);
         
         location = new JTextField();
         location.setBounds(185, 260, 150, 50);
         location.setFont(f);
         location.setForeground(Color.BLUE);
         c.add(location);
         
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

                room.setText(cd);
                location.setText(nm);
                
             
             }
             
             
         });
         
         
         
         
         
         


    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
       if(e.getSource()==Add){
           row[0]=room.getText();
           row[1]=location.getText();
            
           String s1=room.getText().toString();
           String s2=location.getText().toString();
           
           Room ob=new Room(s1,s2);
           try {
               ob.saveInfo();
           } catch (SQLException ex) {
               Logger.getLogger(ClassroomInfo.class.getName()).log(Level.SEVERE, null, ex);
           }
           
           model.addRow(row);
       }
       else if(e.getSource()==Clear){
           room.setText("");
           location.setText("");
          
           

       }
       
       else if(e.getSource()==ShowAll){
            Room ob=new Room();
            ArrayList<String>ar=new ArrayList();
            try {
                routinemanagementsystem.Room.showAllRoom(ar);
                int cnt=0;
                for(int i=0;i<ar.size();i++){
                    String a;
                    a=ar.get(i).toString();
                    row[cnt]=a;
                    cnt++;
                    if(cnt==2){
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
           
           Room ob=new Room(cd,nm);
           
           try {
               ob.deleteInfo();
           } catch (SQLException ex) {
               Logger.getLogger(ClassroomInfo.class.getName()).log(Level.SEVERE, null, ex);
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
       else if(e.getSource()== Update){
             int numberOfRow=table.getSelectedRow();
            String cd=room.getText();
            String nm=location.getText();
            
            String s1=room.getText().toString();
            String s2=location.getText().toString();
            
            Room ob=new Room(s1,s2);
           try {
               ob.updateInfo();
           } catch (SQLException ex) {
               Logger.getLogger(ClassroomInfo.class.getName()).log(Level.SEVERE, null, ex);
           }


            model.setValueAt(cd,numberOfRow, 0);
            model.setValueAt(nm,numberOfRow, 1);

            
         }
    }

    public static void main(String[] args) {

         ClassroomInfo frame = new ClassroomInfo();
         frame.setVisible(true);
    }

    
    
}
