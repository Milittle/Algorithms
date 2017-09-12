package com.mizeshuang.main;


import edu.princeton.cs.algs4.StdOut;

/**
 * Created by mizeshuang on 2016/4/29.
 */
public class Insertion {
    public static void sorted(Comparable[] comparables) {
        int N = comparables.length;
        for (int i = 1; i < N; i++) {
            for (int j = i; j > 0 && less(comparables[j], comparables[j-1]); j--) {
                exchange(comparables,j,j-1);
            }
        }
    }

    public static boolean less(Comparable v, Comparable w) {
        return v.compareTo(w) < 0;
    }

    public static void exchange(Comparable[] comparables, int i, int j) {
        Comparable temp;
        temp = comparables[i];
        comparables[i] = comparables[j];
        comparables[j] = temp;
    }

    public static void show(Comparable[] comparables) {
        StdOut.println("输出元素：");
        for (Comparable i : comparables) {
            StdOut.println(i);
        }
    }

    public static boolean isSorted(Comparable[] comparables) {
        for (int i = 1; i < comparables.length; i++) {
            if (less(comparables[i], comparables[i - 1])) {
                return false;
            }
        }
        return true;
    }

    public static  void main(String[] args) {
        Integer[] a = {5, 9, 8, 6, 3, 4, 7, 1, 2, 2};
        sorted(a);
        assert isSorted(a);
        show(a);
    }
}
