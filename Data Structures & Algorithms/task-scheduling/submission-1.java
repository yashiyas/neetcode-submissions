class Solution {
    public int leastInterval(char[] tasks, int n) {

        Map<Character,Integer> charMap = new HashMap();

        for(int i=0; i<tasks.length; i++){
            int freq = charMap.getOrDefault(tasks[i],0) + 1;
            charMap.put(tasks[i], freq);
        }

        int i=0;

        PriorityQueue<Task> pq = new PriorityQueue<>();
        Queue<Task> waiting = new LinkedList();

        for(Map.Entry<Character,Integer> entry: charMap.entrySet()){
            Task t = new Task(entry.getKey(), entry.getValue());
            pq.offer(t);
        }



        while(!pq.isEmpty() || !waiting.isEmpty()){
            if(!waiting.isEmpty()){
                Task top = waiting.peek();
                if(i >= top.waitFor){
                    waiting.poll();
                    pq.offer(top);
                }
            }
            if(!pq.isEmpty()){
                Task top = pq.poll();
                int currFreq = top.freq - 1;
                if(currFreq > 0){
                    top.freq = currFreq;
                    top.waitFor = i+n+1;
                    waiting.offer(top);
                }

            }
            i++;

        }

        return i;

        


    }

    class Task implements Comparable<Task>{
        Character ch;
        int freq;
        int waitFor;

        Task(Character ch, int freq){
            this.ch = ch;
            this.freq = freq;
            this.waitFor = -1;
        }

        @Override
        public int compareTo(Task t2){
            return t2.freq - this.freq;
        }
    }
}
