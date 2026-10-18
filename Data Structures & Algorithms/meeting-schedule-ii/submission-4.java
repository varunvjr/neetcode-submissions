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
        int rooms = 0;
        if(intervals.size()<=1)
            return intervals.size();
        Collections.sort(intervals,(a,b)->a.start-b.start);
        PriorityQueue<Interval>maxHeap = new PriorityQueue<>((a,b)->a.end-b.end);
        Iterator<Interval> iterator = intervals.iterator();
        while(iterator.hasNext()){
            Interval itr = iterator.next();
            int start = itr.start;
            int end = itr.end;
            while(!maxHeap.isEmpty()&&maxHeap.peek().end<=start){
                maxHeap.poll();
            }
            maxHeap.add(new Interval(start,end));
            rooms = Math.max(rooms,maxHeap.size());
        }
        return rooms;
    }
}
