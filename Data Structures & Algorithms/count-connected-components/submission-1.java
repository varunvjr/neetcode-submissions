class Solution {
    int parent[];
    int rank[];
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
            int y = edge[1];
            if(find(x)!=find(y)){
                union(x,y);
                numProvinces--;
            }
       
        }
        return numProvinces;
    }
    private int find(int x){
        if(parent[x]!=x){
            parent[x] = find(parent[x]);
        }
        return parent[x];
    }
    private void union(int x,int y){
        int iRep = find(x);
        int jRep = find(y);
        if(iRep == jRep)
            return;
        if(rank[iRep]<rank[jRep]){
            parent[iRep] = jRep;
        }else if(rank[iRep]>rank[jRep]){
            parent[jRep] = iRep;
        }else{
            parent[jRep] = iRep;
            rank[iRep]++;
        }
    }
}
