class Solution {
    public static int findMinimum(int nums[]){
        int left = 0;
        int right = nums.length-1;
        while(left<right){
            int mid = left+(right-left)/2;
            if(nums[mid]>nums[right]){
                left = mid+1;
            }else{
                right = mid;
            }
        }
        return left;
    }
    public int search(int[] nums, int target) {
        int pivot = findMinimum(nums);
        int left = 0;
        int right = nums.length-1;
        if(nums[pivot]<=target&&nums[right]>=target){
            left = pivot;
        }else{
            right = pivot;
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
