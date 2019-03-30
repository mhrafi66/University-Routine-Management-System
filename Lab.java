
package routinemanagementsystem;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Scanner;


public class Lab {
    private String lab_no;
    private String location;
    
    Lab(){
        lab_no=null;
        location=null;
    }
    
    Lab(String _room_no,String _loc){
        lab_no=_room_no;
        location=_loc;
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
            try (PreparedStatement str = conn.prepareStatement("insert into lab values(?,?)")) {
                str.setString(1,lab_no);
                str.setString(2,location);

                str.executeUpdate();
                str.close();
            }
            catch(Exception e){
                System.out.println("Problem in storing value in lab table"+e.getMessage());
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
            try (PreparedStatement str = conn.prepareStatement("delete from lab where labno=?")) {
                str.setString(1, lab_no);
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
            try (PreparedStatement str = conn.prepareStatement("update lab set location=? where labno=?")) {
                str.setString(1, location);
                str.setString(2, lab_no);
   
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
    
        static void showAllRoom(ArrayList<String>ar) throws SQLException{
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
               String query = "select * from lab";
             try (Statement stmt = conn.createStatement()) {
                 ResultSet rs = stmt.executeQuery(query);
                 System.out.println("Lab No \t Location");
                 while(rs.next()) {
                     String c=rs.getString("labno");
                     String n=rs.getString("location");
                     
                     ar.add(c);
                     ar.add(n);
                     
                     System.out.println(c+" \t "+n);
                 }
                 stmt.close();
             }
             catch(Exception e){
                 System.out.println("Problem in retriving data from lab table"+e.getMessage());
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
    
    static void showAllRoom() throws SQLException{
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
               String query = "select * from lab";
             try (Statement stmt = conn.createStatement()) {
                 ResultSet rs = stmt.executeQuery(query);
                 System.out.println("Lab No \t Location");
                 while(rs.next()) {
                     String c=rs.getString("labno");
                     String n=rs.getString("location");
                     
                     System.out.println(c+" \t "+n);
                 }
                 stmt.close();
             }
             catch(Exception e){
                 System.out.println("Problem in retriving data from lab table"+e.getMessage());
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
    static void HandleRoom() throws SQLException{
        while(true){
        System.out.println("1.Add Lab 2.Update Info 3.Delete Lab");
        int choose;
        Scanner scanhere=new Scanner(System.in);
        choose=scanhere.nextInt();
        if(choose==1){
            Lab.showAllRoom();
            Lab ob=new Lab();
            System.out.println("Input Unique Lab No:");
            ob.lab_no=scanhere.next();
            scanhere.nextLine();
            System.out.println("Input Lab's Location:");
            ob.location=scanhere.nextLine();
            scanhere.nextLine();
            ob.saveInfo();
            Lab.showAllRoom();
            
        }
        else if(choose==2){
            Lab.showAllRoom();
            Lab ob=new Lab();
            System.out.println("Input Unique Lab_no:");
            ob.lab_no=scanhere.next();
            scanhere.nextLine();
            System.out.println("Input Lab's Location:");
            ob.location=scanhere.nextLine();
            scanhere.nextLine();
            ob.updateInfo();
            Lab.showAllRoom();
        }
        else if(choose==3){
            Lab.showAllRoom();
            Lab ob=new Lab();
            System.out.println("Input Lab No:");
            ob.lab_no=scanhere.next();
            scanhere.nextLine();
            
            ob.deleteInfo();
            Lab.showAllRoom();
        }
        System.out.println("Continue Lab? 1.yes\n2.no");
        int a;
        
        a=scanhere.nextInt();
        if(a==2)
            break;
        }
        
    }
    
    
    
       
    
    
}
