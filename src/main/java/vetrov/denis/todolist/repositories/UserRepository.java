package vetrov.denis.todolist.repositories;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Repository;
import vetrov.denis.todolist.models.entities.Role;
import vetrov.denis.todolist.models.entities.User;

@Repository
public class UserRepository {
    public User findOneByEmail(String email){
        User user = new User();
        user.setEmail("holydenez@gmail.com");
        user.setPasswordHash(new BCryptPasswordEncoder().encode("1111"));
        user.setRole(Role.ADMIN);
        return user;
    }
//    public void getUserEmail(User user){
//        user.getEmail();
//    }
}