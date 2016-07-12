package vetrov.denis.todolist.models;

import org.springframework.security.core.authority.AuthorityUtils;
import vetrov.denis.todolist.models.entities.Category;
import vetrov.denis.todolist.models.entities.Role;
import vetrov.denis.todolist.models.entities.User;

public class CurrentUser extends org.springframework.security.core.userdetails.User {

    private User user;

    private String selectedCategory;

    public CurrentUser(User user) {
        super(user.getEmail(), user.getPasswordHash(), AuthorityUtils.createAuthorityList(user.getRole().toString()));
        this.user = user;
        this.selectedCategory = "";
    }

    public User getUser() {
        return user;
    }

    public Long getId() {
        return user.getId();
    }

    public Role getRole() {
        return user.getRole();
    }

    public String getSelectedCategory() {
        return selectedCategory;
    }

    public void setSelectedCategory(String selectedCategory) {
        this.selectedCategory = selectedCategory;
    }
}