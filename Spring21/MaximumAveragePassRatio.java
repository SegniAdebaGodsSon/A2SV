import java.util.Arrays;
import java.util.PriorityQueue;

class Solution {
    public double maxAverageRatio(int[][] classes, int extraStudents) {

        // sort the array by which of the two compared to sort in the heap has the biggest impact when a student is added
        PriorityQueue<int[]> heap = new PriorityQueue<int[]>( (class1, class2) -> {
            double ratio1 = (class1[0] + 1.0)/(class1[1] + 1.0) - (double) class1[0]/class1[1];
            double ratio2 = (class2[0] + 1.0)/(class2[1] + 1.0) - (double) class2[0]/class2[1];
            return ratio1 > ratio2 ? -1 : 1;
        });

        heap.addAll(Arrays.asList(classes));
        while(extraStudents > 0)
        {
            int[] min = heap.poll();
            min[0]++;
            min[1]++;
            extraStudents--;
            // needs to be added again b/c it could and will have d/t priority that it's previous
            heap.add(min);
        }

        double maxAverage = 0;

        while(!heap.isEmpty())
        {
            int[] cls = heap.poll();
            maxAverage += (double) cls[0] / cls[1];
            System.out.println(Arrays.toString(cls));
        }

        return maxAverage / classes.length;

    }
}