import java.util.Arrays;

class Solution {

    public static void main(String[] args) {
        int[][] grid = {{1,1,0,1,1},{1,0,0,0,0},{0,0,0,0,1},{1,1,0,1,1}};
        System.out.println(maxAreaOfIsland(grid));

        System.out.println('a' + "," + 'b');
    }


    public static int maxAreaOfIsland(int[][] grid) {
        int maxArea = 0;
        int[][] dirs = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
        for(int i=0; i<grid.length; i++){
            for(int j=0; j<grid[i].length; j++)
                if(grid[i][j] == 1) maxArea = Math.max(maxArea, dfs(grid, dirs, new int[]{i, j}));
        }
        return maxArea;
    }

    public static int dfs(int[][] grid, int[][] dirs, int[] coordinate){
        System.out.println(Arrays.deepToString(grid));
        int i = coordinate[0], j = coordinate[1], count = 1;
        grid[i][j] = -1;
        int[] neighbor;
        for(int[] dir : dirs){
            neighbor = new int[]{i + dir[0], j + dir[1]};
            if(inBounds(grid, neighbor) && grid[neighbor[0]][neighbor[1]] == 1){
                count += dfs(grid, dirs, neighbor);
            }
        }
        return count;
    }

    public static boolean inBounds(int[][] grid, int[] coordinate){
        return 0 <= coordinate[0] && coordinate[0] < grid.length && 0 <= coordinate[1] && coordinate[1] < grid[0].length;
    }
}
