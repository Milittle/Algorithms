package com.mizeshuang.main;

import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.StdRandom;
import edu.princeton.cs.algs4.Stopwatch;

/**
 * Created by mizeshuang on 2016/4/29.
 */

/*测试随机的排序算法的各个时间*/
public class SortCompare {
    public static double time(String alg, Double[] a) {
        Stopwatch timer = new Stopwatch();
        if(alg.equals("Insertion")) Insertion.sorted(a);
        if(alg.equals("Selection")) Selection.sort(a);
        if(alg.equals("Shell")) Shell.sorted(a);
        return timer.elapsedTime();
    }

    public static double timeRandomInput(String alg, int N, int T) {
        double total = 0.0;
        Double[] a = new Double[N];
        for (int t = 0; t < T; t++) {
            for (int i = 0; i < N; i++) {
                a[i] = StdRandom.uniform();
            }
            total += time(alg, a);
        }
        return total;
    }

    public static void main(String[] args) {
        System.out.println("请输入一个排序算法的名称：");
        String alg1 = StdIn.readString();
        System.out.println("请输入一个排序算法的名称：");
        String alg2 = StdIn.readString();
        System.out.println("请输入一个排序算法的名称：");
        String alg3 = StdIn.readString();
        System.out.println("请输入数组的数目");
        int n1 = StdIn.readInt();
        System.out.println("请输入数组的数目");
        int n2 = StdIn.readInt();
        System.out.println("请输入数组的数目");
        int n3 = StdIn.readInt();
        double total1 = timeRandomInput(alg1, 10, n1);
        double total2 = timeRandomInput(alg2, 10, n2);
        double total3 = timeRandomInput(alg3, 10, n3);
        StdOut.printf("%s total's time is %.10f\n", alg1, total1);
        StdOut.printf("%s total's time is %.10f\n", alg2, total2);
        StdOut.printf("%s total's time is %.10f\n", alg3, total3);
        StdOut.printf("For %d random Doubles\n%s is", n1, alg1);
        StdOut.printf(" %.10f times faster than %s\n", total2 / total1, alg2);
    }
}
