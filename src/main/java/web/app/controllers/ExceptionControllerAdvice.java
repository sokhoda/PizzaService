package web.app.controllers;

import org.springframework.http.HttpStatus;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;

import javax.servlet.http.HttpServletRequest;
@ControllerAdvice
public class ExceptionControllerAdvice {

    @ExceptionHandler(NumberFormatException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public String error(Exception e, HttpServletRequest req,
                                    Model model) {

        model.addAttribute("ex", e);
        model.addAttribute("url", req.getRequestURL());
        return "errorPage";
    }
}
