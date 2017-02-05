package infrastructure.misc;


public class Pigeon extends Bird {
    public String color;

    public  static String sing(){
        return "sol";
    }

    public Pigeon(String color) {
        super(color);
        this.color = color;
    }

    @Override
    protected void fly(){
        System.out.println(getClass().getSimpleName() + " - I can fly");
    }


    @Override
    public String getColor() {
        return color;
    }

    @Override
    public void setColor(String color) {
        this.color = color;
    }
}
