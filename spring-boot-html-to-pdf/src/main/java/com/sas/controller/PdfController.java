package com.sas.controller;

import com.sas.service.PdfService;
import org.apache.commons.io.IOUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import javax.servlet.http.HttpServletResponse;
import java.io.ByteArrayInputStream;
import java.io.IOException;

@Controller
public class PdfController {

    @Autowired
    private PdfService pdfService;

    @GetMapping("/")
    public String index() {
        return "index";
    }

    @PostMapping("/generatePdfFile")
    public void generatePdfFile(HttpServletResponse response, String htmlContent) throws IOException {
        ByteArrayInputStream byteArrayInputStream = pdfService.convertHtmlToPdf(htmlContent);
        response.setContentType("application/octet-stream");
        response.setHeader("Content-Disposition", "attachment; filename=sample_file.pdf");
        IOUtils.copy(byteArrayInputStream, response.getOutputStream());
    }
}
