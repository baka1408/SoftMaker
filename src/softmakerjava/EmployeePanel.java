package softmakerjava;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.Statement;
import java.util.Vector;
import javax.swing.*;

public class EmployeePanel {
static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
    static final String DB_URL = "jdbc:mysql://mysql614.admin.strefa.pl:3306/db1105534_SoftMaker";
    static final String USER = "u1105534_baka";
    static final String PASS = "_mediolan1408";

    Connection conn = null;
    Statement st = null;
    
    private JFrame mainFrame;
    private JLabel TaskL;
    private JComboBox Tasks;
    private JButton DeployTask;
    private JButton UserTasks;
    
    Vector<String> TaskNames;
    User currentUser;
    
     EmployeePanel(Vector<Task> TaskList, User currentUser)
    {
                UserCenter UC = new UserCenter();
                Vector<Task> V = new Vector<Task>();
                V = UC.ShowUserTasks(currentUser);
        TaskNames = new Vector<String>(TaskList.capacity());
        if(TaskList.capacity()!=0){
        for(int i=0;i<V.capacity();i++)
        {
            if(V.get(i).getStatus().equals("Asigned")){
            this.TaskNames.addElement(V.get(i).getName());
            
        }
            if(V.get(i) == V.lastElement())break;
        }
       }
        this.currentUser = currentUser;
        generateGUI();
    }
    
    private void generateGUI()
    {
        mainFrame = new JFrame("Employee Panel");
        mainFrame.setSize(250, 320);
        mainFrame.setLayout(null);
        
        mainFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        mainFrame.setResizable(false);
        
        TaskL = new JLabel("Task:");
        TaskL.setBounds(10, 20, 100, 20);
        TaskL.setVisible(true);
        mainFrame.add(TaskL);
        
        Tasks = new JComboBox(TaskNames);
        Tasks.setBounds(10, 40, 100, 20);
        Tasks.setVisible(true);
        mainFrame.add(Tasks);
        
        DeployTask = new JButton("deploy");
        DeployTask.setBounds(110, 40, 100, 20);
        DeployTask.setVisible(true);
        DeployTask.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
               UserCenter UC = new UserCenter();
               UC.DeployTask((String)Tasks.getSelectedItem());
            }
        });
        
        mainFrame.add(DeployTask);
        
        UserTasks = new JButton("Show User Tasks");
        UserTasks.setBounds(10, 100, 200, 20);
        UserTasks.setVisible(true);
        UserTasks.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                UserCenter UC = new UserCenter();
                Vector<Task> V = new Vector<Task>();
                V = UC.ShowUserTasks(currentUser);
                System.out.println(V.capacity() + ".");
                JFrame rameczka = new JFrame("User's Tasks");
                rameczka.setSize(480, 720);
                rameczka.setLayout(null);
        
                rameczka.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
                rameczka.setResizable(false);
        
               JTextArea textArea = new JTextArea();
               
               textArea.setBounds(20, 20, 350, 650);
               textArea.setEditable(false);
               textArea.setVisible(true);
               for(int i=0;i<V.capacity();i++)
               {
                 textArea.append(V.get(i).getName() + " "+ V.get(i).getStatus()+ " " + V.get(i).getType() +"\n");
                 if(V.get(i) == V.lastElement())break;
               }
               rameczka.add(textArea);
               
               rameczka.setVisible(true);
               
            }
        });
        mainFrame.add(UserTasks);
        
        mainFrame.setVisible(true);
    }
    
    
}
