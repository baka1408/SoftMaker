package softmakerjava;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.Vector;



public class UserCenter {

static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
    static final String DB_URL = "jdbc:mysql://mysql614.admin.strefa.pl:3306/db1105534_SoftMaker";
    static final String USER = "u1105534_baka";
    static final String PASS = "_mediolan1408";

         Connection conn = null;
         Statement st = null;
    
    
    public Vector<Task> ShowUserTasks(User currentUser)
    {
        
        Vector<Task> allV = new Vector<Task>(0);
        Vector<Task> V = new Vector<Task>(0);
        TaskMenager TM = new TaskMenager();
        allV = TM.GenerateTaskList();
        
        try{
          Class.forName("com.mysql.jdbc.Driver");
         
          conn = DriverManager.getConnection(DB_URL, USER, PASS);
          
          st = conn.createStatement();
          String sql = "SELECT Task_name FROM tasklist WHERE User_name = '"+currentUser.getName()+"'";
          ResultSet rs = st.executeQuery(sql);
          
          
          while(rs.next())
          {
              Task tk = new Task();
            
              tk.setName(rs.getString("Task_name"));
              V.addElement(tk);
              
              
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
       
        

        
        Vector<Task> userTasks = new Vector<Task>(V.capacity());
        for(int i=0;i<(allV.capacity()-1);i++)
        {
            for(int j=0;j<(V.capacity());j++)
            {
                if( allV.get(i).getName().equals(V.get(j).getName()) )
                {
                   System.out.println("TAG");
                   userTasks.addElement(allV.get(i));
                }
                if(V.get(j) == V.lastElement())break;
            }
           if(allV.get(i) == allV.lastElement())break;
        }

        return userTasks;
    }
    public void DeployTask(String TaskName)
    {
        try{
          Class.forName("com.mysql.jdbc.Driver");
          System.out.println("connecting");
          conn = DriverManager.getConnection(DB_URL, USER, PASS);
          
          st = conn.createStatement();
          String sql = "UPDATE task " + "SET status = 'deployed' WHERE Name = '"+TaskName+"'";
          st.executeUpdate(sql);
          System.out.println("Task deployed!");
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

}
