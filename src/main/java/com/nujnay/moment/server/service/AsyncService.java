package com.nujnay.moment.server.service;

public interface AsyncService {
    /**
     * 执行异步任务
     */
    void executeAsync(String mFileExcel,String fileCsv,String fileResult);
}
