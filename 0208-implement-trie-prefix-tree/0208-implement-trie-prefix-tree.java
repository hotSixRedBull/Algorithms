class TrieNode {
    boolean isEnd;
    HashMap<Character, TrieNode> child;
    public TrieNode() {
        isEnd = false;
        child = new HashMap();
    }
}

class Trie {
    TrieNode root;
    public Trie() {
        root = new TrieNode();
    }
    
    public void insert(String word) {
        TrieNode cur = root;
        for (int i=0; i<word.length(); i++) {
            if (cur.child.containsKey(word.charAt(i)) == false) {
                cur.child.put(word.charAt(i), new TrieNode());
            }
            cur = cur.child.get(word.charAt(i));
        }
        cur.isEnd = true;
    }
    
    public boolean search(String word) {
        TrieNode cur = root;
        for (int i=0; i<word.length(); i++) {
            if (cur.child.containsKey(word.charAt(i)) == false) {
                return false;
            }
            cur = cur.child.get(word.charAt(i));
        }
        return cur.isEnd;
    }
    
    public boolean startsWith(String prefix) {
        TrieNode cur = root;
        for (int i=0; i<prefix.length(); i++) {
            if (cur.child.containsKey(prefix.charAt(i)) == false) {
                return false;
            }
            cur = cur.child.get(prefix.charAt(i));
        }
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