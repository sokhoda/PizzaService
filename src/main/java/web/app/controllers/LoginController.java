package web.app.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.security.Principal;
import java.util.*;

@Controller
public class LoginController {

    @RequestMapping(name = "/app/loginp", method = RequestMethod.GET)
    public String login(){
        return "login";
    }

}
