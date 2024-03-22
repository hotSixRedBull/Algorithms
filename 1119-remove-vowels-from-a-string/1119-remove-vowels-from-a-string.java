class Solution {
    public String removeVowels(String s) {
        Set<Character> set = new HashSet(List.of('a','e','i','o','u'));
        StringBuilder sb = new StringBuilder();
        for (char c : s.toCharArray()) {
            if (set.contains(c)) {
                continue;
            }
            sb.append(c);
        }
        return sb.toString();
    }
}