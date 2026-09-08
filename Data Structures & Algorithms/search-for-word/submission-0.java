class Solution {
    public boolean exist(char[][] board, String word) {

        TrieNode root = new TrieNode();

        TrieNode curr = root;

        for(int i=0; i<word.length(); i++){
            Character c = word.charAt(i);
            curr.children.put(c, new TrieNode());
            curr = curr.children.get(c);
        }
        curr.isWord = true;

        curr = root;

        boolean[][] visited = new boolean[board.length][board[0].length];



        for(int i=0; i<board.length; i++){
            for(int j=0; j<board[0].length; j++){
                Character c = board[i][j];
                if(root.children.containsKey(c)){
                    boolean isPresent = solve(i,j,root.children.get(c),visited,board);
                    if(isPresent){
                        return true;
                    }
                }
            }
        }

        return false; 
        
    }

    private boolean solve(int x, int y, TrieNode currNode, boolean[][] visited, char[][] board){

        if(currNode.isWord){
            return true;
        }

        visited[x][y] = true;

        int[][] directions = new int[][]{
            {1,0}, {-1,0}, {0,1}, {0,-1} 
        };

        boolean possible = false;

        for(int[] dir: directions){
            int newX = x+dir[0];
            int newY = y+dir[1];
            if(isValid(newX,newY,visited)){
                Character c = board[newX][newY];
                if(currNode.children.containsKey(c)){
                    possible =  solve(newX, newY, currNode.children.get(c), visited, board);
                    if(possible){
                        return possible;
                    }
                }
            }
        }

        visited[x][y] = false;

        return false;

    }

    private boolean isValid(int x, int y, boolean[][] visited){
        if(x<0 || y<0 || x>=visited.length || y>=visited[0].length){
            return false;
        }

        return !visited[x][y];
    }

    class TrieNode{
        Map<Character, TrieNode> children;
        boolean isWord;

        TrieNode(){
            this.children = new HashMap();
            this.isWord = false;
        }
    }
}