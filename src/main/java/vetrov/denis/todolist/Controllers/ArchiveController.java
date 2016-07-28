package vetrov.denis.todolist.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import vetrov.denis.todolist.models.CurrentUser;
import vetrov.denis.todolist.repositories.TaskRepository;

/**
 * Created by Denis on 05.07.2016.
 */
@Controller
@RequestMapping("/task/archive")
public class ArchiveController {
    @Autowired
    TaskRepository taskRepository;

    @RequestMapping(value = "/")
    public ModelAndView showArchivePage(@ModelAttribute CurrentUser currentUser) {
        ModelAndView model = new ModelAndView("archive");
        model.addObject("user", taskRepository.getDoneTasks(currentUser, currentUser.getTaskSortType().getComparator()));
        return model;
    }

    @RequestMapping("/add")
    public String addToArchive(@RequestParam Long id) {
        taskRepository.setTaskDone(id);
        return "redirect:/task/all";
    }

    @RequestMapping("/remove")
    public String getTaskBack(@RequestParam Long id) {
        taskRepository.undoTask(id);
        return "redirect:/task/archive";
    }
}
