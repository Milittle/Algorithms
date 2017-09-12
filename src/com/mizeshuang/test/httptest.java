package com.mizeshuang.test;

/**
 * Created by mizeshuang on 2016/4/14.
 */
public class httptest {
    public static void main(String[] args) {
        int n=Integer.MAX_VALUE;
        System.out.println(returnHttp(n));
    }

    public static String returnHttp(int ip) {
        String temp="";
        String result="";
        for (int i = ip; i > 0; i = i / 2) {
            temp=i%2+temp;
        }

        int n=temp.length();
        if (temp.length() != 32) {
            for (int i = 0; i < 32 - n; i++) {
                temp="0"+temp;
            }
        }

        for (int i = 0; i < 4; i++) {
            int m=0;
            for (int j = i * 8; j < (i + 1) * 8; j++) {
                m= (int) (m+Integer.parseInt(String.valueOf(temp.charAt(j)))*Math.pow(2,8-(j%8+1)));
            }
            if (i == 3) {
                result=result+m;
            }
            else
                result=result+m+".";
        }

        return result;

    }
}
