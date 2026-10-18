class Solution {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>>result =  new ArrayList<>();
        List<Integer>temp = new ArrayList<>();
        boolean pick[] = new boolean[nums.length];
        subset(result,temp,nums,pick);
        return result;
    }
    public void subset(List<List<Integer>>result,List<Integer>temp,int nums[],boolean pick[]){
        if(temp.size()==nums.length){
            if(!result.contains(temp)){
                result.add(new ArrayList<>(temp));
                return;
            }
        }
        for(int i=0;i<nums.length;i++){
            if(!pick[i]){
                temp.add(nums[i]);
                pick[i] = true;
                subset(result,temp,nums,pick);
                temp.remove(temp.size()-1);
                pick[i] = false;
            }
        }
    }
}
