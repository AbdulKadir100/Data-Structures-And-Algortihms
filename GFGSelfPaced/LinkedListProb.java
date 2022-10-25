package GFGSelfPaced;

import java.util.ArrayList;
import java.util.HashSet;

import static GFGSelfPaced.Sorting.swap;

class LinkNode {
    int data;
    LinkNode next;

    LinkNode(int x) {
        data = x;
    }

    public LinkNode() {

    }

    public LinkNode(int i, LinkNode head) {
        data = i;
        next = head;
    }
}

class DoubleList {
    int data;
    DoubleList next;
    DoubleList prev;

    public DoubleList(int d) {
        data = d;
    }

    public static DoubleList delLast(DoubleList head) {
        if (head == null)
            return null;
        if (head.next == null)
            return null;
        DoubleList curr = head;
        while (curr.next != null) {
            curr = curr.next;
        }
        curr.prev.next = null;
        return head;
    }

    public static DoubleList delHead(DoubleList head) {
        if (head == null || head.next == null)
            return null;
        else {
            head = head.next;
            head.prev = null;
        }
        return head;
    }

    public static DoubleList reverseDLL(DoubleList head) {
        if (head == null || head.next == null)
            return head;
        DoubleList prevs = null, curr = head;
        while (curr != null) {
            //Swapping the nodes.
            prevs = curr.prev;
            curr.prev = curr.next;
            curr.next = prevs;
            curr = curr.prev;
        }
        return prevs.prev;
    }

    public static DoubleList insertEnd(DoubleList head, int data) {
        DoubleList temp = new DoubleList(data);
        if (head == null)
            return temp;
        DoubleList curr = head;
        while (curr.next != null) {
            curr = curr.next;
        }
        curr.next = temp;
        temp.prev = curr;
        return head;
    }

    public static DoubleList insetHead(DoubleList head, int data) {
        DoubleList temp = new DoubleList(data);
        temp.next = head.prev;
        if (head != null)
            head.prev = temp;

        return temp;
    }
}

public class LinkedListProb {
    public static void main(String[] args) {

    }
    //Circular LinkedList

    public void treavse(LinkNode head) {
        if (head == null)
            return;
        System.out.println(head.data);
        for (LinkNode r = head.next; r != head; r = r.next) {
            System.out.println(r.data + " ");
        }
    }

