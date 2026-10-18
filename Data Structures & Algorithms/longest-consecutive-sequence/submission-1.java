class Solution {
    public int longestConsecutive(int[] nums) {
        int n = nums.length;
        TreeSet<Integer> set = new TreeSet<>();
        for(int ele:nums){
            set.add(ele);
        }
        if(nums.length==0)
            return 0;
        List<Integer>arr = new ArrayList<>(set);
        int count = 1;
        int maxCount = 1;
        for(int i=1;i<arr.size();i++){
            if(arr.get(i)==arr.get(i-1)+1){
                count++;
            }else{
                count = 1;
            }
            maxCount = Math.max(maxCount,count);
        }
        return maxCount;
    }
}
