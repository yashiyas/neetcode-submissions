class Solution {
    public List<String> findWords(char[][] board, String[] words) {

        List<String> ans = new ArrayList();

        TrieNode root = new TrieNode();

        for(String word: words){
            TrieNode curr = root;
            for(int i=0; i<word.length(); i++){
                Character c = word.charAt(i);
                if(curr.children.containsKey(c)){
                    curr = curr.children.get(c);
                }else{
                    curr.children.put(c, new TrieNode());
                    curr = curr.children.get(c);
                }
            }
            curr.isWord = true;
        }

        String curr = "";

        int m = board.length;
        int n = board[0].length;

        int index = 0;

        

        for(int i=0; i<m; i++){
            for(int j=0; j<n; j++){
                boolean[][] visited = new boolean[m][n];
                solve(i,j,ans,curr,visited,words,board,root);
            }
        }

        return ans;
        
    }

    private void solve(int x, int y, List<String> ans, String curr, boolean[][] visited, String[] words, char[][] board, TrieNode root){
        visited[x][y] = true;
        curr = curr + String.valueOf(board[x][y]);

        if(containsWord(words, curr) && !ans.contains(curr)){
            ans.add(curr);
        }

        if(!wordPossible(curr,root)){
            visited[x][y] = false;
            return;
        }

        int[][] directions = new int[][]{
            {1,0}, {-1,0}, {0,1}, {0,-1}
        };

        for(int[] dir: directions){
            int newX = x+dir[0];
            int newY = y+dir[1];

            if(isValid(newX,newY,visited)){
                solve(newX,newY,ans,curr,visited,words,board,root);
            }
        }

        visited[x][y] = false;

    }

    private boolean isValid(int x, int y, boolean[][] visited){
        if(x <0 || y<0 || x>=visited.length || y>= visited[0].length){
            return false;
        }

        return !visited[x][y];
    }

    private boolean wordPossible(String curr, TrieNode root){
        TrieNode currNode = root;
        for(int i=0; i<curr.length(); i++){
            Character c = curr.charAt(i);
            if(!currNode.children.containsKey(c)){
                return false;
            }
            currNode = currNode.children.get(c);
        }

        return true;
    }

    private boolean containsWord(String[] ref, String word){
        for(String r: ref){
            if(r.equals(word)){
                return true;
            }
        }

        return false;
    }

    class TrieNode{
        Map<Character,TrieNode> children;
        boolean isWord;

        TrieNode(){
            this.children = new HashMap();
            this.isWord = false;
        }
    }
}
