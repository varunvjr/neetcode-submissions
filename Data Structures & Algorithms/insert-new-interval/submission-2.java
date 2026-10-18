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
        Iterator<Interval>listIterator = intervalList.iterator();
        List<Interval>resultList = new ArrayList<>();
        Interval curInterval = listIterator.next();
        int prevStart = curInterval.start;
        int prevEnd = curInterval.end;
        while(listIterator.hasNext()){
            Interval interval = listIterator.next();
            int start = interval.start;
            int end = interval.end;
            if(start>prevEnd){
               resultList.add(new Interval(prevStart,prevEnd));
               prevStart = start;
               prevEnd = end;
            }else{
                prevEnd = Math.max(prevEnd,end);
            }
        }
        resultList.add(new Interval(prevStart,prevEnd));
        int result[][] = new int[resultList.size()][2];
        int idx=0;
        for(Interval curItr:resultList){
            result[idx][0] = curItr.start;
            result[idx++][1] = curItr.end;
        }   
        return result;

    }
}
