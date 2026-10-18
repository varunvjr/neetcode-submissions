class Solution {
    public boolean isValidSudoku(char[][] board) {
        HashSet<String>set = new HashSet<>();
        for(int i=0;i<board.length;i++){
            for(int j=0;j<board[i].length;j++){
                char ch = board[i][j];
                if(ch!='.'){
                    String rowCombination = ch+"present in row:"+i;
                    String colCombination = ch+"present in col:"+j;
                    String boxCombination = ch+"present in box:"+i/3+j/3;
                    if(set.contains(rowCombination)||set.contains(colCombination)||set.contains(boxCombination)){
                        return false;
                    }else{
                        set.add(rowCombination);
                        set.add(colCombination);
                        set.add(boxCombination);
                    }
                }
            }
        }
        return true;
    }
}
