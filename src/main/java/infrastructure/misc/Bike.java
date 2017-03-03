package infrastructure.misc;

public class Bike extends Vehicle implements Cloneable {
    private String model;

    public Bike(String model) {
        this.model = model;
    }

    public Bike(int number, String model) {
        super(number);
        this.model = model;
    }

    @Override
    public Bike clone(){
        Bike result = null;
        try {
            result = (Bike) super.clone();
        }
        catch (CloneNotSupportedException e) {
        }
        return result;
    }

    @Override
    public String toString() {
        return "Bike{" +
                "model='" + model + '\'' +
                "number='" + number + '\'' +
                '}';
    }

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

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }
}

