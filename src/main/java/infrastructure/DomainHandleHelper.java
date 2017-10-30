package infrastructure;

import java.io.*;

public class DomainHandleHelper<T> {
    public static <T> T clone(T obj) {
        try {
            ByteArrayOutputStream bos = new ByteArrayOutputStream();
            ObjectOutputStream oos = new ObjectOutputStream(bos);
            oos.writeObject(obj);
            oos.flush();
            oos.close();
            bos.close();
            byte[] byteData = bos.toByteArray();

            ByteArrayInputStream bais = new ByteArrayInputStream(byteData);
            return (T) new ObjectInputStream(bais).readObject();
        }
        catch (IOException | ClassNotFoundException e) {
            throw (new RuntimeException(e));
        }

    }
}
