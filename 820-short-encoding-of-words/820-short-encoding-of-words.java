class TrieNode {
    public boolean isEnd;
    public int index;
    public HashMap<Character, TrieNode> child;
    public TrieNode() {
        isEnd = false;
        index = -1;
        child = new HashMap();
    }
}
class Trie {
    public TrieNode root;
    public Trie() {
        root = new TrieNode();
    }
    public void add(String s, int index) {
        TrieNode cur = root;
        for (int i=s.length()-1; i>=0; i--) {
            char c = s.charAt(i);
            if (cur.child.containsKey(c) == false) {
                cur.child.put(c, new TrieNode());
            }
            cur = cur.child.get(c);
        }
        cur.isEnd = true;
        cur.index = index;
    }
}
class Solution {
    public int minimumLengthEncoding(String[] words) {
        Trie trie = new Trie();
        for (int i=0; i<words.length; i++) {
            trie.add(words[i], i);
        }
        
        Queue<TrieNode> q = new ArrayDeque();
        q.add(trie.root);
        int totalLength = 0;
        while (q.size() > 0) {
            TrieNode cur = q.poll();
            if (cur.child.size() == 0) {
                totalLength += words[cur.index].length()+1;
            }
            for (char key : cur.child.keySet()) {
                q.add(cur.child.get(key));
            }
        }
        return totalLength;
    }
}