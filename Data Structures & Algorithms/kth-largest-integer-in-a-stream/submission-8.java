class KthLargest {
    PriorityQueue<Integer>minHeap = new PriorityQueue<>();
    int capacity;
    public KthLargest(int k, int[] nums) {
        capacity = k;
        if(nums.length<k){
            k = nums.length;
        }
        for(int i=0;i<k;i++){
            minHeap.add(nums[i]);
        }
    
        for(int i=k;i<nums.length;i++){
            if(!minHeap.isEmpty()&&minHeap.peek()<nums[i]){
                minHeap.poll();
                minHeap.add(nums[i]);
            }
        }
    }
    
    public int add(int val) {
        if(minHeap.size()<capacity)
            minHeap.add(val);
        else{
            if(minHeap.peek()<val){
                minHeap.poll();
                minHeap.add(val);
            }
        }
        return minHeap.peek();
    }
}
