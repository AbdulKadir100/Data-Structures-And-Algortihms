package CodeChef;

public class SegmentTree {
    static class Node{
        int maximun;
        int smaximum;

        //Node(int maximum,int smaximum){this.maximun = maximum; this.smaximum = smaximum;}
    }

    public void buildTree(int[] arr,int[] tree,int treeIndex,int start,int end){
        int mid = (start+end)/2;
        buildTree(arr,tree,2*treeIndex,start,mid);
        buildTree(arr,tree,2*treeIndex+1,mid+1,end);
         int left =  tree[2*treeIndex];
         int right = tree[2*treeIndex+1];
         

    }
}
