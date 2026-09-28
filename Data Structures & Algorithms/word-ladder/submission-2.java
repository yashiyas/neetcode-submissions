class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {

        Map<String, List<String>> adjList = new HashMap();
        
        List<String> allWords = new ArrayList<>(wordList);
        if(!allWords.contains(beginWord)){
            allWords.add(beginWord);
        }

        for(int i=0; i<allWords.size(); i++){
            String word1 = allWords.get(i);
            for(int j=i+1; j<allWords.size(); j++){
                String word2 = allWords.get(j);
                if(isPossible(word1, word2)){
                    adjList.computeIfAbsent(word1, k->new ArrayList());
                    adjList.computeIfAbsent(word2, k->new ArrayList());
                    adjList.get(word1).add(word2);
                    adjList.get(word2).add(word1);
                }
            }
        }

        int ans = 0;

        Set<String> visited = new HashSet();
        Queue<String> queue = new LinkedList();

        queue.offer(beginWord);
        visited.add(beginWord);

        while(!queue.isEmpty()){
            int size = queue.size();
            ans++;

            for(int i=0; i<size; i++){
                String neigh = queue.poll();
                if(neigh.equals(endWord)){
                    return ans;
                }

                if(adjList.containsKey(neigh)){

                    for(String word: adjList.get(neigh)){
                        if(!visited.contains(word)){
                            visited.add(word);
                            queue.offer(word);
                        }
                    }

                }

                
            }
        }

        return 0;

        
    }

    private boolean isPossible(String word1, String word2){
        if(word1.length() != word2.length()){
            return false;
        }

        int diff = 0;
        for(int i=0; i<word1.length(); i++){
            if(word1.charAt(i) != word2.charAt(i)){
                diff++;
                if(diff > 1){
                    return false;
                }
            }
        }
        return diff == 1;
    }
}