class Solution {
    public int minCostClimbingStairs(int[] cost) {
        int n = cost.length;
        int cache[] = new int[n+1];
        Arrays.fill(cache,-1);
        int firstStep = dfs(cache,cost,n,0);
        int secondStep = dfs(cache,cost,n,1);
        return Math.min(firstStep,secondStep);
    }
    private int dfs(int cache[],int cost[],int n,int idx){
        if(idx>=cost.length){
            return 0;
        }
        if(cache[idx]!=-1)
            return cache[idx];
        cache[idx] = cost[idx]+Math.min(dfs(cache,cost,n,idx+1),dfs(cache,cost,n,idx+2));
        return cache[idx];
    }
}
