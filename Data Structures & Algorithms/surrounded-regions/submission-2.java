class Solution {
    public void solve(char[][] board) {
        if (board == null || board.length == 0) return;

        int directions[][] = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
        Queue<int[]> queue = new LinkedList<>();

        // Add boundary 'O' cells to the queue
        int rows = board.length, cols = board[0].length;
        for (int i = 0; i < rows; i++) {
            if (board[i][0] == 'O') queue.add(new int[]{i, 0});
            if (board[i][cols - 1] == 'O') queue.add(new int[]{i, cols - 1});
        }
        for (int j = 0; j < cols; j++) {
            if (board[0][j] == 'O') queue.add(new int[]{0, j});
            if (board[rows - 1][j] == 'O') queue.add(new int[]{rows - 1, j});
        }

        // BFS to mark connected 'O' regions as '*'
        while (!queue.isEmpty()) {
            int[] state = queue.poll();
            int curRow = state[0], curCol = state[1];
            board[curRow][curCol] = '*';

            for (int[] dir : directions) {
                int nextRow = curRow + dir[0], nextCol = curCol + dir[1];
                if (nextRow >= 0 && nextRow < rows && nextCol >= 0 && nextCol < cols && board[nextRow][nextCol] == 'O') {
                    queue.add(new int[]{nextRow, nextCol});
                }
            }
        }

        // Flip remaining 'O' to 'X' and '*' back to 'O'
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (board[i][j] == 'O') board[i][j] = 'X';
                else if (board[i][j] == '*') board[i][j] = 'O';
            }
        }
    }
}
