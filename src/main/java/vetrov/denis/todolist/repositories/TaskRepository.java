package vetrov.denis.todolist.repositories;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.annotation.Transient;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import vetrov.denis.todolist.comparators.DateComparator;
import vetrov.denis.todolist.comparators.TaskComparator;
import vetrov.denis.todolist.models.CurrentUser;
import vetrov.denis.todolist.models.entities.Task;
import vetrov.denis.todolist.models.entities.User;
import vetrov.denis.todolist.services.EmailSenderService;

import javax.persistence.EntityManager;
import java.util.*;

@Repository
@Transactional
public class TaskRepository {
    @Autowired
    UserRepository repository;

    @Autowired
    EntityManager entityManager;

    public List<Task> getTasks() {
        List<Task> activeTasks = new ArrayList<>();
//        for (Task task : getUserTasks(currentUser)) {
//            if (!task.isDone()) {
//                activeTasks.add(task);
//            }
//        }
//        Collections.sort(activeTasks, comparator);
        return activeTasks;
    }

    public List<Task> getTasks(CurrentUser currentUser, Comparator<Task> comparator) {
        List<Task> activeTasks = new ArrayList<>();
        for (Task task : getUserTasks(currentUser)) {
            if (!task.isDone()) {
                activeTasks.add(task);
            }
        }
        Collections.sort(activeTasks, comparator);
        return activeTasks;
    }

    private List<Task> getUserTasks(CurrentUser currentUser) {
        return repository.findOneByEmail(currentUser.getUsername()).get(0).getTasks();
    }

    public List<Task> getDoneTasks(CurrentUser currentUser, Comparator<Task> comparator) {
        List<Task> doneTasks = new ArrayList<>();
        for (Task task : getUserTasks(currentUser)) {
            if (task.isDone()) {
                doneTasks.add(task);
            }
        }
        Collections.sort(doneTasks, comparator);
        return doneTasks;
    }

    public void addTask(Task task) {
//        task.setId(UUID.randomUUID().toString());
//        tasks.add(task);
    }

    public Task getTask(Long id) {
        return entityManager.find(Task.class, id);
    }

    public void editTask(Task newTask) {
//        tasks.set(tasks.indexOf(getTask(newTask.getId())), newTask);
    }

    public void setTaskDone(Long id) {
        Task task = entityManager.find(Task.class, id);
        task.setDone(true);
        entityManager.merge(task);
//        for (Task task : tasks) {
//            if (task.getId().equals(id)) {
//                task.setDone(true);
//            }
//        }

    }

    public void undoTask(Long id) {
//        for (Task task : tasks) {
//            if (task.getId().equals(id)) {
//                task.setDone(false);
//            }
//        }

    }

    public void setTaskChecked(Long id) {
//        for (Task task : tasks) {
//            if (task.getId().equals(id)) {
//                task.setChecked(true);
//            }
//        }

    }

    public void setTaskUnchecked(Long id) {
//        for (Task task : tasks) {
//            if (task.getId().equals(id)) {
//                task.setChecked(false);
//            }
//        }

    }
}
