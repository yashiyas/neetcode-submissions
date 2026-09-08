class Solution {
    public List<List<Integer>> pacificAtlantic(int[][] heights) {

        List<List<Integer>> ans = new ArrayList();
        Set<List<Integer>> pacific = new HashSet();
        Set<List<Integer>> atlantic = new HashSet();

        int row = heights.length;
        int col = heights[0].length;

        boolean [][] visitedAtlantic = new boolean[heights.length][heights[0].length];
        boolean [][] visitedPacific = new boolean[heights.length][heights[0].length];

        Queue<List<Integer>> aq = new LinkedList();
        Queue<List<Integer>> pq = new LinkedList();

        for(int j=0; j<heights[0].length; j++){
            pq.offer(List.of(0,j));
            visitedAtlantic[row-1][j] = true;
            visitedPacific[0][j] = true;
            aq.offer(List.of(row-1,j));
        }

        for(int i=0; i<row; i++){
            pq.offer(List.of(i,0));
            aq.offer(List.of(i,col-1));
            visitedAtlantic[i][col-1] = true;
            visitedPacific[i][0] = true;
        }

        int[][] directions = new int[][]{
            {1,0},{-1,0},{0,1},{0,-1}
        };


        while(!aq.isEmpty()){
            List<Integer> curr = aq.poll();
            int x=curr.get(0);
            int y=curr.get(1);
            visitedAtlantic[x][y]=true;
            atlantic.add(curr);

            for(int[] dir:directions){
                int newX = x+dir[0];
                int newY = y+dir[1];

                if(isValid(newX,newY,visitedAtlantic,heights,heights[x][y])){
                    aq.offer(List.of(newX,newY));
                }
            }
        }

        while(!pq.isEmpty()){
            List<Integer> curr = pq.poll();
            int x=curr.get(0);
            int y=curr.get(1);
            visitedPacific[x][y]=true;
            pacific.add(curr);

            for(int[] dir:directions){
                int newX = x+dir[0];
                int newY = y+dir[1];

                if(isValid(newX,newY,visitedPacific,heights, heights[x][y])){
                    pq.offer(List.of(newX,newY));
                }
            }
        }

        for(List<Integer> curr:pacific){

            if(atlantic.contains(curr)){
                ans.add(curr);
            }
            
        }

        return ans;

        
        
    }

    private boolean isValid(int x, int y, boolean[][] visited, int[][] heights, int currH){

        return x>=0 && y>=0 && x<heights.length && y<heights[0].length && !visited[x][y] && currH<=heights[x][y];

    }
}
