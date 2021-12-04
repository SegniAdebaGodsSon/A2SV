// https://leetcode.com/problems/design-add-and-search-words-data-structure/

class TrieNode{
    Character val;
    TrieNode[] children;
    boolean isEndOfWord;
    TrieNode(){
        val = null;
        children = new TrieNode[26];
        isEndOfWord = false;
    }
    
    TrieNode(Character c){
        this();
        val = c;
    }
    
    public boolean hasNode(char c){
        return children[getInd(c)] != null;
    }
    
    public TrieNode getNode(char c){
        if(hasNode(c)) return children[getInd(c)];
        return null;
    }
    
    public TrieNode addNode(char c){
        return children[getInd(c)] = new TrieNode(c);
    }
        
    private int getInd(char c){
        return c - 'a';
    }
    
    @Override
    public String toString(){
        return "TrieNode{ val: " + (val != null ? val : "NULL ") + " children: " +
                Arrays.toString(children) + "}";
    }
    
}
class WordDictionary {
    TrieNode root;
    public WordDictionary() {
        root = new TrieNode();
    }
    
    public void addWord(String word) {
        TrieNode curr = root;
        for(char c : word.toCharArray()){
            if(curr.hasNode(c)){
                curr = curr.getNode(c);
            }else{
                curr = curr.addNode(c);
            }
        }
        curr.isEndOfWord = true;
    }
    
    public boolean search(String word) {
        
        return search(word, root);
    }
    
    private boolean search(String word, TrieNode node){
        TrieNode curr = node;
        for(int i=0; i<word.length(); i++){
            char c = word.charAt(i);
            if(Character.compare(c, '.') == 0){
                boolean exists = false;
                for(char j = 'a'; j <= 'z'; j++){
                    j = (char) j;
                    if(curr.hasNode(j)){
                        exists |= search(j + word.substring(i+1), curr);
                        if(exists) return true;
                    }
                }
                return exists;
            }else{
                if(curr.hasNode(c)){
                    curr = curr.getNode(c);
                    if(word.length() - 1 == i && !curr.isEndOfWord) return false;
                } 
                else 
                    return false;
            }
            
        }
        return true;
    }
}

/**
 * Your WordDictionary object will be instantiated and called as such:
 * WordDictionary obj = new WordDictionary();
 * obj.addWord(word);
 * boolean param_2 = obj.search(word);
 */