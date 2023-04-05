package whatsapp;

import org.python.antlr.ast.Str;
import org.sikuli.script.FindFailed;
import org.sikuli.script.Pattern;
import org.sikuli.script.Screen;
import org.testng.annotations.Test;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.io.*;

public class SendImages {

    //        https://web.whatsapp.com/send?phone=+919866840603

    @Test
    public void sendImagesInWhatsapp() throws FindFailed, InterruptedException, IOException, AWTException {

        File file = new File("C:\\Users\\govreddy\\IdeaProjects\\JAVA\\src\\test\\resources\\phoneNumbers\\UniqueACABC.txt");



        BufferedReader br = new BufferedReader(new FileReader(file));


        BufferedWriter unique = new BufferedWriter(new FileWriter("C:\\Users\\govreddy\\IdeaProjects\\JAVA\\src\\test\\resources\\phoneNumbers\\unique.txt"));


//        BufferedWriter whatsAppFailed = new BufferedWriter(new FileWriter("C:\\Users\\govreddy\\IdeaProjects\\JAVA\\src\\test\\resources\\phoneNumbers\\WhatsAppFailed.txt"));
//        BufferedWriter whatsAppPass = new BufferedWriter(new FileWriter("C:\\Users\\govreddy\\IdeaProjects\\JAVA\\src\\test\\resources\\phoneNumbers\\WhatsAppPass.txt"));

//        Screen screen = new Screen();

//        Pattern BrowserURLPath = new Pattern("C:\\Users\\govreddy\\IdeaProjects\\JAVA\\src\\test\\resources\\pics\\BrowserURLPath.png");
//        Pattern attachmentsIcon = new Pattern("C:\\Users\\govreddy\\IdeaProjects\\JAVA\\src\\test\\resources\\pics\\attachmentsIcon.png");
//        Pattern imagesIcon = new Pattern("C:\\Users\\govreddy\\IdeaProjects\\JAVA\\src\\test\\resources\\pics\\imagesIcon.png");
//        Pattern acabcF = new Pattern("C:\\Users\\govreddy\\IdeaProjects\\JAVA\\src\\test\\resources\\pics\\ACABC_F.png");
//        Pattern acabcB = new Pattern("C:\\Users\\govreddy\\IdeaProjects\\JAVA\\src\\test\\resources\\pics\\ACABC_B.png");

//        Robot robot = new Robot();



        String phoneNumber;
        String phoneNumber1;

        Thread.sleep(5000);

        while ((phoneNumber = br.readLine()) != null){

            File file1 = new File("C:\\Users\\govreddy\\IdeaProjects\\JAVA\\src\\test\\resources\\phoneNumbers\\ACABC.txt");
            BufferedReader br1 = new BufferedReader(new FileReader(file1));

            boolean exists = false;

            while ((phoneNumber1 = br1.readLine()) != null){

                if (phoneNumber.equals(phoneNumber1)) {
                    exists = true;
                    break;
                }

            }
            if (!exists){
                unique.append(phoneNumber);
                unique.newLine();
            }



//            try {

//                screen.type(BrowserURLPath, "https://web.whatsapp.com/send?phone=" + phoneNumber);
//                robot.keyPress(KeyEvent.VK_ENTER);
//                robot.keyRelease(KeyEvent.VK_ENTER);
//                Thread.sleep(2000);
//
//                screen.click(attachmentsIcon);
//                Thread.sleep(2000);
//
//                screen.click(imagesIcon);
//                Thread.sleep(2000);
//
//                screen.doubleClick(acabcF);
//                Thread.sleep(2000);
//                robot.keyPress(KeyEvent.VK_ENTER);
//                robot.keyRelease(KeyEvent.VK_ENTER);
//                Thread.sleep(2000);
//
//                screen.click(attachmentsIcon);
//                Thread.sleep(2000);
//
//                screen.click(imagesIcon);
//                Thread.sleep(2000);
//
//                screen.doubleClick(acabcB);
//                Thread.sleep(2000);
//                robot.keyPress(KeyEvent.VK_ENTER);
//                robot.keyRelease(KeyEvent.VK_ENTER);
//                Thread.sleep(2000);

//                whatsAppPass.append(phoneNumber);
//                whatsAppPass.newLine();

//            } catch (Exception e){
//                whatsAppFailed.append(phoneNumber);
//                whatsAppFailed.newLine();
//            }


        }

//        whatsAppFailed.flush();
//        whatsAppFailed.close();

//        whatsAppPass.flush();
//        whatsAppPass.close();

        unique.flush();
        unique.close();

    }
}
