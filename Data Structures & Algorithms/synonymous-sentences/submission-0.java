class Solution {
    public List<String> generateSentences(
            List<List<String>> synonyms, String text) {

        UnionFind uf = new UnionFind();

        for (List<String> pair : synonyms) {
            String s1 = pair.get(0);
            String s2 = pair.get(1);

            uf.parentMap.putIfAbsent(s1, s1);
            uf.parentMap.putIfAbsent(s2, s2);
            uf.union(s1, s2);
        }

        Map<String, List<String>> rootGroup = new HashMap<>();

        for (String word : uf.parentMap.keySet()) {
            String root = uf.getParent(word); // find the actual root
            rootGroup.computeIfAbsent(root, k -> new ArrayList<>()).add(word);
        }

        List<String> ans = new ArrayList<>();
        backtrack(text.split(" "), 0, new StringBuilder(), ans, rootGroup, uf);

        Collections.sort(ans);
        return ans;
    }

    private void backtrack(String[] words, int index, StringBuilder curr,
                           List<String> ans,
                           Map<String, List<String>> rootGroup,
                           UnionFind uf) {
        if (index == words.length) {
            ans.add(curr.toString());
            return;
        }

        String word = words[index];

        List<String> choices = uf.parentMap.containsKey(word)
                ? rootGroup.get(uf.getParent(word))
                : List.of(word);

        for (String choice : choices) {
            int oldLength = curr.length();

            if (oldLength > 0) curr.append(' ');
            curr.append(choice);

            backtrack(words, index + 1, curr, ans, rootGroup, uf);

            curr.setLength(oldLength); // undo exactly what this iteration added
        }
    }

    class UnionFind {
        Map<String, String> parentMap = new HashMap<>();
        Map<String, Integer> rank = new HashMap<>();

        void union(String s1, String s2) {
            String parent1 = getParent(s1);
            String parent2 = getParent(s2);

            if (parent1.equals(parent2)) return;

            int rank1 = getRank(parent1);
            int rank2 = getRank(parent2);

            if (rank1 > rank2) {
                parentMap.put(parent2, parent1);
            } else if (rank2 > rank1) {
                parentMap.put(parent1, parent2);
            } else {
                parentMap.put(parent2, parent1);
                rank.put(parent1, rank1 + 1);
            }
        }

        String getParent(String node) {
            if (!node.equals(parentMap.get(node))) {
                parentMap.put(node, getParent(parentMap.get(node)));
            }
            return parentMap.get(node);
        }

        int getRank(String node) {
            return rank.getOrDefault(node, 0);
        }
    }
}