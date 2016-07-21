package vetrov.denis.todolist.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import vetrov.denis.todolist.models.entities.User;
import vetrov.denis.todolist.services.UserCreateFormService;
import vetrov.denis.todolist.services.UserService;
import vetrov.denis.todolist.validators.UserCreateFormValidator;

import javax.validation.Valid;

/**
 * Created by Denis on 21.07.2016.
 */
@Controller
public class UserRegistrationController {
    @Autowired
    private UserService userService;
    @Autowired
    private UserCreateFormValidator userCreateFormValidator;

    @InitBinder("form")
    public void initBinder(WebDataBinder binder) {
        binder.addValidators(userCreateFormValidator);
    }

    @RequestMapping(value = "/user/create", method = RequestMethod.GET)
    public ModelAndView getUserCreatePage() {
        return new ModelAndView("user_create", "form", new UserCreateFormService());
    }

    @RequestMapping(value = "/user/create", method = RequestMethod.POST)
    public String handleUserCreateForm(@Valid @ModelAttribute("form") UserCreateFormService form, BindingResult bindingResult, User user) {
        if (bindingResult.hasErrors()) {
            return "user_create";
        }
        try {
            userService.create(form);
        } catch (DataIntegrityViolationException e) {
            bindingResult.reject("email.exists", "Email already exists");
            return "user_create";
        }
        return "redirect:/login";

    }

}