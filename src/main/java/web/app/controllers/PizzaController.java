package web.app.controllers;

import domain.Pizza;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.security.access.annotation.Secured;
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
public class PizzaController {

    @Autowired
    public PizzaService pizzaService;

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

    @RequestMapping(value = "/upload", method = RequestMethod.POST)
    public String uploadFiles(@RequestParam("nname") String name,
                              @RequestParam("ffile") MultipartFile file,
                              Model model) {

        model.addAttribute("resultMessage", pizzaService.uploadFile(file));
        return "multipart";
    }

    @RequestMapping(value = "/exception")
    public void exception() {
        throw new NumberFormatException("artificial exception");
    }

    @RequestMapping("/create")
    @Secured("ROLE_ADMIN")
//    @Secured("hasRole('ADMIN')")
    public String create() {
        return "pizzaedit";
    }

//    @RequestMapping("/edit")
//    public String edit(@RequestParam Long pizzaID, Model model){
//        model.addAttribute("pizza", pizzaService.find(pizzaID));
//        return "pizzaedit";
//    }

    @RequestMapping("/multipart")
    public String showMultipart() {
        return "multipart";
    }

    @RequestMapping("/edit")
    public String edit(@RequestParam Long pizzaId) {
        return "pizzaedit";
    }

    @RequestMapping(value = "/addnew", method = RequestMethod.POST)
    public String addnew(@ModelAttribute Pizza pizza) {
        System.out.println(pizza);
        pizzaService.save(pizza);
        return "redirect:list";
    }

    @RequestMapping(value = "/remove", method = RequestMethod.POST)
    public String remove(@ModelAttribute Pizza pizza) {
        pizzaService.remove(pizza);
        return "redirect:list";
    }


//    @RequestMapping(value = "/list", method = RequestMethod.GET)
//    @Secured("IS_AUTHENTICATED_FULLY")
//    public ModelAndView getAllPizzas(ModelAndView modelAndView){
//        List<Pizza> pizzaList = pizzaService.findAll();
//        modelAndView.setViewName("pizzalist");
//        modelAndView.addObject("pizzalist", pizzaList);
//        return modelAndView;
//    }

    @RequestMapping(value = "/list", method = RequestMethod.GET)
    @Secured("IS_AUTHENTICATED_FULLY")
    public String getAllPizzas(HttpSession session,
                               HttpServletRequest req,
                               HttpEntity<byte[]> httpEntity) {
        session.setAttribute("ed", new Pizza());
        req.getHeader("er");
        byte[] body = httpEntity.getBody();
        return "pizzalist";
    }

    @RequestMapping(value = "/dashboard", method = RequestMethod.GET)
    public String redirectDashboard() {
        return "dashboard";
    }

    @PostFilter("filterObject.type != T (domain.PizzaType).MEAT")
//    @PostFilter("filterObject.pizzaId > 5")
    @ModelAttribute("pizzalist")
    public List<Pizza> getPizzas() {
        List<Pizza> pizzalist = pizzaService.findAll();
        return pizzalist;
    }


}
