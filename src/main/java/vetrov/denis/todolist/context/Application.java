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
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import vetrov.denis.todolist.models.entities.Category;
import vetrov.denis.todolist.models.entities.Role;
import vetrov.denis.todolist.models.entities.Task;
import vetrov.denis.todolist.models.entities.User;
import vetrov.denis.todolist.repositories.UserRepository;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;

@Configuration
@ComponentScan("vetrov")
@EnableWebMvc
@EnableScheduling
@EnableAutoConfiguration
@EnableJpaRepositories(basePackages = "vetrov.denis.todolist.repositories")
@EntityScan(basePackages = "vetrov.denis.todolist.models.entities")
@Transactional
public class Application {
    private static final Logger log = LoggerFactory.getLogger(Application.class);

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);

    }
    @Bean
    public CommandLineRunner demo(UserRepository repository) {
        return (args) -> {

            User admin = new User("holydenez@gmail.com", new BCryptPasswordEncoder().encode("1111"), Role.ADMIN);
            List<Task> tasks = new ArrayList<>();
            List<Category> categories=new ArrayList<>();
            Category category = new Category("Дела", admin, tasks);
            Category category2 = new Category("Покупки", admin, tasks);
            categories.add(category);
            categories.add(category2);
            tasks.add(new Task()
                    .setName("Купить помидоров2")
                    .setDone(false)
                    .setChecked(true)
                    .setCreateDate(new Date())
                    .setPlanDate(new Date(116, 7, 30))
                    .setAuthor(admin)
                    .setCategory(category2)
            );
            tasks.add(new Task()
                    .setName("Зайти на Новую почту")
                    .setDone(false)
                    .setChecked(false)
                    .setPlanDate(new Date(113, 7, 30))
                    .setCreateDate(new Date())
                    .setAuthor(admin)
                    .setCategory(category)
            );
            tasks.add(new Task()
                    .setName("Записать что съел на обед")
                    .setDone(false)
                    .setChecked(true)
                    .setCreateDate(new Date())
                    .setAuthor(admin)
                    .setCategory(category)
            );
            tasks.add(new Task()
                    .setName("Забрать перчатки из Розетки2")
                    .setDone(true)
                    .setChecked(false)
                    .setCreateDate(new Date())
                    .setAuthor(admin)
                    .setCategory(category2)
            );
            tasks.add(new Task()
                    .setName("Скачать дискографию Эминема")
                    .setDone(true)
                    .setChecked(true)
                    .setCreateDate(new Date())
                    .setAuthor(admin)
                    .setCategory(category)
            );
            tasks.add(new Task()
                    .setName("Помыть квартиру")
                    .setDone(false)
                    .setChecked(false)
                    .setCreateDate(new Date())
                    .setAuthor(admin)
                    .setCategory(category)
            );
            tasks.add(new Task()
                    .setName("Подать документы")
                    .setDone(false)
                    .setChecked(true)
                    .setCreateDate(new Date())
                    .setAuthor(admin)
                    .setCategory(category)
            );
            admin.setCategories(categories);
           // admin.setTasks(tasks);

            repository.save(admin);
            repository.save(new User("user@gmail.com", new BCryptPasswordEncoder().encode("1111"), Role.USER));
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
