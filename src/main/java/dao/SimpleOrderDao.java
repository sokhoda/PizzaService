package dao;

import domain.Order;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class SimpleOrderDao implements OrderDao {
    CustomerDao customerDao = new SimpleCustomerDao();

    @Override
    public Order find(Long id) {
        return null;
    }

    @Override
    public Long save(Order order) {
        Long id = null;
        if (order == null) {
            return id;
        }
        EntityManagerFactory emf = Persistence.createEntityManagerFactory
                ("jpa");
        EntityManager em = emf.createEntityManager();
        EntityTransaction et = em.getTransaction();
        et.begin();
        if (order.getId() == null) {
            em.persist(order);
        }
        else {
            em.merge(order);
        }
        et.commit();

        em.close();
        emf.close();
        return order.getId();
    }
}