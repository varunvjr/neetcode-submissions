class Solution {
    public boolean canPartition(int[] nums) {
        int sum = 0;
        for(int ele:nums){
            sum+=ele;
        }
        if(sum%2!=0)
            return false;
        List<List<Integer>>res = new ArrayList<>();
        List<Integer>temp = new ArrayList<>();
        subset(nums,sum/2,0,temp,res);
        return res.size()>0;
    }
    public void subset(int nums[],int target,int idx,List<Integer>temp,List<List<Integer>>res){
        if(target<=0){
            if(target==0&&!res.contains(temp))
                res.add(new ArrayList<>(temp));
            return;
        }
        for(int i=idx;i<nums.length;i++){
            temp.add(nums[i]);
            subset(nums,target-nums[i],i+1,temp,res);
            temp.remove(temp.size()-1);
        }
    }
}
