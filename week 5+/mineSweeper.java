import java.util.ArrayDeque;
import java.util.Arrays;

class Scratch {


    public static char[][] updateBoard(char[][] board, int[] click) {

        if(board[click[0]][click[1]] == 'M'){
            board[click[0]][click[1]] = 'X';
            return board;
        }
        int[][] dirs = {{-1, -1}, {-1, 0}, {-1, 1}, {0, 1}, {1, 1}, {1, 0}, {1, -1}, {0, -1}};


        return updateBoardHelperBFS(dirs, board, click);
    }

    public static char[][] updateBoardHelper(int[][] dirs ,char[][] board, int[] current){
        int maxX = board.length;
        int maxY = board[0].length;
        int x = current[0], y = current[1];

        int mines = 0;
        for(int[] i : dirs){
            int[] curr = {i[0] + x, i[1] + y};
            if(inBounds(maxX, maxY, curr) && board[curr[0]][curr[1]] == 'M'){
                mines++;
            }
        }

        board[x][y] = 'B';
        if(mines > 0){
            board[x][y] = (char) ('0' + mines);
            return board;
        }

        for (int[] i : dirs){
            int[] curr = {i[0] + current[0], i[1] + current[1]};
            if(inBounds(maxX, maxY, curr)){
                if(board[curr[0]][curr[1]] == 'E') {
                    updateBoardHelper(dirs, board, curr);
                }
            }
        }

        return board;
    }
















    public static char[][] updateBoardHelperBFS(int[][] dirs ,char[][] board, int[] current){
        int maxX = board.length;
        int maxY = board[0].length;
        int x = current[0], y = current[1];

        board[x][y] = 'B';

        int mines = 0;
        for(int[] i : dirs){
            int[] curr = {i[0] + x, i[1] + y};
            if(inBounds(maxX, maxY, curr) && board[curr[0]][curr[1]] == 'M'){
                mines++;
            }
        }

        if(mines > 0){
            board[x][y] = (char) ('0' + mines);
            return board;
        }

        ArrayDeque<int[]> queue = new ArrayDeque();
        for(int[] i : dirs){
            int[] curr = {x + i[0] , y + i[1]};
            if(inBounds(maxX, maxY, curr)){
                queue.add(curr);
            }
        }
        int[] head;
        while(!queue.isEmpty()){
            head = queue.poll();
            if(board[head[0]][head[1]] == 'E'){
                updateBoardHelperBFS(dirs, board, head);
            }
        }

        return board;
    }





















    public static boolean inBounds(int maxX, int maxY, int[] curr){
        if((curr[0] >= 0 && curr[0] < maxX) && (curr[1] >=0 && curr[1] < maxY))
            return true;
        return false;
    }


    public static void main(String[] args) {
        char[][] input = {{'E','E','E','E','E'},{'E','E','M','E','E'},{'E','E','E','E','E'},{'E','E','E','E','E'}};
        int[] click = {3, 0};
        char[][] output = updateBoard(input, click);
        System.out.println(Arrays.deepToString(output));

    }
}