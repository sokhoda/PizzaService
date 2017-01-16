package infrastructure.misc;

public class Bike extends Vehicle {
    private String model;


    @Override
    public boolean equals(Object obj) {
        if (obj == null) return false;
        if (obj == this) return true;

        if (obj.getClass() != getClass()) return false;

        Bike other = (Bike) obj;

        if (model != null ? !model.equals(other.model) : other.model != null)
            return false;

        return true;
    }
}

