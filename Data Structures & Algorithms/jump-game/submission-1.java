class Solution {
    public boolean canJump(int[] nums) {
        int n = nums.length;
        int maxJump = n-1;
        for(int i=n-2;i>=0;i--){
            if(nums[i]+i>=maxJump){
                maxJump = i;
            }
        }
        return maxJump==0;
    }
}
