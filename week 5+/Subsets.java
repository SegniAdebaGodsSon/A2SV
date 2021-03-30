import java.util.ArrayList;

class Scratch {
    public static void main(String[] args) {
//        System.out.println("000");
        int[] input = {1,2};
        ArrayList<ArrayList<Integer>> result = new ArrayList<>();

        for(int i= (int) Math.pow(2, input.length); i<= (int) Math.pow(2, input.length+1) -1; i++){
            ArrayList<Integer> combination = new ArrayList<>();
            String pattern = Integer.toBinaryString(i);
            for(int j = 1; j<=input.length; j++){
                if(pattern.charAt(j) == '1') combination.add(input[j-1]);
            }
            result.add(combination);
        }

        System.out.println(result);

    }
}