package infrastructure.misc;

public class MainMisc {
    public static void main(String[] args) {
        Vehicle vehicle = new Vehicle();

        Bike bike = new Bike();

        System.out.println("bike.equals(vehicle) = " + bike.equals(vehicle));

        System.out.println("vehicle.equals(bike) = " + vehicle.equals(bike));
    }
}
