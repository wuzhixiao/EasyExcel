package com.nujnay.moment.server.controller;


import org.springframework.web.multipart.MultipartFile;

public class ExcelVO {

    private MultipartFile filecsv;
    private MultipartFile filexcel;

    public MultipartFile getFilecsv() {
        return filecsv;
    }

    public void setFilecsv(MultipartFile filecsv) {
        this.filecsv = filecsv;
    }

    public MultipartFile getFilexcel() {
        return filexcel;
    }

    public void setFilexcel(MultipartFile filexcel) {
        this.filexcel = filexcel;
    }
}
