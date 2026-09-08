class CountSquares {

    Map<Integer, List<int[]>> pointsListY;
    Map<Integer, List<int[]>> pointsListX;

    public CountSquares() {

        this.pointsListY = new HashMap();
        this.pointsListX = new HashMap();
        
    }
    
    public void add(int[] point) {

        pointsListY.computeIfAbsent(point[1], k -> new ArrayList());
        pointsListY.get(point[1]).add(point);

        pointsListX.computeIfAbsent(point[0], k -> new ArrayList());
        pointsListX.get(point[0]).add(point);
        
    }
    
    public int count(int[] point) {
        
        int y = point[1];
        int x = point[0];

        if(!pointsListY.containsKey(y) || !pointsListX.containsKey(x)){
            return 0;
        }

        int ans = 0;

        for(int[] candidate: pointsListY.get(y)){

            ans = ans + canMakeSquare(candidate, point);
        }

        return ans;
    }

    private int canMakeSquare(int[] candidate, int[] point){
        int destX = Math.abs(candidate[0] - point[0]);
        if(destX == 0){
            return 0;
        }

        // up
        int y = candidate[1]+destX;

        int ans = 0;

        if(pointsListY.containsKey(y)){

            int points1 = findPoints(pointsListY.get(y), candidate[0]);
            int points2 = findPoints(pointsListY.get(y), point[0]);
            
            ans += points1 * points2;
        }

        // down

        y = candidate[1]-destX;
        if(y >=0 ){

            if(pointsListY.containsKey(y)){

            int points1 = findPoints(pointsListY.get(y), candidate[0]);
            int points2 = findPoints(pointsListY.get(y), point[0]);
            
            ans += points1 * points2;
            }

        }

        return ans; 

    }

    private int findPoints(List<int[]> points, int x){
        int ans = 0;

        for(int i=0; i<points.size(); i++){
            if(points.get(i)[0] == x){
                ans++;
            }
        }

        return ans;
    }
}
