package pizzaservice;

import org.apache.commons.io.FileUtils;
import org.springframework.core.io.FileSystemResource;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import javax.inject.Inject;
import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import java.io.File;
import java.io.IOException;
import java.net.URL;

@Service
public class CustomMailServiceImpl implements CustomMailService {
    @Inject
    private JavaMailSender javaMailSender;

    @Override
    public void sendMail(File file, String attachmentFilename) {
        doSendMail(file, attachmentFilename);
    }

    @Override
    public void sendMail(String attachmentUrl, String attachmentFilename) {
        File file = loadFileByURL(attachmentUrl, attachmentFilename);
        doSendMail(file, attachmentFilename);
    }

    private void doSendMail(File file, String attachmentFilename) {
        MimeMessage message = javaMailSender.createMimeMessage();
        try {
            MimeMessageHelper helper = new MimeMessageHelper(message, true);
            helper.setTo("receiver@gmail.com");
            helper.setSubject("Some mail from me! ))");
            helper.setText("Hi!");
            helper.addAttachment(attachmentFilename, file);
            javaMailSender.send(message);
        } catch (MessagingException e) {
            return;
        }
    }

    private File loadLocalFile(String pathToAttachment) {
        return new File(pathToAttachment);
    }

    private File loadFileByURL(String fileUrl, String filename) {
        File file = new File(filename);
        try {
            URL url = new URL(fileUrl);
            FileUtils.copyURLToFile(url, file);
            return file;
        } catch (IOException e) {
            return null;
        }
    }
}
