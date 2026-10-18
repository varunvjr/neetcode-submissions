class Solution {
    public void solve(char[][] board) {
        int directions[][] = {{1,0},{-1,0},{0,1},{0,-1}};
        Queue<int[]>queue = new LinkedList<>();
        for(int i=0;i<board.length;i++){
            if(board[i][0]=='O')
                queue.add(new int[]{i,0});
            if(board[i][board[0].length-1]=='O')
                queue.add(new int[]{i,board[0].length-1});
        }
        for(int j=0;j<board[0].length;j++){
            if(board[0][j]=='O')
                queue.add(new int[]{0,j});
            if(board[board.length-1][j]=='O')
                queue.add(new int[]{board.length-1,j});
        }
        boolean visited[][] = new boolean[board.length][board[0].length];
        while(!queue.isEmpty()){
            int state[] = queue.poll();
            int currow = state[0];
            int curcol = state[1];
            board[currow][curcol] = '*';
            visited[currow][curcol] = true;
            for(int dir[]:directions){
                int nextrow = currow+dir[0];
                int nextcol = curcol+dir[1];
                if(nextrow>=0&&nextrow<board.length&&nextcol>=0&&nextcol<board[0].length&&!visited[nextrow][nextcol]){
                    if(board[nextrow][nextcol]=='O'){
                        board[nextrow][nextcol] = '*';
                        queue.add(new int[]{nextrow,nextcol});
                    }
                    visited[nextrow][nextcol] = true;
                }
            }
        }
        for(int i=0;i<board.length;i++){
            for(int j=0;j<board[0].length;j++){
                if(board[i][j]=='O'){
                    board[i][j] = 'X';
                }else if(board[i][j] == '*'){
                    board[i][j] = 'O';
                }
            }
        }
    }
}
