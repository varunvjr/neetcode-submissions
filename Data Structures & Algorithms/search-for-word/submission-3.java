class Solution {
    public boolean exist(char[][] board, String word) {
        for(int i = 0;i<board.length;i++){
            for(int j = 0;j<board[0].length;j++){
                if(board[i][j]==word.charAt(0)){
                    if(found(board,word,0,i,j))
                        return true;
                }
            }
        }
        return false;       
    }
    private boolean found(char board[][],String word,int idx,int row,int col){
        if(idx==word.length())
            return true;
        if(row<0||row>=board.length||col<0||col>=board[0].length||board[row][col]!=word.charAt(idx)||board[row][col]=='#')
            return false;
        char ch = board[row][col];
        board[row][col] = '#';
        boolean flag = found(board,word,idx+1,row+1,col)||found(board,word,idx+1,row-1,col)||found(board,word,idx+1,row,col-1)||found(board,word,idx+1,row,col+1);
        board[row][col] = ch;
        return flag;
    }
}
