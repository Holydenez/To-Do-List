package vetrov.denis.todolist.models;

import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.stereotype.Component;
import vetrov.denis.todolist.models.entities.Role;
import vetrov.denis.todolist.models.entities.User;

import java.util.Collection;

public class CurrentUser extends org.springframework.security.core.userdetails.User {

    private User user;

    private String selectedCategory;
    private TaskSortType taskSortType=TaskSortType.BY_IMPORTANCE;

    public CurrentUser(User user) {
        super(user.getEmail(), user.getPasswordHash(), AuthorityUtils.createAuthorityList(user.getRole().toString()));
        this.user = user;
        this.selectedCategory = "Дела";
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

    public TaskSortType getTaskSortType() {
        return taskSortType;
    }

    public void setTaskSortType(TaskSortType taskSortType) {
        this.taskSortType = taskSortType;
    }
}