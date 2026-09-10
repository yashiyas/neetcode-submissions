class Solution {
    public TreeNode buildTree(int[] preorder, int[] inorder) {

        if (preorder == null || preorder.length == 0) {
            return null;
        }

        int n = preorder.length;

        Map<Integer, Integer> inorderIndexes = new HashMap<>();

        for (int i = 0; i < inorder.length; i++) {
            inorderIndexes.put(inorder[i], i);
        }

        return build(
            0, n - 1,
            0, n - 1,
            preorder,
            inorder,
            inorderIndexes
        );
    }

    private TreeNode build(
        int preStart,
        int preEnd,
        int inStart,
        int inEnd,
        int[] preorder,
        int[] inorder,
        Map<Integer, Integer> inorderIndexes
    ) {

        if (preStart > preEnd || inStart > inEnd) {
            return null;
        }

        int currVal = preorder[preStart];

        TreeNode curr = new TreeNode(currVal);

        int mid = inorderIndexes.get(currVal);

        // Number of nodes in left subtree
        int leftSize = mid - inStart;

        // Left subtree
        curr.left = build(
            preStart + 1,
            preStart + leftSize,
            inStart,
            mid - 1,
            preorder,
            inorder,
            inorderIndexes
        );

        // Right subtree
        curr.right = build(
            preStart + leftSize + 1,
            preEnd,
            mid + 1,
            inEnd,
            preorder,
            inorder,
            inorderIndexes
        );

        return curr;
    }
}