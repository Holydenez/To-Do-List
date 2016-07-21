package vetrov.denis.todolist.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import vetrov.denis.todolist.models.entities.Role;
import vetrov.denis.todolist.models.entities.User;
import vetrov.denis.todolist.repositories.UserRepository;

/**
 * Created by Denis on 12.07.2016.
 */
@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserRepository userRepository;

    @Override
    public User getUserByEmail(String email) {
        return userRepository.findOneByEmail(email).get(0);
    }

    @Override
    public User create() {
        User user = new User("holydenez@gmail.com",new BCryptPasswordEncoder().encode("1111"), Role.ADMIN);
//        user.setEmail(form.getEmail());
//        user.setPasswordHash(new BCryptPasswordEncoder().encode(form.getPassword()));
//        user.setRole(form.getRole());
//        userRepository.save(user)
        return user;
    }

}