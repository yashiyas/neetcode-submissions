class Solution {
public:
    bool validTree(int n, vector<vector<int>>& edges) {
        vector<vector<int>> graph(n);
        vector<bool> visited(n);
        for(int i=0; i<edges.size(); i++){
            int c1 = edges[i][0];
            int c2 = edges[i][1];
            graph[c1].push_back(c2);
            graph[c2].push_back(c1);
        }

        if(hasCycle(0, graph, visited, -1)){
            return false;
        }
        for(int i=0; i<n; i++){
            if(!visited[i]){
                return false;
            }
        }
        return true;
    }

    bool hasCycle(int i, vector<vector<int>> &graph, vector<bool> &visited, int parent){
        visited[i] = true;

        for(int j=0; j<graph[i].size(); j++){
            int curr = graph[i][j];
            if(visited[curr]){
                if(curr != parent)
                {return true;}
            }
            else if(hasCycle(curr, graph, visited, i)){
                return true;
            }
        }
        return false;
    }
};
