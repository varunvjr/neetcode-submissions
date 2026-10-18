class Solution {
    private int parent[];
    private int rank[];
    public boolean validTree(int n, int[][] edges) {
         if (edges.length != n - 1) {
            return false;
        }
        parent = new int[n];
        rank = new int[n];
        for(int i=0;i<n;i++){
            parent[i] = i;
            rank[i] = 1;
        }
        for(int edge[]:edges){
            int x = edge[0];
            int y = edge[1];
            System.out.println(x+"--->"+y);
            if(find(x)==find(y)){
                return false;
            }
            union(x,y);
        }
        return true;
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
