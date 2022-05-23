package LinkedList;

import java.util.HashSet;
import java.util.LinkedList;

public class LinkedListNode {
    private static LinkedListNode next = null;
    private int data;

    public LinkedListNode(int data) {
        this.data = data;
    }
    public LinkedListNode() { }

    public static void main(String[] args) {
        LinkedListNode n = new LinkedListNode();
        AddNode(5);
        dispalay();
       // deleteDups();
    }

    public static void AddNode(int d){
        LinkedListNode end = new LinkedListNode(d);
        LinkedListNode n = new LinkedListNode();

        while (n.next != null){
            n = n.next;
        }
        n.next = end;
    }

    public static void dispalay(){
        LinkedListNode node = new LinkedListNode();
        while (node != null){
            node = node.next;
        }
        System.out.printf("%d ",node.data);
    }

    public static void deleteDups(LinkedListNode n){
        HashSet<Integer> set = new HashSet<>();

        LinkedListNode previous = null;
        LinkedListNode next = null;
        int data = 0;

        while (n != null){
            if (set.contains(n.data)){
                previous.next = n.next;
                previous = n;
            }else {
                set.add(n.data);
                previous = n;
            }
            n = n.next;
        }

    }

}
