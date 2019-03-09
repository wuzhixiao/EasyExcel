package com.nujnay.moment.server.util;

import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;

public class SaveFile {
    private static InputStream ins;
    private static File file;

    public static boolean saveFile(MultipartFile file, String path) {
        File dest = new File(path);
        try {
            file.transferTo(dest);
            return true;
        } catch (Exception e) {
            e.toString();
        }
        return false;
    }


    public static void inputStreamToFile(InputStream ins, File file) {
        SaveFile.ins = ins;
        SaveFile.file = file;
        try {
            OutputStream os = new FileOutputStream(file);
            int bytesRead = 0;
            byte[] buffer = new byte[8192];
            while ((bytesRead = ins.read(buffer, 0, 8192)) != -1) {
                os.write(buffer, 0, bytesRead);
            }
            os.close();
            ins.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
