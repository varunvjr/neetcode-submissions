class MedianFinder {
    PriorityQueue<Integer>maxHeap; 
    PriorityQueue<Integer>minHeap; 
    public MedianFinder() {
        maxHeap = new PriorityQueue<>((n1,n2)->n2-n1);
        minHeap = new PriorityQueue<>((n1,n2)->n1-n2);
    }
    
    public void addNum(int num) {
        if(maxHeap.isEmpty()||maxHeap.peek()>=num)
            maxHeap.add(num);
        else
            minHeap.add(num);
        if(maxHeap.size()>minHeap.size()+1){
            minHeap.add(maxHeap.poll());
        }else if(minHeap.size()>maxHeap.size()){
            maxHeap.add(minHeap.poll());
        }
    }
    
    public double findMedian() {
       if(maxHeap.size()==minHeap.size()){
            return (maxHeap.peek()+minHeap.peek())/2.0;
       }else{
            return maxHeap.peek();
       }
    }
}
