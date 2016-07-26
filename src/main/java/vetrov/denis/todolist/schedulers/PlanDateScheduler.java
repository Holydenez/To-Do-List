package vetrov.denis.todolist.schedulers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import vetrov.denis.todolist.models.CurrentUser;
import vetrov.denis.todolist.models.entities.User;
import vetrov.denis.todolist.repositories.TaskRepository;

/**
 * Created by Denis on 21.07.2016.
 */

@Component
public class PlanDateScheduler {

    @Autowired
    private TaskRepository taskRepository;

    @Scheduled(cron = "0 0 7 * * MON")
    public void checkPlanedDate() {
        taskRepository.failedPlanedDate();
    }
}
