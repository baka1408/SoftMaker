package softmakerjava;
import java.util.Calendar;




public class Task {
    private String name;
    private String type;
    private Calendar deadline;
    private String status;

    
    public Task()
    {
        
    }
    
    public Task(String name, Calendar deadline, String type)
    {
        this.name=name;
        this.deadline=deadline;
        this.status="Not Asigned";
        this.type=type;
    }

    public void setName(String name) {
        this.name = name;
    }
    public String getName() {
        return name;
    }
    public Calendar getDeadline() {
        return deadline;
    }
    public String getType() {
        return type;
    }
    public void setDeadline(Calendar deadline) {
        this.deadline = deadline;
    }
    public void setType(String type) {
        this.type = type;
    }
    
    public void setStatus(String status) {
        this.status = status;
    }

    public String getStatus() {
        return status;
    }

}
