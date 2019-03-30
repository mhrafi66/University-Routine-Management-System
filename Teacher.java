
package routinemanagementsystem;

import java.sql.Array;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Scanner;


public class Teacher {

   
    private String code;
    private String name;
    private String designation;
    private String dept;
    private String pass;
    Teacher(){
        code=null;
        name=null;
        designation=null;
        dept=null;
        pass=null;
    }
    
    Teacher(String _code,String _name,String _des,String _dept){
        code=_code;
        name=_name;
        designation=_des;
        dept=_dept;
        pass=null;
    }
    
    void setCode(String _code){
        code=_code;
    }
    void setName(String _name){
        name=_name;
    }
    void setDesignation(String _des){
        designation=_des;
    }
    void setDept(String _dept){
        dept=_dept;
    }
    void setPassword(String _pass){
        pass=_pass;
    }
    
    
    
    void saveInfo()throws SQLException{
        Connection conn = null;
       try{
           String driverName= "oracle.jdbc.driver.OracleDriver";
           Class.forName(driverName);
           String serverName="DESKTOP-OS6ILV2";
           String serverPort="1521";
           String sid="XE";
           String url= "jdbc:oracle:thin:@"+serverName+":"+serverPort+":"+sid;
           String username="myuser1";
           String password="dunno";
           conn=DriverManager.getConnection(url, username, password);
           System.out.println("Successfully Connected to the database!");
            try (PreparedStatement str = conn.prepareStatement("insert into teacher values(?,?,?,?,?)")) {
                str.setString(1,code);
                str.setString(2,name);
                str.setString(3,designation);
                str.setString(4,dept);
                str.setString(5,pass);
                str.executeUpdate();
                str.close();
            }
            catch(Exception e){
                System.out.println("Problem in storing value"+e.getMessage());
            }
          
           
       
       }
       catch(ClassNotFoundException e){
           System.out.println("driver not found"+e.getMessage());
       }
       catch(SQLException e){
           System.out.println("can't connect"+e.getMessage());
       }
       finally{
           conn.close();
       }
    }
    void deleteInfo() throws SQLException{
        Connection conn = null;
       try{
           String driverName= "oracle.jdbc.driver.OracleDriver";
           Class.forName(driverName);
           String serverName="DESKTOP-OS6ILV2";
           String serverPort="1521";
           String sid="XE";
           String url= "jdbc:oracle:thin:@"+serverName+":"+serverPort+":"+sid;
           String username="myuser1";
           String password="dunno";
           conn=DriverManager.getConnection(url, username, password);
           System.out.println("Successfully Connected to the database!");
            try (PreparedStatement str = conn.prepareStatement("delete from teacher where code=?")) {
                str.setString(1, code);
                str.executeUpdate();
                str.close();
            }
            catch(Exception e){
                System.out.println("Problem in deleting value"+e.getMessage());
            }
           
       
       }
       catch(ClassNotFoundException e){
           System.out.println("driver not found"+e.getMessage());
       }
       catch(SQLException e){
           System.out.println("can't connect"+e.getMessage());
       }
       finally{
           conn.close();
       }
       
    }
    
    void updateInfo() throws SQLException{
        Connection conn = null;
       try{
           String driverName= "oracle.jdbc.driver.OracleDriver";
           Class.forName(driverName);
           String serverName="DESKTOP-OS6ILV2";
           String serverPort="1521";
           String sid="XE";
           String url= "jdbc:oracle:thin:@"+serverName+":"+serverPort+":"+sid;
           String username="myuser1";
           String password="dunno";
           conn=DriverManager.getConnection(url, username, password);
           System.out.println("Successfully Connected to the database!");
            try (PreparedStatement str = conn.prepareStatement("update teacher set name=?,designation=?,dept=? where code=?")) {
                str.setString(1, name);
                str.setString(2, designation);
                str.setString(3, dept);
                str.setString(4, code);
                str.executeUpdate();
                str.close();
            }
            catch(Exception e){
                System.out.println("Problem in Updating"+e.getMessage());
            }
           
       
       }
       catch(ClassNotFoundException e){
           System.out.println("driver not found"+e.getMessage());
       }
       catch(SQLException e){
           System.out.println("can't connect"+e.getMessage());
       }
       finally{
           conn.close();
       }
       
        
    }
    
     static void showAllTeacher(ArrayList<String>ar,String _dept) throws SQLException{
         Connection conn = null;
         
       try{
           String driverName= "oracle.jdbc.driver.OracleDriver";
           Class.forName(driverName);
           String serverName="DESKTOP-OS6ILV2";
           String serverPort="1521";
           String sid="XE";
           String url= "jdbc:oracle:thin:@"+serverName+":"+serverPort+":"+sid;
           String username="myuser1";
           String password="dunno";
           conn=DriverManager.getConnection(url, username, password);
           System.out.println("Successfully Connected to the database!");
               String query = "select * from teacher where dept='"+_dept+"'";
             try (Statement stmt = conn.createStatement()) {
                 ResultSet rs = stmt.executeQuery(query);
                 System.out.println("Code \t Name \t Dept \t Designation" );
                 while(rs.next()) {
                     
                     String c=rs.getString("code");
                     ar.add(c);
                     System.out.println(c);
                 }
                 stmt.close();
             }
             catch(Exception e){
                 System.out.println("Problem in retriving data from teacher table"+e.getMessage());
             }
           
       
       }
       catch(ClassNotFoundException e){
           System.out.println("driver not found"+e.getMessage());
       }
       catch(SQLException e){
           System.out.println("can't connect"+e.getMessage());
       }
       finally{
           conn.close();
       }
       
    }
    
