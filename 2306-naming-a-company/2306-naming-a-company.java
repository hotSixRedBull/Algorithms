class Solution {
    public long distinctNames(String[] ideas) {
        HashSet<String> set = new HashSet();
        for (String idea : ideas) {
            set.add(idea);
        }
        HashMap<String, Set<Character>> availables = new HashMap();
        int[][] candidate = new int[26][26]; // firstletter, available
        
        for (String idea : ideas) {
            availables.put(idea, new HashSet());
            char ideaFirstLetter = idea.charAt(0);
            char[] arr = idea.toCharArray();
            for (char c1='a'; c1<='z'; c1++) {
                arr[0] = c1;
                String newString = new String(arr);
                if (set.contains(newString)) {
                    continue;
                }
                availables.get(idea).add(c1);
                candidate[ideaFirstLetter-'a'][c1-'a']++;
            }
        }
        // System.out.println(availables);
        
        
        long cnt = 0;
        for (String idea : ideas) {
            char ideaFirstLetter = idea.charAt(0);
            for (char c : availables.get(idea)) {
                cnt += candidate[c-'a'][ideaFirstLetter-'a'];
            }
        } 
        return cnt;
    }
}