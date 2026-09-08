class Solution {
public:
    vector<int> topKFrequent(vector<int>& nums, int k) {
        map<int,int> count;
        vector<int> ans;
        for(int i=0; i<nums.size(); i++){
            if(count.find(nums[i]) != count.end()){
                count[nums[i]]++;
            }
            else{
                count[nums[i]] = 1;
            }
        }
        map<int, vector<int>> countToElements;
        for(auto var: count){
            if(countToElements.find(var.second) != countToElements.end()){
                countToElements[var.second].push_back(var.first);
            }
            else{
                vector<int> temp;
                temp.push_back(var.first);
                countToElements.insert({var.second, temp}); 
            }
        }
        auto itr = countToElements.end();
        while(k>0){
            itr--;
            vector<int> n = itr->second;
            for(int i =0; i< n.size(); i++){
                k--;
                ans.push_back(n[i]);
            }
            
            
        }
        return ans;

    }
};
