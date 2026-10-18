

class Pair {
    int row;
    int col;

    Pair(int r, int c) {
        row = r;
        col = c;
    }
}

class Solution {
    // Directions for moving up, down, left, and right
    private static final int[][] directions = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};

    public int maxAreaOfIsland(int[][] grid) {
        int maxArea = 0;

        // Traverse the entire grid
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                // Start BFS if a cell is part of an island (value == 1)
                if (grid[i][j] == 1) {
                    maxArea = Math.max(maxArea, bfs(i, j, grid));
                }
            }
        }
        return maxArea;
    }

    private int bfs(int row, int col, int[][] grid) {
        Queue<Pair> queue = new LinkedList<>();
        queue.add(new Pair(row, col));
        grid[row][col] = 0; // Mark the cell as visited
        int area = 0;

        while (!queue.isEmpty()) {
            Pair current = queue.poll();
            area++;

            // Explore all valid neighbors
            for (int[] dir : directions) {
                int nextRow = current.row + dir[0];
                int nextCol = current.col + dir[1];

                if (nextRow >= 0 && nextRow < grid.length && nextCol >= 0 && nextCol < grid[0].length && grid[nextRow][nextCol] == 1) {
                    queue.add(new Pair(nextRow, nextCol));
                    grid[nextRow][nextCol] = 0; // Mark as visited
                }
            }
        }
        return area;
    }
}
