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

class Tuple {
    Node node;
    int row;
    int col;

    public Tuple(Node _node, int _row, int _col) {
        node = _node;
        row = _row;
        col = _col;
    }

}

public class Tree {
    Node prev = null;

    static class Pair {
        int x;
        Node node;

        public Pair(int x, Node node) {
            this.x = x;
            this.node = node;
        }
    }

    public static void main(String[] args) {

    }
    void pathhelp(Node node,int target, List<Integer> curres,List<List<Integer>> res){
        if(node==null)return ;

        curres.add(node.key);

        if(node.key == target && node.left==null && node.right==null){
            res.add(new ArrayList<>(curres));
        }else {
            pathhelp(node.left,target-node.key,curres,res);
            pathhelp(node.right,target-node.key,curres,res);

        }
        curres.remove(curres.size()-1); 


    }
    private List<List<Integer>> pathSum_2(Node root,int targetSum){
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> curres = new ArrayList<>();
        pathhelp(root,targetSum,curres,res);
        return res;
    }
    private void propertySum(Node root){
        /*
        Tc-> O(N)
        SC -> O(N) if it skewed tree
         */
        if (root==null)return;
        int child=0;
        if (root.left!=null){
            child+=root.left.key;
        }
        if(root.right!=null){
            child+=root.right.key;
        }

        if (child>= root.key) root.key=child;
        else {
            if (root.left!=null)root.left.key = root.key;
            else if (root.right!=null) root.right.key = root.key;
        }
        propertySum(root.left);
        propertySum(root.right);

        int tot=0;
        if (root.left!=null)tot+=root.left.key;
        if (root.right!=null)tot+=root.right.key;
        if (root.left!=null || root.right!=null)root.key= tot;


    }
    private void flatten(Node root) {
        /*
        Reverse PostOrder
        TC -> O(N)
        SC -> O(N)
         */
        Node prev=null;
        if(root == null)return;
        flatten(root.right);
        flatten(root.left);
        root.right = prev;
        root.left = null;
        prev = root;
    }
    private boolean isSymmetric(Node left, Node right) {
        if (left == null || right == null)
            return left==right;

        if(left.key != right.key) return false;
        return isSymmetric(left.left, right.right)
                && isSymmetric(left.right, right.left);
    }

    private int maxPathSum(Node node,int[] maxval){
        //the size of the maxval should be 1.
        if (node==null)return 0;
        int left = Math.max(0,maxPathSum(node.left,maxval));
        int right = Math.max(0,maxPathSum(node.right,maxval));
        maxval[0] = Math.max(maxval[0],left+right+node.key);
        return Math.max(left,right)+node.key;
    }
    private static  ArrayList<Integer> traverseBoundary(Node root){
        // Write your code here.
        ArrayList<Integer> ans = new ArrayList<>();
        if(!isLeaf(root)){
            ans.add(root.key);
        }
        addLeftBoundary(root,ans);
        addLeaves(root,ans);
        addRightBoundary(root,ans);
        return ans;
    }
    private static void addLeaves(Node root, ArrayList<Integer> list){
        if (isLeaf(root)){
            list.add(root.key);
            return;
        }
        if (root.left!=null)addLeaves(root.left, list);
        if (root.right != null) addLeaves(root.right, list);
    }
    private static void addRightBoundary(Node root, ArrayList<Integer> list){
        Node cur = root.right;
        ArrayList<Integer> res = new ArrayList<>();
        while (cur!=null){
            if(!isLeaf(cur)){
                res.add(cur.key);
            }
            if(cur.right!=null)
                cur = cur.right;
            else
                cur = cur.left;
        }
        int i;
        for(i = res.size()-1;i>=0;--i){
           list.add(res.get(i));
        }

    }
    private static void addLeftBoundary(Node root, ArrayList<Integer> list){
        Node cur = root.left;
        while (cur!=null){
            if(!isLeaf(cur)){
                list.add(cur.key);
            }
            if(cur.left!=null)
                cur = cur.left;
            else
                cur = cur.right;
        }

    }
    private static boolean isLeaf(Node root){
        return (root.left==null) && (root.right==null);
    }
    private boolean isSameTree(Node p, Node q) {
        if(p==null && q==null)return true;
        if(p==null || q==null)return false;

        //checking the subtrees
        return p.key==q.key && isSameTree(p.left,q.left) && isSameTree(p.right,q.right);
    }
    private Node lowestCommonAncestor(Node root, Node p, Node q) {
        /*
        TC -> O(N)
        SC -> O(w)stack space
         */
        if(root == null || p==root || q==root)
            return root;

        Node left = lowestCommonAncestor(root.left,p,q);
        Node right = lowestCommonAncestor(root.right,p,q);

        //result
        if(left == null){
            return right;
        }else if(right == null){
            return left;
        }else{
            //else both are null we found our result
            return root;
        }
    }
    private int widthOfBinaryTree(Node root) {
        /*
        TC -> O(N) LO traversal
        SC -> O(N)
         */
        int ans = 0;
        if (root == null)
            return 0;
        Queue<Pair> q = new LinkedList<>();
        q.offer(new Pair(0, root));
        while (!q.isEmpty()) {
            int size = q.size();
            int mmin = q.peek().x;
            int first = 0, last = 0;

            for (int i = 0; i < size; i++) {
                int cur_ind = q.peek().x - mmin;//to make the id starting from zero
                Node node = q.peek().node;
                q.poll();
                if (i == 0) first = cur_ind;
                if (i == size - 1) last = cur_ind;

                if (node.left != null) {
                    q.offer(new Pair(cur_ind * 2 + 1, node.left));
                }
                if (node.right != null) {
                    q.offer(new Pair(cur_ind * 2 + 2, node.right));
                }
            }


            ans = Math.max(ans, last - first + 1);
        }

        return ans;
    }

