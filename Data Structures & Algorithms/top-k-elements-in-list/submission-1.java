class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        HashMap<Integer,Integer>map = new HashMap<>();
        for(int ele:nums){
            map.put(ele,map.getOrDefault(ele,0)+1);
        }
        PriorityQueue<Map.Entry<Integer,Integer>>maxQueue = new PriorityQueue<>((n1,n2)->n2.getValue()-n1.getValue());
        for(Map.Entry<Integer,Integer>entry:map.entrySet()){
            maxQueue.add(entry);
        }
        int result[] = new int[k];
        for(int i=0;i<k;i++){
            int key = maxQueue.poll().getKey();
            result[i] = key;
        }
        return result;
    }
}
