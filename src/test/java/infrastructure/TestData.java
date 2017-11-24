package infrastructure;

import businessdomain.Pizza;
import businessdomain.PizzaType;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class TestData {
    protected final Pizza testPizza1 = new Pizza(1L, "Tomato", 90., PizzaType
            .VEGETERIAN);
    protected final Pizza testPizza2 = new Pizza(2L, "Chicken", 120., PizzaType
            .MEAT);
    protected List<Pizza> expectedPizzaList = new ArrayList<>(Arrays.asList
            (testPizza1, testPizza2));
}
