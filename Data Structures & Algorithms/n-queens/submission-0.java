class Solution {
    public List<List<String>> solveNQueens(int n) {

        List<List<String>> ans = new ArrayList<>();

        List<List<String>> board = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            List<String> row = new ArrayList<>();

            for (int j = 0; j < n; j++) {
                row.add(".");
            }

            board.add(row);
        }

        Set<Integer> col = new HashSet<>();
        Set<Integer> nd = new HashSet<>();
        Set<Integer> pd = new HashSet<>();

        solve(board, 0, col, nd, pd, n, ans);

        return ans;
    }

    private void solve(
        List<List<String>> board,
        int row,
        Set<Integer> col,
        Set<Integer> nd,
        Set<Integer> pd,
        int n,
        List<List<String>> ans
    ) {

        if (row == n) {

            // Create a copy of the current board
            List<String> solution = new ArrayList<>();

            for (List<String> currRow : board) {
                solution.add(String.join("", currRow));
            }

            ans.add(solution);
            return;
        }

        for (int i = 0; i < n; i++) {

            int currNd = row - i;
            int currPd = row + i;

            if (!col.contains(i)
                    && !nd.contains(currNd)
                    && !pd.contains(currPd)) {

                // choose
                col.add(i);
                nd.add(currNd);
                pd.add(currPd);

                board.get(row).set(i, "Q");

                // explore
                solve(board, row + 1, col, nd, pd, n, ans);

                // backtrack
                col.remove(i);
                nd.remove(currNd);
                pd.remove(currPd);

                board.get(row).set(i, ".");
            }
        }
    }
}