    //Singly LinkedList
    private LinkNode reverseKGroup(LinkNode head, int k) {
        if(head == null || head.next == null || k == 1) return head;
        LinkNode counter = head ;
        int count = 0 ;
        while(counter != null){
            count = count + 1;
            counter = counter.next;
        }

        LinkNode cur = head , nxt = cur.next;
        LinkNode dummy = new LinkNode(0,head);
        LinkNode pre = dummy;
        while(count >=  k){
            for(int i=1 ; i<k ;i++){
                cur.next = nxt.next;
                nxt.next = pre.next;
                pre.next = nxt;
                nxt = cur.next;
            }
            count = count - k;
            pre = cur;

            cur = cur.next;
            if(cur != null)
            {
                nxt = cur.next;
            }
        }

        return dummy.next;
    }
    private LinkNode sumOfTwoList(LinkNode l1,LinkNode l2){
        LinkNode dummy = new LinkNode();
        LinkNode temp = dummy;
        int carry=0;
        while (l1!=null || l2!=null || carry==1){
            int sum=0;
            if (l1!=null){
                sum+= l1.data;
                l1 = l1.next;
            }
            if (l2!=null){
                sum+=l2.data;
                l2 = l2.next;
            }
            sum+=carry;
            carry = sum/10;
            LinkNode node = new LinkNode(sum%10);
            temp.next = node;
            temp = temp.next;
        }
        return dummy.next;
    }
    private void deleteNodeList(LinkNode node){
        /*
        Basically we not given access to head of list
        TC -> O(1)
        SC -> O(1)
         */
        node.data = node.next.data;
        node.next = node.next.next;
    }
    private LinkNode mergeTwoSortedList(LinkNode l1,LinkNode l2){
        /*
        It works for two different length of list
        TC -> O(N)
        SC -> O(N)
        */
        if (l1 == null) return l2;
        if (l2 == null) return l1;

        if (l1.data > l2.data) swap(l1,l2); //swap


        LinkNode res = l1;
        while (l1 != null && l2 != null){
            LinkNode tmp = null;
            while (l1 != null && l1.data <= l2.data){
                 tmp = l1;
                 l1 = l1.next;
            }
            tmp.next = l2;

            //swap
            swap(l1,l2);

        }
        return res;
    }
    private LinkNode midOfList(LinkNode head){
        /*
        Two Pointer or Tortus approach
        TC -> O(N/2)
        SC -> O(1)

        2nd Approach is to count all node and take mid add onto it.
        n = total nodes
        mid = (n/2)
        return mid+1;
        TC -> O(N) + O(N/2)
        SC -> O(1)
         */
        if(head.next == null) return head;

        LinkNode slow = head,fast = head;
        while (fast!=null && fast.next!=null){
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;

    }
    private LinkNode deleteNodePointerGiven(LinkNode head,int n){
        LinkNode curr = new LinkNode();
        curr.next = head;
        LinkNode slow = curr,fast = curr;
        for (int i = 1; i <= n ; ++i) {
            fast = fast.next;
        }
        //Edge Case
        if (fast == head)
            return head;

        //this loop is for slow pointer to reach exact node
        while (fast.next != null){
            slow = slow.next;
            fast = fast.next;
        }
        slow.next = slow.next.next;
        return head;

    }
    private LinkNode reverseListEff(LinkNode head) {
        // Reversing start to end whole list

        LinkNode newHead = null;
        while (head != null) {
            LinkNode next = head.next;
            head.next = newHead;
            newHead = head;
            head = next;
        }
        return newHead;
    }
    private void swap(LinkNode l1,LinkNode l2){
        LinkNode temp = l1;
        l1 = l2;
        l2 = temp;
    }
    public int intersectionPointOfTwoList(LinkNode l1,LinkNode l2){
        int c1=0,c2=0;
        LinkNode curr1=l1,curr2=l2;
        while (curr1!=null){
            c1++;
            curr1 = curr1.next;
        }
        while (curr2!=null){
            c2++;
            curr2 = curr2.next;
        }
        int d = Math.abs(c1-c2);
        while (curr1!=null && curr2!=null){
            if(curr1==curr2)
                return curr1.data;
            curr1 = curr1.next;
            curr2 = curr2.next;

        }
        return -1;
    }

    public LinkNode deleteDuplicates(LinkNode head) {
        if(head==null){
            return null;
        }
        LinkNode cur = head;
        while(cur.next != null){
            if(cur.data == cur.next.data){
                cur.next = cur.next.next;
            }else{
                cur = cur.next;
            }
        }
        return head;
    }

    public LinkNode MergesortList(LinkNode head) {
        if (head == null || head.next == null)
            return head;
        LinkNode mid = getMid(head);
        LinkNode left = MergesortList(head);
        LinkNode right = MergesortList(mid);
        return merge(left, right);
    }

    LinkNode merge(LinkNode list1, LinkNode list2) {
        LinkNode dummyHead = new LinkNode();
        LinkNode tail = dummyHead;
        while (list1 != null && list2 != null) {
            if (list1.data < list2.data) {
                tail.next = list1;
                list1 = list1.next;
                tail = tail.next;
            } else {
                tail.next = list2;
                list2 = list2.next;
                tail = tail.next;
            }
        }
        tail.next = (list1 != null) ? list1 : list2;
        return dummyHead.next;
    }

    LinkNode getMid(LinkNode head) {
        //We could use two pointer approach
        LinkNode midPrev = null;
        while (head != null && head.next != null) {
            midPrev = (midPrev == null) ? head : midPrev.next;
            head = head.next.next;
        }
        LinkNode mid = midPrev.next;
        midPrev.next = null;
        return mid;
    }

    LinkNode insertionSort(LinkNode head){
        LinkNode curr = head, next = null;
        // l is a fake head
        LinkNode l = new LinkNode(0);

        while (curr != null) {
            next = curr.next;

            LinkNode p = l;
            while (p.next != null && p.next.data < curr.data)
                p = p.next;

            // insert curr between p and p.next
            curr.next = p.next;
            p.next = curr;
            curr = next;
        }

        return l.next;
    }

    LinkNode pairswap(LinkNode head){
        if(head==null)
            return null;
        if (head.next==null)
            return head;
        LinkNode cur = head;
        while (cur!=null && cur.next!=null){
          //  swap(cur.data,cur.next.data);
            cur = cur.next.next;
        }
        return head;
    }
    LinkNode segregateList(LinkNode head){
        /*
        Segregate Even and Odd in the LinkedList.
        Just one traversal is needed.
        es = Even Start
        eE = Even End
        oS = Odd Start
        oE = Odd End
         */
        LinkNode es=null,eE=null,oS=null,oE=null;
        for(LinkNode curr = head;curr!=null;curr=curr.next){
            int x = curr.data;
            if (x%2==0){
                if (es==null){
                    es=curr;
                    eE = es;
                }else {
                    eE.next = curr;
                    eE = eE.next;
                }
            }else {
                if (oS==null){
                    oS=curr;
                    oE = oS;
                }else {
                    oE.next = curr;
                    oE = oE.next;
                }
            }
        }
        if (oS==null || es==null){
            return head;
        }
        eE.next = oS;
        oE.next = null;
        return es;
    }
    void detectAndRemovLoop(LinkNode head){
        LinkNode slow=head,fast=head;
        while (slow!=null && fast.next==null){
            slow = slow.next;
            fast = fast.next.next;
            if (slow==fast)
                break;
        }
        if (slow!=fast)
            return;
        slow=head;
        while (slow.next!=fast.next){
            slow = slow.next;
            fast = fast.next;
        }
        fast.next=null;
    }
    boolean isLoopEff(LinkNode head) {
        /*
        Floyd's Cycle Detection.
        This algo used two ref fast and slow, slow inc by one fast inc by two.
        If both they meet there is a cycle else not.
        exp:  1->2->3->4->5->6
              s        ^     |
              f        |_____|
         */
        LinkNode slow = head, fast = head;
        while (slow != null && fast != null && fast.next != null) {
            slow = slow.next;
            fast=fast.next.next;
            if (slow==fast)
                return true;
        }
        return false;
    }

    boolean isLoop(LinkNode had) {
        // O(N) time,O(N) space
        HashSet<LinkNode> s = new HashSet<>();
        for (LinkNode curr = had; curr != null; curr = curr.next) {
            if (s.contains(curr))
                return true;
            s.add(curr);
        }
        return false;
    }

    LinkNode reverseRecurList(LinkNode head) {
        if (head == null || head.next == null)
            return head;
        LinkNode restTail = reverseRecurList(head.next);
        restTail.next = head;
        head.next = null;
        return restTail;
    }
    LinkNode reverseListEffUptoK(LinkNode head,int k) {
    // Reversing list upto k elements,if less then k reverse them too.

        LinkNode curr = head;
        LinkNode prev = null;
        int count=0;
        while (curr != null && count<k) {
            LinkNode next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
            count++;
        }
        if (curr!=null)
            head.next = reverseListEffUptoK(head,k);
        return prev;
    }


    public LinkNode reverseList(LinkNode head) {
        /*
        Not a efficient sol coz required two traversal
        and extra space aux space.
        */
        ArrayList<Integer> list = new ArrayList<>();
        for (LinkNode curr = head; curr != null; curr = curr.next) {
            list.add(curr.data);
        }
        for (LinkNode curr = head; curr != null; curr = curr.next) {
            curr.data = list.remove(list.size() - 1);
        }
        return head;
    }

    public void printMiddle(LinkNode head) {
        if (head == null)
            return;
        LinkNode slow = head, fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        System.out.println(slow.data);
    }

    LinkNode insertSorted(LinkNode head, int x) {
        LinkNode temp = new LinkNode(x);
        if (head == null)
            return temp;
        if (x < head.data) {
            temp.next = head;
            return temp;
        }
        LinkNode curr = head;
        while (curr.next != null && x > curr.next.data) {
            curr = curr.next;
        }
        temp.next = curr.next;
        curr.next = temp;
        return head;
    }

    int search(LinkNode head, int x) {
        int pos = 1;
        LinkNode curr = head;
        while (curr != null) {
            if (curr.data == x) {
                return pos;
            } else {
                pos++;
                curr = curr.next;
            }
        }
        return -1;
    }

    int recurSearch(LinkNode head, int x) {
        if (head == null)
            return -1;
        if (head.data == x)
            return 1;
        else {
            int res = recurSearch(head.next, x);
            if (res == -1)
                return -1;
            return res + 1;
        }
    }

    LinkNode insertPos(LinkNode head, int pos, int data) {
        LinkNode temp = new LinkNode(data);
        if (pos == 1) {
            temp.next = head;
            return temp;
        }
        LinkNode curr = head;
        for (int i = 1; i <= pos - 2 && curr != null; i++) {
            curr = curr.next;
        }
        if (curr == null)
            return head;
        //Connecting Node to their response.
        temp.next = curr.next;
        curr.next = temp;
        return head;
    }

    LinkNode removeNthFromEnd(LinkNode head, int n) {
        LinkNode cur = head;
        int count = 0;
        if (head.next == null && n == 1)
            return head;
        while (n > 1) {
            cur = cur.next;
            n--;
        }
        cur.next = cur.next.next;
        return cur;
    }
    public void deleteNode(LinkNode head) {
        if (head == null)
            return;
        if (head.next == null)
            return;
        LinkNode curr = head;
        curr.next = null;
    }
    LinkNode delNode(LinkNode head) {
        if (head == null)
            return null;
        if (head.next == null)
            return null;
        LinkNode curr = head;
        while (curr.next.next != null)
            curr = curr.next;
        curr.next = null;
        return head;
    }

    static LinkNode delHead(LinkNode head) {
        if (head == null)
            return null;
        return head.next;
    }

    static LinkNode insertEnd(LinkNode head, int x) {

        LinkNode temp = new LinkNode(x);
        if (head == null)
            return temp;

        LinkNode cur = head;
        while (cur.next != null) {
            cur = cur.next;
        }
        cur.next = temp;
        return head;
    }

    static LinkNode insertBegin(LinkNode head, int x) {
        LinkNode cur = new LinkNode(x);
        cur.next = head;
        return head;
    }

    public void printList(LinkNode head) {
        LinkNode curr = head;
        while (curr != null) {
            System.out.println(curr.data + " ");
            curr = curr.next;
        }
    }
}
