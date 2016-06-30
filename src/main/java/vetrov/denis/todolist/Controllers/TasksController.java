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
import vetrov.denis.todolist.comparators.TaskComparator;
import vetrov.denis.todolist.models.Task;
import vetrov.denis.todolist.repositories.TaskRepository;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

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

        Collections.sort(taskRepository.getTasks(), taskComparator);
        model.addObject("tasks", taskRepository.getTasks());
        return model;
    }

    @RequestMapping("/create")
    public ModelAndView showNewTasksPage() {
        ModelAndView model = new ModelAndView("newTask");
        return model;
    }

    @RequestMapping(value = "/create", method = RequestMethod.POST)
    public String newTaskSubmit(@ModelAttribute Task task, Model model) {
        taskRepository.addTask(task);
        return "redirect:/";
    }

}

