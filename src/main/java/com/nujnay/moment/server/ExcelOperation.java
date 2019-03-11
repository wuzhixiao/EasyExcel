package com.nujnay.moment.server;

import ch.qos.logback.core.util.FileUtil;
import com.alibaba.excel.ExcelReader;
import com.alibaba.excel.metadata.BaseRowModel;
import com.nujnay.moment.server.controller.ExcelController;
import com.nujnay.moment.server.util.FileUtils;
import de.siegmar.fastcsv.reader.CsvContainer;
import de.siegmar.fastcsv.reader.CsvParser;
import de.siegmar.fastcsv.reader.CsvReader;
import de.siegmar.fastcsv.reader.CsvRow;
import org.apache.poi.hssf.usermodel.HSSFDateUtil;
import org.springframework.util.ResourceUtils;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

public class ExcelOperation {
    static List<LoanInfo> listLoanInfo = new ArrayList<>();
    static List<ResultInfo> listResultInfo = new ArrayList<>();
    static List<ResultInfo> listResultInfo2 = new ArrayList<>();
    static List<ResultInfoUser> listResultInfoUser = new ArrayList<>();
    static List<ResultInfoNewUser> listResultInfoNewUser = new ArrayList<>();
    static List<ResultInfoProduct> listResultInfoProduct = new ArrayList<>();

    static String mFileExcel = "";
    static String fileCsv = "";
    static String fileResult = "";
    static String fileMovetoStr = "";
    static String resourcemove = "";
    static String excelmove = "";
    static String csvemove = "";
    static File file;
    static File fileloaninfo;
    static File filecsv;

    public static void main(String str[]) {
//        try {
//            excelReadOperation();
//            csvReadOperation1();
//            excelWriteOperation();
//        } catch (
//                IOException e) {
//            e.printStackTrace();
//        }
    }

