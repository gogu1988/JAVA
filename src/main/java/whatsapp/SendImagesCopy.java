package whatsapp;

import org.sikuli.script.FindFailed;
import org.sikuli.script.Pattern;
import org.sikuli.script.Screen;
import org.testng.annotations.Test;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.io.*;
import java.util.Scanner;

public class SendImagesCopy {

    //https://web.whatsapp.com/send?phone=+919866840603

    @Test
    public void sendImagesInWhatsapp() throws FindFailed, InterruptedException, IOException, AWTException {

        File file = new File("C:\\Users\\govreddy\\IdeaProjects\\JAVA\\src\\test\\resources\\phoneNumbers\\unique.txt");

        BufferedReader br = new BufferedReader(new FileReader(file));

        BufferedWriter whatsAppFailed = new BufferedWriter(new FileWriter("C:\\Users\\govreddy\\IdeaProjects\\JAVA\\src\\test\\resources\\phoneNumbers\\WhatsAppFailed.txt", true));
        BufferedWriter whatsAppPass = new BufferedWriter(new FileWriter("C:\\Users\\govreddy\\IdeaProjects\\JAVA\\src\\test\\resources\\phoneNumbers\\WhatsAppPass.txt", true));

        Screen screen = new Screen();

        Pattern BrowserURLPath = new Pattern("C:\\Users\\govreddy\\IdeaProjects\\JAVA\\src\\test\\resources\\pics\\BrowserURLPath.png");
        Pattern attachmentsIcon = new Pattern("C:\\Users\\govreddy\\IdeaProjects\\JAVA\\src\\test\\resources\\pics\\attachmentsIcon.png");
        Pattern imagesIcon = new Pattern("C:\\Users\\govreddy\\IdeaProjects\\JAVA\\src\\test\\resources\\pics\\imagesIcon.png");
        Pattern acabcF = new Pattern("C:\\Users\\govreddy\\IdeaProjects\\JAVA\\src\\test\\resources\\pics\\ACABC_F.png");
        Pattern acabcB = new Pattern("C:\\Users\\govreddy\\IdeaProjects\\JAVA\\src\\test\\resources\\pics\\ACABC_B.png");

        Robot robot = new Robot();

        String phoneNumber;

        Thread.sleep(5000);


        while ((phoneNumber = br.readLine()) != null) {

            Scanner whatsAppPassScanner = new Scanner(new FileInputStream("C:\\Users\\govreddy\\IdeaProjects\\JAVA\\src\\test\\resources\\phoneNumbers\\WhatsAppPass.txt"));
            Scanner whatsAppFailScanner = new Scanner(new FileInputStream("C:\\Users\\govreddy\\IdeaProjects\\JAVA\\src\\test\\resources\\phoneNumbers\\WhatsAppFailed.txt"));


            if (!(phoneNumber.equals("") || phoneNumber.length() != 10)) {

                boolean presentInWhatsAppPass = false;
                while (whatsAppPassScanner.hasNextLine()) {
                    String whatsAppPassPhoneNumber = whatsAppPassScanner.nextLine();
                    if (phoneNumber.equals(whatsAppPassPhoneNumber)) {
                        presentInWhatsAppPass = true;
                        break;
                    }
                }

                boolean presentInWhatsAppFail = false;
                while (whatsAppFailScanner.hasNextLine()) {
                    String whatsAppFailPhoneNumber = whatsAppFailScanner.nextLine();
                    if (phoneNumber.equals(whatsAppFailPhoneNumber)) {
                        presentInWhatsAppFail = true;
                        break;
                    }
                }

                if (!(presentInWhatsAppPass || presentInWhatsAppFail)) {
                    System.out.println(phoneNumber);

                    try {

                        screen.type(BrowserURLPath, "https://web.whatsapp.com/send?phone=" + phoneNumber);
                        robot.keyPress(KeyEvent.VK_ENTER);
                        robot.keyRelease(KeyEvent.VK_ENTER);
                        Thread.sleep(8000);

                        screen.click(attachmentsIcon);
                        Thread.sleep(2000);

                        screen.click(imagesIcon);
                        Thread.sleep(2000);

                        screen.doubleClick(acabcF);
                        Thread.sleep(2000);
                        robot.keyPress(KeyEvent.VK_ENTER);
                        robot.keyRelease(KeyEvent.VK_ENTER);
                        Thread.sleep(2000);

                        screen.click(attachmentsIcon);
                        Thread.sleep(2000);

                        screen.click(imagesIcon);
                        Thread.sleep(2000);

                        screen.doubleClick(acabcB);
                        Thread.sleep(2000);
                        robot.keyPress(KeyEvent.VK_ENTER);
                        robot.keyRelease(KeyEvent.VK_ENTER);
                        Thread.sleep(2000);

                        whatsAppPass.append(phoneNumber);
                        whatsAppPass.newLine();
                        whatsAppPass.flush();

                    } catch (Exception e) {
                        whatsAppFailed.append(phoneNumber);
                        whatsAppFailed.newLine();
                        whatsAppFailed.flush();

                    }

                }

            }

        }

        whatsAppPass.close();
        whatsAppFailed.close();

    }
}
