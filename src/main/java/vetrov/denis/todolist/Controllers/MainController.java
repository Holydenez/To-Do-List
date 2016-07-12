package vetrov.denis.todolist.controllers;

/**
 * Created by Denis on 23.03.2016.
 */

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class MainController {

    @RequestMapping(value="/")
    public String showTasksPage() {
     return "redirect:/task/all";
    }

}