    private ArrayList<Integer> solve(Node a, int b) {
        /*
        TC -> O(N)
        SC -> O(Height of the tree)
         */
        ArrayList<Integer> ans = new ArrayList<>();
        if (a == null) return ans;
        getPath(a, ans, b);
        return ans;
    }

    private boolean getPath(Node root, ArrayList<Integer> arr, int x) {
        if (root == null) return false;

        arr.add(root.key);
        if (root.key == x) return true;
        if (getPath(root.left, arr, x) || getPath(root.right, arr, x)) {
            return true;
        }
        arr.remove(arr.size() - 1);
        return false;

    }

    private List<List<Integer>> verticalTraversal(Node root) {
        /*
        TC -> O(N)logN
        SC -> O(N)
         */
        TreeMap<Integer, TreeMap<Integer, PriorityQueue<Integer>>> map = new TreeMap<>();
        Queue<Tuple> q = new LinkedList<>();
        q.offer(new Tuple(root, 0, 0));
        while (!q.isEmpty()) {
            Tuple tuple = q.poll();
            Node node = tuple.node;
            int x = tuple.row;
            int y = tuple.col;

            //If vertical doesn't exist.
            if (!map.containsKey(x)) {
                map.put(x, new TreeMap<>());
            }
            //if Priority doesn't exist,we creating.
            if (!map.get(x).containsKey(y)) {
                map.get(x).put(y, new PriorityQueue<>());
            }
            // Insert, Vertical and level and that node.
            map.get(x).get(y).offer(node.key);

            if (node.left != null) {
                q.offer(new Tuple(node.left, x - 1, y + 1));
            }
            if (node.right != null) {
                q.offer(new Tuple(node.right, x + 1, y + 1));
            }


        }

        List<List<Integer>> list = new ArrayList<>();
        for (TreeMap<Integer, PriorityQueue<Integer>> ys : map.values()) {
            list.add(new ArrayList<>());
            for (PriorityQueue<Integer> nodes : ys.values()) {
                while (!nodes.isEmpty()) {
                    System.out.println(nodes.peek());
                    list.get(list.size() - 1).add(nodes.poll());

                }

            }
        }
        return list;

    }

    private void predSucessor2(Node root, int key) {
        Node predessor = null, successor = null;
        while (root != null) {
            if (root.key >= key) {
                root = root.left;
            } else {
                predessor = root;
                root = root.right;
            }
            if (root.key <= key) {
                root = root.right;
            } else {
                successor = root;
                root = root.left;
            }
        }

        System.out.println(predessor + " " + successor);
    }

