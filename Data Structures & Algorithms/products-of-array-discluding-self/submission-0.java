class Solution {
    public int[] productExceptSelf(int[] nums) {
        int n = nums.length;
        int lsum[] = new int[n];
        int rsum[] = new int[n];
        int res[] = new int[n];
        lsum[0] = 1;
        rsum[n-1] = 1;
        for(int i=1;i<n;i++){
            lsum[i] = lsum[i-1]*nums[i-1];
        }
        for(int i=n-2;i>=0;i--){
            rsum[i] = rsum[i+1]*nums[i+1];
        }
        for(int i=0;i<n;i++){
            res[i] = lsum[i]*rsum[i];
        }
        return res;
    }
}  
