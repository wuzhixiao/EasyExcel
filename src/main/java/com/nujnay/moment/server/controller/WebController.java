package com.nujnay.moment.server.controller;

import com.nujnay.moment.server.base.BasicResult;
import com.nujnay.moment.server.service.AsyncService;
import com.nujnay.moment.server.service.DataServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletResponse;
import java.io.*;

@Controller
public class WebController {

    @GetMapping("/index")
    public String index(){
        System.out.println("ccccc");
        return "/home";
    }
}
