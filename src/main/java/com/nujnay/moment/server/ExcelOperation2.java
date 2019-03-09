//package com.nujnay.moment.server;
//
//import com.nujnay.moment.server.controller.ExcelController;
//import com.nujnay.moment.server.util.FileUtils;
//import de.siegmar.fastcsv.reader.CsvContainer;
//import de.siegmar.fastcsv.reader.CsvParser;
//import de.siegmar.fastcsv.reader.CsvReader;
//import de.siegmar.fastcsv.reader.CsvRow;
//import org.springframework.util.ResourceUtils;
//
//import java.io.*;
//import java.nio.charset.StandardCharsets;
//import java.text.SimpleDateFormat;
//import java.util.ArrayList;
//import java.util.Date;
//import java.util.List;
//
//public class ExcelOperation2 {
//    static List<LoanInfo> listLoanInfo = new ArrayList<>();
//    static List<ResultInfo> listResultInfo = new ArrayList<>();
//    static List<ResultInfoUser> listResultInfoUser = new ArrayList<>();
//    static List<ResultInfoNewUser> listResultInfoNewUser = new ArrayList<>();
//    static List<ResultInfoProduct> listResultInfoProduct = new ArrayList<>();
//
//    static String mFileExcel = "";
//    static String fileCsv = "";
//    static String fileResult = "";
//    static String fileMovetoStr = "";
//    static String resourcemove = "";
//    static String excelmove = "";
//    static String csvemove = "";
//    static File file;
//    static File fileloaninfo;
//    static File filecsv;
//
//    public static void main(String str[]) {
//        try {
//
//
//            csvReadOperation1();
//            excelReadOperation();
//            addListAll();
//            excelWriteOperation();
//        } catch (
//                IOException e) {
//            e.printStackTrace();
//        }
//    }
//
//    public ExcelOperation2(String mFileExcel, String fileCsv, String fileResult) {
//        this.mFileExcel = mFileExcel;
//        this.fileCsv = fileCsv;
//        this.fileResult = fileResult;
//        try {
//            fileMovetoStr = ResourceUtils.getURL("classpath:").getPath() + "\\system1\\";
//            resourcemove = fileMovetoStr + "合成" + System.currentTimeMillis() + fileResult.substring(fileResult.lastIndexOf(".") - 1);
//            excelmove = fileMovetoStr + System.currentTimeMillis() + mFileExcel.substring(mFileExcel.lastIndexOf(".") - 2);
//            csvemove = fileMovetoStr + System.currentTimeMillis() + fileCsv.substring(fileCsv.lastIndexOf(".") - 13);
//
//        } catch (FileNotFoundException e) {
//            e.printStackTrace();
//        }
//
//    }
//
//    public static void exceldo() {
//        try {
//            file = new File(fileResult);
//            filecsv = new File(fileCsv);
//            fileloaninfo = new File(mFileExcel);
//            csvReadOperation1();
//            excelReadOperation();
//            addListAll();
//            excelWriteOperation();
//
//            File resourceMoveFile = new File(resourcemove);
//            File excelMoveFile = new File(excelmove);
//            File csvMoveFile = new File(csvemove);
//
//            FileUtils.cutFile(file, resourceMoveFile, false);
//            FileUtils.cutFile(fileloaninfo, excelMoveFile, true);
//            FileUtils.cutFile(filecsv, csvMoveFile, true);
//
//            ExcelController.fileResult = fileResult;
//
//        } catch (
//                IOException e) {
//            e.printStackTrace();
//        }
//    }
//
////    public
//
//    public static void addListAll() {
//        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy/MM/dd");
//        SimpleDateFormat simpleDateFormat2 = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
//
//        boolean isHas = false;
//        for (int i = 0; i < listLoanInfo.size(); i++) {
//            for (int j = 0; j < listResultInfo.size(); j++) {
//                if (listLoanInfo.get(i).getUserId().equals(listResultInfo.get(j).getUserId())) {
//                    isHas = true;
//                }
//            }
//            if (!isHas) {
//                ResultInfo resultInfo = new ResultInfo();
//                resultInfo.setUserId(listLoanInfo.get(i).getUserId());
//                resultInfo.setUserName(listLoanInfo.get(i).getUserName());
//                resultInfo.setRegistTime(simpleDateFormat2.format(listLoanInfo.get(i).getRegistTime()));
//                resultInfo.setUserlevel(listLoanInfo.get(i).getUserlevel());
//                resultInfo.setAppName(listLoanInfo.get(i).getAppName());
//                listResultInfo.add(resultInfo);
//            }
//            isHas = false;
//        }
//
//        for (int i = 0; i < listResultInfo.size(); i++) {
//            for (int j = 0; j < listLoanInfo.size(); j++) {
//                if (listResultInfo.get(i).getUserId().equals(listLoanInfo.get(j).getUserId())) {
//                    LoanInfo loanInfo = listLoanInfo.get(j);
//                    System.out.println("AAA:" + loanInfo.getLoanId());
//                    listResultInfo.get(i).setLoanId(loanInfo.getLoanId() + "");
//                    System.out.println("AAA222:" + listResultInfo.get(i).getLoanId());
//                    listResultInfo.get(i).setStateNow(loanInfo.getStateNow());
//                    String orderRepaymentState = "";
//                    //关闭（无放款时间）
//                    if (loanInfo.getLoanTime() == null) {
//                        orderRepaymentState = "关闭";
//                    } else {
//                        if (loanInfo.getSettleTime() != null) {
//                            //有放款日期 有结清时间
//                            Date dateMoneyshuld = loanInfo.getReturnMoneyshuldTime();
//                            Date settle = loanInfo.getSettleTime();
//
//                            String returnMoneyshuldTimeStr = simpleDateFormat.format(dateMoneyshuld);
//                            String settleStr = simpleDateFormat.format(settle);
//
//                            int compare = dateStrCompare(returnMoneyshuldTimeStr, settleStr);
//                            //且结清日期<=应还款日期
//                            if (compare == 1 || compare == 2) {
//                                //正常结清
//                                orderRepaymentState = "正常结清";
//                            } else {
//                                orderRepaymentState = "逾期已结清";
//                            }
//                        } else {
//                            //有放款时间 无结清日期
//                            Date date = loanInfo.getReturnMoneyshuldTime();
//                            if (date != null) {
//
//                                String returnMoneyshuldTimeStr = simpleDateFormat.format(date);
//                                String timeNowStr = simpleDateFormat.format(new Date());
//                                int compare = dateStrCompare(returnMoneyshuldTimeStr, timeNowStr);
//                                //且当前日期<=应还款日期
//                                if (compare == 1 || compare == 2) {
//                                    //未到期
//                                    orderRepaymentState = "未到期";
//                                } else {
//                                    orderRepaymentState = "逾期未结清";
//                                }
//                            }
//                        }
//                    }
//
//                    listResultInfo.get(i).setUnit(" ");
//                    listResultInfo.get(i).setOrderRepaymentState(orderRepaymentState);
//
//                    listResultInfo.get(i).setApplicationAmount(loanInfo.getApplicationAmount());
//                    listResultInfo.get(i).setApplicationdays(loanInfo.getApplicationdays());
//                    listResultInfo.get(i).setRate(loanInfo.getRate());
//                    listResultInfo.get(i).setServicefee(loanInfo.getServicefee());
//                    listResultInfo.get(i).setLoanAmountActual(loanInfo.getLoanAmountActual());
//                    listResultInfo.get(i).setApkVersion(loanInfo.getApkVersion());
//                    listResultInfo.get(i).setUserKTP(loanInfo.getUserKTP());
//                    listResultInfo.get(i).setRecruiterNow(loanInfo.getRecruiterNow());
//                    listResultInfo.get(i).setRejectStage(loanInfo.getRejectStage());
//                    listResultInfo.get(i).setReasonRefusal(loanInfo.getReasonRefusal());
//                    listResultInfo.get(i).setReturnMoneyRate(loanInfo.getReturnMoneyRate());
//                    listResultInfo.get(i).setReturnMoneyPrincipal(loanInfo.getReturnMoneyPrincipal());
//                    listResultInfo.get(i).setReturnMoneyService(loanInfo.getReturnMoneyService());
//                    listResultInfo.get(i).setReturnMoneyPenalty(loanInfo.getReturnMoneyPenalty());
//                    listResultInfo.get(i).setReturnMoneyAlready(loanInfo.getReturnMoneyAlready());
//                    listResultInfo.get(i).setSettleTime(loanInfo.getSettleTime());
//                    listResultInfo.get(i).setOverdueDays(loanInfo.getOverdueDays());
//                    listResultInfo.get(i).setReturnMoneyshuldTime(loanInfo.getReturnMoneyshuldTime());
//                    listResultInfo.get(i).setLoanTime(loanInfo.getLoanTime());
//
////                    simpleDateFormat2.format(loanInfo.getApplicationTime().getTime());
//                    listResultInfo.get(i).setApplicationTime(loanInfo.getApplicationTime());
//
//                    if (simpleDateFormat.format(loanInfo.getApplicationTime()) != null)
//                        listResultInfo.get(i).setApplicationDate(simpleDateFormat.format(loanInfo.getApplicationTime()));
//                    if (loanInfo.getLoanTime() != null) {
//                        listResultInfo.get(i).setLoanDate(simpleDateFormat.format(loanInfo.getLoanTime()));
//                    }
//
//                    if (loanInfo.getReturnMoneyshuldTime() != null)
//                        listResultInfo.get(i).setReturnMoneyshuldDate(simpleDateFormat.format(loanInfo.getReturnMoneyshuldTime()));
//                    if (loanInfo.getSettleTime() != null)
//                        listResultInfo.get(i).setSettleDate(simpleDateFormat.format(loanInfo.getSettleTime()));
//
//                    listResultInfo.get(i).setReturnMoneyAll(loanInfo.getReturnMoneyPrincipal() + loanInfo.getReturnMoneyRate() + loanInfo.getReturnMoneyService());
//                    listResultInfo.get(i).setReturnMoneyActual(loanInfo.getReturnMoneyPrincipal() + loanInfo.getReturnMoneyRate() + loanInfo.getReturnMoneyService() + loanInfo.getReturnMoneyPenalty());
//                }
//            }
//
//            System.out.println("listLoanInfo.get(0); " + listResultInfo.get(0));
//
//        }
//        System.out.println("listLoanInfo.get(0); " + listResultInfo.get(0));
//    }
//
//
//    //F:\Excel\loan-info.xlsm
//    public static void excelReadOperation() throws IOException {
////        InputStream inputStream = getInputStream();java.lang.NumberFormatException: For input string: "8392a4e8eb3433ff"
//
//
//        BufferedInputStream bis = new BufferedInputStream(new FileInputStream(fileloaninfo));
//
//
//        try {
//            listLoanInfo = ExcelReaderFactory.readExcel(bis, LoanInfo.class);
////            listCustomerInfo = ExcelReaderFactory.readExcel(bis2, CustomerInfo.class);
//
//        } catch (Exception e) {
//            e.printStackTrace();
//        } finally {
//            bis.close();
//        }
//    }
//
//    public static void excelWriteOperation() throws IOException {
////        InputStream inputStream = getInputStream();
//
//
//        if (file.exists()) {
//            file.delete();
//        }
//        file.createNewFile();
//
////        List<LoanInfo> list = new ArrayList<>();
////        for (int i = 0; i < 3; i++) {
////            LoanInfo loanInfo = new LoanInfo();
//////            loanInfo.setLoanId(i);
////            loanInfo.setUserId("userId" + i);
////            list.add(loanInfo);
////        }
//
//        ExcelReaderFactory.writeExcel("订单表", file, listResultInfo);
//
//    }
//
//    public static void csvReadOperation() throws IOException {
//        File file = new File("F:\\Excel\\customer-info.csv");
//        CsvReader csvReader = new CsvReader();
//        csvReader.setContainsHeader(true);
//
//        CsvContainer csv = csvReader.read(file, StandardCharsets.UTF_8);
//        for (CsvRow row : csv.getRows()) {
//            System.out.println("First column of line: " + row.getField("用户编号"));
//        }
//    }
//
//    public static void csvReadOperation1() throws IOException {
//        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy/MM/dd");
//        CsvReader csvReader = new CsvReader();
//
//        CsvContainer csv = csvReader.read(filecsv, StandardCharsets.UTF_8);
//        for (CsvRow row : csv.getRows()) {
//            System.out.println("Read line: " + row);
//            System.out.println("First column of line: " + row.getField(0));
//            if (row.getOriginalLineNumber() != 1) {
//                ResultInfo resultInfo = new ResultInfo();
//                resultInfo.setUserId(row.getField(0));
//                resultInfo.setUserPhone(row.getField(1));
//                resultInfo.setUserName(row.getField(2));
//                resultInfo.setRegistTime(row.getField(3));
//                resultInfo.setUserlevel(row.getField(4));
//                resultInfo.setAppName(row.getField(10));
//                listResultInfo.add(resultInfo);
//
//                ResultInfoUser resultInfoUser = new ResultInfoUser();
//                resultInfoUser.setRegistTime(row.getField(3));
//                if (simpleDateFormat.format(row.getField(3)) != null)
//                    resultInfoUser.setRegistDate(simpleDateFormat.format(row.getField(3)));
//                resultInfoUser.setRegistFrom(row.getField(11));
//                resultInfoUser.setRegistPakage(row.getField(10));
//                resultInfoUser.setUserLevel(row.getField(4));
//            }
//
//        }
//    }
//
//    public static void csvReadOperation2() throws IOException {
//        File file = new File("F:\\Excel\\customer-info.csv");
//        CsvReader csvReader = new CsvReader();
//
//        try (CsvParser csvParser = csvReader.parse(file, StandardCharsets.UTF_8)) {
//            CsvRow row;
//            while ((row = csvParser.nextRow()) != null) {
//                System.out.println("Read line: " + row);
//                System.out.println("First column of line: " + row.getField(0));
//            }
//        }
//    }
//
//    //比较date1是否大于date2   0:date1小于date2,   1：date1大于date2     2：date1=date2  2018/0/11
//    public static int dateStrCompare(String date1, String date2) {
//        String[] date1s = date1.split("/");
//        String[] date2s = date2.split("/");
//
//        int year1 = Integer.valueOf(date1s[0]);
//        int month1 = Integer.valueOf(date1s[1]);
//        int day1 = Integer.valueOf(date1s[2]);
//
//        int year2 = Integer.valueOf(date2s[0]);
//        int month2 = Integer.valueOf(date2s[1]);
//        int day2 = Integer.valueOf(date2s[2]);
//
//        if (year1 < year2) {
//            return 0;
//        } else if (year1 > year2) {
//            return 1;
//        } else {
//            if (month1 < month2) {
//                return 0;
//            } else if (month1 > month2) {
//                return 1;
//            } else {
//                if (day1 < day2) {
//                    return 0;
//                } else if (day1 > day2) {
//                    return 1;
//                } else {
//                    return 2;
//                }
//            }
//        }
//    }
//}