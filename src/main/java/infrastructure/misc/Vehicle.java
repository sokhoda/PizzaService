package infrastructure.misc;

public class Vehicle {
    protected int number;


    public Vehicle() {
    }

    public Vehicle(int number) {
        this.number = number;
    }

    @Override
    public boolean equals (Object obj){
        if (obj == null) return false;
        if (this == obj) return true;

        if (!(obj instanceof Vehicle)) return false;
        Vehicle other = (Vehicle) obj;

        return other.number == number;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }
}
