class Solution {
    public int maxLengthBetweenEqualCharacters(String s) {
        HashMap<Character, Integer> hashmap = new HashMap<>();
        int index = 0;
        int max = -1;
        for (char c : s.toCharArray()) {
            if (hashmap.containsKey(c)) {
                max = Math.max(max, index-hashmap.get(c)-1);
            }
            else {
                hashmap.put(c, index);
            }
            index++;
        }
        return max;
    }
}