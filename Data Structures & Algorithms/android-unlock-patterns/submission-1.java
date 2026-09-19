class Solution {
    int ans = 0;
    int[][] middle = new int[10][10];
    public int numberOfPatterns(int m, int n) {

        buildMiddle();
        
        for(int i=m; i<=n; i++){
            for(int j=1; j<=9; j++){
                List<Integer> currPattern = new ArrayList();
                currPattern.add(j);
                findPatterns(currPattern, i);
            }
        }

        return ans;
        
    }

    private void findPatterns(List<Integer> currPattern, int expSize){

        if(currPattern.size() == expSize){
            ans++;
            return;
        }

        int size = currPattern.size();
        int prev = currPattern.get(size-1);

        for(int i=1; i<=9; i++){
            if(currPattern.contains(i)){
                continue;
            }

            if(middle[prev][i] == 0 || currPattern.contains(middle[prev][i])){
                currPattern.add(i);
                findPatterns(currPattern, expSize);
                currPattern.remove(currPattern.size()-1);
            }
        }

    }

    private void buildMiddle(){
        middle[1][3] = 2;
        middle[3][1] = 2;
        middle[1][9] = 5;
        middle[9][1] = 5;
        middle[1][7] = 4;
        middle[7][1] = 4;
        middle[2][8] = 5;
        middle[8][2] = 5;
        middle[3][9] = 6;
        middle[9][3] = 6;
        middle[3][7] = 5;
        middle[7][3] = 5;
        middle[4][6] = 5;
        middle[6][4] = 5;
        middle[7][9] = 8;
        middle[9][7] = 8;
    }
}
