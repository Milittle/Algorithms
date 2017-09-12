package com.mizeshuang.main;

import java.util.Iterator;

/**
 * Created by mizeshuang on 2016/4/5.
 */
public class Queue<Item> implements Iterable<Item> {
    @Override
    public Iterator<Item> iterator() {
        return new QueueIterator();
    }
    private Node first=null;
    private Node last=null;
    private int N=0;
    private class Node {
        Item item;
        Node next;
    }

    public void enqueue(Item item) {
        Node oldNode=last;
        last=new Node();
        last.item=item;
        last.next=null;
        if(isEmpty()) first=last;
        else oldNode.next=last;
        N++;
    }
    public Item dequeue() {
        Node oldNode=first;
        first=first.next;
        N--;
        if(isEmpty()) last=null;
        return oldNode.item;
    }
    public boolean isEmpty() {
        return N==0;
    }
    public int size() {
        return N;
    }

    private class QueueIterator implements Iterator<Item> {
        private Node i=first;
        @Override
        public Item next() {
            Node oldNode=i;
            i=i.next;
            return oldNode.item;
        }

        @Override
        public boolean hasNext() {
            return i!=null;
        }

        @Override
        public void remove() {

        }
    }
}
