package vetrov.denis.todolist.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import vetrov.denis.todolist.models.CurrentUser;
import vetrov.denis.todolist.repositories.TaskRepository;

@Controller
@RequestMapping("/task")
public class CategoryController {
    @Autowired
    TaskRepository taskRepository;

    @RequestMapping(value = "/chooseCategory", method = RequestMethod.POST)
    public String chooseCategory(@RequestParam String category,
                                 @ModelAttribute CurrentUser currentUser) {
        currentUser.setSelectedCategory(category);
        return "redirect:/task/all";
    }
}
