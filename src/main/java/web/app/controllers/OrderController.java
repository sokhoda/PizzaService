package web.app.controllers;

import domain.Customer;
import domain.DomainHelper;
import domain.Orders;
import domain.Pizza;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import pizzaservice.OrderService;
import web.app.converters.PizzaConverter;
import web.app.dto.OrdersList;
import web.app.dto.PizzaList;
import web.infrastructure.Routes;

import javax.inject.Inject;
import javax.servlet.http.HttpSession;
import java.util.List;

@Slf4j
@Controller
public class OrderController {
    public static final String USER = "user";

    @Inject
    private OrderService orderService;
    @Inject
    private PizzaConverter pizzaConverter;


    @RequestMapping(value = "/orders", method = RequestMethod.GET)
    public String findAll(ModelMap model) {
        List<Orders> orderList = orderService.findAll();

        model.addAttribute(DomainHelper.ORDERSLIST, new OrdersList(orderList));
        return Routes.ORDER_EDIT_PAGE;
    }

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
