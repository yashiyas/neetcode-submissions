class Solution {
    public void solve(char[][] board) {

        int row = board.length;
        int col = board[0].length;

        boolean [][] visited = new boolean[row][col];

        for(int i=0; i<row; i++){
            for(int j=0; j<col; j++){
                char curr = board[i][j];

                if(curr == 'O' && !visited[i][j] && !isEdgeCell(i,j,board)){
                    surroundRegion(i,j,board,visited);
                }

            }
        }

        
    }

    private void surroundRegion(int x, int y, char[][] board, boolean[][] visited){
        List<int[]> toChange = new ArrayList();
        Queue<int[]> queue = new LinkedList();
        boolean validRegion = true;

        queue.offer(new int[]{x,y});
        visited[x][y] = true;

        int[][] dir = new int[][]{
            {1,0}, {-1,0}, {0,1}, {0,-1}
        };

        while(!queue.isEmpty()){
            int[] curr = queue.poll();
            if(!isEdgeCell(curr[0], curr[1], board)){
                toChange.add(curr);
                for(int k=0; k<4; k++){
                    int newX = curr[0]+dir[k][0];
                    int newY = curr[1]+dir[k][1];
                    if(isValid(newX, newY,board) && board[newX][newY] == 'O' && !visited[newX][newY]){
                        visited[newX][newY] = true;
                        queue.offer(new int[]{newX,newY});
                    }
                }
            }else{
                validRegion = false;
            }
        }

        if(validRegion){
            for(int[] curr: toChange){
                int i=curr[0];
                int j=curr[1];
                board[i][j] = 'X';
            }
        }

    }

    private boolean isEdgeCell(int x, int y, char[][] board){
        int row = board.length;
        int col = board[0].length;

        return (x==0 && y<col) || (x==row-1 && y<col) || (y==0 && x<row) || (y==col-1 && x<row);
    }

    private boolean isValid(int x, int y, char[][] board){
        int row = board.length;
        int col = board[0].length;
        return x>=0 && y>=0 && x<row && y< col;
    }
}
