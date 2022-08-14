// saw solution
class Solution {
    Map<String, List<String>> adjList = new HashMap<String, List<String>>();
    List<String> currPath = new ArrayList<String>();
    List<List<String>> shortestPaths = new ArrayList<List<String>>();
    
    private List<String> findNeighbors(String word, Set<String> wordList) {
        List<String> neighbors = new ArrayList<String>();
        char charList[] = word.toCharArray();
        
        for (int i = 0; i < word.length(); i++) {
            char oldChar = charList[i];   
            
            // replace the i-th character with all letters from a to z except the original character
            for (char c = 'a'; c <= 'z'; c++) {
                charList[i] = c;
                
                // skip if the character is same as original or if the word is not present in the wordList
                if (c == oldChar || !wordList.contains(String.valueOf(charList))) {
                    continue;
                }
                neighbors.add(String.valueOf(charList));
            }
            charList[i] = oldChar;
        }
        return neighbors;
    }
    
    private void backtrack(String source, String destination) {
        // store the path if we reached the endWord
        if (source.equals(destination)) {
            List<String> tempPath = new ArrayList<String>(currPath);
            Collections.reverse(tempPath);
            shortestPaths.add(tempPath);
        }
        
        if (!adjList.containsKey(source)) {
            return;
        }
        
        for (int i = 0; i < adjList.get(source).size(); i++) {
            currPath.add(adjList.get(source).get(i));
            backtrack(adjList.get(source).get(i), destination);
            currPath.remove(currPath.size() - 1);
        }
    }
    
    private void bfs(String beginWord, String endWord, Set<String> wordList) {
        Queue<String> q = new LinkedList<>();
        q.add(beginWord);
        
        // remove the root word which is the first layer in the BFS
        if (wordList.contains(beginWord)) {
            wordList.remove(beginWord);
        }
        
        Map<String, Integer> isEnqueued = new HashMap<String, Integer>();
        isEnqueued.put(beginWord, 1);
        
        while (q.size() > 0)  {
             // visited will store the words of current layer
            List<String> visited = new ArrayList<String>();
            
            for (int i = q.size() - 1; i >= 0; i--) {
                String currWord = q.peek(); 
                q.remove();

                // findNeighbors will have the adjacent words of the currWord
                List<String> neighbors = findNeighbors(currWord, wordList);
                for (String word : neighbors) {
                    visited.add(word);
                    
                    if (!adjList.containsKey(word)) {
                        adjList.put(word, new ArrayList<String>());
                    }
                    
                    // add the edge from word to currWord in the list
                    adjList.get(word).add(currWord);
                    if (!isEnqueued.containsKey(word)) {
                        q.add(word);
                        isEnqueued.put(word, 1);
                    }
                }
            }
             // removing the words of the previous layer
            for (int i = 0; i < visited.size(); i++) {
                if (wordList.contains(visited.get(i))) {
                    wordList.remove(visited.get(i));
                }
            }
        }
    }
    
    public List<List<String>> findLadders(String beginWord, String endWord, List<String> wordList) {
        // copying the words into the set for efficient deletion in BFS
        Set<String> copiedWordList = new HashSet<>(wordList);
        // build the DAG using BFS
        bfs(beginWord, endWord, copiedWordList);
        
        // every path will start from the endWord
        currPath.add(endWord);
        // traverse the DAG to find all the paths between endWord and beginWord
        backtrack(endWord, beginWord);
        
        return shortestPaths;
    }
}
/*
class Solution {
    public List<List<String>> findLadders(String beginWord, String endWord, List<String> wordList) {
        Set<Integer>[] adj = new HashSet[wordList.size()];
        for (int i=0; i<wordList.size(); i++) {
            adj[i] = new HashSet();
        }
        Queue<Integer> q = new ArrayDeque();
        Queue<List<String>> path = new ArrayDeque();
        Queue<Set<Integer>> visited = new ArrayDeque();
        int endWordIndex = -1;
        for (int i=0; i<wordList.size(); i++) {
            if (diff(wordList.get(i), beginWord) == 1) {
                q.add(i);
                List<String> newList = new ArrayList();
                newList.add(beginWord);
                newList.add(wordList.get(i));
                path.add(newList);
                Set<Integer> visit = new HashSet();
                visit.add(i);
                visited.add(visit);
            }
            if (wordList.get(i).equals(endWord)) {
                endWordIndex = i;
            }
            for (int j=i+1; j<wordList.size(); j++) {
                if (diff(wordList.get(i), wordList.get(j)) == 1) {
                    adj[i].add(j);
                    adj[j].add(i);
                }
            }
        }
        int min = Integer.MAX_VALUE;
        List<List<String>> answer = new ArrayList();
        
        if (endWordIndex == -1) {
            return answer;
        }
        
        while (q.size() > 0) {
            int cur = q.poll();
            List<String> p = path.poll();
            // System.out.println(p);
            Set<Integer> visit = visited.poll();
            if (cur == endWordIndex) {
                min = Math.min(min, p.size());
                if (p.size() <= min) {
                    answer.add(p);
                    continue;
                }
                else {
                    break;
                }
            }
            for (int next : adj[cur]) {
                if (visit.contains(next) == false) {
                    q.add(next);
                    List<String> newP = new ArrayList(p);
                    newP.add(wordList.get(next));
                    path.add(newP);
                    Set<Integer> newVisit = new HashSet(visit);
                    newVisit.add(next);
                    visited.add(newVisit);
                }
            }
        }
        
        return answer;
    }
    
    public int diff(String s1, String s2) {
        int ret = 0;
        for (int i=0; i<s1.length(); i++) {
            if (s1.charAt(i) != s2.charAt(i)) {
                ret++;
                if (ret > 1) {
                    return -1;
                }
            }
        }
        return ret;
    }
}
*/