class Solution {
    public List<List<String>> solveNQueens(int n) {
        char board[][] = new char[n][n];
        List<List<String>>result = new ArrayList<>();
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                board[i][j] = '.';
            }
        }
        dfs(board,n,0,result);
        return result;
    }
    public void dfs(char board[][],int n,int row,List<List<String>>result){
        if(row==n){
            constructBoard(result,board);
            return;
        }
        for(int col=0;col<n;col++){
            if(canPlaceQueen(board,row,col,n)){
                board[row][col] = 'Q';
                dfs(board,n,row+1,result);
                board[row][col] = '.';
            }
        }
    }
    public boolean canPlaceQueen(char board[][],int row,int col,int n){
        for(int i=0;i<row;i++){
            if(board[i][col]=='Q')
                return false;
        }
        for(int i=row-1,j=col-1;i>=0&&j>=0;i--,j--){
            if(board[i][j]=='Q')
                return false;
        }
        for(int i=row-1,j=col+1;i>=0&&j<n;i--,j++){
            if(board[i][j]=='Q')
                return false;
        }
        return true;
    }
    public void constructBoard(List<List<String>>result,char board[][]){
        List<String>temp = new ArrayList<>();
        for(char row[]:board){
            temp.add(new String(row));
        }
        result.add(new ArrayList<>(temp));
    }
}
