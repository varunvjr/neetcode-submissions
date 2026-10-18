class Solution {
    int parent[];
    int rank[];
    public int[] findRedundantConnection(int[][] edges) {
        int n = edges.length;
        parent = new int[n+1];
        rank = new int[n+1];
        initialize(n);
        int res[] = new int[2];
        for(int edge[]:edges){
            int src = edge[0];
            int dest = edge[1];
            if(find(src)!=find(dest)){
                union(src,dest);
            }else{
                res[0] = src;
                res[1] = dest;
            }
        }
        return res;
    }
    private int find(int node){
        if(node!=parent[node]){
            parent[node] = find(parent[node]);
        }
        return parent[node];
    }
    private void union(int x,int y){
        int irep = find(x);
        int jrep = find(y);
        if(rank[irep]<rank[jrep]){
            parent[irep] = jrep;
        }else if(rank[irep]>rank[jrep]){
            parent[jrep] = irep;
        }else{
            parent[jrep] = irep;
            rank[irep]++;
        }
    }
    private void initialize(int n){
        for(int i=1;i<=n;i++){
            parent[i] = i;
            rank[i] = 1;
        }
    }
}
