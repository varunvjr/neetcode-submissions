class Solution {
    private int parent[];
    private int rank[];
    public int[] findRedundantConnection(int[][] edges) {
        int n = edges.length;
        List<int[]>result = new ArrayList<>();
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
                result.add(new int[]{x,y});
            }else{
                union(x,y);
            }
        }
        return result.get(result.size()-1);
    }
    public int find(int node){
        if(node!=parent[node]){
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
