class Solution {
    public List<List<Integer>> combinationSum(int[] nums, int target) {
        List<List<Integer>>result = new ArrayList<>();
        generate(result,new ArrayList<>(),nums,target,0);
        return result;   
    }
    public void generate(List<List<Integer>>result,List<Integer>temp,int nums[],int target,int idx){
        if(target<=0){
            if(target==0&&!result.contains(temp)){
                result.add(new ArrayList<>(temp));
            }
            return;
        }
        for(int i = idx;i<nums.length;i++){
            temp.add(nums[i]);
            generate(result,temp,nums,target-nums[i],i);
            temp.remove(temp.size()-1);
        }
    }
}
