class Solution {
    public int[] getOrder(int[][] tasks) {

        int n = tasks.length;

        PriorityQueue<Task> pq = new PriorityQueue();

        for(int i=0; i<tasks.length; i++){
            int[] curr = tasks[i];
            Task task = new Task(curr[0], curr[1], i);
            pq.offer(task);
        }

        int time = pq.peek().enqueTime;
        int pos = 0;
        int[] order = new int[n];
        

        while(!pq.isEmpty()){
            Task t = getCurrentTask(time, pq);
            if(t != null ){
                order[pos] = t.index;
                pos++;
                time = time+t.processTime;
            }else{
            time = pq.peek().enqueTime;
            };
        }

        return order;
        
    }

    private Task getCurrentTask(int time,  PriorityQueue<Task> pq){

        while(pq.peek().enqueTime < time){
            Task task = pq.poll();
            task.enqueTime = time;
            pq.offer(task);
        }

        if(pq.peek().enqueTime == time){
            return pq.poll();
        }

        return null;

    }

    class Task implements Comparable<Task>{
        int enqueTime;
        int processTime;
        int index;

        Task(int t1, int t2, int i){
            this.enqueTime = t1;
            this.processTime = t2;
            this.index = i;
        }

        @Override

        public int compareTo(Task t){
            if(this.enqueTime != t.enqueTime){
                return Integer.compare(this.enqueTime, t.enqueTime);
            }

            if(this.processTime != t.processTime){
                return Integer.compare(this.processTime, t.processTime);
            }

            return Integer.compare(this.index, t.index);
        }

    }
}