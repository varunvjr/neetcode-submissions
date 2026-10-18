class Solution {
    public int uniquePaths(int m, int n) {
        int cache[][] = new int[m][n];
        return dfs(cache,m,n,0,0);
    }
    public int dfs(int cache[][],int m,int n,int i,int j){
        if(i==m-1&&j==n-1)
            return 1;
        if(i>=m||j>=n)
            return 0;
        cache[i][j] = dfs(cache,m,n,i+1,j)+dfs(cache,m,n,i,j+1);
        return cache[i][j];
    }
}
