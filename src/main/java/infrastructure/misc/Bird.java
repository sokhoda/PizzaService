package infrastructure.misc;

import lombok.Data;

public class Bird {
    public String color;

    public Bird() {
    }

    public Bird(String color) {
        this.color = color;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }
}
