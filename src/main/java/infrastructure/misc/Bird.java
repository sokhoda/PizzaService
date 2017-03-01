package infrastructure.misc;

public class Bird implements Cloneable, Comparable<Bird>{
    public String color;

    public  static String sing(){
        return "fa";
    }
    public Bird() {
    }

    public Bird(String color) {
        this.color = color;
    }

    protected void fly(){
        System.out.println(getClass().getCanonicalName() + " flies.");
    };

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    @Override
    public Bird clone() throws CloneNotSupportedException {
        return (Bird)super.clone();
    }

    @Override
    public int compareTo(Bird o) {
        return this.getColor().compareTo(o.getColor());
    }

    @Override
    public String toString() {
        return "Bird{" +
                "color='" + color + '\'' +
                '}';
    }
}
