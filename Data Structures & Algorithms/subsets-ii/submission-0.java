class Solution {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        List<List<Integer>>result = new ArrayList<>();
        List<Integer>temp = new ArrayList<>();
        result.add(new ArrayList<>(temp));
        Arrays.sort(nums);
        subset(nums,result,temp,0);
        return result;
    }
    public void subset(int nums[],List<List<Integer>>result,List<Integer>temp,int idx){
        if(idx==nums.length){
            return;
        }
        for(int i=idx;i<nums.length;i++){
            temp.add(nums[i]);
 
            if(!result.contains(temp))
                result.add(new ArrayList<>(temp));
            subset(nums,result,temp,i+1);
            temp.remove(temp.size()-1);
        }
    }
}
