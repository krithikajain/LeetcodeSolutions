class Solution {
    public boolean exist(char[][] board, String word) {
        int rows=board.length, cols=board[0].length;
        //to keep a track of the visited char
        boolean[][] visited = new boolean[rows][cols];
        //since it's a 2D array we loop  through every element
        for(int r=0; r<rows; r++){
            for(int c=0; c<cols; c++){
               if(wordsearch(board, word, r, c, visited,0))
                return true;
            }
        }
        return false;
    }
    private boolean wordsearch(char[][] board, String word, int r, int c, boolean[][] visited, int idx){
        //base case - found the path
        if(idx == word.length())
            return true;
        
        //take care of the edge cases
        if(r<0 || r>=board.length || c<0 || c>=board[0].length || visited[r][c] || board[r][c]!=word.charAt(idx))
        return false;

        // look/recurse in all directions for possible paths
        visited[r][c] = true; 
        boolean found = wordsearch(board, word, r+1, c, visited, idx+1)||
        wordsearch(board, word, r-1, c, visited, idx+1)||
        wordsearch(board, word, r, c+1, visited, idx+1)||
        wordsearch(board, word, r, c-1, visited, idx+1);

        visited[r][c] = false; //clear all the previous visited paths

        return found;
    }
}

//clarifications
//cannot resuse the same letter which is already in my path
//no diagonal movement
//contains both uppercase and lowercase in same class