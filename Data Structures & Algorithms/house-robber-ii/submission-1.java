class Solution {
    public int rob(int[] nums) {
        int n = nums.length;
        if(nums.length==1)
            return nums[0];
        if(nums.length==2)
            return Math.max(nums[0],nums[1]);
        List<Integer>list = new ArrayList<>();
        int firstHouse[] = new int[n-1];
        int lastHouse[] = new int[n-1];
        for(int i=0;i<n-1;i++){
            list.add(nums[i]);
        }
        int size = list.size();
        int cache[] = new int[size];
        Arrays.fill(cache,-1);
        dfs(list,size-1,cache);
        int max1 = Math.max(cache[size-1],cache[size-2]);
        list = new ArrayList<>();
        for(int i=1;i<n;i++){
            list.add(nums[i]);
        }
        size = list.size();
        Arrays.fill(cache,-1);
        dfs(list,size-1,cache);
        int max2 = Math.max(cache[size-1],cache[size-2]);
        return Math.max(max1,max2);
    }
    public int dfs(List<Integer>nums,int n,int cache[]){
        if(n<0){
            return 0;
        }
        if(cache[n]!=-1)
            return cache[n];
        return cache[n] = Math.max(nums.get(n)+dfs(nums,n-2,cache),dfs(nums,n-1,cache));
    }
}
