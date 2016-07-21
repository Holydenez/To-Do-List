package vetrov.denis.todolist.services;

import org.hibernate.validator.constraints.NotEmpty;
import vetrov.denis.todolist.models.entities.Role;

import javax.validation.constraints.NotNull;

/**
 * Created by Denis on 21.07.2016.
 */
public class UserCreateFormService {

    @NotEmpty
    private String email = "";

    @NotEmpty
    private String password = "";

    @NotEmpty
    private String passwordRepeated = "";

    @NotNull
    private Role role = Role.USER;

    public UserCreateFormService setEmail(String email) {
        this.email = email;
        return this;
    }

    public UserCreateFormService setPassword(String password) {
        this.password = password;
        return this;
    }

    public UserCreateFormService setPasswordRepeated(String passwordRepeated) {
        this.passwordRepeated = passwordRepeated;
        return this;
    }

    public String getEmail() {

        return email;
    }

    public String getPassword() {
        return password;
    }

    public Role getRole() {
        return role;
    }

    public String getPasswordRepeated() {
        return passwordRepeated;
    }
}