class Solution {
    int parent[];
    int rank[];
    public int[] findRedundantConnection(int[][] edges) {
        int n = edges.length;
        int result[] = new int[2];
        parent = new int[n+1];
        rank = new int[n+1];
        for(int i=1;i<=n;i++){
            parent[i] = i;
            rank[i] = 1;
        }
        for(int edge[]:edges){
            int x = edge[0];
            int y = edge[1];
            if(find(x)==find(y)){
                result[0] = x;
                result[1] = y;
            }else{
                union(x,y);
            }
        }
        return result;        
    }

    private int find(int node){
        if(parent[node]!=node){
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
}
