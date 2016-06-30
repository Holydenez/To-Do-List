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

@Controller
public class MainController {

    @RequestMapping(value="/")
    public String showTasksPage() {
     return "redirect:/task/all";
    }

}
