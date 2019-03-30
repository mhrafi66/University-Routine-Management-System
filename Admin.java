
package routinemanagementsystem;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Scanner;


public class Admin {
    private final static String usn="myusn";
    private final static String pass="test";
    Admin(){
        
    }
    public static String getUSN(){
        
        return usn;
        
    }
    public static String getPassword(){
        return pass;
    }
    public void controlOfAdmin() throws SQLException{
        Scanner scanhere=new Scanner(System.in);
        int a;
        System.out.println("Choose what you want:\n1.Manage Info\n2.Make Schedule");
        a=scanhere.nextInt();
        if(a==1){
            System.out.println("Choose what you want:\n1.Manage Batch\n2.Manage Subject\n3.Manage Teacher");
            System.out.println("4.Manage Classroom\n5.Manage Lab");
            int c;
            c=scanhere.nextInt();
            switch (c) {
                case 1:
                    Batch.HandleBatch();
                    break;
                case 2:
                    Subject.HandleCourse();
                    break;
                case 3:
                    Teacher.HandleTeacher();
                    break;
                case 4:
                    Room.HandleRoom();
                    break;
                case 5:
                    Lab.HandleRoom();
                    break;
                default:
                    break;
            }
        }
        else if(a==2){
            scanhere.nextLine();
            System.out.println("Enter Dpt:");
            String dpt=scanhere.next();
            scanhere.nextLine();
            System.out.println("Enter semester:");
            String sems=scanhere.next();
            scanhere.nextLine();
            ArrayList<String>ar=new ArrayList();
            Routine.findAvailableCourse2(dpt, sems, ar);
            
            
            
            
        }
        
        
        
    }
    
}
