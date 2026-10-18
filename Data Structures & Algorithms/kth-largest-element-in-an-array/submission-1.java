class Solution {
    public int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer>minHeap = new PriorityQueue<>((n1,n2)->n1-n2);
        for(int i=0;i<k;i++){
            minHeap.add(nums[i]);
        }
        for(int i=k;i<nums.length;i++){
            if(!minHeap.isEmpty()&&minHeap.peek()<nums[i]){
                minHeap.poll();
                minHeap.add(nums[i]);
            }
        }
        return minHeap.poll();
    }
}
