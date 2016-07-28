package vetrov.denis.todolist.repositories;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.annotation.Transient;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import vetrov.denis.todolist.comparators.DateComparator;
import vetrov.denis.todolist.comparators.TaskComparator;
import vetrov.denis.todolist.models.CurrentUser;
import vetrov.denis.todolist.models.entities.Category;
import vetrov.denis.todolist.models.entities.Task;
import vetrov.denis.todolist.models.entities.User;
import vetrov.denis.todolist.services.EmailSenderService;

import javax.persistence.EntityManager;
import java.util.*;

@Repository
@Transactional
public class TaskRepository {
    @Autowired
    UserRepository userRepository;

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

    public List<Task> compareTasks(CurrentUser currentUser, Comparator<Task> comparator) {
        List<Task> tasks = new LinkedList<>();
        tasks.addAll(userRepository.findOneByEmail(currentUser.getUser().getEmail()).get(0).getTasks());
        Collections.sort(tasks, comparator);
        return tasks;
    }

    private List<Task> getUserTasks(CurrentUser currentUser) {
        return userRepository.findOneByEmail(currentUser.getUsername()).get(0).getTasks();
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
        entityManager.persist(task);
    }

    public Task getTask(Long id) {
        return entityManager.find(Task.class, id);
    }

    public void editTask(Task newTask, Long id) {
        newTask.setCategory(getTask(id).getCategory());
        entityManager.merge(newTask);
    }

    public void setTaskDone(Long id) {
        Task task = entityManager.find(Task.class, id);
        task.setDone(true);
        entityManager.merge(task);
    }

    public void undoTask(Long id) {
        Task task = entityManager.find(Task.class, id);
        task.setDone(false);
        entityManager.merge(task);
    }

    public void setTaskChecked(Long id) {
        Task task = entityManager.find(Task.class, id);
        task.setChecked(true);
        entityManager.merge(task);
    }

    public void setTaskUnchecked(Long id) {
        Task task = entityManager.find(Task.class, id);
        task.setChecked(false);
        entityManager.merge(task);
    }
}
