class Solution {
    public int networkDelayTime(int[][] times, int n, int k) {
        List<List<int[]>>adj = new ArrayList<>();
        for(int i=0;i<=n;i++){
            adj.add(i,new ArrayList<>());
        }
        for(int time[]:times){
            int src = time[0];
            int dest = time[1];
            int cost = time[2];
            adj.get(src).add(new int[]{dest,cost});
        }
        int distance[] = new int[n+1];
        for(int i=1;i<=n;i++){
            distance[i] = Integer.MAX_VALUE;
        }
        distance[k] = 0;
        Queue<int[]>queue = new LinkedList<>();
        queue.add(new int[]{k,0});
        while(!queue.isEmpty()){
            int pair[] = queue.remove();
            int node = pair[0];
            int cost = pair[1];
            for(int neighbor[]:adj.get(node)){
                int nextNode = neighbor[0];
                int wt = neighbor[1];
                if(wt+cost<distance[nextNode]){
                    distance[nextNode] = wt+cost;
                    queue.add(new int[]{nextNode,wt+cost});
                }
            }
        }
        int ans = Integer.MIN_VALUE;
        for(int i=1;i<=n;i++){
            ans = Math.max(ans,distance[i]);
        }
        return ans==Integer.MAX_VALUE?-1:ans;
    }
}
