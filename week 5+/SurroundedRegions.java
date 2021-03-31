import java.util.Arrays;
import java.util.HashSet;

class Solution{

    public static void main(String[] args) {
        char[][] inp = {
                {'O', 'O', 'O', 'O', 'X', 'X'},
                {'O', 'O', 'O', 'O', 'O', 'O'},
                {'O', 'X', 'O', 'X', 'O', 'O'},
                {'O', 'X', 'O', 'O', 'X', 'O'},
                {'O', 'X', 'O', 'X', 'O', 'O'},
                {'O', 'X', 'O', 'O', 'O', 'O'}};

        char[][] inp2 = {
                {'X','X','X','X'},
                {'X','O','O','X'},
                {'X','X','O','X'},
                {'X','O','X','X'}};

        System.out.println((2 + 3) / 3.0d);

//        [["X","O","X","O","X","O"],["O","X","O","X","O","X"],["X","O","X","O","X","O"],["O","X","O","X","O","X"]]



        solve(inp2);

        System.out.println(Arrays.deepToString(inp2));
    }

    public static void solve(char[][] board){
        HashSet<String> visited = new HashSet<>();
        int[][] dirs = {{0, 1}, {1, 0}, {-1, 0}, {0, -1}};
        // Iterate the edges first
        // left edge
        for(int i=0; i<board.length; i++){
            if(board[i][0] == 'O' && !visited.contains(i+","+0))
                dfs(board, dirs, new int[]{i, 0}, visited, true);
        }
// right edge
        for(int i=0; i<board.length; i++){
            if(board[i][board[0].length-1]== 'O' && !visited.contains(i+","+ (board[0].length-1)))
                dfs(board, dirs, new int[]{i, board[0].length-1}, visited, true);
        }
// top edge
        for(int i=0; i<board[0].length;i++){
            if(board[0][i]== 'O' && !visited.contains(0+","+i))
                dfs(board, dirs, new int[]{0, i}, visited, true);
        }
// bottom edge
        for(int i=0; i<board[0].length; i++){
            if(board[board.length-1][i]== 'O' && !visited.contains(board.length-1+","+i))
                dfs(board, dirs, new int[]{board.length-1, i}, visited, true);

        }
// for every other
        for(int row = 0; row<board.length; row++){
            for(int column = 0; column<board[0].length; column++){
                if(board[row][column] == 'O' && !visited.contains(row + "," +column))
                    dfs(board, dirs, new int[]{row, column}, visited, false);
            }
        }

    }

    public static void dfs(char[][] board, int[][] dirs, int[] curr, HashSet<String> visited, boolean isEdge){
        if(!isEdge) board[curr[0]][curr[1]] =  'X';
        visited.add(curr[0] + "," + curr[1]);
        int[] neighbor;
        for(int[] dir : dirs){
            neighbor = new int[]{curr[0] + dir[0], curr[1] + dir[1]};
            if(inBounds(board, neighbor) && !visited.contains(neighbor[0]+ "," + neighbor[1]) && board[neighbor[0]][neighbor[1]] == 'O')
                dfs(board, dirs, neighbor, visited, isEdge);
        }
    }

    public static boolean inBounds(char[][] grid, int[] coordinate){
        return 0 <= coordinate[0] && coordinate[0] < grid.length && 0 <= coordinate[1] && coordinate[1] < grid[0].length;
    }
}
