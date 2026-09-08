class Solution {
    public int minKnightMoves(int x, int y) {
        
        Queue<Pair> queue = new LinkedList();

        Set<Pair> visited = new HashSet();

        Pair p = new Pair(0,0);

        visited.add(p);

        queue.offer(p);

        int moves = 0;

        int[][] directions = new int[][]{
            {2,1}, {2,-1}, {-2,1}, {-2,-1}, {1,2}, {1,-2}, {-1,2}, {-1,-2}
        };

        while(!queue.isEmpty()){
            moves++;
            int size = queue.size();

            for(int i=0; i<size; i++){
                Pair curr = queue.poll();
                if(curr.x == x && curr.y == y){
                    return moves-1;
                }

                for(int[] dir: directions){
                    int newX = curr.x + dir[0];
                    int newY = curr.y + dir[1];
                    Pair newPoints = new Pair(newX, newY);

                    if(!visited.contains(newPoints)){
                        queue.offer(newPoints);
                        visited.add(newPoints);
                    }
                }
            }
        }

        return -1;

    }

    class Pair{
        int x;
        int y;

        Pair(int x, int y){
            this.x = x;
            this.y = y;
        }

        @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Pair)) return false;

        Pair p = (Pair) o;
        return x == p.x && y == p.y;
    }

    @Override
    public int hashCode() {
        return Objects.hash(x, y);
    }

        
    }
}
