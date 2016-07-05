package vetrov.denis.todolist.repositories;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import vetrov.denis.todolist.comparators.TaskComparator;
import vetrov.denis.todolist.models.Task;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.UUID;

/**
 * Created by Denis on 30.06.2016.
 */
@Repository
public class TaskRepository {
    @Autowired
    TaskComparator taskComparator;
    List<Task> tasks;

    public TaskRepository() {
        tasks = new ArrayList<>();
        tasks.add(new Task()
                .setId(UUID.randomUUID().toString())
                .setName("Купить помидоров")
                .setDone(false)
                .setChecked(true)
        );
        tasks.add(new Task()
                .setId(UUID.randomUUID().toString())
                .setName("Зайти на Новую почту")
                .setDone(false)
                .setChecked(false)
        );
        tasks.add(new Task()
                .setId(UUID.randomUUID().toString())
                .setName("Записать что съел на обед")
                .setDone(false)
                .setChecked(true)
        );
        tasks.add(new Task()
                .setId(UUID.randomUUID().toString())
                .setName("Забрать перчатки из Розетки")
                .setDone(true)
                .setChecked(false)
        );
        tasks.add(new Task()
                .setId(UUID.randomUUID().toString())
                .setName("Скачать дискографию Эминема")
                .setDone(true)
                .setChecked(true)
        );
    }

    public List<Task> getTasks() {
        List<Task> activeTasks = new ArrayList<>();
        for (Task task : tasks) {
            if (!task.isDone()) {
                activeTasks.add(task);
            }
        }

        Collections.sort(activeTasks, taskComparator);
        return activeTasks;
    }

    public List<Task> getDoneTasks() {
        List<Task> doneTasks = new ArrayList<>();
        for (Task task : tasks) {
            if (task.isDone()) {
                doneTasks.add(task);
            }
        }
        Collections.sort(doneTasks, taskComparator);
        return doneTasks;
    }

    public void addTask(Task task) {
        task.setId(UUID.randomUUID().toString());
        tasks.add(task);
    }

    public Task getTask(String id) {
        for (Task task : tasks) {
            if (task.getId().equals(id)) {
                return task;
            }
        }
        return null;
    }

    public void editTask(Task newTask) {
        tasks.set(tasks.indexOf(getTask(newTask.getId())), newTask);
    }

    public void setTaskDone(String id) {
        for (Task task : tasks) {
            if (task.getId().equals(id)) {
                task.setDone(true);
            }
        }

    }

    public void undoTask(String id) {
        for (Task task : tasks) {
            if (task.getId().equals(id)) {
                task.setDone(false);
            }
        }

    }

    public void setTaskChecked(String id) {
        for (Task task : tasks) {
            if (task.getId().equals(id)) {
                task.setChecked(true);
            }
        }

    }
    public void setTaskUnchecked(String id) {
        for (Task task : tasks) {
            if (task.getId().equals(id)) {
                task.setChecked(false);
            }
        }

    }
}
