package infrastructure.event.handling.listeners;

import infrastructure.event.handling.events.CustomerCreationEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

@Component
public class CustomerCreationEventListener implements ApplicationListener<CustomerCreationEvent> {

    @Override
    public void onApplicationEvent(CustomerCreationEvent event) {
        System.out.println("received new event: " + event.getMessage());
    }
}
