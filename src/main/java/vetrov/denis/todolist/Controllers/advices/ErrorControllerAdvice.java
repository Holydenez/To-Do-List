package vetrov.denis.todolist.controllers.advices;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.ModelAndView;

@ControllerAdvice
public class ErrorControllerAdvice {

    @ExceptionHandler(Exception.class)
    public ModelAndView index(Exception exception) {
        ModelAndView model = new ModelAndView("error");
        model.addObject("error", exception);
        model.addObject("message", exception.getMessage());
        return model;
    }

}
