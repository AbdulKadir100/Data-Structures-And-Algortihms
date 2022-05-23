package GreedyAndDP;

import java.util.Arrays;
import java.util.Comparator;

public class ActivitySelection {
    static class Activity {
        int start;
        int finish;

        public Activity(int start, int finish) {
            this.start = start;
            this.finish = finish;
        }

    }

    public static void main(String[] args) {
        Activity[] ar = new Activity[3];
        ar[0] = new Activity(10, 20);
        ar[1] = new Activity(12, 25);
        ar[2] = new Activity(20, 30);


    }

    private static int activitySelection(Activity[] ar) {
        Arrays.sort(ar, new Comparator<Activity>() {
            @Override
            public int compare(Activity o1, Activity o2) {

                return o1.finish - o2.finish;
            }
        });
        int res=0,prev=0;
        for (int curr = 1; curr < ar.length; curr++) {
            if (ar[prev].finish <= ar[curr].start){
                res++;
                prev = curr;
            }
        }
        return res;
    }


}
