package ssc;

//import io.github.bonigarcia.wdm.WebDriverManager;

import com.opencsv.CSVWriter;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

public class SSC_HallTicket_1 {

    @Test
    public void getHallTicket_1() throws IOException {

        String districtName = "23-ANNAMAYA";
        String schoolName = "23102-Z P HIGH SCHOOL MUDIVEDU";

        File file = new File("C:\\Users\\govreddy\\IdeaProjects\\JAVA\\src\\test\\resources\\CSV\\" + schoolName + ".CSV");
        FileWriter outputFile = new FileWriter(file);
        CSVWriter writer = new CSVWriter(outputFile);
        String[] header = {"HallTicket", "StudentName", "FatherName", "SchoolName"};
        writer.writeNext(header);

        for (int i = 2; i <= 84; i++) {

            try {

                WebDriver driver = new ChromeDriver();
                driver.manage().window().maximize();
                driver.get("https://bse.ap.gov.in/APSSCHTTHREE/RegDefault.aspx");

                Select drpCountry = new Select(driver.findElement(By.name("drpDistrict")));
                drpCountry.selectByVisibleText(districtName);

                Select drpSchools = new Select(driver.findElement(By.name("drpSchools")));
                drpSchools.selectByVisibleText(schoolName);



                driver.findElement(By.xpath("//select[@id='drpName']/option["+i+"]")).click();

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


                    System.out.println();

                } catch (Exception e) {
                    System.out.println("Inner " + e);
                }

                driver.quit();
            } catch (Exception e) {
                System.out.println("Outer " + e);
            }

        }

        writer.close();

    }


}
