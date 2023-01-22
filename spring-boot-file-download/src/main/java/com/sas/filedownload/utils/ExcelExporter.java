package com.sas.filedownload.utils;

import com.sas.filedownload.response.EmployeeResponse;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.stereotype.Component;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.List;

@Component
public class ExcelExporter {

    public ByteArrayInputStream contactListToExcelFile(List<EmployeeResponse> employeeResponses) {
        try (Workbook workbook = new XSSFWorkbook()) {
            ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
            Sheet sheet = workbook.createSheet("Employee Details");
            Row row = sheet.createRow(0);
            CellStyle headerCellStyle = workbook.createCellStyle();
            headerCellStyle.setFillForegroundColor(IndexedColors.AQUA.getIndex());
            headerCellStyle.setFillPattern(FillPatternType.SOLID_FOREGROUND);

            // populate header
            Cell cell = row.createCell(0);
            cell.setCellValue("Emp Id");
            cell.setCellStyle(headerCellStyle);

            cell = row.createCell(1);
            cell.setCellValue("First Name");
            cell.setCellStyle(headerCellStyle);

            cell = row.createCell(2);
            cell.setCellValue("Last Name");
            cell.setCellStyle(headerCellStyle);

            cell = row.createCell(3);
            cell.setCellValue("Email");
            cell.setCellStyle(headerCellStyle);

            cell = row.createCell(4);
            cell.setCellValue("Mobile");
            cell.setCellStyle(headerCellStyle);

            // populate employee data
            for (int i = 0; i < employeeResponses.size(); i++) {
                Row dataRow = sheet.createRow(i + 1);
                dataRow.createCell(0).setCellValue(employeeResponses.get(i).getEmployeeId());
                dataRow.createCell(1).setCellValue(employeeResponses.get(i).getFirstName());
                dataRow.createCell(2).setCellValue(employeeResponses.get(i).getLastName());
                dataRow.createCell(3).setCellValue(employeeResponses.get(i).getEmail());
                dataRow.createCell(4).setCellValue(employeeResponses.get(i).getMobile());
            }
            // auto resize column size to fit with data
            sheet.autoSizeColumn(0);
            sheet.autoSizeColumn(1);
            sheet.autoSizeColumn(2);
            sheet.autoSizeColumn(3);
            workbook.write(outputStream);
            return new ByteArrayInputStream(outputStream.toByteArray());
        } catch (IOException ex) {
            ex.printStackTrace();
            return null;
        }
    }
}