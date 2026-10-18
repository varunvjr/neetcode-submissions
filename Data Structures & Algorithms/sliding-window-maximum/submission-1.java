class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        int res[] = new int[nums.length-k+1];
        int winStart = 0;
        int max = 0;
        PriorityQueue<Integer>maxHeap = new PriorityQueue<>(Collections.reverseOrder());
        for(int winEnd = 0;winEnd<nums.length;winEnd++){
            maxHeap.add(nums[winEnd]);
            if(winEnd>=k-1){
                res[winStart] = maxHeap.peek();
                maxHeap.remove(nums[winStart++]);
            }
        }
        return res;
    }
}
