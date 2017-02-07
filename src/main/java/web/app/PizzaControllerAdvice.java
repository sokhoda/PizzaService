package web.app;

import domain.Pizza;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestParam;
import pizzaservice.PizzaService;

@ControllerAdvice
public class PizzaControllerAdvice {
    @Autowired
    PizzaService pizzaService;

//    @ModelAttribute
//    public Pizza pizzaMeth(@RequestParam(name = "pizzaId", required = false)
//                                   Long pizzaId){
//        if (pizzaId != null){
//            return pizzaService.find(pizzaId);
//        } else {
//            return new Pizza();
//        }
//    }

    @ModelAttribute(name = "pizza")
    public Pizza pizzaMeth(@RequestParam(name = "pizzaId", required = false)
                                   Pizza pizza){
        System.out.println("ControllerAdvice" + pizza);

        return pizza;
    }
    @InitBinder
    public void pizzaBinder(WebDataBinder binder){

    }
}
