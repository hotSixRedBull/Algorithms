class Solution {
    public boolean checkIfPangram(String sentence) {
        HashMap<Character, Integer> map = new HashMap<>();
        for (char c : sentence.toCharArray()) {
            map.put(c, 1);
        }
        return map.size() == 26;
    }
}