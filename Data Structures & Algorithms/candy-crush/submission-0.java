class Solution {
    public int[][] candyCrush(int[][] board) {

        int m = board.length;
        int n = board[0].length;

        boolean[][] crushBoard = new boolean[m][n];

        boolean crushed = find(board, crushBoard);

        while(crushed){
            crush(board, crushBoard);
            drop(board);
            crushed = find(board,crushBoard);
        }

        return board;
        
    }

    private boolean find(int[][] board, boolean[][] crush){

        int m = board.length;
        int n = board[0].length;
        boolean ans = false;

        // check horizontally

        for(int i=0; i<m; i++){
            for(int j=1; j<n-1; j++){
                if(board[i][j] != 0 && board[i][j-1] == board[i][j] && board[i][j+1] == board[i][j]){
                    crush[i][j-1] = true;
                    crush[i][j] = true;
                    crush[i][j+1] = true;
                    ans = true;
                }
            }
        }

        // check vertically

        for(int j=0; j<n; j++){
            for(int i=1; i<m-1; i++){
                if(board[i][j] != 0 && board[i-1][j] == board[i][j] && board[i+1][j] == board[i][j]){
                    crush[i-1][j] = true;
                    crush[i][j] = true;
                    crush[i+1][j] = true;
                    ans = true;
                }
            }
        }

        return ans;
    }

    private void crush(int[][] board, boolean[][] crushBoard){
        int m = board.length;
        int n = board[0].length;

        for(int i=0; i<m; i++){
            for(int j=0; j<n; j++){
                if(crushBoard[i][j]){
                    board[i][j] = 0;
                }
            }
        }

        for (int i = 0; i < m; i++) {
            Arrays.fill(crushBoard[i], false);
        }
    }

    private void drop(int[][] board){

        int m = board.length;
        int n = board[0].length;

        for(int j=0; j<n; j++){
            int zero = -1;
            for(int i=m-1; i>=0; i--){
                if(board[i][j] == 0){
                    zero = Math.max(zero, i);
                }else{
                    if(zero != -1){
                        board[zero][j] = board[i][j];
                        board[i][j] = 0;
                        zero = zero - 1;
                    }
                }
            }
        }
    }

}
