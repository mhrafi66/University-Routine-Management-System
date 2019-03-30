
package routinemanagementsystem;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Scanner;


public class RoutineManagementSystem {
 

    public static void main(String[] args) throws SQLException {
        String s1;
        String s2;
        Scanner scan=new Scanner(System.in);
        
        int flag=1;
        int c;
        while(flag==1){
            System.out.println("1.Log In \n2.Debug");
            c=scan.nextInt();
            if(c==1){
                System.out.println("Input Your Username");
                s1=scan.next();
                System.out.println("Input Your Password");
                s2=scan.next();
               
                String s3=Admin.getUSN();
                
                String s4=Admin.getPassword();
                boolean flagu=false,flagp=false;
                if(s1.equals(s3))
                    flagu=true;
                if(s2.equals(s4))
                    flagp=true;
                if(flagu && flagp){
                    Admin admin=new Admin();
                    admin.controlOfAdmin();
                }
                else{
                    System.out.println("Username or Password is incorrect");
                }
                
                
                
            }
            else if(c==2){
                /*Routine ob=new Routine("CSE",4,"CSE-4409","ARMK", (float) 3.0,"Mon","Slot-3(9.40-10.30)","Core","Theory","N-302","0");
                ob.saveInfo();*/
                scan.nextLine();
                System.out.println("Enter Dept:");
                 String dpt=scan.next();
                scan.nextLine();
                System.out.println("Enter Sem:");
                int a=scan.nextInt();
                scan.nextLine();
                System.out.println("Enter Day:");
                String d=scan.next();
                scan.nextLine();
                System.out.println("Enter Slot:");
                String s=scan.next();
                scan.nextLine();
                ArrayList<String>ar=new ArrayList();
                Routine.findTableInfo(dpt, a,d,s, ar);
            }
            
        }
    }
    
   
    
}
