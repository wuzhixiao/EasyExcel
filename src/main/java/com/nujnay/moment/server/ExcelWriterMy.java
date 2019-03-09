package com.nujnay.moment.server;

import com.alibaba.excel.ExcelWriter;
import com.alibaba.excel.metadata.BaseRowModel;
import com.alibaba.excel.metadata.Sheet;
import com.alibaba.excel.support.ExcelTypeEnum;

import java.io.IOException;
import java.io.OutputStream;
import java.util.List;

public class ExcelWriterMy extends ExcelWriter {
    private OutputStream outputStream;
    private int sheetNo = 1;

    public ExcelWriterMy(OutputStream outputStream, ExcelTypeEnum typeEnum) {
        super(outputStream, typeEnum);
        this.outputStream = outputStream;
    }

    public ExcelWriterMy write(List<? extends BaseRowModel> list, String sheetName,
                               Class<? extends BaseRowModel> clazz) {
        this.sheetNo++;
        try {
            Sheet sheet = new Sheet(sheetNo, 0, clazz);
            sheet.setSheetName(sheetName);
            this.write(list, sheet);
        } catch (Exception ex) {
            ex.printStackTrace();
            try {
                outputStream.flush();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return this;
    }

    @Override
    public void finish() {
        super.finish();
        try {
            outputStream.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
