package vetrov.denis.todolist.validators;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;
import vetrov.denis.todolist.services.UserCreateFormService;
import vetrov.denis.todolist.services.UserService;

/**
 * Created by Denis on 21.07.2016.
 */
@Component
public class UserCreateFormValidator implements Validator {

    private final UserService userService;

    @Autowired
    public UserCreateFormValidator(UserService userService) {
        this.userService = userService;
    }

    @Override
    public boolean supports(Class<?> clazz) {
        return clazz.equals(UserCreateFormService.class);
    }

    @Override
    public void validate(Object target, Errors errors) {
        UserCreateFormService form = (UserCreateFormService) target;
        validatePasswords(errors, form);
        validateEmail(errors, form);
    }

    private void validatePasswords(Errors errors, UserCreateFormService form) {
        if (!form.getPassword().equals(form.getPasswordRepeated())) {
            errors.reject("password.no_match", "Passwords do not match");
        }
    }

    private void validateEmail(Errors errors, UserCreateFormService form) {
//        if (userService.getUserByEmail(form.getEmail()).isPresent()) {
//            errors.reject("email.exists", "User with this email already exists");
//        }
    }
}