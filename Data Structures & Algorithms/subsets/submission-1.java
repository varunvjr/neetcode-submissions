class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>>result = new ArrayList<>();
        result.add(new ArrayList<>());
        generateSubsets(nums,result,new ArrayList<>(),0);
        return result;
    }
    private void generateSubsets(int nums[],List<List<Integer>>result,List<Integer>temp,int idx){
        for(int i=idx;i<nums.length;i++){
            temp.add(nums[i]);
            result.add(new ArrayList<>(temp));
            generateSubsets(nums,result,temp,i+1);
            temp.remove(temp.size()-1);
        }
    }
}
