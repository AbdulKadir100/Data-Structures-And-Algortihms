package Graphs;

public class Tree {
    static Node root;

    Tree(int key) {
        root = new Node(key);
    }

    Tree() {
        root = null;
    }



    public static void main(String[] args) {
        Tree tree = new Tree();
        root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);
        root.postOrder(root);


    }
}

class Node {
    int key;
    Node left, right;

    public Node(int item) {
        key = item;
        left = right = null;
    }
    public void postOrder(Node node){
        if (node == null)
            return;
        postOrder(node.left);
        postOrder(node.right);
        System.out.print(" "+ node.key);

    }
}

class SimpleTree {
    Node root;

    SimpleTree(int key) {
        root = new Node(key);
    }

    SimpleTree() {
        root = null;
    }


}