    public ExcelOperation(String mFileExcel, String fileCsv, String fileResult) {
        this.mFileExcel = mFileExcel;
        this.fileCsv = fileCsv;
        this.fileResult = fileResult;
        try {
            fileMovetoStr = ResourceUtils.getURL("classpath:").getPath() + "\\system1\\";
            resourcemove = fileMovetoStr + "合成" + System.currentTimeMillis() + fileResult.substring(fileResult.lastIndexOf(".") - 1);
            excelmove = fileMovetoStr + System.currentTimeMillis() + mFileExcel.substring(mFileExcel.lastIndexOf(".") - 2);
            csvemove = fileMovetoStr + System.currentTimeMillis() + fileCsv.substring(fileCsv.lastIndexOf(".") - 13);

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

    }

    public static void exceldo() {
        try {
            file = new File(fileResult);
            filecsv = new File(fileCsv);
            fileloaninfo = new File(mFileExcel);
            excelReadOperation();
            csvReadOperation1();
            excelWriteOperation();

            File resourceMoveFile = new File(resourcemove);
            File excelMoveFile = new File(excelmove);
            File csvMoveFile = new File(csvemove);

            FileUtils.cutFile(file, resourceMoveFile, false);
            FileUtils.cutFile(fileloaninfo, excelMoveFile, true);
            FileUtils.cutFile(filecsv, csvMoveFile, true);

            ExcelController.fileResult = fileResult;

            System.out.println("wzxxxxxxxxxxxxx成功wzxxxxxxxxxxxxx成功wzxxxxxxxxxxxxx成功wzxxxxxxxxxxxxx成功wzxxxxxxxxxxxxx成功 ");
        } catch (IOException e) {
            System.out.println("wzxxxxxxxxxxxxxx2344 " + e.toString());
            e.printStackTrace();
        }
    }


    //F:\Excel\loan-info.xlsm
    public static void excelReadOperation() throws IOException {
//        InputStream inputStream = getInputStream();java.lang.NumberFormatException: For input string: "8392a4e8eb3433ff"


        BufferedInputStream bis = new BufferedInputStream(new FileInputStream(fileloaninfo));

        listLoanInfo = ExcelReaderFactory.readExcel(bis, LoanInfo.class);

        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy/MM/dd");
        SimpleDateFormat simpleDateFormat2 = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");

        try {
//            listCustomerInfo = ExcelReaderFactory.readExcel(bis2, CustomerInfo.class);
            for (int i = 0; i < listLoanInfo.size(); i++) {
                ResultInfo resultInfo = new ResultInfo();
                LoanInfo loanInfo = listLoanInfo.get(i);
                resultInfo.setLoanId(loanInfo.getLoanId() + "");
                resultInfo.setStateNow(loanInfo.getStateNow());

                String orderRepaymentState = "";
                //关闭（无放款时间）
                if (loanInfo.getLoanTime() == null) {
                    orderRepaymentState = "关闭";
                } else {
                    if (loanInfo.getSettleTime() != null) {
                        //有放款日期 有结清时间
                        Date dateMoneyshuld = loanInfo.getReturnMoneyshuldTime();
                        Date settle = loanInfo.getSettleTime();

                        String returnMoneyshuldTimeStr = simpleDateFormat.format(dateMoneyshuld);
                        String settleStr = simpleDateFormat.format(settle);

                        int compare = dateStrCompare(returnMoneyshuldTimeStr, settleStr);
                        //且结清日期<=应还款日期
                        if (compare == 1 || compare == 2) {
                            //正常结清
                            orderRepaymentState = "正常结清";
                        } else {
                            orderRepaymentState = "逾期已结清";
                        }
                    } else {
                        //有放款时间 无结清日期
                        Date date = loanInfo.getReturnMoneyshuldTime();
                        if (date != null) {

                            String returnMoneyshuldTimeStr = simpleDateFormat.format(date);
                            String timeNowStr = simpleDateFormat.format(new Date());
                            int compare = dateStrCompare(returnMoneyshuldTimeStr, timeNowStr);
                            //且当前日期<=应还款日期
                            if (compare == 1 || compare == 2) {
                                //未到期
                                orderRepaymentState = "未到期";
                            } else {
                                orderRepaymentState = "逾期未结清";
                            }
                        }
                    }
                }

                resultInfo.setUnit(" ");
                resultInfo.setOrderRepaymentState(orderRepaymentState);
                resultInfo.setUserId(loanInfo.getUserId());
                resultInfo.setApplicationAmount(loanInfo.getApplicationAmount());
                resultInfo.setApplicationdays(loanInfo.getApplicationdays());
                resultInfo.setRate(loanInfo.getRate());
                resultInfo.setServicefee(loanInfo.getServicefee());
                resultInfo.setLoanAmountActual(loanInfo.getLoanAmountActual());
                resultInfo.setApkVersion(loanInfo.getApkVersion());
                resultInfo.setUserKTP(loanInfo.getUserKTP());
                resultInfo.setRecruiterNow(loanInfo.getRecruiterNow());
                resultInfo.setRejectStage(loanInfo.getRejectStage());
                resultInfo.setReasonRefusal(loanInfo.getReasonRefusal());
                resultInfo.setReturnMoneyRate(loanInfo.getReturnMoneyRate());
                resultInfo.setReturnMoneyPrincipal(loanInfo.getReturnMoneyPrincipal());
                resultInfo.setReturnMoneyService(loanInfo.getReturnMoneyService());
                resultInfo.setReturnMoneyPenalty(loanInfo.getReturnMoneyPenalty());
                resultInfo.setReturnMoneyAlready(loanInfo.getReturnMoneyAlready());
                resultInfo.setSettleTime(loanInfo.getSettleTime());
                resultInfo.setOverdueDays(loanInfo.getOverdueDays());
                resultInfo.setReturnMoneyshuldTime(loanInfo.getReturnMoneyshuldTime());
                resultInfo.setLoanTime(loanInfo.getLoanTime());

//                    simpleDateFormat2.format(loanInfo.getApplicationTime().getTime());
                resultInfo.setApplicationTime(loanInfo.getApplicationTime());

                if (simpleDateFormat.format(loanInfo.getApplicationTime()) != null)
                    resultInfo.setApplicationDate(simpleDateFormat.format(loanInfo.getApplicationTime()));
                if (loanInfo.getLoanTime() != null) {
                    resultInfo.setLoanDate(simpleDateFormat.format(loanInfo.getLoanTime()));
                }

                if (loanInfo.getReturnMoneyshuldTime() != null)
                    resultInfo.setReturnMoneyshuldDate(simpleDateFormat.format(loanInfo.getReturnMoneyshuldTime()));
                if (loanInfo.getSettleTime() != null)
                    resultInfo.setSettleDate(simpleDateFormat.format(loanInfo.getSettleTime()));

                resultInfo.setReturnMoneyAll(loanInfo.getReturnMoneyPrincipal() + loanInfo.getReturnMoneyRate() + loanInfo.getReturnMoneyService());
                resultInfo.setReturnMoneyActual(loanInfo.getReturnMoneyPrincipal() + loanInfo.getReturnMoneyRate() + loanInfo.getReturnMoneyService() + loanInfo.getReturnMoneyPenalty());
                listResultInfo.add(resultInfo);

            }


            System.out.println("wzxxxxxxxxxxxxxx listResultInfo " + listResultInfo.size());

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            bis.close();
        }
    }

    public static void excelWriteOperation() throws IOException {
//        InputStream inputStream = getInputStream();

        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy/MM/dd");

        if (file.exists()) {
            file.delete();
        }
        file.createNewFile();

//        List<LoanInfo> list = new ArrayList<>();
//        for (int i = 0; i < 3; i++) {
//            LoanInfo loanInfo = new LoanInfo();
////            loanInfo.setLoanId(i);
//            loanInfo.setUserId("userId" + i);
//            list.add(loanInfo);
//        }
        int i = 0;
//        for (ResultInfoUser resultInfoUser : listResultInfoUser) {
        HashMap<String, ResultInfoUserInfo> resultInfoUserInfoHashMap = new HashMap<>();

        for (int j = 0; j < listResultInfoNewUser.size(); j++) {
            long newUserApplication = 0;
            long newUserLoanNum = 0;
            for (ResultInfo resultInfo : listResultInfo) {
                if (j == 0) {
                    if (resultInfoUserInfoHashMap.containsKey(resultInfo.getUserId())) {
                        ResultInfoUserInfo resultInfoUserInfo = resultInfoUserInfoHashMap.get(resultInfo.getUserId());
                        resultInfoUserInfo.setDksqsuccessTimes(resultInfoUserInfo.getDksqsuccessTimes() + 1);
                        if (resultInfo.getLoanTime() != null) {

                            resultInfoUserInfo.setDksqsuccessTimes(resultInfoUserInfo.getDksqsuccessTimes() + 1);

                            if (resultInfoUserInfo.getmLoanDatas() == null) {
                                List<ResultInfoUserInfo.LoanData> loanDatas = new ArrayList<>();
                                resultInfoUserInfo.setDksqsuccessTimes(1);
                                ResultInfoUserInfo.LoanData loanData1 = new ResultInfoUserInfo.LoanData();
                                loanData1.setLoanSucc1(resultInfo.getLoanId() + "|" + resultInfo.getOrderRepaymentState() + "|" + resultInfo.getOverdueDays());
                                loanData1.setDdkkstate(resultInfo.getOrderRepaymentState());
                                loanData1.setDdkkstate(resultInfo.getOverdueDays() + "");
                                loanDatas.add(loanData1);
                                resultInfoUserInfo.setmLoanDatas(loanDatas);
                            } else {
                                List<ResultInfoUserInfo.LoanData> loanDatas = resultInfoUserInfo.getmLoanDatas();
                                resultInfoUserInfo.setDksqsuccessTimes(resultInfoUserInfo.getDksqsuccessTimes() + 1);
                                ResultInfoUserInfo.LoanData loanData1 = new ResultInfoUserInfo.LoanData();
                                loanData1.setLoanSucc1(resultInfo.getLoanId() + "|" + resultInfo.getOrderRepaymentState() + "|" + resultInfo.getOverdueDays());
                                loanData1.setDdkkstate(resultInfo.getOrderRepaymentState());
                                loanData1.setDdkkstate(resultInfo.getOverdueDays() + "");
                                loanDatas.add(loanData1);
                                resultInfoUserInfo.setmLoanDatas(loanDatas);
                            }
                        }

                    } else {
                        ResultInfoUserInfo resultInfoUserInfo = new ResultInfoUserInfo();
                        resultInfoUserInfo.setDksqsuccessTimes(1);
                        List<ResultInfoUserInfo.LoanData> loanDatas = new ArrayList<>();
                        if (resultInfo.getLoanTime() != null) {
                            resultInfoUserInfo.setDksqsuccessTimes(1);
                            ResultInfoUserInfo.LoanData loanData = new ResultInfoUserInfo.LoanData();
                            loanData.setLoanSucc1(resultInfo.getLoanId() + "|" + resultInfo.getOrderRepaymentState() + "|" + resultInfo.getOverdueDays());
                            loanData.setDdkkstate(resultInfo.getOrderRepaymentState());
                            loanData.setDdkkstate(resultInfo.getOverdueDays() + "");
                            loanDatas.add(loanData);
                            resultInfoUserInfo.setmLoanDatas(loanDatas);
                        }

                        resultInfoUserInfoHashMap.put(resultInfo.getUserId(), resultInfoUserInfo);
                    }

                }


                List<String> userIdList = new ArrayList<>();
                boolean isHasUserId = false;
                //新用户转化
                if (dateStrCompare(resultInfo.getApplicationDate(), listResultInfoNewUser.get(j).getRegistDate()) == 2 &&
                        dateStrCompare(resultInfo.getApplicationDate(), chageDate(resultInfo.getRegistTime())) == 2) {


                    if (userIdList.size() > 0) {

                        for (int k = 0; k < userIdList.size(); k++) {
                            if (userIdList.get(k).equals(resultInfo.getUserId())) {
                                isHasUserId = true;
                            }
                        }


                        if (!true) {
                            userIdList.add(resultInfo.getUserId());
                            newUserApplication++;

                            if (dateStrCompare(resultInfo.getApplicationDate(), resultInfo.getLoanDate()) == 2) {
                                newUserLoanNum++;
                            }
                        }
                        isHasUserId = false;


                    } else {
                        newUserApplication++;
                        userIdList.add(resultInfo.getUserId());
                        if (dateStrCompare(resultInfo.getApplicationDate(), resultInfo.getLoanDate()) == 2) {
                            newUserLoanNum++;
                        }
                    }

                }
                System.out.println(newUserApplication + "  " + " newUserLoanNum  " + newUserLoanNum + " " + listResultInfoNewUser.get(j).getRegistPeopleNum());
                listResultInfoNewUser.get(j).setSqNum(newUserApplication + "");
                listResultInfoNewUser.get(j).setFkNum(newUserLoanNum + "");
                if (newUserApplication != 0) {
                    listResultInfoNewUser.get(j).setSqfkLv((((float) newUserLoanNum / (float) newUserApplication) * 100) + "%");
                }
                int registNum = Integer.valueOf(listResultInfoNewUser.get(j).getRegistPeopleNum());
                if (newUserLoanNum != 0) {
                    listResultInfoNewUser.get(j).setZcfkLv((((float) registNum / (float) newUserLoanNum) * 100) + "%");
                }

                if (registNum != 0) {
                    listResultInfoNewUser.get(j).setZcSqLv((((float) newUserApplication / (float) registNum) * 100) + "%");
                }


            }


        }


//"订单表", file, listResultInfo,


        ExcelReaderFactory.writeExcel("订单表", file, listResultInfo, "用户表", listResultInfoUser,
                "新用户转化分析", listResultInfoNewUser);

    }

    public static void csvReadOperation() throws IOException {
        File file = new File("F:\\Excel\\customer-info.csv");
        CsvReader csvReader = new CsvReader();
        csvReader.setContainsHeader(true);

        CsvContainer csv = csvReader.read(file, StandardCharsets.UTF_8);
        for (CsvRow row : csv.getRows()) {
            System.out.println("First column of line: " + row.getField("用户编号"));
        }
    }


    public static void csvReadOperation1() throws IOException {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy/MM/dd");
        CsvReader csvReader = new CsvReader();
        CsvContainer csv = csvReader.read(filecsv, StandardCharsets.UTF_8);
//        System.out.println("wzxxxxxxxxx listResultInfoUser222 " + listResultInfo.size());
        System.out.println("wzxxxxxxxxx listResultInfoUser " + csv.getRows().size());

        System.out.println("wzxxxxxxxxx listResultInfo123o  " + listResultInfo.size());

        for (int i = 0; i < listResultInfo.size(); i++) {
            ResultInfo resultInfo = listResultInfo.get(i);
            for (int j = 0; j < csv.getRows().size(); j++) {
                CsvRow row = csv.getRows().get(j);
//                System.out.println("listResultInfo: " + i + " CsvRow " + j);
//                System.out.println("Read line: " + row);
//                System.out.println("First column of line: " + row.getField(0));
                if (i == 0 && row.getOriginalLineNumber() > 1) {
                    ResultInfoUser resultInfoUser = new ResultInfoUser();
                    resultInfoUser.setUserAccount(row.getField(0));
                    resultInfoUser.setRegistTime(row.getField(3));
//                if (simpleDateFormat.format(row.getField(3)) != null)simpleDateFormat.format(
                    resultInfoUser.setRegistDate(row.getField(3));
                    resultInfoUser.setRegistFrom(row.getField(11));
                    resultInfoUser.setRegistPakage(row.getField(10));
                    resultInfoUser.setUserLevel(row.getField(4));
                    listResultInfoUser.add(resultInfoUser);

                    ResultInfoNewUser resultInfoNewUser = new ResultInfoNewUser();
                    resultInfoNewUser.setRegistTime(row.getField(3));
                    resultInfoNewUser.setRegistDate(chageDate(row.getField(3)));
                    resultInfoNewUser.setRegistPeopleNum(csv.getRows().size() + "");

                    listResultInfoNewUser.add(resultInfoNewUser);
                }

                if (resultInfo.getUserId().equals(row.getField(0))) {
                    if (row.getOriginalLineNumber() != 1) {
                        resultInfo.setUserId(row.getField(0));
                        resultInfo.setUserPhone(row.getField(1));
                        resultInfo.setUserName(row.getField(2));
                        resultInfo.setRegistTime(row.getField(3));
                        resultInfo.setUserlevel(row.getField(4));
                        resultInfo.setAppName(row.getField(10));
                        listResultInfo2.add(resultInfo);
                    }
                    continue;
                }


            }
        }


        listResultInfo.addAll(listResultInfo2);
    }

    public static void csvReadOperation2() throws IOException {
        File file = new File("F:\\Excel\\customer-info.csv");
        CsvReader csvReader = new CsvReader();

        try (CsvParser csvParser = csvReader.parse(file, StandardCharsets.UTF_8)) {
            CsvRow row;
            while ((row = csvParser.nextRow()) != null) {
                System.out.println("Read line: " + row);
                System.out.println("First column of line: " + row.getField(0));
            }
        }
    }

    //比较date1是否大于date2   0:date1小于date2,   1：date1大于date2     2：date1=date2  2018/0/11
    public static int dateStrCompare(String date1, String date2) {
        String[] date1s = date1.split("/");
        String[] date2s = date2.split("/");

        int year1 = Integer.valueOf(date1s[0]);
        int month1 = Integer.valueOf(date1s[1]);
        int day1 = Integer.valueOf(date1s[2]);

        int year2 = Integer.valueOf(date2s[0]);
        int month2 = Integer.valueOf(date2s[1]);
        int day2 = Integer.valueOf(date2s[2]);

        if (year1 < year2) {
            return 0;
        } else if (year1 > year2) {
            return 1;
        } else {
            if (month1 < month2) {
                return 0;
            } else if (month1 > month2) {
                return 1;
            } else {
                if (day1 < day2) {
                    return 0;
                } else if (day1 > day2) {
                    return 1;
                } else {
                    return 2;
                }
            }
        }
    }

    private static String chageDate(String date) {
        DateFormat simpleDateFormat = new SimpleDateFormat("yyyy/MM/dd");
        try {
            Date s = simpleDateFormat.parse(date);
            return simpleDateFormat.format(s);
        } catch (ParseException e) {
            e.printStackTrace();
        }

        return "";
    }
}