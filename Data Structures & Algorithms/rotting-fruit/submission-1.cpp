class Solution {
public:
    int orangesRotting(vector<vector<int>>& grid) {
        int n = grid.size();
        int m = grid[0].size();
        int fresh =0;
        queue<pair<int,int>> q;

        for(int i=0; i<n; i++){
            for(int j=0; j<m; j++){
                if(grid[i][j] == 1){
                    fresh++;
                }
                else if(grid[i][j] == 2){
                    pair<int,int> rot;
                    rot.first = i;
                    rot.second = j;
                    q.push(rot);
                }
            }
        }

        int min = 0;
        vector<vector<int>> dir = {{0,1}, {0, -1}, {1,0}, {-1,0}};

        while(!q.empty() && fresh > 0){
            int s = q.size();
            min++;
            for(int i=0; i<s; i++){
                pair<int,int> curr = q.front();
                q.pop();
                int row = curr.first;
                int col = curr.second;

                for(int j=0; j<4; j++){
                    int x = row+dir[j][0];
                    int y = col+dir[j][1];

                    if(x <0 || x >=n || y<0 || y>=m || grid[x][y] != 1){
                        continue;
                    }

                    fresh--;
                    grid[x][y] = 2;
                    q.push({x,y});
                }
            }
        }

        if(fresh == 0){
            return min;
        }

        return -1;
        
    }
};
