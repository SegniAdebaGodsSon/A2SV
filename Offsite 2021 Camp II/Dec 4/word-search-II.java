// https://leetcode.com/problems/word-search-ii/
class TrieNode{
    Character val;
    TrieNode[] children;
    boolean endOfWord;
    
    TrieNode(){
        val = null;
        children = new TrieNode[26];
        endOfWord = false;
    }
    
    TrieNode(char val){
        this();
        this.val = val;
    }
    
    public boolean hasChild(char c){
        int ind = c - 'a';
        return children[ind] != null;
    }
    
    public TrieNode getChild(char c){
        if(hasChild(c)) return children[c-'a'];
        return null;
    }
    
    public TrieNode addChild(char c){
        int ind = c - 'a';
        return children[ind] = new TrieNode(c);
    }
    
    public boolean isAbsoluteEnd(){
        for(TrieNode node : children) if(node != null) return false;
        return true;
    }
}

class Trie{
    TrieNode root;
    Trie(){
        root = new TrieNode();
    }
    
    public void insertWord(String word){
        TrieNode curr = root;
        for(char c : word.toCharArray()){
            if(curr.hasChild(c)){
                curr = curr.getChild(c);
            }else{
                curr = curr.addChild(c);
            }
        }
        curr.endOfWord = true;
    }
    
    public boolean hasWord(String word){
        TrieNode curr = root;
        for(char c : word.toCharArray()){
            if(curr.hasChild(c)){
                curr = curr.getChild(c);
            }else{
                return false;
            }
        }
        return true;
    }
}

class Solution {
    final int[][] dirs = {{-1, 0}, {0, 1}, {1, 0}, {0, -1}};  // up right down left
    public List<String> findWords(char[][] board, String[] words) {
        int rows = board.length, cols = board[0].length;
        boolean[][] visited = new boolean[rows][cols];
        Trie trie = new Trie();
        HashSet<String> list = new HashSet<>();
        for(String word : words){
            trie.insertWord(word);
        }
        
        for(int row=0; row<rows; row++){
            for(int col=0; col<cols; col++){
                if(!trie.root.hasChild(board[row][col])) continue;
                DFS(trie.root.getChild(board[row][col]), new int[]{row, col}, board, visited, list, "");
            }
         }
        return new ArrayList<>(list);
    }
    
    public void DFS(TrieNode node, int[] curr ,char[][] board, boolean[][] visited, HashSet<String> list, String currStr){
        int row=curr[0], col=curr[1];
        currStr += board[row][col];
        if(node.endOfWord) list.add(currStr);
        visited[row][col] = true;
        
        for(int[] dir : dirs){
            int[] newCoord = {row + dir[0], col + dir[1]};
            int newRow = newCoord[0], newCol = newCoord[1];
            
            if(isInBounds(board, newCoord) && node.hasChild(board[newRow][newCol]) && !visited[newRow][newCol]){
                DFS(node.getChild(board[newRow][newCol]), newCoord, board, visited, list, currStr);
            }
        }
        
        visited[row][col] = false;
            
    }
    
    public boolean isInBounds(char[][] board, int[] coord){
        int rows = board.length, cols = board[0].length;
        return 0<=coord[0] && coord[0] < rows && 0 <= coord[1] && coord[1] < cols;
    }
}