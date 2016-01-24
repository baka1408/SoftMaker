package softmakerjava;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.Vector;
import softmakerjava.User;


public class ManagerCenter {
     static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
    static final String DB_URL = "jdbc:mysql://localhost:3306/SoftDB";
    static final String USER = "root";
    static final String PASS = "";

    Connection conn = null;
    Statement st = null;
    
    public Vector GetUserList()
    {
      
        Vector<User> UserList = new Vector<User>(0);
        
         try{
          Class.forName("com.mysql.jdbc.Driver");
          System.out.println("connecting");
          conn = DriverManager.getConnection(DB_URL, USER, PASS);
          
          st = conn.createStatement();
          String sql = "SELECT ID, Name, Status, Position FROM user";
          ResultSet rs = st.executeQuery(sql);
          
          
          while(rs.next())
          {
              
              User user = new User();
              user.setName(rs.getString("Name"));
              user.setStatus(rs.getString("Status"));
              user.setPosition(rs.getString("Position"));
              UserList.addElement(user);
              
          } }
      catch(SQLException se)
      {
          se.printStackTrace();
      }
      catch(Exception e)
      {
          e.printStackTrace();
      }
          finally
      {
          try{
          if(st!=null){
              st.close();
          }
          }catch(SQLException se2){}
          try{
          if(conn!=null)conn.close();
          }catch(SQLException se3){
           }
          
        }


        return UserList;
    }
      
    }



