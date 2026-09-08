class Solution {
    public boolean isMatch(String s, String p) {
        return solve(s,p,0,0);
    }

    private boolean solve(String s, String p, int s1, int p1){
        if(p1 == p.length()){
            return s1 == s.length();
        }

        boolean firstMatch = (s1 < s.length() && (s.charAt(s1) == p.charAt(p1) || p.charAt(p1) == '.'));

        if(p1 + 1 < p.length() && p.charAt(p1 + 1) == '*'){
            return solve(s, p, s1, p1 + 2) || (firstMatch && solve(s, p, s1 + 1, p1));
        }

        if(firstMatch){
            return solve(s, p, s1 + 1, p1 + 1);
        }

        return false;
    }
}