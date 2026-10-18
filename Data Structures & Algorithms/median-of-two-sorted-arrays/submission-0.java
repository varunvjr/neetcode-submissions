class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        PriorityQueue<Integer>maxHeap = new PriorityQueue<>(Collections.reverseOrder());
        PriorityQueue<Integer>minHeap = new PriorityQueue<>();
        for(int ele:nums1){
            if(maxHeap.isEmpty()||maxHeap.peek()>=ele)
                maxHeap.add(ele);
            else
                minHeap.add(ele);
            if(maxHeap.size()>minHeap.size()+1)
                minHeap.add(maxHeap.poll());
            else if(minHeap.size()>maxHeap.size())
                maxHeap.add(minHeap.poll());
        }
         for(int ele:nums2){
            if(maxHeap.isEmpty()||maxHeap.peek()>=ele)
                maxHeap.add(ele);
            else
                minHeap.add(ele);
            if(maxHeap.size()>minHeap.size()+1)
                minHeap.add(maxHeap.poll());
            else if(minHeap.size()>maxHeap.size())
                maxHeap.add(minHeap.poll());
        }
        if(maxHeap.size()==minHeap.size())
            return (maxHeap.poll()+minHeap.poll())/2.0;
        else
            return maxHeap.poll();
    }
}
