class Solution {
    public int[][] indexPairs(String text, String[] words) {
        HashMap<Integer, List<String>> lengthMap = new HashMap();
        for (String word : words) {
            if (lengthMap.containsKey(word.length()) == false) {
                lengthMap.put(word.length(), new ArrayList());
            }
            lengthMap.get(word.length()).add(word);
        }
        
        List<int[]> forSort = new ArrayList();
        for (int i=0; i<text.length(); i++) {
            for (int len : lengthMap.keySet()) {
                List<String> candidates = lengthMap.get(len);
                for (String candidate : candidates) {
                    if (i+len <= text.length() 
                        && text.substring(i, i+len).equals(candidate)) {
                        forSort.add(new int[]{i, i+len-1});
                    }
                }
            }
        }
        forSort.sort(new Comparator<int[]>() {
           @Override
            public int compare(int[] arg0, int[] arg1) {
                if (arg0[0] < arg1[0]) {
                    return -1;
                }
                else if (arg0[0] > arg1[0]) {
                    return 1;
                }
                else {
                    if (arg0[1] < arg1[1]) {
                        return -1;
                    }
                    else if (arg0[1] > arg1[1]) {
                        return 1;
                    }
                    return 0;
                }
            } 
        });
        int[][] ans = new int[forSort.size()][2];
        int index = 0;
        for (int[] elem : forSort) {
            ans[index++] = elem;
        }
        return ans;
    }
}