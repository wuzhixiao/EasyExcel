package com.nujnay.moment.server.controller;

import com.nujnay.moment.server.ExcelOperation;
import org.springframework.util.ClassUtils;
import org.springframework.util.ResourceUtils;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;

public class test {
    public static void main(String str[]) {
//        String path = ClassUtils.getDefaultClassLoader().getResource("").getPath();
//        try {
//            File path1 = new File(ResourceUtils.getURL("classpath:").getPath());
//            if (!path1.exists()) {
//                path1 = new File("");
//            }
//            path1.getAbsolutePath();
//        } catch (FileNotFoundException e) {
//            e.printStackTrace();
//        }
        String mFileExcel = "F:\\Excel\\loan-info.xlsm";
        String fileCsv = "F:\\Excel\\customer-info.csv";
        String fileResult = "F:\\Excel\\从星合loan-info表生成的数据分析表2222222.xlsx";
        ExcelOperation excelOperation = new ExcelOperation(mFileExcel, fileCsv, fileResult);
        excelOperation.exceldo();

    }

}
