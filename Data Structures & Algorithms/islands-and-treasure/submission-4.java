class Solution {
    public void islandsAndTreasure(int[][] grid) {
        Queue<int[]> queue = new ArrayDeque<>();

        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 0) {
                    queue.offer(new int[] {i, j});
                }
            }
        }

        int[][] directions = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
        while (!queue.isEmpty()) {
            int[] curr = queue.poll();

            for (int[] direction : directions) {
                int row = direction[0] + curr[0];
                int col = direction[1] + curr[1];

                if (row < 0 || col < 0 || row >= grid.length || col >= grid[0].length
                    || grid[row][col] != Integer.MAX_VALUE) {
                    continue;
                }

                grid[row][col] = 1 + grid[curr[0]][curr[1]];
                queue.offer(new int[] {row, col});
            }
        }
    }
}
