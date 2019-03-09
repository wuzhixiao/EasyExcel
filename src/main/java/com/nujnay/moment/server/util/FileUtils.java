package com.nujnay.moment.server.util;

import java.io.*;

public class FileUtils {
    public static void cutFile(File fileFrom, File fileTo, boolean isCut) {
        //创建文件流对象
        FileInputStream fis = null;
        FileOutputStream fos = null;


        try {
            fis = new FileInputStream(fileFrom);
            fos = new FileOutputStream(fileTo);
            //为读取文件做准备
            byte[] bs = new byte[50];//储存读取的数据
            int count = 0;//储存读取的数据量

            //边读取，边复制
            while ((count = fis.read(bs)) != -1) {
                fos.write(bs, 0, count);
                fos.flush();
            }

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (fis != null) {
                try {
                    fis.close();
                } catch (IOException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }
            }
            if (fos != null) {
                try {
                    fos.close();
                } catch (IOException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }
            }
        }

        if (isCut) {
            //删除文件
            fileFrom.delete();
        }

    }

    public static String getName(File file) {
        String fileName = file.getName();
        String prefix = fileName.substring(fileName.lastIndexOf(".") + 1);
        return prefix;
    }
}
