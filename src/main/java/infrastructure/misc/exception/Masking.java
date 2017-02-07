package infrastructure.misc.exception;

import infrastructure.misc.Bird;

import java.io.*;

public class Masking {
    private final Bird bird;

    public Masking(Bird bird) {
        this.bird = bird;
    }

    public void custom(OutputStream os, ObjectOutputStream oos) throws
            IOException{
        Bird clon = null;

        try {
            clon.getColor();
            oos.writeObject(clon);
        }
        finally {
            oos.close();
        }


    }
}
