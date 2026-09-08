class Solution {
    public int carFleet(int target, int[] position, int[] speed) {
        int n = position.length;
        Pair[] cars = new Pair[n];

        for(int i=0; i<n; i++){
            Pair p = new Pair(position[i], speed[i]);
            cars[i]=p;
        }

        Arrays.sort(cars, (a,b) -> b.pos - a.pos);

        List<Double> time = new ArrayList();

        for(int i=0; i<n; i++){
            Pair p = cars[i];
            double t = (double)(target - p.pos)/p.speed;
            time.add(t);
        }

        int ans = 1;
        double curr = time.get(0);

        for(int i=1; i<n; i++){
            if(curr >= time.get(i)){
                continue;
            }
            ans++;
            curr = time.get(i);
        }

        return ans;
        
        
    }

    class Pair{
        int pos;
        int speed;

        Pair(int p, int s){
            this.pos = p;
            this.speed = s;
        }
    }
}
