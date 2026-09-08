class Solution {
    public boolean isValidSudoku(char[][] board) {
        
        return areValidRows(board) && areValidColumns(board) && areValidBlocks(board);
    }

    public boolean areValidRows(char[][] board){
        for(int i=0; i<9; i++){
            Set<Character> rows = new HashSet();

            for(int j=0; j<9; j++){
                if(board[i][j] != '.' && rows.contains(board[i][j])){
                    return false;
                }
                else{
                    rows.add(board[i][j]);
                }
            }
        }
        return true;
    }

    public boolean areValidColumns(char[][] board){
        for(int i=0; i<9; i++){
            Set<Character> rows = new HashSet();

            for(int j=0; j<9; j++){
                if(board[j][i] != '.' && rows.contains(board[j][i])){
                    return false;
                }
                else{
                    rows.add(board[j][i]);
                }
            }
        }
        return true;
    }

    public boolean areValidBlocks(char[][] board){

        List<Set<Character>> blockList = new ArrayList();

        for(int i=0; i<9; i++){
            blockList.add(new HashSet());
        }

        for(int i=0; i<9; i++){
            for(int j=0; j<9; j++){
                int block = getBlockNumber(i,j);
                Set<Character> blockChar = blockList.get(block);
                if(board[i][j] != '.' && blockChar.contains(board[i][j])){
                    return false;
                }
                else{
                    blockChar.add(board[i][j]);
                }
            }
        }
        return true;
    }

    public int getBlockNumber(int row, int column){
        if(row < 3 && column < 3){
            return 0;
        }

        if(row < 3 && column >=3 && column <6){
            return 1;
        }

        if(row < 3 && column >=6){
            return 2;
        }

        if(row >=3 && row < 6 && column < 3){
            return 3;
        }

        if(row >=3 && row < 6 && column >= 3 && column <6){
            return 4;
        }

        if(row >=3 && row < 6 && column >=6){
            return 5;
        }

        if(row>=6 && column <3){
            return 6;
        }

        if(row >= 6 && column >=3 && column <6){
            return 7;
        }

        return 8;


    }
}
