class Solution {

    public static void main(String[] args) {
        char[][] grid = {
                    {'1', '1', '0', '0', '0'},
                    {'1', '1', '0', '0', '0'},
                    {'0', '0', '1', '0', '0'},
                    {'0', '0', '0', '1', '1'}};

        char[][] grid2 = {
                {'1', '1', '1', '1', '0'},
                {'1', '1', '0', '1', '0'},
                {'1', '1', '0', '0', '0'},
                {'0', '0', '0', '0', '0'}};

        System.out.println(numIslands(grid2));
    }


    public static int numIslands(char[][] grid) {
        if(grid.length == 0 || grid[0].length == 0) return 0;
        int count = 0;
        int[][] dirs = {{0,1}, {1, 0}, {0, -1}, {-1, 0}}; // right -> down -> left -> up
        for(int i = 0; i < grid.length; i++){
            for(int j = 0; j < grid[i].length; j++){
                if(grid[i][j] == '1'){
                    dfs(grid, dirs, new int[]{i, j});
                    count++;
                }
            }
        }

        return count;
    }


    public static void dfs(char[][] grid, int[][] dirs, int[] coordinate){
        grid[coordinate[0]][coordinate[1]] = '#';
        for(int[] dir : dirs){
            int[] newCoordinate = {dir[0] + coordinate[0], dir[1] + coordinate[1]};
            if(isInbounds(newCoordinate, grid) && grid[newCoordinate[0]][newCoordinate[1]] == '1')
                dfs(grid, dirs, newCoordinate);
        }
    }


    public static boolean isInbounds(int[] coordinate, char[][] grid){
        int x = coordinate[0], y = coordinate[1];
        return 0 <= x && x < grid.length && 0 <= y && y < grid[0].length;
    }

}