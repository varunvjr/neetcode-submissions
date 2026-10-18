class Solution {
    public int minCostClimbingStairs(int[] cost) {
        int n = cost.length;
        int cache[] = new int[n];
        Arrays.fill(cache,-1);
        int oneStep = dfs(cache,cost,0,n);
        int twoStep = dfs(cache,cost,1,n);
        return Math.min(oneStep,twoStep);
    }
    public int dfs(int cache[],int cost[],int i,int n){
        if(i>=n){
            return 0; // we have reached the last step so no cost involved
        }
        if(cache[i]!=-1)
            return cache[i];
        cache[i] = cost[i]+Math.min(dfs(cache,cost,i+1,n),dfs(cache,cost,i+2,n));
        return cache[i];
    }
}
