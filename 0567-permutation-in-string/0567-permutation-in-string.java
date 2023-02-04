class Solution {
    public boolean checkInclusion(String s1, String s2) {
        char[] s1arr = s1.toCharArray();
        Arrays.sort(s1arr);
        String sortedS1 = new String(s1arr);
        for (int i=0; i<s2.length(); i++) {
            if (i+s1.length() > s2.length()) {
                break;
            }
            char[] s2substring = s2.substring(i, i+s1.length()).toCharArray();
            Arrays.sort(s2substring);
            String sortedS2 = new String(s2substring);
            if (sortedS1.equals(sortedS2)) {
                return true;
            } 
        }
        return false;
    }
}

/*
class Solution {
    public boolean checkInclusion(String s1, String s2) {
        HashMap<Character, Integer> s1map = new HashMap();
        for (int i=0; i<s1.length(); i++) {
            s1map.put(s1.charAt(i), s1map.getOrDefault(s1.charAt(i), 0)+1);
        }
        System.out.println(s1map);
        
        HashMap<Character, Integer> s2map = new HashMap();
        for (int i=0; i<s2.length(); i++) {
            if (s1map.containsKey(s2.charAt(i))) {
                // System.out.println(String.format("found at %d", i));
                boolean isSame = true;
                if (i+s1.length() > s2.length()) {
                    break;
                }
                for (int pos = 0; pos < s1.length(); pos++) {
                    if (s1map.containsKey(s2.charAt(i+pos)) == false) {
                        s2map.clear();
                        isSame = false;
                        i = i+pos;
                        break;
                    }
                    s2map.put(s2.charAt(i+pos), s2map.getOrDefault(s2.charAt(i+pos), 0)+1);
                }
                System.out.println(s2map);
                if (!isSame) {
                    break;
                }
                for (char c : s2map.keySet()) {
                    if (s1map.get(c) != s2map.get(c)) {
                        s2map.clear();
                        isSame = false;
                        break;
                    }
                }
                if (isSame) {
                    return true;
                }
            }
            else {
                s2map.clear();
            }
        }
        return false;
    }
}
*/

/*
"hello"
"ooolleoooleh"
*/