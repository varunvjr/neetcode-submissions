class Solution {
    public int longestConsecutive(int[] nums) {
        TreeSet<Integer>set = new TreeSet<>();
        if(nums.length==0)
            return 0;
        for(int ele:nums){
            set.add(ele);
        }
        List<Integer>temp = new ArrayList<>(set);
        int len = 1;
        int j=1;
        int maxLen = 1;
        while(j<temp.size()){
            if(temp.get(j)==temp.get(j-1)+1){
                len++;
            }else{
                len=1;
            }
            j++;
            maxLen = Math.max(len,maxLen);
        }
        return maxLen;
    }
}
