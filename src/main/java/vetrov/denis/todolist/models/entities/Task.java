package vetrov.denis.todolist.models.entities;


import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.text.SimpleDateFormat;
import java.util.Date;


/**
 * Created by Denis on 23.03.2016.
 */
@Entity
public class Task {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false, updatable = false)
    private Long id;
    @ManyToOne
    private User author;
    @Column
    private String name;
    @ManyToOne
    private Category category;
    @Column
    private SimpleDateFormat simpleDateFormat;
    @Column
    private Date createDate;
    @Column
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date planDate = new Date();
    @Column
    private boolean planDateFailed;
    @Column
    private boolean done;
    @Column
    private boolean checked;

    public User getAuthor() {
        return author;
    }

    public Task setAuthor(User author) {
        this.author = author;
        return this;
    }

    public Task setId(Long id) {
        this.id = id;
        return this;
    }

    public String getName() {
        return name;
    }

    public Long getId() {
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

    public Category getCategory() {
        return category;
    }

    public Task setCategory(Category category) {
        this.category = category;
        return this;
    }
}
