class TrieNode {
    public boolean isEnd;
    public int index;
    public HashMap<Character, TrieNode> childMap;
    public TrieNode() {
        isEnd = false;
        childMap = new HashMap();
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
            char c = s.charAt(i);
            if (cur.childMap.containsKey(c) == false) {
                cur.childMap.put(c, new TrieNode());
            }
            cur = cur.childMap.get(c);
        }
        cur.isEnd = true;
        cur.index = index;
    }
    public List<Integer> find(String s) {
        List<Integer> ret = new ArrayList();
        TrieNode cur = root;
        for (int i=0; i<s.length(); i++) {
            char c = s.charAt(i);
            if (cur.childMap.containsKey(c) == false) {
                return new ArrayList();
            }
            cur = cur.childMap.get(c);
        }
        
        Queue<TrieNode> q = new ArrayDeque();
        q.add(cur);
        while (q.size() > 0) {
            TrieNode node = q.poll();
            if (node.isEnd) {
                ret.add(node.index);
            }
            for (char key : node.childMap.keySet()) {
                q.add(node.childMap.get(key));
            }
        }
        Collections.sort(ret);
        return ret;
    }
}

class Solution {
    public List<List<String>> suggestedProducts(String[] products, String searchWord) {
        Trie trie = new Trie();
        Arrays.sort(products); //This may slow program.
        for (int i=0; i<products.length; i++) {
            trie.add(products[i], i);
        }
        List<List<String>> ans = new ArrayList();
        // System.out.println(Arrays.toString(products));
        for (int i=1; i<=searchWord.length(); i++) {
            List<Integer> indexes = trie.find(searchWord.substring(0, i));
            // System.out.println(indexes);
            PriorityQueue<Integer> pq = new PriorityQueue();
            for (int index : indexes) {
                pq.add(index);
            }

            List<String> temp = new ArrayList();
            // System.out.println(pq);
            int siz = Math.min(3, pq.size());
            for (int j=0; j<siz; j++) {
                temp.add(products[pq.poll()]);
            }
            ans.add(temp);
        }
        return ans;
    }
}