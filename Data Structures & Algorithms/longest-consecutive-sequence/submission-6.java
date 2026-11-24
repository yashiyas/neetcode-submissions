class Solution {
    public int longestConsecutive(int[] nums) {

        int ans = 0;

        Set<Integer> numSet = new HashSet();

        for(int i: nums){
            numSet.add(i);
        }

        for(int i: nums){
            if(!numSet.contains(i-1)){
                int curr = i;
                int currLen = 0;
                while(numSet.contains(curr)){
                    currLen++;
                    curr++;
                }

                if(ans < currLen){
                    ans = currLen;
                }
            }
        }

        return ans;
        
    }
}
