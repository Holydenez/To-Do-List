package vetrov.denis.todolist.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import vetrov.denis.todolist.repositories.UserRepository;

import java.util.Optional;

@Controller
public class LoginController {
    @Autowired
    UserRepository userRepository;
    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public ModelAndView getLoginPage(@RequestParam Optional<String> error) {
        return new ModelAndView("login", "error", error);
    }
    @RequestMapping(value = "/logout", method = RequestMethod.GET)
    public ModelAndView logout(@RequestParam Optional<String> error) {
        return new ModelAndView("login", "error", error);
    }
//    @RequestMapping(value = "/login", method = RequestMethod.POST)
//    public String getUserEmail(@ModelAttribute User user) {
//        userRepository.getUserEmail(user);
//        return "redirect:/";
//    }
}
