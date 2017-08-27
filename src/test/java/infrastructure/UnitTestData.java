package infrastructure;

import domain.*;
import org.junit.runner.RunWith;
import org.mockito.runners.MockitoJUnitRunner;
import pizzaservice.states.NewState;
import pizzaservice.states.OrderStateCycle;

import java.util.*;

@RunWith(MockitoJUnitRunner.class)
public class UnitTestData extends TestData{

    protected final Map<Pizza, Integer> pizzaMap = new HashMap<>();
    protected Customer testCustomer;
    protected Orders expectedOrder;
    protected LoyaltyCard testLoyaltyCard;
    protected Address testAddress;
    protected String testCustomerName;
    protected Cheque testCheque;
    protected DiscountRecord testDiscountRecord;

    {
        initTestLoyaltyCard();
        initTestCustomer();
        initExpectedOrder();
        initTestCheque();
        initTestDiscontRecord();
    }

    private void initTestCustomer() {
        testCustomerName = "Alex";
        testCustomer = new Customer(testCustomerName,  testLoyaltyCard);
        testCustomer.setCustomerId(1L);
        testAddress = new Address("03004", "Kyiv", "CustomStreetName", "Str",
                "18", "2", testCustomer);
        testAddress.setId(1L);
        testCustomer.getAddress().add(testAddress);
    }

    private void initTestLoyaltyCard() {
        testLoyaltyCard = new LoyaltyCard(0.);
    }

    private void initTestDiscontRecord() {
        testDiscountRecord = new DiscountRecord();
        testDiscountRecord.setId(1L);
        testDiscountRecord.setCheque(testCheque);
    }

    private void initTestCheque(){
        testCheque = new Cheque();
        testCheque.setId(1L);
    }

    private void initExpectedOrder() {
        pizzaMap.put(testPizza1, 1);
        OrderStateCycle orderStateCycle = new OrderStateCycle();
        orderStateCycle.setCurState(new NewState());
        expectedOrder = new Orders(testCustomer, pizzaMap, orderStateCycle);
    }
}
