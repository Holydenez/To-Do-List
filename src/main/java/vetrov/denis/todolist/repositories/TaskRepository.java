package vetrov.denis.todolist.repositories;

import org.springframework.stereotype.Repository;
import vetrov.denis.todolist.models.Task;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Denis on 30.06.2016.
 */
@Repository
public class TaskRepository {
    List<Task> tasks;

    public TaskRepository() {
        tasks = new ArrayList<>();
        tasks.add(new Task()
                .setName("h")
                .setDone(true)
                .setChecked(true)
        );
        tasks.add(new Task()
                .setName("io")
                .setDone(false)
                .setChecked(false)
        );
        tasks.add(new Task()
                .setName("htgh")
                .setDone(false)
                .setChecked(true)
        );
    }

    public List<Task> getTasks() {
        return tasks;
    }

    public void addTask(Task task) {
        tasks.add(task);
    }
}
