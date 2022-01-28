class TrieNode {
    Map<Character, TrieNode> nodes = new HashMap();
    boolean isEnd = false;
    public TrieNode() {}
}

class WordDictionary {
    TrieNode root;
    
    public WordDictionary() {
        root = new TrieNode();
    }
    
    public void addWord(String word) {
        TrieNode cur = root;
        for (char c : word.toCharArray()) {
            if (!cur.nodes.containsKey(c)) {
                cur.nodes.put(c, new TrieNode());
            }
            cur = cur.nodes.get(c);
        }
        cur.isEnd = true;
    }
    
    public boolean search(String word) {
        return searchRecursive(word, root);
    }
    
    public boolean searchRecursive(String word, TrieNode node) {
        TrieNode cur = node;
        int progress = 0;
        for (char c : word.toCharArray()) {
            if (c == '.') {
                for (char key : cur.nodes.keySet()) {
                    if (searchRecursive(word.substring(progress+1), cur.nodes.get(key))) {
                        return true;
                    }
                }
                return false;
            }
            else {
                if (cur.nodes.containsKey(c)) {
                    cur = cur.nodes.get(c);
                }
                else {
                    return false;
                }
            }
            progress++;
        }
        return cur.isEnd;
    }
}

/**
 * Your WordDictionary object will be instantiated and called as such:
 * WordDictionary obj = new WordDictionary();
 * obj.addWord(word);
 * boolean param_2 = obj.search(word);
 */