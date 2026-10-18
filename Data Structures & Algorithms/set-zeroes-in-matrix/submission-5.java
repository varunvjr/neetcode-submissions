class Solution {
    public void setZeroes(int[][] matrix){
        int n = matrix.length;
        boolean row[] = new boolean[n];
        boolean col[] = new boolean[matrix[0].length];
        for(int i=0;i<n;i++){
            for(int j=0;j<matrix[i].length;j++){
                if(matrix[i][j]==0){
                    row[i] = true;
                    col[j] = true;
                }
            }
        }
        for(int i=0;i<n;i++){
            if(row[i]){
                nullifyRow(matrix,i);
            }
        }
        for(int i=0;i<matrix[0].length;i++){
            if(col[i]){
                nullifyCol(matrix,i);
            }
        }
    }
    public void nullifyRow(int mat[][],int row){
        for(int j=0;j<mat[0].length;j++){
            mat[row][j] = 0;
        }
    }
    public void nullifyCol(int mat[][],int col){
        for(int j=0;j<mat.length;j++){
            mat[j][col] = 0;
        }
    }

}
