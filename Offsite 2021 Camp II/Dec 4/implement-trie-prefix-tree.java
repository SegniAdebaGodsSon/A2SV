// https://leetcode.com/problems/implement-trie-prefix-tree/

class TrieNode{
    TrieNode[] children;
    boolean endOfWord;
    Character val;
    
    TrieNode(){
        endOfWord = false;
        children = new TrieNode[26];
        Arrays.fill(children, null);
        val = null;
    }
    
    TrieNode(char val){
        this();
        this.val = val;
    }
    
    public boolean hasChild(char c){
        int index = c - 'a';
        return (children[index] == null ? false : true);
    }
    
    public TrieNode getChild(char c){
        int index = c - 'a';
        if(hasChild(c)){
            return children[index];
        }
        return null;
    }
    
    public TrieNode addChild(char c){
        int index = c - 'a';
        return children[index] = new TrieNode(c);
    }
    
    @Override
    public String toString(){
        return "TrieNode{ val: " + (val != null ? val : "NULL ") + " children: " + 
                Arrays.toString(children) + "}";
    }
}

class Trie {
    
    TrieNode root;

    public Trie() {
        root = new TrieNode();
    }
    
    public void insert(String word) {
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
    
    public boolean search(String word) {
        TrieNode curr = root;
        
        for(char c : word.toCharArray()){
            if(curr.hasChild(c)){
                curr = curr.getChild(c);
            }else{
                return false;
            }
        }
        
        return curr.endOfWord;
    }
    
    public boolean startsWith(String prefix) {
        TrieNode curr = root;
        
        for(char c : prefix.toCharArray()){
            if(curr.hasChild(c)){
                curr = curr.getChild(c);
            }else{
                return false;
            }
        }
        
        // for(TrieNode child : curr.children) if(child != null && !child.endOfWord) return true;
        return true;
    }
}

/**
 * Your Trie object will be instantiated and called as such:
 * Trie obj = new Trie();
 * obj.insert(word);
 * boolean param_2 = obj.search(word);
 * boolean param_3 = obj.startsWith(prefix);
 */