package vetrov.denis.todolist.context; /**
 * Created by Denis on 23.03.2016.
 */

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.orm.jpa.EntityScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import vetrov.denis.todolist.models.entities.Role;
import vetrov.denis.todolist.models.entities.User;
import vetrov.denis.todolist.repositories.UserRepository;

@Configuration
@ComponentScan("vetrov")
@EnableWebMvc
@EnableScheduling
@EnableAutoConfiguration
@EnableJpaRepositories(basePackages = "vetrov.denis.todolist.repositories")
@EntityScan(basePackages = "vetrov.denis.todolist.models.entities")
public class Application {
    private static final Logger log = LoggerFactory.getLogger(Application.class);

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);

    }

    @Bean
    public CommandLineRunner demo(UserRepository repository) {
        return (args) -> {
            // save a couple of customers
            repository.save(new User("holydenez@gmail.com",new BCryptPasswordEncoder().encode("1111"), Role.ADMIN));
            repository.save(new User("user@gmail.com",new BCryptPasswordEncoder().encode("1111"), Role.USER));
            // fetch all customers
            log.info("Customers found with findAll():");
            log.info("-------------------------------");
            for (User user : repository.findAll()) {
                log.info(user.toString());
            }
            log.info("");

            // fetch an individual customer by ID
            User user = repository.findOne(1L);
            log.info("Customer found with findOne(1L):");
            log.info("--------------------------------");
            log.info(user.toString());
            log.info("");

            // fetch customers by last name
            log.info("Customer found with findOneByEmail('holydenez@gmail.com'):");
            log.info("--------------------------------------------");
            for (User holydenez : repository.findOneByEmail("holydenez@gmail.com")) {
                log.info(holydenez.toString());
            }
            log.info("");
        };
    }

}
