package LinkedList;

import java.util.HashSet;

public class ReverseList {

    static class Node{
        int data;
        Node next;

        public Node(int data) {
            this.data = data;
        }

    }
    public static Node reverse(Node head,int k){
        if (head == null)
            return null;
        Node current = head;
        Node next = null;
        Node prev = null;
        int count = 0;
        while (count < k && current != null){
            next = current.next;
            current.next = prev;
            prev = current;
            current = next;
            count++;
        }
        if (next!=null){
            head.next = reverse(next,k);
        }
        return prev;
    }

    public static void main(String[] args) {
        Node head = new Node(2);
        head.next = new Node(3);
        head.next.next = new Node(4);
        head.next.next.next = new Node(5);
        head.next.next.next.next = head.next.next;
        Node t = head;
        if(!isCycleExist(head)) {
            while (t != null) {
                System.out.print(t.data + " ");
                t = t.next;
            }
        }else{
            deletLoop(head);
            while (t != null) {
                System.out.print(t.data + " ");
                t = t.next;
            }
        }




//        Node head2 = reverse(head,3);
//        reverse(head);
//        while (head2 != null){
//            System.out.print(head2.data+" ");
//            head2 = head2.next;
//        }
    }

    private static void deletLoop(Node head2) {
        Node head = head2;
        HashSet<Node> s = new HashSet<>();
        Node prev = null;
        while(head != null){
            if(s.contains(head))
                prev.next = null;
            s.add(head);
            prev = head;
            head = head.next;
        }
    }

    private static boolean isCycleExist(Node head2) {
        Node head = head2;
        HashSet<Node> s = new HashSet<>();
        while(head != null){
            if(s.contains(head))
                return true;
            s.add(head);
            head = head.next;
        }
        return false;
    }
}
