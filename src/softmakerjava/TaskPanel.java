package softmakerjava;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.Properties;
import java.util.Vector;
import javafx.scene.control.DatePicker;
import javax.swing.*;
import org.jdatepicker.impl.*;
import org.jdatepicker.util.*;
import org.jdatepicker.*;
import org.jdatepicker.graphics.*;



public class TaskPanel implements ActionListener {
static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
    static final String DB_URL = "jdbc:mysql://mysql614.admin.strefa.pl:3306/db1105534_SoftMaker";
    static final String USER = "u1105534_baka";
    static final String PASS = "_mediolan1408";

    Connection conn = null;
    Statement st = null;
    
    private JFrame mainFrame;
    private JLabel UserL, TaskL;
    private JComboBox Users, DUsers;
    private JComboBox Tasks;
    private JButton BindTask;
    private JTextField Name;
    private JTextField Type;
    private JTextField Deadline;
    private JButton AddTask;
    private JComboBox TasksDel;
    private JButton DelBtn;
    private JComboBox TasksVal;
    private JButton ValBtn;
    private JButton GenerateBtn;
    private JButton CloseBtn;
    private JTextField UName, UStat, UPos;
    private JButton UAdd, UDel;
   
    
    UserRepository UR;
    Vector<String> UserNames ;
    Vector<String> TaskNames ;
    
    TaskPanel(Vector<Task> TaskList)
    {
        
        TaskNames = new Vector<String>(TaskList.capacity());
        this.UR = new UserRepository();
        UR.LoadUser();
        UserNames = new Vector<String>(0);
        if(UR.users.capacity()!=0){
      
        for(int i=0;i<UR.users.capacity();i++)
        {
            
            UserNames.addElement(UR.users.get(i).getName());
            if(UR.users.get(i) == UR.users.lastElement())break;
        }
       }
       if(TaskList.capacity()!=0){
        for(int i=0;i<TaskList.capacity();i++)
        {
            this.TaskNames.addElement(TaskList.get(i).getName());
            if(TaskList.get(i) == TaskList.lastElement())break;
        }
       }
        
        prepareGUI();
    }
    
