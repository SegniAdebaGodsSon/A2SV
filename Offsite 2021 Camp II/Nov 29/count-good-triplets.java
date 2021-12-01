// https://leetcode.com/problems/count-good-triplets/
class Solution {
    public int countGoodTriplets(int[] arr, int a, int b, int c) {
        int len = arr.length, count = 0;
        for(int i=0; i<len; i++){
            for(int j=0; j<len; j++){
                for(int k=0; k<len; k++){
                    if(i<j && j<k && isGoodTriplet(i, j, k, a, b, c, arr)) count++;
                }
            }
        }
        return count;
    }
    
    public boolean isGoodTriplet(int i, int j, int k, int a, int b, int c, int[] arr){
        return (Math.abs(arr[i] - arr[j]) <= a) && (Math.abs(arr[j] - arr[k]) <= b) && (Math.abs(arr[i] - arr[k]) <= c);
    }
}