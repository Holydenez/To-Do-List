package vetrov.denis.todolist.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
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
    public ModelAndView showArchivePage() {
        ModelAndView model = new ModelAndView("archive");
        model.addObject("tasks", taskRepository.getDoneTasks());
        return model;
    }

    @RequestMapping("/add")
    public String addToArchive(@RequestParam String id) {
        taskRepository.setTaskDone(id);
        taskRepository.getDoneTasks();
        return "redirect:/";
    }

    @RequestMapping("/remove")
    public String getTaskBack(@RequestParam String id) {
        taskRepository.undoTask(id);
        taskRepository.getTasks();
        return "redirect:/task/archive/";
    }
}
