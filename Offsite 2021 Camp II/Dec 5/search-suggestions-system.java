// https://leetcode.com/problems/search-suggestions-system/

class TrieNode{
    Character val;
    TrieNode[] children;
    boolean isWord;
    
    TrieNode(){
        val = null;
        children = new TrieNode[26];
        isWord = false;
    }
    
    TrieNode(char val){
        this();
        this.val = val;
    }
    
    private int getIndex(char c) { return c - 'a'; }   
    
    public boolean hasChild(char c){
        return children[getIndex(c)] != null;
    }
    
    public TrieNode getChild(char c){
        return children[getIndex(c)];
    }
    
    public TrieNode addChild(char c){
        return children[getIndex(c)] = new TrieNode(c);
    }
    
    @Override
    public String toString(){
        return "Node { val: " + val + " children: " + (isWord ? "}" : Arrays.toString(children)) + " }";
    }
}

class Trie{
    TrieNode root;
    
    Trie(){
        root = new TrieNode('*');
    }
    
    public void addWord(String word){
        TrieNode curr = root;
        for(char letter : word.toCharArray()){
            if(!curr.hasChild(letter)) 
                curr = curr.addChild(letter);
            else 
                curr = curr.getChild(letter);
        }
        curr.isWord = true;
    }
}

class Solution {
    public List<List<String>> suggestedProducts(String[] products, String searchWord) {
        Trie trie = new Trie();
        List<List<String>> res = new ArrayList<>();
        for(String product : products){
            trie.addWord(product);
        }
        
        TrieNode curr = trie.root;
        String phrase = "";
        for(char letter : searchWord.toCharArray()){
            if(!curr.hasChild(letter)) break;
            curr = curr.getChild(letter);
            
            List<String> phraseRes = new ArrayList<>();
            if(curr.isWord) phraseRes.add(phrase+letter);
            search(curr, phrase+letter, phraseRes);
            res.add(phraseRes);
            phrase+=letter;
        }
        int size = searchWord.length();
        while(res.size() < size){
            res.add(new ArrayList<>());
        }
        return res;
    }
    

    public void search(TrieNode node, String phrase, List<String> words){
        if(words.size() >= 3) return;
        
        for(char letter = 'a'; letter<='z'; letter++){
            if(words.size() >= 3) return;
            if(node.hasChild(letter)){
                TrieNode child = node.getChild(letter);
                if(child.isWord) words.add(phrase+letter);
                search(child, phrase+letter, words);
            }
        }
    }
}