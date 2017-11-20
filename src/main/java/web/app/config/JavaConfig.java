package web.app.config;

import domain.Customer;
import domain.Orders;
import domain.Pizza;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.oxm.jaxb.Jaxb2Marshaller;
import org.springframework.web.servlet.ViewResolver;
import web.app.view.resolvers.JsonViewResolver;
import web.app.view.resolvers.XmlViewResolver;

@Configuration
public class JavaConfig {



    @Bean
    public ViewResolver xmlViewResolver() {
        Jaxb2Marshaller marshaller = new Jaxb2Marshaller();
        marshaller.setClassesToBeBound(Pizza.class, Customer.class, Orders.class);
        return new XmlViewResolver(marshaller);
    }

    @Bean
    public ViewResolver jsonViewResolver() {
        return new JsonViewResolver();
    }
}
