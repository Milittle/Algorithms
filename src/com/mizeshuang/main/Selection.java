package com.mizeshuang.main;

import edu.princeton.cs.algs4.StdOut;

/**
 * Created by mizeshuang on 2016/4/29.
 */
public class Selection {
    public static void sort(Comparable[] comparables) {
        int N = comparables.length;
        int min;
        for (int i = 0; i < N; i++) {
            min = i;
            for (int j = i + 1; j < N; j++) {
                if (less(comparables[j],comparables[min])) min = j;
            }
            exchange(comparables, i, min);
        }
    }

    public static boolean less(Comparable v, Comparable w) {
        return v.compareTo(w) < 0;
    }

    public static void exchange(Comparable[] a, int i, int j) {
        Comparable temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }

    public static void show(Comparable[] comparables) {
        StdOut.println("输出元素的值：");
        for (int i = 0; i < comparables.length; i++) {
            StdOut.println("第" + i + "个元素\t" + comparables[i]);
        }
    }

    public static boolean isSorted(Comparable[] comparables) {
        for (int i = 1; i < comparables.length; i++) {
            if(less(comparables[i],comparables[i-1])) return false;
        }
        return true;
    }

    public static void main(String[] args) {
        Integer[] comaprables = {9, 8, 5, 6, 3, 2, 1, 4, 7};
        sort(comaprables);
        assert isSorted(comaprables);
        show(comaprables);
    }
}
