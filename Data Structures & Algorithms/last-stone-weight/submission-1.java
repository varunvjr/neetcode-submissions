class Solution {
    public int lastStoneWeight(int[] stones) {
        PriorityQueue<Integer>maxHeap = new PriorityQueue<>((n1,n2)->n2-n1);
        for(int stone:stones){
            maxHeap.add(stone);
        }
        while(maxHeap.size()>1){
            int y = maxHeap.poll();
            int x = maxHeap.poll();
            if(x<y){
                y = y-x;
                maxHeap.add(y);
            }
        }
        return maxHeap.size()==0?0:maxHeap.peek();
    }
}
