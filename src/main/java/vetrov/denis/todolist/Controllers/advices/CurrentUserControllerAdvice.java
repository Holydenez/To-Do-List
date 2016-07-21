package vetrov.denis.todolist.controllers.advices;

import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ModelAttribute;
import vetrov.denis.todolist.models.CurrentUser;
import vetrov.denis.todolist.models.entities.User;

@ControllerAdvice
public class CurrentUserControllerAdvice {
    @ModelAttribute("currentUser")
    public CurrentUser getCurrentUser(Authentication authentication) {
        return (authentication == null) ? null : (CurrentUser) authentication.getPrincipal();
    }
}