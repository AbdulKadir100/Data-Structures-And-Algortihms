package GFGSelfPaced;

import java.util.*;
import java.util.LinkedList;
import java.util.Queue;

class Node {
    int key;
    Node left;
    Node right;

    Node(int k) {
        key = k;
    }

    Node(int k, Node l, Node r) {
        this.key = k;
        this.left = l;
        this.right = r;
    }

}

public class Tree {
    Node prev = null;

    public static void main(String[] args) {

    }
    private void predSucessor2(Node root,int key){
        Node predessor = null,successor=null;
        while (root != null){
            if (root.key >= key){
                root = root.left;
            }else {
                predessor = root;
                root = root.right;
            }
            if (root.key <= key){
                root = root.right;
            }else {
                successor = root;
                root = root.left;
            }
        }

        System.out.println(predessor+" "+successor);
    }
    private void predSucessor(Node root,int key){
        Node predessor = null,successor=null;

        List<Node> list = new ArrayList<>();
        if (root!=null){
            predSucessor(root.left, key);
            list.add(root);
            predSucessor(root.right, key);
        }
        if (list.size()== 0)return;

        for(int i=0;i<list.size();i++){
            if (list.get(i).key == key){
                predessor = list.get(i-1);
                successor = list.get(i+1);
                break;
            }
        }
        System.out.println("Predessor is: "+predessor+" Presuccesor is: "+successor);
    }
    private Node predessor(Node root,int key){
        Node predessor = null;
        while (root != null){
            if (root.key >= key){
                root = root.left;
            }else {
                predessor = root;
                root = root.right;
            }
        }
        return predessor;
    }
    private Node successor(Node root,int key){
        Node sucessor = null;
        while (root != null){
            if (root.key <= key){
                root = root.right;
            }else {
                sucessor = root;
                root = root.left;
            }
        }
        return sucessor;
    }
    void mirror(Node root){
        if (root != null) {
            preorder(root.right);
            System.out.print(root.key + " ");
            preorder(root.left);

        }
    }
   
    void itrativeInorder(Node root){
        Stack<Node> s = new Stack<>();
        Node curr = root;
        while (curr!=null || !s.isEmpty()){
            while (curr!=null){
                s.push(curr);
                curr = curr.left;
            }
            s.pop();
            System.out.print(curr.key);
            curr = curr.right;
        }
    }
    int countNode(Node root){
        int lh=0,rh=0;
        Node curr = root;
        while (curr!= null){
            lh++;
            curr = curr.left;
        }
        curr = root;
        while (curr!=null){
            rh++;
            curr = curr.right;
        }
        if (lh==rh){
            return (int) Math.pow(2,lh)-1;
        }
        return 1+countNodes(root.left)+countNodes(root.right);
//        if (lca1!=null && lca2!=null)
//            return root;
//        return (lca1!=null)?lca1:lca2;
    }
    static int daimeterOfTree(Node root){
        if (root==null)
            return 0;

        int d1 =  1+Math.max(heightBinaryTree(root.left),heightBinaryTree(root.right));
        int d2 =  daimeterOfTree(root.left);
        int d3 =  daimeterOfTree(root.right);
        return 1+Math.max(d1,Math.max(d2,d3));

    }
    static List<List<Integer>> printSpiral(Node root) {
     List<List<Integer>> res = new ArrayList<>();
     List<Integer> list = new ArrayList<>();
        if (root == null)
            return new ArrayList<>();
        Queue<Node> q = new LinkedList<>();
        Stack<Integer> s = new Stack<>();
        boolean reverse = false;
        q.add(root);

        while (!q.isEmpty()) {
            int count = q.size();
            for (int i = 0; i < count; i++) {
                Node curr = q.poll();
                if (reverse)
                    s.push(curr.key);
                else {
                    list.add(curr.key);
                    //System.out.print(curr.key + " ");
                }

                if (curr.left != null) {
                    q.add(curr.left);
                }
                if (curr.right != null)
                    q.add(curr.right);
                res.add(list);
            }
            if (reverse){
                while (!s.isEmpty()){
                    //System.out.print(s.pop()+" ");
                    list.add(s.pop());
                }
            }
            reverse = !reverse;

           // System.out.println();

        }
        
        return res;
    }

    public Node constrctTree(int[] in, int[] pre, int is, int ie) {

        int preIndex = 0;
        if (is > ie)
            return null;
        Node root = new Node(pre[preIndex++]);
        int inINdex = 0;
        for (int i = is; i <= ie; i++) {
            if (in[i] == root.key) {
                inINdex = i;
                break;
            }
        }
        root.left = constrctTree(in, pre, is, inINdex - 1);
        root.right = constrctTree(in, pre, inINdex + 1, ie);
        return root;
    }

