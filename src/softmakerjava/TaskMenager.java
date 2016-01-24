package softmakerjava;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.Vector;
import javax.swing.JFrame;


public class TaskMenager {
static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
    static final String DB_URL = "jdbc:mysql://mysql614.admin.strefa.pl:3306/db1105534_SoftMaker";
    static final String USER = "u1105534_baka";
    static final String PASS = "_mediolan1408";

    Connection conn = null;
    Statement st = null;
    
    private Vector<Task> taskQueue = new Vector<Task>(1);

    public Vector<Task> getTaskQueue() {
        return taskQueue;
    }

    public void setTaskQueue(Task taskQueue) {
        this.taskQueue.addElement(taskQueue); 
    }
    
    
    
    public void BindTask(String username, String taskname)
    {
         try{
          Class.forName("com.mysql.jdbc.Driver");
          System.out.println("connecting");
          conn = DriverManager.getConnection(DB_URL, USER, PASS);
          
          st = conn.createStatement();
          String sql = "INSERT INTO tasklist (User_name, Task_name) " + "VALUES ('"+username+"', '"+taskname+"')";
          st.executeUpdate(sql);
          System.out.println("Task bound!");
          String q = "UPDATE task " + "SET Status = 'Asigned' WHERE Name ='"+taskname+"'";
          st.executeUpdate(q);
        //  task.setType("Asigned");
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

    public void AddNewTask(Task task)
    {
        try{
          Class.forName("com.mysql.jdbc.Driver");
          System.out.println("connecting");
          conn = DriverManager.getConnection(DB_URL, USER, PASS);
          
          st = conn.createStatement();
          String sql = "INSERT INTO task (Name, Type, Term, Status) " + "VALUES ('"+task.getName()+"', '"+task.getType()+"', '"+task.getDeadline().getTimeInMillis()+"', '"+task.getStatus()+"')";
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
        
        System.out.println("Added new Task");
    }

    public void RemoveTask(Task task)
    {
       try{
          Class.forName("com.mysql.jdbc.Driver");
          System.out.println("connecting");
          conn = DriverManager.getConnection(DB_URL, USER, PASS);
          
          st = conn.createStatement();
         
          String sql = "DELETE FROM task " + "WHERE Name = '"+task.getName()+"' ";
          st.executeUpdate(sql);
          sql = "DELETE FROM tasklist " + "WHERE Task_name = '"+task.getName()+"'";
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

    public boolean ValidateTask(Task task)
    {
        Validator VD = new Validator();
        if(VD.CheckValidation(task))return true;
        else return false;
    }

    public Vector GenerateTaskList()
    {
        Vector<Task> TaskList = new Vector<Task>(0);
        
         try{
          Class.forName("com.mysql.jdbc.Driver");
          System.out.println("connecting");
          conn = DriverManager.getConnection(DB_URL, USER, PASS);
          
          st = conn.createStatement();
          String sql = "SELECT ID, Name, Type, Term, Status FROM task";
          ResultSet rs = st.executeQuery(sql);
          
          
          while(rs.next())
          {
              Calendar c = new GregorianCalendar();
              Task tk = new Task();
              tk.setName(rs.getString("Name"));
              c.setTimeInMillis(rs.getLong("Term"));
              tk.setDeadline(c);
              tk.setStatus(rs.getString("Status"));
              tk.setType(rs.getString("Type"));
              TaskList.addElement(tk);
              
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

        System.out.println(TaskList.capacity());
        return TaskList;
    }

}
