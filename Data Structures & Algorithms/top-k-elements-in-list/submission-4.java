class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        int n = nums.length;
        List<Integer>[] freq = new ArrayList[n+1];

        for(int i=0; i<=n; i++){
            freq[i] = new ArrayList();
        }

        Map<Integer, Integer> count = new HashMap();

        for(int i: nums){
            int curr = count.getOrDefault(i,0) + 1;

            count.put(i, curr);
        }

        for(Map.Entry<Integer,Integer> entry: count.entrySet()){


            int curr = entry.getKey();
            int currFreq = entry.getValue();

            freq[currFreq].add(curr);


        }

        int[] ans = new int[k];
        int i = n;
        int curr = 0;
        while(k>0 && i>=0){
            for(int num: freq[i]){
                ans[curr] = num;
                curr++;
                k--;
            }
            i--;
        }

        return ans;
        
    }
}
