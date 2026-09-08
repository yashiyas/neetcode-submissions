class Solution {
    public List<String> findWords(char[][] board, String[] words) {

        List<String> ans = new ArrayList();

        String curr = "";

        int m = board.length;
        int n = board[0].length;

        int index = 0;

        

        for(int i=0; i<m; i++){
            for(int j=0; j<n; j++){
                boolean[][] visited = new boolean[m][n];
                solve(i,j,ans,curr,visited,words,board);
            }
        }

        return ans;
        
    }

    private void solve(int x, int y, List<String> ans, String curr, boolean[][] visited, String[] words, char[][] board){
        visited[x][y] = true;
        curr = curr + String.valueOf(board[x][y]);

        if(containsWord(words, curr) && !ans.contains(curr)){
            ans.add(curr);
        }

        if(!wordPossible(curr,words)){
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
                solve(newX,newY,ans,curr,visited,words,board);
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

    private boolean wordPossible(String curr, String[] words){
        for(String word: words){
            if(word.startsWith(curr)){
                return true;
            }
        }
        return false;
    }

    private boolean containsWord(String[] ref, String word){
        for(String r: ref){
            if(r.equals(word)){
                return true;
            }
        }

        return false;
    }
}
