class Solution {
    public int rob(int[] nums) {
       int n = nums.length;
       if(n==1){
            return nums[0];
       }
       if(n==2){
            return Math.max(nums[0],nums[1]);
       }
       int cache[] = new int[n];
       Arrays.fill(cache,-1);
       dfs(n-1,nums,cache);
       return Math.max(cache[n-1],cache[n-2]); 

    }
    public int dfs(int n,int nums[],int cache[]){
        if(n<0)
            return 0;
        else if(cache[n]!=-1)
            return cache[n];
        else{
            return cache[n] = Math.max(nums[n]+dfs(n-2,nums,cache),dfs(n-1,nums,cache));
        }
    }
}
