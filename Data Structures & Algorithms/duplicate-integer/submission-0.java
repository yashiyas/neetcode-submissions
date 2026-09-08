class Solution {
    public boolean hasDuplicate(int[] nums) {
        Set<Integer> s = new HashSet<>();
        for(int t: nums){
            s.add(t);
        }
        return (s.size() != nums.length);
    }
}