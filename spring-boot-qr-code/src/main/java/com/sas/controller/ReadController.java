package com.sas.controller;

import com.sas.service.QRCodeService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletResponse;

@Slf4j
@RestController
public class ReadController {

    @Autowired
    private QRCodeService qrCodeService;

    @PostMapping("/readQRCode")
    public String readQRCode(@RequestParam("file") MultipartFile file){
        String qrCodeContent = qrCodeService.readQRCode(file);
        log.info("Decoded QR Code Content: " + qrCodeContent);
        return qrCodeContent;
    }
}
