package vetrov.denis.todolist;

/**
 * Created by Denis on 23.03.2016.
 */
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class HelloController {

    @RequestMapping("/")
    public ModelAndView showTasksPage() {
        ModelAndView model = new ModelAndView("index");
        model.addObject("name", "Denis");
        return model;
    }

    @RequestMapping("/tasks")
    @ResponseBody
    public String tasks(@RequestParam Integer a, @RequestParam Integer b) {

        return String.valueOf(b+a);
    }

}
