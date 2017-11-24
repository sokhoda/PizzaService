package pizzaservice;

import businessdomain.Pizza;
import businessdomain.PizzaType;
import infrastructure.TestData;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;
import repository.JPAPizzaRepo;
import repository.PizzaRepository;

import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;
import static org.mockito.Matchers.any;
import static org.mockito.Matchers.anyLong;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.powermock.api.mockito.PowerMockito.*;

@RunWith(PowerMockRunner.class)
@PrepareForTest(SimplePizzaService.class)
public class SimplePizzaServicePowerMockTest extends TestData {

    @Test
    public void findByType() throws Exception {
        PizzaRepository mockPizzaRepo = mock(PizzaRepository.class);

        when(mockPizzaRepo.findByType(any(PizzaType.class))).thenReturn(expectedPizzaList);
        PizzaService pizzaService = new SimplePizzaService(mockPizzaRepo);
        List<Pizza> actualList = pizzaService.findByType(any(PizzaType.class));

        assertThat(actualList, is(expectedPizzaList));
        verify(mockPizzaRepo).findByType(any(PizzaType.class));
    }

    @Test
    public void getVegetarianPizza() throws Exception {
        mockStatic(SimplePizzaService.class);
        when(SimplePizzaService.getVegetarianPizza()).thenReturn(testPizza1);
        assertThat(SimplePizzaService.getVegetarianPizza(), is(testPizza1));
        verifyStatic();
        SimplePizzaService.getVegetarianPizza();
    }

    @Test
    public void finalMethod() throws Exception {
        SimplePizzaService pizzaService = mock(SimplePizzaService.class);
        when(pizzaService.finalMethod()).thenReturn(testPizza2);
        Pizza actual = pizzaService.finalMethod();
        assertThat(actual, is(testPizza2));

        Mockito.verify(pizzaService).finalMethod();
    }

    @Test
    public void constructorTest() throws Exception {
        SimplePizzaService pizzaService = new SimplePizzaService();
        JPAPizzaRepo pizzaRepo = mock(JPAPizzaRepo.class);
        when(pizzaRepo.find(anyLong())).thenReturn(testPizza2);

        whenNew(JPAPizzaRepo.class).withNoArguments().thenReturn(pizzaRepo);
        Pizza actual = pizzaService.methodWithConstructor(1L);
        assertThat(actual, is(testPizza2));

        verifyNew(JPAPizzaRepo.class, times(1)).withNoArguments();
    }

    @Test
    public void privateMethod() throws Exception {
        SimplePizzaService pizzaService = spy(new SimplePizzaService());

        when(pizzaService, "privateGetPizza", anyLong()).thenReturn(testPizza1);

        Pizza actual = pizzaService.privateMethodCaller();
        assertThat(actual, is(testPizza1));

        verifyPrivate(pizzaService).invoke("privateGetPizza", anyLong());
    }

    @Test
    public void partialMocking() throws Exception {
        SimplePizzaService pizzaService = spy(new SimplePizzaService());

        doReturn(testPizza1).when(pizzaService).save(any(Pizza.class));

        Pizza actual = pizzaService.save(any(Pizza.class));
        assertThat(actual, is(testPizza1));

        verify(pizzaService).save(any(Pizza.class));
    }
}