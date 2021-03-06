package domain;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import javax.persistence.*;
import java.io.Serializable;

/**
 * Created by s_okhoda on 10.10.2016.
 */
@Component
@Scope("prototype")
@Entity
public class LoyaltyCard implements Serializable{
    @Id
    @TableGenerator(
            name = "LOYALTYCARDGen",
            table = "ID_GEN",
            pkColumnName = "GEN_KEY",
            pkColumnValue = "LCARD_ID",
            valueColumnName = "GEN_VALUE",
            initialValue = 0,
            allocationSize = 1)
    @GeneratedValue(strategy= GenerationType.TABLE, generator =
            "LOYALTYCARDGen")
    private Long id;

    @OneToOne(mappedBy = "loyaltyCard")
    private Customer customer;

    private Double sum;

    public LoyaltyCard() {
    }

    public LoyaltyCard(Double sum) {
        this.sum = sum;
    }

    @Override
    public String toString() {
        return "LoyaltyCard{" +
                "id=" + id +
                ", customer={name=" + (customer == null ? "" : customer.getName()) +
                ", address=" + (customer == null ? "" : customer.getAddress()) +
                "}, sum=" + sum +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        LoyaltyCard that = (LoyaltyCard) o;

        return sum != null ? sum.equals(that.sum) : that.sum == null;
    }

    @Override
    public int hashCode() {
        return sum != null ? sum.hashCode() : 0;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Double getSum() {
        return sum;
    }

    public void setSum(Double sum) {
        this.sum = sum;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }
}
