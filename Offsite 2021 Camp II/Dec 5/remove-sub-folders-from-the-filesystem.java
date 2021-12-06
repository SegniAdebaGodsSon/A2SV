// https://leetcode.com/problems/remove-sub-folders-from-the-filesystem/

import java.util.StringTokenizer;
class TrieNode {
    private HashMap<String, TrieNode> map;
    boolean isWord;
    String val;
    
    TrieNode(){
        map = new HashMap<>();
        isWord = false;
        val = "*";
    }
    
    TrieNode(String val){
        this();
        this.val = val;
    }
    
    public boolean hasChild(String c){
        return map.containsKey(c);
    }
    
    public TrieNode getChild(String c){
        if(hasChild(c)) return map.get(c);
        return null;
    }
    
    public TrieNode addChild(String c){
        map.put(c, new TrieNode(c));
        return map.get(c);
    }
}

class Trie{
    TrieNode root;
    Trie(){
        root = new TrieNode();
    }
    
    public boolean addFolder(String folder){
        TrieNode curr = root;
        StringTokenizer stringTokenizer = new StringTokenizer(folder, "/");
        
        while(stringTokenizer.hasMoreTokens()){
            String f = stringTokenizer.nextToken();
            if(curr.hasChild(f)){
                if(curr.getChild(f).isWord) return false;
                curr = curr.getChild(f);
            }else{
                curr = curr.addChild(f);
            }
        }
        curr.isWord = true;

        return true;
    }
}


class Solution {
    public List<String> removeSubfolders(String[] folders) {
        List<String> ans = new ArrayList<>();
        List<String> foldersList = new ArrayList<>();
        for(String folder : folders) foldersList.add(folder);
        foldersList.sort((folder1, folder2) -> Integer.compare(folder1.length(), folder2.length()));
        Trie trie = new Trie();
        for(String folder : foldersList){
            if(trie.addFolder(folder)) ans.add(folder);
        }
        return ans;
    }
}