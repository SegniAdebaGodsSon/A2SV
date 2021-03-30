class Scratch {
    public static void main(String[] args) {
        int[] input = {7, 1, 5, 3, 6, 4};
        int[] input2 = {1,2,3,4,5};
        int[] input3 = {1};
        System.out.println(maxProfit2(input3));
    }


    // approach 1
    // TC - O(n)
    // SC - O(1)
    public static int maxProfit(int[] prices) {
        int profit = 0;
        for (int i = 0; i < prices.length - 1; i++)
            profit += Math.max(0, prices[i + 1] - prices[i]);
        return profit;
    }

    public static int maxProfit2(int[] prices) {
        if(prices.length == 1) return 0;
        int profit = 0, min = prices[0], i = 0;
        Boolean dec = null;
        for (; i < prices.length - 1; i++) {
            if (prices[i] >= prices[i+1] || i== prices.length-1){             //
                if (dec != null && !dec) profit += prices[i] - min;
                min = prices[i+1];
                dec = true;
            } else dec = false;
        }
        if(i<=prices.length-1 && !dec) profit += prices[i] - min;
        return profit;
    }
}