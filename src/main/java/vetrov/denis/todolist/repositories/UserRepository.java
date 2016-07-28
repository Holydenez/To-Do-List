package vetrov.denis.todolist.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import vetrov.denis.todolist.models.entities.Role;
import vetrov.denis.todolist.models.entities.User;

import java.util.List;


public interface UserRepository  extends JpaRepository<User, Long> {
    List<User> findOneByEmail(String email);

}