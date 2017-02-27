package infrastructure;

import domain.Pizza;
import domain.PizzaType;
import org.springframework.transaction.TransactionDefinition;

import javax.persistence.*;
import javax.persistence.metamodel.EntityType;
import javax.persistence.metamodel.ManagedType;
import javax.persistence.metamodel.Metamodel;
import java.util.Collections;
import java.util.List;
import java.util.Set;

public class JPAAppRunner {
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory
                ("jpa");
//        System.out.println("metamodel" );
//        Set<EntityType<?>> mm = emf.getMetamodel().getEntities();
//        Set<ManagedType<?>> mt = emf.getMetamodel().getManagedTypes();
//
//        for (EntityType<?> entityType : mm) {
//            System.out.println(entityType.getName());
//        }
//
//        for (ManagedType<?> managedType : mt) {
//            System.out.println(managedType.getJavaType());
//        }

        EntityManager em = emf.createEntityManager();
        Pizza pizza = new Pizza(null, "Tomato", 90.1, PizzaType.VEGETERIAN);

        TypedQuery<Pizza> q = em.createQuery("Select p from Pizza p", Pizza.class);
        List<Pizza> list = q.getResultList();
        System.out.println(list);

        EntityTransaction et = em.getTransaction();
        et.begin();
        System.out.println("before persist " +  pizza.getPizzaId());
        System.out.println("contains before=" + em.contains(pizza));
        em.persist(pizza);
        Pizza pizza2 = em.getReference(Pizza.class, 2L);

//        em.merge(pizza);
//        pizza.setStrName("224324234");
        System.out.println(pizza2);
        System.out.println("after persist " +  pizza.getPizzaId());
        System.out.println("contains after=" + em.contains(pizza));
//        em.persist(oak);

        et.rollback();

        em.clear();

        et.begin();
        Pizza pizzaL = em.find(Pizza.class, 5L);
        pizzaL.setPrice(344.2);
        em.refresh(pizzaL);
        System.out.println("Pizza " + pizzaL );
        et.commit();

        Pizza pizza1 = em.find(Pizza.class, 5L);
        System.out.println(pizza == pizza1);

        em.close();
        emf.close();
    }
}
