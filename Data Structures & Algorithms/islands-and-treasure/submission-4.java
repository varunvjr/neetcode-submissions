
class Solution {
    public void islandsAndTreasure(int[][] grid) {
        int direction[][] = {{1,0},{-1,0},{0,1},{0,-1}};
        Queue<int[]>queue = new LinkedList<>();
        boolean visited[][] = new boolean[grid.length][grid[0].length];
        for(int i=0;i<grid.length;i++){
            for(int j=0;j<grid[0].length;j++){
                if(grid[i][j] == 0){
                    queue.add(new int[]{i,j});
                }
            }
        }
        while(!queue.isEmpty()){
            int node[] = queue.poll();
            int currow = node[0];
            int curcol = node[1];
            visited[currow][curcol] = true;
            for(int dir[]:direction){
                int nextrow = currow+dir[0];
                int nextcol = curcol+dir[1];
                if(nextrow>=0&&nextrow<grid.length&&nextcol>=0&&nextcol<grid[0].length&&grid[nextrow][nextcol]!=-1){
                    if(!visited[nextrow][nextcol]){
                        grid[nextrow][nextcol] = grid[currow][curcol]+1;
                        visited[nextrow][nextcol] = true;
                        queue.add(new int[]{nextrow,nextcol});
                    }
                }
            }
        }        
    }
}
