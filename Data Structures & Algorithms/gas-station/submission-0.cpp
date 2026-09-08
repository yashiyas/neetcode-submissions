class Solution {
public:
    int canCompleteCircuit(vector<int>& gas, vector<int>& cost) {
        int gasSum = 0;
        int costSum = 0;
        int n = gas.size();
        vector<int> diff(n);

        for(int i=0; i<gas.size(); i++){
            gasSum+=gas[i];
            costSum+=cost[i];
            diff[i] = gas[i] - cost[i];
        }

        if(gasSum < costSum){
            return -1;
        }

        int total = 0;
        int res = 0;

        for(int i=0; i<n; i++){
            total = total+diff[i];
            if(total < 0){
                total = 0;
                res = i+1;
            }
        }

        return res;

    }
};
