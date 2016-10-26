package pizzaservice.cheque;

import domain.*;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import pizzaservice.discount.DiscountCalculator;

import java.util.*;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.*;

public class SimpleChequeProducerTest {
    @Mock
    private DiscountCalculator discountCalculator;
    @Mock
    private ChequeService chequeService;
    private SimpleChequeProducer scp;

    @Before
    public void setUp() throws Exception {
        MockitoAnnotations.initMocks(this);
        scp = new SimpleChequeProducer(discountCalculator, chequeService);
    }

    @Test
    public void testPlaceCheque() throws Exception {
        Order order = getSimpleOrder();

        Cheque cheque = new Cheque();
        System.out.println(cheque);

        SimpleChequeProducer scpSpy = spy(scp);

//      GIVEN
        doNothing().when(discountCalculator).handleDiscount(order, cheque);
        doReturn(cheque).when(scpSpy).createNewCheque();

//      WHEN
        Cheque actualCheque = scpSpy.placeCheque(order);
//      THEN
        assertThat(actualCheque, is(cheque));
        verify(scpSpy).createNewCheque();
        verify(discountCalculator).handleDiscount(order, cheque);
        verify(chequeService).save(cheque);
    }

    private Order getSimpleOrder() {
        final Map<Pizza, Integer> pizzaMap  = new HashMap<>();
        Pizza pizza = new Pizza(2L, "Chicken", 120., PizzaType.MEAT);
        Address address = new Address("0343", "Kyov","Customer", "Str", "18",
                "2");
        Customer customer = new Customer("Alex", address, new LoyaltyCard(0.));

        pizzaMap.put(new Pizza(1L, "Tomato", 90., PizzaType.VEGETERIAN), 1);
        return new Order(null, customer, pizzaMap);
    }
}
