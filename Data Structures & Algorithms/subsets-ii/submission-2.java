class Solution {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>>result = new ArrayList<>();
        result.add(new ArrayList<>());
        List<Integer>temp = new ArrayList<>();
        generate(result,temp,nums,0);
        return result;
    }
    private void generate(List<List<Integer>>result,List<Integer>temp,int nums[],int idx){
        // if(idx==nums.length)
        //     return;
        for(int i = idx;i<nums.length;i++){
            temp.add(nums[i]);
            if(!result.contains(temp)){
                result.add(new ArrayList<>(temp));
            }
            generate(result,temp,nums,i+1);
            temp.remove(temp.size()-1);
        }
    }
}
