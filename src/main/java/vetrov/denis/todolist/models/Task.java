package vetrov.denis.todolist.models;


import com.fasterxml.jackson.annotation.JsonProperty;
import org.springframework.format.annotation.DateTimeFormat;

import java.text.SimpleDateFormat;
import java.util.Date;


/**
 * Created by Denis on 23.03.2016.
 */
public class Task  {
    private String id;
    private String name;
    private SimpleDateFormat simpleDateFormat;
    private Date createDate;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date planDate;
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

    public SimpleDateFormat getSimpleDateFormat() {
        return simpleDateFormat;
    }

    public Task setSimpleDateFormat(SimpleDateFormat simpleDateFormat) {
        this.simpleDateFormat = simpleDateFormat;
        return this;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public Task setCreateDate(Date createDate) {
        this.createDate = createDate;
        return this;
    }

    public Date getPlanDate() {
        return planDate;
    }

    public Task setPlanDate(Date planDate) {
        this.planDate = planDate;
        return this;
    }
}
