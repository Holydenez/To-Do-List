package vetrov.denis.todolist.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import vetrov.denis.todolist.models.entities.Task;
import vetrov.denis.todolist.repositories.TaskRepository;

/**
 * Created by Denis on 05.07.2016.
 */

@Controller
@RequestMapping("/task")
public class EditController {

    @Autowired
    TaskRepository taskRepository;

    @RequestMapping("/edit")
    public ModelAndView editTaskPage(@RequestParam Long id) {
        ModelAndView model = new ModelAndView("editTask");
        model.addObject("task", taskRepository.getTask(id));
        return model;
    }

    @RequestMapping(value = "/edit", method = RequestMethod.POST)
    public String editTask(@ModelAttribute Task task) {
        taskRepository.editTask(task);
        return "redirect:/task/all";
    }

}
