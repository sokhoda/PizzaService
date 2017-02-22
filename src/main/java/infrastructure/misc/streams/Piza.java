package infrastructure.misc.streams;

import domain.PizzaType;
import lombok.Data;

@Data
public class Piza {
    private long pizzaId;
    private String name;
    private double price;

    private PizzaType type;

    public Piza(Long id, String name, Double price, PizzaType type) {
        this.pizzaId = id;
        this.name = name;
        this.price = price;
        this.type = type;
    }

    public Piza() {
    }

    public Piza(Long id, String name) {
        this.pizzaId = id;
        this.name = name;
    }

    @Override
    public String toString() {
        return "\nPizza{" +
                "pizzaId=" + pizzaId +
                ", name='" + name + '\'' +
                ", price=" + price +
                ", type=" + type +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Piza pizza = (Piza) o;

        if (name != null ? !name.equals(pizza.name) : pizza.name != null)
            return false;
        if (price != pizza.price)
            return false;
        return type == pizza.type;

    }

    @Override
    public int hashCode() {
        int result = name != null ? name.hashCode() : 0;
        result = 31 * result + ((int) price);
        result = 31 * result + (type != null ? type.hashCode() : 0);
        return result;
    }

}