import java.util.*;
class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        HashSet<String> words = new HashSet<>(wordList);
        HashSet<String> visited = new HashSet<>();
        Queue<String> queue = new ArrayDeque<>();
        int count = 1;
        if(!words.contains(endWord)) return 0;

        queue.offer(beginWord);
        String curr = "";
        boolean found = false;
        while(!queue.isEmpty())
        {
            int size = queue.size();
            for(int i=0; i<size; i++)
            {

                curr = queue.poll();
                visited.add(curr);

                if(curr.equals(endWord)){
                    found = true;
                    return count;
                }


                String[] currArr = curr.split("");
                for(int letter=0; letter<currArr.length; letter++)
                {
                    String[] temp = Arrays.copyOf(currArr, currArr.length);
                    for(int j=0; j<26; j++)
                    {
                        temp[letter] = (char) ('a' + j) + "";
                        String tempStr = String.join("", temp);
                        if(words.contains(tempStr) && !visited.contains(tempStr)){
                            queue.offer(tempStr);
                            visited.add(tempStr);
                        }
                    }
                }
            }

            count++;
        }

        if(!found) return 0;
        return count;
    }
}