import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;


// Definition for Employee.
class Employee {
    public int id;
    public int importance;
    public List<Integer> subordinates;
};

class Solution {

    public static void main(String[] args) {
        Employee one = new Employee();
        one.id = 1;
        one.importance = 5;
        one.subordinates = new ArrayList<Integer>();
        one.subordinates.add(2);
        one.subordinates.add(3);

        Employee two = new Employee();
        two.id = 2;
        two.importance = 3;
        two.subordinates = new ArrayList<Integer>();
        two.subordinates.add(4);

        Employee three = new Employee();
        three.id = 3;
        three.importance = 4;
        three.subordinates = new ArrayList<Integer>();

        Employee four = new Employee();
        four.id = 4;
        four.importance = 1;
        four.subordinates = new ArrayList<Integer>();

        List<Employee> input = new ArrayList<>();
        input.add(one);
        input.add(two);
        input.add(three);
        input.add(four);
        System.out.println(getImportance(input, 1));
    }

    public static int getImportance(List<Employee> employees, int id) {
        HashSet<Integer> visited = new HashSet<>();
        HashMap<Integer, ArrayList> adjList = new HashMap<>();
        for(Employee employee : employees){
            ArrayList val = new ArrayList<>();
            val.add(employee.importance);
            val.add(employee.subordinates);
            adjList.put(employee.id, val);
        }

        return getImportanceHelper(id, visited, adjList, 0);
    }

    public static int getImportanceHelper(int id, HashSet<Integer> visited, HashMap<Integer, ArrayList> adjList, int importance){
        if(visited.contains(id)) return importance;
        visited.add(id);
        importance += (int) adjList.get(id).get(0);

        // get the object from the HashMap, then the second element of the value
        ArrayList subords = (ArrayList) adjList.get(id).get(1);

        for(Object sub : subords)
            if(!visited.contains(sub))
                importance = getImportanceHelper((int) sub, visited, adjList, importance);

        return importance;
    }
}
