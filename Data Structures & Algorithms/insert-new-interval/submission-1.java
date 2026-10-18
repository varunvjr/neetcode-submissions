class Interval{
    int start;
    int end;
    public Interval(int start,int end){
        this.start = start;
        this.end = end;
    }
}
class Solution {
    public int[][] insert(int[][] intervals, int[] newInterval) {
        List<Interval>intervalList = new ArrayList<>();
        for(int interval[]:intervals){
            intervalList.add(new Interval(interval[0],interval[1]));
        }
        intervalList.add(new Interval(newInterval[0],newInterval[1]));
        Collections.sort(intervalList,(a,b)->a.start-b.start);
        Iterator<Interval>iterator = intervalList.iterator();
        Interval itr = iterator.next();
        List<Interval>resultList = new ArrayList<>();
        int prevStart = itr.start;
        int prevEnd = itr.end;
        while(iterator.hasNext()){
            itr = iterator.next();
            int start = itr.start;
            int end = itr.end;
     
            if(prevEnd>=start){
                prevEnd = Math.max(prevEnd,end);
            }else{
                resultList.add(new Interval(prevStart,prevEnd));
                prevStart = start;
                prevEnd = end;
            }
            
        }
        resultList.add(new Interval(prevStart,prevEnd));
        int n = resultList.size();
        int res[][] = new int[n][2];
        int idx = 0;
        for(Interval cur:resultList){
            res[idx][0] = cur.start;
            res[idx++][1] = cur.end;
        }
        return res;
    }
}
