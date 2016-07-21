package vetrov.denis.todolist.models;

import vetrov.denis.todolist.comparators.DateComparator;
import vetrov.denis.todolist.comparators.TaskComparator;
import vetrov.denis.todolist.models.entities.Task;

import java.util.Comparator;

/**
 * Created by Denis on 21.07.2016.
 */
public enum TaskSortType {
    BY_DATE(new TaskComparator()), BY_IMPORTANCE(new DateComparator());

    private Comparator<Task> comparator;

    TaskSortType(Comparator<Task> comparator) {
        this.comparator = comparator;
    }

    public TaskSortType reverse() {
        return this.equals(BY_DATE) ? BY_IMPORTANCE : BY_DATE;
    }

    public Comparator<Task> getComparator() {
        return comparator;
    }
}
