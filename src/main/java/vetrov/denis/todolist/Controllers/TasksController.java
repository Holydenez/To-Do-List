package vetrov.denis.todolist.controllers;

/**
 * Created by Denis on 23.03.2016.
 */

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import vetrov.denis.todolist.comparators.TaskComparator;
import vetrov.denis.todolist.models.CurrentUser;
import vetrov.denis.todolist.models.TaskSortType;
import vetrov.denis.todolist.models.entities.Task;
import vetrov.denis.todolist.repositories.TaskRepository;
import vetrov.denis.todolist.repositories.UserRepository;

import java.util.Collections;
import java.util.Comparator;

@Transactional
@Controller
@RequestMapping("/task")
public class TasksController {

    @Autowired
    TaskRepository taskRepository;

    @Autowired
    UserRepository userRepository;

    @RequestMapping(value = "/all")
    public ModelAndView showTasksPage(@ModelAttribute CurrentUser currentUser, Comparator<Task> comparator) {
        ModelAndView model = new ModelAndView("index");
        model.addObject("user", userRepository.findOneByEmail(currentUser.getUser().getEmail()).get(0));
        model.addObject( taskRepository.compareTasks(currentUser, currentUser.getTaskSortType().getComparator()));
        return model;
    }

    @RequestMapping("/sort")
    public String setSortType( @ModelAttribute CurrentUser currentUser,
                               @RequestParam TaskSortType taskSortType) {
        currentUser.setTaskSortType(taskSortType.reverse());
        return "redirect:/task/all";
    }

    @RequestMapping("/checked")
    public String setTaskChecked(@RequestParam Long id) {
        taskRepository.setTaskChecked(id);
        return "redirect:/task/all";
    }

    @RequestMapping("/unchecked")
    public String setTaskUnchecked(@RequestParam Long id) {
        taskRepository.setTaskUnchecked(id);
        return "redirect:/task/all";
    }
}

