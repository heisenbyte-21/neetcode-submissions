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

        int[][] directions = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};

        while (!queue.isEmpty()) {
            int[] current = queue.poll();
            int row = current[0];
            int col = current[1];

            for (int[] direction : directions) {
                int newRow = row + direction[0];
                int newCol = col + direction[1];

                if (newRow < 0 || newCol < 0 || newRow >= grid.length || newCol >= grid[0].length
                    || grid[newRow][newCol] != Integer.MAX_VALUE) {
                    continue;
                }

                grid[newRow][newCol] = grid[row][col] + 1;

                queue.offer(new int[] {newRow, newCol});
            }
        }
    }
}
