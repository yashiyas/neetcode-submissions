class CountSquares {

    Map<Integer, List<int[]>> pointsListY;
    Map<Integer, List<int[]>> pointsListX;
    Map<String, Integer> pointsFreq;

    public CountSquares() {

        this.pointsListY = new HashMap();
        this.pointsListX = new HashMap();
        this.pointsFreq = new HashMap();
        
    }
    
    public void add(int[] point) {

        String key = String.valueOf(point[0])+"|"+String.valueOf(point[1]);
        int freq = pointsFreq.getOrDefault(key,0)+1;
        pointsFreq.put(key, freq);

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

            int points1 = findPoints(candidate[0], y);
            int points2 = findPoints(point[0],y);
            
            ans += points1 * points2;
        }

        // down

        y = candidate[1]-destX;
        if(y >=0 ){

            if(pointsListY.containsKey(y)){

            int points1 = findPoints(candidate[0], y);
            int points2 = findPoints(point[0], y);
            
            ans += points1 * points2;
            }

        }

        return ans; 

    }

    private int findPoints(int x, int y){
        String key = String.valueOf(x)+"|"+String.valueOf(y);
        int ans = pointsFreq.getOrDefault(key,0);
        return ans;
    }
}
