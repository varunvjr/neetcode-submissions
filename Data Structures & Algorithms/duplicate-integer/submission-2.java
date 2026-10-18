class Solution {
    public boolean hasDuplicate(int[] nums) {
        HashSet<Integer>set = new HashSet<>();
        for(int i = 0;i<nums.length;i++){
            int ele = nums[i];
            set.add(ele);
        }
        return !(set.size()==nums.length);
    }
}