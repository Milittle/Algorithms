package com.mizeshuang;

import java.util.ArrayList;

/**
 * Created by mizeshuang on 2016/3/13.
 */
/*
* 米泽双的Math库，初期只能支持int的数组，后续将继续进行扩充
* */
public class MyMath {

    /*欧几里得求最大公约数*/
    public static int gcd(int p,int q){
        if(q==0) return p;
        int temp=p%q;
        return gcd(q,temp);
    }

    /*将一个int转化为二进制字符串*/
    public static String toBinary(int n){
        String binary="";
        for(int i=n;i>0;i/=2){
            binary=i%2+binary;
        }
        return binary;
    }

    /*讲一个int转换为指定进制的数*/
    public static String to(int n, int ary) {
        String t="";
        for (int i = n; i > 0; i /= ary) {
            t = i % ary + t;
        }
        return t;
    }

    /*矩阵的逆*/
    public static void transposition(int[][]n){
        for(int i=0;i<n.length;i++){
            for(int j=i;j<n[i].length;j++){
                int tmp=n[i][j];
                n[i][j]=n[j][i];
                n[j][i]=tmp;
            }
        }
    }

    /*二分查找，前提是该数组是有序的，所以先要进行排序*/
    public static int binarySearch(int[]a,int key){
        int lo=0;
        int hi=a.length;
        while (lo <= hi) {
            int mid=lo+(hi-lo)/2;
            if (a[mid]>key) hi=mid-1;
            else if(a[mid]<key) lo=mid+1;
            else
                return mid;
        }
        return -1;
    }
    /*直接插入排序，每次比较的次数较多*/
    public static void insertSort(int[]array){
        int temp;
        int i,j;
        for(i=1;i<=array.length-1;i++){
            temp=array[i];
            j=i-1;
            while ((j >= 0) && array[j] > temp) {
                array[j+1]=array[j];
                j--;
            }
            array[j+1]=temp;
        }
    }
    /*BinInsertSort()实现，查找的时候用的是二分法查找法*/
    public static void binInsertSort(int[]array){
        int key,left,right,middle;
        for(int i=1;i<array.length-1;i++){
            key=array[i];
            left=0;
            right=i-1;

            while (left <=right) {
                middle=(left+right)/2;
                if (array[middle] > key) {
                    right=middle-1;
                }
                else
                    left=middle+1;
            }
            for (int j = i - 1; j >= left; j--) {
                array[j+1]=array[j];
            }
            array[left]=key;
        }
    }
    /*QuickSort()实现*/
    /*左右各一次做排序，将数组分为两个独立的数组，相当于一部分总是都大于(小于)另一部分，然后迭代下去*/
    public static void quickSort(int[] a, int left, int right) {
        int temp,i,j;
        if (left < right) {
            i=left;
            j=right;
            temp=a[i];
            do {
                while (a[j] > temp && i < j) {
                    j--;
                }
                if (i < j) {
                    a[i] = a[j];
                    i++;
                }
                while (a[i] < temp && i < j) {
                    i++;
                }
                if (i < j) {
                    a[j] = a[i];
                    j--;
                }
            } while (i != j);
            a[i]=temp;
            quickSort(a, left, i - 1);
            quickSort(a, j + 1, right);
        }
    }
    /*HeapSort()排序*/
    /*进行排序，将堆顶的东西取走以后，再进行0-i的堆调整，i是实时变化的*/
    public static void heapSort(int[] a) {
        buildHeap(a);
        int temp;
        for (int i = a.length - 1; i >= 0; i--) {
            temp=a[0];
            a[0]=a[i];
            a[i]=temp;
            heapAdjust(a,0,i);
        }
    }
    /*用于HeapSort()*/
    /*建堆的过程*/
    /*其实原理就是进行堆调整结果*/
    private static void buildHeap(int[] a) {
        for(int i = (a.length-2)/2; i >= 0; i--)
        {
            heapAdjust(a, i, a.length);
        }
    }
    /*用于HeapSort()进行对调整的函数，每次就一个顶点进行调整*/
    private static void heapAdjust(int[] a, int i,int heapSize) {
        int l= left(i);
        int r= right(i);
        int largest;
        int temp;
        //这里判断有没有比较的必要，因为如果是叶子节点的话，就没有比较的必要，而且数组也会越界
        if (l < heapSize && a[l] > a[i]) {
            largest=l;
        }
        else{
            largest=i;
        }
        //和上面类似的
        if (r < heapSize && a[r] > a[largest]) {
            largest = r;
        }
        if (largest != i) {
            temp=a[i];
            a[i]=a[largest];
            a[largest]=temp;
            //关键的一步
            heapAdjust(a, largest, heapSize);
        }
    }
    /*用于HeapSort()当前结点的父节点的索引*/
    private static int parent(int i) {
        return (int)Math.floor((i-1)/2);
    }
    /*用于HeapSort()当前结点的左孩子的索引*/
    private static int left(int i) {
        return 2*i+1;
    }
    /*用于HeapSort()当前结点的右孩子的索引*/
    private static int right(int i) {
        return 2*i+2;
    }

    /*用于求一个数是不是另一个数的幂*/
    public static boolean isPower(int baseNum, int powerNum) {
        boolean result = false;
        if (powerNum <= 0 || powerNum % baseNum != 0)
            return false;
        if (powerNum / baseNum > 1) {
            result = isPower(baseNum, powerNum / baseNum);
        } else {
            result = true;
        }
        return result;
    }

    public static double log(double value, double base) {
        return Math.log(value) / Math.log(base);
    }

    public static ArrayList<Integer> getCountBits(int n) {
        int temp;
        ArrayList<Integer> arrayList = new ArrayList<Integer>();
        arrayList.add(0);
        for (int i = 1; i <= n; i++) {
            if (log(i, 2) % 2 == 0) {
                arrayList.add(1);
            } else {
                temp=(int)(i - Math.pow(2, Math.floor(log(i, 2))));
                arrayList.add(arrayList.get(temp)+1);
            }
        }
        return arrayList;
    }

    public static int[] getCount(int n) {
        int[] list;
        ArrayList<Integer> arrayList = new ArrayList<Integer>();
        arrayList.add(0);
        for (int i = 1; i <= n; i++) {
            arrayList.add(arrayList.get(i & (i - 1)) + 1);
        }
        list = new int[arrayList.size()];
        for (int i = 0; i < list.length; i++) {
            list[i] = arrayList.get(i);
        }
        return list;
    }

    public static boolean canWinNim(int n) {
        if(n%4==0) return false;
        return true;
    }

    public static String reverseString(String s) {
        StringBuffer temp = new StringBuffer(s);
        temp.reverse();
        return temp.toString();
    }

    public static void main(String[] args) {
        String t = "mizeshuang";
        System.out.println(reverseString(t));
    }
}
