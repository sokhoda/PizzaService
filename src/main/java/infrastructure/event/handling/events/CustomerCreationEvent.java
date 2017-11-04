package infrastructure.event.handling.events;

import domain.Customer;
import org.springframework.context.ApplicationEvent;

public class CustomerCreationEvent extends ApplicationEvent {
    private Customer customer;
    private String message;

    public CustomerCreationEvent(Object source, Customer customer, String message) {
        super(source);
        this.customer = customer;
        this.message = message;
    }

    public String getMessage() {
        return String.format(message, customer);
    }
}
