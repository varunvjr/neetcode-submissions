class Solution {
    public int rob(int[] nums) {
        if(nums.length==1)
            return nums[0];
        if(nums.length==2)
            return Math.max(nums[0],nums[1]);
        int n = nums.length;
        int cache[] = new int[n];
        Arrays.fill(cache,-1);
        dfs(cache,nums,n,0);
        return Math.max(cache[0],cache[1]);
    }
    private int dfs(int cache[],int nums[],int n,int idx){
        if(idx>=n)
            return 0;
        if(cache[idx]!=-1)
            return cache[idx];
        cache[idx] = Math.max(nums[idx]+dfs(cache,nums,n,idx+2),dfs(cache,nums,n,idx+1));
        return cache[idx];
    }
}
