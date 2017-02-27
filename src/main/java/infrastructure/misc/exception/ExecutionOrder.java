package infrastructure.misc.exception;

import java.io.IOException;

public class ExecutionOrder {
     int method() throws IOException{
        int i = 1;
        try {
            System.out.println("try");
            if(i == 0) throw new Exception();
            return i;
        }catch (Exception e){
            System.out.println("catch");
            IOException ioException = new IOException();
            ioException.initCause(e);
            throw ioException;
        }finally {
            i = i + 100;
            System.out.println("finally " + i);
        }
//        System.out.println("method code");
//        return i;
    }

    public static void main(String[] args) throws Exception{

        System.out.println("i=" + new ExecutionOrder().method());
    }

}
