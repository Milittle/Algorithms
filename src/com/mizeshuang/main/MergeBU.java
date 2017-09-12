package com.mizeshuang.main;

/**
 * Created by mizeshuang on 2016/4/30.
 */
public class MergeBU {
    private static Comparable[] aux;

    public static void sort(Comparable[] comparables) {
        int N = comparables.length;
        aux = new Comparable[N];
        for (int sz = 1; sz < N; sz = sz + sz) {
            for (int lo = 0; lo < N - sz; lo += sz + sz) {
                merge(comparables, lo, lo + sz - 1, Math.min(lo + sz + sz - 1, N - 1));
            }
        }
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
        Integer[] a = {8, 10, 6, 5, 4, 2, 3, 1, 7};
        test.sort(a);
        assert isSorted(a);
        show(a);
    }
}
