package pizzaservice;

import businessdomain.Pizza;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;

@RunWith(Parameterized.class)
public class SimpleParameterizedTest {
    private Long id;
    private String name;

    private Pizza pizza;

    public SimpleParameterizedTest(Long id, String name) {
        this.id = id;
        this.name = name;
    }

    @Parameterized.Parameters
    public static Collection someMethod() {
        return Arrays.asList(new Object[][]{
                {1L, "testName"},
                {2L, "testName2"}});
    }

    @Before
    public void init() {
        pizza = new Pizza(id, name);
    }

    @Test
    public void namePizzaId() throws Exception {
        System.out.println("Input:" + id + ", name =" + name);

        assertThat(pizza.getPizzaId(), is(id));
        assertThat(pizza.getName(), is(name));
    }

}
