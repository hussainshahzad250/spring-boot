package com.sas.filedownload.controller;

import com.sas.filedownload.response.EmployeeResponse;
import com.sas.filedownload.service.EmployeeService;
import com.sas.filedownload.utils.JsonExporter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@Controller
public class JsonDownloadController {

    @Autowired
    private JsonExporter jsonExporter;

    @Autowired
    private EmployeeService employeeService;

    @GetMapping("/download/employee.json")
    public ResponseEntity<byte[]> downloadCsv(HttpServletResponse response) throws IOException {
        List<EmployeeResponse> employeeResponses = employeeService.fetchEmployee();
        String customerJsonString = jsonExporter.export(employeeResponses);
        byte[] customerJsonBytes = customerJsonString.getBytes();
        return ResponseEntity
                .ok()
                .header(HttpHeaders.CONTENT_DISPOSITION, "attachment;filename=employee.json")
                .contentType(MediaType.APPLICATION_JSON)
                .contentLength(customerJsonBytes.length)
                .body(customerJsonBytes);
    }
}
