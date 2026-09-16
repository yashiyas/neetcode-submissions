class Solution {

    int ans = 0;

    public int longestConsecutive(TreeNode root) {
        solve(root);
        return ans;
    }

    private int[] solve(TreeNode root) {

        if (root == null) {
            return new int[]{0, 0};
        }

        int[] left = solve(root.left);
        int[] right = solve(root.right);

        int inc = 1;
        int dec = 1;

        if (root.left != null) {

            if (root.left.val == root.val + 1) {
                inc = Math.max(inc, left[0] + 1);
            }

            if (root.left.val == root.val - 1) {
                dec = Math.max(dec, left[1] + 1);
            }
        }

        if (root.right != null) {

            if (root.right.val == root.val + 1) {
                inc = Math.max(inc, right[0] + 1);
            }

            if (root.right.val == root.val - 1) {
                dec = Math.max(dec, right[1] + 1);
            }
        }

        ans = Math.max(ans, inc + dec - 1);

        return new int[]{inc, dec};
    }
}