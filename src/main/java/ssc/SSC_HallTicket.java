package ssc;

//import io.github.bonigarcia.wdm.WebDriverManager;

import com.opencsv.CSVWriter;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.time.Duration;
import java.util.List;

public class SSC_HallTicket {

    @Test
    public void getHallTicket() throws IOException {


        String districtName = "23-ANNAMAYA";
        String schoolName = "23102-Z P HIGH SCHOOL MUDIVEDU";

        File file = new File("C:\\Users\\govreddy\\IdeaProjects\\JAVA\\src\\test\\resources\\CSV\\" + schoolName + ".CSV");
        FileWriter outputFile = new FileWriter(file);
        CSVWriter writer = new CSVWriter(outputFile);

        String[] header = {"HallTicket", "StudentName", "FatherName", "SchoolName"};
        writer.writeNext(header);


        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
//        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(60));

        driver.get("https://bse.ap.gov.in/APSSCHTTHREE/RegDefault.aspx");
        Select drpCountry = new Select(driver.findElement(By.name("drpDistrict")));
        drpCountry.selectByVisibleText(districtName);

        Select drpSchools = new Select(driver.findElement(By.name("drpSchools")));
        drpSchools.selectByVisibleText(schoolName);


        Select names = new Select(driver.findElement(By.id("drpName")));
        List<WebElement> l = names.getOptions();

        for (int i = 0; i<=l.size(); i++) {
            try {

                names.selectByIndex(i);

                Select dd = new Select(driver.findElement(By.name("dd")));
                dd.selectByVisibleText("01");

                Select mm = new Select(driver.findElement(By.name("mm")));
                mm.selectByVisibleText("01");

                Select yy = new Select(driver.findElement(By.name("yy")));
                yy.selectByVisibleText("2007");

                driver.findElement(By.name("btnDownload")).click();

                try {

                    String HallTicket = driver.findElement(By.id("lblRollNo")).getText();
                    System.out.print(HallTicket + ",");

                    String StudentName = driver.findElement(By.id("lblCName")).getText();
                    System.out.print(StudentName + ",");

                    String FatherName = driver.findElement(By.id("lblFName")).getText();
                    System.out.print(FatherName);

                    String SchoolName = driver.findElement(By.id("lblSchName")).getText();
                    System.out.print(SchoolName);

                    String[] studentDetails = {HallTicket, StudentName, FatherName, SchoolName};
                    writer.writeNext(studentDetails);
                    writer.close();

                    System.out.println();

                    driver.navigate().back();

                } catch (Exception e) {
                    System.out.println("Inner" + e);
                }


            } catch (Exception e) {
                System.out.println("Outer" + e);
            }

        }

        driver.quit();

    }
}
