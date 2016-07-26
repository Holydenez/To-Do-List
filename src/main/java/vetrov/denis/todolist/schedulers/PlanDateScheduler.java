package vetrov.denis.todolist.schedulers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import vetrov.denis.todolist.models.CurrentUser;
import vetrov.denis.todolist.models.entities.Task;
import vetrov.denis.todolist.models.entities.User;
import vetrov.denis.todolist.repositories.TaskRepository;
import vetrov.denis.todolist.services.EmailSenderService;

import java.util.Date;

/**
 * Created by Denis on 21.07.2016.
 */

@Component
public class PlanDateScheduler {

    @Autowired
    private TaskRepository taskRepository;


    @Autowired
    EmailSenderService emailSenderService;

    @Scheduled(cron = "0 0 6 * * TUE")
    public void checkPlanedDate() {
        for (Task task : taskRepository.getTasks()) {
            if (task.getPlanDate().before(new Date())) {
                task.setPlanDateFailed(true);
                emailSenderService.send("holydenez@gmail.com", "TO-DO LIST", "Ваша задача " + task.getName() + " из категории " + task.getCategory() + " просрочена");
            }
        }
    }
}
