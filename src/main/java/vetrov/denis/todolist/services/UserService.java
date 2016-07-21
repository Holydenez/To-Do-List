package vetrov.denis.todolist.services;

import vetrov.denis.todolist.models.entities.User;

/**
 * Created by Denis on 12.07.2016.
 */
public interface UserService {
    User getUserByEmail(String email);
    User create(UserCreateFormService form);

}
