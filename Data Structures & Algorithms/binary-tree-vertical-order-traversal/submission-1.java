class Solution {
    public List<List<Integer>> verticalOrder(TreeNode root) {
        if (root == null) return new ArrayList<>();
        Map<Integer, List<Integer>> nodesList = new TreeMap<>();
        Queue<Pair<TreeNode, Integer>> queue = new LinkedList<>();
        queue.add(new Pair<>(root, 0));

        while (!queue.isEmpty()) {
            Pair<TreeNode, Integer> p = queue.poll();
            TreeNode node = p.node;
            int curr = p.col;

            nodesList.computeIfAbsent(curr, k -> new ArrayList<>()).add(node.val);

            if (node.left != null) {
                queue.add(new Pair<>(node.left, curr - 1));
            }
            if (node.right != null) {
                queue.add(new Pair<>(node.right, curr + 1));
            }
        }

        List<List<Integer>> ans = new ArrayList<>();
        for (Map.Entry<Integer, List<Integer>> entry : nodesList.entrySet()) {
            ans.add(entry.getValue());
        }
        return ans;
    }

    private static class Pair<K, V> {
        K node;
        V col;
        Pair(K node, V col) { this.node = node; this.col = col; }
    }
}