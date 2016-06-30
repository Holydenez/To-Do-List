package vetrov.denis.todolist.controllers;

/**
 * Created by Denis on 23.03.2016.
 */

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import vetrov.denis.todolist.models.Task;
import vetrov.denis.todolist.repositories.TaskRepository;

import java.util.ArrayList;
import java.util.List;

@Controller
public class TasksController {

    @Autowired
    TaskRepository taskRepository;

    @RequestMapping("/")
    public ModelAndView showTasksPage() {
        ModelAndView model = new ModelAndView("index");
       model.addObject("tasks",taskRepository.getTasks());
       return model;
    }

    @RequestMapping("/newTask")
    public ModelAndView showNewTasksPage() {
        ModelAndView model = new ModelAndView("newTask");
        return model;
    }

    @RequestMapping(value="/newTask", method= RequestMethod.POST)
    public String newTaskSubmit(@ModelAttribute Task task, Model model) {
        taskRepository.addTask(task);
        return "redirect:/";
    }

}

