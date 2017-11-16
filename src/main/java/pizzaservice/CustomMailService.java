package pizzaservice;

import domain.Orders;

import java.io.File;

public interface CustomMailService {
    void sendMail(File file, String attachmentFilename, Orders order);

    void sendMail(String attachmentUri, String attachmentFilename, Orders order);
}