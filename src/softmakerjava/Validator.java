package softmakerjava;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.Random;


public class Validator {

    public boolean CheckValidation(Task task)
    {
       if(GetStats(task) && GetTestResults(task)){
           MarkTaskAsCompleted(task);
           return true; 
       } 
           
       else
       {
           MarkTaskAsFailed(task);
           return false;
       }
           
    }

    private boolean GetTestResults(Task task)
    {
        Random rnd = new Random();
        boolean results = rnd.nextBoolean();
       
      return results;
    }

    private boolean GetStats(Task task)
    {
        Calendar cal = new GregorianCalendar();
        if(task.getDeadline().getTimeInMillis() > cal.getTimeInMillis())
        return true;
        else return false;
    }

    public void MarkTaskAsCompleted(Task task)
    {
        task.setStatus("Completed");
    }

    public void MarkTaskAsFailed(Task task)
    {
        task.setStatus("Failed");
    }

}






