package com.sas.filedownload.controller;

import com.sas.filedownload.response.EmployeeResponse;
import com.sas.filedownload.service.EmployeeService;
import com.sas.filedownload.utils.CsvUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@Controller
public class CSVDownloadController {

    @Autowired
    private EmployeeService employeeService;

    @GetMapping("/download/employee.csv")
    public void downloadCsv(HttpServletResponse response) throws IOException {
        List<EmployeeResponse> employeeResponses = employeeService.fetchEmployee();
        response.setContentType("text/csv");
        response.setHeader("Content-Disposition", "attachment; file=employee.csv");
        CsvUtils.downloadCsv(response.getWriter(), employeeResponses);
    }
}
