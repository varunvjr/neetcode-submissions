class Solution {
    public boolean canPartition(int[] nums) {
        int sum  = 0;
        for(int ele:nums){
            sum+=ele;
        }
        if(sum%2!=0)
            return false;
        int n = nums.length;
        int target = sum/2;
        boolean cache[][] = new boolean[n+1][target+1];
        for(int i=0;i<=n;i++){
            cache[i][0] = true;   
        }
        for(int i=1;i<=n;i++){
            for(int j=1;j<=target;j++){
                if(nums[i-1]<=j){
                    cache[i][j] = cache[i-1][j-nums[i-1]]||cache[i-1][j];
                }else{
                    cache[i][j] = cache[i-1][j];
                }
            }
        }
        return cache[n][target];
    }
}
