package com.nujnay.moment.server.service;


import com.nujnay.moment.server.base.BasicResult;
import com.nujnay.moment.server.controller.ExcelController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationHome;
import org.springframework.stereotype.Service;
import org.springframework.util.ResourceUtils;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;

@Service
public class DataServiceImpl {
    String fileResult = "";

    @Autowired
    private AsyncService asyncService;

    public int upload(MultipartFile file, MultipartFile filexcel) {
        if (file.isEmpty()) {
            return 1;
            //BasicResult.error(0, "上传失败，请选择文件");
        }
        if (filexcel.isEmpty()) {
            return 1;
            //BasicResult.error(0, "上传失败，请选择文件");
        }
        String fileName = file.getOriginalFilename();
        String filexcelName = filexcel.getOriginalFilename();
        try {
            ApplicationHome home = new ApplicationHome(getClass());
            File jarFile = home.getSource();
            File filePath = new File(jarFile.getParentFile().toString());
            if (!filePath.exists()) {
                filePath = new File("");
            }
            filePath.getAbsolutePath();
            File dest = new File(filePath + "\\" + fileName);
            File destexcel = new File(filePath + "\\" + filexcelName);
            file.transferTo(dest);
            filexcel.transferTo(destexcel);

            String fileExcel = filePath + "\\" + filexcelName;
            String fileCsv = filePath + "\\" + fileName;
            fileResult = filePath + "\\从星合loan-info表生成的数据分析表.xlsx";
            asyncService.executeAsync(fileExcel, fileCsv, fileResult);
            return 0;
            //BasicResult.ok(1, "上传成功");
        } catch (IOException e) {
            e.toString();
            return 2;
            //BasicResult.error(0, "上传失败" + e.getMessage());
        }
    }


}
