package vetrov.denis.todolist.repositories;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.annotation.Transient;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Repository;
import vetrov.denis.todolist.comparators.DateComparator;
import vetrov.denis.todolist.comparators.TaskComparator;
import vetrov.denis.todolist.models.CurrentUser;
import vetrov.denis.todolist.models.entities.Task;
import vetrov.denis.todolist.models.entities.User;
import vetrov.denis.todolist.services.EmailSenderService;

import java.util.*;

/**
 * Created by Denis on 30.06.2016.
 */
@Repository
public class TaskRepository {
    List<Task> tasks;
    @Autowired
    EmailSenderService emailSenderService;

    @Autowired
    @Transient
    User user;
    public TaskRepository() {
        tasks = new ArrayList<>();
        tasks.add(new Task()
                .setId(UUID.randomUUID().toString())
                .setName("Купить помидоров")
                .setDone(false)
                .setChecked(true)
                .setCreateDate(new Date())
                .setPlanDate(new Date(116, 7, 30))
                .setCategory("Покупки")
        );
        tasks.add(new Task()
                .setId(UUID.randomUUID().toString())
                .setName("Зайти на Новую почту")
                .setDone(false)
                .setChecked(false)
                .setPlanDate(new Date(113, 7, 30))
                .setCreateDate(new Date())
                .setCategory("Дела")
        );
        tasks.add(new Task()
                .setId(UUID.randomUUID().toString())
                .setName("Записать что съел на обед")
                .setDone(false)
                .setChecked(true)
                .setCreateDate(new Date())
                .setCategory("Покупки")
        );
        tasks.add(new Task()
                .setId(UUID.randomUUID().toString())
                .setName("Забрать перчатки из Розетки")
                .setDone(true)
                .setChecked(false)
                .setCreateDate(new Date())
                .setCategory("Дела")
        );
        tasks.add(new Task()
                .setId(UUID.randomUUID().toString())
                .setName("Скачать дискографию Эминема")
                .setDone(true)
                .setChecked(true)
                .setCreateDate(new Date())
                .setCategory("Дела")
        );
        tasks.add(new Task()
                .setId(UUID.randomUUID().toString())
                .setName("Помыть квартиру")
                .setDone(false)
                .setChecked(false)
                .setCreateDate(new Date())
                .setCategory("Дела")
        );
        tasks.add(new Task()
                .setId(UUID.randomUUID().toString())
                .setName("Подать документы")
                .setDone(false)
                .setChecked(true)
                .setCreateDate(new Date())
                .setCategory("Дела")
        );
    }

    public List<Task> getTasks(Comparator<Task> comparator) {
        List<Task> activeTasks = new ArrayList<>();
        for (Task task : tasks) {
            if (!task.isDone()) {
                activeTasks.add(task);
            }
        }
        Collections.sort(activeTasks, comparator);
        return activeTasks;
    }

    public List<Task> getDoneTasks(Comparator<Task> comparator) {
        List<Task> doneTasks = new ArrayList<>();
        for (Task task : tasks) {
            if (task.isDone()) {
                doneTasks.add(task);
            }
        }
        Collections.sort(doneTasks, comparator);
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


    public void failedPlanedDate() {
        for (Task task : tasks) {
            if (task.getPlanDate().before(new Date())) {
                task.setPlanDateFailed(true);
                emailSenderService.send(user.getEmail(), "TO-DO LIST", "Ваша задача " + task.getName() + " из категории " + task.getCategory() + " просрочена");
            }
        }
    }
}
