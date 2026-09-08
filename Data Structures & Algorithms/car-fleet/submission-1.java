class Solution {
    public int carFleet(int target, int[] position, int[] speed) {

        ArrayDeque<Double> timeTaken = new ArrayDeque();

        List<Pair> pairs = new ArrayList();

        for(int i=0; i<position.length; i++){
            Pair p = new Pair(position[i], speed[i]);
            pairs.add(p);
        }

        Collections.sort(pairs, (a,b) -> b.pos - a.pos);

        for(int i=0; i<position.length; i++){
            Pair curr = pairs.get(i);

            double currTime =  ((double)(target - curr.pos)) /(curr.speed);

            if(timeTaken.isEmpty()){
                timeTaken.push(currTime);
            }else if(timeTaken.peek() < currTime){
                timeTaken.push(currTime);
            }
        }

        return timeTaken.size();
        
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
