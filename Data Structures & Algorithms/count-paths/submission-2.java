class Solution {
    public int uniquePaths(int m, int n) {
        int cache[][] = new int[m][n];
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                cache[i][j] = -1;
            }
        }
        return dfs(cache,0,0,m,n);
    }
    private int dfs(int cache[][],int i,int j,int m, int n){
        if(i==m-1&&j==n-1)
            return 1;
        if(i>=m||j>=n)
            return 0;
        if(cache[i][j]!=-1)
            return cache[i][j];
        cache[i][j] = dfs(cache,i+1,j,m,n)+dfs(cache,i,j+1,m,n);
        return cache[i][j];
    }
}
