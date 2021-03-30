import java.util.*;

class Scratch {
    public static void main(String[] args) {
//        String[][] input = {{"add", "hacker"}, {"add", "hackerRank"}, {"find", "hac"}, {"find", "hak"}};
//        System.out.println(Arrays.toString(contacts(input)));
        beautifulPairs(new int[]{3, 5, 7, 11, 5, 8}, new int[]{5, 7, 11, 10, 5, 8});

    }

    static int beautifulPairs(int[] A, int[] B) {
        HashMap<Integer, ArrayList<Integer>> a = new HashMap<>();
        HashMap<Integer, ArrayList<Integer>> b = new HashMap<>();

        HashSet<Integer> visA = new HashSet<>();
        HashSet<Integer> visB = new HashSet<>();

        for(int i=0; i<A.length; i++){
            ArrayList<Integer> val = a.getOrDefault(A[i], new ArrayList<Integer>());
            val.add(i);
            a.put(A[i], val);
        }

        for(int i=0; i<B.length; i++){
            ArrayList<Integer> val = b.getOrDefault(B[i], new ArrayList<Integer>());
            val.add(i);
            b.put(B[i], val);
        }

        int count = 0;
        for(int key : a.keySet()){
            if(b.containsKey(key)){
                for(int i : a.get(key)){
                    visA.add(i);
                }
                for(int i : b.get(key)){
                    if(!visB.contains(key)) visB.add(i);
                }

                System.out.println(visB.size());
                count=visB.size();
            }
        }

        int diffA = A.length - visA.size();
        int diffB = B.length - visB.size();

        if(diffA > 0 && diffB > 0) count += diffA;
        System.out.println("Vis A -> " + visA);
        System.out.println("Vis B -> " + visB);
        System.out.println("Count: " + count);

        System.out.println(a);
        System.out.println(b);

        return count;

    }

    static int maxMin(int k, int[] arr) {
        int i = 0, j=k-1;
        Arrays.sort(arr);
        int unfairness = Integer.MAX_VALUE;
        while(j < arr.length) {
            unfairness = Math.min(unfairness, arr[j] - arr[i]);
            i++;
            j++;
        }
        return unfairness;
    }

    static int[] contacts(String[][] queries) {
        ArrayList<Integer> result = new ArrayList<>();
        ArrayList<String> words = new ArrayList<>();

        for(String[] query : queries){
            if(query[0].equals("add")){
                words.add(query[1]);
            }else{
                int count = 0;
                for(String word : words){
                    if(word.contains(query[1])) count++;
                }
                result.add(count);
            }
        }

        int ind = 0;
        int[] resultArr = new int[result.size()];
        for(Integer i : result){
            resultArr[ind] = i;
            ind++;
        }

        return resultArr;

    }

}