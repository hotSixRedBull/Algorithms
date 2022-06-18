class TrieNode {
    public boolean isEnd;
    public boolean isSuffix;
    public int index;
    public Set<Integer> suffixIndex;
    public TrieNode[] child;
    public TrieNode() {
        isEnd = false;
        isSuffix = false;
        index = -1;
        suffixIndex = new HashSet();
        child = new TrieNode[26];
    }
}

class Trie {
    public TrieNode root;
    public Trie() {
        root = new TrieNode();
    }
    public void add(String s, int index) {
        TrieNode cur = root;
        for (int i=0; i<s.length(); i++) {
            int c = s.charAt(i) - 'a';
            if (cur.child[c] == null) {
                cur.child[c] = new TrieNode();
            }
            cur = cur.child[c];
        }
        cur.isEnd = true;
        cur.index = index;
    }
    public void addSuffix(String s, int index) {
        TrieNode cur = root;
        for (int i=0; i<s.length(); i++) {
            int c = s.charAt(i) - 'a';
            if (cur.child[c] == null) {
                cur.child[c] = new TrieNode();
            }
            cur = cur.child[c];
        }
        cur.isSuffix = true;
        cur.suffixIndex.add(index);
    }
    public Set<Integer> find(String prefix) {
        Set<Integer> ret = new HashSet();
        TrieNode cur = root;
        for (int i=0; i<prefix.length(); i++) {
            int c = prefix.charAt(i) - 'a';
            if (cur.child[c] == null) {
                return ret;
            }
            cur = cur.child[c];
        }
        Queue<TrieNode> q = new ArrayDeque();
        q.add(cur);
        while (q.size() > 0) {
            TrieNode node = q.poll();
            if (node.isEnd) {
                ret.add(node.index);
            }
            for (int i=0; i<26; i++) {
                if (node.child[i] != null) {
                    q.add(node.child[i]);
                }
            }
        }
        return ret;
    }
    public Set<Integer> findSuffix(String suffix) {
        TrieNode cur = root;
        for (int i=0; i<suffix.length(); i++) {
            int c = suffix.charAt(i) - 'a';
            if (cur.child[c] == null) {
                return new HashSet();
            }
            cur = cur.child[c];
        }
        return cur.suffixIndex;
    }
}

class WordFilter {
    Trie trie;
    public WordFilter(String[] words) {
        trie = new Trie();
        for (int i=0; i<words.length; i++) {
            trie.add(words[i], i);
            for (int j=words[i].length()-1; j>=0; j--) {
                trie.addSuffix(words[i].substring(j,words[i].length()), i);
            }
        }
    }
    
    public int f(String prefix, String suffix) {
        Set<Integer> set = trie.find(prefix);
        Set<Integer> suffixSet = trie.findSuffix(suffix);
        set.retainAll(suffixSet);
        List<Integer> li = new ArrayList(set);
        Collections.sort(li);
        if (li.size() > 0) {
            return li.get(li.size()-1);
        }
        return -1;
    }
}

/*
["WordFilter","f","f","f","f","f","f","f","f","f","f"]
[[["cabaabaaaa","ccbcababac","bacaabccba","bcbbcbacaa","abcaccbcaa","accabaccaa","cabcbbbcca","ababccabcb","caccbbcbab","bccbacbcba"]],["bccbacbcba","a"],["ab","abcaccbcaa"],["a","aa"],["cabaaba","abaaaa"],["cacc","accbbcbab"],["ccbcab","bac"],["bac","cba"],["ac","accabaccaa"],["bcbb","aa"],["ccbca","cbcababac"]]
*/

/**
 * Your WordFilter object will be instantiated and called as such:
 * WordFilter obj = new WordFilter(words);
 * int param_1 = obj.f(prefix,suffix);
 */