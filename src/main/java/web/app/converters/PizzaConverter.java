package web.app.converters;

import domain.Pizza;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import pizzaservice.PizzaService;

public class PizzaConverter implements Converter<String, Pizza>{
    @Autowired
    PizzaService pizzaService;

    @Override
    public Pizza convert(String pizzaIdStr) {
        System.out.println("Convert " + pizzaIdStr);
        if(pizzaIdStr == null || pizzaIdStr.isEmpty()){
            return new Pizza();
        }
        Long pizzaId= Long.valueOf(pizzaIdStr);
        if (pizzaId != null){
            return pizzaService.find(pizzaId);
        } else{
            return null;
        }
    }
}
