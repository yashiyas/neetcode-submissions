class Solution {
    public int[][] floodFill(int[][] image, int sr, int sc, int color) {

        int rowSize = image.length;
        int colSize = image[0].length;

        boolean [][] visited = new boolean[rowSize][colSize];

        int numToChange = image[sr][sc];

        if(numToChange == color){
            return image;
        }

        Queue<Pair> bfs = new LinkedList();
        Pair start = new Pair(sr,sc);
        bfs.offer(start);
        visited[sr][sc] = true;

        int[][] directions = {
                                {0, 1},
                                {1, 0},
                                {0, -1},
                                {-1, 0}
                            };

        while(!bfs.isEmpty()){
            int size = bfs.size();

            for(int i=0; i<size; i++){
                Pair top = bfs.poll();
                image[top.row][top.column] = color;

                for (int[] dir : directions) {
                    int newRow = top.row + dir[0];
                    int newCol = top.column + dir[1];
                    Pair temp = new Pair(newRow, newCol);
                    if(isValid(newRow, newCol, rowSize, colSize) && !visited[newRow][newCol] && image[newRow][newCol] == numToChange){
                        bfs.add(temp);
                        visited[newRow][newCol] = true;
                    }
                }

            }
        }

        return image;


        
    }

    private boolean isValid(int row, int col, int rowSize, int colSize){
        if(row < 0 || col < 0 || row >= rowSize || col >= colSize){
            return false;
        }
        return true;
    }

    class Pair{
        int row;
        int column;

        Pair(int r, int c){
            this.row = r;
            this.column = c;
        }
    }
}