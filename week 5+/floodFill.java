import java.util.Arrays;

class Scratch {
    public static int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
        int[][] neighbours = {{-1, 0}, {0, 1}, {1, 0}, {0, -1}, }; // up, right, down, left
        int[] source = {sr, sc};
        int oldColor = image[sr][sc];
        return fill(image, source, newColor, oldColor, neighbours);

    }

    public static int[][] fill(int[][] image, int[] source, int newColor, int oldColor, int[][] neighbours) {
        int maxX = image.length-1;
        int maxY = image[0].length-1;

        image[source[0]][source[1]] = newColor;
        int[] newSource;
        for (int[] neighbour : neighbours) {
            newSource = new int[]{source[0] + neighbour[0], source[1] + neighbour[1]};
            if (checkInterval(newSource, maxX, maxY)) {
                if (image[newSource[0]][newSource[1]] == oldColor && image[newSource[0]][newSource[1]] != newColor) {
                    fill(image, newSource, newColor, oldColor, neighbours);
                }
            }
        }
        return image;
    }

    public static boolean checkInterval(int[] curr, int maxX, int maxY){
        if ((curr[0] >= 0 && curr[0] <= maxX) && (curr[1] >= 0 && curr[1] <= maxY)) return true;
        return false;
    }

    public static void main(String[] args) {

        int[][] input = {{1,1,1}, {1,1,0}, {1,0,1}};
        int[][] ans = floodFill(input, 1, 1, 2);
        System.out.println(Arrays.deepToString(ans));
    }


}