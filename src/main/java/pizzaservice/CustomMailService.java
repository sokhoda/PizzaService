package pizzaservice;

import java.io.File;

public interface CustomMailService {
    void sendMail(File file, String attachmentFilename);

    void sendMail(String attachmentUri, String attachmentFilename);
}
