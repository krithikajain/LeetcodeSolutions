class Solution {
    public int orangesRotting(int[][] grid) {
        Queue<int[]> q = new ArrayDeque<>();
        int fresh = 0;
        int time = 0;

        for(int r=0; r<grid.length; r++){
            for(int c=0; c<grid[0].length; c++){
                if(grid[r][c] == 1){
                    fresh++;
                }
                if(grid[r][c] == 2){
                    q.offer(new int[]{r,c});
                }
            }
        }
        int[][] directions = {{0,1},{0,-1},{1,0},{-1,0}};
        while(!q.isEmpty() && fresh>0){
            int length = q.size();
            for(int i=0; i<length; i++){
            int[] cur = q.poll();
            int r = cur[0];
            int c = cur[1];

            for(int[] dir:directions){
                int row = r + dir[0];
                int col = c + dir[1];

                if (row >= 0 && row < grid.length && col >= 0 && col < grid[0].length && grid[row][col] == 1){
                    grid[row][col] = 2;
                    q.offer(new int[]{row,col});
                    fresh --;
                }
            }
            }
            time++;
        }
    return fresh == 0 ? time : -1;
}
}
//(0,0) -> (0,1),(1,0) -> rot as ex

// there's rotten oranges every iteration the neighboring fresh oranges also rot return min time until all are rot otherwise -1---> looks like bfs
// track rotten oranges -> insert into q 
//track the fresh oranges -> count in fresh
//while !q.empty and fresh oranges>0
//for each rotten q.poll() and find it's neighours and q.offer()
//time++ and fresh--



//clarifications and edge cases
// no oranges -? 
// 1 orange - rot = 0; fresh = -1
// 2 rotten oranges -> simultaneously rot the neighbours
// no adjacent rotten oranges -> fresh left -> -1