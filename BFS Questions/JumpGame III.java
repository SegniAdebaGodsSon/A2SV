import java.util.*;
class Solution {
    public  boolean canReach(int[] arr, int start) {
        Queue<Integer> queue = new ArrayDeque<>();
        HashSet<Integer> visited = new HashSet<>();
        queue.offer(start);
        while(queue.size() > 0){
            int curr = queue.poll();
            if(arr[curr] == 0) return true;


            if(isInbounds(arr ,curr + arr[curr]) && !visited.contains(curr + arr[curr]))
            {
                queue.offer(curr + arr[curr]);
                visited.add(curr + arr[curr]);

            }


            if(isInbounds(arr, curr - arr[curr]) && !visited.contains(curr - arr[curr]))
            {
                queue.offer(curr - arr[curr]);
                visited.add(curr - arr[curr]);
            }

        }

        return false;

    }

    private boolean isInbounds(int[] arr, int ind)
    {
        return 0 <= ind && ind < arr.length;
    }
}