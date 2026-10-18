class Solution {
    public int findSmallest(int intervals[][],int query){
        int len = Integer.MAX_VALUE;
        for(int interval[]:intervals){
            int left = interval[0];
            int right = interval[1];
            if(query>=left&&query<=right){
                len = Math.min(right-left+1,len);
            }
        }
        return len;
    }
    public int[] minInterval(int[][] intervals, int[] queries) {
        int n = queries.length;
        int res[] = new int[n];
        int idx = 0;
        for(int query:queries){
            int ans = findSmallest(intervals,query);
            res[idx++] = (ans == Integer.MAX_VALUE?-1:ans);
        }
        return res;
    }
}
