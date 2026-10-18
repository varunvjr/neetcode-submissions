public static class Pair{
    int row;
    int col;
    int time;
    Pair(int r,int c,int t){
        row = r;
        col = c;
        time = t;
    }
}
class Solution {
    public int orangesRotting(int[][] grid) {
        int freshOranges = 0;
        Queue<Pair>queue = new LinkedList<>();
        for(int i=0;i<grid.length;i++){
            for(int j=0;j<grid[0].length;j++){
                if(grid[i][j]==1){
                    freshOranges++;
                }else if(grid[i][j]==2){
                    queue.add(new Pair(i,j,0));
                }
            }
        }
        int maxTime = 0;
        int directions[][] = {{1,0},{-1,0},{0,1},{0,-1}};
        while(!queue.isEmpty()){
            Pair p = queue.poll();
            int currow = p.row;
            int curcol = p.col;
            int curtime = p.time;

            maxTime = Math.max(maxTime,curtime);
            for(int dir[]:directions){
                int nextrow = currow+dir[0];
                int nextcol = curcol+dir[1];
               

                if(nextrow>=0&&nextrow<grid.length&&nextcol>=0&&nextcol<grid[0].length){ // boundary condition
                    if(grid[nextrow][nextcol]==1){ // found a fresh fruit;
                        freshOranges--;  // decrement the count
                        grid[nextrow][nextcol] = 2; // Will become rotten
                        queue.add(new Pair(nextrow,nextcol,curtime+1));
                    }
                }
            }
        }
        return freshOranges==0?maxTime:-1;
    }
}
