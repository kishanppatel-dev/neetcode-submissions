class Solution {
    int direction[][] = {{1, 0}, {0, 1}, {-1, 0}, {0, -1}};

    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        int n = heights.length;
        int m = heights[0].length;
        boolean[][] pacificReachable = new boolean[n][m];
        boolean[][] atlanticReachable = new boolean[n][m];
        List<List<Integer>> res = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            dfs(heights, pacificReachable, i, 0);
            dfs(heights, atlanticReachable, i, m - 1);
        }

        for (int j = 0; j < m; j++) {
            dfs(heights, pacificReachable, 0, j);
            dfs(heights, atlanticReachable, n - 1, j);
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (pacificReachable[i][j] && atlanticReachable[i][j]) {
                    res.add(Arrays.asList(i, j));
                }
            }
        }

        return res;
    }

    private void dfs(int[][] heights, boolean[][] reachable, int r, int c) {
        int n = heights.length;
        int m = heights[0].length;

        reachable[r][c] = true;

        for (int[] dir : direction) {
            int nr = r + dir[0];
            int nc = c + dir[1];

            if (nr >= 0 && nr < n && nc >= 0 && nc < m && heights[nr][nc] >= heights[r][c]
                && !reachable[nr][nc]) {
                    dfs(heights, reachable, nr, nc);
            }
        }
    }
}
