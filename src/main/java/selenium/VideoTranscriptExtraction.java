package selenium;

import com.mysql.cj.xdevapi.DocResultImpl;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import java.io.*;
import java.time.Duration;
import java.util.ArrayList;
import java.util.Properties;

public class VideoTranscriptExtraction {

    @Test
    public void transcriptExtraction() throws IOException, InterruptedException {
        Properties p = new Properties();
        FileInputStream file = new FileInputStream("C:\\Users\\govreddy\\IdeaProjects\\JAVA\\src\\test\\resources\\URLs_1.properties");
        p.load(file);
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(60));
        driver.get("http://outsystems.com/training/lesson/2311/why-is-architecture-important?LearningPathId=8");
        System.out.println("Now login");
        for (int i = 1; i <= 16; i++) {
            System.out.println(p.get(String.valueOf(i)));
            driver.navigate().to((String) p.get(String.valueOf(i)));
            Thread.sleep(5000);
            BufferedWriter fw = new BufferedWriter(new FileWriter(i+".txt"));
            ArrayList<WebElement> transElements = (ArrayList<WebElement>) driver.findElements(By.xpath("//div[@class='transcript-text OSInline']"));
            for (WebElement transElement : transElements) {
                fw.append(transElement.getAttribute("innerHTML"));
                fw.append(" ");
//                fw.newLine();
            }
            fw.flush();
            fw.close();
        }
    }
}
