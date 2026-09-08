class Solution {
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {

        Map<Integer, List<Pair>> adjList = new HashMap();
        for(int i=0; i<n; i++){
            adjList.put(i, new ArrayList());
        }

        for(int i=0; i<flights.length; i++){
            int s = flights[i][0];
            int d = flights[i][1];
            int c = flights[i][2];

            adjList.get(s).add(new Pair(d, c));
        }

        int[] prices = new int[n];
        Arrays.fill(prices, Integer.MAX_VALUE);
        prices[src] = 0;

       for(int i=0; i<=k; i++){

            int[] temp = prices.clone();

            for(int[] flight: flights){
                int s = flight[0];
                int d = flight[1];
                int cost = flight[2];

                if(prices[s] == Integer.MAX_VALUE){
                    continue;
                }

                temp[d] = Math.min(temp[d], prices[s]+cost);
            }

            prices = temp;

       }

       return prices[dst]==Integer.MAX_VALUE?-1:prices[dst];

    }

}
