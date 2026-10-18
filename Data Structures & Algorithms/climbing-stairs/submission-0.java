class Solution {
    public int climbStairs(int n) {
        int cache[] = new int[n];
        for(int i=0;i<n;i++){
            cache[i] = -1;
        }
        return dfs(cache,n,0);
    }
    public int dfs(int cache[],int n,int i){
        if(i>=n){
            if(i==n)
                return 1;
            return 0;
        }
        if(cache[i]!=-1)
            return cache[i];
        return cache[i] =  dfs(cache,n,i+1)+dfs(cache,n,i+2);
    }

}
