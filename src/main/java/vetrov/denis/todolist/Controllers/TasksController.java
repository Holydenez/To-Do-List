package vetrov.denis.todolist.controllers;

/**
 * Created by Denis on 23.03.2016.
 */

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import vetrov.denis.todolist.comparators.TaskComparator;
import vetrov.denis.todolist.models.entities.Task;
import vetrov.denis.todolist.repositories.TaskRepository;

@Controller
@RequestMapping("/task")
public class TasksController {

    @Autowired
    TaskRepository taskRepository;

    @Autowired
    TaskComparator taskComparator;

    @RequestMapping(value = "/all")
    public ModelAndView showTasksPage() {
        ModelAndView model = new ModelAndView("index");
        model.addObject("tasks", taskRepository.getTasks());
        return model;
    }

    @RequestMapping("/checked")
    public String setTaskChecked(@RequestParam String id) {
        taskRepository.setTaskChecked(id);
        taskRepository.getTasks();
        return "redirect:/";
    }

    @RequestMapping("/unchecked")
    public String setTaskUnchecked(@RequestParam String id) {
        taskRepository.setTaskUnchecked(id);
        taskRepository.getTasks();
        return "redirect:/";
    }

    @RequestMapping(value = "/all/checkDate")
    @Scheduled(cron = "0 0 7 * * *")
    public void checkPlanedDate() {
        taskRepository.failedPlanedDate();
    }

}

