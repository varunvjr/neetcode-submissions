class Solution {
    public int leastInterval(char[] tasks, int n) {
        int count[] = new int[26];
        Queue<int[]>queue = new LinkedList<>();
        PriorityQueue<Integer>maxHeap = new PriorityQueue<>((n1,n2)->n2-n1);
        for(char task:tasks){
            count[task-'A']++;
        }
        for(int cnt:count){
            if(cnt>0)
                maxHeap.add(cnt);
        }
        int time = 0;
        while(!maxHeap.isEmpty()||!queue.isEmpty()){
            time++;
            if(maxHeap.isEmpty()){
                time = queue.peek()[1];
            }else{
                int cnt = maxHeap.poll()-1;
                if(cnt>0)
                    queue.add(new int[]{cnt,time+n});
            }
            if(!queue.isEmpty()&&queue.peek()[1]==time){
                maxHeap.add(queue.poll()[0]);
            }
        }
        return time;
    }
}
