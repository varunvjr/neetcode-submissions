class Solution {
    public int longestConsecutive(int[] nums) {
        if(nums.length==0)
            return 0;
        HashSet<Integer>set = new HashSet<>();
        for(int ele:nums){
            set.add(ele);
        }
        int longest = 1;
        for(int num:nums){
            if(!set.contains(num-1)){
                int len = 1;
                while(set.contains(num+len)){
                    len++;
                }
                longest = Math.max(longest,len);
            }
        }
        return longest;
    }
}
