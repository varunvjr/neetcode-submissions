class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>>result = new ArrayList<>();
        List<Integer>temp = new ArrayList<>();
        result.add(new ArrayList<>(temp));
        generate(nums,result,temp,0);
        return result;
    }
    public void generate(int nums[],List<List<Integer>>result,List<Integer>temp,int idx){
        if(idx==nums.length){
            return;
        }
        for(int i=idx;i<nums.length;i++){
            temp.add(nums[i]);
            result.add(new ArrayList<>(temp));
            generate(nums,result,temp,i+1);
            temp.remove(temp.size()-1);
        }
    }
}
