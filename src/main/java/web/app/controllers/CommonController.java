package web.app.controllers;

import domain.Pizza;
import exceptions.CustomerAddressException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.security.access.prepost.PostFilter;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import pizzaservice.PizzaService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.security.Principal;
import java.util.List;

@Controller
public class CommonController {

    @Autowired
    public PizzaService pizzaService;

    @RequestMapping("/")
    public String index(){
        return "redirect:dashboard";
    }

    @RequestMapping("/hello")
    public String hello(Principal principall) {
        Object principal = SecurityContextHolder.getContext()
                .getAuthentication().getPrincipal();

        String username;
        if (principal instanceof UserDetails) {
            username = ((UserDetails) principal).getUsername();
        }
        else {
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
    public String redirectDashboard() {
        return "dashboard";
    }

}
