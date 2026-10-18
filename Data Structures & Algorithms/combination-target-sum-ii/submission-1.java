class Solution {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>>result = new ArrayList<>();
        List<Integer>temp = new ArrayList<>();
        Arrays.sort(candidates);
        subset(candidates,target,0,result,temp);
        return result;
    }
    public void subset(int candidates[],int target,int idx,List<List<Integer>>result,List<Integer>temp){
        if(target<=0){
            if(target==0&&!result.contains(temp)){
                result.add(new ArrayList<>(temp));
            }
            return;
        }
        for(int i=idx;i<candidates.length;i++){
            temp.add(candidates[i]);
            subset(candidates,target-candidates[i],i+1,result,temp);
            temp.remove(temp.size()-1);
        }
    }
}
