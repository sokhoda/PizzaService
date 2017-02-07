package infrastructure.misc;

import javafx.scene.paint.Stop;

public class STon {
    private static STon sTon = null;
    private int i;

    private STon(){
    }

    public int getI() {
        return i;
    }

    public void setI(int i) {
        this.i = i;
    }

    public static STon getInstance(int i){

        if(sTon == null){
            sTon = new STon();
            sTon.setI(i);
        }
        return sTon;
    }

    public static void main(String[] args) {
        STon sTon1 = STon.getInstance(10);
        STon sTon2 = STon.getInstance(11);

        System.out.println(sTon1);
        System.out.println(sTon2);
        System.out.println(sTon1.hashCode());
        System.out.println(sTon2.hashCode());

    }

}
