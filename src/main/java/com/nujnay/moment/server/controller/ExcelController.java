package com.nujnay.moment.server.controller;

import com.nujnay.moment.server.base.BasicResult;
import com.nujnay.moment.server.service.AsyncService;
import com.nujnay.moment.server.service.DataServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.ResourceUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;

@RestController
public class ExcelController {
    private final DataServiceImpl dataService;
    public static String fileResult = "";
    @Autowired
    private AsyncService asyncService;

    @Autowired
    public ExcelController(DataServiceImpl dataService) {
        this.dataService = dataService;
    }

    @GetMapping("/getTodayContent")
    public BasicResult getTodayContent() {
        return BasicResult.ok(1, "上传成功");
    }

    @PostMapping("/upload")
    @ResponseBody
//    public BasicResult upload(@RequestParam("filecsv") MultipartFile filecsv,@RequestParam("filexcel")  MultipartFile filexcel) {
    public BasicResult upload(@RequestParam("filecsv") MultipartFile filecsv, @RequestParam("filexcel") MultipartFile filexcel) {
        int i = dataService.upload(filecsv, filexcel);
        if (i == 0) {
            return BasicResult.ok(1, "上传成功");
        } else {
            return BasicResult.error(0, "上传失败，请选择文件");
        }
    }


    @GetMapping("/download")
    public BasicResult downloadFile(HttpServletResponse response) {
//        String fileName = "dalaoyang.jpeg";// 文件名
        if (fileResult != null) {
            //设置文件路径
            File file = new File(fileResult);
            //File file = new File(realPath , fileName);
            if (file.exists()) {
                response.setContentType("application/force-download");// 设置强制下载不打开
                response.addHeader("Content-Disposition", "attachment;fileName=" + fileResult);// 设置文件名
                byte[] buffer = new byte[1024];
                FileInputStream fis = null;
                BufferedInputStream bis = null;
                try {
                    fis = new FileInputStream(file);
                    bis = new BufferedInputStream(fis);
                    OutputStream os = response.getOutputStream();
                    int i = bis.read(buffer);
                    while (i != -1) {
                        os.write(buffer, 0, i);
                        i = bis.read(buffer);
                    }
                    return BasicResult.ok(1, "下载成功");
                } catch (Exception e) {
                    e.printStackTrace();
                } finally {
                    if (bis != null) {
                        try {
                            bis.close();
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    }
                    if (fis != null) {
                        try {
                            fis.close();
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    }

                    if (file.exists()) {
                        file.delete();
                        fileResult = null;
                    }
                }
            }
        }
        return BasicResult.error(0, "下载失败");
    }
}
