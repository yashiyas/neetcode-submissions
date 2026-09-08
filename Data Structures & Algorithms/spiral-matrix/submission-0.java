class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {

        List<Integer> ans = new ArrayList<>();

        int m = matrix.length;
        int n = matrix[0].length;

        int k = 0;

        while (ans.size() < m * n) {

            // Top row
            for (int j = k; j < n - k; j++) {
                ans.add(matrix[k][j]);
            }

            // Right column
            for (int i = k + 1; i < m - k; i++) {
                ans.add(matrix[i][n - k - 1]);
            }

            // Bottom row
            if (m - 1 - k > k) {
                for (int j = n - 2 - k; j >= k; j--) {
                    ans.add(matrix[m - k - 1][j]);
                }
            }

            // Left column
            if (n - 1 - k > k) {
                for (int i = m - 2 - k; i > k; i--) {
                    ans.add(matrix[i][k]);
                }
            }

            k++;
        }

        return ans;
    }
}