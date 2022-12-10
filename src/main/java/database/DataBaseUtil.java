package database;


import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.Test;

import java.io.*;
import java.sql.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.stream.Stream;

public class DataBaseUtil {

    @Test
    public void dataBaseToExcel() throws SQLException, IOException {
        String sqlQuery = "";
        Connection connection = DriverManager.getConnection("","","");
        Statement statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery(sqlQuery);

        XSSFWorkbook workbook = new XSSFWorkbook();
        XSSFSheet sheet = workbook.createSheet("DBdata");
        XSSFRow row = sheet.createRow(0);
        row.createCell(0).setCellValue("Header 1");
        row.createCell(1).setCellValue("Header 2");
        row.createCell(2).setCellValue("Header 3");
        row.createCell(3).setCellValue("Header 4");

        int r = 1;

        while(resultSet.next()){

            String value1 = resultSet.getString("Header 1");
            String value2 = resultSet.getString("Header 2");
            String value3 = resultSet.getString("Header 3");
            String value4 = resultSet.getString("Header 4");

            sheet.createRow(r++);
            row.createCell(0).setCellValue(value1);
            row.createCell(0).setCellValue(value2);
            row.createCell(0).setCellValue(value3);
            row.createCell(0).setCellValue(value4);

        }

        FileOutputStream fileOutputStream = new FileOutputStream("Path of xlsx file");
        workbook.write(fileOutputStream);
        workbook.close();
        fileOutputStream.close();
        connection.close();

    }

    @Test
    public void excelToDataBase() throws SQLException, IOException {
        Connection connection = DriverManager.getConnection("","","");
        Statement statement = connection.createStatement();
        statement.execute("SQL to create table");

        FileInputStream fileInputStream = new FileInputStream("Path of xlsx file");
        XSSFWorkbook workbook = new XSSFWorkbook(fileInputStream);
        XSSFSheet sheet = workbook.createSheet("excelToDataBase");

        for (int r = 1; r <=sheet.getLastRowNum() ; r++) {
            XSSFRow row = sheet.getRow(r);
            String value1 = row.getCell(0).getStringCellValue();
            String value2 = row.getCell(1).getStringCellValue();
            String value3 = row.getCell(2).getStringCellValue();
            String value4 = row.getCell(3).getStringCellValue();

            statement.execute("SQL query to insert values");
        }

        Stream<Integer> s = Stream.<Integer>builder().build();
    }

}
