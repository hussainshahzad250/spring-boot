package com.sas.service;

import org.springframework.web.multipart.MultipartFile;

import java.io.File;

public interface QRCodeService {

    byte[] generateQRCode(String qrContent, int width, int height);

    String readQRCode(MultipartFile file);

    String decodeQR(byte[] bytes);
}
