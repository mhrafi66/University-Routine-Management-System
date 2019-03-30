
package routinemanagementsystem;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Scanner;


public class Room {
    private String room_no;
    private String location;
    
    Room(){
        room_no=null;
        location=null;
    }
    
    Room(String _room_no,String _loc){
        room_no=_room_no;
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
            try (PreparedStatement str = conn.prepareStatement("insert into room values(?,?)")) {
                str.setString(1,room_no);
                str.setString(2,location);

                str.executeUpdate();
                str.close();
            }
            catch(Exception e){
                System.out.println("Problem in storing value in room table"+e.getMessage());
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
            try (PreparedStatement str = conn.prepareStatement("delete from room where roomno=?")) {
                str.setString(1, room_no);
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
            try (PreparedStatement str = conn.prepareStatement("update room set location=? where roomno=?")) {
                str.setString(1, location);
                str.setString(2, room_no);
   
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
               String query = "select * from room";
             try (Statement stmt = conn.createStatement()) {
                 ResultSet rs = stmt.executeQuery(query);
                 System.out.println("Room No \t Location");
                 while(rs.next()) {
                     String c=rs.getString("roomno");
                     String n=rs.getString("location");
                     
                     ar.add(c);
                     ar.add(n);
                     
                     System.out.println(c+" \t "+n);
                 }
                 stmt.close();
             }
             catch(Exception e){
                 System.out.println("Problem in retriving data from room table"+e.getMessage());
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
               String query = "select * from room";
             try (Statement stmt = conn.createStatement()) {
                 ResultSet rs = stmt.executeQuery(query);
                 System.out.println("Room No \t Location");
                 while(rs.next()) {
                     String c=rs.getString("roomno");
                     String n=rs.getString("location");
                     
                     System.out.println(c+" \t "+n);
                 }
                 stmt.close();
             }
             catch(Exception e){
                 System.out.println("Problem in retriving data from room table"+e.getMessage());
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
        System.out.println("1.Add Room 2.Update Info 3.Delete Room");
        int choose;
        Scanner scanhere=new Scanner(System.in);
        choose=scanhere.nextInt();
        if(choose==1){
            Room.showAllRoom();
            Room ob=new Room();
            System.out.println("Input Unique Room No:");
            ob.room_no=scanhere.next();
            scanhere.nextLine();
            System.out.println("Input Room's Location:");
            ob.location=scanhere.nextLine();
            scanhere.nextLine();
            ob.saveInfo();
            Room.showAllRoom();
            
        }
        else if(choose==2){
            Room.showAllRoom();
            Room ob=new Room();
            System.out.println("Input Unique Room No:");
            ob.room_no=scanhere.next();
            scanhere.nextLine();
            System.out.println("Input Room's Location:");
            ob.location=scanhere.nextLine();
            scanhere.nextLine();
            ob.updateInfo();
            Room.showAllRoom();
        }
        else if(choose==3){
            Room.showAllRoom();
            Room ob=new Room();
            System.out.println("Input RoomNo:");
            ob.room_no=scanhere.next();
            scanhere.nextLine();
            
            ob.deleteInfo();
            Room.showAllRoom();
        }
        System.out.println("Continue Room? 1.yes\n2.no");
        int a;
        
        a=scanhere.nextInt();
        if(a==2)
            break;
        }
        
    }
    
    
    
    
}
