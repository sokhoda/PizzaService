package pizzaservice;

import domain.Address;
import domain.Customer;
import domain.LoyaltyCard;
import dto.CustomerDto;
import dto.PizzaDto;
import dto.converters.CustomerDtoConverter;
import dto.converters.PizzaDtoConverter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.Assert;
import org.springframework.web.multipart.MultipartFile;
import repository.CustomerRepository;
import utils.parsers.CustomParser;

import javax.inject.Inject;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

@Service("customerService")
public class SimpleCustomerService implements CustomerService {
    @Inject
    CustomParser<CustomerDto> customerListParser;

    @Autowired
    @Qualifier("customerRepository")
    private CustomerRepository customerRepo;

    public SimpleCustomerService(CustomerRepository customerRepo) {
        this.customerRepo = customerRepo;
    }

    public SimpleCustomerService() {
    }

    @Override
    public List<Customer> findAll() {
        return customerRepo.findAll();
    }

    @Transactional
    @Override
    public Customer save(Customer customer) {
        return customerRepo.save(customer);
    }

    @Override
    public String uploadFile(MultipartFile file) {
        Assert.notNull(file, "File should not be null");
        try {
            InputStream inputStream = new ByteArrayInputStream(file.getBytes());
            List<CustomerDto> customerDtos = customerListParser.parse(inputStream);

            customerDtos.stream().map(CustomerDtoConverter::toCustomerEntity).forEach(this::save);
        }
        catch (IOException ex) {
            throw new RuntimeException(String.format(CustomParser.FAIL_TO_UPLOAD_FILE, file.getOriginalFilename()), ex);
        }
        return String.format(CustomParser.FILE_UPLOADED_SUCCESSFULLY, file.getOriginalFilename());
    }

    @Override
    public Customer find(Long id) {
        return customerRepo.find(id);
    }

    @Override
    public List<Customer> findByName(String name) {
        return customerRepo.findByName(name);
    }

    @Override
    public List<Customer> findByLoyaltyCard(LoyaltyCard loyaltyCard) {
        return customerRepo.findByLoyaltyCard(loyaltyCard);
    }

    @Override
    public int delete(Customer customer){
        return customerRepo.delete(customer);
    }

    @Transactional
    @Override
    public Customer placeNewCustomer(String name, Address address, LoyaltyCard loyaltyCard) {
        Customer customer = createNewCustomer();
        customer.setName(name);
        customer.setAddress(address);
        customer.setLoyaltyCard(loyaltyCard);
        return save(customer);
    }

    @Override
    public void remove(Customer customer) {
        Assert.notNull(customer, "Customer should not be null");
        customerRepo.remove(customer);
    }

    Customer createNewCustomer() {
        throw new IllegalStateException("Customer createNewCustomer method " +
                "not overridden");
    }

    public void setCustomerRepository(CustomerRepository customerRepo) {
        this.customerRepo = customerRepo;
    }
}
