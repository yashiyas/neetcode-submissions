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
            curr.word = word;
        }

        int m = board.length;
        int n = board[0].length;

        for(int i=0; i<m; i++){
            for(int j=0; j<n; j++){
                if (root.children.containsKey(board[i][j])) {
                    boolean[][] visited = new boolean[m][n];
                    solve(i,j,ans,visited,board,root.children.get(board[i][j]));
                }
            }
        }

        return ans;
        
    }

    private void solve(int x, int y, List<String> ans, boolean[][] visited, char[][] board, TrieNode currNode){
        visited[x][y] = true;
        if(currNode.isWord && !ans.contains(currNode.word)){
            ans.add(currNode.word);
        }

        int[][] directions = new int[][]{
            {1,0}, {-1,0}, {0,1}, {0,-1}
        };

        for(int[] dir: directions){
            int newX = x+dir[0];
            int newY = y+dir[1];

            if(isValid(newX,newY,visited) && wordPossible(currNode, board[newX][newY])){
                solve(newX,newY,ans,visited,board,currNode.children.get(board[newX][newY]));
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

    private boolean wordPossible(TrieNode curr, Character next){
        return (curr.children != null && curr.children.containsKey(next));
    }

    class TrieNode{
        Map<Character,TrieNode> children;
        boolean isWord;
        String word;

        TrieNode(){
            this.children = new HashMap();
            this.isWord = false;
            this.word = "";
        }
    }
}