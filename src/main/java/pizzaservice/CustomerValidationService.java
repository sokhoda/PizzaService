package pizzaservice;

import domain.Customer;
import org.springframework.validation.BindingResult;

public interface CustomerValidationService  {
    boolean isNotValid(Customer customer, BindingResult bindingResult, Class<?> group);
}