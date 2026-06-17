class Solution {
    int count = 0;

    public int islandPerimeter(int[][] grid) {
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 1) {
                    return dfs(grid, i, j);
                }
            }
        }

        return 0;
    }

    private int dfs(int[][] grid, int row, int col) {
        if (row < 0 || col < 0 || row >= grid.length || col >= grid[0].length
            || grid[row][col] == 0) {
            return 1;
        }

        if (grid[row][col] == -1) {
            return 0;
        }

        grid[row][col] = -1;

        int perimeter = 0;
        perimeter += dfs(grid, row - 1, col);
        perimeter += dfs(grid, row + 1, col);
        perimeter += dfs(grid, row, col - 1);
        perimeter += dfs(grid, row, col + 1);

        return perimeter;
    }
}