    private void predSucessor(Node root, int key) {
        Node predessor = null, successor = null;

        List<Node> list = new ArrayList<>();
        if (root != null) {
            predSucessor(root.left, key);
            list.add(root);
            predSucessor(root.right, key);
        }
        if (list.size() == 0) return;

        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).key == key) {
                predessor = list.get(i - 1);
                successor = list.get(i + 1);
                break;
            }
        }
        System.out.println("Predessor is: " + predessor + " Presuccesor is: " + successor);
    }

    private Node predessor(Node root, int key) {
        Node predessor = null;
        while (root != null) {
            if (root.key >= key) {
                root = root.left;
            } else {
                predessor = root;
                root = root.right;
            }
        }
        return predessor;
    }

    private Node successor(Node root, int key) {
        Node sucessor = null;
        while (root != null) {
            if (root.key <= key) {
                root = root.right;
            } else {
                sucessor = root;
                root = root.left;
            }
        }
        return sucessor;
    }


        private Node reverseOddLevels(Node root) {
            //lvl starting from 1
            dfs(root.left,root.right,1);
            return root;
        }
        private void dfs(Node node1,Node node2,int lvl){
            if(node1==null || node2 == null)return;

            if(lvl%2==1){
                int temp = node1.key;
                node1.key = node2.key;
                node2.key = temp;
            }

            dfs(node1.left,node2.right,lvl+1);
            dfs(node1.right,node2.left,lvl+1);
        }


    private void mirror(Node root) {
        if (root != null) {
            preorder(root.right);
            System.out.print(root.key + " ");
            preorder(root.left);

        }
    }

    private void itrativeInorder(Node root) {
        Stack<Node> s = new Stack<>();
        Node curr = root;
        while (curr != null || !s.isEmpty()) {
            while (curr != null) {
                s.push(curr);
                curr = curr.left;
            }
            s.pop();
            System.out.print(curr.key);
            curr = curr.right;
        }
    }

    private int countNode(Node root) {
        int lh = 0, rh = 0;
        Node curr = root;
        while (curr != null) {
            lh++;
            curr = curr.left;
        }
        curr = root;
        while (curr != null) {
            rh++;
            curr = curr.right;
        }
        if (lh == rh) {
            return (int) Math.pow(2, lh) - 1;
        }
        return 1 + countNodes(root.left) + countNodes(root.right);
//        if (lca1!=null && lca2!=null)
//            return root;
//        return (lca1!=null)?lca1:lca2;
    }

    private static int daimeterOfTree(Node root) {
        if (root == null)
            return 0;

        int d1 = 1 + Math.max(heightBinaryTree(root.left), heightBinaryTree(root.right));
        int d2 = daimeterOfTree(root.left);
        int d3 = daimeterOfTree(root.right);
        return 1 + Math.max(d1, Math.max(d2, d3));

    }

    private static List<List<Integer>> printSpiral(Node root) {
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
            if (reverse) {
                while (!s.isEmpty()) {
                    //System.out.print(s.pop()+" ");
                    list.add(s.pop());
                }
            }
            //after a level complete
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

    private static ArrayList<Integer> bottomView(Node root) {
        ArrayList<Integer> ans = new ArrayList<>();
        if (root == null)
            return ans;

        Map<Integer, Integer> map = new TreeMap<>();
        Queue<Pair> q = new LinkedList<>();

        q.offer(new Pair(0, root));
        while (!q.isEmpty()) {
            Pair p = q.poll();
            int x = p.x;
            Node cur = p.node;

            map.put(x, cur.key);

            if (cur.left != null) {
                q.offer(new Pair(x - 1, cur.left));
            }
            if (cur.right != null) {
                q.offer(new Pair(x + 1, cur.right));
            }
        }

        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            ans.add(entry.getValue());
        }
        return ans;
    }

    private static void leftRigtView(Node root, int level) {
        //level should be 0 initially,to print left view swap recursive fn code.
        List<Integer> ds = new ArrayList<>();
        if (root == null) return;
        if (ds.size() == level) ds.add(root.key);
        leftRigtView(root.right, level + 1);
        leftRigtView(root.left, level + 1);
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
