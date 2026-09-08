class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {

        if(beginWord.equals(endWord)){
            return 1;
        }

        if(!wordList.contains(endWord)){
            return 0;
        }

        Map<String,List<String>> adjList = new HashMap();

        wordList.add(beginWord);

        for(int i=0; i<wordList.size(); i++){
            adjList.put(wordList.get(i), new ArrayList());
        }

        for(int i=0; i<wordList.size(); i++){
            for(int j=i+1; j<wordList.size(); j++){
                if(canTransform(wordList.get(i), wordList.get(j))){
                    adjList.computeIfAbsent(wordList.get(i), k -> new ArrayList()).add(wordList.get(j));
                    adjList.computeIfAbsent(wordList.get(j), k -> new ArrayList()).add(wordList.get(i));
                }
            }
        }

       Queue<String> queue = new LinkedList();
       Set<String> visited = new HashSet();

       int ans = 1;

       queue.offer(beginWord);
       visited.add(beginWord);

       while(!queue.isEmpty()){
            ans++;
           int size = queue.size();
           for(int i=0; i<size; i++){
                String curr = queue.poll();
                for(String neighbour: adjList.get(curr)){
                    if(neighbour.equals(endWord)){
                        return ans;
                    }else{
                        if(!visited.contains(neighbour)){
                            queue.offer(neighbour);
                            visited.add(neighbour);
                        }
                    }
                }
           }
       }

       return 0;
        
    }

    private boolean canTransform(String end, String curr){
        int diff = 0;

        for(int i=0; i<end.length(); i++){
            if(curr.charAt(i) != end.charAt(i)){
                diff++;
            }
        }

        return diff<=1;
    }
}
