package com.mizeshuang.main;

import java.util.Iterator;

/**
 * Created by mizeshuang on 2016/4/5.
 */
public class Bag<Item> implements Iterable<Item> {
    @Override
    public Iterator<Item> iterator() {
        return new BagIterator();
    }
    private Node first=null;
    private int N=0;
    private class Node{
        Item item;
        Node next;
    }

    public void add(Item item) {
        Node oldNode=first;
        first=new Node();
        first.item=item;
        first.next=oldNode;
        N++;
    }
    public boolean isEmpty() {
        return false;
    }
    public int size() {
        return N;
    }

    private class BagIterator implements Iterator<Item> {
        private Node current=first;
        @Override
        public void remove() {

        }

        @Override
        public Item next() {
            Item item = current.item;
            current=current.next;
            return item;
        }

        @Override
        public boolean hasNext() {
            return current!=null;
        }
    }
}
