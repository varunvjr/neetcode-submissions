class Solution {
    public int minCostClimbingStairs(int[] cost) {
        int n = cost.length;
        int cache[] = new int[n+1];
        Arrays.fill(cache,-1);
        int costStep0 = dfs(cache,0,cost);
        int costStep1 = dfs(cache,1,cost);
        return Math.min(costStep0,costStep1);
    }
    public int dfs(int cache[],int idx,int cost[]){
        if(idx>=cost.length)
            return 0;
        if(cache[idx]!=-1)
            return cache[idx];
        cache[idx] = cost[idx]+Math.min(dfs(cache,idx+1,cost),dfs(cache,idx+2,cost));
        return cache[idx];
    }
}
