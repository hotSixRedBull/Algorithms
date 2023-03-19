class Node {
    boolean isEnd;
    Map<Character, Node> child;
    public Node() {
        isEnd = false;
        child = new HashMap();
    }
}

class WordDictionary {
    Node root;
    Set<String> cache;
    // int n;
    // int nn;
    public WordDictionary() {
        root = new Node();
        cache = new HashSet();
        // n = 0;
        // nn = 0;
    }
    
    public void addWord(String word) {
        // nn++;
        // System.out.println(String.format("%dth, addWord(%s)", nn, word));
        Node cur = root;
        for (int i=0; i<word.length(); i++) {
            cur.child.putIfAbsent(word.charAt(i), new Node());
            cur = cur.child.get(word.charAt(i));
        }
        cur.isEnd = true;
    }
    
    public boolean search(String word) {
        // n++;
        // System.out.println(String.format("%dth: search(%s)",n, word));
        if (cache.contains(word)) {
            return true;
        }
        
        Queue<Node> q = new ArrayDeque();
        Queue<Integer> posQ = new ArrayDeque();
        q.add(root);
        posQ.add(0);
        while (q.size() > 0) {
            Node cur = q.poll();
            int pos = posQ.poll();
            
            if (pos == word.length()) {
                if (cur.isEnd) {
                    cache.add(word);
                    return true;
                }
                else {
                    continue;
                }
            }
            
            if (word.charAt(pos) == '.') {
                for (char key : cur.child.keySet()) {
                    q.add(cur.child.get(key));
                    posQ.add(pos+1);
                }
                continue;
            }
            else if (cur.child.containsKey(word.charAt(pos)) == false) {
                continue;
            }
            else {
                q.add(cur.child.get(word.charAt(pos)));
                posQ.add(pos+1);
            }
        }
        return false;
    }
    
}

/**
 * Your WordDictionary object will be instantiated and called as such:
 * WordDictionary obj = new WordDictionary();
 * obj.addWord(word);
 * boolean param_2 = obj.search(word);
 */