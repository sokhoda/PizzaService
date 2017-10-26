package web.app.controllers;

import domain.Customer;
import domain.Pizza;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.datetime.DateFormatter;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestParam;
import pizzaservice.CustomerService;

@ControllerAdvice(assignableTypes = {CustomerController.class})
public class CustomerControllerAdvice {
    @Autowired
    CustomerService customerService;

    @ModelAttribute(name = "customer")
    public Customer loadCustomer(@RequestParam(name = "customerId", required = false) Customer customer) {
        System.out.println("ControllerAdvice: " + customer);

        return customer;
    }

}
