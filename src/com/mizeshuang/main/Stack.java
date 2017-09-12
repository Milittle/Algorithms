package com.mizeshuang.main;

import java.util.Iterator;

/**
 * Created by mizeshuang on 2016/4/5.
 */
public class Stack<Item>implements Iterable<Item> {
    @Override
    public Iterator<Item> iterator() {
        return new ListIterator();
    }
    private Node first;
    private int N=0;
    private class Node{
        Item item;
        Node next;
    }
    public boolean isEmpty() {
        return first == null;
    }
    public int size(){
        return N;
    }

    public void push(Item item) {
        Node oldNode=first;
        first=new Node();
        first.item=item;
        first.next=oldNode;
        N++;
    }
    public Item pop() {
        Node oldNode=new Node();
        oldNode=first;
        first=first.next;
        N--;
        return oldNode.item;
    }
    public Item peek() {
        return first.item;
    }
    private class ListIterator implements Iterator<Item>{
        private Node i=first;
        private int temp=N;
        @Override
        public Item next() {
            Node j=i;
            i=i.next;
            return j.item;
        }

        @Override
        public boolean hasNext() {
            temp--;
            return temp!=-1;
        }

        @Override
        public void remove() {

        }
    }
}
