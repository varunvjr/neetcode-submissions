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
    public int minMeetingRooms(List<Interval> intervals) {
        Collections.sort(intervals,(a,b)->a.start-b.start);
        PriorityQueue<Interval>maxHeap = new PriorityQueue<>((a,b)->a.end-b.end);
        int room = 0;
        for(Interval interval:intervals){
            if(!maxHeap.isEmpty()&&maxHeap.peek().end<=interval.start){
                maxHeap.poll();
            }
            maxHeap.add(interval);
            room = Math.max(room,maxHeap.size());
        }
        return room;
    }
}
