package softmakerjava;
import java.sql.*;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.Vector;

public class UserRepository {
    public Vector<User> users = new Vector(0);
    


    
    static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
    static final String DB_URL = "jdbc:mysql://mysql614.admin.strefa.pl:3306/db1105534_SoftMaker";
    static final String USER = "u1105534_baka";
    static final String PASS = "_mediolan1408";

    Connection conn = null;
         Statement st = null;
  

    public void LoadUser()
    {
         try{
          Class.forName("com.mysql.jdbc.Driver");
          System.out.println("connecting");
          conn = DriverManager.getConnection(DB_URL, USER, PASS);
          
          st = conn.createStatement();
          String sql = "SELECT id, Name, Status, Position FROM user";
          ResultSet rs = st.executeQuery(sql);
          
          
          while(rs.next())
          {
              User us = new User();
              us.setName(rs.getString("Name"));
              us.setStatus(rs.getString("Status"));
              us.setPosition(rs.getString("Position"));
              users.add(us);
          }
      }
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
    }

    public void AddUser(String name, String status, String position)
    {
        try{
          Class.forName("com.mysql.jdbc.Driver");
          System.out.println("connecting");
          conn = DriverManager.getConnection(DB_URL, USER, PASS);
          
          st = conn.createStatement();
          String sql = "INSERT INTO user (Name, Status, Position) " + "VALUES ('"+name+"', '"+status+"', '"+position+"')";
          st.executeUpdate(sql);
      }
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
    }

    public void DeleteUser(String Name)
    {
        try{
          Class.forName("com.mysql.jdbc.Driver");
          System.out.println("connecting");
          conn = DriverManager.getConnection(DB_URL, USER, PASS);
          
          st = conn.createStatement();
         
          String sql = "DELETE FROM user " + "WHERE name = '"+Name+"' ";
          st.executeUpdate(sql);
      }
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
    }

    public void LoadOnlineUsers()
    {

    }


    
}
