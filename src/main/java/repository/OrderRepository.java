package repository;

import domain.Customer;
import domain.Orders;

import java.time.LocalDateTime;
import java.util.List;

public interface OrderRepository {
    Orders find(Long id);

    List<Orders> findByCustomer(Customer customer);

    Orders save(Orders newOrder);

    List<Orders> findByDateBetween(LocalDateTime fromDate, LocalDateTime toDate);

//    List<Order> getOrderList();
}
