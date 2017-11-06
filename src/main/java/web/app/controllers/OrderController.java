package web.app.controllers;

import domain.Customer;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import pizzaservice.OrderService;
import web.app.converters.PizzaConverter;
import web.infrastructure.Routes;

import javax.inject.Inject;
import javax.servlet.http.HttpSession;

@Slf4j
@Controller
public class OrderController {
    public static final String USER = "user";

    @Inject
    private OrderService orderService;
    @Inject
    private PizzaConverter pizzaConverter;

    @RequestMapping(Routes.ORDER_CREATE)
    public String orderCreate(@RequestParam(required = false) Long orderId, Model model, HttpSession session) {
        orderService.doCreateOrder(model, session);
        return Routes.ORDER_EDIT_PAGE;
    }

    @RequestMapping(value = Routes.ORDER_ADDNEW, method = RequestMethod.POST)
    public String addNewOrder(@RequestParam("orderedPizzaIds") String orderedPizzaIds, HttpSession session) {
        Customer customer = (Customer) session.getAttribute(USER);
        orderService.buildOrder(orderedPizzaIds, customer, pizzaConverter);
        return Routes.REDIRECT_DASHBOARD_PAGE;
    }
}