    private void prepareGUI()
    {
        mainFrame = new JFrame("Task Panel");
        mainFrame.setSize(720, 480);
        mainFrame.setLayout(null);
        
        mainFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        mainFrame.setResizable(false);
        
       
        
        UserL = new JLabel("User:");
        UserL.setBounds(10, 20, 100, 20);
        UserL.setVisible(true);
        mainFrame.add(UserL);
        Users = new JComboBox(UserNames);
        Users.setBounds(10, 40, 100, 20);
        Users.setVisible(true);
        mainFrame.add(Users);
        
        
        TaskL = new JLabel("Task:");
        TaskL.setBounds(110, 20, 100, 20);
        TaskL.setVisible(true);
        mainFrame.add(TaskL);
        Tasks = new JComboBox(TaskNames);
        Tasks.setBounds(110, 40, 100, 20);
        Tasks.setVisible(true);
        mainFrame.add(Tasks);
        
        BindTask = new JButton("Bind Task");
        BindTask.setBounds(210, 40, 100, 20);
        BindTask.setVisible(true);
        BindTask.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent e)
            {
                 TaskMenager TM = new TaskMenager();
                 TM.BindTask((String)Users.getSelectedItem(),(String)Tasks.getSelectedItem());
            }
        });
        mainFrame.add(BindTask);
       
        
         
      
        UserL = new JLabel("Name:");
        UserL.setBounds(10, 100, 100, 20);
        mainFrame.add(UserL);
        Name = new JTextField();
        Name.setBounds(10, 120, 100, 20);
        Name.setVisible(true);
        mainFrame.add(Name);
        
        TaskL = new JLabel("Type:");
        TaskL.setBounds(110, 100, 100, 20);
        mainFrame.add(TaskL);
        Type = new JTextField();
        Type.setBounds(110, 120, 100, 20);
        Type.setVisible(true);
        mainFrame.add(Type);
        
        TaskL = new JLabel("Deadline:");
        
        TaskL.setBounds(210, 100, 100, 20);
        mainFrame.add(TaskL);
       
        Properties p = new Properties();
        p.put("text.today", "Today");
        p.put("text.month", "Month");
        p.put("text.yea", "Year");
        UtilDateModel model = new UtilDateModel();
        
        JDatePanelImpl datePanel = new JDatePanelImpl(model, p);
        JDatePickerImpl datePicker = new JDatePickerImpl(datePanel, null);
        Deadline = new JTextField(); 
        datePanel.setVisible(true);
        datePicker.setBounds(210,120,200,20);
        datePicker.setVisible(true);
        mainFrame.add(datePicker);
        
        AddTask = new JButton("Add Task");
        AddTask.setBounds(410, 120, 100, 20);
        AddTask.setVisible(true);
        AddTask.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Task task = new Task();
                TaskMenager TM = new TaskMenager();
                task.setName((String)Name.getText());
                task.setType((String)Type.getText());
                Calendar c =Calendar.getInstance();
                c.set(datePicker.getModel().getYear(), datePicker.getModel().getMonth(), datePicker.getModel().getDay());
                task.setDeadline(c);
                task.setStatus("Fresh");
              
              
               TM.AddNewTask(task);
            }
        });
        mainFrame.add(AddTask);
        
        
        TaskL = new JLabel("Task:");
        TaskL.setBounds(10, 200, 100, 20);
        mainFrame.add(TaskL);
        TasksDel = new JComboBox(TaskNames);
        TasksDel.setBounds(10, 220, 100, 20);
        TasksDel.setVisible(true);
        mainFrame.add(TasksDel);
        
        DelBtn = new JButton("Delete");
        DelBtn.setBounds(110, 220, 100, 20);
        DelBtn.setVisible(true);
        DelBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                TaskMenager TM = new TaskMenager();
                Task task = new Task();
                task.setName((String)TasksDel.getSelectedItem());
                TM.RemoveTask(task);
                System.out.println("Deleted task");
            }
        });
        mainFrame.add(DelBtn);
        
        ValBtn = new JButton("Validate");
        ValBtn.setBounds(210, 220, 100, 20);
        ValBtn.setVisible(true);
        ValBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
               TaskMenager TM = new TaskMenager();
               Task task = new Task();
               
                 try{
          Class.forName("com.mysql.jdbc.Driver");
          System.out.println("connecting");
          conn = DriverManager.getConnection(DB_URL, USER, PASS);
          
          st = conn.createStatement();
          String sql = "SELECT  Name, Type, Term, Status FROM task";
          ResultSet rs = st.executeQuery(sql);
          
          while(rs.next())
          {
             Calendar c = new GregorianCalendar();
              
              task.setName(rs.getString("Name"));
              c.setTimeInMillis(rs.getLong("Term"));
              task.setDeadline(c);
              task.setStatus(rs.getString("Status"));
              task.setType(rs.getString("Type"));
            
          } }
      catch(SQLException se)
      {
          se.printStackTrace();
      }
      catch(Exception ee)
      {
          ee.printStackTrace();
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
            System.out.println("kek");     
          if(TM.ValidateTask(task))System.out.println("Task Valid");
          else System.out.println("Task not valid");
            }
        });
        mainFrame.add(ValBtn);
        
        TaskL = new JLabel("Name:");
        TaskL.setBounds(10, 260, 100, 20);
        TaskL.setVisible(true);
        mainFrame.add(TaskL);
        TaskL = new JLabel("Status:");
        TaskL.setBounds(110, 260, 100, 20);
        mainFrame.add(TaskL);
        TaskL = new JLabel("Position:");
        TaskL.setBounds(210, 260, 100, 20);
        mainFrame.add(TaskL);
        UName = new JTextField();
        UName.setBounds(10, 280, 100, 20);
        UName.setVisible(true);
        mainFrame.add(UName);
        
        UStat = new JTextField();
        UStat.setBounds(110, 280, 100, 20);
        UStat.setVisible(true);
        mainFrame.add(UStat);
        
        UPos = new JTextField();
        UPos.setBounds(210, 280, 100, 20);
        UPos.setVisible(true);
        mainFrame.add(UPos);
        
        UAdd = new JButton("Add User");
        UAdd.setBounds(310, 280, 100, 20);
        UAdd.setVisible(true);
        UAdd.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                UserRepository UR = new UserRepository();
                UR.AddUser(UName.getText(), UStat.getText(), UPos.getText());
                System.out.println("User added succesfully");
            }
        });
        mainFrame.add(UAdd);
        
        DUsers = new JComboBox(UserNames);
        DUsers.setBounds(10, 350, 100, 20);
        DUsers.setVisible(true);
        mainFrame.add(DUsers);
        
        UDel = new JButton("Del User");
        UDel.setBounds(110, 350, 100, 20);
        UDel.setVisible(true);
        UDel.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                UserRepository UR = new UserRepository();
                UR.DeleteUser((String)DUsers.getSelectedItem());
                System.out.println("User Deleted!");
            }
        });
        mainFrame.add(UDel);
        
       
        CloseBtn = new JButton("Close");
        CloseBtn.setBounds(620, 400, 70, 20);
        CloseBtn.setVisible(true);
        CloseBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
               mainFrame.dispose();
            }
        });
        mainFrame.add(CloseBtn);
        
        mainFrame.setVisible(true);
    }
    
    private void filterTasks()
    {
        
    }
    
    private void groupTasks()
    {
        
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }


     
}