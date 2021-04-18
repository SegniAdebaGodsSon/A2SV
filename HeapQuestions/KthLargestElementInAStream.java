import java.util.*;
class KthLargest {
    private PriorityQueue<Integer> heap;
    private int k;
    public KthLargest(int k, int[] nums) {
        this.k = k;
        this.heap = new PriorityQueue<Integer>();
        this.addListToHeap(nums);
    }

    public int add(int val) {
        if(this.heap.size() < k)
        {
            this.heap.offer(val);
        }
        else if(this.heap.peek() < val)
        {
            this.heap.poll();
            this.heap.offer(val);
        }
        return this.heap.peek();
    }

    private void addListToHeap(int[] nums)
    {
        for(int num : nums)
        {
            this.add(num);
        }
    }
}

/**
 * Your KthLargest object will be instantiated and called as such:
 * KthLargest obj = new KthLargest(k, nums);
 * int param_1 = obj.add(val);
 */
