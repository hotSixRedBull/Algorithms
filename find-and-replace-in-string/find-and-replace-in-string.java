class Tuple {
    int index;
    int originalLength;
    String target;
    
    public Tuple(int i, int o, String s) {
        index = i;
        originalLength = o;
        target = s;
    }
}

class Solution {
    public String findReplaceString(String s, int[] indices, String[] sources, String[] targets) {
        PriorityQueue<Tuple> pq = new PriorityQueue<>((item1, item2) -> item1.index - item2.index);
        
        for (int i=0; i<indices.length; i++) {
            int index = indices[i];
            String source = sources[i];
            String target = targets[i];
            if (index+source.length() <= s.length()
                && s.substring(index, index+source.length()).equals(source)) {
                pq.add(new Tuple(index, source.length(), target));
            }
        }
        
        int i=0;
        String result = "";
        while (pq.size() > 0) {
            Tuple cur = pq.poll();
            if (i < cur.index) {
                result += s.substring(i, cur.index);
                i = cur.index;
            }
            result += cur.target;
            i += cur.originalLength;
        }
        if (i < s.length()) {
            result += s.substring(i, s.length());
        }
        
        return result;
    }
}