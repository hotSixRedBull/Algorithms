class TrieNode {
    TrieNode[] childs;
    boolean isEnd;
    public TrieNode() {
        childs = new TrieNode[10];
        isEnd = false;
    }
}

class Trie {
    TrieNode root;
    public Trie() {
        root = new TrieNode();
    }
    
    public void put(int val) {
        String s = Integer.toString(val);
        TrieNode cur = root;
        for (int i=0; i<s.length(); i++) {
            if (cur.childs[s.charAt(i)-'0'] == null) {
                cur.childs[s.charAt(i)-'0'] = new TrieNode();
            }
            cur = cur.childs[s.charAt(i)-'0'];
        }
        cur.isEnd = true;
    }
    
    public String lcp(int val) {
        String result = "";
        String s = Integer.toString(val);
        TrieNode cur = root;
        for (int i=0; i<s.length(); i++) {
            if (cur.childs[s.charAt(i)-'0'] == null) {
                // System.out.println(String.format("next: %c, childs: %s", s.charAt(i), Arrays.toString(cur.childs)));
                break;
            }
            result += s.charAt(i);
            cur = cur.childs[s.charAt(i)-'0'];
        }
        // System.out.println(String.format("lcp(%d), longest: %s", val, result));
        return result;
    }
}

class Solution {
    public int longestCommonPrefix(int[] arr1, int[] arr2) {
        Trie trie = new Trie();
        for (int num : arr1) {
            trie.put(num);
        }
        
        int max = 0;
        for (int num : arr2) {
            max = Math.max(max, trie.lcp(num).length());
        }
        return max;
    }
}
/*
[32,33,35]
[10,12,32]
*/