    static void showAllTeacher(ArrayList<String>ar) throws SQLException{
         Connection conn = null;
         
       try{
           String driverName= "oracle.jdbc.driver.OracleDriver";
           Class.forName(driverName);
           String serverName="DESKTOP-OS6ILV2";
           String serverPort="1521";
           String sid="XE";
           String url= "jdbc:oracle:thin:@"+serverName+":"+serverPort+":"+sid;
           String username="myuser1";
           String password="dunno";
           conn=DriverManager.getConnection(url, username, password);
           System.out.println("Successfully Connected to the database!");
               String query = "select * from teacher";
             try (Statement stmt = conn.createStatement()) {
                 ResultSet rs = stmt.executeQuery(query);
                 System.out.println("Code \t Name \t Dept \t Designation" );
                 while(rs.next()) {
                     
                     String c=rs.getString("code");
                     String n=rs.getString("name");
                     String p=rs.getString("designation");
                     String d=rs.getString("dept");
                     ar.add(c);
                     ar.add(n);
                     ar.add(d);
                     ar.add(p);
                     
                    
                     System.out.println(c+" \t "+n+" \t "+d+" \t "+p);
                 }
                 stmt.close();
             }
             catch(Exception e){
                 System.out.println("Problem in retriving data from teacher table"+e.getMessage());
             }
           
       
       }
       catch(ClassNotFoundException e){
           System.out.println("driver not found"+e.getMessage());
       }
       catch(SQLException e){
           System.out.println("can't connect"+e.getMessage());
       }
       finally{
           conn.close();
       }
       
    }
    
    static void showAllTeacher() throws SQLException{
         Connection conn = null;
         String[] ar=new String[4];
       try{
           String driverName= "oracle.jdbc.driver.OracleDriver";
           Class.forName(driverName);
           String serverName="DESKTOP-OS6ILV2";
           String serverPort="1521";
           String sid="XE";
           String url= "jdbc:oracle:thin:@"+serverName+":"+serverPort+":"+sid;
           String username="myuser1";
           String password="dunno";
           conn=DriverManager.getConnection(url, username, password);
           System.out.println("Successfully Connected to the database!");
               String query = "select * from teacher";
             try (Statement stmt = conn.createStatement()) {
                 ResultSet rs = stmt.executeQuery(query);
                 System.out.println("Code \t Name \t Dept \t Designation" );
                 while(rs.next()) {
                     
                     String c=rs.getString("code");
                     String n=rs.getString("name");
                     String p=rs.getString("designation");
                     String d=rs.getString("dept");
                     ar[0]=c;
                     ar[1]=n;
                     ar[2]=p;
                     ar[3]=d;
                    
                     System.out.println(c+" \t "+n+" \t "+d+" \t "+p);
                 }
                 stmt.close();
             }
             catch(Exception e){
                 System.out.println("Problem in retriving data from teacher table"+e.getMessage());
             }
           
       
       }
       catch(ClassNotFoundException e){
           System.out.println("driver not found"+e.getMessage());
       }
       catch(SQLException e){
           System.out.println("can't connect"+e.getMessage());
       }
       finally{
           conn.close();
       }
       
    }
    

    
    static void HandleTeacher() throws SQLException{
        while(true){
        System.out.println("1.Add Teacher 2.Update Info 3.Delete Teacher");
        int choose;
        Scanner scanhere=new Scanner(System.in);
        choose=scanhere.nextInt();
        if(choose==1){
            Teacher.showAllTeacher();
            Teacher ob=new Teacher();
            System.out.println("Input Unique Username:");
            ob.code=scanhere.next();
            scanhere.nextLine();
            System.out.println("Input Teacher Name:");
            ob.name=scanhere.nextLine();
            scanhere.nextLine();
            System.out.println("Input Teacher's Designation:");
            ob.designation=scanhere.nextLine();
            scanhere.nextLine();
            System.out.println("Input Department:");
            ob.dept=scanhere.nextLine();
            scanhere.nextLine();
            ob.saveInfo();
            Teacher.showAllTeacher();
            
        }
        else if(choose==2){
            Teacher.showAllTeacher();
            Teacher ob=new Teacher();
            System.out.println("Input Username:");
            ob.code=scanhere.next();
            scanhere.nextLine();
            System.out.println("Input Teacher Name:");
            ob.name=scanhere.nextLine();
            System.out.println("Input Teacher's Designation:");
            ob.designation=scanhere.nextLine();
            
            System.out.println("Input Department:");
            ob.dept=scanhere.nextLine();
            
            ob.updateInfo();
            Teacher.showAllTeacher();
        }
        else if(choose==3){
            Teacher.showAllTeacher();
            Teacher ob=new Teacher();
            System.out.println("Input Username:");
            ob.code=scanhere.next();
            scanhere.nextLine();
            
            ob.deleteInfo();
            Teacher.showAllTeacher();
        }
        System.out.println("Continue Teacher? 1.yes\n2.no");
        int a;
        
        a=scanhere.nextInt();
        if(a==2)
            break;
        }
        
    }
    
}


