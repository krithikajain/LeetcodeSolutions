class Solution {
    public int numIslands(char[][] grid) {
        if(grid == null || grid.length == 0){
            return 0;
        }
        int rows = grid.length;
        int cols = grid[0].length;
        int islands = 0;

        for(int r=0; r<rows; r++){
            for(int c=0; c<cols; c++){
                if(grid[r][c] == '1'){
                    dfs(grid, r, c);
                    islands++;
                }
            }
        }
        return islands;
    }
    private static void dfs(char[][] grid, int r, int c){
        if(r<0 || c<0 || r>=grid.length || c>=grid[0].length || grid[r][c] == '0'){
            return;
        }
        grid[r][c] = '0'; //marking it as visited 
        //traversing it's neighbours

        dfs(grid, r+1, c); //down
        dfs(grid, r-1, c); //up
        dfs(grid, r, c+1); //right
        dfs(grid, r, c-1); //left
    }
}




//find the no of islands: island is adjacent 1's is 1 island surrounding 0
//edge cases:
//if grid is empty or it's [[]] = 0
//if all water [[0]] = 0 
//if all land [[1,1][1,1]] = 1
//multiple single islands = count of island
// is m always === n? should return the same