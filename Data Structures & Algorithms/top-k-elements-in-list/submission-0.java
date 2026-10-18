class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        HashMap<Integer,Integer>map = new HashMap<>();
        for(int ele:nums){
            map.put(ele,map.getOrDefault(ele,0)+1);
        }
        List<Integer>list = new ArrayList<>(map.keySet());
        Collections.sort(list,(a,b)->map.get(b)-map.get(a));
        int res[] = new int[k];
        int idx = 0;
        for(int i=0;i<k;i++){
            res[idx++] = list.get(i);
        } 
        return res;
    }
}
