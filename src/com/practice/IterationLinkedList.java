package com.practice;

public class IterationLinkedList<E> {
    public static class LinkedList<E> {
        E val;
        LinkedList<E> next;

        LinkedList() {
        }

        LinkedList(E val) {
            this.val = val;
        }

        LinkedList(E val, LinkedList<E> next) {
            this.val = val;
            this.next = next;
        }
    }

    public static void main(String[] args) {
        LinkedList<String> l = new LinkedList<>("Welcome", new LinkedList<>("To", new LinkedList<>("Java")));
        System.out.println(new IterationLinkedList<String>().findKthElement(l, 3));
    }

    public E findKthElement(LinkedList<E> l, int k){
        int counter = 0;
        LinkedList<E> p = l;
        while(counter<k && null != p){
            p = l.next;
            counter++;
        }
        return p.next.val;
    }
}
