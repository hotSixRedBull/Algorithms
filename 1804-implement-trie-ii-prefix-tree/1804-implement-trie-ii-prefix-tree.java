class TrieNode {
    boolean isEnd;
    int count;
    Map<Character, TrieNode> childs;
    public TrieNode() {
        isEnd = false;
        count = 0;
        childs = new HashMap();
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
            if (cur.childs.containsKey(word.charAt(i)) == false) {
                cur.childs.put(word.charAt(i), new TrieNode());
            }
            cur.count++;
            cur = cur.childs.get(word.charAt(i));
        }
        cur.count++;
        cur.isEnd = true;
    }
    
    public int countWordsEqualTo(String word) {
        TrieNode cur = root;
        for (int i=0; i<word.length(); i++) {
            if (cur.childs.containsKey(word.charAt(i)) == false) {
                return 0;
            }
            cur = cur.childs.get(word.charAt(i));
        }
        int totalCount = cur.count;
        int childCount = 0;
        for (char child : cur.childs.keySet()) {
            childCount += cur.childs.get(child).count;
        }
        // System.out.println(String.format("total: %d, child: %d", totalCount, childCount));
        return totalCount-childCount;
    }
    
    public int countWordsStartingWith(String prefix) {
        TrieNode cur = root;
        for (int i=0; i<prefix.length(); i++) {
            if (cur.childs.containsKey(prefix.charAt(i)) == false) {
                return 0;
            }
            cur = cur.childs.get(prefix.charAt(i));
        }
        return cur.count;
    }
    
    public void erase(String word) {
        TrieNode cur = root;
        for (int i=0; i<word.length(); i++) {
            if (cur.childs.containsKey(word.charAt(i)) == false) {
                return;
            }
            cur = cur.childs.get(word.charAt(i));
        }
        if (cur.isEnd == false) {
            return;
        }
        cur = root;
        for (int i=0; i<word.length(); i++) {
            cur.count--;
            cur = cur.childs.get(word.charAt(i));
        }
        cur.count--;
    }
}

/**
 * Your Trie object will be instantiated and called as such:
 * Trie obj = new Trie();
 * obj.insert(word);
 * int param_2 = obj.countWordsEqualTo(word);
 * int param_3 = obj.countWordsStartingWith(prefix);
 * obj.erase(word);
 */