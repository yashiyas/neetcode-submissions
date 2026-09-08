class Solution {
    public int mincostTickets(int[] days, int[] costs) {
        int n = costs.length;

        int days1 = findIndex(days,days[0]+7,0);
        int days2 = findIndex(days,days[0]+30,0);
        Map<Integer,Integer> cache = new HashMap();

        return  Math.min(costs[0]+solve(days,costs,1,cache),
                Math.min(costs[1]+solve(days,costs,days1,cache),
                costs[2]+solve(days,costs,days2,cache)));
        
    }

    private int solve(int[] days, int[] costs, int index, Map<Integer,Integer> cache){
        if(index >= days.length){
            return 0;
        }

        if(cache.containsKey(index)){
            return cache.get(index);
        }

        int days1 = findIndex(days,days[index]+7,index);
        int days2 = findIndex(days,days[index]+30,index);

        int ans =  Math.min(costs[0]+solve(days,costs,index+1,cache),
                Math.min(costs[1]+solve(days,costs,days1,cache),
                costs[2]+solve(days,costs,days2,cache)));

        cache.put(index,ans);
        return ans;


    }

    private int findIndex(int[] days, int cover, int current){
        while(current <days.length && days[current] < cover){
            current++;
        }

        return current;
    }
}