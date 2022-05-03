package com.tyk.SoftWare.FourArith_Program;

import java.io.IOException;

/**
 * @author Tang
 * @version 1.0
 * 该程序实现简易的混合四则运算表达式生成
 *  1　能够自动生成四则运算练习题
 *  2　可以定制题目数量
 *  3　用户可以选择运算符(+ - / *)
 *  4　用户设置最大数（如十以内、百以内等）
 *  5　用户选择是否有括号、是否有小数
 *  6　用户选择输出方式（如输出到文件、打印机等）
 *  7  用户可以指定操作数个数的范围
 *
 *  但是也有一些业务、边界、安全问题，有待改进，比如：
 *      用户输入可能会输入不合逻辑的负整数
 *      没有进行运算式结果的统计
 *      没有提供修改输出文件路径的方法
 *      在producer方法中，用于判断运算时是否包含括号，是否包含小数的代码实现部分冗余度大
 *      父类子类的逻辑关系不够紧密等等
 */

public class fourAri_program {
    public static void main(String[] args) throws IOException {
        new Producer().print();
    }
}
