package com.mizeshuang.main;

import java.util.Comparator;

/**
 * created by mizeshuang on 2016/4/30.
 */
/*自顶向下的归并排序*/
public class Merge {
    private static Comparable[] aux;

    public static void sort(Comparable[] comparables) {
        aux = new Comparable[comparables.length];
        sort(comparables, 0, aux.length - 1);
    }

    public static void sort(Comparable[] comparables, int lo, int hi) {
        if (hi <= lo) {
            return;
        }
        int mid = lo + (hi - lo) / 2;
        sort(comparables, lo, mid);
        sort(comparables, mid + 1, hi);
        merge(comparables, lo, mid, hi);
    }

    public static void merge(Comparable[] comparables, int lo, int mid, int hi) {
        int i = lo;
        int j = mid + 1;
        for (int k = lo; k <= hi; k++) {
            aux[k] = comparables[k];
        }

        for (int k = lo; k <= hi; k++) {
            if(i>mid) comparables[k] = aux[j++];
            else if (j > hi) comparables[k] = aux[i++];
            else if (less(aux[j], aux[i])) comparables[k] = aux[j++];
            else comparables[k] = aux[i++];
        }

    }

    public static boolean less(Comparable v, Comparable w) {
        return v.compareTo(w) < 0;
    }

    public static void exchange(Comparable[] comparables, int i, int j) {

    }

    public static void show(Comparable[] comparables) {
        for (Comparable i : comparables) {
            System.out.println(i);
        }
    }

    public static boolean isSorted(Comparable[] comparables) {
        for (int i = 1; i < comparables.length; i++) {
            if(less(comparables[i],comparables[i-1]))
                return false;
        }
        return true;
    }

    public static void main(String[] args) {
        Merge test = new Merge();
        Integer[] a = {8, 11, 6, 5, 4, 2, 3, 1, 7};
        test.sort(a);
        assert isSorted(a);
        show(a);
    }
}
