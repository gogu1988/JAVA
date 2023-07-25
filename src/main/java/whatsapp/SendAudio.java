package whatsapp;

import org.sikuli.script.FindFailed;
import org.sikuli.script.Pattern;
import org.sikuli.script.Screen;
import org.testng.annotations.Test;

import java.awt.*;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.io.*;
import java.util.Scanner;

public class SendAudio {

    //https://web.whatsapp.com/send?phone=+919866840603

    @Test
    public void sendAudioInWhatsapp() throws FindFailed, InterruptedException, IOException, AWTException {

        Toolkit toolkit = Toolkit.getDefaultToolkit();
        Clipboard clipboard = toolkit.getSystemClipboard();

        File file = new File("C:\\Users\\govreddy\\IdeaProjects\\JAVA\\src\\test\\resources\\phoneNumbers\\Polycet\\2023Contacts.txt");

        BufferedReader br = new BufferedReader(new FileReader(file));

        BufferedWriter whatsAppFailed = new BufferedWriter(new FileWriter("C:\\Users\\govreddy\\IdeaProjects\\JAVA\\src\\test\\resources\\phoneNumbers\\Polycet\\2023_FAIL.txt", true));
        BufferedWriter whatsAppPass = new BufferedWriter(new FileWriter("C:\\Users\\govreddy\\IdeaProjects\\JAVA\\src\\test\\resources\\phoneNumbers\\Polycet\\2023_PASS.txt", true));

        Screen screen = new Screen();

        Pattern BrowserURLPath = new Pattern("C:\\Users\\govreddy\\IdeaProjects\\JAVA\\src\\test\\resources\\pics\\BrowserURLPath.png");
        Pattern attachmentsIcon = new Pattern("C:\\Users\\govreddy\\IdeaProjects\\JAVA\\src\\test\\resources\\pics\\attachmentsIcon.png");
        Pattern imagesIcon = new Pattern("C:\\Users\\govreddy\\IdeaProjects\\JAVA\\src\\test\\resources\\pics\\imagesIcon.png");
        Pattern a1 = new Pattern("C:\\Users\\govreddy\\IdeaProjects\\JAVA\\src\\test\\resources\\pics\\02_Audio.png");
        Pattern typeMessage = new Pattern("C:\\Users\\govreddy\\IdeaProjects\\JAVA\\src\\test\\resources\\pics\\TypeMessage.png");

        Robot robot = new Robot();

        String phoneNumber;

        Thread.sleep(5000);



        while ((phoneNumber = br.readLine()) != null) {

            Scanner whatsAppPassScanner = new Scanner(new FileInputStream("C:\\Users\\govreddy\\IdeaProjects\\JAVA\\src\\test\\resources\\phoneNumbers\\2023_PASS.txt"));
            Scanner whatsAppFailScanner = new Scanner(new FileInputStream("C:\\Users\\govreddy\\IdeaProjects\\JAVA\\src\\test\\resources\\phoneNumbers\\2023_FAIL.txt"));


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

                        StringSelection url = new StringSelection("https://web.whatsapp.com/send?phone=" + phoneNumber);
                        clipboard.setContents(url, null);

                        screen.click(BrowserURLPath);
                        robot.keyPress(KeyEvent.VK_CONTROL);
                        robot.keyPress(KeyEvent.VK_V);
                        robot.keyRelease(KeyEvent.VK_V);
                        robot.keyRelease(KeyEvent.VK_CONTROL);
                        robot.keyPress(KeyEvent.VK_ENTER);
                        robot.keyRelease(KeyEvent.VK_ENTER);
                        Thread.sleep(12000);

                        screen.click(attachmentsIcon);
                        Thread.sleep(2000);

                        screen.click(imagesIcon);
                        Thread.sleep(2000);

                        screen.doubleClick(a1);
                        Thread.sleep(2000);
                        robot.keyPress(KeyEvent.VK_ENTER);
                        robot.keyRelease(KeyEvent.VK_ENTER);
                        Thread.sleep(2000);

                        screen.click(typeMessage);
                        Thread.sleep(2000);

                        StringSelection message = new StringSelection("9804090401\n9804090402\n9804090403\nLast Date 10 Jul");
//                        StringSelection message = new StringSelection("Last Date 10 Jul");
                        clipboard.setContents(message, null);

                        robot.keyPress(KeyEvent.VK_CONTROL);
                        robot.keyPress(KeyEvent.VK_V);
                        robot.keyRelease(KeyEvent.VK_V);
                        robot.keyRelease(KeyEvent.VK_CONTROL);

                        robot.keyPress(KeyEvent.VK_ENTER);
                        robot.keyRelease(KeyEvent.VK_ENTER);
                        Thread.sleep(2000);

                        screen.click(typeMessage);
                        Thread.sleep(2000);

                        StringSelection message_1 = new StringSelection("https://youtu.be/DMe_5Ijbg1s");
                        clipboard.setContents(message_1, null);

                        robot.keyPress(KeyEvent.VK_CONTROL);
                        robot.keyPress(KeyEvent.VK_V);
                        robot.keyRelease(KeyEvent.VK_V);
                        robot.keyRelease(KeyEvent.VK_CONTROL);

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
