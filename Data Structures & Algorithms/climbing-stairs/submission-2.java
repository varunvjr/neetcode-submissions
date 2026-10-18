class Solution {
    public int climbStairs(int n) {
        int cache[] = new int[n];
        Arrays.fill(cache,-1);
        return dfs(cache,n,0);
    }
    private int dfs(int cache[],int n,int idx){
        if(idx==n)
            return 1;
        if(idx>n)
            return 0;
        if(cache[idx]!=-1)
            return cache[idx];
        cache[idx] = dfs(cache,n,idx+1)+dfs(cache,n,idx+2);
        return cache[idx];
    }
}
