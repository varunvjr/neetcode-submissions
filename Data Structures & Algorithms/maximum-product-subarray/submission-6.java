class Solution {
    public int maxProduct(int[] nums) {
        int max_so_far = nums[0];
        int min_so_far = nums[0];
        if(nums.length==1)
            return nums[0];
        int result = 0;
        for(int i=1;i<nums.length;i++){
            int curr = nums[i];
            int tempMax = Math.max(curr,Math.max(curr*max_so_far,curr*min_so_far));
            min_so_far = Math.min(curr,Math.min(curr*min_so_far,curr*max_so_far));
            max_so_far = tempMax;
            result = Math.max(result,max_so_far);
        }
        return result;
    }
}
