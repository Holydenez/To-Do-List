package vetrov.denis.todolist.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import vetrov.denis.todolist.models.CurrentUser;
import vetrov.denis.todolist.models.entities.User;

@Service
public class UserDetailsServiceImpl implements UserDetailsService  {
    @Autowired
    private UserService userService;

    @Override
    public CurrentUser loadUserByUsername(String email) throws UsernameNotFoundException {
        User user = userService.getUserByEmail(email);
        if(user == null) {
            throw new UsernameNotFoundException(String.format("User with email=%s was not found", email));
        };
        return new CurrentUser(user);
    }
}