class Solution {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int size = gas.length;
        int [] diff = new int[size];
        int totalGas = 0;
        int totalCost = 0;

        for(int i=0; i<size; i++){
            diff[i] = gas[i] - cost[i];
            totalGas+=gas[i];
            totalCost+=cost[i];
        }

        if(totalCost > totalGas){
            return -1;
        }

        int i=0;

        while(i < size){
            if(diff[i] < 0){
                i++;
                continue;
            }else{
                totalGas = 0;
                int start = i;
                for(int j=i; j<size; j++){
                    totalGas+=diff[j];
                    if(totalGas < 0){
                        start = j+1;
                        break;
                    }
                }
                if(totalGas < 0){
                       i=start;
                }
                else{
                    return i;
                }
            }
        }

        return -1;
        
    }
}
