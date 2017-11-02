package web.app.controllers;

import exceptions.CustomerAddressException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import pizzaservice.PizzaService;
import web.app.services.CommonService;
import web.app.services.CommonServiceImpl;

import javax.inject.Inject;
import java.security.Principal;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

@Controller
public class CommonController {

    @Autowired
    public PizzaService pizzaService;
    @Inject
    private CommonService commonService;

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
    public ModelAndView redirectDashboard(Principal principal, ModelAndView model) {
       return commonService.populateModelAndView(principal, model);
    }

}
