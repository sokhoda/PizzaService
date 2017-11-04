package infrastructure.event.handling.publishers;

import domain.Customer;
import infrastructure.event.handling.events.CustomerCreationEvent;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Component;

import javax.inject.Inject;

@Component
public class CustomerCreationEventPublisher {

    @Value("#{properties['customer.create.message']}")
    private String message;

    @Inject
    private ApplicationEventPublisher applicationEventPublisher;

    public void doPublishEvent(Customer customer) {
        CustomerCreationEvent customerCreationEvent = new CustomerCreationEvent(this, customer, message);
        applicationEventPublisher.publishEvent(customerCreationEvent);
    }
}
