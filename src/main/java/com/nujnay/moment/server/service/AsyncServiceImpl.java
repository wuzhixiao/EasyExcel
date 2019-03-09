package com.nujnay.moment.server.service;

import com.nujnay.moment.server.ExcelOperation;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

@Component
@Service
public class AsyncServiceImpl implements AsyncService {
    @Override
    @Async
    public void executeAsync(String mFileExcel,String fileCsv,String fileResult) {
//        try {
//            Thread.sleep(1000);

            ExcelOperation excelOperation = new ExcelOperation(mFileExcel, fileCsv, fileResult);
            excelOperation.exceldo();

//        } catch (Exception e) {
//            e.printStackTrace();
//
//        }
    }
}
