package vetrov.denis.todolist.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import vetrov.denis.todolist.models.CurrentUser;
import vetrov.denis.todolist.models.entities.Task;
import vetrov.denis.todolist.repositories.TaskRepository;
import vetrov.denis.todolist.repositories.UserRepository;

import java.util.Collections;

/**
 * Created by Denis on 05.07.2016.
 */
@Controller
@RequestMapping("/task")
public class CreateController {
    @Autowired
    TaskRepository taskRepository;

    @Autowired
    UserRepository userRepository;

    @RequestMapping("/create")
    public ModelAndView showNewTasksPage(@ModelAttribute CurrentUser currentUser) {
        ModelAndView model = new ModelAndView("newTask");
        model.addObject("user", userRepository.findOneByEmail(currentUser.getUser().getEmail()).get(0));
        return model;
    }

    @RequestMapping(value = "/create", method = RequestMethod.POST)
    public String newTaskSubmit(@ModelAttribute Task task, Model model) {
        taskRepository.addTask(task);
        return "redirect:/task/all";
    }
}
