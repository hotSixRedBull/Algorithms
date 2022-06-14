class TrieNode {
    public boolean isEnd;
    public String value;
    public int wordLeft;
    public HashMap<Character, TrieNode> childs;
    public TrieNode() {
        wordLeft = 0;
        isEnd = false;
        value = "";
        childs = new HashMap();
    }
}

class Trie {
    public TrieNode root;
    public Trie() {
        root = new TrieNode();
    }
    public void add(String s) {
        TrieNode cur = root;
        cur.wordLeft++;
        for (int i=0; i<s.length(); i++) {
            char c = s.charAt(i);
            if (!cur.childs.containsKey(c)) {
                cur.childs.put(c, new TrieNode());
            }
            cur = cur.childs.get(c);
            cur.wordLeft++;
        }
        cur.isEnd = true;
        cur.value = s;
    }
    
    public void remove(String s) {
        // System.out.println("remove "+s);
        TrieNode parent = null;
        TrieNode cur = root;
        cur.wordLeft--;
        if (cur.wordLeft == 0) {
            root.childs.clear();
        }
        for (int i=0; i<s.length(); i++) {
            char c = s.charAt(i);
            parent = cur;
            cur = cur.childs.get(c);
            if (cur == null) {
                break;
            }
            cur.wordLeft--;
            if (cur.wordLeft == 0) {
                // System.out.println(parent.childs);
                // System.out.println("found");
                TrieNode node = parent.childs.get(c);
                parent.childs.remove(c);
                // System.out.println(parent.childs);
                break;
            }
        }
    }
    
}

class Solution {
    public List<String> findWords(char[][] board, String[] words) {
        Trie trie = new Trie();
        for (String word : words) {
            trie.add(word);
        }
        
        int M = board.length;
        int N = board[0].length;
        int K = words.length;
        List<String> ans = new ArrayList();
        int[] dr = new int[]{-1,0,1,0};
        int[] dc = new int[]{0,1,0,-1};
        for (int r=0; r<M; r++) {
            for (int c=0; c<N; c++) {
                if (trie.root.childs.containsKey(board[r][c])) {
                    Stack<HashMap<Integer, Set<Integer>>> visitedQ = new Stack();
                    HashMap<Integer, Set<Integer>> visited = new HashMap();
                    visited.put(r, new HashSet());
                    visited.get(r).add(c);
                    visitedQ.add(visited);
                    Stack<int[]> q = new Stack();
                    Stack<TrieNode> tq = new Stack();
                    q.add(new int[]{r,c});
                    tq.add(trie.root.childs.get(board[r][c]));
                    while (q.size() > 0) {
                        int[] curPos = q.pop();
                        TrieNode curNode = tq.pop();
                        visited = visitedQ.pop();
                        // System.out.println(curNode.wordLeft);
                        if (curNode.wordLeft == 0) {
                            continue;
                        }
                        // System.out.println(Arrays.toString(curPos));
                        if (curNode.isEnd) {
                            curNode.isEnd = false;
                            ans.add(curNode.value);
                            trie.remove(curNode.value);
                        }
                        for (int i=0; i<4; i++) {
                            int nr = curPos[0]+dr[i];
                            int nc = curPos[1]+dc[i];
                            if (nr >= 0
                               && nc >= 0
                               && nr < M
                               && nc < N
                               && ((visited.containsKey(nr)
                               && visited.get(nr).contains(nc) == false)
                                  || visited.containsKey(nr) == false)
                               && curNode.childs.containsKey(board[nr][nc])) {
                                q.add(new int[]{nr,nc});
                                tq.add(curNode.childs.get(board[nr][nc]));
                                HashMap<Integer, Set<Integer>> newVisited = new HashMap();
                                for (int key : visited.keySet()) {
                                    newVisited.put(key, new HashSet(visited.get(key)));
                                }
                                if (newVisited.containsKey(nr) == false) {
                                    newVisited.put(nr, new HashSet());
                                }
                                newVisited.get(nr).add(nc);
                                visitedQ.add(newVisited);
                            }
                        }
                    }
                }
            }
        }
        return ans;
    }
}

/*
[["o","a","a","n"],["e","t","a","e"],["i","h","k","r"],["i","f","l","v"]]
["oath","pea","eat","rain"]
[["a","b"],["c","d"]]
["abcb"]
[["o","a","a","n"],["e","t","a","e"],["i","h","k","r"],["i","f","l","v"]]
["oath","pea","eat","rain","hklf", "hf"]
[["a","a"]]
["aaa"]
[["a","a"],["a","a"]]
["aaaaa"]
[["o","a","a","n"],["e","t","a","e"],["i","h","k","r"],["i","f","l","v"]]
["oath","pea","eat","rain","oathi","oathk","oathf","oate","oathii","oathfi","oathfii"]


[
["o","a","a","n"],
["e","t","a","e"],
["i","h","k","r"],
["i","f","l","v"]
]
*/