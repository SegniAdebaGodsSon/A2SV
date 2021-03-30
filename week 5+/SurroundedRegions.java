import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;

class Solution {
    public static void main(String[] args) {
        // inp
        // [["O","O","O","O","X","X"],
        // ["O","O","O","O","O","O"],
        // ["O","X","O","X","O","O"],
        // ["O","X","O","O","X","O"],
        // ["O","X","O","X","O","O"],
        // ["O","X","O","O","O","O"]]
        char[][] inp = {
                {'O', 'O', 'O', 'O', 'X', 'X'},
                {'O', 'O', 'O', 'O', 'O', 'O'},
                {'O', 'X', 'O', 'X', 'O', 'O'},
                {'O', 'X', 'O', 'O', 'X', 'O'},
                {'O', 'X', 'O', 'X', 'O', 'O'},
                {'O', 'X', 'O', 'O', 'O', 'O'}};

        solve(inp);
        System.out.println(Arrays.deepToString(inp));
        HashMap<Integer, Integer> a = new HashMap<>();
        int[] aa = {12};
        

        // myOut
        // [["O","O","O","O","X","X"],
        // ["O","O","O","O","O","O"],
        // ["O","X","O","X","O","O"],
        // ["O","X","O","X","X","O"],
        // ["O","X","O","X","O","O"],
        // ["O","X","O","O","O","O"]]

        // expected
        // [["O","O","O","O","X","X"],
        // ["O","O","O","O","O","O"],
        // ["O","X","O","X","O","O"],
        // ["O","X","O","O","X","O"],
        // ["O","X","O","X","O","O"],
        // ["O","X","O","O","O","O"]]

    }

    public static void solve(char[][] board) {
        HashSet<String> visited = new HashSet<String>();
        int[][] dirs = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
        for(int row=0; row < board.length; row++){
            for(int column=0; column<board[row].length; column++)
                if(!visited.contains(row+","+column) && board[row][column] == 'O') dfs(board, dirs, new int[]{row, column}, visited);
        }
        System.out.println(visited);
    }

    public static boolean dfs(char[][] board, int[][] dirs, int[] curr, HashSet<String> visited){
        boolean isSurrounded = true;
        int[] neighbor;
        visited.add(curr[0]+","+curr[1]);
        if(curr[0] == board.length - 1|| curr[1] == board[0].length -1 || curr[0] == 0 || curr[1] == 0)
            isSurrounded = false;
        for(int[] dir : dirs){
            neighbor = new int[]{dir[0] + curr[0], dir[1] + curr[1]};
            if(inBounds(board, neighbor) && board[neighbor[0]][neighbor[1]] == 'O' && !visited.contains(neighbor[0]+","+neighbor[1])){
                isSurrounded = dfs(board, dirs, neighbor, visited) && isSurrounded;
            }

        }
        if(isSurrounded) board[curr[0]][curr[1]] = 'X';

        return isSurrounded;
    }

    public static boolean inBounds(char[][] grid, int[] coordinate){
        return 0 <= coordinate[0] && coordinate[0] < grid.length && 0 <= coordinate[1] && coordinate[1] < grid[0].length;
    }


}
