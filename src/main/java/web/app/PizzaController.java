package web.app;

import domain.Pizza;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import pizzaservice.PizzaService;

import java.util.List;

@Controller
public class PizzaController {

    @Autowired
    public PizzaService pizzaService;

    @RequestMapping("/hello")
    public String hello(){
        return "hello";
    }

    @RequestMapping("/exception")
    public void exception(){
        throw new  NumberFormatException("artificial exception");
    }

    @RequestMapping("/create")
    public String create(){
        return "pizzaedit";
    }

//    @RequestMapping("/edit")
//    public String edit(@RequestParam Long pizzaID, Model model){
//        model.addAttribute("pizza", pizzaService.find(pizzaID));
//        return "pizzaedit";
//    }

    @RequestMapping("/edit")
    public String edit(@RequestParam Long pizzaId){
        return "pizzaedit";
    }

    @RequestMapping(name = "/addnew", method = RequestMethod.POST)
    public String addnew(@ModelAttribute Pizza pizza){
        System.out.println(pizza);
        pizzaService.save(pizza);
        return "redirect:list";
    }


    @RequestMapping(value = "/list", method = RequestMethod.GET)
    public ModelAndView getAllPizzas(ModelAndView modelAndView){
        List<Pizza> pizzaList = pizzaService.findAll();
        modelAndView.setViewName("pizzalist");
        modelAndView.addObject("pizzalist", pizzaList);
        return modelAndView;
    }




}
