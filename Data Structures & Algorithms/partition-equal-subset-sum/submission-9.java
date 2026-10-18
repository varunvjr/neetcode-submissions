class Solution {
    public boolean canPartition(int[] nums) {
        int sum = 0;
        for (int num : nums)
            sum += num;

        if (sum % 2 != 0)
            return false;

        int target = sum / 2;
        Boolean[][] memo = new Boolean[nums.length][target + 1];
        return canPartitionRecursive(nums, 0, target, memo);
    }

    private boolean canPartitionRecursive(int[] nums, int index, int target, Boolean[][] memo) {
        if (target == 0)
            return true;
        if (index >= nums.length || target < 0)
            return false;

        if (memo[index][target] != null)
            return memo[index][target];

        // Try including nums[index]
        boolean include = canPartitionRecursive(nums, index + 1, target - nums[index], memo);
        // Try excluding nums[index]
        boolean exclude = canPartitionRecursive(nums, index + 1, target, memo);

        memo[index][target] = include || exclude;
        return memo[index][target];
    }
}
