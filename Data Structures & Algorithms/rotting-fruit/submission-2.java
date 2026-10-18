class Solution {
    public int orangesRotting(int[][] grid) {
        int fresh = 0;
        int directions[][] = {{1,0},{-1,0},{0,1},{0,-1}};
        Queue<int[]>queue = new LinkedList<>();
        for(int i=0;i<grid.length;i++){
            for(int j=0;j<grid[0].length;j++){
                if(grid[i][j]==1)
                    fresh++;
                else if(grid[i][j]==2){
                    queue.add(new int[]{i,j,0});
                }
            }
        }
        int time = 0;
        while(!queue.isEmpty()){
            int node[] = queue.remove();
            int currow = node[0];
            int curcol = node[1];
            int curTime = node[2];
            time = Math.max(curTime,time);
            for(int dir[]:directions){
                int nextrow = currow+dir[0];
                int nextcol = curcol+dir[1];
                if(nextrow>=0&&nextrow<grid.length&&nextcol>=0&&nextcol<grid[0].length){
                    if(grid[nextrow][nextcol]==1){
                        grid[nextrow][nextcol] = 2; // make the fruit rotten;
                        fresh--;
                        queue.add(new int[]{nextrow,nextcol,curTime+1});
                    }
                }
            }
        }
        return fresh==0?time:-1;
    }
}
