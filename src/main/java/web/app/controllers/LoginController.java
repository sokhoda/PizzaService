package web.app.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import web.app.services.LoginService;

import javax.inject.Inject;
import javax.servlet.http.HttpSession;
import java.security.Principal;
import java.util.*;

@Controller
public class LoginController {

    @Inject
    private LoginService loginService;

    @RequestMapping(name = "/app/loginp", method = RequestMethod.GET)
    public String login(){
        return "login";
    }

}
