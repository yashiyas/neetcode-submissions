class Solution {
    public int reverse(int x) {
        int ans = 0;

        int maxVal = Integer.MAX_VALUE;
        int maxTens = maxVal/10;
        int onesMax = maxVal%10;
        int minVal = Integer.MIN_VALUE;
        int minTens = minVal/10;
        int onesMin = minVal%10;

        while(x != 0){
            int curr = x % 10;
            if (ans > maxTens || (ans == maxTens && curr > onesMax)) return 0;
            if (ans < minTens || (ans == minTens && curr < onesMin)) return 0;
            ans = ans * 10 + curr;
            x = x / 10;
        }

        return ans;
    }
}