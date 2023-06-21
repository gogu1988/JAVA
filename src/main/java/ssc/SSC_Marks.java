package ssc;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import java.io.*;

public class SSC_Marks {

    @Test
    public void passFail() throws IOException {
        File file = new File("C:\\Users\\govreddy\\IdeaProjects\\JAVA\\src\\test\\resources\\HallTickets\\H1.txt");

        BufferedReader br = new BufferedReader(new FileReader(file));

        String hallTicket;

        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://results.bse.ap.gov.in");

        while ((hallTicket = br.readLine()) != null) {
            driver.findElement(By.id("txtHallTicketNo")).clear();
            driver.findElement(By.id("txtHallTicketNo")).sendKeys(hallTicket);
            driver.findElement(By.id("btnSubmit")).click();
            System.out.println(driver.findElement(By.id("lblResult")).getText());

        }
    }
}
