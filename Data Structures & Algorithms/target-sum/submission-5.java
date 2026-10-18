class Solution {
    public int findTargetSumWays(int[] nums, int target) {
        int sum = 0;
        for(int ele : nums) {
            sum += ele;
        }
        
        // If target + sum(nums) is odd or target is out of possible range, return 0
        if ((target + sum) % 2 != 0 || target > sum) {
            return 0;
        }
        
        int k = (target + sum) / 2;  // This is the target for subset sum
        int n = nums.length;
        int[] cache = new int[k + 1];  // We only need a 1D array (space optimization)
        
        // Base case: there's 1 way to make sum 0 (select no elements)
        cache[0] = 1;

        for (int i = 0; i < n; i++) {
            // Traverse backward to avoid recomputing values in the same iteration
            for (int j = k; j >= nums[i]; j--) {
                cache[j] += cache[j - nums[i]];
            }
        }

        return cache[k];
    }
}
