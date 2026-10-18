class Solution {
    private int parent[];
    private int rank[];
    public int countComponents(int n, int[][] edges) {
        int numProvinces = n;
        parent = new int[n];
        rank = new int[n];
        for(int i=0;i<n;i++){
            parent[i] = i;
            rank[i] = 1;
        }
        for(int edge[]:edges){
            int x = edge[0];
            int y= edge[1];
            if(find(x)!=find(y)){
                numProvinces--;
                union(x,y);
            }
        }
        return numProvinces;
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
