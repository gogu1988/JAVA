package xlsx;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.Test;


import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class XlsxFileUtil {

    @Test
    public void xlsxReaderForLoop() throws IOException {
        String excelFile = ".\\src\\test\\resources\\test.xlsx";
        FileInputStream inputStream = new FileInputStream(excelFile);

        XSSFWorkbook workbook = new XSSFWorkbook(inputStream);
        XSSFSheet sheet = workbook.getSheetAt(0);

        int rows = sheet.getLastRowNum();
        int cols = sheet.getRow(1).getLastCellNum();

        for (int r = 0; r <= rows; r++) {
            XSSFRow row = sheet.getRow(r);
            for (int c = 0; c < cols; c++) {
                XSSFCell cell = row.getCell(c);
                switch (cell.getCellType()) {
                    case STRING:
                        System.out.print(cell.getStringCellValue());
                        break;
                    case NUMERIC:
                        System.out.print(cell.getNumericCellValue());
                        break;
                    case BOOLEAN:
                        System.out.print(cell.getBooleanCellValue());
                        break;
                }
            }
            System.out.println();
        }
    }

    @Test
    public void xlsxReaderIterator() throws IOException {

        String excelFile = ".\\src\\test\\resources\\test.xlsx";
        FileInputStream inputStream = new FileInputStream(excelFile);

        XSSFWorkbook workbook = new XSSFWorkbook(inputStream);
        XSSFSheet sheet = workbook.getSheetAt(0);

        Iterator rows = sheet.iterator();

        while (rows.hasNext()) {
            XSSFRow row = (XSSFRow) rows.next();
            Iterator cells = row.cellIterator();
            while (cells.hasNext()) {
                XSSFCell cell = (XSSFCell) cells.next();
                switch (cell.getCellType()) {
                    case STRING:
                        System.out.print(cell.getStringCellValue());
                        break;
                    case NUMERIC:
                        System.out.print(cell.getNumericCellValue());
                        break;
                    case BOOLEAN:
                        System.out.print(cell.getBooleanCellValue());
                        break;
                }
            }
            System.out.println();
        }
    }

    @Test
    public void writingXlsxForLoop() throws IOException {

        XSSFWorkbook workbook = new XSSFWorkbook();
        XSSFSheet sheet = workbook.createSheet("Emp Info");
        Object empdata[][] = {{"EmpID", "Name", "Place"},
                {"01", "gogu", "hello"},
                {"02", "sasi", "blg"},
                {"03", "visu", "hyd"}
        };

        int rows = empdata.length;
        int cols = empdata[0].length;

        for (int r = 0; r < rows; r++) {
            XSSFRow row = sheet.createRow(r);
            for (int c = 0; c < cols; c++) {
                XSSFCell cell = row.createCell(c);
                Object value = empdata[r][c];

                if (value instanceof String)
                    cell.setCellValue((String) value);
                if (value instanceof Integer)
                    cell.setCellValue((Integer) value);
                if (value instanceof Boolean)
                    cell.setCellValue((Boolean) value);
            }
        }
        String file = ".\\src\\test\\resources\\test.xlsx";
        FileOutputStream fileOutputStream = new FileOutputStream(file);
        workbook.write(fileOutputStream);
        fileOutputStream.close();
    }

    @Test
    public void writingXlsxForEachLoop() throws IOException {

        XSSFWorkbook workbook = new XSSFWorkbook();
        XSSFSheet sheet = workbook.createSheet("Emp Info");
        Object empdata[][] = {{"EmpID", "Name", "Place"},
                {01, "gogu", "hello"},
                {02, "sasi", "blg"},
                {03, "visu", "hyd"}
        };

        int rows = 0;

        for (Object emp[] : empdata) {
            XSSFRow row = sheet.createRow(rows++);
            int cols = 0;
            for (Object value : emp) {
                XSSFCell cell = row.createCell(cols++);
                if (value instanceof String)
                    cell.setCellValue((String) value);
                if (value instanceof Integer)
                    cell.setCellValue((Integer) value);
                if (value instanceof Boolean)
                    cell.setCellValue((Boolean) value);

            }
        }
        String file = ".\\src\\test\\resources\\test.xlsx";
        FileOutputStream fileOutputStream = new FileOutputStream(file);
        workbook.write(fileOutputStream);
        fileOutputStream.close();
    }

    @Test
    public void writingXlsxArrayList() throws IOException {

        XSSFWorkbook workbook = new XSSFWorkbook();
        XSSFSheet sheet = workbook.createSheet("Emp Info");
        ArrayList<Object[]> empdata = new ArrayList<Object[]>();
        empdata.add(new Object[]{"EmpID", "Name", "Place"});
        empdata.add(new Object[]{01, "gogu", "hello"});
        empdata.add(new Object[]{02, "sasi", "blg"});
        empdata.add(new Object[]{03, "visu", "hyd"});

        int rows = 0;

        for (Object[] emp : empdata) {
            XSSFRow row = sheet.createRow(rows++);
            int cols = 0;
            for (Object value : emp) {
                XSSFCell cell = row.createCell(cols++);
                if (value instanceof String)
                    cell.setCellValue((String) value);
                if (value instanceof Integer)
                    cell.setCellValue((Integer) value);
                if (value instanceof Boolean)
                    cell.setCellValue((Boolean) value);

            }
        }
        String file = ".\\src\\test\\resources\\test.xlsx";
        FileOutputStream fileOutputStream = new FileOutputStream(file);
        workbook.write(fileOutputStream);
        fileOutputStream.close();
    }

    @Test
    public void hashMapToExcel() throws IOException {
        XSSFWorkbook workbook = new XSSFWorkbook();
        XSSFSheet sheet = workbook.createSheet("HashMap-Excel");

        HashMap<String, String> hashMap = new HashMap<>();
        hashMap.put("101","gogu");
        hashMap.put("102","sasi");
        hashMap.put("103","visu");

        int rows = 0;
        for (Map.Entry entry: hashMap.entrySet()) {
            XSSFRow row = sheet.createRow(rows++);
            row.createCell(0).setCellValue((String)entry.getKey());
            row.createCell(1).setCellValue((String)entry.getValue());
        }
        String file = ".\\src\\test\\resources\\test.xlsx";
        FileOutputStream fileOutputStream = new FileOutputStream(file);
        workbook.write(fileOutputStream);
        fileOutputStream.close();
    }

    @Test
    public void excelToHashMap() throws IOException {
        String file = ".\\src\\test\\resources\\test.xlsx";
        FileInputStream fileInputStream = new FileInputStream(file);
        XSSFWorkbook workbook = new XSSFWorkbook(fileInputStream);
        XSSFSheet sheet = workbook.getSheetAt(0);

        HashMap<String, String> hashMap = new HashMap<String, String>();

        Iterator rows = sheet.iterator();

        while(rows.hasNext()){
            XSSFRow row = (XSSFRow) rows.next();
            Iterator cols = row.iterator();
            while(cols.hasNext()){
                XSSFCell cell = (XSSFCell) cols.next();
                hashMap.put("","");
            }

        }
    }

}



