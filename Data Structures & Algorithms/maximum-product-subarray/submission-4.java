class Solution {
    public int maxProduct(int[] nums) {
        int res = nums[0];
        int curmax = 1;
        int curmin = 1;
        for(int ele:nums){
            int temp = ele*curmax;
            curmax = Math.max(ele,Math.max(ele*curmax,ele*curmin));
            curmin = Math.min(ele,Math.min(temp,ele*curmin));
            res = Math.max(curmax,res);
        }
        return res;
    }
}
