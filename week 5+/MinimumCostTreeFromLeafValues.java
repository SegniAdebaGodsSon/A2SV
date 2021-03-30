import java.util.ArrayList;
import java.util.Arrays;

class Solution {
    public static void main(String[] args) {
        mctFromLeafValues(new int[]{7,12,8,10});


    }

    public static int mctFromLeafValues(int[] arr) {
        ArrayList<Integer> array = new ArrayList<>();
        for (int i : arr) array.add(i);

        int sum = 0;

        while(array.size() >  1){
            int[] minInd = getMin(array);
            int prod = array.get(minInd[0]) * array.get(minInd[1]);
            System.out.println(array + " -> " + Arrays.toString(minInd) + " -> " + prod);
            sum+=prod;
            int min = -1;
            if(array.get(minInd[0]) > array.get(minInd[1])) min = minInd[1];
            else min = minInd[0];
            array.remove(min);
        }

        System.out.println(sum);
        return sum;
    }

    public static int[] getMin(ArrayList<Integer> array){
        int i = 0, j = 1;
        int min = array.get(i) * array.get(j);
        System.out.println(min);
        for(int iter=1; iter<array.size()-1; iter++){
            if(min > array.get(iter) * array.get(iter+1)){
                min = array.get(iter) * array.get(iter+1);
                i=iter;
                j=iter+1;
            }
        }
        return new int[]{i ,j};
    }
}