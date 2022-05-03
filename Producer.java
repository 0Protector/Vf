package com.tyk.SoftWare.FourArith_Program;

import jdk.jfr.StackTrace;
import org.junit.jupiter.api.Test;

import java.io.*;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Random;

/**
 * @author Tang
 * @version 1.0
 */
public class Producer extends Output_{
    ArrayList<String> Ari_issue = new ArrayList<>();
    @Override
    public void print() throws IOException {
        int OutNum = 1;
        super.print();
        produce();
        //调用迭代器遍历四则表达式集合
        if(getOutWay() == 0) {
            Iterator<String> iterator = Ari_issue.iterator();
            while (iterator.hasNext()) {
                System.out.println("题目编号" + OutNum + ":");
                String next = iterator.next();
                System.out.println(next);
                OutNum++;
            }
        }
        else{
            BufferedWriter bw = new BufferedWriter(new FileWriter(getFilePath()));  //覆盖模式
            Iterator<String> iterator = Ari_issue.iterator();
            while (iterator.hasNext()) {
////                System.out.println("题目编号" + OutNum + ":");
//                bw.write("题目编号");
//                bw.write(OutNum);
//                bw.write(":");
//                bw.newLine();
                String next = iterator.next();
                bw.write(next);
                bw.newLine();
                OutNum++;
            }
            bw.close();
            System.out.println("文件打印成功！");
        }
    }

    //生成需要的四则运算表达式
    @Test
    public void produce(){
        String issue = "";
        int issue_LenScope = 0;
        for (int i = 0; i < getIssue_Num(); i++) {
            //在范围内 的随机操作数个数
            issue_LenScope =(int)(Math.random() * (getIssue_Len() - 1) + 2);
//            if(isHaveDecimal())
            if(isHaveBrackets() && isHaveDecimal()){
                int BracketsNum = 0;    //简易模拟括号压弹栈
                int isBrackets; //是否生成括号的种子
                int isDecimal;   //添加整数还是浮点数的选择种子
                for (int j = 0; j < issue_LenScope - 1; j++) {
                    isDecimal =(int)( Math.random()*2);

                    //防止只有两个操作数的时候还有括号
                    if(issue_LenScope == 2){
                        isBrackets = 0;
                    }else {
                        isBrackets = (int) (Math.random() * 4);
                    }
                    if (isBrackets == 1){
                        BracketsNum ++; //括号入栈
                        issue += "(";   //生成左括号
                    }

                    if (isDecimal == 0){    //取整数
                        issue += getIntOperator();
                        issue += " ";
                    }else{  //取小数
                        issue += getDoubleOperator();
                        issue += " ";
                    }

                    if (isBrackets == 3 && BracketsNum > 0){
                        issue += ")";   //括号弹栈
                        BracketsNum --;
                    }
                    issue += getOperator();
                    issue += " ";
                }
                issue += getIntOperator();
                if (BracketsNum != 0){  //如果表达式结尾，栈内还有左括号没有进行匹配，则将全部输出
                    for (int j = 0; j < BracketsNum; j++) {
                        issue += ")";
                    }
                }
                issue += " = ?";
            }else if (isHaveDecimal()){
                int isDecimal;   //添加整数还是浮点数的选择种子
                for (int j = 0; j < issue_LenScope - 1; j++) {
                    isDecimal =(int)( Math.random()*2);
                    if (isDecimal == 0){    //取整数
                        issue += getIntOperator();
                        issue += " ";
                    }else{  //取小数
                        issue += getDoubleOperator();
                        issue += " ";
                    }
                    issue += getOperator();
                    issue += " ";
                }
                issue += getIntOperator();
                issue += " = ?";

            }else if(isHaveBrackets()){
                int BracketsNum = 0;    //简易模拟括号压弹栈
                int isBrackets; //是否生成括号的种子
                for (int j = 0; j < issue_LenScope - 1; j++) {
                    isBrackets = (int)(Math.random()*4);
                    if (isBrackets == 0){
                        BracketsNum ++; //括号入栈
                        issue += "(";   //生成左括号
                    }

                    issue += getIntOperator();
                    issue += " ";

                    if (isBrackets == 3 && BracketsNum > 0){
                        issue += ")";   //括号弹栈
                        BracketsNum --;
                    }

                    issue += getOperator();
                    issue += " ";

                }
                issue += getIntOperator();
                if (BracketsNum != 0){  //如果表达式结尾，栈内还有左括号没有进行匹配，则将全部输出
                    for (int j = 0; j < BracketsNum; j++) {
                        issue += ")";
                    }
                }
                issue += " = ?";
            }else {
                for (int j = 0; j < issue_LenScope - 1; j++) {
                    issue += getIntOperator();
                    issue += " ";
                    issue += getOperator();
                    issue += " ";
                }
                issue += getIntOperator();
                issue += " = ?";
            }
//            System.out.println(issue);
            if (issue != null) {
                Ari_issue.add(issue);   //将四则表达式加入集合
            }
            //issue 清空
            issue = "";
        }
    }
    //返回一个整数
    @Test
    public int getIntOperator(){
        return (int) (Math.random()*getIssue_Max() + 1);
//        System.out.println((int) (Math.random()*getIssue_Max() + 1));
    }
    //返回一个随机的保留两位的浮点型数
    @Test
    public double getDoubleOperator(){
        return Double.parseDouble(String.format("%.2f", Math.random()*getIssue_Max()));
//        for (int i = 0; i < 10; i++) {
//            System.out.println(Double.parseDouble(String.format("%.2f", Math.random()*getIssue_Max())));
//        }

    }

    public String getOperator(){
        String str  = "";   //用于存储返回的运算符
        switch ((int)(Math.random()* 4)){   //种下随机种子
            case 0:
               str = "+";
               break;
            case 1:
                str = "-";
                break;
            case 2:
                str = "*";
                break;
            case 3:
                str = "/";
                break;

//            default:
//                throw new IllegalStateException("Unexpected value: " + (int) (Math.random() * 4 + 1));
        }
        
        return str;
    }
}
