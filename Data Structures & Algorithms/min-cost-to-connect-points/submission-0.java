class Solution {
    private int parent[];
    private int rank[];
    public int minCostConnectPoints(int[][] points) {
        int n = points.length;
        parent = new int[n];
        rank = new int[n];
        for(int i=0;i<n;i++){
            parent[i] = i;
            rank[i] = 1;
        }
        List<int[]>edges = new ArrayList<>();
        for(int i=0;i<n;i++){
            for(int j=i+1;j<n;j++){
                int x1 = points[i][0];
                int y1 = points[i][1];
                int x2 = points[j][0];
                int y2 = points[j][1];
                int dist = Math.abs(x1-x2)+Math.abs(y1-y2);
                edges.add(new int[]{i,j,dist});
            }
        }
        int ans = 0;
        Collections.sort(edges,(a,b)->a[2]-b[2]);
        for(int edge[]:edges){
            int x = edge[0];
            int y = edge[1];
            int dist = edge[2];
            if(find(x)!=find(y)){
                ans+=dist;
                union(x,y);
            }
        }
        return ans;
    }
    public int find(int node){
        if(parent[node]!=node){
            parent[node] = find(parent[node]);
        }
        return parent[node];
    }
    public void union(int x,int y){
        int irep = find(x);
        int jrep = find(y);
        if(irep == jrep)
            return;
        if(rank[irep]<rank[jrep]){
            parent[irep] = jrep;
        }else if(rank[irep]>rank[jrep]){
            parent[jrep] = irep;
        }else{
            parent[jrep] = irep;
            rank[irep]++;
        }
    }
}
