import java.util.*;

class Node {
    public int val;
    public List<Node> children;

    public Node() {}

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, List<Node> _children) {
        val = _val;
        children = _children;
    }
};


class Solution {

    public static void main(String[] args) {
        Node one = new Node(1);
        Node two = new Node(2);
        Node three = new Node(3);
        Node four = new Node(4);
        Node five = new Node(5);
        Node six = new Node(6);

        one.children = new ArrayList<>();
        one.children.add(two);
        one.children.add(three);
        one.children.add(four);

        two.children = new ArrayList<Node>();

        three.children = new ArrayList<Node>();
        three.children.add(five);
        three.children.add(six);

        four.children = new ArrayList<Node>();
        five.children = new ArrayList<Node>();
        six.children = new ArrayList<Node>();
        int de = maxDepth2(one);
        System.out.println("Depth -> " + de);
    }
    public static int maxDepth(Node root) {
        if(root == null) return 0;
        return depth(root, 1);
    }

    public static int depth(Node node, int d){
//         System.out.println("Current node -> " + node.val + "\n" + "Level = " + d + "\n");
        if(node.children.size() == 0)
            return d;

        ListIterator<Node> iterator = node.children.listIterator();
        int dd = d;
        while(iterator.hasNext()){      // change to for-in loop
            Node next = iterator.next();
//            System.out.println("Math.max(" + d + ", depth(" + next.val + ", " +  (d+1) + ")");
            dd = Math.max(dd, depth(next, d+1));
        }
        return dd;
    }

    // APPROACH 2 - MORE CONCISE - 4 LINER
    public static int maxDepth2(Node root){
        if(root == null || root.children == null) return root == null ? 0 : 1;
        int res = 1;
        for(Node node : root.children)
            res = Math.max(res, maxDepth2(node) + 1);    // 1 -> caller node ... maxDepth2(node) -> height of child tree
        return res;
    }

    // APPROACH 3 - ALMOST THE SAME WITH <APPROACH - 2> ABOVE --- BUT SOMEHOW TAKES 0ms TO RUN UNLIKE THE ABOVE(30+)
    public static int maxDepth3(Node root){ // checks for the height of children if they exist and adds it's self(1)
        if(root == null) return 0;  // no need to check if the children value is null, because it never is, can only be an empty ArrayList
        int depth = 1; // because the root is not null, it's counted as one
        for(Node child : root.children)
            depth = Math.max(depth, maxDepth3(child)+1);
        return depth;
    }
}


