package web.app.controllers;

import domain.Pizza;
import exceptions.PizzaPriceException;
import exceptions.PizzaTypeException;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.security.access.prepost.PostFilter;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import pizzaservice.PizzaService;

@Slf4j
@Controller
@RequestMapping("/pizza")
public class PizzaController {

    @Autowired
    public PizzaService pizzaService;

    @RequestMapping("/create")
//    @Secured("ROLE_ADMIN")
//    @Secured("hasRole('ADMIN')")
    public String create() {
        return "pizza/pizzaedit";
    }

//    @RequestMapping("/edit")
//    public String edit(@RequestParam Long pizzaID, Model model){
//        model.addAttribute("pizza", pizzaService.find(pizzaID));
//        return "pizzaedit";
//    }

    @RequestMapping("/edit")
    public String edit(@RequestParam Long pizzaId) {
        return "pizza/pizzaedit";
    }

    @RequestMapping(value = "/addnew", method = RequestMethod.POST)
    public String addnew(@ModelAttribute @Validated Pizza pizza, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            log.error("!!!!!ERRORS:");
            return "pizza/pizzaedit";
        }
        System.out.println(pizza);
        pizzaService.save(pizza);
        return "redirect:../pizza/list";
    }

    @RequestMapping(value = "/pizzatypeexception")
    public void pizzaTypeException() {
        throw new PizzaTypeException("Pizza type not found");
    }

    @RequestMapping(value = "/pizzapriceexception")
    public void pizzaPriceException() {
        throw new PizzaPriceException("Pizza price not valid");
    }

    @RequestMapping(value = "/pizzalist/upload", method = RequestMethod.POST)
    public String uploadFiles(@RequestParam("nname") String name,
                              @RequestParam("ffile") MultipartFile file,
                              Model model) {

        model.addAttribute("resultMessage", pizzaService.uploadFile(file));
        return "utils/upload/pizzaListUpload";
    }

    @RequestMapping("/pizzalist/upload")
    public String showMultipart() {
        return "utils/upload/pizzaListUpload";
    }

    @RequestMapping(value = "/remove", method = RequestMethod.POST)
    public String remove(@ModelAttribute Pizza pizza) {
        pizzaService.remove(pizza);
        return "redirect:../pizza/list";
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
//    @Secured("IS_AUTHENTICATED_FULLY")
    public String getAllPizzas(HttpSession session,
                               HttpServletRequest req,
                               HttpEntity<byte[]> httpEntity) {
        session.setAttribute("ed", new Pizza());
        req.getHeader("er");
        byte[] body = httpEntity.getBody();
        return "pizza/pizzalist";
    }

    @PostFilter("filterObject.type != T (domain.PizzaType).MEAT")
//    @PostFilter("filterObject.pizzaId > 5")
    @ModelAttribute("pizzalist")
    public List<Pizza> getPizzas() {
        List<Pizza> pizzalist = pizzaService.findAll();
        return pizzalist;
    }


}
