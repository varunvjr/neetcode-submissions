class Solution {
    public boolean exist(char[][] board, String word) {
        for(int i=0;i<board.length;i++){
            for(int j=0;j<board[i].length;j++){
                if(board[i][j]==word.charAt(0)){
                    if(dfs(i,j,board,word,0))
                        return true;
                }
            }
        }
        return false;
    }
    public boolean dfs(int row,int col,char board[][],String word,int idx){
        if(row<0||row>=board.length||col<0||col>=board[0].length||board[row][col]!=word.charAt(idx))
            return false;
        if(idx==word.length()-1)
            return true;
        char ch = board[row][col];
        board[row][col] = '#';
        boolean found = dfs(row+1,col,board,word,idx+1)||dfs(row-1,col,board,word,idx+1)||dfs(row,col+1,board,word,idx+1)||dfs(row,col-1,board,word,idx+1);
        board[row][col] = ch;
        return found; 
    }
}
