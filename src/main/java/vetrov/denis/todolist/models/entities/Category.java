package vetrov.denis.todolist.models.entities;

/**
 * Created by Denis on 12.07.2016.
 */
public class Category {
    String id;
    String name;
    User user;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
