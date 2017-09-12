package com.mizeshuang.test;

import edu.princeton.cs.algs4.StdIn;
import com.mizeshuang.main.Stack;

import java.util.Scanner;

/**
 * Created by mizeshuang on 2016/4/6.
 */
public class exam1_3_9 {
    public static void exam() {
        Stack<String> number=new Stack<String>();
        Stack<String> symbol=new Stack<String>();
        String item;
        Scanner in=new Scanner(System.in);
        while (!StdIn.isEmpty()) {
            String subString="";
            item= StdIn.readString();
            if (item.equals("+") || item.equals("-") || item.equals("*") || item.equals("/")) {
                symbol.push(item);
            }
            else if (item.equals(")")) {
                subString=number.pop()+" )";
                subString="( "+number.pop()+" "+symbol.pop()+" "+subString;
                number.push(subString);

            } else {
                number.push(item);
            }
        }
        System.out.println(number.pop());
    }
    public static void main(String[] args) {
        exam();
    }
}
