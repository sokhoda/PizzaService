package web.app.validators;

import domain.Pizza;
import domain.PizzaType;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

@Component
public class PizzaValidator implements Validator {
    private static final Integer PIZZA_MAX_PRICE = 999;
    public static final String PIZZA = "pizza";
    public static final String PIZZA_PRICE_CAN_T_BE_NEGATIVE = "pizza price can`t be negative";
    public static final String PIZZA_PRICE_IS_TOO_HIGH = "pizza price is too high";
    public static final String PIZZA_NAME_IS_REQUIRED = "pizza name is required";
    public static final String PRICE = "price";
    public static final String NEGATIVE_VALUE = "negativeValue";
    public static final String PRICE_TOO_HIGH = "price.too.high";
    public static final String NAME = "name";
    public static final String NAME_REQUIRED = "name.required";

    @Override
    public boolean supports(Class<?> clazz) {
        return Pizza.class.equals(clazz);
    }

    @Override
    public void validate(Object target, Errors errors) {
        Pizza pizza = (Pizza) target;
        Object[] errorArgs = {PIZZA};
        if (pizza.getPrice() < 0) {
            errors.rejectValue(PRICE, NEGATIVE_VALUE, errorArgs, PIZZA_PRICE_CAN_T_BE_NEGATIVE);
        }
        if (pizza.getPrice() > PIZZA_MAX_PRICE) {
            errors.rejectValue(PRICE, PRICE_TOO_HIGH, new Object[] {PIZZA, PIZZA_MAX_PRICE}, PIZZA_PRICE_IS_TOO_HIGH);
        }
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, NAME, NAME_REQUIRED, errorArgs, PIZZA_NAME_IS_REQUIRED);
    }
}
