package vetrov.denis.todolist.comparators;


import org.springframework.stereotype.Component;
import vetrov.denis.todolist.models.Task;

import java.util.Comparator;

/**
 * Created by Denis on 23.03.2016.
 */
@Component
public class TaskComparator implements Comparator<Task> {
    @Override
    public int compare(Task task1, Task task2) {
        if (task1.isChecked() && !task2.isChecked()) {
            return -1;
        } else if (!task1.isChecked() && task2.isChecked()){
            return 1;
        } else {
            return 0;
        }
    }
}
