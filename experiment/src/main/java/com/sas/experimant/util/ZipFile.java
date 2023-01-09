package com.sas.experimant.util;

import java.io.*;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

public class ZipFile {

    public static void createZip() {
        byte[] buffer = new byte[1024];
        try {
            FileOutputStream fos = new FileOutputStream("D:\\java-zip\\testing.zip");
            ZipOutputStream zos = new ZipOutputStream(fos);

            String path = "D:\\java-zip\\file\\";
            File file = new File(path);
            String[] list = file.list();
            for (int i = 0; i < list.length; i++) {
                ZipEntry ze = new ZipEntry(list[i]);
                zos.putNextEntry(ze);
                FileInputStream in = new FileInputStream(path + list[i]);
                int len;
                while ((len = in.read(buffer)) > 0) {
                    zos.write(buffer, 0, len);
                }
                in.close();
                zos.closeEntry();
            }
            zos.close();
            System.out.println("Done");

        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }
}
