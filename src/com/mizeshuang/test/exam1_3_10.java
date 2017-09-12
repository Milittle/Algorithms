package com.mizeshuang.test;

import edu.princeton.cs.algs4.StdIn;
import com.mizeshuang.main.Queue;
import com.mizeshuang.main.Stack;

/**
 * Created by mizeshuang on 2016/4/8.
 */
public class exam1_3_10 {
    public static void exam() {
        Stack<String> source =new Stack<>();
        Queue<String> total=new Queue<>();
        String temp="";
        String sub="";
        while (!StdIn.isEmpty()) {
            temp=StdIn.readString();
            if (temp.equals("(")) {
                source.push(temp);
            }
            else if (temp.equals(")")) {
                if (source.isEmpty()) {
                    System.out.println("错误1");
                }
                else {
                    while (!(sub = source.pop()).equals("(")) {
                        total.enqueue(sub);
                    }
                }
            }
            else if (temp.equals("+") || temp.equals("-") || temp.equals("*") || temp.equals("/")) {
                if (temp.equals("+")) {
                    while (!source.isEmpty()&&!source.peek().equals("(")) {
                        sub= source.pop();
                        total.enqueue(sub);
                    }
                    source.push(temp);
                }
                else if (temp.equals("-")) {
                    while (!source.isEmpty()&&!source.peek().equals("(")) {
                        sub= source.pop();
                        total.enqueue(sub);
                    }
                    source.push(temp);
                }
                else if (temp.equals("*")) {
                    while (!source.isEmpty()&&!source.peek().equals("(")&&(source.peek().equals("*")|| source.peek().equals("/"))) {
                        sub= source.pop();
                        total.enqueue(sub);
                    }
                    source.push(temp);
                }
                else if (temp.equals("/")) {
                    while (!source.isEmpty()&&!source.peek().equals("(")&&(source.peek().equals("*")|| source.peek().equals("/"))) {
                        sub= source.pop();
                        total.enqueue(sub);
                    }
                    source.push(temp);
                }
            }
            else{
                total.enqueue(temp);
            }
        }
        while (!source.isEmpty()) {
            temp= source.pop();
            if (temp.equals("(")) {
                System.out.println("错误2");
            }
            else{
                total.enqueue(temp);
            }
        }
        for (String i : total) {
            System.out.print(i + " ");
        }
    }
    public static void main(String[] args) {
        exam();
    }
}
