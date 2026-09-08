class Solution {
public:
    void islandsAndTreasure(vector<vector<int>>& grid) {
        int n = grid.size();
        int m = grid[0].size();
        queue<pair<int,int>> elements;

        for(int i=0; i<n; i++){
            for(int j=0; j<m; j++){
                if(grid[i][j] == 0){
                    pair<int,int> curr;
                    curr.first = i;
                    curr.second = j;
                    elements.push(curr);
                }
            }
        }

        vector<vector<int>> dir = {{-1,0}, {1,0}, {0,-1}, {0,1}};
        while(!elements.empty()){
            pair<int,int> curr = elements.front();
            int row = curr.first;
            int col = curr.second;
            elements.pop();

            for(int i=0; i<4; i++){
                int x = row + dir[i][0];
                int y = col + dir[i][1];

                if(x < 0 || x>=n || y<0 || y>=m || grid[x][y] != INT_MAX){
                    continue;
                }

                grid[x][y] = 1+grid[row][col];
                elements.push({x,y});
            }


        }
    }
};
