// https://leetcode.com/problems/maximum-69-number/

// sol #1
class Solution {
    public int maximum69Number (int num) {
        int[] digits = numToDigitArray(num);
        int len = digits.length;
        int ans = 0;
        for(int i=0; i<len; i++){
            if(digits[i] == 6){
                digits[i] = 9;
                break;
            }
        }
        
        for(int i=0; i<len; i++){
            ans += Math.pow(10, len-i - 1) * digits[i];
        }
        
        return ans;
    }
    
    public int[] numToDigitArray(int num){
        ArrayDeque<Integer> stack = new ArrayDeque<>();
        
        while(num > 0){
            int lastDig = num % 10;
            num /= 10;
            stack.push(lastDig);
        }
        
        int[] ans = new int[stack.size()];
        int i=0;
        while(!stack.isEmpty()){
            ans[i++] = stack.pop();
        }
        return ans;
    }
}



// sol #2
class Solution {
    public int maximum69Number (int num) {
        return Integer.parseInt(new String(num+"").replaceFirst("6","9"));
    }
}