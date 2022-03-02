class Solution {
    public int canBeTypedWords(String text, String brokenLetters) {
        Set<Character> broken = new HashSet();
        for (char c : brokenLetters.toCharArray()) {
            broken.add(c);
        }
        
        String[] str = text.split(" ");
        int cnt = 0;
        for (String s : str) {
            boolean canBeTyped = true;
            for (char c : s.toCharArray()) {
                if (broken.contains(c)) {
                    canBeTyped = false;
                    break;
                }
            }
            if (canBeTyped) {
                cnt++;
            }
        }
        return cnt;
    }
}