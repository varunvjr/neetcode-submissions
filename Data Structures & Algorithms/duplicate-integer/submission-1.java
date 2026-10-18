class Solution {
    public boolean hasDuplicate(int[] nums) {
        int i = 0;
        int count = 1;
        Arrays.sort(nums);
        int j = 1;
        while(j<nums.length){
            if(nums[i] == nums[j]){
                count++;
                if(count>1)
                    return true;
            }else{
                i=j;
                count = 1;
            }
            j++;
        }
        return false;
    }
}
