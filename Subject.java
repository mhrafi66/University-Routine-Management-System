
package routinemanagementsystem;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Scanner;


public class Subject {
    private String code;
    private String name;
    private float credit;
    private String dept;
    private int semester;
    private String type;
    private String stype;
    
    Subject(){
        code=null;
        name=null;
        credit=0;
        dept=null;
        semester=0;
        type=null;
        stype=null;
    }
    Subject(String _code,String _name,float _credit,String _dept,int _semester,String _type,String _stype){
        code=_code;
        name=_name;
        credit=_credit;
        dept=_dept;
        semester=_semester;
        type=_type;
        stype=_stype;
    }
    
        static void showAllCourse(ArrayList<String>ar) throws SQLException{
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
               String query = "select * from subject";
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
                     ar.add(c);
                     ar.add(nm);
                     ar.add(f2);
                     ar.add(cn);
                     ar.add(cnn2);
                     ar.add(cnnn);
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
    
    
    static void showAllCourse() throws SQLException{
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
               String query = "select * from subject";
             try (Statement stmt = conn.createStatement()) {
                 ResultSet rs = stmt.executeQuery(query);
                 System.out.println("Code \t Credit \t Type \t Dept \t Semester \t SType");
                 while(rs.next()) {
                     String c=rs.getString("code");
                     float f=rs.getFloat("credit");
                     String n=rs.getString("type");
                     String cn=rs.getString("dept");
                     int cnn=rs.getInt("semester");
                     String cnnn=rs.getString("type");
                     String ccn=rs.getString("stype");
                     
                     
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
            try (PreparedStatement str = conn.prepareStatement("insert into subject values(?,?,?,?,?,?,?)")) {
                str.setString(1,code);
                str.setString(2,name);
                str.setFloat(3,credit);
                str.setString(4,dept);
                str.setInt(5,semester);
                str.setString(6, type);
                str.setString(7, stype);
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
            try (PreparedStatement str = conn.prepareStatement("delete from subject where code=?")) {
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
            try (PreparedStatement str = conn.prepareStatement("update subject set name=?,credit=?,dept=?,semester=?,type=?,stype=? where code=?")) {
                str.setString(1, name);
                str.setFloat(2, credit);
                str.setString(3, dept);
                str.setInt(4, semester);
                str.setString(5, type);
                str.setString(6, stype);
                str.setString(7, code);
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
    static void HandleCourse() throws SQLException{
        while(true){
        System.out.println("1.Add Course 2.Update Course 3.Delete Course");
        int choose;
        Scanner scanhere=new Scanner(System.in);
        choose=scanhere.nextInt();
        if(choose==1){
            Subject.showAllCourse();
            Subject ob=new Subject();
            System.out.println("Input Unique CourseID:");
            ob.code=scanhere.next();
            scanhere.nextLine();
            System.out.println("Input Course Name:");
            ob.name=scanhere.nextLine();
            scanhere.nextLine();
            System.out.println("Input Course Credit:");
            ob.credit=scanhere.nextFloat();
            scanhere.nextLine();
            System.out.println("Input Department:");
            ob.dept=scanhere.nextLine();
            scanhere.nextLine();
            System.out.println("Input Semester:");
            ob.semester=scanhere.nextInt();
            scanhere.nextLine();
            System.out.println("Input Course Type( core/optional):");
            ob.type=scanhere.nextLine();
            scanhere.nextLine();
            System.out.println("Input Course Type( Theory/Lab):");
            ob.stype=scanhere.nextLine();
            scanhere.nextLine();
            ob.saveInfo();
            Subject.showAllCourse();
            
        }
        else if(choose==2){
            Subject.showAllCourse();
            Subject ob=new Subject();
            System.out.println("Input Unique CourseID:");
            ob.code=scanhere.next();
            scanhere.nextLine();
            System.out.println("Input Course Name:");
            ob.name=scanhere.nextLine();
            scanhere.nextLine();
            System.out.println("Input Course Credit:");
            ob.credit=scanhere.nextFloat();
            scanhere.nextLine();
            System.out.println("Input Department:");
            ob.dept=scanhere.nextLine();
            scanhere.nextLine();
            System.out.println("Input Semester:");
            ob.semester=scanhere.nextInt();
            scanhere.nextLine();
            System.out.println("Input Course Type( core/optional):");
            ob.type=scanhere.nextLine();
            scanhere.nextLine();
            System.out.println("Input Course Type( Theory/Lab):");
            ob.stype=scanhere.nextLine();
            scanhere.nextLine();
            ob.updateInfo();
            Subject.showAllCourse();
        }
        else if(choose==3){
            Subject.showAllCourse();
            Subject ob=new Subject();
            System.out.println("Input Course ID:");
            ob.code=scanhere.next();
            scanhere.nextLine();
            
            ob.deleteInfo();
            Subject.showAllCourse();
        }
        System.out.println("Continue Course? 1.yes\n2.no");
        int a;
        
        a=scanhere.nextInt();
        if(a==2)
            break;
        }
        
    }
    
}
