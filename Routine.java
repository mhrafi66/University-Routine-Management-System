
package routinemanagementsystem;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;


public class Routine {
    String Department,Course,Teacher,Day,Slot,Type,Stype,Room,Lab;
    float Credit;
    int Semester;
    
    Routine(){
        Department=null;
        Course=null;
        Teacher=null;
        Day=null;
        Slot=null;
        Type=null;
        Stype=null;
        Room=null;
        Lab=null;
        Credit=0;
        Semester=0;
    }
    Routine(String _dept,int _sem,String _course,String _teacher,float _credit,String _day,String _slot,String _type,String _stype,String _room,String _lab){
        Department=_dept;
        Semester=_sem;
        Course=_course;
        Teacher=_teacher;
        Credit=_credit;
        Day=_day;
        Slot=_slot;
        Type=_type;
        Stype=_stype;
        Room=_room;
        Lab=_lab;
        
        
    }
    
     static void deleteInfo(String _code) throws SQLException{
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
            try (PreparedStatement str = conn.prepareStatement("delete from rtn where course=?")) {
                str.setString(1, _code);
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
    
    
    static void findTableInfo(String _dept,int _semes,String _day,String _slot,ArrayList<String>ar) throws SQLException{
        //int semes=Integer.parseInt(_sem);
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
               String query = "select * from rtn where department='"+_dept+"' and semester="+_semes+" and day='"+_day+"' and slot='"+_slot+"'";
             try (Statement stmt = conn.createStatement()) {
                 ResultSet rs = stmt.executeQuery(query);
                 System.out.println("Code \t Credit \t Type \t Dept \t Semester \t SType");
                 while(rs.next()) {
                     String c=rs.getString("course");
                     String n=rs.getString("teacher");
                     String r=rs.getString("room");
                     String s=rs.getString("lab");
                     
                     
                     
                     ar.add(c);
                     ar.add(n);
                     ar.add(r);
                     ar.add(s);
                     System.out.println(c+" "+n+" "+r+" "+s);
                     
                     
                     
                     //System.out.println(c+" \t "+f+" \t "+n+" \t "+cn+" \t "+cnn+" \t "+ccn);
                 }
                 stmt.close();
             }
             catch(Exception e){
                 System.out.println("Problem in retriving data from course table"+e.getMessage());
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
    
    
        static void findAllLab(ArrayList<String>ar) throws SQLException{
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
                 System.out.println("Room No \t Location");
                 while(rs.next()) {
                     String c=rs.getString("labno");
                    
                     
                     ar.add(c);
                    
                     
                     System.out.println(c);
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
    
    static void findAvailableLab(String _stype,String _day,String _slot,ArrayList<String>ar) throws SQLException{
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
               String query = "select * from rtn where stype='"+_stype+"' and day='"+_day+"' and slot='"+_slot+"'";
               System.out.println(query);
             try (Statement stmt = conn.createStatement()) {
                 ResultSet rs = stmt.executeQuery(query);
                 System.out.println("Room No \t Location");
                 while(rs.next()) {
                     String c=rs.getString("lab");
                   
                     
                     ar.add(c);
                     
                     
                     System.out.println(c);
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
    
    
    static void findAllRoom(ArrayList<String>ar) throws SQLException{
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
                    
                     
                     ar.add(c);
                    
                     
                     System.out.println(c);
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
    
    static void findAvailableRoom(String _stype,String _day,String _slot,ArrayList<String>ar) throws SQLException{
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
               String query = "select * from rtn where stype='"+_stype+"' and day='"+_day+"' and slot='"+_slot+"'";
               System.out.println(query);
             try (Statement stmt = conn.createStatement()) {
                 ResultSet rs = stmt.executeQuery(query);
                 System.out.println("Room No \t Location");
                 while(rs.next()) {
                     String c=rs.getString("room");
                   
                     
                     ar.add(c);
                     
                     
                     System.out.println(c);
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
    
    static void findStudentSlot(String _dept,int _sem,String _day,ArrayList<String>ar) throws SQLException{
        //int semes=Integer.parseInt(_sem);
        
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
              String query = "select * from rtn where department='"+_dept+"' and semester="+_sem+" and day='"+_day+"'";
             try (Statement stmt = conn.createStatement()) {
                 ResultSet rs = stmt.executeQuery(query);
                 System.out.println("Code \t Credit \t Type \t Dept \t Semester \t SType");
                
                 while(rs.next()) {
                     
                     String c=rs.getString("slot");
                     
                     
                     ar.add(c);
                     System.out.println(c);
                     
                     
                     
                     //System.out.println(c+" \t "+f+" \t "+n+" \t "+cn+" \t "+cnn+" \t "+ccn);
                 }
                 stmt.close();
             }
             catch(Exception e){
                 System.out.println("Problem in retriving data from course table"+e.getMessage());
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
    
        static void findTeacherSlot(String _teacher,String _day,ArrayList<String>ar) throws SQLException{
        //int semes=Integer.parseInt(_sem);
        
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
              String query = "select * from rtn where teacher='"+_teacher+"' and day='"+_day+"'";
             try (Statement stmt = conn.createStatement()) {
                 ResultSet rs = stmt.executeQuery(query);
                 System.out.println("Code \t Credit \t Type \t Dept \t Semester \t SType");
                
                 while(rs.next()) {
                     
                     String c=rs.getString("slot");
                     
                     
                     ar.add(c);
                     System.out.println(c);
                     
                     
                     
                     //System.out.println(c+" \t "+f+" \t "+n+" \t "+cn+" \t "+cnn+" \t "+ccn);
                 }
                 stmt.close();
             }
             catch(Exception e){
                 System.out.println("Problem in retriving data from course table"+e.getMessage());
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
    
    static void findAvailableCourse(String _dept,String _sem,ArrayList<String>ar) throws SQLException{
        int semes=Integer.parseInt(_sem);
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
               String query = "select * from subject where dept='"+_dept+"' and semester="+semes;
             try (Statement stmt = conn.createStatement()) {
                 ResultSet rs = stmt.executeQuery(query);
                 System.out.println("Code \t Credit \t Type \t Dept \t Semester \t SType");
                 while(rs.next()) {
                     String c=rs.getString("code");
                     
                     
                     ar.add(c);
                     System.out.println(c);
                     
                     
                     
                     //System.out.println(c+" \t "+f+" \t "+n+" \t "+cn+" \t "+cnn+" \t "+ccn);
                 }
                 stmt.close();
             }
             catch(Exception e){
                 System.out.println("Problem in retriving data from course table"+e.getMessage());
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
            try (PreparedStatement str = conn.prepareStatement("insert into rtn values(?,?,?,?,?,?,?,?,?,?,?)")) {
                str.setString(1,Department);
                str.setInt(2,Semester);
                str.setString(3,Course);
                str.setString(4,Teacher);
                str.setFloat(5, Credit);
                str.setString(6,Day);
                str.setString(7, Slot);
                str.setString(8, Type);
                str.setString(9, Stype);
                str.setString(10, Room);
                str.setString(11, Lab);
                
                
          
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
    
    static void findAvailableCourse2(String _dept,String _sem,ArrayList<String>ar) throws SQLException{
        int semes=Integer.parseInt(_sem);
        
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
              String query = "select * from rtn where department='"+_dept+"' and semester="+semes;
             try (Statement stmt = conn.createStatement()) {
                 ResultSet rs = stmt.executeQuery(query);
                 System.out.println("Code \t Credit \t Type \t Dept \t Semester \t SType");
                
                 while(rs.next()) {
                     
                     String c=rs.getString("course");
                     
                     
                     ar.add(c);
                     System.out.println(c);
                     
                     
                     
                     //System.out.println(c+" \t "+f+" \t "+n+" \t "+cn+" \t "+cnn+" \t "+ccn);
                 }
                 stmt.close();
             }
             catch(Exception e){
                 System.out.println("Problem in retriving data from course table"+e.getMessage());
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
    
    static void showAllCourse(String _code,ArrayList<String>ar) throws SQLException{
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
               String query = "select * from subject where code='"+_code+"'";
             try (Statement stmt = conn.createStatement()) {
                 ResultSet rs = stmt.executeQuery(query);
                 System.out.println("Code \t Credit \t Type \t Dept \t Semester \t SType");
                 while(rs.next()) {
                     String c=rs.getString("code");
                     String nm=rs.getString("name");
                     float f=rs.getFloat("credit");
                     String n=rs.getString("type");
                     String cn=rs.getString("dept");
                     int cnn=rs.getInt("semester");
                     String cnnn=rs.getString("type");
                     String ccn=rs.getString("stype");
                     
                     String f2=Float.toString(f);
                     String cnn2=Integer.toString(cnn);
                     
                     ar.add(f2);
                     
                     ar.add(ccn);
                     
                     
                     
                     System.out.println(c+" \t "+f+" \t "+n+" \t "+cn+" \t "+cnn+" \t "+ccn);
                 }
                 stmt.close();
             }
             catch(Exception e){
                 System.out.println("Problem in retriving data from course table"+e.getMessage());
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
    
}
