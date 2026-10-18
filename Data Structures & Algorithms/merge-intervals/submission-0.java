class Interval{
    int start;
    int end;
    public Interval(int start,int end){
        this.start = start;
        this.end = end;
    }
}
class Solution {
    public int[][] merge(int[][] intervals) {
        Arrays.sort(intervals,(a,b)->a[0]-b[0]);
        List<Interval>intervalList = new ArrayList<>();
        int prevStart = intervals[0][0];
        int prevEnd = intervals[0][1];
        for(int i=1;i<intervals.length;i++){
            int start = intervals[i][0];
            int end = intervals[i][1];
            if(prevEnd>=start){
                prevEnd = Math.max(end,prevEnd);
            }else{
                intervalList.add(new Interval(prevStart,prevEnd));
                prevStart = start;
                prevEnd = end; 
            }
        }
        intervalList.add(new Interval(prevStart,prevEnd));
        int n = intervalList.size();
        int res[][] = new int[n][2];
        int idx = 0;
        for(Interval curInterval:intervalList){
            res[idx][0] = curInterval.start;
            res[idx++][1] = curInterval.end;
        }
        return res;
    }
}
