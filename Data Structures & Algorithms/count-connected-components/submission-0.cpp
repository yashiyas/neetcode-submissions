class Solution {
public:
    int countComponents(int n, vector<vector<int>>& edges) {
        vector<vector<int>> adj(n);
        for(int i=0; i<edges.size(); i++){
            int p1 = edges[i][0];
            int p2 = edges[i][1];
            adj[p1].push_back(p2);
            adj[p2].push_back(p1);
        }
        int ans =0;
        vector<bool> visited(n, false);
        for(int i=0; i<n; i++){
            if(!visited[i]){
                ans++;
                dfs(i,adj,visited);
            }
        }

        return ans;
    }

    void dfs(int node, vector<vector<int>> &adj, vector<bool> &visited){
        visited[node] = true;
        for(int i=0; i<adj[node].size(); i++){
            int n = adj[node][i];
            if(!visited[n]){
                dfs(n,adj,visited);
            }
        }
    }
};
