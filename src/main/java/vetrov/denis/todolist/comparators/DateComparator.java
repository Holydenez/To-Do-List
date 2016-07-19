package vetrov.denis.todolist.comparators;


import org.springframework.stereotype.Component;
import vetrov.denis.todolist.models.entities.Task;

import java.util.Comparator;

/**
 * Created by Denis on 23.03.2016.
 */
@Component
public class DateComparator implements Comparator<Task> {
    @Override
    public int compare(Task task1, Task task2) {
        if (task1.getPlanDate().before(task2.getPlanDate())) {
            return -1;
        } else if (task1.getPlanDate().after(task2.getPlanDate())){
            return 1;
        } else {
            return 0;
        }
    }
}
