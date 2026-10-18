class Solution {
    private int findMinimum(int nums[]){
        int left = 0;
        int right = nums.length-1;
        while(left<right){
            int mid = (left+right)/2;
            if(nums[mid]<nums[right]){
                right = mid;
            }else{
                left = mid+1;
            }
        }
        return left;
    }
    public int search(int[] nums, int target) {
        int minIdx = findMinimum(nums);
        if(nums[minIdx]==target)
            return minIdx;
        int left = 0;
        int right = nums.length-1;
        if (target >= nums[minIdx] && target <= nums[nums.length - 1]) {
            // Search in right half
            left = minIdx;
            right = nums.length - 1;
        } else {
            // Search in left half
            left = 0;
            right = minIdx - 1;
        }

        while(left<=right){
            int mid = left+(right-left)/2;
            if(nums[mid]==target)
                return mid;
            else if(nums[mid]<target)
                left = mid+1;
            else
                right = mid-1;
        }
        return -1;
    }
}
