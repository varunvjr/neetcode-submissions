class Solution {
    public int rob(int[] nums) {
        int n = nums.length;
        int cache[] = new int[n];
        Arrays.fill(cache,-1);
        int oneHouse = dfs(nums,cache,0,n);
        int twoHouse = dfs(nums,cache,1,n);
        return Math.max(oneHouse,twoHouse);
    }
    public int dfs(int nums[],int cache[],int i,int n){
        if(i>=n){
            return 0;
        }
        if(cache[i]!=-1)
            return cache[i];
        cache[i] = Math.max(dfs(nums,cache,i+1,n),(nums[i]+dfs(nums,cache,i+2,n)));
        return cache[i];
    }
}
