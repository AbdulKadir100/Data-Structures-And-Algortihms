package CodeChef;

import java.util.Arrays;
import java.util.Comparator;

public class FractionalKnapsack {
    // Greedy Approach

    public static void main(String[] args) {
        int[] val = new int[]{60,100,120};
        int[] wt = new int[]{10,20,30};
        int capacity=50;
        double maxValue = getMaxValue(wt,val,capacity);
        System.out.println("Max value can be obtain: "+maxValue);
    }

    static class ItemValue {
        Double cost;
        double wt, val, ind;

        public ItemValue(double wt, double val, double ind) {
            this.wt = wt;
            this.val = val;
            this.ind = ind;
            cost = val / wt;
        }
    }

    static double getMaxValue(int[] wt, int[] val, int capacity) {
        ItemValue[] iValue = new ItemValue[wt.length];
        for (int i = 0; i < wt.length; i++) {
            iValue[i] = new ItemValue(wt[i], val[i], i);
        }
        //sorting items by values
        Arrays.sort(iValue, new Comparator<ItemValue>() {
            @Override
            public int compare(ItemValue o1, ItemValue o2) {
                return o2.cost.compareTo(o1.cost);
            }
        });
        double totalValue = 0;
        for (ItemValue i : iValue) {
            int curWt = (int) i.wt;
            int curval = (int) i.val;
            if (capacity - curWt >= 0) {
                //This weight can be picked while
                capacity = capacity - curWt;
                totalValue += curval;
            } else {
                //Item can be picked whole
                double fraction = (double) capacity / (double) curWt;
                totalValue += curval * fraction;
                capacity = (int) (capacity - (curWt * fraction));
                break;
            }
        }
        return totalValue;
    }

    static int knapSack(int W, int wt[], int val[], int n) {
        //Base Case
        if (n == 0 || W == 0)
            return 0;
        /*
        if weight of the nth item is more than Knapsack capacity W.
        than the cannot be included into the optimal sol.
         */
        if (wt[n - 1] > W)
            return knapSack(W, wt, val, n - 1);
        /*
        Return the max two cases:
        1. nth item is included
        2. not included
         */
        else
            return max(val[n - 1] + knapSack(W - wt[n - 1], wt, val, n - 1), knapSack(W, wt, val, n - 1));


    }

    static int max(int a, int b) {
        return (a > b) ? a : b;
    }

    public static void buildTree(int[] arr, int[] tree, int start, int end, int treenode) {
        if (start == end) {
            tree[treenode] = arr[start];
            return;
        }
        int mid = (start + end) / 2;
        buildTree(arr, tree, start, mid, 2 * treenode);
        buildTree(arr, tree, mid + 1, end, 2 * treenode);
        tree[treenode] = tree[2 * treenode] + tree[2 * treenode + 1];

    }

}
