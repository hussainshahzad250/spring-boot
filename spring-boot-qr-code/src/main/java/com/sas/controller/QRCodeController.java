package com.sas.controller;

import com.sas.service.QRCodeService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.OutputStream;

@Slf4j
@Controller
public class QRCodeController {

    @Autowired
    private QRCodeService qrCodeService;

    @RequestMapping("/")
    public String index() {
        return "index";
    }

    @PostMapping("/showQRCode")
    public String showQRCode(String qrContent, Model model) {
        model.addAttribute("qrCodeContent", "/generateQRCode?qrContent=" + qrContent);
        return "show-qr-code";
    }

    @PostMapping("/generateQRCode")
    public void generateQRCode(@RequestParam String qrContent, HttpServletResponse response) throws IOException {
        response.setContentType("image/png");
        byte[] qrCode = qrCodeService.generateQRCode(qrContent, 500, 500);
        OutputStream outputStream = response.getOutputStream();
        outputStream.write(qrCode);
    }
}
