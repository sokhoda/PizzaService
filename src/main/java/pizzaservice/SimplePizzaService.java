package pizzaservice;

import domain.Pizza;
import domain.PizzaType;
import dto.PizzaDto;
import dto.converters.PizzaDtoConverter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.Assert;
import org.springframework.web.multipart.MultipartFile;
import repository.JPAPizzaRepo;
import repository.PizzaRepository;
import utils.parsers.PriceListParser;

import javax.inject.Inject;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;

@Service("pizzaService")
public class SimplePizzaService implements PizzaService {

    public static final String FAIL_TO_UPLOAD_FILE = "Fail to upload file: '%s'";
    public static final String FILE_UPLOADED_SUCCESSFULLY = "File uploaded successfully: '%s'";

    @Autowired
    @Qualifier(value = "pizzaRepository")
    private PizzaRepository pizzaRepo;

    @Inject
    PriceListParser<PizzaDto> priceListParser;

    public SimplePizzaService() {
    }

    public SimplePizzaService(PizzaRepository pizzaRepo) {
        this.pizzaRepo = pizzaRepo;
    }

    @Transactional
    @Override
    public Pizza save(Pizza pizza) {
        return pizzaRepo.save(pizza);
    }

    @Override
    public Pizza find(Long id) {
        return pizzaRepo.find(id);
    }

    @Override
    public List<Pizza> findAll() {
        return pizzaRepo.findAll();
    }

    @Override
    public String uploadFile(MultipartFile file) {
        Assert.notNull(file, "File should not be null");
        try {
            InputStream inputStream = new ByteArrayInputStream(file.getBytes());
            List<PizzaDto> pizzaDtos = priceListParser.parse(inputStream);

            pizzaDtos.stream().map(PizzaDtoConverter::toPizzaEntity).forEach(this::save);
        }
        catch (IOException ex) {
            throw new RuntimeException(String.format(FAIL_TO_UPLOAD_FILE, file.getOriginalFilename()), ex);
        }
        return String.format(FILE_UPLOADED_SUCCESSFULLY, file.getOriginalFilename());
    }

    @Override
    public void remove(Pizza pizza) {
        Assert.notNull(pizza, "Pizza should not be null");
        pizzaRepo.remove(pizza);
    }

    @Override
    public List<Pizza> findByType(PizzaType type) {
        return pizzaRepo.findByType(type);
    }

    public static Pizza getVegetarianPizza() {
        return new Pizza(null, "Vege", 123., PizzaType.VEGETERIAN);
    }

    public final Pizza finalMethod() {
        return new Pizza();
    }

    public Pizza methodWithConstructor(Long id) {
        PizzaRepository repo = new JPAPizzaRepo();
        return repo.find(id);
    }

    public Pizza privateMethodCaller() {
        return privateGetPizza(1L);
    }

    private Pizza privateGetPizza(Long id) {
        final Pizza pizza = new Pizza();
        pizza.setPizzaId(1L);
        return pizza;
    }
}
