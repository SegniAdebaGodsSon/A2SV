import java.util.HashMap;

class Solution {
    public String[] getFolderNames(String[] names) {
        HashMap<String, Integer> count = new HashMap<>();
        String[] result = new String[names.length];

        int index = 0;
        for(String name : names)
        {
            if(count.containsKey(name))
            {
                int val = count.get(name);
                StringBuilder sb = new StringBuilder(name).append("(").append(val).append(")");
                while(count.containsKey(sb.toString()))
                {
                    val++;
                    sb = new StringBuilder(name).append("(").append(val).append(")");
                }
                count.put(name, val + 1);
                count.put(sb.toString(), 1);
                result[index] = sb.toString();
            }
            else
            {
                result[index] = name;
                count.put(name, 1);
            }

            index++;
        }

        return result;
    }
}