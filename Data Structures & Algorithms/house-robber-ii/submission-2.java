class Solution {
    public int rob(int[] nums) {
        int n = nums.length;
        if(nums.length==1)
            return nums[0];
        if(nums.length==2)
            return Math.max(nums[0],nums[1]);
        int cache[] = new int[n-1];
        Arrays.fill(cache,-1);
        int house1[] = new int[n-1];
        int house2[] = new int[n-1];
        for(int i=0;i<n-1;i++){
            house1[i] = nums[i];
        }
        dfs(cache,house1,n-1,0);
        int max1 = Math.max(cache[0],cache[1]);
        Arrays.fill(cache,-1);
        for(int i=1;i<n;i++){
            house2[i-1] = nums[i];
        }
        dfs(cache,house2,n-1,0);
        int max2 = Math.max(cache[0],cache[1]);
        return Math.max(max1,max2);
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
