class Solution {
    public int countCharacters(String[] words, String chars) {
        HashMap<Character, Integer> map = new HashMap<Character, Integer>();
        for (char c : chars.toCharArray()) {
            if (map.containsKey(c)) {
                map.put(c, map.get(c)+1);
            }
            else {
                map.put(c, 1);
            }
        }
        //System.out.println(map);
        
        //sort by length
        // Arrays.sort(words,  new Comparator<String>() {
        //     @Override
        //     public int compare(String s1, String s2) {
        //         return s1.length() - s2.length();
        //     }
        // });
        // System.out.println(Arrays.toString(words));
        
        int index = 0;
        int result = 0;
        for (String word : words) {
            if (isGood(word, map)) {
                //result = Math.max(result, recursiveSearch(words, index, map));
                result += word.length();
            }
            index++;
        }
        return result;
    }
    
    public int recursiveSearch(String[] words, int index, HashMap<Character, Integer> map) {
        System.out.println(String.format("%s is good.", words[index]));
        int initialResult = words[index].length();
        int result = 0;
        map = subtractWord(words[index], map);
        System.out.println(map);
        for (int i = index+1; i<words.length; i++) {
            if (isGood(words[i], map)) {
                result = Math.max(result, initialResult + recursiveSearch(words, i, map));
            }
        }
        return result;
    }
    
    public Boolean isGood(String word, HashMap<Character, Integer> map) {
        HashMap<Character, Integer> mapCloned = new HashMap<Character, Integer>(map);
        for (char c : word.toCharArray()) {
            if (!mapCloned.containsKey(c) || mapCloned.get(c) < 1) {
                return false;
            }
            else {
                mapCloned.put(c, mapCloned.get(c)-1);
            }
        }
        return true;
    }
    
    public HashMap<Character, Integer> subtractWord(String word, HashMap<Character, Integer> map) {
        for (char c : word.toCharArray()) {
            map.put(c, map.get(c)-1);
        }
        return map;
    }
}