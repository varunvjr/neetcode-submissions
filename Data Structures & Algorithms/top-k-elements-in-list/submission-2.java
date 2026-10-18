class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        HashMap<Integer,Integer>map = new HashMap<>();
        for(int i=0;i<nums.length;i++){
            map.put(nums[i],map.getOrDefault(nums[i],0)+1);
        }
        PriorityQueue<Integer>queue = new PriorityQueue<>(((a, b) -> map.get(b).compareTo(map.get(a))));
       queue.addAll(map.keySet());
        int res[] = new int[k];
        int idx = 0;
        while(k>0&&!queue.isEmpty()){
            int ele = queue.poll();
            System.out.println(ele);
            res[idx++] = ele;
            k--;
        }
        return res;
    }
}
