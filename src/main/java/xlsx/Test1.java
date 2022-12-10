package xlsx;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.Test;

import java.io.*;

public class Test1 {

    @Test
    public void xlsxReaderForLoop() throws IOException {
        String excelFile = ".\\src\\test\\resources\\2022.xlsx";
        FileInputStream inputStream = new FileInputStream(excelFile);

        XSSFWorkbook workbook = new XSSFWorkbook(inputStream);
        XSSFSheet sheet = workbook.getSheetAt(0);

        workbook.getSheetAt(0).getRow(0).getCell(0);
        BufferedWriter fw = new BufferedWriter(new FileWriter("2020.txt"));


        for (int i = 0; i < 8016; i++) {
            for (int j = 0; j < 60; j++) {
//                System.out.println(workbook.getSheetAt(1).getRow(j).getCell(i).getRawValue());
                fw.append(workbook.getSheetAt(1).getRow(j).getCell(i).getRawValue());
                fw.newLine();
            }

        }

        fw.flush();
        fw.close();
    }

}
