package com.sas.filedownload.controller;

import com.sas.filedownload.response.EmployeeResponse;
import com.sas.filedownload.service.EmployeeService;
import com.sas.filedownload.utils.ExcelExporter;
import org.apache.poi.util.IOUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import javax.servlet.http.HttpServletResponse;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.util.List;

@Controller
public class ExcelDownloadController {

    @Autowired
    private ExcelExporter excelExporter;

    @Autowired
    private EmployeeService employeeService;

    @GetMapping("/download/employee.xlsx")
    public void downloadCsv(HttpServletResponse response) throws IOException {
        List<EmployeeResponse> employeeResponses = employeeService.fetchEmployee();
        ByteArrayInputStream stream = excelExporter.contactListToExcelFile(employeeResponses);
        response.setContentType("application/octet-stream");
        response.setHeader("Content-Disposition", "attachment; filename=employee.xlsx");
        IOUtils.copy(stream, response.getOutputStream());
    }
}
