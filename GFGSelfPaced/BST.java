package GFGSelfPaced;

import java.util.*;

class Pair{
    Node node;
    int hd;
      Pair(Node n,int h){
        node = n;
        hd = h;
    }
}
/*
               10
             /    \
            5     15
          /  \   /  \
         3    6 14   20
*/

public class BST {
    public static void main(String[] args) {

    }

    void veticalOrder(Node root){
        Queue<Pair> q = new LinkedList<>();
        Map<Integer,ArrayList<Integer>> map = new TreeMap<>();
        q.add(new Pair(root,0));
        while (!q.isEmpty()){
            Pair p = q.poll();
            Node curr = p.node;
            int hd = p.hd;
            if (map.containsKey(hd)){
                //For vertical view of a tree,we can ignore if it already present.
                map.get(hd).add(curr.key);
            }else {
                ArrayList<Integer> al = new ArrayList<>();
                al.add(curr.key);
                map.put(hd,al);
            }
            if (curr.left!=null){
                q.add(new Pair(curr.left,hd-1));
            }
            if (curr.right!=null){
                q.add(new Pair(curr.right,hd+1));
            }
            //Printing element from map
            for (Map.Entry<Integer,ArrayList<Integer>> mp : map.entrySet()) {
                ArrayList<Integer> al = mp.getValue();
                for (int x : al)
                    System.out.println(x+" ");
                System.out.println();
            }
        }
    }
    void vertSum(Node root, int hd, TreeMap<Integer, Integer> map) {
        if (root == null)
            return;
        vertSum(root.left, hd - 1, map);
        int psum = (map.get(hd) == null) ? 0 : map.get(hd);
        map.put(hd, psum + root.key);
        vertSum(root.right, hd + 1, map);
    }

    void vsum(Node root) {
        TreeMap<Integer, Integer> map = new TreeMap<>();
        vertSum(root, 0, map);
        for (Map.Entry sum : map.entrySet()) {
            System.out.print(sum);
        }
    }


    boolean isPairSum(Node root, int sum, HashSet<Integer> set) {
        if (root == null)
            return false;
        if (isPairSum(root.left, sum, set))
            return true;
        if (set.contains(sum - root.key))
            return true;
        else
            set.add(root.key);
        return isPairSum(root.right, sum, set);
    }

    void fixBST(Node root) {
        //this code would not swapped the data,rather it would identifying.

        Node first = null, second = null, prev = null;
        if (root == null)
            return;
        fixBST(root.left);
        if (prev != null && root.key < prev.key) {
            if (first == null)
                first = prev;
            second = root;
        }
        prev = root;
        fixBST(root.right);
    }

    boolean checkBST(Node root, int min, int max) {
        /*
               10
             /    \
            5     15
          /  \   /  \
         3    6 14   20
         */
        // min = Integer.MIN_VALUE;
        //max = Integer.MAX_VALUE;
        if (root == null)
            return true;
        return (root.key > min && root.key < max &&
                checkBST(root.left, min, root.key) &&
                checkBST(root.right, root.key, max));
    }

    void kthSmallest(Node root, int k) {
        int count = 0;
        if (root != null) {
            kthSmallest(root.left, k);
            count++;
            if (count == k) {
                System.out.println(root.key + " ");
                return;
            }
            kthSmallest(root.right, k);
        }
    }

    void leftCeiling(int[] arr) {
        int n = arr.length;
        System.out.print(-1);
        TreeSet<Integer> s = new TreeSet<>(); // Self balancing BST.
        s.add(arr[0]);
        for (int i = 1; i < n; i++) {
            if (s.contains(s.ceiling(arr[i])))
                System.out.print(arr[i]);
            else
                System.out.print(-1);
            s.add(arr[i]);
        }
    }

    Node delete(Node root, int x) {
        if (root == null)
            return null;
        if (root.key > x)
            root.left = delete(root.left, x);
        else if (root.key < x)
            root.right = delete(root.right, x);
        else {
            if (root.left == null)
                return root.right;
            else if (root.right == null)
                return root.left;
            else {
                Node succ = getSucc(root);
                root.key = succ.key;
                root.right = delete(root.right, succ.key);
            }
        }
        return root;
    }

    Node getSucc(Node root) {
        Node curr = root.right;
        while (curr != null && curr.left != null) {
            curr = curr.left;
        }
        return curr;
    }

    Node insertEff(Node root, int x) {
        Node t = new Node(x);
        Node parent = null, curr = root;
        while (curr != null) {
            parent = curr;
            if (curr.key > x)
                curr = curr.left;
            else if (curr.key < x)
                curr = curr.right;
            else
                return root;

        }
        if (parent == null) {
            return t;
        }
        if (root.key > x)
            parent.left = t;
        else
            parent.right = t;
        return root;
    }

    Node insertItrtv(Node root, int x) {
        if (root == null)
            return new Node(x);
        if (root.key > x)
            root.left.key = x;
        else
            root.right.key = x;
        return root;
    }

    Node insert(Node root, int x) {
        if (root == null)
            return new Node(x);
        if (root.key > x)
            root.left = insert(root, x);
        else
            root.right = insert(root, x);
        return root;
    }

    boolean search(Node root, int x) {
        if (root == null)
            return false;
        if (root.key == x)
            return true;
        else if (root.key < x)
            root = root.right;
        else
            root = root.left;
        return false;
    }
}
