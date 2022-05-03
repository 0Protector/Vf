package com.tyk.SoftWare.FourArith_Program;

import java.io.IOException;
import java.util.Scanner;

/**
 * @author Tang
 * @version 1.0
 */
public class Output_ {
    private int issue_Num = 10;
    private int issue_Len = 6;
    private int issue_Max = 10;
    private boolean isHaveBrackets = true;
    private boolean isHaveDecimal = true;
    private int outWay = 0;
    private String filePath = "d://FourAri_Program.txt";

    public int getOutWay() {
        return outWay;
    }

    public void setOutWay(int outWay) {
        this.outWay = outWay;
    }

    public String getFilePath() {
        return filePath;
    }

    public void setFilePath(String filePath) {
        this.filePath = filePath;
    }

    public void setIssue_Num(int issue_Num) {
        this.issue_Num = issue_Num;
    }

    public void setIssue_Len(int issue_Len) {
        this.issue_Len = issue_Len;
    }

    public void setIssue_Max(int issue_Max) {
        this.issue_Max = issue_Max;
    }

    public void setHaveBrackets(boolean haveBrackets) {
        isHaveBrackets = haveBrackets;
    }

    public void setHaveDecimal(boolean haveDecimal) {
        isHaveDecimal = haveDecimal;
    }

    public int getIssue_Num() {
        return issue_Num;
    }

    public int getIssue_Len() {
        return issue_Len;
    }

    public int getIssue_Max() {
        return issue_Max;
    }

    public boolean isHaveBrackets() {
        return isHaveBrackets;
    }

    public boolean isHaveDecimal() {
        return isHaveDecimal;
    }

    public void print() throws IOException {
        int getOperand = 0;
        //获取操作数
        Scanner scanner = new Scanner(System.in);
        while (true) {
            printUI();
            getOperand = scanner.nextInt();

            switch (getOperand) {
                case 1:
                    System.out.println("设置题目数量：");
                    issue_Num = scanner.nextInt();
                    System.out.println("设置成功！");
                    break;
                case 2:
                    System.out.println("设置题目中操作数的最大长度(不能小于2)：");
                    issue_Len = scanner.nextInt();
                    if (issue_Len < 2){
                        System.out.println("设置失败！" +
                                "\n 失败原因： 操作数不能低于两个");
                    }
                    System.out.println("设置成功！");
                    break;
                case 3:
                    System.out.println("设置题目中操作数的最大值：");
                    issue_Max = scanner.nextInt();
                    System.out.println("设置成功！");
                    break;
                case 4:
                    System.out.println("设置题目中是否有括号：");
                    isHaveBrackets = scanner.nextBoolean();
                    System.out.println("设置成功！");
                    break;
                case 5:
                    System.out.println("设置题目中是否有小数");
                    isHaveDecimal = scanner.nextBoolean();
                    System.out.println("设置成功！");
                    break;
                case 6:
                    System.out.println("设置输出方式");
                    outWay = scanner.nextInt();
                    System.out.println("设置成功！");
                default:
                    break;
            }

            if (getOperand == 7) {
                System.out.println("退出设置");
                break;
            }
        }

    }



        public void printUI(){
            System.out.println("欢迎使用四则运算自动生成软件！\n" +
                    "1. 设置生成题目的数量\n" +
                    "2. 设置生成题目的最大长度(指操作数数量，不含操作符)\n" +
                    "3. 设置操作数的最大值\n" +
                    "4. 设置是否有括号\n" +
                    "5. 设置是否有小数\n" +
                    "6. 设备输出格式：(0表示打印到控制台，1表示输出到文件)\n" +
                    "7. 退出设置");
    }
}

