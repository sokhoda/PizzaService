package infrastructure.misc.InnerClass;

public class Anonym {
    private int count;

    public static void main(String[] args) {
       new Thread(new Runnable(){

            @Override
            public void run() {
                System.out.println("Hi! " + new Anonym().count);
            }
        }).start();
    }
}
