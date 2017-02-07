package infrastructure.misc;

public class Genericc<T> {

    private T age;
    private T height;

    public Genericc(T age, T height) {
        this.age = age;
        this.height = height;
    }

    public T caculate(T factor){
        return  age;
    }
}
