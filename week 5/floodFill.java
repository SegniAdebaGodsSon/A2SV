import java.util.Arrays;

public class floodFill {
    public static int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
        int[][] neighbours = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}}; // down, right, up, left
        int[] source = {sr, sc};
        int oldColor = image[sr][sc];
        return fill(image, source, newColor, oldColor, neighbours);

    }

    public static int[][] fill(int[][] image, int[] source, int newColor, int oldColor, int[][] neighbours) {
        int maxX = image.length-1;
        int maxY = image[0].length-1;

        image[source[0]][source[1]] = newColor;
        int[] newSource = {};
        for (int[] neighbour : neighbours) {
            newSource = new int[]{source[0] + neighbour[0], source[1] + neighbour[1]};
            if ((newSource[0] >= 0 && newSource[0] <= maxX) && (newSource[1] >= 0 && newSource[1] <= maxY)) {
                if (image[newSource[0]][newSource[1]] == oldColor && image[newSource[0]][newSource[1]] != newColor) {
                    fill(image, newSource, newColor, oldColor, neighbours);
                }
            }
        }


        return image;
    }

    public static void main(String[] args) {
//        int[][] input = {{1, 1, 1}, {1, 1, 0}, {1, 0, 1}};
//        int[][] ans = floodFill(input, 1, 1, 2);
//        System.out.println(Arrays.deepToString(ans));

//        int[][] input = {{0,0,0}, {0,0,0}};
//        int[][] ans = floodFill(input, 0, 0, 2);
//        System.out.println(Arrays.deepToString(ans));

//        int[][] input = {{0,0,0}, {0,1,1}};
//        int[][] ans = floodFill(input, 1, 1, 1);
//        System.out.println(Arrays.deepToString(ans));

        int[][] input = {{0,0,0}, {1,0,0}};
        int[][] ans = floodFill(input, 1, 0, 2);
        System.out.println(Arrays.deepToString(ans));
    }
}
