class Solution {
    public boolean canJump(int[] nums) {
        int maxSoFar = nums.length-1;
        for(int i = nums.length-1;i>=0;i--){
            if(nums[i]+i>=maxSoFar){
                maxSoFar = i;
            }
        }
        return maxSoFar==0;
    }
}
