/**
 * Definition for an interval.
 * public class Interval {
 *     int start;
 *     int end;
 *     Interval() { start = 0; end = 0; }
 *     Interval(int s, int e) { start = s; end = e; }
 * }
 */
class Solution {
    public int minMeetingRooms(Interval[] intervals) {
        if (intervals.length == 0) {
            return 0;
        }
        Arrays.sort(intervals, new Comparator<Interval>() {
            public int compare(Interval a, Interval b) { return a.start - b.start; }
        });

        PriorityQueue<Interval> pq = new PriorityQueue<Interval>(intervals.length, new Comparator<Interval>() {
            public int compare(Interval a, Interval b) { return a.end - b.end; }
        });
        
        int rnum = 0;
        for (Interval itv:intervals) {
            if(pq.isEmpty()){
                rnum++;
                pq.offer(itv);
            } else {
                Interval i = pq.peek();
                if (i.end > itv.start) {
                    rnum++;
                } else {
                    pq.poll();
                }
                pq.offer(itv);
            }
        }
        return rnum;
        
    }
}