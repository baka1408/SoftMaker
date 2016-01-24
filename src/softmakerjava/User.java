package softmakerjava;

import java.util.Vector;



public class User {
    private int id;
    private String name;
    private String status;
    private String position;
    Vector<Task> Tasks;


    public User() {}
    public User(String name, String status, String position)
    {
        this.name = name;
        this.status=status;
        this.position = position;
        this.Tasks = new Vector<Task>(1);
    }
    
   public String getName() {
        return name;
    }
    public String getPosition() {
        return position;
    }
    public String getStatus() {
        return status;
    }
    public Vector getTasks() {
        return this.Tasks;
    }
    public int getid() { return id;}
    public void setId(int id) { this.id = id;}
    public void setName(String name) {
        this.name = name;
    }
    public void setPosition(String position) {
        this.position = position;
    }
    public void setStatus(String status) {
        this.status = status;
    }
    public void setTask(Task task) {
        this.Tasks.addElement(task);
    }
}
