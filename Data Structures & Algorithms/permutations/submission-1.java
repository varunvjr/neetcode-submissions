class Solution {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>>result = new ArrayList<>();
        boolean pick[] = new boolean[nums.length];
        generate(result,nums,new ArrayList<>(),pick);
        return result;
    }
    public void generate(List<List<Integer>>result,int nums[],List<Integer>temp,boolean pick[]){
        if(temp.size()==nums.length){
            if(!result.contains(temp))
                result.add(new ArrayList<>(temp));
            return;
        }
        for(int i=0;i<nums.length;i++){
            if(!pick[i]){
                pick[i] = true;
                temp.add(nums[i]);
                generate(result,nums,temp,pick);
                temp.remove(temp.size()-1);
                pick[i] = false;
            }
        }
    }

}
