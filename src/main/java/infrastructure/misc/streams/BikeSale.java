package infrastructure.misc.streams;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class BikeSale implements Comparable {
    private int discount;
    private int internalNo;

    @Override
    public int compareTo(Object o) {
        return internalNo - ((BikeSale)o).getInternalNo();
    }

    @Override
    public String toString() {
        return "\nBikeSale{" +
                "discount=" + discount +
                ", internalNo=" + internalNo +
                '}';
    }
}
