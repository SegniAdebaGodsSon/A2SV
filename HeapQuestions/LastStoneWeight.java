import java.util.PriorityQueue;

class Solution {
    public int lastStoneWeight(int[] stones) {
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for(int stone : stones) pq.add(stone * -1);

        while(true)
        {

            if(pq.size() == 1) return (-1 * pq.poll());
            if(pq.size() == 0) return 0;

            int first = -1 * pq.poll(), second = -1 * pq.poll();
            if(first == second) continue;
            pq.add(second - first);
        }
    }
}