class Solution {
public:
    struct Compare{
        bool operator()(const pair<int,int> &p1, const pair<int,int> &p2)const{
            return p1.first > p2.first;
        };
    };

    vector<int> partitionLabels(string s) {
        map<char, pair<int,int>> occur;
        vector<int> ans;
        priority_queue<pair<int,int>, vector<pair<int,int>>, Compare> pq;

        for(int i = 0; i<s.length(); i++){
            char curr = s[i];
            if(occur.find(curr) == occur.end()){
                occur[curr] = {i,i};
            }
            else{
                occur[curr].second = i;
            }
        }

        for(auto &curr: occur){
            pair<int,int> p = curr.second;
            pq.push(p);

        }

        while(!pq.empty()){
            pair<int,int> curr = pq.top();
            cout << curr.first << " " << curr.second <<" ";
            pq.pop();
            while(!pq.empty() && pq.top().first < curr.second){
                int e1 = pq.top().second;
                int e2 = curr.second;
                curr.second = max(e1,e2);
                pq.pop();
            }
            int sz = curr.second - curr.first +1;
            ans.push_back(sz);
        }

        return ans;


    }
};
