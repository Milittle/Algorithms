package com.mizeshuang.main;

import java.util.Comparator;

/**
 * Created by mizeshuang on 2016/4/29.
 */
public class Shell {
    public static void sorted(Comparable[] comparables) {
        //将comparables数组做一个升序处理
        int N = comparables.length;
        int h=1;
        while (h < N / 3) {
            h = 3 * h + 1;
        }
        while (h >= 1) {
            for (int i = h; i < N; i++) {
                for (int j = i; j >= h&&less(comparables[j],comparables[j-h]); j -= h) {
                    exchange(comparables,j,j-h);
                }
            }
            h = h / 3;
        }
    }

    public static boolean less(Comparable v, Comparable w) {
        return v.compareTo(w)<0;
    }

    public static void exchange(Comparable[]comparables, int i, int j) {
        Comparable temp;
        temp = comparables[i];
        comparables[i] = comparables[j];
        comparables[j] = temp;
    }

    public static boolean isSorted(Comparable[]comparables) {
        for (int i = 1; i < comparables.length; i++) {
            if(less(comparables[i],comparables[i-1])) return false;
        }
        return true;
    }

    public static void show(Comparable[] comparables) {
        for (Comparable i : comparables) {
            System.out.println(i);
        }
    }

    public static void main(String[] args) {
        Shell test = new Shell();
        Integer[] a = {8, 9, 6, 3, 2, 5, 4, 1, 7};
        sorted(a);
        assert isSorted(a);
        show(a);
    }
}
