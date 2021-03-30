import java.util.ArrayDeque;
import java.util.Deque;

class Solution {
    public static void main(String[] args) {
        int res = mctFromLeafValues(new int[]{6, 2, 4});
        System.out.println(res);
    }

    public static int mctFromLeafValues(int[] arr) {
        Deque<Integer> stack = new ArrayDeque<>();
        stack.push(Integer. MAX_VALUE);
        int sum = 0;

        for (int i: arr) {
            while (stack.peek() <=i) {
                int curr = stack.pop();
                sum += curr * Math.min(stack.peek(), i);
            }
            stack.addFirst(i);
        }

        while (stack.size() > 2) {
            sum += stack.pop() * stack.peek();
        }




        return sum;
    }
}