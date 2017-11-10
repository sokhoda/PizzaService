package pizzaservice;

import domain.*;
import org.springframework.beans.factory.annotation.RequiredAnnotationBeanPostProcessor;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.security.access.annotation.Secured;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.access.prepost.PreFilter;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.TransactionDefinition;
import org.springframework.transaction.TransactionException;
import org.springframework.transaction.TransactionStatus;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.servlet.HandlerExceptionResolver;
import pizzaservice.cheque.ChequeProducer;
import pizzaservice.states.InProgressState;
import pizzaservice.states.NewState;
import pizzaservice.states.OrderStateCycle;
import pizzaservice.states.StateEn;
import repository.AddressRepository;
import repository.CustomerRepository;
import repository.OrderRepository;
import repository.PizzaRepository;

import javax.annotation.security.RolesAllowed;
import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

import static org.springframework.security.access.vote.AuthenticatedVoter.IS_AUTHENTICATED_ANONYMOUSLY;


public class SpringJPAAppRunner {
    private static Random random = new Random();

    public static void init(PizzaService pizzaService,
                            AddressService addressService) {
        if (pizzaService == null) return;
        pizzaService.save(new Pizza(null, "Tomato", (double) random.nextInt
                (1000), PizzaType.VEGETERIAN));
        pizzaService.save(new Pizza(null, "Chicken", (double) random.nextInt
                (1000), PizzaType.MEAT));
        pizzaService.save(new Pizza(null, "Fish", (double) random.nextInt
                (1000), PizzaType.SEA));

        Customer customer = new Customer("Anna Guyvan", new LoyaltyCard(0.));
        Address address = new Address
                ("01032", "Kyiv", "Iwana Pidkovy", AddressType.HOME, String.valueOf
                        (random.nextInt(1000)), String.valueOf
                        (random.nextInt(90)));
        addressService.save(address);
    }

    public static void main(String[] args) {
        ConfigurableApplicationContext repoContext = new
                ClassPathXmlApplicationContext("repoContext.xml");

        ConfigurableApplicationContext appContext = new
                ClassPathXmlApplicationContext(new String[]
                {"app_context.xml"}, repoContext);

        System.out.print("repoContext::");
        System.out.println(Arrays.toString(repoContext.getBeanDefinitionNames()));
        System.out.print("appContext::");
        System.out.println(Arrays.toString(appContext.getBeanDefinitionNames()));

        CustomerService customerService = appContext.getBean("customerService", CustomerService.class);
        AddressService addressService = appContext.getBean("addressService",
                AddressService.class);
        Customer customer2 = customerService.find(2L);
//        System.out.println(customer);
//
//        PreFilter
//        RolesAllowed

        CustomerRepository customerRepository = (CustomerRepository)
                appContext.getBean("customerRepository");
        PizzaRepository pizzaRepository = (PizzaRepository) appContext.getBean
                ("pizzaRepository");
        PizzaService pizzaService = (PizzaService) appContext.getBean
                ("pizzaService");

        OrderService orderService = appContext.getBean("orderService", OrderService.class);
        OrderRepository orderRepository = appContext.getBean
                ("orderRepository", OrderRepository.class);

        Customer customer1 = customerRepository.find(1L);

        LocalDateTime fromDate = LocalDateTime.of(2016, 10, 4, 0, 0);
        LocalDateTime toDate = LocalDateTime.of(2016, 11, 10, 0, 0);
        List<Orders> orderList = orderService.findByDateBetween(fromDate,
                toDate);
//        orderList = orderService.findByCustomerByState(customer1, new
//                NewState());

        orderList = orderService.findByDateBetweenByState(fromDate,
                toDate, new InProgressState());
        System.out.println(orderList);

        AddressRepository addressRepo = appContext.getBean
                ("addressRepository", AddressRepository.class);

//        List<Address> addressList = addressRepo.findAll("buildingNo+0");
        List<Address> addressList = addressRepo.findAll("buildingNo+0");
        System.out.println(addressList);

//        orderList = orderService.findByDateBetweenByStateByCustomer(fromDate,
//                toDate, new NewState(), customer1);
//        System.out.println(orderList);
//
//
////
//        System.out.println("\n\n\n\n\n\n !!!" + orderRepository.findByCustomer
//                (customer1));

//        for (int i = 0; i < 3; i++) {
//            init(pizzaService, addressService);
//        }

        Pizza pizza = pizzaRepository.read(5L);
        System.out.println(pizza);
        Customer customer = customerRepository.find(1L);
        OrderStateCycle orderStateCycle = (OrderStateCycle) appContext.getBean
                ("orderStateCycle");
        System.out.println(orderStateCycle + "!!!!!!!!!!!!!!!!!!!!!!");
        System.out.println();
        Orders order = orderService.placeNewOrder(customer, 1L, 2L, 4L);
        order = orderService.addPizzas(order, 1L, 2L);

        ChequeProducer chequeProducer = appContext.getBean("chequeProducer",
                ChequeProducer.class);
        System.out.println("Customer::\n" + customer);
        order = chequeProducer.placeCheque(order);

        System.out.println(order);
        System.out.println("Cheque::\n" + order.getCheque());

        System.out.println("Customer::" + customer);
        Orders order2 = orderService.placeNewOrder(customer, 3L, 6L);
        order2 = chequeProducer.placeCheque(order2);
        order2.nextState();
        order2 = orderService.save(order2);
        System.out.println(order2);
        System.out.println("Cheque::\n" + order2.getCheque());

        System.out.println(orderService.findByCustomer(customer));
//+++++++++++++++++++++++++++++++++++++++++++++++
        System.out.println(order + "\n" + order2);
        order = orderService.save(order);
        System.out.println(order + "\n" + order2);
//
//
//        Order order11 = orderService.find(1L);
//        System.out.println("order11::\n" + order11);
//
//        Order order22 = orderService.find(2L);
//        System.out.println("order22::\n" + order22);

//        Pizza pizza = new Pizza();
//        pizza.setStreetName("Customized");
//        pizza.setType(PizzaType.MEAT);
//        pizza = pizzaService.save(pizza);
//        System.out.println(pizza);
//        System.out.println(pizza.getPizzaId());
//OrderStateCycle orderStateCycle = appContext.getBean("orderStateCycle",
//        OrderStateCycle.class);
//        System.out.println(orderStateCycle.toString());
//
//
//        ChequeProducer chequeProducer = appContext.getBean("chequeProducer",
//                ChequeProducer.class);
//        OrderService orderService =  appContext.getBean("orderService", OrderService.class);
//        System.out.println(orderService);
//        Order order = orderService.placeNewOrder(customer, 1L, 2L, 3L);
//        order = orderService.addPizzas(order, 1L, 2L);
//
//        Cheque cheque = chequeProducer.placeCheque(order);
//        System.out.println(order);
//        System.out.println(cheque);
//        System.out.println(customer);
//
//        System.out.println("\n\n\n----------Order II----------\n");
//        order = orderService.placeNewOrder(customer, 2L, 2L, 3L);
//
//        cheque = chequeProducer.placeCheque(order);
//        System.out.println(order);
//        System.out.println(cheque);
//        System.out.println(customer);
//
//        ChequeService chequeService = appContext.getBean
//                ("simpleChequeService", SimpleChequeService.class);
//
//        System.out.println("found Cheque:\n" + chequeService.find(2L));

        repoContext.close();
        appContext.close();
    }

}