    public Node btoDlink(Node root) {
        if (root == null)
            return null;
        Node head = btoDlink(root.left);
        if (prev == null) {
            head = root;
        } else {
            root.left = prev;
            prev.right = root;
        }
        prev = root;
        btoDlink(root.right);
        return head;
    }

    public int isBalanceEff(Node root) {
        if (root == null)
            return 0;
        int lh = isBalanceEff(root.left);
        if (lh == -1)
            return -1;
        int rh = isBalanceEff(root.right);
        if (rh == -1)
            return -1;
        if (Math.abs(lh - rh) > 1)
            return -1;
        else
            return Math.max(lh, rh) + 1;

    }

    public static boolean isBalance(Node root) {
        if (root == null)
            return true;
        int hl = heightBinaryTree(root.left);
        int hr = heightBinaryTree(root.right);
        return Math.abs(hl - hr) <= 1 && isBalance(root.left) && isBalance(root.right);
    }

    public boolean isChildSum(Node root) {
        if (root == null)
            return true;
        if (root.left == null && root.right == null)
            return true;
        int sum = 0;
        if (root.left != null) {
            sum += root.left.key;
        }
        if (root.right != null) {
            sum += root.right.key;
        }
        return (root.key == sum && isChildSum(root.left) && isChildSum(root.right));
    }

    static int maxInBT(Node root) {
        return (root != null) ? Math.max(root.key, Math.max(maxInBT(root.left), maxInBT(root.right))) : Integer.MIN_VALUE;
    }

    public int countNodes(Node root) {
        return (root != null) ? 1 + countNodes(root.left) + countNodes(root.right) : 0;
    }

    static void printLeftView(Node root) {
        ArrayList<Integer> list = new ArrayList<>();
        if (root == null)
            return;
        Queue<Node> q = new LinkedList<>();
        q.add(root);

        while (!q.isEmpty()) {
            int count = q.size();
            for (int i = 0; i < count; i++) {
                Node curr = q.poll();
                if (i == 0) {  //For printing right view use i=count-1.
                    list.add(curr.key);
                    //System.out.print(curr.key + " ");
                }
                if (curr.left != null) {
                    q.add(curr.left);
                }
                if (curr.right != null)
                    q.add(curr.right);
            }
        }
    }

    static void levelOrdernewLineEffi(Node root) {

        if (root == null)
            return;
        Queue<Node> q = new LinkedList<>();
        q.add(root);
        int res = Integer.MIN_VALUE;
        while (!q.isEmpty()) {
            int count = q.size();
            res = Math.max(res, count);  // Result contains width of btree.
            for (int i = 0; i < count; i++) {
                Node curr = q.poll();
                System.out.print(curr.key + " ");

                if (curr.left != null) {
                    q.add(curr.left);
                }
                if (curr.right != null)
                    q.add(curr.right);
            }
            System.out.println();
        }
    }

    static void levelOrdernewLine(Node root) {
        if (root == null)
            return;
        Queue<Node> q = new LinkedList<>();
        q.add(root);
        q.add(null);
        while (q.size() > 1) {
            Node curr = q.poll();
            if (curr == null) {
                System.out.println();
                q.add(null);
                continue;
            }
            System.out.print(curr.key + " ");
            if (curr.left != null) {
                q.add(curr.left);
            }
            if (curr.right != null)
                q.add(curr.right);
        }
    }

    static void kDistinict(Node root, int k) {
        if (root == null)
            return;
        if (k == 0)
            System.out.print(root.key + " ");
        else {
            kDistinict(root.left, k - 1);
            kDistinict(root.right, k - 1);
        }
    }

    static int heightBinaryTree(Node root) {
        if (root == null)
            return 0;
        return Math.max(heightBinaryTree(root.left),
                        heightBinaryTree(root.right)) + 1;
    }

    static void levelOrder(Node root) {
        if (root == null)
            return;
        Queue<Node> q = new LinkedList<>();
        q.add(root);
        while (!q.isEmpty()) {
            Node curr = q.poll();
            if (curr.left != null) {
                q.add(curr.left);
            }
            if (curr.right != null)
                q.add(curr.right);
        }
    }
    static void postorder(Node root) {
        if (root != null) {
            postorder(root.left);
            postorder(root.right);
            System.out.print(root.key + " ");
        }
    }
    static void preorder(Node root) {
        if (root != null) {
            System.out.print(root.key + " ");
            preorder(root.left);
            preorder(root.right);
        }
    }
    static void inorder(Node root) {
        if (root != null) {
            inorder(root.left);
            System.out.print(root.key + " ");
            inorder(root.right);
        }
    }
}
