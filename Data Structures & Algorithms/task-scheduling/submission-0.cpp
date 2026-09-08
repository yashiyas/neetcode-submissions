class Solution {
public:
    int leastInterval(vector<char>& tasks, int n) {
        map<char,int> freq;

        for(int i=0; i<tasks.size(); i++){
            freq[tasks[i]]++;
        }

        priority_queue<int> pq;
        
        for(auto &itr: freq){
            pq.push(itr.second);
        }

        int t=0;
        queue<pair<int,int>> q;

        while(!pq.empty() || !q.empty()){
            if(!q.empty() && t>= q.front().second){
                pq.push(q.front().first);
                q.pop();
            }
            if(!pq.empty()){
                int count = pq.top() -1;
                pq.pop();
                if(count > 0){
                    q.push({count, t+n+1});
                }
            }
            t++;
            
        }

        return t;




    }
};
