package pizzaservice;

import domain.Address;
import domain.Customer;
import domain.LoyaltyCard;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.support.SessionStatus;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

public interface CustomerService {
    List<Customer> findAll();

    Customer save(Customer customer);

    Customer find(Long id);

    List<Customer> findByName(String name);

    List<Customer> findByLoyaltyCard(LoyaltyCard loyaltyCard);

    int delete(Customer customer);

    Customer placeNewCustomer(String name, Address address, LoyaltyCard
            loyaltyCard);

    void remove(Customer customer);

    String uploadFile(MultipartFile file);

    String addNewCustomer(Customer customer, BindingResult bindingResult, SessionStatus sessionStatus);
}
