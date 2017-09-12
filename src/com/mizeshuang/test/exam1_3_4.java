package com.mizeshuang.test;

import com.mizeshuang.main.Stack;

import java.util.Scanner;

/**
 * Created by mizeshuang on 2016/4/6.
 *
 */
public class exam1_3_4 {
	public static void exam(){
		Stack<Character> items=new Stack<Character>();
		Scanner in=new Scanner(System.in);
		boolean status=true;
		String line;
		line=in.nextLine();
		for (int i = 0; i < line.length(); i++) {
			Character ch = line.charAt(i);
			if (ch == '{' || ch == '[' || ch == '(')
				items.push(line.charAt(i));
			else if (ch == '}' || ch == ']' || ch == ')') {
				if (ch == '}') {
					if (items.pop() != '{') {
						status = false;
						break;
					}

				} else if (ch == ']') {
					if (items.pop() != '[') {
						status = false;
						break;
					}
				} else if (ch == ')') {
					if (items.pop() != '(') {
						status = false;
						break;
					}
				}
			}
		}
		System.out.println(status);
	}
	public static void main(String[] args) {
		exam();
	}
}
