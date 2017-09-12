package com.mizeshuang.main;

import java.util.Iterator;

/**
 * Created by mizeshuang on 2016/4/4.
 */
/*
* 数组
* */
public class ResizingArrayStack<Item>implements Iterable<Item> {
    @Override
    public Iterator<Item> iterator() {
        return new ReverseArrayIterator();
    }

    private Item[]items;
    private int N=0;
    public ResizingArrayStack(int cap) {
        items=(Item[])new Object[cap];
    }

    private void resize(int max) {
        Item[] temp=(Item[])new Object[max];
        for (int i = 0; i < N; i++) {
            temp[i]=items[i];
        }
        items=temp;
    }

    public void push(Item item) {
        if(N==items.length) resize(2*items.length);
        items[N++] = item;
    }

    public Item pop() throws ArrayIndexOutOfBoundsException {
        Item item=items[--N];
        items[N]=null;//避免对象游离，也就是在内存中占用地方，而不释放不用的空间
        if(N>0&&N==items.length/4) resize(items.length/2);
        return item;
    }
    public boolean isEmpty() {
        return N==0;
    }
    public int size() {
        return N;
    }
    private class ReverseArrayIterator implements Iterator<Item>{
        private int i=N;
        @Override
        public void remove() {

        }

        @Override
        public Item next() {
            return items[--i];
        }

        @Override
        public boolean hasNext() {
            return i>0;
        }
    }
}
