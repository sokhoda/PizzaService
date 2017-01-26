package infrastructure.misc;

public class Bird implements Cloneable, Comparable{
    public String color;

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
    public int compareTo(Object o) {
        return this.getColor().compareTo(((Bird)o).getColor());
    }

    @Override
    public String toString() {
        return "Bird{" +
                "color='" + color + '\'' +
                '}';
    }
}
