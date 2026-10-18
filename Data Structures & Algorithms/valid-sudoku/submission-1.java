class Solution {
    public boolean isValidSudoku(char[][] board) {
        HashSet<String>set = new HashSet<>();
        for(int i=0;i<board.length;i++){
            for(int j=0;j<board[i].length;j++){
                if(board[i][j]!='.'){
                    char ch = board[i][j];
                    if(set.contains(ch+"is present in row"+i)||set.contains(ch+"is present in col"+j)||set.contains(ch+"set present in box"+i/3+""+j/3))
                        return false;
                    else{
                        set.add(ch+"is present in row"+i);
                        set.add(ch+"is present in col"+j);
                        set.add(ch+"set present in box"+i/3+""+j/3);
                    }
                }
            }
        }
        return true;
    }
}
