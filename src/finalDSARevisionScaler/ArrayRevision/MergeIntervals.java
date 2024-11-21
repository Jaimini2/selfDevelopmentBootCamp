package src.finalDSARevisionScaler.ArrayRevision;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * Q24)Merge Intervals
 * You have a set of non-overlapping intervals. You are given a new interval [start, end],
 * insert this new interval into the set of intervals (merge if necessary).
 * You may assume that the intervals were initially sorted according to their start times.
 */
public class MergeIntervals {

    public ArrayList<Interval> insert(ArrayList<Interval> a1,Interval interval) {
        ArrayList<Interval> list = new ArrayList<>();

        int n = a1.size();
        for (int i = 0; i < n; i++) {
            int s1 = a1.get(i).start;
            int e1 = a1.get(i).end;

            // merging the intervals if new interval's start is less than current Interval's end
            //and end is greater than current interval's start
            if (s1 > interval.end) {
                list.add(interval);
                for (int j = i; j < n; j++) {
                    list.add(a1.get(j));
                }
                return list;
            } else if (interval.start > e1) {
                list.add(a1.get(i));
            } else {
                interval.start = Math.min(s1, interval.start);
                interval.end = Math.max(e1, interval.end);

            }
        }
        list.add(interval);
        return list;
    }

    public static void main(String[] args) {

        MergeIntervals m = new MergeIntervals();

        ArrayList<Interval> a1 = new ArrayList<>();
        a1.add(new Interval(1,3));
        a1.add(new Interval(6,9));
        Interval interval = new Interval(2,5);

       ArrayList<Interval> ans =  m.insert(a1,interval);
       for (Interval i : ans){
           System.out.println("Start " + i.start + " , End : "+ i.end);
       }

    }
}
