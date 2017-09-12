package com.mizeshuang.main;

import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

/**
 * Created by mizeshuang on 2016/4/29.
 */
/*quick-union*/
public class UFquick_union {
    private int[] id;
    private int count;
    public UFquick_union(int N) {
        count=N;
        id = new int[count];
        for (int i = 0; i < N; i++) {
            id[i] = i;
        }
    }

    public int count() {
        return count;
    }

    public boolean connected(int p,int q) {
        return find(p)==find(q);
    }

    public int find(int p) {
        while(id[p]!=p) p = id[p];
        return p;
    }

    public void union(int p, int q) {
        int pRoot = find(p);
        int qRoot = find(q);
        if(pRoot==qRoot) return;
        id[pRoot] = qRoot;
        count--;
    }

    public void out() {
        for (int i = 0; i < id.length; i++) {
            StdOut.println(i+"\t"+id[i]);
        }
    }

    public static void main(String[] args) {
        UFquick_union test = new UFquick_union(10);
        while (!StdIn.isEmpty()) {
            int a = StdIn.readInt();
            int b = StdIn.readInt();
            test.union(a, b);
            StdOut.println(a + "\t" + b);
        }
        test.out();
        System.out.println(test.count());
    }
}
