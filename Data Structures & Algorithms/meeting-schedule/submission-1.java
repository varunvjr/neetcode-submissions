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
        if(intervals.size()==0)
            return true;
        Collections.sort(intervals,(a,b)->a.start-b.start);
        Iterator<Interval>listIterator = intervals.iterator();
        Interval curInterval = listIterator.next();
        int prevStart = curInterval.start;
        int prevEnd = curInterval.end;
        while(listIterator.hasNext()){
            Interval itr = listIterator.next();
            int start = itr.start;
            int end = itr.end;
            if(start<prevEnd){
                return false;
            }else{
                prevStart = start;
                prevEnd = end;
            }
        }
        return true;

    }
}
