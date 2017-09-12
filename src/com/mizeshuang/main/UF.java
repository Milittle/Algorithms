package com.mizeshuang.main;

import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

/**
 * Created by mizeshuang on 2016/4/27.
 */
/*union-find*/
public class UF {
    private int[] id;
    private int count;

    public UF(int N) {
        count=N;
        id = new int[count];
        for (int i = 0; i < count; i++) {
            id[i]=i;
        }
    }

    public void union(int p, int q) {
        int pID=find(p);
        int qID = find(q);
        if (pID == qID) {
            return;
        }
        for (int i = 0; i < count; i++) {
            if (id[i]==pID) id[i] = qID;
        }
        count--;
    }

    public int find(int p) {
        return id[p];
    }

    public boolean connected(int p, int q) {
        return find(p)==find(q);
    }

    public int count() {
        return count;
    }
    public void out() {
        for (int i = 0; i < id.length; i++) {
            StdOut.println(i+"\t"+id[i]);
        }
    }

    public static void main(String[] args) {
        UF test = new UF(10);
        while (!StdIn.isEmpty()) {
            int a = StdIn.readInt();
            int b = StdIn.readInt();
            if (test.connected(a, b)) continue;
            test.union(a,b);
            StdOut.println(a + "   " + b);
        }
        test.out();
        StdOut.println(test.count());
    }
}
