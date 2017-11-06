package web.app.controllers;

import exceptions.CustomerAddressException;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import pizzaservice.CustomerService;
import pizzaservice.PizzaService;
import web.app.services.LoginService;

import javax.inject.Inject;
import javax.servlet.http.HttpSession;
import java.security.Principal;

@Controller
public class CommonController {

    @Inject
    public PizzaService pizzaService;

    @Inject
    public CustomerService customerService;

    @Inject
    private LoginService loginService;

    @RequestMapping("/hello")
    public String hello(Principal principall) {
        Object principal = SecurityContextHolder.getContext()
                .getAuthentication().getPrincipal();

        String username;
        if (principal instanceof UserDetails) {
            username = ((UserDetails) principal).getUsername();
        } else {
            username = principal.toString();
        }
        System.out.println(username);
        return "hello";
    }

    @RequestMapping(value = "/exception")
    public void numberFormatException() {
        throw new NumberFormatException("artificial exception");
    }

    @RequestMapping(value = "/customeraddressexception")
    public void customerAddressException() {
        throw new CustomerAddressException("Address not valid, 2r2:f3oifm3");
    }


    @RequestMapping(value = "/dashboard", method = RequestMethod.GET)
    public ModelAndView redirectDashboard(ModelAndView modelAndView, HttpSession session) {
        return loginService.doUserLogin(session, modelAndView);
    }
}
