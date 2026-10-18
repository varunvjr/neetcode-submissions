class Solution {
    public List<List<Integer>> combinationSum(int[] nums, int target) {
        List<List<Integer>>result = new ArrayList<>();
        List<Integer>temp = new ArrayList<>();
        subset(result,temp,0,target,nums);
        return result;
    }
    public void subset(List<List<Integer>>result,List<Integer>temp,int idx,int target,int nums[]){
        if(target<=0){
            if(target==0&&!result.contains(temp)){
                result.add(new ArrayList<>(temp));
            }
            return;
        }
        for(int i=idx;i<nums.length;i++){
            temp.add(nums[i]);
            subset(result,temp,i,target-nums[i],nums);
            temp.remove(temp.size()-1);
        }
    }
}
