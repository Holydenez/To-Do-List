package vetrov.denis.todolist.models.entities;


import org.springframework.format.annotation.DateTimeFormat;

import java.text.SimpleDateFormat;
import java.util.Date;


/**
 * Created by Denis on 23.03.2016.
 */
public class Task {
    private User author;
    private String id;
    private String name;
    private String category;
    private SimpleDateFormat simpleDateFormat;
    private Date createDate;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date planDate= new Date();
    private boolean planDateFailed;
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

    public boolean isPlanDateFailed() {
        return planDateFailed;
    }

    public Task setPlanDateFailed(boolean planDateFailed) {
        this.planDateFailed = planDateFailed;
        return this;
    }

    public String getCategory() {
        return category;
    }

    public Task setCategory(String category) {
        this.category = category;
        return this;
    }
}
