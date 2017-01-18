package infrastructure.misc;

import lombok.Data;


public class Pigeon extends Bird{
    public String color;

    public Pigeon(String color) {
        super(color);
        this.color = color;
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
