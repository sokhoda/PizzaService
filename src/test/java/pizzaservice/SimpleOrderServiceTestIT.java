package pizzaservice;

import domain.Orders;
import infrastructure.RepoTestConfig;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

public class SimpleOrderServiceTestIT extends RepoTestConfig {
    @Autowired
    private OrderService orderService;

    @Before
    public void clearTable() {
        clearAllTables();
    }

    @Test
    @Ignore
    public void placeNewOrder() throws Exception {
    }

    @Test
    public void findByCustomer() throws Exception {
        insertPizza();
        Orders expectedOrder1 = orderService.save(expectedOrder);
        //WHEN
        List<Orders> actualOrder = orderService.findByCustomer(testCustomer);
        //THEN
        assertThat(actualOrder.get(0), is(expectedOrder1));
    }

    @Test
    public void save() throws Exception {
        insertPizza();
//        WHEN
        Orders actualOrder = orderService.save(expectedOrder);
//        THEN
        assertNotNull(actualOrder.getId());
        assertNotNull(actualOrder.getCustomer());
    }

    @Test
    public void find() throws Exception {
        insertOrder();
        //WHEN
        Orders actualOrder = orderService.find(1L);
        //THEN
        assertTrue(actualOrder.equals(expectedOrder));
    }
}
