class Solution {
    public int lengthOfLIS(int[] nums) {
        int n = nums.length;
        int lis[] = new int[n];
        int max = 1;
        Arrays.fill(lis,1);
        for(int i=0;i<n;i++){
            for(int j=0;j<i;j++){
                if(nums[i]>nums[j]&&lis[j]+1>lis[i]){
                    lis[i] = lis[j]+1;
                    max = Math.max(max,lis[i]);
                }
            }
        }
        return max;
    }
}
