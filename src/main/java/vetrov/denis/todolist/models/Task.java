package vetrov.denis.todolist.models;


import java.util.Calendar;
import java.util.Comparator;
import java.util.Date;
import java.util.UUID;

/**
 * Created by Denis on 23.03.2016.
 */
public class Task  {
    private String id;
    private String name;
    private boolean done;
    private boolean checked;

    public Task setId(String id) {
        this.id = id;
        return this;
    }

    public String getName() {
        return name;
    }

    public String getId() {
        return id;
    }

    public Task setName(String name) {
        this.name = name;
        return this;

    }

    public boolean isDone() {
        return done;
    }

    public Task setDone(boolean done) {
        this.done = done;
        return this;
    }

    public boolean isChecked() {
        return checked;
    }

    public Task setChecked(boolean checked) {
        this.checked = checked;
        return this;
    }
}
