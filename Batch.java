
package routinemanagementsystem;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Scanner;


public class Batch {
    private int semester;
    private String program;
    private String dept;
    Batch(){
        semester=0;
        program=null;
        dept=null;
    }
    Batch(int _semester,String _prog,String _dept){
        semester=_semester;
        program=_prog;
        dept=_dept;
    }
    void setSemester(int a){
        semester=a;
    }
    void setProg(String a){
        program=a;
    }
    void setDept(String a){
        dept=a;
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
            try (PreparedStatement str = conn.prepareStatement("insert into batch values(?,?,?)")) {
                str.setInt(1,semester);
                str.setString(2,program);
                str.setString(3,dept);
          
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
            try (PreparedStatement str = conn.prepareStatement("delete from batch where semester=? and dept=?")) {
                str.setInt(1, semester);
                str.setString(2, dept);
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
            try (PreparedStatement str = conn.prepareStatement("update batch set program=? where semester=? and dept=?")) {
                str.setString(1, program);
                str.setInt(2, semester);
                str.setString(3, dept);

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
    
        static void findSem(ArrayList<String>ar,String s) throws SQLException{
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
               String query = "select * from batch where dept='"+s+"'";
             try (Statement stmt = conn.createStatement()) {
                 ResultSet rs = stmt.executeQuery(query);
                 System.out.println("Dept \t Program \t Semester");
                 while(rs.next()) {
                     int cn=rs.getInt("semester");
                     String c=Integer.toString(cn);
                     int flag=0;
                     for(int i=0;i<ar.size();i++){
                         String b=ar.get(i).toString();
                         if(b.equals(c)){
                             flag=1;
                             break;
                         }
                             
                     }
                     if(flag==0)
                        ar.add(c);
                     
                     
                     System.out.println(c);
                 }
                 stmt.close();
             }
             catch(Exception e){
                 System.out.println("Problem in retriving data from batch table"+e.getMessage());
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
    
    static void findDept(ArrayList<String>ar) throws SQLException{
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
               String query = "select * from batch";
             try (Statement stmt = conn.createStatement()) {
                 ResultSet rs = stmt.executeQuery(query);
                 System.out.println("Dept \t Program \t Semester");
                 while(rs.next()) {
                     String c=rs.getString("dept");
                     int flag=0;
                     for(int i=0;i<ar.size();i++){
                         String b=ar.get(i).toString();
                         if(b.equals(c)){
                             flag=1;
                             break;
                         }
                             
                     }
                     if(flag==0)
                        ar.add(c);
                     
                     
                     System.out.println(c);
                 }
                 stmt.close();
             }
             catch(Exception e){
                 System.out.println("Problem in retriving data from batch table"+e.getMessage());
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
    
    static void showAllBatch(ArrayList<String>ar) throws SQLException{
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
               String query = "select * from batch";
             try (Statement stmt = conn.createStatement()) {
                 ResultSet rs = stmt.executeQuery(query);
                 System.out.println("Dept \t Program \t Semester");
                 while(rs.next()) {
                     String c=rs.getString("dept");
                     String n=rs.getString("program");
                     int cn=rs.getInt("semester");
                     String cn2=Integer.toString(cn);
                     ar.add(cn2);
                     ar.add(c);
                     ar.add(n);
                     
                     
                     System.out.println(c+" \t "+n+" \t "+cn);
                 }
                 stmt.close();
             }
             catch(Exception e){
                 System.out.println("Problem in retriving data from batch table"+e.getMessage());
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
    
    static void showAllBatch() throws SQLException{
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
               String query = "select * from batch";
             try (Statement stmt = conn.createStatement()) {
                 ResultSet rs = stmt.executeQuery(query);
                 System.out.println("Dept \t Program \t Semester");
                 while(rs.next()) {
                     String c=rs.getString("dept");
                     String n=rs.getString("program");
                     int cn=rs.getInt("semester");
                     
                     System.out.println(c+" \t "+n+" \t "+cn);
                 }
                 stmt.close();
             }
             catch(Exception e){
                 System.out.println("Problem in retriving data from batch table"+e.getMessage());
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
        static void HandleBatch() throws SQLException{
        
       
        while(true){
        System.out.println("1.Add Batch 2.Update Batch 3.Delete Batch");
        int choose;
        Scanner scanhere=new Scanner(System.in);
        choose=scanhere.nextInt();
        if(choose==1){
            Batch.showAllBatch();
            Batch ob=new Batch();
            scanhere.nextLine();
            System.out.println("Input Department:");
            ob.dept=scanhere.nextLine();
            scanhere.nextLine();
            System.out.println("Input Program:");
            ob.program=scanhere.nextLine();
            scanhere.nextLine();
            System.out.println("Input Semester:");
            ob.semester=scanhere.nextInt();
            scanhere.nextLine();
            ob.saveInfo();
            Batch.showAllBatch();
        }
         else if(choose==2){
             Batch.showAllBatch();
            Batch ob=new Batch();
            scanhere.nextLine();
            System.out.println("Input Department:");
            ob.dept=scanhere.nextLine();
            scanhere.nextLine();
            System.out.println("Input Program:");
            ob.program=scanhere.nextLine();
            scanhere.nextLine();
            System.out.println("Input Semester:");
            ob.semester=scanhere.nextInt();
            scanhere.nextLine();
            ob.updateInfo();
            Batch.showAllBatch();
        }
        else if(choose==3){
            Batch.showAllBatch();
            Batch ob=new Batch();
            System.out.println("Input semester:");
    
            ob.semester=scanhere.nextInt();
            scanhere.nextLine();
            System.out.println("Input Dept:");
            ob.dept=scanhere.next();
            scanhere.nextLine();
            
            ob.deleteInfo();
            Batch.showAllBatch();
        }
        System.out.println("Continue Batch? 1.yes\n2.no");
        int a;
        
        a=scanhere.nextInt();
        if(a==2)
            break;
        }   
        

    }
    
}
