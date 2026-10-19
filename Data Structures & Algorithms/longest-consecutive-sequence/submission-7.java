class Solution {
    public int longestConsecutive(int[] nums) {
        if(nums.length==0||nums.length==1)
            return nums.length;
        TreeSet<Integer>set = new TreeSet<>();
        for(int i=0;i<nums.length;i++){
            set.add(nums[i]);
        }
        int maxlen = 1;
        List<Integer>list = new ArrayList<>(set);
        int start = list.get(0);
        int len = 1;
        for(int i=1;i<list.size();i++){
            if(list.get(i)==(start+1)){
                len++;
            }else{
                len = 1;
            }
            start = list.get(i);
            maxlen = Math.max(len,maxlen);
        }
        return maxlen;
    }
}
