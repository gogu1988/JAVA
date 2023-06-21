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

public class SendText {

    //https://web.whatsapp.com/send?phone=+919866840603

    @Test
    public void sentTextMessage() throws FindFailed, InterruptedException, IOException, AWTException {

        Toolkit toolkit = Toolkit.getDefaultToolkit();
        Clipboard clipboard = toolkit.getSystemClipboard();

        File file = new File("C:\\Users\\govreddy\\IdeaProjects\\JAVA\\src\\test\\resources\\phoneNumbers\\2023Contacts.txt");

        BufferedReader br = new BufferedReader(new FileReader(file));

        Screen screen = new Screen();

        Pattern BrowserURLPath = new Pattern("C:\\Users\\govreddy\\IdeaProjects\\JAVA\\src\\test\\resources\\pics\\BrowserURLPath.png");
        Pattern typeMessage = new Pattern("C:\\Users\\govreddy\\IdeaProjects\\JAVA\\src\\test\\resources\\pics\\TypeMessage.png");
        Pattern imagesIcon = new Pattern("C:\\Users\\govreddy\\IdeaProjects\\JAVA\\src\\test\\resources\\pics\\imagesIcon.png");
        Pattern a1 = new Pattern("C:\\Users\\govreddy\\IdeaProjects\\JAVA\\src\\test\\resources\\pics\\01_Audio.png");

        Robot robot = new Robot();

        String phoneNumber;

        Thread.sleep(5000);



        while ((phoneNumber = br.readLine()) != null) {

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
                        Thread.sleep(8000);

                        screen.click(typeMessage);
                        Thread.sleep(2000);

                        StringSelection message = new StringSelection("AP 10th results 2023 on 05 May 2023 4:00 PM");
                        clipboard.setContents(message, null);

                        robot.keyPress(KeyEvent.VK_CONTROL);
                        robot.keyPress(KeyEvent.VK_V);
                        robot.keyRelease(KeyEvent.VK_V);
                        robot.keyRelease(KeyEvent.VK_CONTROL);

                        robot.keyPress(KeyEvent.VK_ENTER);
                        robot.keyRelease(KeyEvent.VK_ENTER);
                        Thread.sleep(2000);

                    } catch (Exception e) {

                    }

                }

            }

        }

