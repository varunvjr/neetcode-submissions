/**
 * Definition of Interval:
 * public class Interval {
 *     public int start, end;
 *     public Interval(int start, int end) {
 *         this.start = start;
 *         this.end = end;
 *     }
 * }
 */

class Solution {
    public boolean canAttendMeetings(List<Interval> intervals) {
        Collections.sort(intervals,(a,b)->a.start-b.start);
        if(intervals.size()<=1)
            return true;
        Iterator<Interval>itr = intervals.iterator();
        Interval curInterval = itr.next();
        int prevStart = curInterval.start;
        int prevEnd = curInterval.end;
        while(itr.hasNext()){
            curInterval = itr.next();
            int curStart = curInterval.start;
            int curEnd = curInterval.end;
            if(prevEnd>curStart){
                return false;
            }
            prevStart = curStart;
            prevEnd = curEnd;
        }
        return true;
    }
}
