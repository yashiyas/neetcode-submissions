class Solution {
    public int[] timeTaken(int[] arrival, int[] state) {

        PriorityQueue<Pair> entry = new PriorityQueue();
        PriorityQueue<Pair> exit = new PriorityQueue();

        int[] ans = new int[arrival.length];

        int time = 0;
        int prev = 2;

        for(int i=0; i<arrival.length; i++){
            Pair curr = new Pair(arrival[i], i);
            if(state[i] == 1){
                exit.offer(curr);
            }else{
                entry.offer(curr);
            }
        }

        while(!entry.isEmpty() && !exit.isEmpty()){

            Pair currEntry = getCandidate(entry, time);
            Pair currExit = getCandidate(exit, time);

            if(currExit != null && currEntry != null){
                if(prev == 2 || prev == 1){
                    exit.poll();
                    ans[currExit.index] = time;
                    prev = 1;
                }else {
                    entry.poll();
                    ans[currEntry.index] = time;
                    prev = 0;
                }
            }else if(currExit != null){
                exit.poll();
                ans[currExit.index] = time;
                prev = 1;
            } else if(currEntry != null){
                entry.poll();
                ans[currEntry.index] = time;
                prev = 0;
            }else{
                prev = 2;
            }

            time++;
        }

        while(!entry.isEmpty()){
            Pair currEntry = entry.poll();
            ans[currEntry.index] = time;
            time++;
        }

        while(!exit.isEmpty()){
            Pair currExit = exit.poll();
            ans[currExit.index] = time;
            time++;
        }

        return ans;
        
    }

    private Pair getCandidate(PriorityQueue<Pair> queue, int time){
        if(queue.peek().time <= time){
            return queue.peek();
        }
        return null;
    }

    class Pair implements Comparable<Pair>{
       
        int time;
        int index;

        Pair(int t, int ind){
            this.index = ind;
            this.time = t;
        }

        @Override
        public int compareTo(Pair p2){
            if(this.time != p2.time){
               return Integer.compare(this.time, p2.time);
            }
            return Integer.compare(this.index, p2.index);
        }
    }
}
