class Solution {
    public boolean isValidSudoku(char[][] board) {
        HashSet<String>set = new HashSet<>();
        for(int i=0;i<board.length;i++){
            for(int j=0;j<board[i].length;j++){
                if(board[i][j]!='.'){
                    String row = "Element Present at row :"+i+" is "+board[i][j];
                    String col = "Element Present at col :"+j+" is "+board[i][j];
                    String cell = "Element Present at cell :"+i/3+""+j/3+" is "+board[i][j];
                    if(set.contains(row)||set.contains(col)||set.contains(cell))
                        return false;
                    else{
                        set.add(row);
                        set.add(col);
                        set.add(cell);
                    }  
                }
            }
        }
        return true;   
    }
}
